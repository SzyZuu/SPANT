package spant.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SpantGUI extends JPanel {
    public SpantGUI(){
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new GridLayout(3, 1, 0, 0));

        JLabel empty = new JLabel();

        JLabel streamerLabel = new JLabel("Streamer live!");
        streamerLabel.setForeground(new Color(192, 192, 192));
        streamerLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        streamerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(streamerLabel);

        JLabel infoLabel = new JLabel("<html>Your PC will turn off automatically after the stream ends, with a small delay because of Twitch's API. To cancel, press the exit button.<html/>");
        infoLabel.setBorder(new EmptyBorder(0, 20, 5, 20));
        infoLabel.setForeground(new Color(160, 160, 160));
        infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(infoLabel);

        JLabel infoLabel2 = new JLabel("<html>You can close this window and the program will continue working in system tray.<html/>");
        infoLabel2.setBorder(new EmptyBorder(0, 20, 5, 20));
        infoLabel2.setForeground(new Color(160, 160, 160));
        infoLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        infoLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        add(infoLabel2);
    }
}
