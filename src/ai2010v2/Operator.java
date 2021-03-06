package ai2010v2;

import java.util.Vector;

/*
 * Should each item have list of operators that can be applied to it;
 * operators are created in Room class and added to each piece;
 * 
 * if operator exists, it means that corresponding predicate is satisfied;
 * do not need to do double check
 * 
 */
public class Operator extends Item{
	// moved to super class 
	// public String type;  /* Possible values: Right Left Up Down Cw Ccw MoveTo*/
	public int[] params; /* if type=='MoveTo', params = [x,y]*/
	public Vector<Character> reasons;
	public Vector<Predicate> Preconditions;
	public Vector<Predicate> Postconditions;
	
	public Operator(String Type)
	{
		type = Type;
		
	}
	
	public Operator(String Type, int[] Params)
	{
		type = Type;
		params = Params;
	}
	
	public Operator(String Type, Vector<Character> Reasons)
	{
		type = Type;
		reasons = new Vector<Character>(Reasons);
	}
	
	public void AddPre(Predicate pred)
	{
		
	}
	
	public void AddPost(Predicate post)
	{
		
		
	}
	
	public void execute(Room room, Piece piece)
	{
		
	}
}
