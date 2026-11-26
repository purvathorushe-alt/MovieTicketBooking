
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BookingHistory extends JFrame
{
    JPanel bookingPanel;

    public BookingHistory()
    {
        setTitle("Booking History");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(20, 20, 30));
        mainPanel.setLayout(new BorderLayout());

        JLabel heading = new JLabel(
            "YOUR BOOKING HISTORY", JLabel.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        heading.setBorder(
            BorderFactory.createEmptyBorder(20, 10, 20, 10)
        );

        mainPanel.add(heading, BorderLayout.NORTH);

        bookingPanel = new JPanel();
        bookingPanel.setBackground(new Color(20, 20, 30));
        bookingPanel.setLayout(new BoxLayout(
            bookingPanel, BoxLayout.Y_AXIS
        ));

        JScrollPane scrollPane = new JScrollPane(bookingPanel);
        scrollPane.setBorder(null);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        refreshBookings();

        add(mainPanel);
        setVisible(true);
    }

    public void refreshBookings()
    {
        bookingPanel.removeAll();

        if(BookingData.bookings.isEmpty())
        {
            JLabel message = new JLabel(
                "No bookings available yet."
            );

            message.setFont(new Font("Arial", Font.PLAIN, 18));
            message.setForeground(Color.LIGHT_GRAY);
            message.setAlignmentX(Component.CENTER_ALIGNMENT);

            bookingPanel.add(message);
        }
        else
        {
            for(int i = 0; i < BookingData.bookings.size(); i++)
            {
                final int bookingIndex = i;

                JPanel rowPanel = new JPanel(new BorderLayout());
                rowPanel.setBackground(new Color(20, 20, 30));
                rowPanel.setBorder(
                    BorderFactory.createLineBorder(Color.ORANGE)
                );

                JLabel details = new JLabel(
                    BookingData.bookings.get(i)
                );

                details.setForeground(Color.WHITE);
                details.setFont(new Font("Arial", Font.PLAIN, 15));
                details.setBorder(
                    BorderFactory.createEmptyBorder(15, 10, 15, 10)
                );

                JButton cancelButton = new JButton("Cancel");
                cancelButton.setBackground(Color.RED);
                cancelButton.setForeground(Color.WHITE);
                cancelButton.setFocusPainted(false);

                cancelButton.addActionListener(e ->
                {
                    int choice = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to cancel this booking?",
                        "Cancel Booking",
                        JOptionPane.YES_NO_OPTION
                    );

                    if(choice == JOptionPane.YES_OPTION)
                    {
                        ArrayList<String> seats =
                            BookingData.bookedSeats.get(bookingIndex);

                        String bookingKey =
                            BookingData.bookingKeys.get(bookingIndex);

                        if(SeatSelection.bookedByMovie.containsKey(bookingKey))
                        {
                            SeatSelection.bookedByMovie.get(bookingKey)
                                .removeAll(seats);
                        }

                        BookingData.cancelBooking(bookingIndex);

                        refreshBookings();
                    }
                });

                JPanel buttonPanel = new JPanel();
                buttonPanel.setBackground(new Color(20, 20, 30));
                buttonPanel.add(cancelButton);

                rowPanel.add(details, BorderLayout.CENTER);
                rowPanel.add(buttonPanel, BorderLayout.EAST);

                rowPanel.setMaximumSize(
                    new Dimension(800, 100)
                );

                rowPanel.setPreferredSize(
                    new Dimension(800, 100)
                );

                bookingPanel.add(rowPanel);
                bookingPanel.add(Box.createVerticalStrut(15));
            }
        }

        bookingPanel.revalidate();
        bookingPanel.repaint();
    }
}


