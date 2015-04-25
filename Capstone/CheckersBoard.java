import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

/**
 * Write a description of class CheckersBoard here
 * 
 * @author zmswartz
 * @version 4/24/15
 */
public class CheckersBoard
{
    
    private Piece[][] game;
    private int xcord;
    private int ycord;
    private int height;
    private int width;
    private Color col1;
    private Color col2;
    private int length;
    private int[] locationSelected;
    private int currentPlayer;
    private boolean isForcedMove;
    /**
     * Default constructor for objects of class CheckersBoard
     */
    public CheckersBoard()
    {
        // initialise instance variables
        game = new Piece[8][8];
        makeBoard();
        this.xcord = 0;
        this.ycord = 0;
        this.height = 800;
        this.width = 800;
        this.col1 = Color.GRAY;
        this.col2 = Color.WHITE;
        this.length = 100;
        currentPlayer = -1;
        isForcedMove = false;
    }

    /**
     * Returns the number that represents the current player
     *
     * @pre     the CheckersBoard object is initialized
     * @return  the number of the current player
     */
    public int getCurrentPlayer()
    {
        // put your code here
        return currentPlayer;
    }

    /**
     * Changes the current player to the other player
     *
     * @pre     the CheckersBoard object is initialized
     * @post    currentPlayer has been changed to the other player
     */
    public void changePlayer()
    {
        if (currentPlayer == -1)
        {
            currentPlayer = 1;
            return;
        }
        currentPlayer = -1;
        
    }
    

    /**
     * Prints the current player's color
     *
     * @pre     the CheckersBoard object is initialized
     * @post    prints out the current player
     */
    public void displayCurrentPlayer()
    {
        // put your code here
        String player;
        if(getCurrentPlayer() == -1)
        {
            player = "Red's Turn";
        }
        else
            player = "Black's Turn";
        System.out.println(player);
    }


    /**
     * Returns the piece at the x and y value
     *
     * @pre        the CheckersBoard object is initialized
     * @param    x    the x coordinate
     *  @param         y    the y coordinate
     * @return    the piece at the x and y value
     */
    public Piece getPieceAt(int x, int y)
    {
        // put your code here
        return game[y][x];
    }

    /**
     * Makes the move that is passed in and removes a piece if it is jumped over
     *
     * @pre     the CheckersBoard object is initialized
     * @post    a piece is moved from one location to another
     * @param   move   the move to be made in the format of oldX + oldY + newX + newY as a String
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
        makeKing();
        isGameOver();
    }

    /**
     * Checks if there is a possible move to be made for a given player
     *
     * @pre     the CheckersBoard object is initialized
     * @param   player   the value of the player
     * @return  true if there is a possible move, false if not
     */
    public boolean isPossibleMove(int player)
    {
        // put your code here
        return forcedMove(player).length!=0 || getAllMoves(player).length!=0;
    }

    /**
     * Returns a list of all of the possible forced moves a player must make
     *
     * @pre     the CheckersBoard object is initialized
     * @param   player   the value of the player
     * @return  an array of all of the forced moves of a given player
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
                            if(getPieceAt(newX, newY).getTeam() !=player)
                            {
                                if(newX2 >= 0 && newX2 <= 7 && newY2 >= 0 && newY2 <= 7 && getPieceAt(newX2, newY2) ==null)
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
        }
        String[] forcedArray = new String[forced.size()];
        for(int i = 0; i < forcedArray.length; i++)
        {
            forcedArray[i] = forced.get(i);
        }
        return forcedArray;
    }

    /**
     * Sets the game array to initial state
     *
     * @pre     the CheckersBoard object is initialized
     * @post    game array is at its initial state
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
     * Returns an array with all of the possible moves of a given piece
     *
     * @pre     the CheckersBoard object is initialized
     * @param   x   the x coordinate of the piece
     * @param         y   the y coordinate of the piece
     * @return  an array of all of the moves of a piece
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

    /**
     * Returns all of the possible moves a player can make
     *
     * @pre     the CheckersBoard object is initialized
     * @param   player   the value of the current player
     * @return  an array of all of the moves the player can make
     */
    public String[] getAllMoves(int player)
    {
        // put your code here
        ArrayList<String> moves = new ArrayList<String>();
        for(int y = 0; y < game.length; y++)
        {
            for(int x = 0; x < game[0].length; x++)
            {
                if(getPieceAt(x,y) != null && getPieceAt(x,y).getTeam() == player)
                {
                    String[] temp = getMovesOfPiece(x,y);
                    for(int i = 0; i < temp.length; i++)
                    {
                        moves.add(temp[i]);
                    }
                }
            }
        }

        String[] movesArray = new String[moves.size()];
        for(int i = 0; i < movesArray.length; i++)
        {
            movesArray[i] = moves.get(i);
        }
        return movesArray;
    }
    
    /**
     * A method used during the early stages of testing which prints the pieces as 1 or -1 and puts tabs between them
     *
     * @pre     the CheckersBoard object is initialized
     * @post    prints out the current state of the board
     */
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
    
