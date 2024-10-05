import java.awt.Rectangle;

public class Brick {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private boolean destroyed;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 20;
        this.destroyed = false;
    }

    public boolean isDestroyed() {
        return !destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
