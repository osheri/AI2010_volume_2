package ai2010v2;

public class Task {

	/**
	 * @param args
	 */
	
	public Room Source;
	public Room Destination;
	
	public Task(String source, String destination)
	{
		Source = new Room(source);
		Destination = new Room(destination);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
