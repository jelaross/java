import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MouseEvents extends JFrame implements MouseListener,
MouseMotionListener {
 private String txt = "";
 private int x = 10, y = 30;
 public MouseEvents() {
 setTitle("Mouse Events Handling");
 setSize(250, 250);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 JPanel panel = new JPanel() {
 @Override
 protected void paintComponent(Graphics g) {
 super.paintComponent(g);
 g.drawString(txt, 30, 40);
 }
 };
 panel.addMouseListener(this);
 panel.addMouseMotionListener(this);
 add(panel);
 setVisible(true);
 }
 @Override
 public void mouseClicked(MouseEvent me) {
 txt = "Mouse Clicked";
 getContentPane().setForeground(Color.pink);
 repaint();
 }
 @Override
 public void mouseEntered(MouseEvent me) {
 txt = "Mouse Entered";
 repaint();
 }
 @Override
 public void mouseExited(MouseEvent me) {
 txt = "Mouse Exited";
 getContentPane().setForeground(Color.blue);
 repaint();
 }
 @Override
 public void mousePressed(MouseEvent me) {
 txt = "Mouse Pressed";
 getContentPane().setForeground(Color.blue);
 repaint();
 }
 @Override
 public void mouseReleased(MouseEvent me) {
 txt = "Mouse Released";
 getContentPane().setForeground(Color.yellow);
 repaint();
 }
 @Override
 public void mouseMoved(MouseEvent me) {
 txt = "Mouse Moved";
 getContentPane().setForeground(Color.red);
 repaint();
 }
 @Override
 public void mouseDragged(MouseEvent me) {
 txt = "Mouse Dragged";
 getContentPane().setForeground(Color.green);
 repaint();
 }
 public static void main(String[] args) {
 SwingUtilities.invokeLater(MouseEvents::new);
 }
}