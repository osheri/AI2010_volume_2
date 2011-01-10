package ai2010v2;

public class Predicate extends Item{
	public int x,y,h,w;
	
	public Predicate(String T, int id, int x2, int y2, int w2, int h2)
	{
		type = T;
		x = x2; y = y2; w = w2; h = h2; 
	}
	


	public Predicate(String T, int x2, int y2) {
		// TODO Auto-generated constructor stub
		type = T;
		x=x2;y=y2;
	}



	public boolean check(Room room)
	{
		if (type=="At")
		{
			for (Piece tmpPiece:room.Pieces)
			{
				if ((tmpPiece.x == x) &&(tmpPiece.y == y)&&(tmpPiece.h == h)&&(tmpPiece.w == w))
					return true;
			}
		}
		if (type=="Clear")
		{
			if (room.room[y][x]=='0') return true;
		}
		
		return false;
		
	}
}
