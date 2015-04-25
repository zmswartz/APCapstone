import javax.swing.JFrame;
/**
 * A View for Checkers
 * 
 * @author zmswartz
 * @version 4/24/15
 */
public class CheckersViewer
{
    /**
     * The method to be ran to start a two person checkers game
     *
     */
    public static void main(String[] args)
    {
        JFrame frame = new CheckersFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(818,840);
        frame.setTitle("CheckersViewer");
        frame.setVisible(true);
    }
    
    
}
