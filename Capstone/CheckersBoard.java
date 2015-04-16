import java.util.ArrayList;
/**
 * Write a description of class CheckersBoard here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CheckersBoard
{
    /** description of instance variable x (add comment for each instance variable) */
    private Piece[][] game;

    /**
     * Default constructor for objects of class CheckersBoard
     */
    public CheckersBoard()
    {
        // initialise instance variables
        game = new Piece[8][8];
        makeBoard();
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
    public Piece getPieceAt(int x, int y)
    {
        // put your code here
        return game[y][x];
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
    public void makeMove(String move)
    {
        // put your code here
        int oldX = Integer.parseInt(move.substring(0,1));
        int oldY = Integer.parseInt(move.substring(1,2));
        int x = Integer.parseInt(move.substring(2,3));
        int y = Integer.parseInt(move.substring(3));
        Piece temp = game[oldY][oldX];
        game[oldY][oldX] = null;
        game[y][x] = temp;
        if(Math.abs(oldY - y) > 1)
        {
            game[(y+oldY)/2][(x+oldX)/2] = null;
        }

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
    public boolean isPossibleMove(int player)
    {
        // put your code here
        return false;
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
    public String[] forcedMove(int player)
    {
        // put your code here
        ArrayList<String> forced = new ArrayList<String>();
        for(int y = 0 ; y < game.length; y++)
        {
            for(int x = 0; x < game[0].length; x++)
            {
                Piece temp = getPieceAt(x,y);
                if(temp!= null && temp.getTeam() == player)
                {
                    int[][] directions = temp.getMoveDirections();
                    for(int i = 0; i < directions.length; i++)
                    {

                        int newX = x + directions[i][0];
                        int newY = y + directions[i][1];
                        if(newX > 0 && newX < 7 && newY > 0 && newY < 7 && getPieceAt(newX, newY) !=null)
                        {
                            int newX2 = newX + directions[i][0];
                            int newY2 = newY + directions[i][1];
                            if(newX2 > 0 && newX2 < 7 && newY2 > 0 && newY2 < 7 && getPieceAt(newX2, newY2) ==null)
                            {
                                String thisMove = "";
                                thisMove += x;
                                thisMove += y;
                                thisMove += (newX2);
                                thisMove += (newY2);
                                forced.add(thisMove);
                            }
                        }

                    }
                }
            }
        }
        String[] forcedArray = new String[forced.size()];
        for(int i = 0; i < forcedArray.length; i++)
        {
            forcedArray[i] = forced.get(i);
        }
        return forcedArray;
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
    public void makeBoard()
    {
        // put your code here
        for(int i = 0 ; i< 3; i = i+2)
        {
            for (int j = 1 ; j < 8; j = j+2)
            {
                game[i][j] = new Piece(1);
            }
        }

        for (int j = 0 ; j < 8; j = j+2)
        {
            game[1][j] = new Piece(1);
        }

        for (int j = 1 ; j < 8; j = j+2)
        {
            game[6][j] = new Piece(-1) ;
        }

        for(int i = 5 ; i< 8; i = i+2)
        {
            for (int j = 0 ; j < 8; j = j+2)
            {
                game[i][j] = new Piece(-1);
            }
        }
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
    public String[] getMovesOfPiece(int x, int y)
    {
        // put your code here
        Piece temp = getPieceAt(x,y);
        int[][] directions = temp.getMoveDirections();
        String[] moves = new String[directions.length];
        int movesIndex = 0;
        for(int i = 0; i < directions.length; i++)
        {
            if(x+directions[i][0] < 0 || x+directions[i][0] > 7 || y+directions[i][1] < 0 
            || y+directions[i][1] > 7 || getPieceAt(x+directions[i][0],y+directions[i][1]) != null )
            {
                String[] moves2 = new String[moves.length -1];
                for(int z = 0; z < moves.length-1; z++)
                    moves2[z] = moves[z];
                moves = moves2;
            }
            else
            {
                String thisMove = "";
                thisMove += x;
                thisMove += y;
                thisMove += (x+directions[i][0]);
                thisMove += (y+directions[i][1]);
                moves[movesIndex] = thisMove;
                movesIndex++;
            }
        }

        return moves;
    }

    
    public void printer()
    {
        for (int i = 0; i <8 ; i++)
        {
            for (int j = 0; j <8 ; j++)
            {
                if( game[i][j] != null)
                    System.out.print(game[i][j].getTeam() + "\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }
}
