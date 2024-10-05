import java.awt.Rectangle;

public class Ball {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private final int width;
    private final int height;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 1;
        this.dy = -1;
        this.width = 10;
        this.height = 10;
    }

    public void move() {
        x += dx;
        y += dy;

        if (x < 0 || x > 390) dx = -dx; // Left and Right Walls
        if (y < 0) dy = -dy; // Top Wall
    }

    public void reverseY() {
        dy = -dy;
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

