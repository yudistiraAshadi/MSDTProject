package userInterface;

import java.util.Scanner;

import databaseHandler.UserDataProcessing;
import touristAssistant.Main;
import user.User;

public class UserAuthentication
{

    public static void LoginMenu()
    {   
        boolean isRunning = true;
        while(isRunning)
    {
        int choice = 0;
        Scanner user_input = null;
        try { user_input= new Scanner( System.in );
        do{
            System.out.println( "\n\tPlease Choose the following options : " );
            System.out.println( "1.Login " );
            System.out.println( "2.Register " );
            while(!user_input.hasNextLine()){
                System.out.println( "Input should be an Integer!" );
                user_input.next();
            }
            choice = user_input.nextInt();
        } while ((choice <1) || (choice >2));
        } catch (Exception e ) {
            e.printStackTrace();
        } finally {
            user_input.nextLine();
        }
        assert choice >2 || choice <1: "choice is unexpectedly not in range";
       switch (choice){
       case 1: 
       
            login();
            isRunning = false;
            break;
       case 2:
           
            register();
            break;
        default :
            System.out.println( "Invalid input!\n" );
            isRunning = true;
            
        }
        }
    } 
    
    
    public static void login()
    {
        User user = new User();
        try ( Scanner scanner = new Scanner( System.in ) ) {
            System.out.print( "\nInput username: " );
            String username = scanner.nextLine();
            
            System.out.print( "\nInput password: " );
            String password = scanner.nextLine();
            
            if ( UserDataProcessing.userAuthentication( username, password ) ) {
                user = UserDataProcessing.getUserInformation( username );
                System.out.println( "Hi " + user.getName() + "!" );
                
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        try {
            UI.Mainmenu( user );
        } catch ( Exception e ) {
           
            e.printStackTrace();
        }
    }
   
    
    public static void register()
    {
        // TODO Ask user to input their information (username, password, name)
        try ( Scanner scanner = new Scanner( System.in ) ) {
            System.out.print( "\nInput username: " );
            String username = scanner.nextLine();
            
            System.out.print( "\nInput password: " );
            String password = scanner.nextLine();
            
            System.out.print( "\nInput name: " );
            String name = scanner.nextLine();
            
            
            if ( ( username != "" ) && ( UserDataProcessing.usernameAvailability( username ) ) ) {
                System.out.println( "Username is available." );
                User user = new User( username, password, name );
                UserDataProcessing.registerUser( user );
                System.out.println( "User is registered." );
            } else {
                // TODO Return to beginning of the routine
                System.out.println( "Username is taken." );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
       
    }
    
}
