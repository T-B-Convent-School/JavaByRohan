import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class game extends JPanel implements ActionListener {
    private final Timer timer;
    private final Ball ball;
    private final Paddle paddle;
    private final Brick[] bricks;

    public game() {
        ball = new Ball(200, 300);
        paddle = new Paddle(170, 350);
        bricks = new Brick[30];

        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                bricks[k] = new Brick(50 + j * 52, 50 + i * 22);
                k++;
            }
        }

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    paddle.moveLeft();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    paddle.moveRight();
                }
            }
        });

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw ball
        g.fillRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());

        // Draw paddle
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());

        // Draw bricks
        for (Brick brick : bricks) {
            if (brick.isDestroyed()) {
                g.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
        checkCollision();
        repaint();
    }

    private void checkCollision() {
        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.reverseY();
        }

        for (Brick brick : bricks) {
            if (brick.isDestroyed() && ball.getBounds().intersects(brick.getBounds())) {
                ball.reverseY();
                brick.setDestroyed(true);
            }
        }

        if (ball.getY() > 400) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout By Rohan Naagar");
        game game = new game();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
