//
// MyMainFrameClass  
//
// this class represents the main frame on a GUI
//
// Author:	Marco E. Ornelas
// Date:		12/04/17
//
package anElectionAndMore;

import javax.swing.*;
import java.awt.*;

import java.io.*;

public class MyMainFrameClass extends JFrame
{
	private GridLayout frameLayout;	// frame layout
	private MyPanelClass firstPanel;		// first panel

	
	//
	//	MyFrameClass
	//
	//	The purpose of this method is to initialize all attributes.
	//
	//	Input:	title		title for frame
	//	Return:	none
	//
	public MyMainFrameClass(String title) throws IOException
	{
		// define parameters for the frame
		setTitle(title);
		setSize(500,150);
		setLocation(50,50);
		
		// close program on exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set panel layout
		frameLayout = new GridLayout();
		setLayout(frameLayout);
		
		// creates panel and adds it to the frame
		firstPanel = new MyPanelClass();
		add(firstPanel);

		// show panel
		setVisible(true);
	}// end overloaded constructor
} // end MyMainFrameClass
