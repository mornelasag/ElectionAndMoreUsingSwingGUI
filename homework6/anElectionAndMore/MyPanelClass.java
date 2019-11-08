//
// MyPanelClass  
//
// this class represents one panel in a GUI
//
// Author:	Marco E. Ornelas
// Date:		12/04/17
//
package anElectionAndMore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class MyPanelClass extends JPanel implements ActionListener, ItemListener
{
	private GridLayout panelLayout;	// panel layout
	
	private JButton election;	// election button
	private JButton count;		// count button
	private JRadioButton red;	// red radio button
	private JRadioButton green;	// green radio button
	private JRadioButton yellow;	// yellow radio button
	private ButtonGroup buttonGroup;	// button group
	private JTextField countNumber;	// count number text area	
	private MySecondFrameClass secondFrame;	// second Frame
	private int cntr;	// keeps track of number of times counter button is pressed

		
	private static final Color RED = Color.RED;		// red color
	private static final Color GREEN = Color.GREEN;	// green color
	private static final Color YELLOW = Color.YELLOW;	// yellow color
	private static final Color BLACK = Color.BLACK;	// black color
	
	//
	//	MyPanelClass
	//
	//	The purpose of this method is to initialize all attributes.
	//	Attributes in this class and also inherited attributes must
	//	be initialized.
	//
	//	Input:	none
	//	Return:	none
	//
	public MyPanelClass() throws IOException
	{
		// create election frame
		secondFrame = new MySecondFrameClass("Election - Marco E. Ornelas");
		
		cntr = 0;
		
		// set initial panel background to red
		setBackground(RED);
		
		// create the layout manager and assign it to the panel
		panelLayout = new GridLayout(4,0);
		setLayout(panelLayout);
		
		// election button
		election = new JButton("ELECTION");
		election.setForeground(BLACK);

		// count button
		count = new JButton("COUNT");
		count.setForeground(BLACK);
		
		// count text field
		countNumber = new JTextField("COUNT has been pressed : " + cntr + " times");
		
		// radio buttons
		red = new JRadioButton("RED", true);
		green = new JRadioButton("GREEN", false);
		yellow = new JRadioButton("YELLOW", false);
		
		// add radio buttons to group
		buttonGroup = new ButtonGroup();
		buttonGroup.add(red);
		buttonGroup.add(green);
		buttonGroup.add(yellow);
		
		// add all buttons to panel
		add(election);
		add(count);
		add(countNumber);
		add(red);
		add(green);
		add(yellow);		
		
		// add buttons to action listener
		election.addActionListener(this);
		count.addActionListener(this);
		// add radio buttons to item listener
		red.addItemListener(this);
		green.addItemListener(this);
		yellow.addItemListener(this);
	}// end MyPanelClass constructor
	
	//
	// actionPerformed
	//
	// this is the event handler for the ActionEvents
	//
	// Input:	e		the action event
	// Return:	none
	//
	public void actionPerformed(ActionEvent e)
	{
		
		if (e.getSource() == election)
		{
			// turn on election GUI visible
			secondFrame.setVisible(true);
		}
		else if (e.getSource() == count)
		{
			// count number of times counter button is pressed
			++cntr;
			// display number of times counter button is pressed
			countNumber.setText("COUNT has been pressed : " + cntr + " times");			
		}
		else
		{
			// error message
			System.out.println("Unexpected Action Event in MyPanelClass");
		} // end if/else
	}// end actionPerformed
	
	//
	// itemStateChanged
	//
	// this is the item listener for the ItemEvents
	//
	// Input:	e		the item event
	// Return:	none
	//
	public void itemStateChanged(ItemEvent e)
	{
		if (e.getSource() == red)
		{
			// set background to red
			setBackground(RED);
		}
		else if (e.getSource() == green)
		{
			// set background to green
			setBackground(GREEN);
		}
		else if (e.getSource() == yellow)
		{
			// set background to yellow
			setBackground(YELLOW);
		}
		else
		{
			// error message
			System.out.println("Unexpected Item Event in MyPanelClass");
		} // end if else
	} // end itemStateChanged
} // end MyPanelClass
