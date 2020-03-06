package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Window;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.binding.StringFormatter;

import interfaces.CustomButtonCommunicator;

public class WindowAddQuestions extends JFrame {
	private static final LayoutManager FlowLayout = null;

	private JLabel question, qType;
	private JComboBox qTypeSelector;
	private CustomSettingsButton Submit;

	private CustomSettingsButton Submit,back;
	
	public WindowAddQuestions() {

		String s1[] = { "Radio Button", "True or False", "Interactive", "Fill in the Blanks" };

		setTitle("New Questions");
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("./assets/backgroundImage1.jpg"))));

		JPanel HorizontalPanel1 = new JPanel();
		setLayout(FlowLayout);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(new PanelTitlePanel());
		HorizontalPanel1.setBorder(new EmptyBorder(-100, 0, 0, 0));

		HorizontalPanel1.setLayout(new FlowLayout(1, 40, 10));
		HorizontalPanel1.setBackground(Color.white);
		HorizontalPanel1.setPreferredSize(new Dimension(5, 5));

		question = new JLabel("Question:");
		question.setForeground(new Color(255, 255, 255));
		question.setBackground(new Color(0, 0, 0));
		question.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));

		HorizontalPanel1.add(question);
		HorizontalPanel1.setOpaque(false);
		add(HorizontalPanel1);

		JPanel HorizontalPanel2 = new JPanel();
		HorizontalPanel2.setLayout(new FlowLayout(1, 40, 10));

		qType = new JLabel("Question Type:");
		qType.setForeground(new Color(255, 255, 255));
		qType.setBackground(new Color(0, 0, 0));
		qType.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));

		qTypeSelector = new JComboBox(s1);
		qTypeSelector.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

		HorizontalPanel2.add(qType);
		HorizontalPanel2.add(qTypeSelector);
		HorizontalPanel2.setOpaque(false);
		add(HorizontalPanel2);

		JPanel HorizontalPanel3 = new JPanel();

		HorizontalPanel3.setLayout(new FlowLayout(1, 10, 10));


		HorizontalPanel3.setLayout(new FlowLayout(1,10,10));
	
		back = new CustomSettingsButton("   Back   ");
		HorizontalPanel3.setOpaque(false);
		add(HorizontalPanel3);
		back.setButtonCommunicator(new CustomButtonCommunicator() {
			@Override
			public void buttonClicked(String userAnswer) {
				setVisible(false);
				new WindowStartScreen();
				dispose();
			}
		});

		
		Submit = new CustomSettingsButton("   Submit   ");
		HorizontalPanel3.add(Submit);
		HorizontalPanel3.setOpaque(false);
		add(HorizontalPanel3);
		HorizontalPanel3.add(back);
		
		
		Submit.setButtonCommunicator(new CustomButtonCommunicator() {

			@Override
			public void buttonClicked(String userAnswer) {
				// TODO Auto-generated method stub
				String selected = (String) qTypeSelector.getSelectedItem();

				if (selected.equalsIgnoreCase("Radio Button")) {
					setVisible(false);
					new WindowAddRBQuestion();
					dispose();
				} else {
					setVisible(false);
					new WindowAddTFQuestions(selected);
					dispose();
				}
			}
		});

		setVisible(true);

	}
}
