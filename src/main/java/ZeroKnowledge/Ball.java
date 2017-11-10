package ZeroKnowledge;

import java.awt.Color;
import java.util.Objects;
import java.util.UUID;

public class Ball {
    private final Color color;
    private final UUID id;
    
    public Ball(Color color) {
        this.color = color;
        this.id = UUID.randomUUID();
    }
    
    /**
     * @return Color The color of the Ball
     */
    public final Color getColor() {
        return this.color;
    }

    @Override
    public boolean equals(final Object o) {
        if (null == o) {
            return false;
        }
        
        Ball otherBall = (Ball) o;
        
        return this.id == otherBall.id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }
}