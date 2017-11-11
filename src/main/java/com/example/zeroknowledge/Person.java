package com.example.zeroknowledge;

import java.awt.Color;

/**
 * A Person that can see Color.
 */
public final class Person implements IPerson {
    /**
     * The last Ball seen by the Person.
     */
    private Ball lastSeenBall;

    @Override
    public Color getBallColor(final Ball ball) {
        return ball.getColor();
    }

    @Override
    public boolean wasSwitched(final Ball ball) {
        boolean res = !ball.equals(lastSeenBall);
        lastSeenBall = ball; // compare this one next time

        return res;
    }
}
