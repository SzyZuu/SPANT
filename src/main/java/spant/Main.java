package spant;

import com.formdev.flatlaf.FlatDarkLaf;
import spant.GUI.MainGUI;
import spant.GUI.SpantGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Optional;

public class Main {

    JFrame window;
    MainGUI mainGUI;
    SpantGUI spantGUI;
    StreamCheck streamCheck;
    CardLayout cardLayout;
    JPanel mainPanel;

    public Main() {
        FlatDarkLaf.setup();
        cardLayout = new CardLayout();
        streamCheck = new StreamCheck(this);
        mainGUI = new MainGUI(this);
        spantGUI = new SpantGUI();
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(450, 300);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setTitle("SPANT");
        window.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/SPANT.png"))).getImage());

        mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);
        mainPanel.setBackground(UIManager.getColor("control"));

        mainPanel.add(mainGUI, "main");
        mainPanel.add(spantGUI, "spant");
        cardLayout.show(mainPanel, "main");

        window.setContentPane(mainPanel);
        window.getContentPane().setBackground(UIManager.getColor("control"));
        window.setVisible(true);
    }
    public static void main(String[] args){
        new Main();
    }

    public StreamCheck getStreamCheck(){
        return streamCheck;
    }

    public void changePane(){
        System.out.println("switching");
        cardLayout.show(mainPanel, "spant");
    }
}
