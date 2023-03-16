import javax.swing.*;
import java.awt.*;
public class Paint {
    JFrame frame;
    JPanel menupanel;
    JButton button;
    JButton[] colorlist, figurelist;
    Container canvas;
    Canvas c;
    Dimension size;
    JTextField textbox;
    public Paint()
    {
        size = Toolkit.getDefaultToolkit().getScreenSize();
        colorlist = new JButton[12];
        figurelist = new JButton[6];
        c = new Canvas();
        frame = new JFrame("Paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension((int)size.getWidth() + 15,(int) size.getHeight()));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        menupanel = new JPanel();
        menupanel.setPreferredSize(new Dimension(0,60));
        menupanel.setBackground(Color.LIGHT_GRAY);
        menupanel.setLayout(null);

        textbox = new JTextField(20);
        textbox.addActionListener(e-> c.text = textbox.getText());
        textbox.setBounds(520,1,200,58);
        menupanel.add(textbox);
        for(int i = 0; i < 12; i++)
        {
            final int x = i;
            button = new JButton();
            button.setBounds((i % 6) * 29,((i / 6) % 2) * 30 + 2,28,28);
            button.setBackground(c.colors[i]);
            button.addActionListener(e -> c.color(x));
            colorlist[i] = button;
            menupanel.add(colorlist[i]);
        }

        for(int i = 0; i < 4; i++)
        {
            button = new JButton();
            button.setBounds(200 + i * 60,2,58,58);
            switch (i) {
                case 0 :
                {
                    button.addActionListener(e -> c.action = 0);
                    button.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\raluc\\OneDrive\\Desktop\\Intellij\\Line.jpg").getImage().getScaledInstance(58,58,Image.SCALE_SMOOTH)));
                    break;
                }
                case 1 :
                {
                    button.addActionListener(e -> c.action = 1);
                    button.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\raluc\\OneDrive\\Desktop\\Intellij\\Rectangle.jpg").getImage().getScaledInstance(58,58,Image.SCALE_SMOOTH)));
                    break;
                }
                case 2 :
                {
                    button.addActionListener(e -> c.action = 2);
                    button.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\raluc\\OneDrive\\Desktop\\Intellij\\Oval.jpg").getImage().getScaledInstance(58,58,Image.SCALE_SMOOTH)));
                    break;
                }
                case 3 :
                {
                    button.addActionListener(e -> c.action = 3);
                    button.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\raluc\\OneDrive\\Desktop\\Intellij\\Text.jpg").getImage().getScaledInstance(58,58,Image.SCALE_SMOOTH)));
                    break;
                }
                case 4 :
                {
                    button.addActionListener(e -> c.action = 4);
                    button.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\raluc\\OneDrive\\Desktop\\Intellij\\Polygon.jpg").getImage().getScaledInstance(58,58,Image.SCALE_SMOOTH)));
                    break;
                }
            }
            figurelist[i] = button;
            menupanel.add(figurelist[i]);
        }
        /* JButton filled = new JButton();
        filled.setBackground(Color.WHITE);
        filled.addActionListener(e-> {
            if(c.filled)
            {
                c.filled = false;
                filled.setBackground(Color.WHITE);
            }
            else
            {
                c.filled = true;
                filled.setBackground(Color.BLACK);
            }
        });
        filled.setBounds(560,1,58,58);
        filled.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\raluc\\OneDrive\\Desktop\\Intellij\\text.jpg").getImage().getScaledInstance(58,58,Image.SCALE_SMOOTH))); */
       //menupanel.add(filled);
        canvas = frame.getContentPane();
        canvas.setBackground(Color.GRAY);
        canvas.setLayout(new BorderLayout());
        canvas.add(c,BorderLayout.CENTER);
        canvas.add(menupanel,BorderLayout.PAGE_START);
        frame.setContentPane(canvas);
        //frame.pack();
        frame.setVisible(true);
    }
}