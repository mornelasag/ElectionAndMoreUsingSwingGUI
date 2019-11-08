//
// CandidateList
//
// The purpose of this method is to represent a list of candidates participating in an election.
//
// Author:	Marco E. Ornelas
// Date:	12/04/17
//

package anElectionAndMore;

import java.util.Scanner;
import java.io.*;

public class CandidateList
{
	// attributes
	private Candidate[] theList;
	
	//
	//	CandidateList
	//
	//	The purpose of this method is to initialize attributes
	//
	//	Input:	none
	//	Return:	none
	//
	public CandidateList()
	{
		// create an empty list
		theList = new Candidate[0];
			
	}// end CandidateList constructor
	
	
	//
	//	setTheList
	//
	//	the purpose of this method is to modify the list of candidates
	//
	//	Input:	lst		the new list of candidates
	//	Return:	none
	//
	public void setTheList(Candidate[] lst)
	{
		theList = lst;

	}// end setTheList
	
	
	//
	//	getTheList
	//
	//	the purpose of this method is to return a copy of the candidate list
	//
	//	Input:	none
	//	REturn:	theList
	//
	public Candidate[] getTheList()
	{
		return theList;
	}
	
	
	//
	//	getListLength
	//
	//	The purpose of this method is to return the length
	//	of the candidate list.
	//
	//	Input:	none
	//	Return:	len			length of the list
	//
	public int getListLength()
	{
		int len;
		len  = theList.length;
		return len;
		
	}// end getListLength
	
	
	//
	//	getOneCandidate
	//
	//	the purpose of this method is to return one candidate from
	//	the list
	//
	//	Input:		index		the index of the candidate in the list
	//	Return:		c			the candidate requested
	//
	public Candidate getOneCandidate(int index )
	{
		Candidate c;
		c = new Candidate();
		
		if ((index >= 0) && (index < theList.length))
		{
			c = theList[index];
		}
		return c;
	}// end getOneCandidate
	
	
	//
	//	toString
	//
	//	the purpose of this method is to create a string that includes
	//	all of the attributes in this class
	//
	//	Input:	none
	//	Return:	retStr		the complete string
	//
	public String toString()
	{
		int cntr;
		StringBuffer buff;
		String canStr;
		String retStr;
		
		buff = new StringBuffer();
		
		for (cntr = 0; cntr < theList.length;++cntr)
		{
			canStr = theList[cntr].toString();
			buff.append(canStr + "\r\n");
			
		}// end for each candidate
		
		retStr = buff.toString();
		
		return retStr;
	}// end toString	
	
	
	//
	//	inputCandidates
	//
	//	the purpose of this method is to input all candidates
	//	from a file
	//
	//	Input:	fn		the name of the file from which to input votes
	//	Return:	none
	//
	public void inputCandidates(String fn) throws IOException
	{
		Scanner input=  new Scanner(new File(fn));
	    Candidate c;
	    String name;
 
        // read candidate names from the file one at a time until
        // the end of the file is reached
        while(input.hasNext() == true)
        {
            // create a new candidate object
            c = new Candidate( );
            	
            //read a name from the file
            name = input.nextLine();
           		
      		c.setName(name);
            		
            expandCandidateList(c);
        }
            
	    	// close the file now that we have exhausted the data
	    	input.close();
	}// end inputCandidates

	
	//
	//	expandCandidateList
	//
	//	the purpose of this method is to expand the list of
	//	candidates to include one additional candidate.
	//
	//	Input:	can			the candidate to add to the list
	//	Return:	none
	//
	public void expandCandidateList(Candidate can)
	{
		int cntr;
		Candidate[] tmpList;
		int expandedSize;
		
		// the new size of the list will be the size of the
		//	existing list plus 1
		expandedSize = theList.length + 1;
		
		// create the temporary list
		tmpList = new Candidate[expandedSize];
		
		// copy existing reservations into the temporary list
		for (cntr =0; cntr < theList.length;++cntr)
		{
			tmpList[cntr] = theList[cntr];
		}// end for each existing reservation
		
		// create a new object for the new reservation to be filled
		tmpList[theList.length] = can;
		
		// assign the temporary list to be the actual reservation list
		theList = tmpList;
	}// end expandCandidateList
	
	
    //
    //	castVote
    //
    //	the purpose of this method is to cast a vote for a candidate
    //
    //	Input:	theName			the name of the candidate for which the vote is cast
    //	Return:	none
    //
    public void castVote(String theName)
    {
	    	int index;
	    	
	    	// find the name in the list of candidates
	    	index = findCandidate(theName);
	    	
	    	if ((index >= 0) && (index < theList.length))
	    	{
	    		// valid index
	    		theList[index].castVote();
	    	}
	    	else
	    	{
	    		System.out.println("Invalid Candidate " + theName);
	    	}
    }// end castVote

    //
    //	findCandidate
    //
    //	The purpose of this method is to find the candidate
    //	number corresponding to a candidate name
    //
    //	Input:	nme			the name of the candidate to find
    //	Return:	num			the candidate number matching or -1 if not found
    //
    public int findCandidate(String nme)
    {
        int num;
        int cntr;
        String n;
              
        num = -1;		// assume that you won't find the candidate
              
        for (cntr = 0; cntr < theList.length;++cntr)
        {
            // get the candidate's name
            n = theList[cntr].getName();
            
            if (n.equalsIgnoreCase(nme) == true)
            {
                // name matches - we have found the candidate
                num = cntr;
                break;
            }
            
        }// end for each candidate
        
        return num;
    }// end findCandidate
    
    
    //
    //	collectAllVotes
    //
    //	the purpose of this method is to collect all votes for all candidates
    //
    //	Input:	none
    //	Return:	allVotes	the list of votes for all candidates
    //
    public int[] collectAllVotes()
    {
	    	int[] allVotes;
	    	int cntr;
	    	
	    	// create an array that will hold the number of votes for each candidate
	    	allVotes = new int[theList.length];
	    	
	    	// determine the # of votes for each candidate
	    	for (cntr = 0; cntr < theList.length;++cntr)
	    	{
	    		allVotes[cntr] = theList[cntr].getNumVotes();
	    	}// end for each candidate
	    	
	    	return allVotes;   	
    }// end collectAllVotes
    
    
    //
    //	collectAllNames
    //
    //	the purpose of this method is to collect all names for all candidates
    //
    //	Input:	none
    //	Return:	theNames	the list of names for all candidates
    //
    public String[] collectAllNames()
    {
	    	String[] theNames;
	    	int cntr;
	    	
	    	// create an array that will hold the name for each candidate
	    	theNames = new String[theList.length];
	    	
	    	// determine the # of votes for each candidate
	    	for (cntr = 0; cntr < theList.length;++cntr)
	    	{
	    		theNames[cntr] = theList[cntr].getName();
	    	}// end for each candidate
	    	
	    	return theNames;
	    	
    }// end collectAllNames
}// end CandidateList class
