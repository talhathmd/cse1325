// Talha Tahmid 1001910304
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.SortedSet;
import java.lang.Math;

public class WordSearch {
    private static final String usage = "usage: java WordSearch [-h] [-v] [#threads] [#puzzles] [puzzleFile]...";
    // Constructor
    public WordSearch(List<String> args) {
    
        // Validate the command line arguments
        if(args.size() > 0 && args.get(0).equals("-h")) {
            System.out.println(usage);
            System.exit(0);
        }
        if(args.size() > 0 && args.get(0).equals("-v")) {
             verbose = true;
             args.remove(0);
        } else {
             verbose = false;
        }
        int threads = 0;
        try {
            threads = Integer.parseInt(args.get(0));
            args.remove(0);
        } catch(Exception e) {
            System.err.println("Error: Invalid number of threads\n" + usage);
            System.exit(-1);
        }
        NUM_THREADS = threads;
        int numPuzzles = 0;
        try {
            numPuzzles = Integer.parseInt(args.get(0));
            args.remove(0);
        } catch(Exception e) {
            System.err.println("Error: Invalid number of puzzles\n" + usage);
            System.exit(-1);
        }

        for(String puzzleName : args) {
            try(BufferedReader br = new BufferedReader(new FileReader(puzzleName))) {
                puzzles.add(new Puzzle(puzzleName, br));
            } catch(IOException e) {
                System.err.println("Unable to load puzzle " + puzzleName);
            }
        }
        
        if(puzzles.size() != args.size()) System.exit(-3);
        
        if(numPuzzles < puzzles.size()) puzzles.subList(numPuzzles, puzzles.size()).clear();
        else if (numPuzzles > puzzles.size()) {
            for(int i=puzzles.size(); i<numPuzzles; ++i)
                puzzles.add(puzzles.get(i%puzzles.size()));
        }
        NUM_PUZZLES = puzzles.size();
         // -------- All Puzzles Loaded --------
    }
    //Solve Method
    public void solve() {
        System.err.println ("\n" + NUM_PUZZLES + " puzzles with " 
            + NUM_THREADS + " threads");
        ArrayList<Thread> threadObjects = new ArrayList<Thread>();
    
    // Solve puzzles with multiple threads
        ArrayList<Thread> threadObj = new ArrayList<Thread>();
        
        for(int i =0; i<NUM_THREADS; i++){
            final int threadID = i;
            int subsetSize = (int)(Math.ceil((double)NUM_PUZZLES/NUM_THREADS));
            final int start = i*subsetSize;
            
            int tempEnd = (i+1)*subsetSize;


            if(tempEnd>NUM_PUZZLES){
                tempEnd = NUM_PUZZLES;
            }
            final int end = tempEnd;


            threadObj.add(new Thread(()->solve(threadID, start, end)));
            threadObj.get(i).start();
        }

        for(int i =0; i<NUM_THREADS; i++){
            try{
                threadObj.get(i).join();
            } catch(Exception e){
                System.err.println("Thread interrupted: "+ e.getMessage());
            }
        }
    }
    // Solve individual puzzles
    public void solve(final int threadID, final int firstPuzzle, final int lastPuzzlePlusOne) {
        System.err.println("Thread " + threadID + ": " + firstPuzzle + "-" + (lastPuzzlePlusOne-1));
        for(int i=firstPuzzle; i<lastPuzzlePlusOne; ++i) {
            Puzzle p = puzzles.get(i);
            Solver solver = new Solver(p);
            for(String word : p.getWords()) {
                try {
                    Solution s = solver.solve(word);
                    if(s == null) System.err.println("#### Failed to solve " + p.name() + " for '" + word + "'");
                    else solutions.add(s);
                } catch (Exception e) {
                    System.err.println("#### Exception solving " + p.name() 
                        + " for " + word + ": " + e.getMessage());
                }
            }
        }

        // -------- All Puzzles Solved --------
    }
    // Print Solutions
    public void printSolutions() {
        for(Solution s : solutions)
            System.out.println(s);
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch(new LinkedList<>(Arrays.asList(args)));
        ws.solve();
        if(ws.verbose) ws.printSolutions();
    }

    public final int NUM_THREADS;
    public final int NUM_PUZZLES;
    public final boolean verbose;
    // List to hold puzzles and solutions
    private List<Puzzle> puzzles = new ArrayList<>();
    private SortedSet<Solution> solutions = new TreeSet<Solution>();

}
