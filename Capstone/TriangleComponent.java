import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;


/**
 * Write a description of class RectangleComponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TriangleComponent extends JComponent
{
    
    CheckersBoard board;
    public TriangleComponent()
    {
        board = new CheckersBoard();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        BoardBackground b1 = new BoardBackground();
        b1.draw(g2);
    }
   
    
    
}
