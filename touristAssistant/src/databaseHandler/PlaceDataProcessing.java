package databaseHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import place.Place;
import place.PlaceAttributes;


/*****************************************************************
 * This class responsible for accessing the database of place i.e 
 * finding place by place id or by keyword or by place name.
 * This class allows user to write place data on place.csv file.
*****************************************************************/
public class PlaceDataProcessing
{
    private static final String PLACE_FILE_NAME = "place.csv";
    
    public static Place findPlaceByPlaceId( int placeId )
    {
        Place place = new Place();
        try ( BufferedReader bufferedReader = new BufferedReader(
                new FileReader( PLACE_FILE_NAME ) ) ) {
            
            String placeDataLine = "";
            List<String> separatedPlaceData = new ArrayList<String>();
            while ( ( placeDataLine = bufferedReader.readLine() ) != null ) {
                separatedPlaceData = CSVUtils.parseLine( placeDataLine );
                
                if ( placeId == Integer.parseInt(
                        separatedPlaceData.get( PlaceAttributes.PLACE_ID.ordinal() ) ) ) {
                    String name = separatedPlaceData.get( PlaceAttributes.NAME.ordinal() );
                    String address = separatedPlaceData.get( PlaceAttributes.ADDRESS.ordinal() );
                    place = new Place( name, address, placeId );
                    break;
                }
            }
            
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        
        return place;
    }
    
    public static List<Place> findPlaceByName( String inputName )
    {
        List<Place> placeResults = new ArrayList<Place>();
        try ( BufferedReader bufferedReader = new BufferedReader(
                new FileReader( PLACE_FILE_NAME ) ) ) {
            
            String placeDataLine = "";
            List<String> separatedPlaceData = new ArrayList<String>();
            while ( ( placeDataLine = bufferedReader.readLine() ) != null ) {
                separatedPlaceData = CSVUtils.parseLine( placeDataLine );
                
                if ( Pattern.compile( Pattern.quote( inputName ), Pattern.CASE_INSENSITIVE )
                        .matcher( separatedPlaceData.get( PlaceAttributes.NAME.ordinal() ) )
                        .find() ) {
                    
                    String name = separatedPlaceData
                            .get( PlaceAttributes.NAME.ordinal() );
                    String address = separatedPlaceData
                            .get( PlaceAttributes.ADDRESS.ordinal() );
                    int placeId = Integer
                            .parseInt( separatedPlaceData.get( PlaceAttributes.PLACE_ID.ordinal() ) );
                    placeResults.add( new Place( name, address, placeId ) );
                }
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        
        return placeResults;
    }
    
    public static List<Place> findPlaceByKeyword( String keyword )
    {
        List<Place> placeResults = new ArrayList<Place>();
        try ( BufferedReader bufferedReader = new BufferedReader(
                new FileReader( PLACE_FILE_NAME ) ) ) {
            
            String placeDataLine = "";
            List<String> separatedPlaceData = new ArrayList<String>();
            while ( ( placeDataLine = bufferedReader.readLine() ) != null ) {
                separatedPlaceData = CSVUtils.parseLine( placeDataLine );
                
                String name = separatedPlaceData.get( PlaceAttributes.NAME.ordinal() );
                String address = separatedPlaceData.get( PlaceAttributes.ADDRESS.ordinal() );
                if ( Pattern.compile( Pattern.quote( keyword ), Pattern.CASE_INSENSITIVE )
                        .matcher( name + " " + address )
                        .find() ) {
                    
                    int placeId = Integer
                            .parseInt( separatedPlaceData.get( PlaceAttributes.PLACE_ID.ordinal() ) );
                    placeResults.add( new Place( name, address, placeId ) );
                }
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        
        return placeResults;
    }
}
