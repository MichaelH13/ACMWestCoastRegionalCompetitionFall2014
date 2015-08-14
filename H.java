import java.util.Scanner;

public class H {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int numRuns = in.nextInt();
		
		int numPushups = 0;
		int numScoreWays = 0;
		int totalPoints = 0;
		int[] scoreChart = {0,0,0};
		int lowestPoints = 0;
		
		for (int i = 0; i < numRuns; i++)
		{
			numPushups = in.nextInt();
			numScoreWays = in.nextInt();
			totalPoints = 0;
			
			scoreChart = new int[numScoreWays];
			
			lowestPoints = scoreChart[0];
			
			// verified that this works
			for (int j = 0; j < numScoreWays; j++)
			{
				scoreChart[j] = in.nextInt();
				
				if (scoreChart[j] < lowestPoints)
				{
					lowestPoints = scoreChart[j];
				}
			}
		
			int callNum = 1;
			
			totalPoints = calc(numPushups, scoreChart, callNum, totalPoints, lowestPoints);
			
			System.out.println(totalPoints);
		
		}	
	}
	
	private static int calc(int pushups, int[] scoreChart, int callNum, int totalPoints, int lowestPoints)
	{
		int points = 0;
		int newPoints = 0;
		int mostPoints = -1;
		int value = 0;
		int bestValue = 0;
		int ppushups = 0;
		
		for (int i = 0; i < scoreChart.length && scoreChart[i] * callNum < pushups; i++)
		{
			ppushups = pushups - scoreChart[i] * callNum;
			
			System.out.println(ppushups);
			
			if (ppushups == 0)
			{
				System.out.println("FOUND: " + scoreChart[i] * callNum);
				return (scoreChart[i] * callNum);
			}
			else if(ppushups < lowestPoints * callNum)
			{
				return -1;
			}
			else
			{
				newPoints = calc(ppushups, scoreChart, callNum + 1, 0, lowestPoints);
				
				if (newPoints > mostPoints)
				{
					mostPoints = newPoints;
					value = scoreChart[i];
				}				
			}
			
			if (mostPoints >= 0)
			{
				totalPoints += mostPoints;
				bestValue = value;
			}
		}
		
		if (mostPoints > -1)
		{
			return totalPoints + bestValue;
		}
		else
		{
			return -1;
		}
		
	}

}
