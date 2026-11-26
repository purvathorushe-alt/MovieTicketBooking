
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Payment extends JFrame
{
    String movieName;
    ArrayList<String> seats;
    int total;
    String showTiming;
    String showDate;

    int snackTotal = 0;
    String selectedSnackDetails = "None";

    JLabel amount;
    JLabel snackSummary;

    String[] snackNames = {
        "Popcorn",
        "Caramel Popcorn",
        "Nachos",
        "French Fries",
        "Hot Dog",
        "Pizza",
        "Veg Burger",
        "Sandwich",
        "Brownie",
        "Ice Cream",
        "Cold Drink",
        "Orange Juice"
    };

    int[] snackPrices = {
        120, 150, 150, 110, 130, 180,
        140, 120, 100, 90, 80, 100
    };

    public Payment(
        String movieName,
        ArrayList<String> seats,
        int total,
        String showTiming,
        String showDate)
    {
        this.movieName = movieName;
        this.seats = seats;
        this.total = total;
        this.showTiming = showTiming;
        this.showDate = showDate;

        setTitle("Payment");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(20, 20, 30));
        mainPanel.setLayout(new GridLayout(13, 1, 8, 8));

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 30, 15, 30)
        );

        JLabel heading = new JLabel(
            "PAYMENT DETAILS", JLabel.CENTER
        );
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);

        JLabel movie = new JLabel(
            "Movie: " + movieName, JLabel.CENTER
        );
        movie.setFont(new Font("Arial", Font.PLAIN, 18));
        movie.setForeground(Color.WHITE);

        JLabel date = new JLabel(
            "Movie Date: " + showDate, JLabel.CENTER
        );
        date.setFont(new Font("Arial", Font.PLAIN, 18));
        date.setForeground(Color.ORANGE);

        JLabel timing = new JLabel(
            "Show Timing: " + showTiming, JLabel.CENTER
        );
        timing.setFont(new Font("Arial", Font.PLAIN, 18));
        timing.setForeground(Color.ORANGE);

        JLabel seat = new JLabel(
            "Selected Seats: " + String.join(", ", seats),
            JLabel.CENTER
        );
        seat.setFont(new Font("Arial", Font.PLAIN, 17));
        seat.setForeground(Color.WHITE);

        int ticketPrice = MovieDetails.getPrice(movieName);

        JLabel price = new JLabel(
            "Price per Ticket: Rs. " + ticketPrice,
            JLabel.CENTER
        );
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Arial", Font.PLAIN, 18));

        amount = new JLabel(
            "Total Amount: Rs. " + total,
            JLabel.CENTER
        );
        amount.setFont(new Font("Arial", Font.BOLD, 24));
        amount.setForeground(Color.ORANGE);

        // Choose Snacks button
        JButton snacksButton = new JButton("Choose Snacks");
        snacksButton.setBackground(Color.ORANGE);
        snacksButton.setFont(
            new Font("Arial", Font.BOLD, 17)
        );

        snackSummary = new JLabel(
            "Snacks: None | Snack Amount: Rs. 0",
            JLabel.CENTER
        );
        snackSummary.setForeground(Color.WHITE);
        snackSummary.setFont(
            new Font("Arial", Font.PLAIN, 15)
        );

        snacksButton.addActionListener(e -> selectSnacks());

        JLabel paymentLabel = new JLabel(
            "Choose Payment Method:", JLabel.CENTER
        );
        paymentLabel.setForeground(Color.WHITE);
        paymentLabel.setFont(
            new Font("Arial", Font.BOLD, 17)
        );

        String[] methods = {
            "UPI",
            "Credit Card",
            "Debit Card",
            "Cash at Counter"
        };

        JComboBox<String> paymentMethod =
            new JComboBox<>(methods);

        paymentMethod.setFont(
            new Font("Arial", Font.PLAIN, 16)
        );

        JButton payButton = new JButton("Continue to Payment");
        payButton.setBackground(Color.ORANGE);
        payButton.setForeground(Color.BLACK);
        payButton.setFont(
            new Font("Arial", Font.BOLD, 18)
        );

        payButton.addActionListener(e ->
        {
            String method =
                (String) paymentMethod.getSelectedItem();

            int finalAmount = total + snackTotal;

            int choice = JOptionPane.NO_OPTION;

            // UPI PAYMENT
            if(method.equals("UPI"))
            {
                JPanel upiPanel = new JPanel();

                upiPanel.setLayout(
                    new BoxLayout(upiPanel, BoxLayout.Y_AXIS)
                );

                JLabel title = new JLabel("SCAN DEMO QR CODE");
                title.setFont(
                    new Font("Arial", Font.BOLD, 18)
                );
                title.setAlignmentX(Component.CENTER_ALIGNMENT);

                ImageIcon qrIcon = new ImageIcon("image.png");

                if(qrIcon.getIconWidth() > 0)
                {
                    Image qrImage = qrIcon.getImage()
                        .getScaledInstance(
                            220, 220, Image.SCALE_SMOOTH
                        );

                    JLabel qrLabel = new JLabel(
                        new ImageIcon(qrImage)
                    );

                    qrLabel.setAlignmentX(
                        Component.CENTER_ALIGNMENT
                    );

                    upiPanel.add(qrLabel);
                }
                else
                {
                    JLabel error = new JLabel(
                        "QR image not found!"
                    );

                    error.setForeground(Color.RED);
                    error.setAlignmentX(
                        Component.CENTER_ALIGNMENT
                    );

                    upiPanel.add(error);
                }

                JLabel upiId = new JLabel(
                    "Demo UPI ID: movieticket@demo"
                );
                upiId.setAlignmentX(
                    Component.CENTER_ALIGNMENT
                );

                JLabel amountLabel = new JLabel(
                    "Amount: Rs. " + finalAmount
                );
                amountLabel.setFont(
                    new Font("Arial", Font.BOLD, 18)
                );
                amountLabel.setAlignmentX(
                    Component.CENTER_ALIGNMENT
                );

                JLabel warning = new JLabel(
                    "DEMO ONLY - NO REAL PAYMENT"
                );
                warning.setForeground(Color.RED);
                warning.setAlignmentX(
                    Component.CENTER_ALIGNMENT
                );

                upiPanel.add(title);
                upiPanel.add(upiId);
                upiPanel.add(amountLabel);
                upiPanel.add(warning);

                choice = JOptionPane.showConfirmDialog(
                    this,
                    upiPanel,
                    "UPI Demo Payment",
                    JOptionPane.YES_NO_OPTION
                );
            }

            // CREDIT CARD PAYMENT
            else if(method.equals("Credit Card"))
            {
                JPanel cardPanel = new JPanel(
                    new GridLayout(3, 1, 5, 5)
                );

                cardPanel.add(
                    new JLabel("Credit Card Demo Payment")
                );

                cardPanel.add(
                    new JLabel("Demo Card: XXXX XXXX XXXX 1234")
                );

                cardPanel.add(
                    new JLabel("Amount: Rs. " + finalAmount)
                );

                choice = JOptionPane.showConfirmDialog(
                    this,
                    cardPanel,
                    "Credit Card Payment",
                    JOptionPane.YES_NO_OPTION
                );
            }

            // DEBIT CARD PAYMENT
            else if(method.equals("Debit Card"))
            {
                JPanel cardPanel = new JPanel(
                    new GridLayout(3, 1, 5, 5)
                );

                cardPanel.add(
                    new JLabel("Debit Card Demo Payment")
                );

                cardPanel.add(
                    new JLabel("Demo Card: XXXX XXXX XXXX 5678")
                );

                cardPanel.add(
                    new JLabel("Amount: Rs. " + finalAmount)
                );

                choice = JOptionPane.showConfirmDialog(
                    this,
                    cardPanel,
                    "Debit Card Payment",
                    JOptionPane.YES_NO_OPTION
                );
            }

            // CASH AT COUNTER
            else if(method.equals("Cash at Counter"))
            {
                choice = JOptionPane.showConfirmDialog(
                    this,
                    "Please pay Rs. " + finalAmount +
                    " at the cinema counter.\n\n" +
                    "This is a simulated booking.\n" +
                    "Continue?",
                    "Cash at Counter",
                    JOptionPane.YES_NO_OPTION
                );
            }

            // PAYMENT SUCCESS
            if(choice == JOptionPane.YES_OPTION)
            {
                String bookingKey =
                    SeatSelection.getBookingKey(
                        movieName, showDate, showTiming
                    );

                SeatSelection.bookedByMovie
                    .get(bookingKey).addAll(seats);

                String bookingDate =
                    new SimpleDateFormat("dd-MM-yyyy HH:mm")
                    .format(new Date());

                String bookingDetails =
                    "Movie: " + movieName +
                    " | Show: " + showTiming +
                    " | Date: " + showDate +
                    " | Seats: " + String.join(", ", seats) +
                    " | Tickets: " + seats.size() +
                    " | Ticket Amount: Rs. " + total +
                    " | Snacks: " + selectedSnackDetails +
                    " | Snack Amount: Rs. " + snackTotal +
                    " | Total: Rs. " + finalAmount +
                    " | Booked On: " + bookingDate;

                BookingData.addBooking(
                    bookingDetails,
                    movieName,
                    seats
                );

                JOptionPane.showMessageDialog(
                    this,
                    "Demo Payment Successful!\n\n" +
                    "No real money was transferred."
                );

                new BookingConfirmation(
                    movieName,
                    new ArrayList<>(seats),
                    finalAmount,
                    showTiming,
                    showDate,
                    selectedSnackDetails,
                    snackTotal
                );

                dispose();
            }
        });

        JLabel note = new JLabel(
            "DEMO ONLY - No actual payment is processed.",
            JLabel.CENTER
        );
        note.setForeground(Color.LIGHT_GRAY);

        mainPanel.add(heading);
        mainPanel.add(movie);
        mainPanel.add(date);
        mainPanel.add(timing);
        mainPanel.add(seat);
        mainPanel.add(price);
        mainPanel.add(amount);
        mainPanel.add(snacksButton);
        mainPanel.add(snackSummary);
        mainPanel.add(paymentLabel);
        mainPanel.add(paymentMethod);
        mainPanel.add(payButton);
        mainPanel.add(note);

        add(mainPanel);
        setVisible(true);
    }

    // Snacks selection
    public void selectSnacks()
    {
        JPanel snackPanel = new JPanel(
            new GridLayout(12, 3, 10, 8)
        );

        JCheckBox[] checkboxes = new JCheckBox[12];
        JSpinner[] quantities = new JSpinner[12];

        for(int i = 0; i < snackNames.length; i++)
        {
            checkboxes[i] = new JCheckBox(snackNames[i]);

            quantities[i] = new JSpinner(
                new SpinnerNumberModel(1, 1, 10, 1)
            );

            JLabel priceLabel = new JLabel(
                "Rs. " + snackPrices[i]
            );

            snackPanel.add(checkboxes[i]);
            snackPanel.add(priceLabel);
            snackPanel.add(quantities[i]);
        }

        JScrollPane scrollPane = new JScrollPane(snackPanel);
        scrollPane.setPreferredSize(new Dimension(430, 350));

        int result = JOptionPane.showConfirmDialog(
            this,
            scrollPane,
            "Select Your Snacks",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if(result == JOptionPane.OK_OPTION)
        {
            snackTotal = 0;
            selectedSnackDetails = "";

            for(int i = 0; i < snackNames.length; i++)
            {
                if(checkboxes[i].isSelected())
                {
                    int quantity =
                        (Integer) quantities[i].getValue();

                    int itemTotal = snackPrices[i] * quantity;

                    snackTotal += itemTotal;

                    selectedSnackDetails +=
                        snackNames[i] + " x " + quantity +
                        " (Rs. " + itemTotal + "), ";
                }
            }

            if(selectedSnackDetails.isEmpty())
            {
                selectedSnackDetails = "None";
            }
            else
            {
                selectedSnackDetails =
                    selectedSnackDetails.substring(
                        0, selectedSnackDetails.length() - 2
                    );
            }

            snackSummary.setText(
                "Snacks: " + selectedSnackDetails +
                " | Snack Amount: Rs. " + snackTotal
            );

            amount.setText(
                "Total Amount: Rs. " + (total + snackTotal)
            );
        }
    }
}

