import java.util.Comparator;

public class Solution implements Comparable<Solution> { 
    public Solution(String name, String word, int x, int y, Direction direction) {
        this.name = name;
        this.word = word;
        this.x = x;
        this.y = y;;
        this.direction = direction;
    }
    
    @Override
    public int compareTo(Solution solution){
        if(this.name.equals(solution.name) == true){
            return this.word.compareTo(solution.word);
        }
        else{
            return this.name.compareTo(solution.name);
        }
    }
   

    @Override
    public String toString() {
        return String.format("In %s: %s found at (%d,%d,%s)", name, word, x, y, direction);
    }

    private String name;
    private String word;
    private int x;
    private int y;
    private Direction direction;
}
