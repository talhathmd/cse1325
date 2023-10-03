package library;

import java.time.LocalDate;


/**
 * A class representing a publication in the library, such as a book or a video, A Library resoure that can be checked out by patron.
 */
public class Publication 
{
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

    /**
     * Constructs a Publication object with the given title, author, and copyright year.
     *
     * @title     The title of the publication.
     * @author    The author of the publication.
     * @copyright The copyright year of the publication.
     * @throws    If the copyright year is not within a valid range (1900 to current year).
     */

    public Publication(String title, String author, int copyright)
    {
        int year = LocalDate.now().getYear();
        if(copyright < 1900 || copyright > year)
        {
            throw new IllegalArgumentException("Invalid Year");
        }

        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }

    /**
     * Checks out the publication to a patron, setting the due date 14 days from the checkout date.
     *
     * @patron The patron checking out the publication.
     */

    public void checkOut(String patron)
    {
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }

     /**
     * Checks in the publication, resetting the loanedTo and dueDate fields.
     */

    public void checkIn()
    {
        this.loanedTo = null;
        this.dueDate = null;
    }


    /**
     * Builds a string representation of the publication with the specified prefix and additional information.
     *
     * @pre The prefix for the string representation (e.g., "Book" or "Video").
     * @mid Additional information to include in the string representation.
     * @return The string representation of the publication.
     */

    protected String toStringBuilder(String pre, String mid)
    {
        StringBuilder info = new StringBuilder(pre);
        info.append(" \"").append(title).append("\" by ").append(author).append(", copyright: ").append(copyright);
        if(mid != null)
        {
            info.append(", ").append(mid);
        }
        if(loanedTo != null)
        {
            info.append("\n  -->").append(" loaned to ").append(loanedTo).append(" until ").append(dueDate);
        }
        info.append("\n");
        return info.toString(); 
    }

    /**
     * Overrides the toString method to provide a string representation of the Publication object.
     *
     * @return A string representation of the Publication object.
     */

    @Override 
    public String toString()
    {
        return toStringBuilder("Book", "");
    }


}

