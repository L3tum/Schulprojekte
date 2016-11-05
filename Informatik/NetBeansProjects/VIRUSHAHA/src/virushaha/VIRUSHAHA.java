/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package virushaha;

/**
 *
 * @author Letum
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 27.11.2014
  * @author Leturn 
  */

public class VIRUSHAHA {

public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JPanel contentPane = new JPanel();
                contentPane.setBackground(Color.BLUE);
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                contentPane.setBounds(0, 0, d.width, d.height);
 
                final JLayeredPane layeredPane = new JLayeredPane();
                layeredPane.add(contentPane, new Integer(0));
                layeredPane.setPreferredSize(contentPane.getSize());
 
                final JButton button = new JButton("VIRUSHAHAHAHAHA");
                button.setSize(1000, 600);
                button.setLocation(d.width / 8, d.height / 8);
                button.setVisible(true);
 
                contentPane.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        if (button.getBounds().contains(e.getPoint())) {
                            layeredPane.add(button, new Integer(1));
                        } else {
                            layeredPane.remove(button);
                            layeredPane.repaint();
                        }
                    }
                });
 
                JFrame frame = new JFrame("VIRUSHAHAHAHA");
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.setAlwaysOnTop(true);
                frame.setResizable(false);
                frame.setContentPane(layeredPane);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
 
}
