package com.myform;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyWindow extends JFrame {

	private JLabel heading; // for creating heading we use JLabel class
	Font font = new Font("", Font.BOLD, 30);

	private JPanel mainPanel;
	private JLabel nameLabel, passwordLabel;
	private JTextField passwordField;
	private JButton button1, button2;
	private JTextField nameTextField;

//	Constructor
	public MyWindow() {

		super.setTitle("My First Form");
		super.setSize(700, 700);
		super.setLocation(100, 100);

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// operation close when application run is close
		this.createGUI();

		setVisible(true);
		System.out.println("This is Constructor...");

	}

//	this method create our GUI
	public void createGUI() {

		this.setLayout(new BorderLayout());

		heading = new JLabel("My First Form...");
		heading.setFont(font);
		heading.setHorizontalAlignment(JLabel.CENTER);// heading line show in centre

		this.add(heading, BorderLayout.NORTH);

//		Working with JPanel
		mainPanel = new JPanel();

//		setting layout of main panel...
		mainPanel.setLayout(new GridLayout(3, 2));

		nameLabel = new JLabel("Enter name :");
		nameLabel.setFont(font);

		passwordLabel = new JLabel("Enter password :");
		passwordLabel.setFont(font);

		nameTextField = new JTextField();
		nameTextField.setFont(font);

		passwordField = new JPasswordField();
		passwordField.setFont(font);

		button1 = new JButton("Submit");
		button1.setFont(font);

		button2 = new JButton("Reset");
		button2.setFont(font);

		mainPanel.add(nameLabel);

		mainPanel.add(nameTextField);

		mainPanel.add(passwordLabel);
		mainPanel.add(passwordField);

		mainPanel.add(button1);
		mainPanel.add(button2);

		this.add(mainPanel, BorderLayout.CENTER);

	}

}
