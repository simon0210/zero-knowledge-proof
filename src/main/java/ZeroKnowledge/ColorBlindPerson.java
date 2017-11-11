package ZeroKnowledge;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class ColorBlindPerson implements IPerson {
    private final Random random = new Random();
    private Ball lastSeenBall;
    private Ball currentBall;
    
    /**
     * @param balls
     * @return Ball A randomly selected ball.
     */
    public Ball pickBall(final Set<Ball> balls) {
        lastSeenBall = currentBall;
        List<Ball> ballList = new ArrayList(balls);
        currentBall = ballList.get(random.nextInt(ballList.size()));
        return currentBall;
    }
    
    @Override
    public Color getBallColor(final Ball ball) {
        return Color.GRAY;
    }

    @Override
    public boolean wasSwitched(Ball ball) { // ball should be the same as currentBall
        return !currentBall.equals(lastSeenBall);
    }
}