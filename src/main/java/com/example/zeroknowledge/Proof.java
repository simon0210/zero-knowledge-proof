package com.example.zeroknowledge;

import java.awt.Color;
import java.util.Set;
import java.util.TreeSet;

/**
 * The main class.
 */
public final class Proof {
    /**
     * The Ball objects used for the proof.
     */
    private static final Set<Ball> BALLS = new TreeSet<>();

    /**
     * The number of iterations for the proof.
     */
    private static final int ITERATIONS = 100;

    /**
     * The probability of a random match.
     */
    private static double prob = 1.0;

    /**
     * @constructor
     */
    private Proof() {
    }

    /**
     * The main class.
     * @param args String[] The command-line arguments
     * @throws Exception When the proof fails.
     */
    public static void main(final String[] args) throws Exception {
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
            // make sure they still don't know about the ball
            if (!you.getBallColor(rBall).equals(Color.GRAY)) {
                throw new Exception("not zero knowledge");
            }

            // show me the ball and see if I am right
            // we both need to know if it was switched
            if (me.wasSwitched(rBall) == you.wasSwitched(rBall)) {
                prob = prob * 1 / BALLS.size();

                System.out.println(
                    "Probability of being randomly correct: " + prob
                );
            } else {
                throw new Exception("one of us was incorrect");
            }
        }
    }
}
