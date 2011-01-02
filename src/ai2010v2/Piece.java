package ai2010v2;

import sun.io.Converters;

/*
 *    Piece is rectangular piece of furniture.
 *    
 *    x,y_________w
 *    |           |
 *    |           |
 *    h------------
 * 
 * 
 * 
 * 
 * */
public class Piece {
	public int x,y;
	public int w, h;
	public int id;
	public char c;
	Piece(int ID)
	{
		id=ID;
		
	}
	public void Draw()
	{
		
		System.out.println("I am piece " + id +", placed on ("+ x +","+y+"), with size of["+w +","+h+"]");
	}
	
}
