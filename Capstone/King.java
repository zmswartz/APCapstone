

/**
 * Write a description of class King here.
 * 
 * @author (zmswartz
 * @version 4/24/15
 */
public class King extends Piece
{
    
    

    /**
     * Default constructor for objects of class King
     */
    public King(int teamNum)
    {
        // initialise instance variables
        super(teamNum);
    }

    /**
     * Returns what type of piece this piece is
     *
     * @return  returns the name of the piece it is
     */
    public String getType()
    {
        // put your code here
        return "King";
    }
    

    /**
     * Returns the directions that the piece can move as a 2D array
     *
     * @return  directions that the piece can move
     */
    public int[][] getMoveDirections()
    {
        int[][] moves = new int[4][2];
        //[[ x right, up/down] , [xleft, up/down]]
        moves[0][0] = 1;
        moves[0][1] = 1;//right down
        moves[1][0] = -1;
        moves[1][1] = 1;//left down
        moves[2][0] = 1;
        moves[2][1] = -1;// right up
        moves[3][0] = -1;
        moves[3][1] = -1;//left up
        return moves;
    }

}
