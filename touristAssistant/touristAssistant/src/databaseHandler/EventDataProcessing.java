package databaseHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import personalSchedule.Event;
import personalSchedule.EventAttributes;
import personalSchedule.Time;
import user.User;

public class EventDataProcessing
{
    private static final String COMMA_DELIMITER = ",";
    private static final String EVENT_FILE_NAME = "event.csv";
    
    public static void saveEvent( Event event )
    {
        try ( BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter( EVENT_FILE_NAME, true ) ) ) {
            bufferedWriter.write( event.getUsername() );
            bufferedWriter.write( COMMA_DELIMITER );
            bufferedWriter.write( event.getTime().toString() );
            bufferedWriter.write( COMMA_DELIMITER );
            bufferedWriter.write( event.getAddress() );
            bufferedWriter.write( COMMA_DELIMITER );
            bufferedWriter.write( event.getNotes() );
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println( "Event has been saved." );
    }
    
    public static List<Event> getEvents( User user )
    {
        List<Event> eventResults = new ArrayList<Event>();
        try ( BufferedReader bufferedReader = new BufferedReader(
                new FileReader( EVENT_FILE_NAME ) ) ) {
            
            String eventDataLine = "";
            List<String> separatedEventData = new ArrayList<String>();
            String userUsername = user.getUsername();
            while ( ( eventDataLine = bufferedReader.readLine() ) != null ) {
                separatedEventData = CSVUtils.parseLine( eventDataLine );
                
                String username = separatedEventData.get( EventAttributes.USERNAME.ordinal() );
                if ( Pattern.compile( Pattern.quote( userUsername ) )
                        .matcher( username )
                        .find() ) {
                    
                    String timeInString = separatedEventData
                            .get( EventAttributes.TIME.ordinal() );
                    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date date = dateFormatter.parse( timeInString );
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime( date );
                    Time time = new Time( calendar );
                    
                    String address = separatedEventData
                            .get( EventAttributes.ADDRESS.ordinal() );
                    String notes = separatedEventData
                            .get( EventAttributes.NOTES.ordinal() );
                    eventResults.add( new Event( username, time, address, notes ) );
                }
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        } catch ( ParseException e ) {
            e.printStackTrace();
        }
        
        return eventResults;
    }
}
