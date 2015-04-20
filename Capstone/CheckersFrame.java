import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class CheckersFrame extends JFrame
{
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 800;
    private CheckersComponent scene;
    /**
     * Default constructor for objects of class TriangleFrame
     */
    public CheckersFrame()
    {
        scene = new CheckersComponent();
        add(scene);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        
        
        
        
        
    }
    
    

}
