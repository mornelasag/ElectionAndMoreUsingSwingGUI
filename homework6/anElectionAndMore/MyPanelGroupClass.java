//
// MyPanelGroupClass  
//
// this class represents a panel with a group of buttons and fields
//
// Author:	Marco E. Ornelas
// Date:		12/04/17
//
package anElectionAndMore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyPanelGroupClass extends JPanel implements ActionListener
{
	private FlowLayout panelLayout;	// panel layout
	private JButton[] buttons;		// buttons array
	private JTextArea results;		// results
	private int size;			// size
	private CandidateList n;		// names
	private String[] theNames;	//
	
	private ElectionFromFile elec;
	
	
	
	
	
	private static final Color BLACK = Color.black;
	
	//
	// MyPanelGroupClass
	public MyPanelGroupClass() throws IOException
	{		
		elec = new ElectionFromFile();
		elec.runElection("candidate list.txt", "results.txt");
		
		n = elec.getTheCandidates();
		
		theNames = n.collectAllNames();
		
		
		int cntr;
		
		size = (theNames.length / 2) + 1;
		
		// create the panel layout and assign it
		panelLayout = new FlowLayout();
		setLayout(panelLayout);
		

		// create the group of buttons
		buttons = new JButton[theNames.length + 1];
		
		for (cntr = 0; cntr < (buttons.length - 1); cntr++)
		{
			buttons[cntr] = new JButton(theNames[cntr]);
			buttons[cntr].setForeground(BLACK);
			buttons[cntr].addActionListener(this);	
		}// end for each button
		
		buttons[buttons.length - 1] = new JButton("SHOW RESULTS");
		buttons[buttons.length- 1].setForeground(BLACK);
		buttons[buttons.length- 1].addActionListener(this);
		
		// add all buttons to the panel
		for (cntr = 0; cntr < buttons.length;++cntr)
		{
			add(buttons[cntr]);
		}
		results = new JTextArea();
		results.setForeground(BLACK);
		add(results);
		results.setVisible(false);

	}// end MyPanelGroup constructor
		
	
	public void actionPerformed(ActionEvent e) 
	{
		int cntr;
		int eventIndex;
		
		
		eventIndex = -1;
		for (cntr = 0; cntr < buttons.length;++cntr)
		{
			if (e.getSource() == buttons[cntr])
			{
				eventIndex = cntr;
				break;
			}
		}
		
		if ((eventIndex >= 0) && (eventIndex < (buttons.length - 1)))
		{
			// add vote to candidate
			n.castVote(theNames[cntr]);
		}
		else if (eventIndex == (buttons.length - 1))
		{
			
			// show results in GUI and write to results.txt file
			for (cntr = 0; cntr < buttons.length; cntr++)
			{
				
				buttons[cntr].setVisible(false);
			}
			
			results.setVisible(true);
			results.setText(elec.toString());
			
			try
			{
				elec.saveResults("test.txt");
			}
			catch(IOException iox)
			{
				System.out.println("IOException caused by elec.saveResults()");
			}
			finally
			{
				System.out.println("Unespected error caused by elec.saveResults()");
			}
			
		}
		else
		{
			System.out.println("Unexpected Event in actionPerformed in MainPanel3");
		}
	
	}// end actionPerformed
} // end MyPanelGroupClass
