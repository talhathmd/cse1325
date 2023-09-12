// Talha Tahmid ID: 1001910304

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Publication
{
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

    public Publication(String title, String author, int copyright)
    {
        int year = LocalDate.now().getYear();
        if(copyright < 1900 || copyright > year)
        {
            throw new IllegalArgumentException("Invalid year");
        }

        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }

    public void checkOut(String patron)
    {
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }

    public void checkIn()
    {
        this.loanedTo = null;
        this.dueDate = null;
    }

    @Override 
    public String toString()
    {
        String info = title +  " by " + author + "," + "copyright" + copyright + " --> loaned to " + loanedTo + " until " + dueDate;
        
        if(loanedTo == null)
        {
            return title + " by " + author + " (Copyright " + copyright + ")";
        } 
        return info;
    }


}

class Library
{
    private String name;
    private ArrayList<Publication> publications = new ArrayList<>();

    public Library(String name)
    {
        this.name = name;
    }

    public void addPublication(Publication publication)
    {
        publications.add(publication);
    }

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

public class LibraryManager
{
    public static void main(String[] args)
    {
        Library library = new Library("cse1325 Library");
        library.addPublication(new Publication("The Daughter’s Tale", "Armando Lucas Correa", 1939));
        library.addPublication(new Publication("Gorgeous Lies", "Martha McPhee", 2002));
        library.addPublication(new Publication("Normal People", "Sally Rooney", 2018));
        System.out.println(library);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the index of the publication: ");
        int index = sc.nextInt();
        System.out.print("What is your name: ");
        sc.nextLine();
        String patron = sc.nextLine();
        library.checkOut(index, patron);
        System.out.println(library);
    }

}