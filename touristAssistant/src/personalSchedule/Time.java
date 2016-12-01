package personalSchedule;

/*****************************************************************
 * This class responsible for setting time i.e 
 * This class has a constructor for setting custom time with year,month,date,hour,minutes.
*****************************************************************/

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class Time
{
    private Calendar time;
    
    public Time()
    {
        time = Calendar.getInstance();
    }
    
    public Time(int year, int month, int date, int hour, int minute)
    {
        time = Calendar.getInstance();
        time.set( year, month, date, hour, minute );
    }
    
    public Time( Calendar calendar )
    {
        time = calendar;
    }
    
    public void setYear( int year )
    {
        time.set( Calendar.YEAR, year );
    }
    
    public void setMonth( int month )
    {
        time.set( Calendar.MONTH, month );
    }
    
    public void setDate( int date )
    {
        time.set( Calendar.DATE, date );
    }
    
    public void setHour( int hour )
    {
        time.set( Calendar.HOUR_OF_DAY, hour );
    }
    
    public void setMinute( int minute )
    {
        time.set( Calendar.MINUTE, minute );
    }
    
    public int getYear()
    {
        return time.get( Calendar.YEAR );
    }
    
    public int getMonth()
    {
        return time.get( Calendar.MONTH );
    }
    
    public int getDate()
    {
        return time.get( Calendar.DATE );
    }
    
    public int getHour()
    {
        return time.get( Calendar.HOUR_OF_DAY );
    }
    
    public int getMinute()
    {
        return time.get( Calendar.MINUTE );
    }
    
    public Date getDateFormat()
    {
        return time.getTime();
    }
    
    public Calendar getCalendarFormat()
    {
        return time;
    }
    
    public String toString()
    {
        Date date = time.getTime();
        String formattedDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm" ).format( date );
        
        return formattedDate;
    }
}
