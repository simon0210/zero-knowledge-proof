package ZeroKnowledge;

import java.awt.Color;
import java.util.Set;
import java.util.TreeSet;

public class Proof {
    private static final Set<Ball> BALLS = new TreeSet<>();
    private static final int ITERATIONS = 100;
    private static double prob = 1.0;
    
    public static void main(String[] args) throws Exception {
        BALLS.add(new Ball(Color.BLACK));
        BALLS.add(new Ball(Color.RED));
        BALLS.add(new Ball(Color.BLUE));
        BALLS.add(new Ball(Color.GREEN));
        BALLS.add(new Ball(Color.GRAY));
        
        final Person me = new Person();
        final ColorBlindPerson you = new ColorBlindPerson();
        
        for (int i = 0; i < ITERATIONS; i++) {
            // you pick a random ball
            final Ball rBall = you.pickBall(BALLS);
            if (!you.getBallColor(rBall).equals(Color.GRAY)) { // make sure they still don't know about the ball
                throw new Exception("not zero knowledge");
            }

            // show me the ball and see if I am right
            if (me.wasSwitched(rBall) == you.wasSwitched(rBall)) { // we both need to know if it was switched
                prob = prob * 1 / BALLS.size();
            
                System.out.println("Probability of being randomly correct: " + prob);
            }
            else {
                throw new Exception("one of us was incorrect");
            }
        }
    }
}
