package ZeroKnowledge;

import java.awt.Color;

public final class Person implements IPerson {
    private Ball lastSeenBall;
    
    @Override
    public Color getBallColor(final Ball ball) {
        return ball.getColor();
    }

    @Override
    public boolean wasSwitched(Ball ball) {
        boolean res = !ball.equals(lastSeenBall);
        lastSeenBall = ball; // compare this one next time
        
        return res;
    }
}