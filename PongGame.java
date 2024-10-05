import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PongGame extends JPanel implements ActionListener, KeyListener {
    private int ballX = 150;
    private int ballY = 100;
    private int ballXDir = 2;
    private int ballYDir = 2;
    private final int ballSize = 20;
    private int paddleX = 150;
    private final int paddleY = 350;
    private final int paddleWidth = 100;
    private final int paddleHeight = 10;

    public PongGame() {
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);
        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Ball
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, ballSize, ballSize);

        // Draw Paddle
        g.setColor(Color.WHITE);
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Ball Movement
        ballX += ballXDir;
        ballY += ballYDir;

        // Bounce off walls
        if (ballX <= 0 || ballX >= getWidth() - ballSize) {
            ballXDir = -ballXDir;
        }

        if (ballY <= 0) {
            ballYDir = -ballYDir;
        }

        // Bounce off paddle
        if (new Rectangle(ballX, ballY, ballSize, ballSize)
                .intersects(new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight))) {
            ballYDir = -ballYDir;
        }

        // Game over if the ball touches the bottom
        if (ballY >= getHeight()) {
            ballX = 150;
            ballY = 100;
            ballXDir = 2;
            ballYDir = 2;
            JOptionPane.showMessageDialog(this, "Game Over!", "Pong", JOptionPane.INFORMATION_MESSAGE);
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int paddleSpeed = 20;
        if (e.getKeyCode() == KeyEvent.VK_LEFT && paddleX > 0) {
            paddleX -= paddleSpeed;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddleX < getWidth() - paddleWidth) {
            paddleX += paddleSpeed;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game By Rohan Naagar");
        PongGame pongGame = new PongGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(pongGame);
        frame.setVisible(true);
    }
}
