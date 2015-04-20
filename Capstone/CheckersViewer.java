import javax.swing.JFrame;

public class CheckersViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new CheckersFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(818,840);
        frame.setTitle("CheckersViewer");
        frame.setVisible(true);
    }
    
    
}
