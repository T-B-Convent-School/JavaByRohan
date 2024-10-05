import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {
    private final JLabel clockLabel;
    private final JLabel dateLabel;

    public DigitalClock() {
        setTitle("Digital Clock By Rohan Naagar");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Layout setup
        setLayout(new BorderLayout());

        clockLabel = new JLabel();
        clockLabel.setFont(new Font("Arial", Font.BOLD, 48));
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setForeground(Color.BLUE);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setForeground(Color.BLUE);

        add(clockLabel, BorderLayout.CENTER);
        add(dateLabel, BorderLayout.SOUTH);

        updateClock();

        Timer timer = new Timer(1000, _ -> updateClock());
        timer.start();
    }

    private void updateClock() {
        String currentTime = new SimpleDateFormat("hh:mm:ss a").format(new Date());
        String currentDate = new SimpleDateFormat("EEEE, MMMM d, yyyy").format(new Date());
        clockLabel.setText(currentTime);
        dateLabel.setText(currentDate);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock();
            clock.setVisible(true);
        });
    }
}
