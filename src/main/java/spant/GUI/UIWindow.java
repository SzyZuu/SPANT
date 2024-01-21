package spant.GUI;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UIWindow extends JFrame {

    private JPanel contentPane;
    MainGUI mainGUI = new MainGUI();
    SpantGUI spantGUI = new SpantGUI();
    public UIWindow() {
        FlatDarkLaf.setup();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setTitle("SPANT");
        setVisible(true);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(UIManager.getColor("control"));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 0, 0));

        JLabel lblNewLabel = new JLabel("SPANT");
        lblNewLabel.setForeground(new Color(192, 192, 192));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel);
    }
}
