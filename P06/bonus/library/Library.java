// Talha Tahmid 1001910304

package library;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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

    public Library(BufferedReader br) throws IOException {
        this.name = br.readLine();
        int numPublications = Integer.parseInt(br.readLine());

        for (int i = 0; i < numPublications; i++) {
            String publicationType = br.readLine();
            if (publicationType.equals("video")) {
                publications.add(new Video(br));
            } else {
                publications.add(new Publication(br));
            }
        }

        
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write(publications.size() + "\n");

        for (Publication publication : publications) {
            if (publication instanceof Video) {
                bw.write("video\n");
            } else {
                bw.write("publication\n");
            }
            publication.save(bw);
        }
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
     * Checks in for a publication at a specified index.
     *
     * Allows you to check in a publication
     *
     * @publicationIndex The index of the publication to check in.
     */
    public void checkIn(int publicationIndex)
    {
        publications.get(publicationIndex).checkIn();
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
