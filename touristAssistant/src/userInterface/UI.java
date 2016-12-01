package userInterface;

import java.util.Scanner;

import user.User;

public class UI
{
    public static void Mainmenu(User user) throws Exception{
        boolean isRunning = true;
        while(isRunning){
        int choice = 0; 
        Scanner user_input = null;
        try { user_input = new Scanner( System.in );
        do{
            System.out.println( "\n\tPlease Select an Option from the Following :" );
            System.out.println( "\n1. User Profile" );
            System.out.println( "2. Find Place" );
            System.out.println( "3. Personal Schedule" );
            System.out.println( "4. Logout" );
            while(!user_input.hasNextLine()){
                System.out.print("Your selection can only be an integer!");
                user_input.next();
            }
        
            choice = user_input.nextInt();
        } while((choice <1) || (choice >4));
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            user_input.nextLine();
        }
        assert choice >4 || choice <1: "choice is unexpectedly not in range";
            switch(choice) {
                case 1: 
//                    System.out.println("1.User Profile");
                    UserProfile.getProfile(user);
                    return;
                case 2: 
//                  System.out.println("2. Find Place");
                    PlaceMenu.Place(user);
                    throw new RuntimeException("3!");
                case 3: 
                    System.out.println("3.Personal Schedule");
                    throw new Exception("3!");
                case 4: 
                    System.out.println("GoodBye");
                    isRunning = false;
            
            
            
            
            
            
            }
            }    
    } 
}
