package mdi;
import java.util.Scanner;
import library.Publication;
import library.Video;
import library.Video.InvalidRuntimeException;
import library.Library;

public class LibraryManager
{
    public static void main(String[] args)
    {
        Library library = new Library("cse1325 Library");
        library.addPublication(new Publication("The Daughter’s Tale", "Armando Lucas Correa", 1939));
        library.addPublication(new Publication("Gorgeous Lies", "Martha McPhee", 2002));
        library.addPublication(new Publication("Normal People", "Sally Rooney", 2018));
        library.addPublication(new Video("The Avengers", "Joss Whedon", 2012, 143));
        library.addPublication(new Video("Interstellar", "Christopher Nolan", 2014, 169));
        library.addPublication(new Video("Spider-Man", "Sam Raimi", 2002, 121));
        library.addPublication(new Video("Titanic", "James Cameron", 1997, 194));
        System.out.println(library);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the index of the publication: ");
        int index = sc.nextInt();
        System.out.print("What is your name: ");
        sc.nextLine();
        String patron = sc.nextLine();
        try
        {
            library.checkOut(index, patron);
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Invalid publication index");
        }
        catch(InvalidRuntimeException e)
        {
            System.out.println(e.getMessage());
        }
        sc.close();
        System.out.println(library);
    }

}