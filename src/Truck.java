import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Truck {
	
	private double capacity = 100; 
	private double totalWeight;
	private ArrayList<Container>Load;
	private static double availableWeight = 100;	
	
	public Truck(ArrayList<Container>cargo) {
		this.capacity = capacity;
		this.Load = cargo;
		this.totalWeight =  setTotalWeight(Load);
	}
	
	public ArrayList<Container> getLoad(){
		return Load;
	}
	
	public double setTotalWeight(ArrayList<Container> weightList) {
		double totalWeight = 0;
		for (Container e: weightList) {
			totalWeight += e.weight;
		}
		return totalWeight;
	}
	
	//takes a map, must convert into an array and then convert into an ArrayList!
	public static ArrayList<Container> toArrayList(HashMap<Integer, Container> mapy)
	{
		Container[] values = new Container[mapy.size()];
		values = (Container[]) mapy.values().toArray();
		ArrayList<Container> listValues = new ArrayList<>();
		for(int i = 0; i < mapy.size(); i += 1)
		{
			listValues.add(values[i]);
		}
		return listValues;
	}

	
	public double getTotalWeight() {
		return totalWeight;
	}
	
	public static double getAvailableWeight()	{
		return availableWeight;
	}
	
	public static void setAvailableWeight(double value)	{
		availableWeight -= value;
	}
	
	public static void resetWeight() {
		availableWeight = 100;
	}
}