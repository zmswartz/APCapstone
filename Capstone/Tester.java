import java.util.Arrays;
public class Tester
{
    public static void main(String[] args)
    {
        CheckersBoard board = new CheckersBoard();
        board.printer();
        
        System.out.println("\n");
        
        
        board.makeMove("1203");
        
        
        board.makeMove("0314");
        System.out.println("\n");
        board.printer();
        board.forcedMove(-1);
        
        
//         board.makeMove("2305");
//         System.out.println("\n");
//         board.printer();
    }
    
    
}
