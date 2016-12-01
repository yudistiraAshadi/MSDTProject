package place;


/*****************************************************************
 * This class responsible for setting and getting place i.e 
  * This class has a constructor for setting  place.
*****************************************************************/

public class Place
{
    private String name;
    private String address;
    private int placeId;
    
    public Place( String name, String address, int placeId )
    {
        this.name = name;
        this.address = address;
        this.placeId = placeId;
    }

    public Place()
    {
        
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public int getPlaceId()
    {
        return placeId;
    }

    public void setPlaceId( int placeId )
    {
        this.placeId = placeId;
    }

    public String toString()
    {
        String indent = "\n";
        String nameString = "Name = " + name;
        String addressString = "Address = " + address;
        String placeIdString = "Place ID = " + placeId;
        String returnString = nameString + indent + addressString + indent + placeIdString;
        
        return returnString;
    }
    
}
