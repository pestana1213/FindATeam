import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Set;
import java.util.stream.Collectors;

public class Menu{

    public static void main(String[] args) {
        displayWindow();
    }
    private static void displayWindow() {
        JFrame frame = new JFrame("Find A Team");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextField tf=new JTextField();
        frame.setBackground(Color.blue);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        BorderLayout borderLayout = new BorderLayout();
        panel.setLayout(borderLayout);
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        JButton b = new JButton("Registar");
        Font f1 = new Font("Arial",Font.BOLD,15);
        JButton c = new JButton("Login");
        b.setFont(f1);
        c.setFont(f1);
        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        dataPanel.add(b,BorderLayout.EAST);
        dataPanel.add(c,BorderLayout.WEST);
        dataPanel.add(tf);


        panel.add(dataPanel, BorderLayout.CENTER);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);


    }
}
