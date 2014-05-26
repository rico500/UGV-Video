import java.awt.event.*;
import java.awt.*;
import java.awt.Dimension;
import javax.swing.*;

public class InterfaceGraphiqueTest_1 extends JFrame
{  
   private JTabbedPane tabs;
   private JPanel connectionTab;
   private JPanel controlTab;
   private JPanel optionTab;
   private JPanel helpTab;
   private JPanel quitTab;
   int keyOnPress, keyOnRelease;
   
   public InterfaceGraphiqueTest_1()
   {
      setTitle("IHM travail de matu");
      setSize(500, 350);
      setBackground(Color.gray);
      
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BorderLayout());
      getContentPane().add(topPanel);
      
      createConnectionTab();
      createControlTab();
      createOptionTab();
      createHelpTab();
      createQuitTab();
      
      tabs = new JTabbedPane();
      tabs.addTab("Connection", connectionTab);
      tabs.addTab("Controle", controlTab);
      tabs.addTab("Paramètres", optionTab); 
      tabs.addTab("Aide", helpTab);
      tabs.addTab("Quitter", quitTab);
      topPanel.add(tabs, BorderLayout.CENTER);
   }
   
   public void createConnectionTab()
   {
      connectionTab = new JPanel();
      connectionTab.setLayout(null);
      
      JLabel adresseIpLabel = new JLabel("Adresse IP");
      adresseIpLabel.setBounds(10, 15, 150 ,20);
      connectionTab.add(adresseIpLabel);
      
      JTextField adresseIpTextField = new JTextField();
      adresseIpTextField.setBounds(150, 15, 150, 20);
      connectionTab.add(adresseIpTextField);
      
      JLabel portLabel = new JLabel("Port");
      portLabel.setBounds(10, 35, 150, 20);
      connectionTab.add(portLabel);
      
      JTextField portTextField = new JTextField();
      portTextField.setBounds(150, 35, 150, 20);
      connectionTab.add(portTextField);
      
      JLabel usernameLabel = new JLabel("Nom d'utilisateur");
      usernameLabel.setBounds(10, 55, 150, 20);
      connectionTab.add(usernameLabel);
      
      JTextField usernameTextField = new JTextField();
      usernameTextField.setBounds(150, 55, 150, 20);
      connectionTab.add(usernameTextField);
      
      JLabel pskLabel = new JLabel("Mot de Passe");
      pskLabel.setBounds(10, 75, 150, 20);
      connectionTab.add(pskLabel);            
      
      JTextField pskTextField = new JTextField();
      pskTextField.setBounds(150, 75, 150, 20);
      connectionTab.add(pskTextField);
   } 
   
   public void createControlTab()
   {
      controlTab = new JPanel();
      controlTab.setLayout(null);
      
      Box videoBox = Box.createHorizontalBox();
      JLabel waitForVideo = new JLabel("attente de la vidéo");
      videoBox.add(waitForVideo);
      controlTab.add(videoBox);
      
   }
   
   public void createOptionTab()
   {
   
   }
   
   public void createHelpTab()
   {
      helpTab = new JPanel();
      helpTab.setLayout(null);
   }
   
   public void createQuitTab()
   {  
      quitTab = new JPanel();
      quitTab.setLayout(null);
      
      JButton quitButton = new JButton("Quitter");
      quitButton.addActionListener(new QuitButtonListener());
      quitTab.add(quitButton);
   }
   
   private class KeyboardListener implements KeyListener
   {
      public void keyPressed(KeyEvent e)
      {  
         System.out.println("Key Pressed!");
         keyOnPress = e.getKeyCode();
      }
      
      public void keyReleased(KeyEvent e)
      {
         System.out.println("Key Released!");
         keyOnRelease = e.getKeyCode();
      }
      
      public void keyTyped(KeyEvent e)
      {
      
      }
   }
   
   public class QuitButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         int reply = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter?","ATTENTION", JOptionPane.YES_NO_OPTION);
         if(reply == JOptionPane.YES_OPTION)
         {
            System.exit(0);
         }
         
         else
         {
            
         }
      }
   }
   public static void main(String args[])
   {
      InterfaceGraphiqueTest_1 mainFrame = new InterfaceGraphiqueTest_1();
      mainFrame.setVisible(true);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }   
      
}         
  
