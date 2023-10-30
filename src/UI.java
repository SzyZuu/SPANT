import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JPanel implements ActionListener {

    protected JTextField tf;

    public void ui(){

        //Frame setup
        JFrame f = new JFrame("SPaNT");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);

        //menubar
        JMenuBar mb = new JMenuBar();
        JMenu mHelp = new JMenu("Help");
        mb.add(mHelp);

        //add text field
        tf = new JTextField();
        tf.addActionListener(this);

        //add content
        f.getContentPane().add(BorderLayout.NORTH, mb);
        f.getContentPane().add(BorderLayout.CENTER, tf);

        //set visible
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt){
        String text = tf.getText();
        Main.name = text;
    }
}
