import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.swingx.prompt.PromptSupport;

public class UI extends JPanel {

    protected JTextField tf;
    JFrame f = new JFrame("SPaNT");

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
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);

        //menubar
        JMenuBar mb = new JMenuBar();
        JMenu mHelp = new JMenu("Help");
        mb.add(mHelp);
        f.setJMenuBar(mb);

        //add content
        f.getContentPane().add(BorderLayout.CENTER, searchPane());
        //p.add(mb);
        //f.add(p);

        //set visible
        f.setVisible(true);
    }

    private JPanel searchPane(){
        JPanel p = new JPanel();

        //add text field
        tf = new JTextField();
        PromptSupport.setPrompt("Enter channel name", tf);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf);
        PromptSupport.setFontStyle(Font.ITALIC, tf);
        tf.addActionListener(new switchAction(mainPane()));

        //add footer
        JLabel footer = new JLabel("2023 SzyZu", SwingConstants.CENTER);
        f.getContentPane().add(BorderLayout.PAGE_END, footer);

        p.add(tf);

        return p;
    }

    private JPanel mainPane(){
        JPanel p = new JPanel();

        //add footer
        JLabel footer = new JLabel("2023 SzyZu", SwingConstants.CENTER);
        f.getContentPane().add(BorderLayout.PAGE_END, footer);

        return p;
    }

    public void changePanel(JPanel p){
        f.getContentPane().removeAll();
        f.getContentPane().add(p, BorderLayout.CENTER);
        f.invalidate();
        f.validate();
        f.repaint();
    }

    private class switchAction implements ActionListener{
        private JPanel panel;

        private switchAction(JPanel p){
            this.panel = p;
        }

        public void actionPerformed(ActionEvent e){
            changePanel(panel);
        }
    }
}