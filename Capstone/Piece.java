import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

/**
 * A class that represents a checkers piece
 * 
 * @author zmswartz
 * @version 4/24/15
 */
public class Piece
{
    private int team;

    /**
     * Default constructor for objects of class Pieces
     */
    public Piece(int teamNum)
    {
        this.team = teamNum;
    }

    /**
     * Returns the team value of the piece
     *
     * @return    the value of the team number
     */
    public int getTeam()
    {
        return team;
    }
    

    /**
     * Returns what type of piece this piece is
     *
     * @return  returns the name of the piece it is
     */
    public String getType()
    {
        // put your code here
        return "Men";
    }
    

    /**
     * Returns the directions that the piece can move as a 2D array
     *
     * @return  directions that the piece can move
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
