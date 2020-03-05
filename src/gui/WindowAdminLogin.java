package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import interfaces.CustomButtonCommunicator;
import interfaces.SoundCommunicator;

public class WindowAdminLogin extends JFrame {
	
	private static final LayoutManager FlowLayout = null;

	private CustomSettingsButton Submit,Back;
	private JTextField Id;
	private JPasswordField Pass;
	private JLabel AdminId, Password, Error;
	private SoundCommunicator soundCommunicator;
	
	public WindowAdminLogin() {
		setTitle("Admin Login");
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("./assets/backgroundImage1.jpg"))));

		JPanel HorizontalPanel1 = new JPanel();
		setLayout(FlowLayout);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(new PanelTitlePanel());

		HorizontalPanel1.setBorder(new EmptyBorder(150, 0, 0, 0));
		HorizontalPanel1.setLayout(new FlowLayout(1, 40, 30));

		AdminId = new JLabel("AdminID:");
		AdminId.setForeground(new Color(255, 255, 255));
		AdminId.setBackground(new Color(0, 0, 0));
		AdminId.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 40));

		
		Id = new JTextField(15);
		Font bigFont = Id.getFont().deriveFont(Font.PLAIN,20f);
		Id.setFont(bigFont);
		

		
		HorizontalPanel1.add(AdminId);
		HorizontalPanel1.add(Id);
		HorizontalPanel1.setOpaque(false);
		add(HorizontalPanel1);

		JPanel HorizontalPanel2 = new JPanel();
		HorizontalPanel2.setLayout(new FlowLayout(1, 40, 30));

		Password = new JLabel("Password:");
		Password.setForeground(new Color(255, 255, 255));
		Password.setBackground(new Color(0, 0, 0));
		Password.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 40));

		
		Pass = new JPasswordField(15);
		Pass.setFont(bigFont);

		
		HorizontalPanel2.add(Password);
		HorizontalPanel2.add(Pass);
		HorizontalPanel2.setOpaque(false);
		add(HorizontalPanel2);

		JPanel HorizontalPanel3 = new JPanel();
		HorizontalPanel3.setLayout(new FlowLayout(1, 50, 10));

		Submit = new CustomSettingsButton("   Submit   ");
		Submit.setButtonCommunicator(new CustomButtonCommunicator() {
			
			@Override
			public void buttonClicked(String userAnswer) {
				
				if(Id.getText().equals("admin")){
					
					if(Pass.getText().equals("admin")){
						setVisible(false);
						new WindowAddQuestions();
						dispose();
					}
				}
				
				else{
					
					Error.setText("Incorrect AdminId or Password");
					Error.setForeground(new Color(255, 255, 255));
					Error.setBackground(new Color(0, 0, 0));
					Error.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
					
				}
			}
				
			
		});
		
		
		Back = new CustomSettingsButton("   Back   ");
		Back.setButtonCommunicator(new CustomButtonCommunicator() {

			@Override
			public void buttonClicked(String userAnswer) {
				// TODO Auto-generated method stub
				setVisible(false);
				new WindowStartScreen();
				dispose();
			}
		});
		
		Error = new JLabel("");
		
		
		
		HorizontalPanel3.add(Submit);
		HorizontalPanel3.add(Back);
		HorizontalPanel3.add(Error);
		HorizontalPanel3.setOpaque(false);
		add(HorizontalPanel3);

		setVisible(true);

	}
	
	
	
	
}
