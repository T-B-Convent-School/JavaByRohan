import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class FlappyBird implements ActionListener, KeyListener {

    private final int WIDTH = 800, HEIGHT = 600;
    private final JPanel gamePanel;
    private int ticks, yMotion, score;
    private final ArrayList<Rectangle> pipes;
    private boolean gameOver, started;

    private Rectangle bird;

    public FlappyBird() {
        JFrame frame = new JFrame();
        gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setTitle("Flappy Bird - Java Edition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.addKeyListener(this);
        frame.setVisible(true);

        bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
        pipes = new ArrayList<>();

        addPipe(true);
        addPipe(true);

        Timer timer = new Timer(20, this);
        timer.start();
    }

    private void addPipe(boolean start) {
        int space = 250;
        int pipeWidth = 100;
        int pipeHeight = 50 + (int) (Math.random() * 300);

        if (start) {
            pipes.add(new Rectangle(WIDTH + pipeWidth + pipes.size() * 300, HEIGHT - pipeHeight - 120, pipeWidth, pipeHeight));
            pipes.add(new Rectangle(WIDTH + pipeWidth + (pipes.size() - 1) * 300, 0, pipeWidth, HEIGHT - pipeHeight - space));
        } else {
            pipes.add(new Rectangle(pipes.getLast().x + 600, HEIGHT - pipeHeight - 120, pipeWidth, pipeHeight));
            pipes.add(new Rectangle(pipes.getLast().x, 0, pipeWidth, HEIGHT - pipeHeight - space));
        }
    }

    private void jump() {
        if (gameOver) {
            bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
            pipes.clear();
            yMotion = 0;
            score = 0;

            addPipe(true);
            addPipe(true);

            gameOver = false;
        }

        if (!started) {
            started = true;
        }

        if (yMotion > 0) {
            yMotion = 0;
        }
        yMotion -= 10;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int speed = 8;

        ticks++;

        if (started) {
            for (Rectangle pipe : pipes) {
                pipe.x -= speed;
            }

            if (ticks % 2 == 0 && yMotion < 15) {
                yMotion += 2;
            }

            for (int i = 0; i < pipes.size(); i++) {
                Rectangle pipe = pipes.get(i);

                if (pipe.x + pipe.width < 0) {
                    pipes.remove(pipe);

                    if (pipe.y == 0) {
                        addPipe(false);
                    }
                }
            }

            bird.y += yMotion;

            for (Rectangle pipe : pipes) {
                if (pipe.intersects(bird)) {
                    gameOver = true;
                    bird.x = pipe.x - bird.width;
                }
            }

            if (bird.y > HEIGHT - 120 || bird.y < 0) {
                gameOver = true;
            }

            if (bird.y + yMotion >= HEIGHT - 120) {
                bird.y = HEIGHT - 120 - bird.height;
            }

            if (!gameOver) {
                for (Rectangle pipe : pipes) {
                    if (pipe.x + pipe.width < bird.x && !pipe.intersects(bird)) {
                        score++;
                    }
                }
            }
        }

        gamePanel.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public class GamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            g.setColor(Color.orange);
            g.fillRect(0, HEIGHT - 120, WIDTH, 120);

            g.setColor(Color.black);
            g.fillRect(0, HEIGHT - 120, WIDTH, 20);

            g.setColor(Color.yellow);
            g.fillRect(bird.x, bird.y, bird.width, bird.height);

            for (Rectangle pipe : pipes) {
                paintPipe(g, pipe);
            }

            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 100));

            if (!started) {
                g.drawString("Press SPACE to Start", 75, HEIGHT / 2 - 50);
            }

            if (gameOver) {
                g.drawString("BETTER LUCK NEXT TIME", 200, HEIGHT / 2 - 50);
            }

            if (!gameOver && started) {
                g.setFont(new Font("Arial", Font.PLAIN, 50));
                g.drawString(String.valueOf(score), -25, 100);
            }
        }

        private void paintPipe(Graphics g, Rectangle pipe) {
            g.setColor(Color.black.darker());
            g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
        }
    }

    public static void main(String[] args) {
        new FlappyBird();
    }
}
