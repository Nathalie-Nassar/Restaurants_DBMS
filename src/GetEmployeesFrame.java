import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

public class GetEmployeesFrame extends JFrame {
    public GetEmployeesFrame() {
        setBounds(100, 100, 500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JButton btn = new JButton();
        btn.setText("Get All Employees");
        btn.setBounds(12, 12, 250, 20);

        JTextArea j = new JTextArea(5,15);
        Font font = new Font("Verdana", Font.BOLD, 12);
        j.setFont(font);
        j.setForeground(Color.BLUE);
        btn.addActionListener(e -> {
            j.setBounds(12,34 , 450,450);
            try {
                j.setText("Employees List: \n"+Database.getEmployees());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        panel.add(btn);
        panel.add(j);
    }
}
