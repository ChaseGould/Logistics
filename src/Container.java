import java.util.Random;

public class Container {

	private static double minWeight = 10;
	private static double maxWeight = 20;	//weight in tons
	public double weight;
	

	public Container() {
		this.weight = weightGenerator();
	}
	
	
	public double weightGenerator() {
		Random rand = new Random();
		double value = rand.nextDouble()*(maxWeight - minWeight + 1) + minWeight;
		return value;
	}
	
	public double getWeight() {
		return weight;
	}
}
