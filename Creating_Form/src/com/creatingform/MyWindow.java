package com.creatingform;

import javax.swing.JFrame;

public class MyWindow extends JFrame {
	
	public MyWindow() {
		
		super.setTitle("My First Form..");
		super.setSize(400, 400);
		super.setLocation(100, 100);
//		super.setVisible(true);
		
		setVisible(true);
		System.out.println("This is Constructor...");
	}

}
