package util;

import java.util.Scanner;

/**
 * Our menu base class to provide all the goodies for
 * writing menus.
 * 
 * @author kent
 *
 */
public class Menu {
    
    // We declare this as static so all of the Menu
    // objects we might create will share this one
    // variable. That way we don't create a lot of
    // different Scanner objects in our application.
    private static Scanner scanner;
    
    // This is a static initializer. It's like a constructor
    // for the class itself. It gets called when the class
    // is first loaded into memory. We'll initialize our scanner
    // in here.
    static {
        scanner = new Scanner(System.in);
    }
    
    /**
     * Constructor
     */
    protected Menu() {
        // empty constructor
    }
    
    /**
     * Provide the menu title. This could
     * be declared as an abstract method without a method body
     * because it doesn't really do anything useful. As an 
     * abstract method, a sub-class would be forced to provide
     * a real implementation (or body) of the method.
     * @return null to skip displaying a menu title.
     */
    protected String getTitle() {
        return null;
    }
    
    
    /**
     * Provide a menu description. This could
     * be declared as an abstract method without a method body
     * because it doesn't really do anything useful. As an 
     * abstract method, a sub-class would be forced to provide
     * a real implementation (or body) of the method.
     * @return null to skip displaying a description.
     */
    protected String getDescription() {
        return null;
    }
    
    /**
     * Provide the list of menu items. This could
     * be declared as an abstract method without a method body
     * because it doesn't really do anything useful. As an 
     * abstract method, a sub-class would be forced to provide
     * a real implementation (or body) of the method.
     * @return
     */
    protected MenuItem[] getMenuItems() {
        return new MenuItem[] {};
    }
    
    
    /**
     * Handle the user's menu selection. This could
     * be declared as an abstract method without a method body
     * because it doesn't really do anything useful. As an 
     * abstract method, a sub-class would be forced to provide
     * a real implementation (or body) of the method.
     * @param key
     * @return false if the menu should exit and return to whatever called it.
     */
    protected boolean handleMenuSelection(char key) {
        return false;
    }
    
    
    /**
     * The menu loop. When this method ends, the 
     * menu is closed and returns to whatever called
     * it.
     */
    public void display() {
        
        boolean keepGoing = true;
        
        while (keepGoing == true) {
            // print the title
            String title = getTitle();
            if (title != null) {
                System.out.println( title );
                System.out.println();
            }
            
            // print the description
            String description = getDescription();
            if (description != null) {
                System.out.println( description );
                System.out.println();
            }
            
            // print the menu items
            MenuItem[] menuItems = getMenuItems();
            if (menuItems == null) {
                System.out.println("Programmer error. Who designs a menu with no options?!");
                break;
            }
            
            for (MenuItem item : menuItems) {
                System.out.printf("%c - %s%n", item.getKey(), item.getText());
            }
            
            System.out.println();
            
            // prompt the user and get the menu choice
            String userInput = prompt("Your choice: ");
            
            System.out.println();
            
            // process the menu choice.
            if (userInput != null && userInput.length() > 0) {
                keepGoing = handleMenuSelection(userInput.charAt(0));
            }
            
            System.out.println();
        }
    }
    
    
    /**
     * Prompt the user for input, and return whatever they type. The user
     * must hit Enter before this will return the value.
     * @param message
     * @return The user's typed value.
     */
    public static String prompt(String message) {
        
        System.out.print(message);
        String input = scanner.nextLine();
        return input.trim();
    }
    
    
    /**
     * Pause the program for the specified number of milliseconds.
     * @param milliseconds
     */
    public static void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            // do nothing
        }
    }

}