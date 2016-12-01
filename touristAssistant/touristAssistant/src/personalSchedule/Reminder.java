package personalSchedule;

import java.util.TimerTask;

public class Reminder extends TimerTask
{
    private Event event;
    
    public Reminder( Event event )
    {
        this.event = event;
    }
    
    @Override
    public void run()
    {
        String eventString = event.toString();
        System.out.println( eventString );
    }

    public Event getEvent()
    {
        return event;
    }

    public void setEvent( Event event )
    {
        this.event = event;
    }
}
