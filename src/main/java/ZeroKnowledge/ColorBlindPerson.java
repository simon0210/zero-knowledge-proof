package ZeroKnowledge;

import java.awt.Color;
import java.util.List;
import java.util.Random;

public final class ColorBlindPerson implements IPerson {
    private final Random random = new Random();
    private Ball lastSeenBall;
    private Ball currentBall;
    
    /**
     * @param balls
     * @return Ball A randomly selected ball.
     */
    public final Ball pickBall(final List<Ball> balls) {
        lastSeenBall = currentBall;
        currentBall = balls.get(random.nextInt(balls.size()));
        return currentBall;
    }
    
    @Override
    public final Color getBallColor(final Ball ball) {
        return Color.GRAY;
    }

    @Override
    public boolean wasSwitched(Ball ball) { // ball should be the same as currentBall
        return !currentBall.equals(lastSeenBall);
    }
}