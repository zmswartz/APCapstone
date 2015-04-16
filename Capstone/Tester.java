import java.util.Arrays;
public class Tester
{
    public static void main(String[] args)
    {
        CheckersBoard board = new CheckersBoard();
        board.printer();
        
        System.out.println("\n");
        System.out.println(Arrays.toString(board.getMovesOfPiece(1,2)));
//         board.makeMove("1223");
//         System.out.println("\n");
//         board.printer();
//         
//         board.makeMove("0514");
//         System.out.println("\n");
//         board.printer();
//         
//         board.makeMove("2305");
//         System.out.println("\n");
//         board.printer();
    }
    
    
}
