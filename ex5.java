import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RadioButton extends JFrame implements ItemListener {
 private CheckboxGroup chgp;
 private Checkbox choice1, choice2, choice3, choice4, choice5, choice6;
 private TextField text1;
 public RadioButton() {
 setTitle("Radio Selection");
 setSize(300, 200);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setLayout(new FlowLayout());
 String s = "List of PG degree";
 Label label = new Label(s, Label.CENTER);
 add(label);
 chgp = new CheckboxGroup();
 choice1 = new Checkbox("MBA", false, chgp);
 add(choice1);
choice1.addItemListener(this);
 choice2 = new Checkbox("MCA", false, chgp);
 add(choice2);
 choice2.addItemListener(this);
 choice3 = new Checkbox("M.COM", false, chgp);
 add(choice3);
 choice3.addItemListener(this);
 choice4 = new Checkbox("MSC", false, chgp);
 add(choice4);
 choice4.addItemListener(this);
 choice5 = new Checkbox("MA", false, chgp);
 add(choice5);
 choice5.addItemListener(this);
 choice6 = new Checkbox("MA", false, chgp);
 add(choice6);
 choice6.addItemListener(this);
 text1 = new TextField(20);
 add(text1);
 setVisible(true);
 }
 @Override
 public void itemStateChanged(ItemEvent e) {
 Checkbox selectedCheckbox = (Checkbox) e.getItemSelectable();
 if (selectedCheckbox == choice1) {
 text1.setText("MBA Selected");
 } else if (selectedCheckbox == choice2) {
 text1.setText("MCA Selected");
 } else if (selectedCheckbox == choice3) {
 text1.setText("M.COM Selected");
 } else if (selectedCheckbox == choice4) {
 text1.setText("MSC Selected");
 } else if (selectedCheckbox == choice5) {
 text1.setText("MA Selected");
 } else if (selectedCheckbox == choice6) {
 text1.setText("MA Selected");
 }
 }
 public static void main(String[] args) {
 SwingUtilities.invokeLater(RadioButton::new);
 }
}
