import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Digitalclock extends JFrame {

    private JLabel timeLabel;

    public Digitalclock() {
        setTitle("Digital Clock");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a label to display the time
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 48));

        // Add the time label to the frame
        add(timeLabel, BorderLayout.CENTER);

        // Set up a timer to update the clock every second
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();
    }

    private void updateClock() {
        // Get the current time
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String timeStr = sdf.format(now);

        // Update the label text
        timeLabel.setText(timeStr);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Digitalclock clock = new Digitalclock();
            clock.setVisible(true);
        });
    }
}
