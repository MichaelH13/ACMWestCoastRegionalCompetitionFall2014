import java.util.Scanner;

public class A {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int loops = in.nextInt();
		
		for (int i = 0; i < loops; i++)
		{
			System.out.println(getLowestNumFor(in.next()));
		}
	}
	
	private static int getLowestNumFor(String input)
	{
		String exp1 = getExp1(input);
		String exp2 = getExp2(input);
		String beforeOp = getBeforeOp(exp1);
		String afterOp = getAfterOp(exp1);
		String op = getOp(exp1);
		
		String replacement = "";
		
		for (int i = 0; i < 10; i++)
		{
			replacement = i;
			
			if (compute(beforeOp.replace('?', (char) i), afterOp.replace('?',  (char) i), op, exp2.replace('?', (char) i)))
			{
				return i;
			}
			
		}
	}
	
	private static boolean compute(String beforeOp, String afterOp, String op, String exp2)
	{
		switch (op)
		{	
			case "+":
				return (Integer.parseInt(beforeOp) + Integer.parseInt(afterOp) == Integer.parseInt(exp2));
			case "-":
				return (Integer.parseInt(beforeOp) - Integer.parseInt(afterOp) == Integer.parseInt(exp2));
			case "*":
				return (Integer.parseInt(beforeOp) * Integer.parseInt(afterOp) == Integer.parseInt(exp2));
				
		}	
		
		return false;
	}

}
