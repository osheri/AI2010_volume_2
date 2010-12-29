package ai2010v2;

import java.io.Console;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.GNOME.Bonobo.Stream;

/*
 *   Room is a big container [like 30x30] it can contain smaller rooms
 *	
 * 
 * 
 * 
 * 
 * */
public class Room {
	public char room[][];
	
	public void Draw()
	{
		int i,j;
		for (i=0;i<30;i++)
		{
			for (j=0;j<30;j++)
			{
				System.out.write(room[i][j]);
			}
			System.out.write('\n');
		}
	}
	
	public Room(String filename)
	{
		int i,j;
		char c;
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
					if (c != '\n')
					room[i][j]=c;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public static void main(String[]Args)
	{
		Room room = new Room("room.txt");
		room.Draw();
	}
}
