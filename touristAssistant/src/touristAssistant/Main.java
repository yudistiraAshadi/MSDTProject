package touristAssistant;

/*****************************************************************
 * This class responsible for starting the program i.e 
 * first it calls .
*****************************************************************/

import java.util.*;

import databaseHandler.PlaceDataProcessing;
import databaseHandler.UserDataProcessing;
import place.Place;
import user.User;

public class Main
{

    public static void main(String[] args)
    {
        findPlaceThree();
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
    
    public static void findPlace()
    {
        int placeId = 2;
        Place place = PlaceDataProcessing.findPlaceByPlaceId( placeId );
        System.out.println( place.getName() );
        System.out.println( place.getAddress() );
    }
    
    public static void findPlaceTwo()
    {
        try ( Scanner scanner = new Scanner( System.in ) ) {
            System.out.print( "\nInput keyword: " );
            String keyword = scanner.nextLine();
            
            List<Place> places = PlaceDataProcessing.findPlaceByName( keyword );
            
            for ( int i = 0; ( i < places.size() && i < 5 ); i++ ) {
                System.out.println( places.get( i ).toString() + "\n" );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
    public static void findPlaceThree()
    {
        try ( Scanner scanner = new Scanner( System.in ) ) {
            System.out.print( "\nInput keyword: " );
            String keyword = scanner.nextLine();
            
            List<Place> places = PlaceDataProcessing.findPlaceByKeyword( keyword );
            
            for ( int i = 0; ( i < places.size() && i < 5 ); i++ ) {
                System.out.println( places.get( i ).toString() + "\n" );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
