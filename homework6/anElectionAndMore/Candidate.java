//
// Candidate
//
// The purpose of this class is to 
//
// Author:	Marco E. Ornelas
// Date:	12/04/17
//


package anElectionAndMore;

public class Candidate
{
	// attributes
	private String name;		// name of the candidate
	private int numVotes;		// the number of votes that have been cast for the candidate
	
	//
	//	Candidate
	//
	//	The purpose of this method is to initialize all attributes
	//
	//	Input:	none
	//	Return:	none
	//
	public Candidate()
	{
		name = "NO NAME YET";
		numVotes = 0;
	}// end Candidate constructor
	
	
	//
	//	Candidate
	//
	//	The purpose of this method is to initialize all attributes
	//
	//	Input:	name				name for the candidate
	//	Return:	none
	//
	public Candidate(String nme)
	{
		name = nme;
		numVotes = 0;
	}// end Candidate constructor	
	
	
	//
	//	setName
	//
	//	the purpose of this method is to modify the name of the candidate
	//
	//	Input:	name			the new name for the candidate
	//	Return:	none
	//
	public void setName(String nme)
	{
		name = nme;
	}// end setName
	
	
	//
	//	getName
	//
	//	the purpose of this method is to return a copy of the name attribute
	//
	//	Input:	none
	//	return:	name
	//
	public String getName( )
	{
		return name;
	}//end getName
	
	
	//
	//	getNumVotes
	//
	//	the purpose of this method is to return a copy of the numVotes attribute
	//
	//	Input:	none
	//	Return:	numVotes
	//
	public int getNumVotes()
	{
		return numVotes;
	}// end getNumVotes
	
	
    //
    //	toString
    //
    //	the purpose of this method is to create a string including
    //	all attributes in the class.
    //
    //	Input:	none
    //	Return:	retStr		the complete string to print 
    //
    public String toString()
    {
        String retStr;
        StringBuffer buff;
        
        buff = new StringBuffer();
        buff.append("Name\t\t" + name + "\r\n");
        buff.append("Number of Votes\t" + numVotes + "\r\n");
        
        retStr = buff.toString();
        
        return retStr;
    }// end toString
    
    
    //
    //	castVote
    //
    //	The purpose of this method is to cast one vote for the Candidate
    //
    //	Input:	none
    //	Return:	none
    //
    public void castVote()
    {
    		++numVotes;
    }// end castVote
}// end Candidate class
