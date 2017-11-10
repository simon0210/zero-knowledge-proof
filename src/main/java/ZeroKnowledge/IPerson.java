package ZeroKnowledge;

import java.awt.Color;

public interface IPerson {
    /**
     * @param ball
     * @return Color The color of the ball as seen by this person.
     */
    public Color getBallColor(final Ball ball);
    
    /**
     * @param ball
     * @return boolean If the ball was switched since last checked. 
     */
    public boolean wasSwitched(final Ball ball);
}