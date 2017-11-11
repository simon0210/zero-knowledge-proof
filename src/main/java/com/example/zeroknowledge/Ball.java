package com.example.zeroknowledge;

import java.awt.Color;
import java.util.Objects;
import java.util.UUID;

/**
 * A Ball class to be used in our proof.
 */
public final class Ball implements Comparable {
    /**
     * The Color of the Ball.
     */
    private final Color color;

    /**
     * The UUID used to ID the Ball.
     */
    private final UUID id;

    /**
     * @constructor
     * @param ballColor The Color of the Ball.
     */
    public Ball(final Color ballColor) {
        this.color = ballColor;
        this.id = UUID.randomUUID();
    }

    /**
     * @return Color The color of the Ball
     */
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(final Object o) {
        if (null == o) {
            return false;
        }

        if (! (o instanceof Ball)) {
            return false;
        }

        Ball otherBall = (Ball) o;

        return this.id == otherBall.id;
    }

    @Override
    public int hashCode() {
        final int hash = 7;
        final int multiplier = 37;

       return multiplier * hash + Objects.hashCode(this.id);
    }

    @Override
    public int compareTo(final Object o) {
        final Ball otherBall = (Ball) o;
        return getColor().getRGB() - otherBall.getColor().getRGB();
    }
}
