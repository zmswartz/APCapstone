import java.util.Arrays;
public class Tester
{
    public static void main(String[] args)
    {
        CheckersBoard board = new CheckersBoard();
        board.printer();
        
        System.out.println("\n");
        System.out.println(Arrays.toString(board.getAllMoves(-1)));
        
    }
    
    
}
