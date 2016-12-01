package userInterface;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Timer;

import databaseHandler.EventDataProcessing;
import personalSchedule.Event;
import personalSchedule.Reminder;
import personalSchedule.Time;
import user.User;

public class ScheduleMenu
{

    public static void menu(User user)
    {

        int choice = 0;
        System.out.println( "\n\tPlease Choose the following options : " );
        try ( Scanner scanner = new Scanner( System.in ) ) {
            System.out.println( "\n1. Schedule an Event" );
            System.out.println( "2. Set a Reminder" );
            choice = scanner.nextInt();
        } catch (NumberFormatException e ) {
            System.out.println("Your selection can only be an integer!");
        } catch (java.util.InputMismatchException err) {
            System.out.println("\nINVALID INPUT!");
        assert choice >2 : "choice is unexpectedly greater than range";
        assert choice <1 : "choice is unexpectedly lesser than range";
        if(choice == 1)
        {
            Time time = setTime();
            setEvent(user , time);
        }
        else if(choice == 2)
        {   
            System.out.println( "How many hours before you want a Reminder? " );
            int hoursBeforeReminder = 0;
            try ( Scanner scanner = new Scanner (System.in)){
                hoursBeforeReminder = scanner.nextInt();
            }catch (Exception e) {
                e.printStackTrace();
            }  
            setReminder( hoursBeforeReminder );
            System.out.println( "All set!" );
        }
        else{
            System.out.println( "Invalid input!\n" );
            menu(user);
        }
        }
    }
    public static void setReminder( int hoursBeforeReminder )
    {
        Event event = new Event();
        Timer alarm = new Timer();
        
        int minusHoursBeforeReminder = -hoursBeforeReminder;
        Calendar reminderTime = event.getTime().getCalendarFormat();
        reminderTime.add( Calendar.HOUR_OF_DAY, minusHoursBeforeReminder );
        
        alarm.schedule( 
                new Reminder( event ),
                reminderTime.getTime() );
        
    }
    public static Time setTime()
    {
         Time time = new Time();
         System.out.println( "Please input the Time : " );
         System.out.println( "Year :" );
         int year = 0;
         try ( Scanner scanner = new Scanner( System.in ) ) {
              year = scanner.nextInt();
              
             System.out.println( "Month :" );
             int month = 0;
             month = scanner.nextInt();
        
             System.out.println( "Date :" );
             int date = 0;
             date = scanner.nextInt();
              
             System.out.println( "Hour :" );
             int hour = 0;
             hour = scanner.nextInt();
         
             System.out.println( "Minutes :" );
             int minute = 0;
             minute = scanner.nextInt();
         
             time = new Time(year, month, date, hour, minute );
        }catch ( Exception e ) {
            e.printStackTrace();
        }
         
         return time;
     }
     public static void setEvent(User user,Time time)
     { 
         String username = user.getUsername();
         System.out.println( "Please input Address:" );
         String address = "";
         String notes = "";
         try ( Scanner scanner = new Scanner( System.in ) ) {
             address = scanner.nextLine();
             
             System.out.println( "Please input any note for Event : " );
             notes = scanner.nextLine();
          
         Event event = new Event(username, time, address, notes);
         EventDataProcessing.saveEvent( event );
         }catch (Exception e) {
             e.printStackTrace();
          }  
     }
     
}
