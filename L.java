import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class L {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int loops = Integer.parseInt(in.next());
		for (int i = 0; i < loops; i++)
		{
			HashMap planets = new HashMap<String, int[]>();
			HashMap wormholes = new HashMap<String, HashSet<String>>();
			int distance = 0;
			
			int pLoops = Integer.parseInt(in.next());
			for(int j = 0; j < pLoops; j++)
			{
				String planet = in.next();
				int coord1 = Integer.parseInt(in.next());
				int coord2 = Integer.parseInt(in.next());
				int coord3 = Integer.parseInt(in.next());
				int[] pCoord = {coord1, coord2, coord3};
				planets.put(planet, pCoord);
			}
			int wloops = Integer.parseInt(in.next());
			for (int ll = 0; ll < wloops; ll++)
			{				
				String p1 = in.next();
				String p2 = in.next();
				for(int q = 0; q < planets.keySet().size(); q++)
				{
					if (wormholes.containsKey(planets.keySet().toArray()[i]))
					{
						HashSet pSet = (HashSet) wormholes.get(planets.keySet().toArray()[i]);
						if(pSet.contains(p1))
						{
							pSet.add(p1);
							wormholes.put(planets.keySet().toArray()[i], pSet);
						}
					}

					else
					{
						HashSet h = new HashSet<String>(); 
						h.add(p2);
						wormholes.put(p1, h);
					}
				}
			}

			int distLoops = Integer.parseInt(in.next());
			for(int k = 0; k < distLoops; k++)
			{
				String planet1 = in.next();
				String planet2 = in.next();
				if (wormholes.containsKey(planet1))
				{
					HashSet wormSet = (HashSet) wormholes.get(planet1);
					if(wormSet.contains(planet2)) //&& wormholes.get(planet1).equals(planet2))
					{
						distance = 0;
					}
					else
					{
						int[] p1Coords = (int[]) planets.get(planet1);
						int[] p2Coords = (int[]) planets.get(planet2);
						
						distance = (int) Math.pow(Math.pow(p1Coords[0] - p2Coords[0], 2) + Math.pow(p1Coords[1] - p2Coords[1], 2) + Math.pow(p1Coords[2] - p2Coords[2], 2), (float)1/2);

					}
				}
				
				else
				{
					System.out.println("proxima");
					int[] p1Coords = (int[]) planets.get(planet1);
					int[] p2Coords = (int[]) planets.get(planet2);
					distance = (int) Math.pow(Math.pow(p1Coords[0] - p2Coords[0], 2) + Math.pow(p1Coords[1] - p2Coords[1], 2) + Math.pow(p1Coords[2] - p2Coords[2], 2), (float)1/2);

				}

				System.out.println("The distance from " + planet1 + " to " + planet2 + " is " + distance + " parsecs.");
			}
			
		}
	}

}
