package managePackage;



public class TurnManager {
	
	public static int turn=0;
	
	public void nextTurn()
	{
		turn++;
	}
	
	public void turnCheck()
	{
		turn = turn%2;
	}
	
	
}
