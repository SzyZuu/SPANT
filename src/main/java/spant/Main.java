package spant;

import com.formdev.flatlaf.FlatDarkLaf;
import spant.GUI.MainGUI;
import spant.GUI.SpantGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

public class Main {

    JFrame window;
    MainGUI mainGUI;
    SpantGUI spantGUI;
    StreamCheck streamCheck;
    CardLayout cardLayout;
    JPanel mainPanel;
    Image icon;

    public Main() {
        FlatDarkLaf.setup();
        cardLayout = new CardLayout();
        streamCheck = new StreamCheck(this);
        mainGUI = new MainGUI(this);
        spantGUI = new SpantGUI();
        window = new JFrame();

        try {
            icon = ImageIO.read(Objects.requireNonNull(getClass().getResource("/SPANT.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                window.setVisible(false);
                doSystemTray();
            }
        });

        window.setSize(450, 300);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setTitle("SPANT");
        window.setIconImage(icon);

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

    public void doSystemTray(){
        if (!SystemTray.isSupported()) {
            System.err.println("System Tray not supported");
            return;
        }

        Image trayIconPng;

        try {
            trayIconPng = ImageIO.read(Objects.requireNonNull(getClass().getResource("/sp16.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final PopupMenu popUp = new PopupMenu();

        SystemTray tray = SystemTray.getSystemTray();
        TrayIcon trayIcon = new TrayIcon(trayIconPng, "SPaNT");

        MenuItem exitItem = new MenuItem("Exit SPaNT");
        popUp.add(exitItem);

        trayIcon.setPopupMenu(popUp);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.err.println("Error adding tray icon: " + e.getMessage());
        }

        exitItem.addActionListener(e -> {
            tray.remove(trayIcon);
            System.exit(0);
        });
    }
}
