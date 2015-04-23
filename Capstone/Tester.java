import java.util.Arrays;
public class Tester
{
    public static void main(String[] args)
    {
        CheckersBoard board = new CheckersBoard();
        
        
        System.out.println("\n");
        
        board.makeMove("6143");
        board.makeMove("7061");
        
        board.makeMove("0770");
        board.printer();
        System.out.println(Arrays.toString(board.getMovesOfPiece(7,0)));
        System.out.println(Arrays.toString(board.forcedMove(-1)));
    }
    
    
}
