//
// MySecondFrameClass  
//
// this class represents the election frame on a GUI
//
// Author:	Marco E. Ornelas
// Date:		12/04/17
//
package anElectionAndMore;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MySecondFrameClass extends JFrame
{
	private GridLayout frameLayout;		// frame layout
	private MyPanelGroupClass secondPanel;	// second panel

	//
	// MySEcondFrameClass
	//
	// the purpose of this method is to initialize all attributes
	//
	// Input:	title		frame title	
	// Return:	none
	//
	public MySecondFrameClass(String title) throws IOException
	{
		// define parameters for frame
		setTitle(title);
		setSize(400,400);
		setLocation(100,100);
		
		// hide frame when closed, allows to show results if election button on main frame is clicked again
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		// set panel layout
		frameLayout = new GridLayout();
		setLayout(frameLayout);
		
		// creates panel and adds it to the frame
		secondPanel = new MyPanelGroupClass();
		add(secondPanel);
		
		// hide panel until called upon 
		setVisible(false);
	} // end constructor
} // end MySecondFrameClass
