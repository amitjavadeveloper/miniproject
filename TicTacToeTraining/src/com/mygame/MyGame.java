package com.mygame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyGame extends JFrame implements ActionListener {

	JLabel heading, clockLabel;// add clock-->clockLabel
	Font font = new Font("", Font.BOLD, 40);// heading bold
	JPanel mainPanel;

	JButton[] btns = new JButton[9];

	// game instance variable...
	int gameChances[] = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };
	int activePlayer = 0;
	
	int wps[][]= {
			{0,1,2},
			{3,4,5},
			{6,7,8},
			{0,3,5},
			{1,4,7},
			{2,5,8},
			{0,4,8},
			{2,4,6}
	};
	
	int winner=2;
	
	boolean gameOver=false;//game's value false means game is continue...

	MyGame() {
		System.out.println("Creating instances of Game");
		setTitle("Tic Tac Toe Game By Amit...");
		setSize(600, 600);
		ImageIcon icon = new ImageIcon("src/img/icon.png");
		setIconImage(icon.getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createGUI();
		setVisible(true);
	}

	private void createGUI() {
		this.getContentPane().setBackground(Color.decode("#575567"));// color blue
		this.setLayout(new BorderLayout());

//		north heading/...
		heading = new JLabel("Tic Tac Toe");
		
		heading.setIcon(new ImageIcon("src/img/Putra1.jpg"));// it gives icon to heading position
		
//		heading.setIcon(new ImageIcon("src/img/Putra.jpg"));
		heading.setFont(font);
		heading.setHorizontalAlignment(SwingConstants.CENTER);// heading in center place

		heading.setForeground(Color.white);
		heading.setHorizontalTextPosition(SwingConstants.CENTER);// it gives heading text to center position

		heading.setVerticalTextPosition(SwingConstants.BOTTOM);// it gives heading text to bottom position


		this.add(heading, BorderLayout.NORTH);

		// creating object of JLabel for Clock
		clockLabel = new JLabel("Clock");
		clockLabel.setFont(font);
		clockLabel.setHorizontalAlignment(SwingConstants.CENTER);

		clockLabel.setForeground(Color.white);// clock color white

		this.add(clockLabel, BorderLayout.SOUTH);

		Thread t = new Thread() {
			public void run() {

				try {
					while (true) {
						String datetime = new Date().toLocaleString();
						clockLabel.setText(datetime);

						Thread.sleep(1000);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();

		// panel section
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 3));

		for (int i = 1; i <= 9; i++) {
			JButton btn = new JButton();
//			btn.setIcon(new ImageIcon("src/img/00.png"));//add '00' button
			btn.setBackground(Color.decode("#FF5733"));// button background change
			btn.setFont(font);
			mainPanel.add(btn);
			btns[i - 1] = btn;
			btn.addActionListener(this);
			btn.setName(String.valueOf(i - 1));

		}
		this.add(mainPanel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("Clicked");//gives clicked on console when we clicked on the button
		JButton currentButton = (JButton) e.getSource();
		String nameStr = currentButton.getName();
//		System.out.println(nameStr);

		int name = Integer.parseInt(nameStr.trim());
		
		if(gameOver==true) {
			JOptionPane.showMessageDialog(this, "Game already over");
			
		}

		if (gameChances[name] == 2) {
			if (activePlayer == 1) {
				currentButton.setIcon(new ImageIcon("src/img/1.jpg"));
				
				gameChances[name]=activePlayer;
				activePlayer = 0;

			} else {
				currentButton.setIcon(new ImageIcon("src/img/0.jpg"));
				
				gameChances[name]=activePlayer;
				activePlayer = 1;
			}
			//find the winner...........
			for(int []temp:wps) {
				if((gameChances[temp[0]]==gameChances[temp[1]])&&(gameChances[temp[1]]==gameChances[temp[2]])&&gameChances[temp[2]]!=2) {
					winner=gameChances[temp[0]];
					gameOver=true;
					
					JOptionPane.showMessageDialog(null, "Player " + winner + " has won the game..");
					int i=JOptionPane.showConfirmDialog(this, "Do you want to play more ??");
					if(i==0) {
						this.setVisible(false);
						new MyGame();
					}else if(i==1) {
						System.exit(34234);
					}else {
						
					}
					System.out.println(i);
					break;
				}
			}
			
			//........
//			Draw logic
			int a=0;
			for(int x:gameChances) {
				if(x==2) {
					a++;
					break;
				}
			}
			if(a==0&&gameOver==false) {
				JOptionPane.showMessageDialog(null, "It's draw...");
				
				int i=JOptionPane.showConfirmDialog(this, "Play more???");
				if(i==0) {
					this.setVisible(false);
					
					new MyGame();
					
				}else if(i==1) {
					System.exit(1212);
				}else {
					
				}
				gameOver=true;
				
			}
			
		} else {
			JOptionPane.showMessageDialog(this, "Position already occupied..");
		}

	}

}
