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
 * A Jcomponent that contains a CheckersBoard Object
 * 
 * @author zmswartz
 * @version 4/24/15
 */
public class CheckersComponent extends JComponent
{
    CheckersBoard board;
    /**
     * Default constructor for a CheckersComponent
     */
    public CheckersComponent()
    {
        board = new CheckersBoard();
        MouseListener l = new MousePressListener();

        addMouseListener(l);

    }

    /**
     * Paints the component
     *
     * @param  g  a graphics object
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        board.draw(g2);
    }

    class MousePressListener implements MouseListener
    {
        /**
         * An unused method
         */
        public void mousePressed(MouseEvent event){}

        /**
         * An unused method
         */
        public void mouseReleased(MouseEvent event) {}

        /**
         * Makes an action every time the mouse is clicked
         *
         * @param  event the mouse event
           */
        public void mouseClicked(MouseEvent event) 
        {

            int x = event.getX()/100;
            int y = event.getY()/100;

            board.actionAt(x,y, board.getCurrentPlayer());

            repaint();

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

            board.continuePlay();

            
        }

        /**
         * An unused method
         */
        public void mouseEntered(MouseEvent event) {}

        /**
         * An unused method
         */
        public void mouseExited(MouseEvent event) {}
    }
}