    /**
     * Draws the current state of the board. Kings are drawn with white boxes inside of them
     *
     * @pre     the CheckersBoard object is initialized
     * @post    the current state of the board is draws
     * @param   g2   a Graphics2D object to draw with
     */
    public void draw(Graphics2D g2)
    {
        // put your code here
        g2.setColor(Color.GRAY);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(this.xcord,this.ycord,
                this.width,this.height);
        g2.draw(rect1);
        g2.setColor(col1);
        g2.fill(rect1);    
        g2.setColor(col2);
        for(int i = 0; i < 8; i++)
        {
            for( int j = 0 ; j < 8; j= j+2)
            {
                Rectangle2D.Double rect2 =new Rectangle2D.Double(j*100,i*100,
                        this.length,this.length);
                g2.draw(rect2);
                g2.fill(rect2);
            }
            i++;
            for( int j = 1 ; j < 8; j= j+2)
            {
                Rectangle2D.Double rect2 =new Rectangle2D.Double(j*100,i*100,
                        this.length,this.length);
                g2.draw(rect2);
                g2.fill(rect2);
            }
        }

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                Piece temp = getPieceAt(j,i);
                g2.setColor(Color.RED);
                if(temp != null)
                {
                    if(temp.getTeam() == 1)
                    {
                        g2.setColor(Color.BLACK);
                    }
                    Ellipse2D.Double ell = new Ellipse2D.Double(j*100, i*100, this.length, this.length);
                    g2.fill(ell);
                    if(temp.getType().compareTo("King") == 0)
                    {
                        Rectangle2D.Double rect2 =new Rectangle2D.Double(j*100 +40 ,i*100 +40,
                                20,20);
                        g2.setColor(Color.WHITE);
                        g2.fill(rect2);
                    }
                }
            }
        }
    }

    /**
     * Does the proper action based on what the current location selected is
     *
     * @pre     the CheckersBoard object is initialized
     * @post    the proper action is made based on what the previous action was
     * @param   x   x coordinate of the event
     * @param         y   y coordinate of the event
     * @param         player   the value of the player
     */
    public void actionAt(int x, int y, int player)
    {
        if(locationSelected == null || getPieceAt(locationSelected[0] , locationSelected[1]) == null
        || getPieceAt(locationSelected[0] , locationSelected[1]).getTeam()!= player)
        {
            locationSelected = new int[] {x, y};
        }
        else
        {
            if( getPieceAt(locationSelected[0],locationSelected[1]).getTeam() == player)
            {
                String thisMove = "";
                thisMove += locationSelected[0]; thisMove += locationSelected[1];thisMove += x; thisMove += y;
                String[] moves;
                if(isForcedMove)
                {
                    moves = forcedMove(currentPlayer);
                }
                else
                {
                    moves = getMovesOfPiece(locationSelected[0] ,locationSelected[1]);
                }
                for(int i = 0; i < moves.length; i++)
                {
                    if( moves[i].compareTo(thisMove) == 0)
                    {
                        makeMove(thisMove);
                        if((isForcedMove && forcedMove(currentPlayer).length==0)|| !isForcedMove )
                        {
                            changePlayer();
                        }

                    }

                }
            }
            locationSelected = null;

        }
    }

    /**
     * Continues the game after a move is made.  Prints the current player and if a move is forced.
     *
     * @pre     the CheckersBoard object is initialized
     * @post    the current player has been printed and isForcedMove has been updated
     */
    public void continuePlay()
    {
        displayCurrentPlayer();
        if(forcedMove(currentPlayer).length!=0)
        {
            
            
            System.out.println("There is a forced move");
            isForcedMove = true;
            return;
        }

        isForcedMove = false;
    }

    /**
     * Checks if any piece is in the other teams kings row.  If there is, it makes it a king piece
     *
     * @pre     the CheckersBoard object is initialized
     * @post    any piece in the other teams king's row has become a king
     */
    public void makeKing()
    {
        // put your code here
        for(int j = 0; j < game[0].length; j++)
        {
            Piece temp = getPieceAt(j,0);
            if(temp != null && temp.getTeam() == -1)
            {
                game[0][j] = new King(-1);
            }
        }

        for(int j = 0; j < game[0].length; j++)
        {
            Piece temp = getPieceAt(j,game.length -1);
            if(temp != null && temp.getTeam() == 1)
            {
                game[game.length-1][j] = new King(1);
            }
        }
    }

    /**
     * Checks if the game is over
     *
     * @pre     the CheckersBoard object is initialized
     * @post    if the game is over, the winner is printed
     */
    public void isGameOver()
    {
        // put your code here
        boolean player1 = true;
        boolean player2 = true;
        for(int i = 0; i < game.length; i++)
        {
            for(int j = 0; j < game.length; j++)
            {
                Piece temp = getPieceAt(j,i);
                if(temp != null)
                {
                    if(temp.getTeam() == 1)
                    {
                        player1 =false;
                    }
                    else
                    {
                        player2 = false;
                    }
                }
            }
        }
        if(player1)
        {
            System.out.println("Red Player Wins");
        }

        if(player2)
        {
            System.out.println("Black Player Wins");
        }
    }

}
