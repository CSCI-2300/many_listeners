import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

public class ObserverExample
{
   int width = 400;
   int height = 400;

   public ObserverExample()
   {
      JFrame mainFrame = new JFrame();
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      mainFrame.setPreferredSize(new Dimension(width, height));
      JButton button = new JButton("Click me");
      mainFrame.add(button);
      button.addActionListener(new NewWindow());
      button.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent event)
         {
            System.out.println("Who clicked that?");
         }
      });
      mainFrame.pack();
      mainFrame.setVisible(true);
   }

   public class NewWindow implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         JFrame frame = new JFrame("New window");
         frame.setPreferredSize(new Dimension(width, height));
         JLabel label = new JLabel("Hi there!");
         frame.add(label);
         frame.pack();
         frame.setVisible(true);
      }
   }
   
   public static void main(String []args)
   {
      ObserverExample example = new ObserverExample();
   }
}
