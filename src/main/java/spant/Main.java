package spant;

import com.formdev.flatlaf.FlatDarkLaf;
import spant.GUI.MainGUI;
import spant.GUI.SpantGUI;

import javax.swing.*;

public class Main {

    JFrame window;
    MainGUI mainGUI;
    SpantGUI spantGUI;
    StreamCheck streamCheck;
    public Main() {
        mainGUI = new MainGUI(this);
        spantGUI = new SpantGUI();
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
    public static void main(String[] args){
        new Main();
    }

    public StreamCheck getStreamCheck(){
        return streamCheck;
    }
}
