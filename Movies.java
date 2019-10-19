//jmcdermott
//01451516
package SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;



public class Movies {
    //stuff needed
    private String serialNum;
    private int droppedOfBy;
    private String genre;
    private String name;
    
    private static Connection conn;
    private static Scanner sc;
    
    //drop it off bb
    public static  void dropOffMovie() {
    	Movies item = new Movies();
        int employeeId;
        try{
            employeeId = Employee.logIn();
            sc = new Scanner(System.in);
            System.out.print("Enter the serial number of the movie: ");
            item.setSerialNum(sc.nextLine());  

            item.setdroppedOfBy(employeeId);

            System.out.print("Enter the genre of the movie:");
            item.setgenre(sc.nextLine());   
            
            System.out.print("Enter the name of the movie:");
            item.setName(sc.nextLine());    

            Employee.dropOffMovie(item);
        } 
        catch(InvalidLoginException e){
            return;
        } 
        catch(Exception e){
            System.out.print(e.getLocalizedMessage());
        }
    }

    //pick it up bb
    public static void signMovieOut() {	
        Helper.printAllInventory();
        Movies item = new Movies();
        int loggedInemployeeId;
        sc = new Scanner(System.in);
        try {
            loggedInemployeeId = Employee.logIn();
            System.out.print("Enter the serial number of the movie you wish to take out: ");
            String userEnteredSerialNum = sc.nextLine();
            item.setSerialNum(userEnteredSerialNum);
            Employee.signMovieOut(item.getSerialNum(), loggedInEmployeeId);
        } 
        catch(InvalidLoginException e) {
            return;
        }
    }
    
    //for GET it and SET it
    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public int getdroppedOfBy() {
        return droppedOfBy;
    }

    public void setdroppedOfBy(int droppedOfBy) {
        this.droppedOfBy = droppedOfBy;
    }

    public String getgenre() {
        return genre;
    }

    public void setgenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}