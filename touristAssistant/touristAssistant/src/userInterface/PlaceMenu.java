package userInterface;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import databaseHandler.PlaceDataProcessing;
import place.Place;
import place.UserReview;
import user.User;

public class PlaceMenu
{
    
    public static void Place(User user) throws IOException
    {
        int choice = 0;
        System.out.println( "\tPlease Select an Opton : " );
        try ( Scanner scanner = new Scanner( System.in ) ) {
             choice = scanner.nextInt();
            System.out.println( "\n1. Find Place" );
            System.out.println( "2. Write Review" );
        }catch (NumberFormatException e) {
            System.out.println("Your selection can only be an integer!");
        }catch (java.util.InputMismatchException err) {
            System.out.println("\nINVALID INPUT!");
            assert choice >2 : "choice is unexpectedly greater than range";
            assert choice <1 : "choice is unexpectedly lesser than range";
            if(choice == 1)
            {
                System.out.println( "\nPlease Input the Keyword : " );
                try ( Scanner scanner = new Scanner( System.in ) ) {
                    String keyword = scanner.nextLine();
                    findPlace(keyword);
                }catch (Exception e) {
                   e.printStackTrace();
                } 
            }
            else if(choice == 2)
            {  
                writeReview(user);
            }
            else{
                System.out.println( "Invalid input!\n" );
                Place(user);
            }
           
        }

    
        
         

    }
    
    public static void findPlace(String keyword)
    {
        List< Place > placeResults = PlaceDataProcessing.findPlaceByKeyword( keyword );
        System.out.println( placeResults );
    }
    public static void writeReview(User user)
    {
        String username = user.getUsername();
        System.out.println( "Please input placeID" );
        int placeID = 0;
        float ratings = 0;
        String comments = "";
        try ( Scanner scanner = new Scanner( System.in ) ) {
        placeID = scanner.nextInt(); 
       
        System.out.println( "Please input your comments about the place" );
        comments = scanner.nextLine();
        
        System.out.println( "Please input your ratings for place out of 10" );
        ratings = scanner.nextFloat();
        }catch (Exception e) {
           e.printStackTrace();
        }
        while(ratings >10.0 || ratings <0)
        {
            System.out.println( "Invalid Input!" );
            try ( Scanner scanner = new Scanner( System.in ) ) {
                ratings = scanner.nextFloat();
           }catch (Exception e) {
              e.printStackTrace();
           }
        }
        assert ratings >10.0 || ratings < 0 : "Ratings is unexpectedly not in range";
        UserReview userReview = new UserReview(username, placeID, comments, ratings);
    }
}
