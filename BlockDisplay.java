/**
 * BlockDisplay class provided for Tetris project
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

// Used to display the contents of a game board
public class BlockDisplay implements KeyListener
{
    private static final Color BACKGROUND = Color.BLACK;

    private BoundedGrid<Block> board;
    private JFrame frame;
    private ArrowListener listener;
    private BufferedImage image;
    private boolean ree;

    public BlockDisplay(BoundedGrid<Block> board)
    {
        this.board = board;
        ree = false;  
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    createAndShowGUI();
                }
            });

        //Wait until display has been drawn
        try
        {
            while (frame == null || !frame.isVisible())
                Thread.sleep(1);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI()
    {
        frame = new JFrame();
        int x = board.getNumCols()*30;
        int y = board.getNumRows()*30;
        image = new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.add(new JLabel(new ImageIcon(image)));
        showBlocks();
        frame.pack();
        frame.setVisible(true);

    }

    public void visible()
    {
        frame.setVisible(!frame.isVisible());
    }

    public void setRee(boolean r){
        ree = r;
    }

    //Redraws the board to include the pieces and border colors.
    public void showBlocks()
    {
        Graphics2D graphics = image.createGraphics();
        if(ree){
            Color c= new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
            graphics.setColor(c);
        }
        else{
            graphics.setColor(BACKGROUND);
        }
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        graphics.setColor(new Color(150,0,255));
        graphics.drawRect(0, 0, image.getWidth()-1, image.getHeight()-1);
        graphics.dispose();

        for (int row = 0; row < board.getNumRows(); row++)
            for (int col = 0; col < board.getNumCols(); col++)
            {
                Location loc = new Location(row, col);
                Block square = board.get(loc);
                if (square != null)
                {
                    graphics = image.createGraphics();
                    graphics.setColor(square.getColor());
                    graphics.fillRect(col*30+1, row*30+1, 28, 28);
                    /**graphics.setColor(Color.BLACK);
                    graphics.fillRect(col*30+2, row*30+2, 26, 26);*/
                    graphics.dispose();

                }
            }
        frame.repaint();

    }

    // Sets the title of the window.
    public void setTitle(String title)
    {
        frame.setTitle(title);
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
        if (listener == null)
            return;
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT)
            listener.leftPressed();
        else if (code == KeyEvent.VK_RIGHT)
            listener.rightPressed();
        else if (code == KeyEvent.VK_DOWN)
            listener.downPressed();
        else if (code == KeyEvent.VK_UP)
            listener.upPressed();
        else if (code == KeyEvent.VK_SPACE)
            listener.spacePressed();
        else if (code == KeyEvent.VK_ESCAPE)
            listener.escPressed();
        else if (code == KeyEvent.VK_O)
            listener.oPressed();
        else if (code == KeyEvent.VK_P)
            listener.pPressed();
        else if (code == KeyEvent.VK_R)
            listener.rPressed();
        else if (code == KeyEvent.VK_C)
            listener.cPressed();
        else if (code == KeyEvent.VK_M)
            listener.mPressed();
        else if (code == KeyEvent.VK_1)
            listener.onePressed();
        else if (code == KeyEvent.VK_2)
            listener.twoPressed();
        else if (code == KeyEvent.VK_3)
            listener.threePressed();
        else if (code == KeyEvent.VK_4)
            listener.fourPressed();
        else if (code == KeyEvent.VK_S)
            listener.sPressed();
        else if (code == KeyEvent.VK_I)
            listener.iPressed();
        else if (code == KeyEvent.VK_T)
            listener.tPressed();
        else if (code == KeyEvent.VK_D)
            listener.dPressed();
        else if (code == KeyEvent.VK_A)
            listener.aPressed();
        else if (code == KeyEvent.VK_Q)
            listener.qPressed();
        else if (code == KeyEvent.VK_W)
            listener.wPressed();
        else if (code == KeyEvent.VK_G)
            listener.gPressed();
        else if (code == KeyEvent.VK_V)
            listener.vPressed();
    }

    public void setArrowListener(ArrowListener listener)
    {
        this.listener = listener;
    }

}