
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class BookingData
{
    public static ArrayList<String> bookings = new ArrayList<>();
    public static ArrayList<String> movieNames = new ArrayList<>();
    public static ArrayList<ArrayList<String>> bookedSeats = new ArrayList<>();
    public static ArrayList<String> bookingKeys = new ArrayList<>();

    // Get the value of a booking field
    public static String getField(String[] parts, String field)
    {
        for(String part : parts)
        {
            part = part.trim();

            if(part.startsWith(field + ":"))
            {
                return part.substring(field.length() + 1).trim();
            }
        }

        return "";
    }

    // Load previous bookings
    static
    {
        try
        {
            BufferedReader reader = new BufferedReader(
                new FileReader("bookings.txt")
            );

            String line;

            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split("\\|");

                String movieName = getField(parts, "Movie");
                String showTiming = getField(parts, "Show");
                String showDate = getField(parts, "Date");
                String seatPart = getField(parts, "Seats");

                if(!movieName.isEmpty() && !seatPart.isEmpty())
                {
                    bookings.add(line);
                    movieNames.add(movieName);

                    ArrayList<String> seats = new ArrayList<>();

                    for(String seat : seatPart.split(","))
                    {
                        if(!seat.trim().isEmpty())
                        {
                            seats.add(seat.trim());
                        }
                    }

                    bookedSeats.add(seats);

                    // New bookings use movie, date and show as the key
                    if(!showDate.isEmpty() && !showTiming.isEmpty())
                    {
                        bookingKeys.add(
                            movieName + "|" + showDate + "|" + showTiming
                        );
                    }
                    else
                    {
                        // Support older bookings without a selected date
                        bookingKeys.add(movieName);
                    }
                }
            }

            reader.close();
        }
        catch(IOException e)
        {
            // File may not exist initially
        }
    }

    // Add a new booking
    public static void addBooking(
        String bookingDetails,
        String movieName,
        ArrayList<String> seats)
    {
        try
        {
            FileWriter writer = new FileWriter("bookings.txt", true);

            writer.write(bookingDetails + "\n");
            writer.close();

            String[] parts = bookingDetails.split("\\|");

            String showTiming = getField(parts, "Show");
            String showDate = getField(parts, "Date");

            bookings.add(bookingDetails);
            movieNames.add(movieName);
            bookedSeats.add(new ArrayList<>(seats));

            if(!showDate.isEmpty() && !showTiming.isEmpty())
            {
                bookingKeys.add(
                    movieName + "|" + showDate + "|" + showTiming
                );
            }
            else
            {
                bookingKeys.add(movieName);
            }
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(
                null, "Unable to save booking!"
            );
        }
    }

    // Remove a cancelled booking
    public static void cancelBooking(int index)
    {
        bookings.remove(index);
        movieNames.remove(index);
        bookedSeats.remove(index);
        bookingKeys.remove(index);

        try
        {
            FileWriter writer = new FileWriter("bookings.txt");

            for(String booking : bookings)
            {
                writer.write(booking + "\n");
            }

            writer.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(
                null, "Unable to update booking history!"
            );
        }
    }
}

