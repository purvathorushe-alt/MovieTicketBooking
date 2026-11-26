
import javax.swing.*;
import java.awt.*;
import java.awt.print.*;
import java.util.ArrayList;

public class BookingConfirmation extends JFrame
{
    JPanel mainPanel;

    public BookingConfirmation(
        String movieName,
        ArrayList<String> seats,
        int total,
        String showTiming,
        String showDate,
        String snackDetails,
        int snackTotal)
    {
        setTitle("Booking Confirmation");
        setSize(650, 750);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(20, 20, 30));
        mainPanel.setLayout(new GridLayout(12, 1, 8, 8));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        int ticketAmount = total - snackTotal;

        JLabel success = new JLabel(
            "BOOKING CONFIRMED!", JLabel.CENTER
        );
        success.setFont(new Font("Arial", Font.BOLD, 28));
        success.setForeground(Color.GREEN);

        JLabel movie = new JLabel(
            "Movie: " + movieName, JLabel.CENTER
        );
        movie.setForeground(Color.WHITE);
        movie.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel date = new JLabel(
            "Movie Date: " + showDate, JLabel.CENTER
        );
        date.setForeground(Color.ORANGE);
        date.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel timing = new JLabel(
            "Show Timing: " + showTiming, JLabel.CENTER
        );
        timing.setForeground(Color.ORANGE);
        timing.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel seat = new JLabel(
            "Seats: " + String.join(", ", seats), JLabel.CENTER
        );
        seat.setForeground(Color.WHITE);
        seat.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel count = new JLabel(
            "Number of Tickets: " + seats.size(), JLabel.CENTER
        );
        count.setForeground(Color.WHITE);
        count.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel price = new JLabel(
            "Price per Ticket: Rs. " +
            MovieDetails.getPrice(movieName),
            JLabel.CENTER
        );
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel ticketAmountLabel = new JLabel(
            "Ticket Amount: Rs. " + ticketAmount,
            JLabel.CENTER
        );
        ticketAmountLabel.setForeground(Color.WHITE);
        ticketAmountLabel.setFont(
            new Font("Arial", Font.PLAIN, 18)
        );

        JLabel snacks = new JLabel(
            "Snacks: " + snackDetails, JLabel.CENTER
        );
        snacks.setForeground(Color.WHITE);
        snacks.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel snackAmountLabel = new JLabel(
            "Snack Amount: Rs. " + snackTotal,
            JLabel.CENTER
        );
        snackAmountLabel.setForeground(Color.WHITE);
        snackAmountLabel.setFont(
            new Font("Arial", Font.PLAIN, 18)
        );

        JLabel amount = new JLabel(
            "Total Amount: Rs. " + total, JLabel.CENTER
        );
        amount.setForeground(Color.ORANGE);
        amount.setFont(new Font("Arial", Font.BOLD, 22));

        String bookingId =
            "MTB" + (System.currentTimeMillis() % 1000000);

        JLabel id = new JLabel(
            "Booking ID: " + bookingId, JLabel.CENTER
        );
        id.setForeground(Color.LIGHT_GRAY);
        id.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton printButton = new JButton("Print Ticket");
        printButton.setBackground(Color.GREEN);
        printButton.setFont(
            new Font("Arial", Font.BOLD, 16)
        );

        printButton.addActionListener(e -> printTicket());

        JButton closeButton = new JButton("Done");
        closeButton.setBackground(Color.ORANGE);
        closeButton.setFont(
            new Font("Arial", Font.BOLD, 16)
        );

        closeButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(20, 20, 30));
        buttonPanel.add(printButton);
        buttonPanel.add(closeButton);

        mainPanel.add(success);
        mainPanel.add(movie);
        mainPanel.add(date);
        mainPanel.add(timing);
        mainPanel.add(seat);
        mainPanel.add(count);
        mainPanel.add(price);
        mainPanel.add(ticketAmountLabel);
        mainPanel.add(snacks);
        mainPanel.add(snackAmountLabel);
        mainPanel.add(amount);
        mainPanel.add(id);

        // Add buttons separately at the bottom
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBackground(new Color(20, 20, 30));
        outerPanel.add(mainPanel, BorderLayout.CENTER);
        outerPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(outerPanel);
        setVisible(true);
    }

    public void printTicket()
    {
        PrinterJob job = PrinterJob.getPrinterJob();

        job.setJobName("Movie Ticket");

        job.setPrintable((graphics, pageFormat, pageIndex) ->
        {
            if(pageIndex > 0)
                return Printable.NO_SUCH_PAGE;

            Graphics2D g2d = (Graphics2D) graphics;

            g2d.translate(
                pageFormat.getImageableX(),
                pageFormat.getImageableY()
            );

            double scale = Math.min(
                pageFormat.getImageableWidth() / getContentPane().getWidth(),
                pageFormat.getImageableHeight() / getContentPane().getHeight()
            );

            g2d.scale(scale, scale);

            getContentPane().printAll(g2d);

            return Printable.PAGE_EXISTS;
        });

        if(job.printDialog())
        {
            try
            {
                job.print();

                JOptionPane.showMessageDialog(
                    this,
                    "Ticket printed successfully!"
                );
            }
            catch(PrinterException e)
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Unable to print ticket!"
                );
            }
        }
    }
}




