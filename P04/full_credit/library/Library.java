package library;
import java.util.ArrayList;


/**
 * A class representing a library that holds publications. Models a library.
 */

public class Library 
{
    private String name;
    private ArrayList<Publication> publications = new ArrayList<>();

    /**
     * Constructs a Library object with the given name.
     *
     * @name The name of the library.
     */

    public Library(String name)
    {
        this.name = name;
    }

    /**
     * Adds a publication to the library's collection.
     *
     * @publication The publication to add.
     */

    public void addPublication(Publication publication)
    {
        publications.add(publication);
    }

    /**
     * Checks out a publication at the specified index to a patron.
     *
     * @publicationIndex The index of the publication to check out.
     * @patron           The patron checking out the publication.
     * @throws           If the publication index is invalid.
     */

    public void checkOut(int publicationIndex , String patron)
    {
        if(publicationIndex >= 0 && publicationIndex < publications.size())
        {
            publications.get(publicationIndex).checkOut(patron);
        }
        else
        {
            throw new IndexOutOfBoundsException("Invalid publication index");
        }
    }

    /**
     * Overrides the toString method to provide a string representation of the Library object.
     *
     * @return A string representation of the Library object.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");

        for(int i = 0; i < publications.size(); i++)
        {
            sb.append(i).append(") ").append(publications.get(i)).append("\n");
        }
        return sb.toString();
    }
}
