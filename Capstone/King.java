

/**
 * Write a description of class King here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class King extends Piece
{
    /** description of instance variable x (add comment for each instance variable) */
    

    /**
     * Default constructor for objects of class King
     */
    public King(int teamNum)
    {
        // initialise instance variables
        super(teamNum);
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public String getType()
    {
        // put your code here
        return "King";
    }
    

    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
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
