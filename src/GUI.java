import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class GUI extends JFrame {
    public GUI() {
        setBounds(100, 100, 300, 300);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel label = new JLabel();
        label.setText("Enter the location of the Lab: ");
        label.setBounds(12, 10, 250, 30);
        panel.add(label);

        JTextField field = new JTextField();
        field.setBounds(12, 45, 250, 25);
        panel.add(field);

        JButton btn = new JButton();
        btn.setText("Check");
        btn.setBounds(12, 80, 250, 20);

        JTextArea j = new JTextArea(5,5);
        Font font = new Font("Verdana", Font.BOLD, 12);
        j.setFont(font);
        j.setForeground(Color.BLUE);
        btn.addActionListener(e -> {
            String location = field.getText().trim();
            j.setBounds(12,100 , 250,250);
            j.setText("The technicians working with "+field.getText() +"\n are Melhem and Ahmad");
        });
        panel.add(btn);
        panel.add(j);
    }
}
