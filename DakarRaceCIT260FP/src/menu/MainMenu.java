package menu;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import dakar.Car;
import dakar.Bike;
import dakar.Truck;

import util.Menu;
import util.MenuItem;

public class MainMenu extends Menu {
	
	static int KILOMETERS_400 = 400;
	static int KILOMETERS_300 = 300;
	
	ArrayList<Car> listOfCars = new ArrayList<Car>();
	ArrayList<Bike> listOfBikes = new ArrayList<Bike>();
	ArrayList<Truck> listOfTrucks = new ArrayList<Truck>();

    /**
     * Default constructor. Does nothing.
     */
    public MainMenu() {
        super();
    }
    
    /**
     * Provide the menu title (or null to skip it)
     * @return
     */
    @Override
    protected String getTitle() {
        return "MAIN MENU";
    }
    
    
    /**
     * Provide a menu description, or null to skip it.
     * @return
     */
    @Override
    protected String getDescription() {
        return "This is the main menu of the program.";
    }
    
    /**
     * Provide the list of menu items.
     * @return
     */
    @Override
    protected MenuItem[] getMenuItems() {
        return new MenuItem[] {
                new MenuItem('1', "Create a CAR"),
                new MenuItem('2', "Create a BIKE"),
                new MenuItem('3', "Create a TRUCK"),
                new MenuItem('4', "List all Vehicles"),
                new MenuItem('5', "Simulate a RACE!"),
                new MenuItem('6', "Clean all vehicles"),
                new MenuItem('7', "I'm lazy... Create a full race"),
                new MenuItem('8', "Store the race to disk"),
                new MenuItem('9', "Retrieve the race from disk"),
                new MenuItem('W', "Show the [W]inners!"),
                //new MenuItem('H', "Help Menu"),
                new MenuItem('Q', "Quit Program")
        };
    }
    
    
    /**
     * Handle the user's menu selection.
     * @param key
     * @return false if the menu should exit and return to whatever called it.
     */
    @Override
    protected boolean handleMenuSelection(char key) {
       
        switch (Character.toUpperCase(key)) {
            case '1': 
            	createCar();
                break;
            case '2':
            	createBike();
                break;
            case '3':
            	createTruck();;
                break;
            case '4':
            	listAllVehicles();
                break;
            case '5':
            	simulateRace();
                break;                
            case '6':
            	cleanListsVehicles();
                break;                
            case '7':
            	createFullRace();
                break;  
            case '8':
			storeRace("MyRace.txt", listOfCars, listOfBikes, listOfTrucks);
                break;
            case 'W':
            	showWinners();
                break;                
            case 'H':
                Menu helpMenu = new HelpMenu();
                helpMenu.display();
                break;
            case 'Q':
                return false;
                
            default:
                System.out.println("Invalid Entry");
            
        }
        
        return true;
    }
    
    /*
     * Option 1 : Create a Car
     * 
     * This option create a new Car object. 
     * The new car is added to the listOfCar Array.
     * 
     * */
    
    void createCar()
    {
    	Car car = new Car();
    	listOfCars.add(car);
    	System.out.println("A new car was created: " + car);
    }
    
    /*
     * Option 2 : Create a Bike
     * 
     * This option create a new Bike object.
     * The new bike is added to the listOfBikes Array. 
     * 
     * */
    
    void createBike()
    {
    	Bike bike = new Bike();
    	listOfBikes.add(bike);
    	System.out.println("A new bike was created: " + bike);
    }    
    
    /*
     * Option 3 : Create a Truck
     * 
     * This option create a new Truck object.
     * The new truck is added to the listOfTrucks Array. 
     * 
     * */
    
    void createTruck()
    {
    	Truck truck = new Truck();
    	listOfTrucks.add(truck);
    	System.out.println("A new truck was created: " + truck);
    }    
    
    
    /*
     * Option 4 : List all Vehicles
     * 
     * This option uses a for to list all the vehicles
     * every object uses his own polymorphic method to list
     * the vehicle
     * The vehicle can be: Car, Bike or Truck
     * 
     * */
    
