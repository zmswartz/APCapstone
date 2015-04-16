

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

}
