package personalSchedule;

public class Event
{
    private String username;
    private Time time;
    private String address;
    private String notes;

    
    public Event( String username, Time time, String address, String notes )
    {
        this.username = username;
        this.time = time;
        this.address = address;
        this.notes = notes;
    }
    
    public Event()
    {
        
    }  
    
    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public Time getTime()
    {
        return time;
    }



    public void setTime( Time time )
    {
        this.time = time;
    }



    public String getAddress()
    {
        return address;
    }



    public void setAddress( String address )
    {
        this.address = address;
    }



    public String getNotes()
    {
        return notes;
    }



    public void setNotes( String notes )
    {
        this.notes = notes;
    }

    public String toString()
    {
        String indent = "\n";
        String timeString = time.toString();
        String addressString = "Address = " + address;
        String notesString = "Notes = " + notes;
        String returnString = timeString + indent + addressString + indent + notesString;
        
        return returnString;
    }
    
    
}
