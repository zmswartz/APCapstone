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
        getMovesOfPiece(7,0);
    }
    
    
}
