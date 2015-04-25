import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * A JFrame that contains a CheckersCompoponent object
 * 
 * @author zmswartz
 * @version 4/24/15
 */
public class CheckersFrame extends JFrame
{
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 800;
    private CheckersComponent scene;
    
    /**
     * Default constructor for objects of class CheckersFrame
     */
    public CheckersFrame()
    {
        JLabel label = new JLabel("T");
        scene = new CheckersComponent();
        add(scene);
        
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        add(label);
        add(scene);
        
        
        
        
    }
    
    

}
