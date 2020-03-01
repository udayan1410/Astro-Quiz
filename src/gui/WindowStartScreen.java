package gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WindowStartScreen extends JFrame {

	JButton b1;
	JLabel l1;
		public WindowStartScreen()
		{
		setTitle("Space Quiz");
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\HP\\Desktop\\bg.jpeg")));
		setLayout(new FlowLayout());
		/*l1=new JLabel("Here is a button");
		b1=new JButton("I am a button");
		add(l1);
		add(b1);*/
		setVisible(true);
		
		
		}
		
	
	
	
	
}
