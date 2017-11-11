package com.example.zeroknowledge;

import java.awt.Color;

/**
 * An Interface for people.
 */
public interface IPerson {
    /**
     * @param ball The Ball that has a Color that needs to be identified.
     * @return Color The color of the ball as seen by this person.
     */
    Color getBallColor(Ball ball);

    /**
     * @param ball The Ball used to see if it was switched.
     * @return boolean If the ball was switched since last checked.
     */
    boolean wasSwitched(Ball ball);
}
