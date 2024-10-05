import java.awt.Rectangle;

public class Paddle {
    private int x;
    private final int y;
    private final int width;
    private final int height;
    private final int dx = 10;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 10;
    }

    public void moveLeft() {
        if (x > 0) x -= dx;
    }

    public void moveRight() {
        if (x < 340) x += dx;
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
