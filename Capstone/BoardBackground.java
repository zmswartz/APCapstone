import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

/**
 * A class which creates and draw a building with windows
 * 
 * @author (zmswartz) 
 * @version (10/1/14)
 */
public class BoardBackground
{
    /** xcord    the x cordinate of the top left corner of the building*/
    /** ycord    the y cordinate of the top left corner of the building*/
    /** height   the height of the building*/
    /** width    the width of the building*/
    /** col1     the color of the building*/
    /** col2     the color of the windows on the buildings*/
    private int xcord;
    private int ycord;
    private int height;
    private int width;
    private Color col1;
    private Color col2;
    private int length;

    /**
     * Default constructor for objects of class Building
     * @pre     all numberical values are positive integers
     * @param   x   the x cordinate of the top left corner of the building
     * @param   y   the y cordinate of the top left corner of the building
     * @param   hei the height of the building
     * @param   wid the width of the building
     * @param   color1 the color of the building
     * @param   color2 the color of the windows on the building
     */
    public BoardBackground()
    {
        // initialise instance variables
        this.xcord = 0;
        this.ycord = 0;
        this.height = 800;
        this.width = 800;
        this.col1 = Color.BLACK;
        this.col2 = Color.WHITE;
        this.length = 100;
    }

    /**
     * The draw method draws the building object based on the attributes
     * provided in the constructor
     *
     * @param    g2    a Graphics2D object
     */
    public void draw(Graphics2D g2)
    {
        // put your code here
        g2.setColor(Color.BLACK);
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
                                        
                                        
                                        
                                        
    }

}
