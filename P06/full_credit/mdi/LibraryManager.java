package mdi;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import library.Publication;
import library.Video;
import library.Video.InvalidRuntimeException;
import library.Library;

public class LibraryManager
{
    private Library library;

    public LibraryManager()
    {
        library = new Library("The CSE1325 Library (UTA)");
        library.addPublication(new Publication("The Daughter’s Tale", "Armando Lucas Correa", 1939));
        library.addPublication(new Publication("Gorgeous Lies", "Martha McPhee", 2002));
        library.addPublication(new Publication("Normal People", "Sally Rooney", 2018));
        library.addPublication(new Video("The Avengers", "Joss Whedon", 2012, 143));
        library.addPublication(new Video("Interstellar", "Christopher Nolan", 2014, 169));
        library.addPublication(new Video("Spider-Man", "Sam Raimi", 2002, 121));
        library.addPublication(new Video("Titanic", "James Cameron", 1997, 194));

    }

    public void saveLibrary() 
    {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console available. Exiting.");
            return;
        }

        System.out.print("Open filename: ");
        String filename = console.readLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) 
        {
            library.save(bw);
            System.out.println("\nLibrary saved successfully to " + filename);
        } 
        catch (IOException e) 
        {
            System.err.println("\nError: Could not write to the file.");
        }
    }

    public void openLibrary() 
    {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console available. Exiting.");
            return;
        }
        
        System.out.print("Open filename: ");
        String filename = console.readLine();
    

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) 
        {
            library = new Library(br);
            System.out.println("Library loaded successfully from " + filename);
            
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println("Error: File not found.");
        }
        catch (IOException e) 
        {
            System.err.println("Error: Could not open the file." + e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        LibraryManager libraryManager = new LibraryManager();
    
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n=========");
            System.out.println("Main Menu");
            System.out.println("=========");
            System.out.println("\n0) Exit \n1) List \n2) Add \n3) Check out \n4) Check in\n5) Open\n6) Save\n");
            System.out.print("Enter your Selection: ");

            choice = sc.nextInt();
            sc.nextLine();
            
            //Execute the selected operationc
            switch (choice) 
            {
                case 0: // exit the program
                    System.out.println("\nExiting program.\n");
                    break;
                
                case 1: // list the publications
                    System.out.println("\n=================");
                    System.out.println("Library Catalogue");
                    System.out.println("=================");
                    System.out.print(libraryManager.library);
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
                        libraryManager.library.addPublication(new Publication(title, author, copyright));
                    }
                    else if (select == 2)
                    {
                        System.out.print("Enter the runtime (minutes): ");
                        int runtime = sc.nextInt();
                        libraryManager.library.addPublication(new Video(title, author, copyright, runtime));
                    }

                    
                    System.out.println("\nAdded to the library. Select list option to view.");
                    
                    break;
                
                case 3: // check out
                    System.out.println(libraryManager.library);
                    System.out.print("Which publication you want to checkout (Enter the index): ");
                    int checkout_index = sc.nextInt();
                    System.out.print("Enter your name: ");
                    sc.nextLine();
                    String patron = sc.nextLine();
                    
                    try
                    {
                        libraryManager.library.checkOut(checkout_index, patron);
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("Invalid publication index.");
                    }
                    catch(InvalidRuntimeException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(libraryManager.library);

                    break;

                case 4: // check in
                    System.out.println(libraryManager.library);
                    System.out.print("Which publication you want to checkin (Enter the index): ");
                    int checkin_index = sc.nextInt();
                    libraryManager.library.checkIn(checkin_index);
                    System.out.println("\nYour selection has been checked in. Select list to view.");

                    break;

                case 5: // open library
                    libraryManager.openLibrary();
                    break;

                case 6: // save library
                    libraryManager.saveLibrary();
                    
                    break;


                default: // invalid choice
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
            

        } while (choice != 0); // repeat until the user chooses to exit

        sc.close();
    }
     

   

}