import java.io.IOException;
import menu.MainMenu;
import util.Menu;

/**
 * This is a simple program to simulate a Dakar Race
 * For mor information about the Darkar you con enter to www.dakar.com
 */

/**
 * @author Pavel Shvets
 *         Noldis Chumacero
 *         
 *         https://github.com/nchumacero/cit260dakar.git
 *
 */
public class DakarRace {
	

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Darkar Race");
	
	 	Menu menu = new MainMenu();
        menu.display();
        System.out.println("Good-bye!");
		
       	// Call a _for_ creating all the cars
		// The objects will create according the register.
		/*
		System.out.println("Creating cars");
		System.out.println("Creating bikes");
		System.out.println("Creating trucks");		
		ArrayList<Car> listOfCars = new ArrayList<Car>();
		ArrayList<Bike> listOfBikes = new ArrayList<Bike>();
		ArrayList<Truck> listOfTrucks = new ArrayList<Truck>();
		listOfCars.add(new Car());
		listOfCars.add(new Car());
		listOfTrucks.add(new Truck());
		listOfCars.add(new Car());
		listOfBikes.add(new Bike());
		listOfBikes.add(new Bike());
		listOfCars.add(new Car());
		listOfTrucks.add(new Truck());		
		listOfCars.add(new Car());
		listOfBikes.add(new Bike());
		listOfBikes.add(new Bike());
		listOfCars.add(new Car());
		listOfCars.add(new Car());
		listOfTrucks.add(new Truck());
		listOfTrucks.add(new Truck());
		listOfTrucks.add(new Truck());
		
		System.out.println("Show the vehicles");
		System.out.println("There's no order because the number is assign in order of register.");
		// Call a _for_ showing all the cars, trucks and bikes
		// this call uses Polymorphism to show toString() in the objects
		// Show the cars
		for(Car car : listOfCars)
		{
			System.out.println(car.toString());
		}
		for(Bike bike : listOfBikes)
		{
			System.out.println(bike.toString());
		}
		for(Truck truck : listOfTrucks)
		{
			System.out.println(truck.toString());
		}
		System.out.println("Run!!!!");
		for(Car car : listOfCars)
		{
			car.setSpeed();
			car.run(KILOMETERS_400);
			System.out.println(car.toString());
		}
		for(Bike bike : listOfBikes)
		{
			bike.setSpeed();
			bike.run(KILOMETERS_300);
			System.out.println(bike.toString());
		}
		for(Truck truck : listOfTrucks)
		{
			truck.setSpeed();
			truck.run(KILOMETERS_400);
			System.out.println(truck.toString());
		}
		//Call the run in every object
		System.out.println("Show the first places");
		//Call for the three vehicles in every category
		Car bestCar = bestCar(listOfCars);
		Bike bestBike = bestBike(listOfBikes);
		System.out.println("Best Car: " + bestCar);
		System.out.println("Best Bike: " + bestBike);
		System.out.println("Best Truck: " + bestTruck(listOfTrucks));
		
		
		
		
		System.out.println("Store the race on disk");
		//storeRace("race01.txt", listOfCars, listOfBikes, listOfTrucks);
		
		// Clean all the lists
		listOfCars.clear();
		listOfBikes.clear();
		listOfTrucks.clear();
		
		System.out.println("Restore the race from disk");
		//retrieveRace("race01.txt", listOfCars, listOfBikes, listOfTrucks);
		
		
		for(Car car : listOfCars)
		{
			System.out.println(car.toString());
		}
		for(Bike bike : listOfBikes)
		{
			System.out.println(bike.toString());
		}
		for(Truck truck : listOfTrucks)
		{
			System.out.println(truck.toString());
		}
		*/
		
	}
}
