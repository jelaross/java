import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        textField = new JTextField();
        textField.setEditable(false);
        panel.add(textField, BorderLayout.NORTH);
        
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };
        
        ActionListener buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                
                if ("0123456789.".contains(command)) {
                    textField.replaceSelection(command);
                } else if ("+-*/".contains(command)) {
                    textField.replaceSelection(" " + command + " ");
                } else if ("=".equals(command)) {
                    calculate();
                }else if("C".equals(command)){
                    textField.setText("");
                }
            }
            
            private void calculate() {
                String input = textField.getText();
                String[] parts = input.split(" ");
                
                if (parts.length != 3) {
                    textField.setText("Error");
                    return;
                }
                
                double operand1 = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double operand2 = Double.parseDouble(parts[2]);
                
                double result = 0;
                switch (operator) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 == 0) {
                            textField.setText("Error: Division by zero");
                            return;
                        }
                        result = operand1 / operand2;
                        break;
                    case "C":
                        textField.setText("");
                        break;
                    default:
                        textField.setText("Error");
                        return;
                }
                
                textField.setText(String.valueOf(result));
            }
        };
        
        JPanel buttonPanel = new JPanel(new GridLayout(5, 3));
        
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }
        
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}
