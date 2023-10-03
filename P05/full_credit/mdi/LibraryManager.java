// Talha Tahmid 1001910304

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
        Library library = new Library("cse1325 Library\n");
        library.addPublication(new Publication("The Daughter’s Tale", "Armando Lucas Correa", 1939));
        library.addPublication(new Publication("Gorgeous Lies", "Martha McPhee", 2002));
        library.addPublication(new Publication("Normal People", "Sally Rooney", 2018));
        library.addPublication(new Video("The Avengers", "Joss Whedon", 2012, 143));
        library.addPublication(new Video("Interstellar", "Christopher Nolan", 2014, 169));
        library.addPublication(new Video("Spider-Man", "Sam Raimi", 2002, 121));
        library.addPublication(new Video("Titanic", "James Cameron", 1997, 194));

    
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=========");
            System.out.println("Main Menu");
            System.out.println("=========");
            System.out.println("\n0) Exit \n1) List \n2) Add \n3) Check out \n4) Check in\n");
            System.out.print("Selection: ");
            choice = sc.nextInt();
            

            switch (choice) {
                case 0: // exit the program
                    System.out.println("\nProgram Exiting...\n");
                    break;
                
                case 1: // list the publications
                    System.out.println("\n=================");
                    System.out.println("Library Catalogue");
                    System.out.println("=================");
                    System.out.print(library);
                    break;

                case 2: // add menu
                    System.out.print("Enter Selection (For Publication: 1. For Video: 2): ");
                    int select = sc.nextInt();
                    System.out.print("Enter the title: ");
                    sc.nextLine();
                    String title = sc.nextLine();

                    System.out.print("Enter the name of the author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter the copyright year: ");
                    int copyright = sc.nextInt();

                    if (select == 1)
                    {
                        library.addPublication(new Publication(title, author, copyright));
                    }
                    else if (select == 2)
                    {
                        System.out.print("Enter the runtime (minutes): ");
                        int runtime = sc.nextInt();
                        library.addPublication(new Video(title, author, copyright, runtime));
                    }

                    
                    System.out.println("\nAdded to the library. Select list to view.");
                    
                    break;
                
                case 3: // check out
                    System.out.println(library);
                    System.out.print("Which publication you want to checkout (Enter the index): ");
                    int checkout_index = sc.nextInt();
                    System.out.print("Enter your name: ");
                    sc.nextLine();
                    String patron = sc.nextLine();
                    
                    try
                    {
                        library.checkOut(checkout_index, patron);
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("Invalid publication index.");
                    }
                    catch(InvalidRuntimeException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(library);

                    break;

                case 4: // check in
                    System.out.println(library);
                    System.out.print("Which publication you want to CheckIn (Enter index): ");
                    int checkin_index = sc.nextInt();
                    library.checkIn(checkin_index);
                    System.out.println("\nYour selection has been checked in. Select list to view.");

                    break;
                default: // invalid choice
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 0); // repeats until user choses to exit

        sc.close();
    }
     

   

}