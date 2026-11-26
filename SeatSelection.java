
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeatSelection extends JFrame
{
    ArrayList<String> selectedSeats = new ArrayList<>();

    static Map<String, Set<String>> bookedByMovie = new HashMap<>();

    JLabel totalLabel;
    int price;
    String showTiming;
    String showDate;

    public static String getBookingKey(
        String movieName,
        String showDate,
        String showTiming)
    {
        return movieName + "|" + showDate + "|" + showTiming;
    }

    public SeatSelection(
        String movieName,
        String showTiming,
        String showDate)
    {
        this.showTiming = showTiming;
        this.showDate = showDate;

        price = MovieDetails.getPrice(movieName);

        String bookingKey = getBookingKey(
            movieName, showDate, showTiming
        );

        setTitle("Seat Selection");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        if(!bookedByMovie.containsKey(bookingKey))
        {
            Set<String> seats = new HashSet<>();

            if(movieName.equals("INTERSTELLAR"))
                seats.addAll(java.util.Arrays.asList(
                    "A2", "A3", "A6", "B1", "B5", "B7",
                    "C3", "C6", "D2", "D4", "E5", "E8"
                ));

            else if(movieName.equals("INCEPTION"))
                seats.addAll(java.util.Arrays.asList(
                    "A1", "A4", "A7", "B2", "B5", "C1",
                    "C4", "C7", "D3", "D6", "E2", "E6"
                ));

            else if(movieName.equals("AVENGERS: ENDGAME"))
                seats.addAll(java.util.Arrays.asList(
                    "A3", "A5", "B2", "B3", "B6", "C4",
                    "C8", "D1", "D5", "D7", "E3", "E6"
                ));

            else if(movieName.equals("SPIDER-MAN"))
                seats.addAll(java.util.Arrays.asList(
                    "A1", "A5", "A8", "B3", "B6", "C2",
                    "C5", "D1", "D4", "D8", "E3", "E7"
                ));

            else if(movieName.equals("JOKER"))
                seats.addAll(java.util.Arrays.asList(
                    "A2", "A6", "B1", "B4", "B6", "C3",
                    "C7", "D2", "D4", "D6", "E1", "E5"
                ));

            else
                seats.addAll(java.util.Arrays.asList(
                    "A4", "A7", "B2", "B5", "C1", "C5",
                    "C8", "D3", "D6", "E2", "E4", "E7"
                ));

            bookedByMovie.put(bookingKey, seats);
        }

        // Load previously saved bookings for this exact show
        for(int i = 0; i < BookingData.bookings.size(); i++)
        {
            String booking = BookingData.bookings.get(i);

            String savedMovie = "";
            String savedTiming = "";
            String savedDate = "";

            String[] parts = booking.split("\\|");

            for(String part : parts)
            {
                part = part.trim();

                if(part.startsWith("Movie:"))
                    savedMovie = part.replace("Movie:", "").trim();

                else if(part.startsWith("Show:"))
                    savedTiming = part.replace("Show:", "").trim();

                else if(part.startsWith("Date:"))
                    savedDate = part.replace("Date:", "").trim();
            }

            if(savedMovie.equals(movieName)
                && savedTiming.equals(showTiming)
                && savedDate.equals(showDate))
            {
                bookedByMovie.get(bookingKey).addAll(
                    BookingData.bookedSeats.get(i)
                );
            }
        }

        System.out.println(
            "Seats loaded for " + bookingKey + ": " +
            bookedByMovie.get(bookingKey)
        );

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(20, 20, 30));
        mainPanel.setLayout(new BorderLayout(10, 10));

        JLabel heading = new JLabel(
            "SELECT YOUR SEATS", JLabel.CENTER
        );
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);

        JLabel movieLabel = new JLabel(
            "Movie: " + movieName +
            " | Date: " + showDate +
            " | Show: " + showTiming,
            JLabel.CENTER
        );

        movieLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        movieLabel.setForeground(Color.ORANGE);

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setBackground(new Color(20, 20, 30));
        topPanel.add(heading);
        topPanel.add(movieLabel);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel seatPanel = new JPanel();
        seatPanel.setBackground(new Color(20, 20, 30));
        seatPanel.setLayout(new GridLayout(5, 8, 12, 12));
        seatPanel.setBorder(
            BorderFactory.createEmptyBorder(30, 50, 20, 50)
        );

        for(int i = 0; i < 5; i++)
        {
            for(int j = 1; j <= 8; j++)
            {
                String seatName =
                    (char)('A' + i) + String.valueOf(j);

                JButton seatButton = new JButton(seatName);
                seatButton.setFont(
                    new Font("Arial", Font.BOLD, 14)
                );

                if(bookedByMovie.get(bookingKey).contains(seatName))
                {
                    seatButton.setBackground(Color.GRAY);
                    seatButton.setEnabled(false);
                }
                else
                {
                    seatButton.setBackground(Color.GREEN);

                    seatButton.addActionListener(e ->
                    {
                        if(selectedSeats.contains(seatName))
                        {
                            selectedSeats.remove(seatName);
                            seatButton.setBackground(Color.GREEN);
                        }
                        else
                        {
                            selectedSeats.add(seatName);
                            seatButton.setBackground(Color.ORANGE);
                        }

                        totalLabel.setText(
                            "Total Amount: Rs. " +
                            (selectedSeats.size() * price)
                        );
                    });
                }

                seatPanel.add(seatButton);
            }
        }

        mainPanel.add(seatPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(20, 20, 30));
        bottomPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel legend = new JLabel(
            "Green: Available     Orange: Selected     Grey: Booked",
            JLabel.CENTER
        );
        legend.setForeground(Color.WHITE);
        legend.setFont(new Font("Arial", Font.PLAIN, 15));

        totalLabel = new JLabel(
            "Total Amount: Rs. 0", JLabel.CENTER
        );
        totalLabel.setForeground(Color.ORANGE);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton confirmButton = new JButton("Confirm Booking");
        confirmButton.setBackground(Color.ORANGE);
        confirmButton.setForeground(Color.BLACK);
        confirmButton.setFont(
            new Font("Arial", Font.BOLD, 16)
        );

        confirmButton.addActionListener(e ->
        {
            if(selectedSeats.isEmpty())
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Please select at least one seat."
                );
            }
            else
            {
                int total = selectedSeats.size() * price;

                new Payment(
                    movieName,
                    new ArrayList<>(selectedSeats),
                    total,
                    showTiming,
                    showDate
                );

                dispose();
            }
        });

        bottomPanel.add(legend);
        bottomPanel.add(totalLabel);
        bottomPanel.add(confirmButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}

