
public class MovieDetails
{
    public static int getPrice(String movieName)
    {
        // Original movies
        if(movieName.equals("INTERSTELLAR"))
            return 450;

        else if(movieName.equals("INCEPTION"))
            return 600;

        else if(movieName.equals("AVENGERS: ENDGAME"))
            return 570;

        else if(movieName.equals("SPIDER-MAN"))
            return 420;

        else if(movieName.equals("JOKER"))
            return 460;

        else if(movieName.equals("DARK KNIGHT"))
            return 550;

        // Action
        else if(movieName.equals("JOHN WICK"))
            return 480;

        else if(movieName.equals("TOP GUN: MAVERICK"))
            return 520;

        // Sci-Fi
        else if(movieName.equals("AVATAR"))
            return 500;

        else if(movieName.equals("DUNE: PART TWO"))
            return 550;

        else if(movieName.equals("THE MATRIX"))
            return 450;

        // Thriller
        else if(movieName.equals("SHUTTER ISLAND"))
            return 430;

        else if(movieName.equals("GONE GIRL"))
            return 420;

        else if(movieName.equals("NOW YOU SEE ME"))
            return 400;

        // Comedy
        else if(movieName.equals("JUMANJI"))
            return 380;

        else if(movieName.equals("THE HANGOVER"))
            return 350;

        else if(movieName.equals("HOME ALONE"))
            return 350;

        // Romance
        else if(movieName.equals("TITANIC"))
            return 450;

        else if(movieName.equals("LA LA LAND"))
            return 400;

        else if(movieName.equals("THE FAULT IN OUR STARS"))
            return 380;

        else if(movieName.equals("VOICEMAILS FOR ISABEL"))
            return 400;

        // Horror
        else if(movieName.equals("THE CONJURING"))
            return 420;

        else if(movieName.equals("A QUIET PLACE"))
            return 400;

        else if(movieName.equals("IT"))
            return 380;

        // Animation
        else if(movieName.equals("FROZEN"))
            return 400;

        else if(movieName.equals("THE LION KING"))
            return 420;

        else if(movieName.equals("COCO"))
            return 380;

        else if(movieName.equals("INSIDE OUT 2"))
            return 400;

        else if(movieName.equals("SPIDER-MAN: ACROSS THE SPIDER-VERSE"))
            return 450;

        // Drama
        else if(movieName.equals("THE PURSUIT OF HAPPYNESS"))
            return 380;

        else
            return 400;
    }
}