    public void listAllVehicles()
    {
    	System.out.println("List of vehicles");
    	String emptyList = "The list is empty";
	    for(Car car : listOfCars)
		{
			System.out.println(car.toString());
			emptyList = "";
		}
		for(Bike bike : listOfBikes)
		{
			System.out.println(bike.toString());
			emptyList = "";
		}
		for(Truck truck : listOfTrucks)
		{
			System.out.println(truck.toString());
			emptyList = "";
		}
		if (emptyList != "")
		{
			System.out.println(emptyList);
		}
    }
    
    /*
     * Option 5 : Simulate a Race!
     * 
     * This option give some kilometers to race to the objects
     * Every object runs in a random speed.
     * According to the object the speed is different using polymorfism
     *  
     * */
    
    public void simulateRace()
    {
		for(Car car : listOfCars)
		{
			car.setSpeed();
			car.run(KILOMETERS_400);
			System.out.println(car.toString());
		}
		for(Bike bike : listOfBikes)
		{
			bike.setSpeed();
			bike.run(KILOMETERS_400);
			System.out.println(bike.toString());
		}
		for(Truck truck : listOfTrucks)
		{
			truck.setSpeed();
			truck.run(KILOMETERS_400);
			System.out.println(truck.toString());
		}
    	System.out.println("The race ends.");
    }    
    
    
    /*
     * Option 6 : Clean all list of vehicles
     * 
     * This option clean all the lists
     * List of Cars
     * List of Bikes
     * List of Trucks
     * 
     * */
    
    public void cleanListsVehicles()
    {
    	
    	listOfCars.clear();
    	listOfBikes.clear();
    	listOfTrucks.clear();
    	System.out.println("All the list of vehicles ware cleaned.");
    }    
    
    
    /*
     * Option 7 : I'm lazy... create a full race
     * 
     * This option clean all the lists
     * Create some cars
     * Create some bikes
     * Create some trucks
     * Simulate the race and show the results
     * Show the winners of the race
     * Store all the race
     * Clean the lists
     * Retrieve the race
     * 
     * */
    
    public void createFullRace()
    {
    	cleanListsVehicles();
    	createCar();
    	createTruck();
    	createCar();
    	createBike();
    	createTruck();
    	createTruck();
    	createBike();
    	createCar();
    	createTruck();
    	createCar();
    	createBike();
    	createBike();
    	createTruck();
    	createCar();
    	createTruck();
    	createBike();
    	createTruck();
    	simulateRace();
    	showWinners();
    	storeRace("race01.txt", listOfCars, listOfBikes, listOfTrucks);
    	cleanListsVehicles();
		retrieveRace("race01.txt", listOfCars, listOfBikes, listOfTrucks);
		listAllVehicles();		
    }
    
    /*
     * Option 8 : Store the race to disk
     * 
     * Store the race on the disk
     * All the Cars
     * All the Bikes
     * All the Trucks
     * 
     * */
    
    public static void storeRace(String fileName, ArrayList<Car> cars, ArrayList<Bike> bikes, ArrayList<Truck> trucks)
	{
		PrintWriter file;
		try {
			file = new PrintWriter(fileName);
		    for(Car car : cars)
		    {
		    	file.println(car.toString());
		    }
		    for(Bike bike : bikes)
		    {
		    	file.println(bike.toString());
		    }
		    for(Truck truck : trucks)
		    {
		    	file.println(truck.toString());
		    }
		    file.close();
		    System.out.println("All the vehicles ware stored on disk.");
		} catch (FileNotFoundException e) {
			System.out.println("There was an error writing to the diks.");
		}
	}
    
    /*
     * Option 9 : Retrieve the race from disk
     * 
     * Retrieve all the vehicles from disk
     * All the Cars
     * All the Bikes
     * All the Trucks
     * 
     * */
    
