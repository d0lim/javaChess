package managePackage;



public class TurnManager {
	
	public static int turn=0;

	int index = 0;

	public static int[] turnArray = {0, 1, 2, 3};

	public void nextTurn1() {
		index++;
		index %= 4;
		turn = turnArray[index] % 2;
	}

	public void nextTurn2()
	{
		index++;
		index %= 4;
		turn = turnArray[index];
	}

	public void cmTurn(int cmTeam) {
		if(cmTeam == 0) {
			turnArray[cmTeam] = 2;
		}
		else if(cmTeam == 1) {
			turnArray[cmTeam] = 3;
		}
		else if(cmTeam == 2) {
			turnArray[cmTeam] = 0;
		}
		else if(cmTeam == 3) {
			turnArray[cmTeam] = 1;
		}
	}

	/*
	public void turnCheck()
	{
		turn = turn%2;
	}
	
	public void turnCheck2()
	{
		index = index % 4;
		turn = turn%4;
	}
	*/
}
