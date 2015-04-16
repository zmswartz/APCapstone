

/**
 * Write a description of class Pieces here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piece
{
    /** description of instance variable x (add comment for each instance variable) */
    private int team;

    /**
     * Default constructor for objects of class Pieces
     */
    public Piece(int teamNum)
    {
        this.team = teamNum;
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
    public int getTeam()
    {
        return team;
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
    public String getType()
    {
        // put your code here
        return "Men";
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
        int[][] moves = new int[2][2];
        //[[ x right, up/down] , [xleft, up/down]]
        moves[0][0] = 1;
        moves[0][1] = team;
        moves[1][0] = -1;
        moves[1][1] = team;
        
        return moves;
    }


}
