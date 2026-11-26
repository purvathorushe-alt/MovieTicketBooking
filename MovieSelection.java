
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class MovieSelection extends JFrame
{
    JPanel moviePanel;
    JTextField searchField;

    String selectedGenre = "All Movies";

    ArrayList<Movie> movies = new ArrayList<>();

    String[] genres = {
        "All Movies",
        "Action",
        "Sci-Fi",
        "Thriller",
        "Comedy",
        "Romance",
        "Horror",
        "Animation",
        "Drama"
    };

    Color backgroundColor = new Color(18, 18, 28);
    Color cardColor = new Color(35, 35, 50);
    Color orange = new Color(255, 165, 0);

    public MovieSelection()
    {
        setTitle("Cinema - Browse Movies");
        setSize(1200, 850);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        addMovies();

        JPanel mainPanel = new JPanel(new BorderLayout(10, 15));
        mainPanel.setBackground(backgroundColor);
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(backgroundColor);

        JLabel logo = new JLabel("CINEMA");
        logo.setFont(new Font("Arial", Font.BOLD, 30));
        logo.setForeground(orange);

        JLabel subtitle = new JLabel(
            "Your movie experience starts here"
        );
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(Color.LIGHT_GRAY);

        JPanel headingPanel = new JPanel();
        headingPanel.setBackground(backgroundColor);
        headingPanel.setLayout(
            new BoxLayout(headingPanel, BoxLayout.Y_AXIS)
        );

        headingPanel.add(logo);
        headingPanel.add(Box.createVerticalStrut(5));
        headingPanel.add(subtitle);

        header.add(headingPanel, BorderLayout.WEST);

        // Search bar
        searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        searchField.setPreferredSize(new Dimension(300, 38));

        searchField.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(orange),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
            )
        );

        header.add(searchField, BorderLayout.EAST);

        mainPanel.add(header, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel(new BorderLayout(10, 15));
        centerPanel.setBackground(backgroundColor);

        JLabel sectionTitle = new JLabel("Explore Movies");
        sectionTitle.setFont(new Font("Arial", Font.BOLD, 25));
        sectionTitle.setForeground(Color.WHITE);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(backgroundColor);
        titlePanel.add(sectionTitle, BorderLayout.WEST);

        // Genre buttons
        JPanel genrePanel = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 8, 8)
        );
        genrePanel.setBackground(backgroundColor);

        for(String genre : genres)
        {
            JButton genreButton = new JButton(genre);

            genreButton.setFont(
                new Font("Arial", Font.BOLD, 13)
            );

            genreButton.setFocusPainted(false);
            genreButton.setBorderPainted(false);
            genreButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
            );

            if(genre.equals(selectedGenre))
            {
                genreButton.setBackground(orange);
                genreButton.setForeground(Color.BLACK);
            }
            else
            {
                genreButton.setBackground(cardColor);
                genreButton.setForeground(Color.WHITE);
            }

            genreButton.addActionListener(e ->
            {
                selectedGenre = genre;

                for(Component component : genrePanel.getComponents())
                {
                    JButton button = (JButton) component;

                    if(button.getText().equals(selectedGenre))
                    {
                        button.setBackground(orange);
                        button.setForeground(Color.BLACK);
                    }
                    else
                    {
                        button.setBackground(cardColor);
                        button.setForeground(Color.WHITE);
                    }
                }

                displayMovies();
            });

            genrePanel.add(genreButton);
        }

        JPanel filterPanel = new JPanel(new BorderLayout());
        filterPanel.setBackground(backgroundColor);
        filterPanel.add(titlePanel, BorderLayout.NORTH);
        filterPanel.add(genrePanel, BorderLayout.CENTER);

        centerPanel.add(filterPanel, BorderLayout.NORTH);

        // Movie cards
        moviePanel = new JPanel(new GridLayout(0, 4, 15, 15));
        moviePanel.setBackground(backgroundColor);

        JScrollPane scrollPane = new JScrollPane(moviePanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(backgroundColor);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        centerPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Search functionality
        searchField.getDocument().addDocumentListener(
            new DocumentListener()
            {
                public void insertUpdate(DocumentEvent e)
                {
                    displayMovies();
                }

                public void removeUpdate(DocumentEvent e)
                {
                    displayMovies();
                }

                public void changedUpdate(DocumentEvent e)
                {
                    displayMovies();
                }
            }
        );

        add(mainPanel);

        displayMovies();

        setVisible(true);
    }

    // Add all movies
    public void addMovies()
    {
        // Action
        movies.add(new Movie("AVENGERS: ENDGAME", "Action", "avengers.jpg", 8.4));
        movies.add(new Movie("SPIDER-MAN", "Action", "spiderman.jpg", 8.2));
        movies.add(new Movie("DARK KNIGHT", "Action", "darkknight.jpg", 9.0));
        movies.add(new Movie("JOHN WICK", "Action", "johnwick.jpg", 7.4));
        movies.add(new Movie("TOP GUN: MAVERICK", "Action", "topgun.jpg", 8.2));

        // Sci-Fi
        movies.add(new Movie("INTERSTELLAR", "Sci-Fi", "interstellar.jpg", 8.7));
        movies.add(new Movie("AVATAR", "Sci-Fi", "avatar.jpg", 7.9));
        movies.add(new Movie("DUNE: PART TWO", "Sci-Fi", "duneparttwo.jpg", 8.5));
        movies.add(new Movie("THE MATRIX", "Sci-Fi", "matrix.jpg", 8.7));

        // Thriller
        movies.add(new Movie("INCEPTION", "Thriller", "inception.jpg", 8.8));
        movies.add(new Movie("SHUTTER ISLAND", "Thriller", "shutterisland.jpg", 8.2));
        movies.add(new Movie("GONE GIRL", "Thriller", "gonegirl.jpg", 8.1));
        movies.add(new Movie("NOW YOU SEE ME", "Thriller", "nowyouseeme.jpg", 7.2));

        // Comedy
        movies.add(new Movie("JUMANJI", "Comedy", "jumanji.jpg", 7.0));
        movies.add(new Movie("THE HANGOVER", "Comedy", "hangover.jpg", 7.7));
        movies.add(new Movie("HOME ALONE", "Comedy", "homealone.jpg", 7.7));

        // Romance
        movies.add(new Movie("TITANIC", "Romance", "titanic.jpg", 7.9));
        movies.add(new Movie("LA LA LAND", "Romance", "lalaland.jpg", 8.0));
        movies.add(new Movie("THE FAULT IN OUR STARS", "Romance", "faultinstars.jpg", 7.7));
        movies.add(new Movie("VOICEMAILS FOR ISABEL", "Romance", "voicemailsforisabel.jpg", 0.0));

        // Horror
        movies.add(new Movie("THE CONJURING", "Horror", "conjuring.jpg", 7.5));
        movies.add(new Movie("A QUIET PLACE", "Horror", "quietplace.jpg", 7.5));
        movies.add(new Movie("IT", "Horror", "it.jpg", 7.3));

        // Animation
        movies.add(new Movie("FROZEN", "Animation", "frozen.jpg", 7.4));
        movies.add(new Movie("THE LION KING", "Animation", "lionking.jpg", 8.5));
        movies.add(new Movie("COCO", "Animation", "coco.jpg", 8.4));
        movies.add(new Movie("INSIDE OUT 2", "Animation", "insideout2.jpg", 7.5));
        movies.add(new Movie("SPIDER-MAN: ACROSS THE SPIDER-VERSE", "Animation", "spiderverse.jpg", 8.6));

        // Drama
        movies.add(new Movie("JOKER", "Drama", "joker.jpg", 8.3));
        movies.add(new Movie("THE PURSUIT OF HAPPYNESS", "Drama", "pursuitofhappyness.jpg", 8.0));
    }

    // Display movies according to genre and search
    public void displayMovies()
    {
        moviePanel.removeAll();

        String searchText =
            searchField.getText().trim().toLowerCase();

        int count = 0;

        for(Movie movie : movies)
        {
            boolean genreMatch =
                selectedGenre.equals("All Movies") ||
                movie.genre.equals(selectedGenre);

            boolean searchMatch =
                movie.name.toLowerCase().contains(searchText);

            if(genreMatch && searchMatch)
            {
                moviePanel.add(createMovieCard(movie));
                count++;
            }
        }

        if(count == 0)
        {
            JLabel noMovies = new JLabel("No movies found!");
            noMovies.setForeground(Color.WHITE);
            noMovies.setFont(
                new Font("Arial", Font.BOLD, 20)
            );
            moviePanel.add(noMovies);
        }

        moviePanel.revalidate();
        moviePanel.repaint();
    }

    // Create movie card
    public JPanel createMovieCard(Movie movie)
    {
        JPanel card = new JPanel();

        card.setLayout(
            new BoxLayout(card, BoxLayout.Y_AXIS)
        );

        card.setBackground(cardColor);

        card.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    new Color(75, 75, 90), 1
                ),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            )
        );

        // Poster
        ImageIcon originalIcon =
            new ImageIcon("posters/" + movie.imageName);

        JLabel poster;

        if(originalIcon.getIconWidth() > 0)
        {
            Image image = originalIcon.getImage();

            Image scaledImage = image.getScaledInstance(
                190,
                220,
                Image.SCALE_SMOOTH
            );

            poster = new JLabel(new ImageIcon(scaledImage));
        }
        else
        {
            poster = new JLabel("Poster Not Found");
            poster.setForeground(Color.WHITE);
            poster.setPreferredSize(
                new Dimension(190, 220)
            );
            poster.setHorizontalAlignment(
                SwingConstants.CENTER
            );
        }

        poster.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Movie name
        JLabel nameLabel = new JLabel(movie.name);
        nameLabel.setFont(
            new Font("Arial", Font.BOLD, 15)
        );
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Genre
        JLabel genreLabel = new JLabel(movie.genre);
        genreLabel.setFont(
            new Font("Arial", Font.PLAIN, 14)
        );
        genreLabel.setForeground(Color.LIGHT_GRAY);
        genreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Rating
        JLabel ratingLabel;

        if(movie.rating > 0)
        {
            ratingLabel = new JLabel(
                "★ " + movie.rating + " / 10"
            );
        }
        else
        {
            ratingLabel = new JLabel("Rating unavailable");
        }

        ratingLabel.setFont(
            new Font("Arial", Font.BOLD, 14)
        );
        ratingLabel.setForeground(orange);
        ratingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Price
        JLabel priceLabel = new JLabel(
            "Ticket Price: Rs. " +
            MovieDetails.getPrice(movie.name)
        );

        priceLabel.setFont(
            new Font("Arial", Font.BOLD, 15)
        );
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Book button
        JButton selectButton = new JButton("Book Tickets");

        selectButton.setFont(
            new Font("Arial", Font.BOLD, 14)
        );
        selectButton.setBackground(orange);
        selectButton.setForeground(Color.BLACK);
        selectButton.setFocusPainted(false);
        selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectButton.setCursor(
            new Cursor(Cursor.HAND_CURSOR)
        );

        selectButton.addActionListener(e ->
        {
            String[] timings = {
                "Morning - 10:00 AM",
                "Afternoon - 2:00 PM",
                "Evening - 6:00 PM"
            };

            String selectedTiming =
                (String) JOptionPane.showInputDialog(
                    this,
                    "Select Show Timing:",
                    "Show Timings",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    timings,
                    timings[0]
                );

            if(selectedTiming != null)
            {
                SpinnerDateModel dateModel =
                    new SpinnerDateModel(
                        new Date(),
                        new Date(),
                        null,
                        Calendar.DAY_OF_MONTH
                    );

                JSpinner dateSpinner =
                    new JSpinner(dateModel);

                dateSpinner.setEditor(
                    new JSpinner.DateEditor(
                        dateSpinner,
                        "dd-MM-yyyy"
                    )
                );

                JPanel datePanel = new JPanel(
                    new GridLayout(2, 1, 5, 5)
                );

                datePanel.add(
                    new JLabel("Select Movie Date:")
                );

                datePanel.add(dateSpinner);

                int result = JOptionPane.showConfirmDialog(
                    this,
                    datePanel,
                    "Select Date",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
                );

                if(result == JOptionPane.OK_OPTION)
                {
                    Date selectedDate =
                        (Date) dateSpinner.getValue();

                    String formattedDate =
                        new SimpleDateFormat("dd-MM-yyyy")
                        .format(selectedDate);

                    new SeatSelection(
                        movie.name,
                        selectedTiming,
                        formattedDate
                    );
                }
            }
        });

        card.add(poster);
        card.add(Box.createVerticalStrut(8));
        card.add(nameLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(genreLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(ratingLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(priceLabel);
        card.add(Box.createVerticalStrut(8));
        card.add(selectButton);

        return card;
    }

    // Movie class
    class Movie
    {
        String name;
        String genre;
        String imageName;
        double rating;

        Movie(
            String name,
            String genre,
            String imageName,
            double rating)
        {
            this.name = name;
            this.genre = genre;
            this.imageName = imageName;
            this.rating = rating;
        }
    }
}

