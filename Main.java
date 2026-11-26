
import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String args[])
    {
        JFrame frame = new JFrame("Movie Ticket Booking System");

        frame.setSize(900, 700);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(20, 20, 30));
        panel.setLayout(new GridBagLayout());

        // Heading
        JLabel title = new JLabel("MOVIE TICKET BOOKING");
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setForeground(Color.WHITE);

        // Welcome message
        JLabel welcome = new JLabel("Welcome to the World of Movies!");
        welcome.setFont(new Font("Arial", Font.PLAIN, 22));
        welcome.setForeground(Color.ORANGE);

        // Description
        JLabel description = new JLabel("Book your favourite movies and enjoy the show.");
        description.setFont(new Font("Arial", Font.PLAIN, 16));
        description.setForeground(Color.LIGHT_GRAY);

        // Browse Movies button
        JButton browse = new JButton("Browse Movies");
        browse.setFont(new Font("Arial", Font.BOLD, 18));
        browse.setBackground(Color.ORANGE);
        browse.setForeground(Color.BLACK);
        browse.setFocusPainted(false);
        browse.addActionListener(e -> new MovieSelection());
        // Booking History button
JButton history = new JButton("Booking History");
history.setFont(new Font("Arial", Font.BOLD, 18));
history.setBackground(Color.ORANGE);
history.setForeground(Color.BLACK);
history.setFocusPainted(false);
history.addActionListener(e -> new BookingHistory());

        // Layout arrangement
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridy = 0;
        panel.add(title, gbc);

        gbc.gridy = 1;
        panel.add(welcome, gbc);

        gbc.gridy = 2;
        panel.add(description, gbc);

        gbc.gridy = 3;
        panel.add(browse, gbc);
        gbc.gridy = 4;
panel.add(history, gbc);

        // Add panel to frame
        frame.add(panel);

        // Display window
        frame.setVisible(true);
    }
}


