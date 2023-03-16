import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Canvas extends JComponent {
    public Graphics2D gr;
    public Image img;
    public Color[] colors = {
            Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY,
            Color.WHITE, Color.BLUE, Color.CYAN, Color.GREEN,
            Color.ORANGE, Color.RED, Color.YELLOW, Color.MAGENTA};
    private int firstX, secondX , firstY, secondY;
    boolean ok = true;
    int action = 0;
    //boolean filled = false;
    String text;
    @Override
    protected void paintComponent(Graphics g) {
        if(img == null)
        {
            img = createImage(getSize().width, getSize().height);
            gr = (Graphics2D) img.getGraphics();
            gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //clear();
        }
        g.drawImage(img,0,0,null);
    }
    public Canvas() {
        setDoubleBuffered(false);
        //int[] ptsx = new int[100];
        //int[] ptsy = new int[100];
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // save coord x,y when mouse is pressed
                if(ok) {
                    firstX = e.getX();
                    firstY = e.getY();
                    ok = false;
                }
                else
                {
                    secondX = e.getX();
                    secondY = e.getY();
                    switch (action) {
                        case 0:
                        {
                            gr.drawLine(firstX, firstY, secondX, secondY);
                            break;
                        }
                        case 1:
                        {
                            Rectangle rec = new Rectangle(Math.min(firstX, secondX), Math.min(firstY, secondY), Math.abs(firstX - secondX), Math.abs(firstY - secondY));
                            gr.draw(rec);
                            break;
                        }
                        case 2:
                        {
                            gr.drawOval(Math.min(firstX, secondX), Math.min(firstY, secondY), Math.abs(firstX - secondX), Math.abs(firstY - secondY));
                            break;
                        }
                        case 3:
                        {
                            gr.drawString(text,firstX,firstY);
                            break;
                        }
                    }
                    repaint();
                    ok = true;
                }
            }
        });
        //if(action == 3)
        //{
        //MouseAdapter ad = new MouseAdapter() {
        //    int i =0;
        //};
        //while(SwingUtilities.isLeftMouseButton(e))
        //addMouseListener(new MouseAdapter() {
        //});
        //
        //if(SwingUtilities.isLeftMouseButton(e))
        //{
        //    System.out.println(e.getX()+""+e.getY());
        //    ptsx[i] = e.getX();
        //    ptsy[i] = e.getY();
        //    i++;
        //    System.out.println(i);
        //}
        //System.out.println(i);
        //if(SwingUtilities.isRightMouseButton(e)) {
        //    if (filled) {
        //        Polygon pol = new Polygon(ptsx, ptsy, i);
        //        gr.draw(pol);
        //        gr.fill(pol);
        //    } else {
        //        Polygon pol = new Polygon(ptsx, ptsy, i);
        //        gr.draw(pol);
        //    }
        //}
        //repaint();
        //}
    }

    /*public void clear()
    {
        gr.setPaint(Color.white);
        gr.fillRect(0,0,getSize().width, getSize().height);
        gr.setPaint(Color.black);
        repaint();
    }*/

    public void color(int ind)
    {
        gr.setColor(colors[ind]);
    }
}