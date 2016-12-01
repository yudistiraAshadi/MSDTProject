package userInterface;

import user.User;

public class UserProfile
{

    public static void getProfile(User user)
    {
        System.out.println( "\n\tUser Profile" );
        String username = user.getUsername();
        String password = user.getPassword();
        String name = user.getName();
        System.out.println( "\nName : " + name );
        System.out.println( "Username : " + username );
        System.out.println( "Password : " + password);
        System.out.println( "" );
        try {
            UI.Mainmenu( user );
        } catch ( Exception e ) {
            
            e.printStackTrace();
        }
    }   
}