import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Picture extends JPanel implements MouseListener {
 private int x, y;
 private Image img;
 public Picture() {
 super();
 addMouseListener(this);
 img = Toolkit.getDefaultToolkit().getImage("Picture.jpg");
 }
 @Override
 protected void paintComponent(Graphics g) {
 super.paintComponent(g);
 g.drawString("x-axis=" + x + ", y-axis=" + y, x, y);
 g.drawImage(img, x, y, this);
 }
@Override
 public void mouseClicked(MouseEvent me) {
 x = me.getX();
 y = me.getY();
 repaint();
 }
 // Unused MouseListener methods
 @Override
 public void mouseEntered(MouseEvent me) {}
 @Override
 public void mouseExited(MouseEvent me) {}
 @Override
 public void mousePressed(MouseEvent me) {}
 @Override
 public void mouseReleased(MouseEvent me) {}
 public static void main(String[] args) {
 SwingUtilities.invokeLater(() -> {
 createAndShowGUI();
 });
 }
 private static void createAndShowGUI() {
 JFrame frame = new JFrame("Picture App");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 Picture panel = new Picture();
 frame.add(panel);
 frame.setSize(600, 600);
 frame.setVisible(true);
 }
}