    public static void retrieveRace(String fileName, ArrayList<Car> cars, ArrayList<Bike> bikes, ArrayList<Truck> trucks) 
	{
		java.io.File file = new java.io.File(fileName);
		Scanner input;
		try {
			input = new Scanner(file);
			String number = null;
			String speed = null;
			String distance = null;
			String stringDistance;
			String doubleDistance;
			while(input.hasNext())
			{
				String line = input.next();
				if (("CarBikeTruck").contains(line))
				{
					number = input.next();
					speed = input.next();
					speed = speed.substring(2, speed.indexOf("K"));
					distance = input.next();
					distance = distance.substring(2);
					stringDistance = input.next();
					doubleDistance = input.next();
					System.out.println("Car");
					System.out.println("number " + number);
					System.out.println("speed " + speed);
					System.out.println("distance " + distance);
					System.out.println("stringDistance " + stringDistance);
					System.out.println("doubleDistance " + doubleDistance);
				}
				System.out.println(line);
				switch(line)
				{
				    case "Car":
				    	Car car = new Car();
				    	car.setNumber(Integer.parseInt(number));
				    	car.setSpeed(Double.parseDouble(speed));
				    	car.setDistance(Double.parseDouble(distance));
				    	cars.add(car);
				    	break;
				    case "Bike":
				    	Bike bike = new Bike();
				    	bike.setNumber(Integer.parseInt(number));
				    	bike.setSpeed(Double.parseDouble(speed));
				    	bike.setDistance(Double.parseDouble(distance));
				    	bikes.add(bike);
				    	break;
				    case "Truck":
				    	Truck truck = new Truck();
				    	truck.setNumber(Integer.parseInt(number));
				    	truck.setSpeed(Double.parseDouble(speed));
				    	truck.setDistance(Double.parseDouble(distance));
				    	trucks.add(truck);
				    	break;
				    default: 
	                    System.out.println("There was an error loading the records");
	            }
			}
			input.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("There was an error reading from disk");
		}
	}
    
    /*
     * Option W : Show the winners
     * 
     * List the winners of the race
     * Winner of cars
     * Winner of bikes
     * Winner of trucks
     * 
     * */
    
    public void showWinners()
    {
     	System.out.println("Best Car: " + bestCar(listOfCars));
		System.out.println("Best Bike: " + bestBike(listOfBikes));
		System.out.println("Best Truck: " + bestTruck(listOfTrucks));
    }    
    
    
    
    /*
     * bestCar: search for the best Car in the race according with the time
     * and distance.
     * */
	public static Car bestCar(ArrayList<Car> Cars)
	{
		double bestTime = 9999999;
		Car bestCar = null;
		for(Car car : Cars)
		{
			if (car.getLongTimeTraveled() < bestTime)
			{
				bestTime = car.getLongTimeTraveled();
				bestCar = car;
			}
		}
		return bestCar;
	}
	
    /*
     * bestBike: search for the best Bike in the race according with the time
     * and distance.
     * */
	public static Bike bestBike(ArrayList<Bike> Bikes)
	{
		double bestTime = 9999999;
		Bike bestBike = null;
		for(Bike bike : Bikes)
		{
			if (bike.getLongTimeTraveled() < bestTime)
			{
				bestTime = bike.getLongTimeTraveled();
				bestBike = bike;
			}
		}
		return bestBike;
	}
	
	
    /*
     * bestTruck: search for the best Truck in the race according with the time
     * and distance.
     * */
	public static Truck bestTruck(ArrayList<Truck> Trucks)
	{
		double bestTime = 9999999;
		Truck bestTruck = null;
		for(Truck truck : Trucks)
		{
			if (truck.getLongTimeTraveled() < bestTime)
			{
				bestTime = truck.getLongTimeTraveled();
				bestTruck = truck;
			}
		}
		return bestTruck;
	}
}