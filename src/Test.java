import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Test {
	
	
	//need to add comments and print lines so user know what program is doing

	public static void main(String[] args) {
		
		System.out.println("How many containers have we received?");
		
		Scanner input = new Scanner(System.in);
		int totalContainers = input.nextInt();
		
		HashMap<Integer, Container> containers = new HashMap<>();
		
		containersPopulate(containers, totalContainers);
		
		//System.out.println(containers.get(0).getValue().getWeight());
		
		containersDisplay(containers, totalContainers);
		
		//may need to send list to array to determine length. from javadocs public <T> T[] toArray(T[] a)
		
		ArrayList<Container> cargo = new ArrayList<>();
		
		ArrayList<Truck>Fleet = new ArrayList<>();
		
		loadShipment(containers, cargo, Fleet);
		
		System.out.println(Fleet.get(0).getTotalWeight());
		
		System.out.println("Containers left: " + containers.size());
		
		
		for (int i = 0; i < containers.size(); i += 1)
		{
		loadShipment(containers, cargo, Fleet);
		
		System.out.println(Fleet.get(1).getTotalWeight());
		
		System.out.println("Containers left: " + containers.size());
		}
		
		
		
		
		
		//certain keys have been removed from hashmap
		//need those elements to get skipped.
		
		
		
		
		
	}//end of testMethod
	
	public static void containersPopulate(HashMap<Integer,Container> containers, int totalContainers) {
		for (int i = 0; i < totalContainers; i++) {
			Container p1 = new Container();
			containers.put(i, p1);
			}		
		}//end of populate method
	
	
	public static void containersDisplay(HashMap<Integer, Container> containers, int totalContainers) {
		ArrayList<Container> List = new ArrayList<>();
		List = toArrayList(containers);
		
		for (int i = 0; i < totalContainers; i += 1) {
			System.out.print("Container " + (i+1) + ": ");
			System.out.printf("Weight: %4.2f", List.get(i).getWeight());
			System.out.println("\n");
		}
	}
	
	/*containers is made to be a hashmap because items are removed by a key
	*rather than by index. removing elements by index caused problems previously
	*because the number of elements changing through off the for loop.
	*/
	
	public static void loadShipment(HashMap<Integer, Container> containers, ArrayList<Container> cargo, 
			ArrayList<Truck> fleet){
			for(int i = 0; i < containers.size(); i += 1) {
				if (containers.get(i).weight < Truck.getAvailableWeight()) {
					Truck.setAvailableWeight(containers.get(i).weight);//keeps track of available weight
					cargo.add(containers.get(i));
					containers.remove(i); 
				}//end of if
			}//end of for loop
						
				Truck t1 = new Truck(cargo);//load truck with cargo
				fleet.add(t1);//truck added to fleet.
				cargo.clear();//remove all elements of vector cargo, because a new cargo must be made for next truck.
				Truck.resetWeight(); //reset available weight for next truck.
				
				ArrayList<Container> tempList = new ArrayList<>();
				tempList = toArrayList(containers);
				int sizeOfList = containers.size(); //size of map stored to be used in for loop
				containers.clear(); //empty map its about to be repopulated
				for(int i = 0; i < sizeOfList; i += 1)
				{
					containers.put(i, tempList.get(i));
				}
				
				/*
				 * at the end of this method you need to
				 * send whats left of the map to arraylist.
				 * then create a for each loop that puts the values back into the map.
				 * this is necessary so that there are no null pointers in the key list.
				 * you can get ride of the if null statement.
				 */
				
				
			
			
		}//end of method	
	
	//takes a map, must convert into an array and then convert into an ArrayList!
		public static ArrayList<Container> toArrayList(HashMap<Integer, Container> mapy)
		{
			Object[] values = new Object[mapy.size()];
			values = mapy.values().toArray();
			
			ArrayList<Container> listValues = new ArrayList<>();
			for(int i = 0; i < mapy.size(); i += 1)
			{
				listValues.add((Container) values[i]);
			}
			return listValues;
		}
	
	}//end of class

	


