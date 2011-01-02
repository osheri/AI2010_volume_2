package ai2010v2;

public class Task {

	/**
	 * @param args
	 */
	
	public Room Source;
	public Room Destination;
	
	public Task(String source, String destination)
	{
		Source = new Room(source, true);
		Destination = new Room(destination, false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
