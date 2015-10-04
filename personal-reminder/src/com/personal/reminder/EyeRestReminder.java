package com.personal.reminder;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EyeRestReminder implements Reminder{
	private JFrame mainAppFrame;
	private JPanel mainAppPanel;

	@Override
	public void reminderForEyeRest() {
		mainAppFrame = new JFrame("Remind Master v1.0");
		mainAppPanel = new JPanel(new FlowLayout());
		buildGUI();
		
	}
	
	/**
	 * Builds the GUI window.
	 */
	private void buildGUI(){
		JLabel headerLabel = new JLabel("Remind Master - Your Personal Reminder!!");
		headerLabel.setFont(new Font("Times New Roman", 1, 14));
		JPanel headerPanel = new JPanel(new FlowLayout());
		headerPanel.add(headerLabel);
		
		JLabel nameLabel = new JLabel("Please enter you'r name:");
		nameLabel.setFont(new Font("Times New Roman", 1, 12));
		final JTextField nameField = new JTextField(20);
		JPanel namePanel = new JPanel(new FlowLayout());
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		JButton startButton = new JButton("Start App");
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(startButton);
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				name = name.trim();
				if(name == null || name.equalsIgnoreCase("")){
					name = "there";
				}
				showInfo(name);
				
			}
		});
		
		mainAppPanel.add(headerPanel);
		mainAppPanel.add(namePanel);
		mainAppPanel.add(buttonPanel);
		mainAppFrame.getContentPane().add(mainAppPanel);
		mainAppFrame.setSize(400, 200);
		mainAppFrame.setVisible(true);
		mainAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 
	 * @param name
	 */
	private void showInfo(final String name){
		mainAppPanel.removeAll();
		JLabel info1Label = new JLabel("Hey " + name + "!! Welcome.");
		info1Label.setFont(new Font("Times New Roman", 1, 14));
		JLabel info2Label = new JLabel("I've been started successfully!!");
		info2Label.setFont(new Font("Times New Roman", 1, 14));
		JLabel info3Label = new JLabel("Now you can minimize me and I'll remind you to take up eye rest after 20 min.");
		info3Label.setFont(new Font("Times New Roman", 1, 14));
		JPanel info1Panel = new JPanel(new FlowLayout());
		info1Panel.add(info1Label);
		JPanel info2Panel = new JPanel(new FlowLayout());
		info2Panel.add(info2Label);
		JPanel info3Panel = new JPanel(new FlowLayout());
		info3Panel.add(info3Label);
		mainAppPanel.add(info1Panel);
		mainAppPanel.add(info2Panel);
		mainAppPanel.add(info3Panel);
		mainAppFrame.setSize(510, 200);
		mainAppFrame.addWindowStateListener(new WindowStateListener() {
			
			@Override
			public void windowStateChanged(WindowEvent e) {
				if((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED){
					remind(name);
				}
				
			}
		});
		
	}
	
	
	/**
	 * 
	 * @param name
	 */
	private void remind(final String name){
		System.out.println("Successfully minimized!!");
		try{
			Thread.sleep(20 * 60 * 1000);
		}catch(InterruptedException e){
			System.out.println("Something went wrong in reminding!!");
			System.out.println("Please restart the app.");
			e.printStackTrace();
		}
		mainAppPanel.removeAll();
		
		JLabel message1Label = new JLabel("Hey " + name + ".");
		message1Label.setFont(new Font("Times New Roman", 1, 14));
		JPanel message1Panel = new JPanel(new FlowLayout());
		message1Panel.add(message1Label);
		
		JLabel message2Label = new JLabel("It's almost 20 min, that you have been working on your system.");
		message2Label.setFont(new Font("Times New Roman", 1, 14));
		JPanel message2Panel = new JPanel(new FlowLayout());
		message2Panel.add(message2Label);
		
		JLabel message3Label = new JLabel("1. Please look away from your monitor, say about 20 ft distance.");
		message3Label.setFont(new Font("Times New Roman", 1, 14));
		JPanel message3Panel = new JPanel(new FlowLayout());
		message3Panel.add(message3Label);
		
		JLabel message4Label = new JLabel("2. And blink your eyes for 20 times. This should release some some stress from your eyes.");
		message4Label.setFont(new Font("Times New Roman", 1, 14));
		JPanel message4Panel = new JPanel(new FlowLayout());
		message4Panel.add(message4Label);
		
		JLabel message5Label = new JLabel("You can now minimize me to remind you again!!");
		message5Label.setFont(new Font("Times New Roman", 1, 14));
		JPanel message5Panel = new JPanel(new FlowLayout());
		message4Panel.add(message5Label);
		
		mainAppPanel.add(message1Panel);
		mainAppPanel.add(message2Panel);
		mainAppPanel.add(message3Panel);
		mainAppPanel.add(message4Panel);
		mainAppPanel.add(message5Panel);
		mainAppFrame.setState(JFrame.NORMAL);
		mainAppFrame.setSize(880, 200);
		
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EyeRestReminder eyeRestReminder = new EyeRestReminder();
		eyeRestReminder.reminderForEyeRest();
	}

}
