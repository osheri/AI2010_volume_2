package ai2010v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;


/*
 *   Room is a big container [like 30x30] it can contain smaller rooms
 *	
 *    I can read files! 
 *    See attached room.txt as an example
 * 
 * 
 * */


public class Room {
	public boolean isSource;
	public char room[][];
	public char PieceFlag[]; 
	public Vector<Piece> Pieces; 

	public void Draw()
	{
		int x,y;
		for (y=0;y<30;y++)
		{
			for (x=0;x<30;x++)
			{
				System.out.write(room[y][x]);
			}
			System.out.write('\n');
		}
	}

	public Room(String filename, boolean source)
	{
		int i,j;
		char c;
		isSource = source;
		File file = new File(filename);
		FileInputStream fis = null;
		try 
		{
			fis = new FileInputStream(file);
		}
		catch(Exception E)
		{
			System.out.print("Exception 1");
		}
		room = new char[30][30];
		for (i=0;i<30;i++)
			for (j=0;j<30;j++)
				try {
					c = (char) fis.read();
					if ((c>='0') && (c<='9'))
						room[i][j]=c;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PieceFlag = new char[9];
				Pieces = new Vector<Piece>();
				for (i=0;i<30;i++)
					for (j=0;j<30;j++)
					{
						if ((room[i][j]!='0') && (room[i][j]!='1') && (inPF(room[i][j])==false))
						{
							// Identified new piece; create object; count dimensions;
							Piece newPiece = new Piece(room[i][j]-'0');
							PieceFlag[Pieces.size()]=room[i][j];
							int i1, j1, w = 0 ,h = 0;
							i1= i; j1=j;
							while (room[i][j1]==room[i][j])
							{
								h++; j1++;
							}
							while (room[i1][j]==room[i][j])
							{
								w++; i1++;
							}
							newPiece.x = j;
							newPiece.y = i;
							newPiece.w = h;  // I like drugs
							newPiece.h = w;
							Pieces.add(newPiece);
						}

					}
	}

	private boolean inPF(char c) {
		if (PieceFlag.length>0)
			for (int i=0;i<PieceFlag.length;i++)
				if (c==PieceFlag[i]) return true;
		return false;
	}

	public void fillOperators()
	{
		for (Piece tmpPiece:Pieces)
		{
			/*
			 * check if can move left, right, up and down
			 * check if can rotate cw, ccw
			 */
			int i;
			boolean wallflag;
			wallflag = false;
			
			// Right check
			
			for (i=tmpPiece.y; i<tmpPiece.y+tmpPiece.h;i++)
			{
				if (room[i][tmpPiece.x+tmpPiece.w]=='1') 
				{
					// check if can be moved at all
					wallflag = true;
				}
			}
			if (!wallflag)
			{
				//create operator; add preconditions and postconditions
				Operator tmpOp = new Operator("Right");
				Predicate tmpPredicate = new Predicate("At", tmpPiece.id, tmpPiece.x, tmpPiece.y, tmpPiece.w, tmpPiece.h);
				tmpOp.AddPre(tmpPredicate);
				Predicate tmpPost = new Predicate("At", tmpPiece.id, tmpPiece.x+1, tmpPiece.y, tmpPiece.w, tmpPiece.h);
				tmpOp.AddPost(tmpPost);
				for (i=tmpPiece.y; i<tmpPiece.y+tmpPiece.h;i++)
				{														//  x            y			
					Predicate myPredicate = new Predicate("Clear", tmpPiece.x+tmpPiece.w,i);
					tmpOp.AddPre(myPredicate);
				}
				tmpPiece.Operators.add(tmpOp);
			}
			

			// Left Check
			wallflag = false;
			
			
			for (i=tmpPiece.y; i<tmpPiece.y+tmpPiece.h;i++)
			{
				if (room[i][tmpPiece.x-1]=='1') 
				{
					wallflag = true;
				}
			}
			if (!wallflag)
			{
				Operator tmpOp = new Operator("Left");
				Predicate tmpPredicate = new Predicate("At", tmpPiece.id, tmpPiece.x, tmpPiece.y, tmpPiece.w, tmpPiece.h);
				tmpOp.AddPre(tmpPredicate);
				Predicate tmpPost = new Predicate("At", tmpPiece.id, tmpPiece.x-1, tmpPiece.y, tmpPiece.w, tmpPiece.h);
				tmpOp.AddPost(tmpPost);
				
				for (i=tmpPiece.y; i<tmpPiece.y+tmpPiece.h;i++)
				{
					Predicate myPredicate = new Predicate("Clear", tmpPiece.x-1,i);
					tmpOp.AddPre(myPredicate);
				}
				
				tmpPiece.Operators.add(tmpOp);
			}
			
			// Up Check
			
			wallflag = false;
			for (i=tmpPiece.x; i<tmpPiece.x+tmpPiece.w;i++)
			{
				if (room[tmpPiece.y-1][i]=='1') 
				{
					wallflag = true;
				}
			}
			if (!wallflag)
			{
				Operator tmpOp = new Operator("Up");
				Predicate tmpPredicate = new Predicate("At", tmpPiece.id, tmpPiece.x, tmpPiece.y, tmpPiece.w, tmpPiece.h);
				tmpOp.AddPre(tmpPredicate);
				Predicate tmpPost = new Predicate("At", tmpPiece.id, tmpPiece.x, tmpPiece.y-1, tmpPiece.w, tmpPiece.h);
				tmpOp.AddPost(tmpPost);
				for (i=tmpPiece.x; i<tmpPiece.x+tmpPiece.w;i++)
				{
					Predicate myPredicate = new Predicate("Clear", i,tmpPiece.y-1);
					tmpOp.AddPre(myPredicate);
				}
				
				tmpPiece.Operators.add(tmpOp);
			}
			// Down Check
			
			wallflag = false;
			for (i=tmpPiece.x; i<tmpPiece.x+tmpPiece.w;i++)
			{
				if (room[tmpPiece.y+tmpPiece.h][i]=='1') 
				{
					wallflag = true;					
				}
			}
			if (!wallflag)
			{
				Operator tmpOp = new Operator("Down");
				Predicate tmpPredicate = new Predicate("At", tmpPiece.id, tmpPiece.x, tmpPiece.y, tmpPiece.w, tmpPiece.h);
				tmpOp.AddPre(tmpPredicate);
				Predicate tmpPost = new Predicate("At", tmpPiece.id, tmpPiece.x, tmpPiece.y+1, tmpPiece.w, tmpPiece.h);
				tmpOp.AddPost(tmpPost);
				for (i=tmpPiece.x; i<tmpPiece.x+tmpPiece.w;i++)
				{
					Predicate myPredicate = new Predicate("Clear", i,tmpPiece.y+tmpPiece.h);
					tmpOp.AddPre(myPredicate);
				}

				tmpPiece.Operators.add(tmpOp);
			}
			
		}


	}

	public static void main(String[]Args)
	{
		Room room = new Room("room.txt", true);
		room.Draw();
		room.fillOperators();
		for (Piece tmpPiece:room.Pieces)
		{
			tmpPiece.Draw();
		}
	}
}
