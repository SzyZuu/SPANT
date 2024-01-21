package spant.GUI;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class UIWindow {
    JFrame window;
    MainGUI mainGUI = new MainGUI();
    SpantGUI spantGUI = new SpantGUI();
    public UIWindow() {
        window = new JFrame();
        FlatDarkLaf.setup();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(450, 300);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setTitle("SPANT");

        window.setContentPane(mainGUI);
        window.getContentPane().setBackground(UIManager.getColor("control"));
        window.setVisible(true);
    }
}
