package spant.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SpantGUI extends JPanel {
    public SpantGUI(){
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new GridLayout(4, 1, 0, 0));

        JLabel empty = new JLabel();
        add(empty);
        add(empty);

        JLabel streamerLabel = new JLabel("Streamer live!");
        streamerLabel.setForeground(new Color(192, 192, 192));
        streamerLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        streamerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(streamerLabel);

        JLabel infoLabel = new JLabel("<html>Your PC will turn off automatically after the stream ends, with a small delay because of Twitch's API. To cancel, just close this window.<html/>");
        infoLabel.setBorder(new EmptyBorder(0, 20, 5, 20));
        infoLabel.setForeground(new Color(160, 160, 160));
        infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(infoLabel);
    }
}
