package spant.GUI;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainGUI extends JPanel {
    JTextField textField;
    public MainGUI(){
        doGUI();
    }
    public void doGUI(){
        FlatDarkLaf.setup();
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new GridLayout(2, 1, 0, 0));

        JLabel spantLabel = new JLabel("SPANT");
        spantLabel.setForeground(new Color(192, 192, 192));
        spantLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        spantLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(spantLabel);

        JPanel bottomPanel = new JPanel();
        add(bottomPanel);
        bottomPanel.setLayout(new GridLayout(2, 0, 0, 0));

        JPanel textPanel = new JPanel();
        bottomPanel.add(textPanel);

        textField = new JTextField();
        textPanel.add(textField);
        textField.setColumns(20);

        JPanel buttonPanel = new JPanel();
        bottomPanel.add(buttonPanel);

        JButton btnNewButton = new JButton("New button");
        JButton btnNewButton_1 = new JButton("New button");

        buttonPanel.add(btnNewButton);
        buttonPanel.add(btnNewButton_1);
    }
}
