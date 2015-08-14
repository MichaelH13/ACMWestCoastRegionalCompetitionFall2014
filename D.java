import java.util.Scanner;


/* The Seg-Fault in Our Stars */

public class D {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int lines = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < lines; i++)
		{
			double n = Double.parseDouble(in.next());

			double m = Double.parseDouble(in.next());

			double a = Double.parseDouble(in.next());

			double b = Double.parseDouble(in.next());

			double c = Double.parseDouble(in.next());

			double d = Double.parseDouble(in.next());
			
			// See if this should actually be next line
			double r = Double.parseDouble(in.next());

			String t = Double.toString(n / m);

			
			double answer;
			
			if (Double.parseDouble(t) > 0)
			{
				answer = function(n, m, a, b, c, d, r, 1-2*(Double.parseDouble(t)), Double.parseDouble(t), 0, 0, t, t);
			}
			else
			{
				answer = function(n, m, a, b, c, d, r, -1-2*(Double.parseDouble(t)), Double.parseDouble(t), 0, 0, t, t);
			}
					
			System.out.println(answer);
		}		
	}

	private static double function(double n, double m, double a, double b, double c, double d, double r, double t, double firstT, double x, double y, String t2, String t3)
	{
		double answer = 0; 
				
		if (t == Double.parseDouble(t2) || t == firstT || t == Double.parseDouble(t3))
		{
			return -(x/(y-1));
		}
		else if (t > 0)
		{
			//answer = (c + (d + r * t * t) * function(n, m, a, b, c, d, r, 1 - 2 * t)) / r;
			System.out.println("---Double.parseDouble(t3)---------------------");
			System.out.println("t > 0");
			System.out.println("t: " + t);
			System.out.println("firstT: " + firstT);
			System.out.println("previousT: " + Double.parseDouble(t2));
			System.out.println("ppreviousT: " + Double.parseDouble(t3));
			System.out.println("x: " + x);
			System.out.println("y: " + y);
			t3 = t2;
			t2 = new Double(t).toString();
			return function (n, m, a, b, c, d, r, 1 - (2 * t), firstT, c, (d + (r * t * t) )/ r, t2, t3); 
		}
		else
		{
			//answer = (a + (b + r * t * t) * function(n, m, a, b, c, d, r, -1 - 2 * t)) / r;
			System.out.println("------------------------");
			System.out.println("t <= 0");
			System.out.println("t: " + t);
			System.out.println("firstT: " + firstT);
			System.out.println("previousT: " + Double.parseDouble(t2));
			System.out.println("ppreviousT: " + Double.parseDouble(t3));
			System.out.println("x: " + x);
			System.out.println("y: " + y);
			t3 = t2;
			t2 = new Double(t).toString();
			return function (n, m, a, b, c, d, r, -1 - (2 * t), firstT, a, (b + (r * t * t) )/ r, t2, t3); 
		}
	}
}
