package ZeroKnowledge;

import java.awt.Color;

public interface IPerson {
    /**
     * @param ball
     * @return Color The color of the ball as seen by this person.
     */
    Color getBallColor(final Ball ball);
    
    /**
     * @param ball
     * @return boolean If the ball was switched since last checked. 
     */
    boolean wasSwitched(final Ball ball);
}