package com.example.zeroknowledge;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * A Person that cannot see Color.
 */
public final class ColorBlindPerson implements IPerson {
    /**
     * Used for randomness.
     */
    private final Random random = new Random();

    /**
     * The Ball that was seen before the currentBall.
     */
    private Ball lastSeenBall;

    /**
     * The current Ball.
     */
    private Ball currentBall;

    /**
     * @param balls The Set of balls used to choose a Ball.
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
    // ball should be the same as currentBall
    public boolean wasSwitched(final Ball ball) {
        return !currentBall.equals(lastSeenBall);
    }
}
