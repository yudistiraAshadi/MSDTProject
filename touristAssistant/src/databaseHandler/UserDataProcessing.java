package databaseHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import user.User;
import user.UserAttributes;

/*****************************************************************
 * This class responsible for accessing the database of user i.e 
 * save user profile data or read it and check for username if its availab
 * This class allows to write user information on user.csv file.
*****************************************************************/

public class UserDataProcessing
{
    private static final String COMMA_DELIMITER = ",";
    private static final String USER_FILE_NAME = "user.csv";
    
    public static boolean userAuthentication(String username, String password)
    {
        boolean authenticationSuccess = false;
        try ( BufferedReader bufferedReader = new BufferedReader(
                new FileReader( USER_FILE_NAME ) ) ) {
            
            String userDataLine = "";
            List<String> separatedUserData = new ArrayList<String>();
            while ( ( userDataLine = bufferedReader.readLine() ) != null ) {
                separatedUserData = CSVUtils.parseLine( userDataLine );
                
                if ( username.equals( separatedUserData.get( UserAttributes.USERNAME.ordinal() ) ) ) {
                    if ( password.equals( separatedUserData.get( UserAttributes.PASSWORD.ordinal() ) ) ) {
                        authenticationSuccess = true;
                        System.out.println( "Log in success." );
                        return authenticationSuccess;
                    }
                    authenticationSuccess = false;
                    System.out.println( "Wrong password." );
                    return authenticationSuccess;
                }
            }
            authenticationSuccess = false;
            System.out.println( "Username doesn't exist." );
            return authenticationSuccess;
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        
        authenticationSuccess = false;
        System.out.println( "Error has occurred." );
        return authenticationSuccess; 
    }
    
    public static User getUserInformation(String username)
    {
        User user = new User();
        try ( BufferedReader bufferedReader = new BufferedReader(
                new FileReader( USER_FILE_NAME ) ) ) {
            
            String userDataLine = "";
            List<String> separatedUserData = new ArrayList<String>();
            while ( ( userDataLine = bufferedReader.readLine() ) != null ) {
                separatedUserData = CSVUtils.parseLine( userDataLine );
                
                if ( username.equals( separatedUserData.get( UserAttributes.USERNAME.ordinal() ) ) ) {
                    String password = separatedUserData.get( UserAttributes.PASSWORD.ordinal() );
                    String name = separatedUserData.get( UserAttributes.NAME.ordinal() );
                    user = new User( username, password, name );
                    break;
                }
            }
            
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public static boolean usernameAvailability(String username)
    {
        boolean usernameExistance = true;
        try ( BufferedReader bufferedReader = new BufferedReader(
                new FileReader( USER_FILE_NAME ) ) ) {
            String userDataLine = "";
            List<String> separatedUserData = new ArrayList<String>();
            while ( ( userDataLine = bufferedReader.readLine() ) != null ) {
                separatedUserData = CSVUtils.parseLine( userDataLine );
                
                if ( username.equals( separatedUserData.get( UserAttributes.USERNAME.ordinal() ) ) ) {
                    System.out.println( "Username is used." );
                    usernameExistance = false;
                    break;
                }
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        
        return usernameExistance;
    }
    
    public static void registerUser(User user)
    {
        try ( BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter( USER_FILE_NAME, true ) ) ) {
            bufferedWriter.write( user.getUsername() );
            bufferedWriter.write( COMMA_DELIMITER );
            bufferedWriter.write( user.getPassword() );
            bufferedWriter.write( COMMA_DELIMITER );
            bufferedWriter.write( user.getName() );
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println( "User has been registered." );
    }
}
