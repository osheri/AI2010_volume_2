package ai2010v2;
/*
 *   Room is a big container [like 30x30] it can contain smaller rooms
 *   Small rooms are not objects by themselves, they're representing 
 *   available space in the big room where pieces of furniture can be placed
 *   every square have "wall flag": if it's opened to l,r,u,d
 *   1  : u
 *   2  : l
 *   4  : d
 *   8  : r
 * 
 * for example: empty square in the middle of the room have flag 0;
 * square in upper-left room corner will have 3;
 * 
 * if at least one of walls have flag, item of furniture cann't move there;
 * if square have wall flag on, adjacent square have opposite corresponding 
 * flag on (1-4; 2-8)
 * 
 * 
 * 
 * 
 * 
 * */
public class Room {
	public int room[][];
	
	public Room()
	{
		int i;
		room = new int[30][30];
		for(i=0;i<30;i++)
		{ // Generate outer walls;
			room[0][i]+=2;
			room[i][0]+=1;
			room[29][i]+=8;
			room[i][29]+=4;
		}
	}
}
