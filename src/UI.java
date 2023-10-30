import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.swingx.prompt.PromptSupport;

public class UI extends JPanel implements ActionListener {

    protected JTextField tf;

    public void ui(){

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            System.out.println("umm it doesn't support feelings");
        }
        catch (ClassNotFoundException e) {
            System.out.println("The class is poof");
        }
        catch (InstantiationException e) {
            System.out.println("Instance noodles");
        }
        catch (IllegalAccessException e) {
            System.out.println("That's illegal");
        }

        //Frame setup
        JFrame f = new JFrame("SPaNT");
        JPanel p = new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);

        //menubar
        JMenuBar mb = new JMenuBar();
        JMenu mHelp = new JMenu("Help");
        mb.add(mHelp);

        //add footer
        JLabel footer = new JLabel("2023 SzyZu", SwingConstants.CENTER);

        //add text field
        tf = new JTextField();
        PromptSupport.setPrompt("Enter channel name", tf);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf);
        PromptSupport.setFontStyle(Font.ITALIC, tf);
        tf.setBounds(300, 400, 400, 400);
        tf.addActionListener(this);

        //add content
        f.getContentPane().add(BorderLayout.NORTH, mb);
        f.getContentPane().add(BorderLayout.CENTER, p);
        f.getContentPane().add(BorderLayout.PAGE_END, footer);
        //p.add(mb);
        p.add(tf);
        //f.add(p);

        //set visible
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt){
        String text = tf.getText();
        Main.name = text;
        System.out.println(text);
    }
}
