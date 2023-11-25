import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class MyWindow extends JFrame implements Runnable {

    private JLabel timeLabel;
    private Thread thread;

    public MyWindow() {

        JFrame frame = new JFrame();
        frame.setTitle("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.orange);

        frame.setLocation(700, 400);



        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(timeLabel, BorderLayout.CENTER);


        frame.setVisible(true);

        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            while (true) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int minutes = calendar.get(Calendar.MINUTE);
                int seconds = calendar.get(Calendar.SECOND);

                String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                timeLabel.setText(timeString);

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}
