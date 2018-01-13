package vw_erl_clock_angle;

import java.util.Scanner;

/**
 *
 * @author anthony
 */
public class VW_ERL_Clock_Angle {
    
    public static final int HOUR = 0;
    public static final int MINUTE = 1;
    public static final int SECOND = 2;
    public static final int HOUR_ANGLE_STEP = 360/12;
    public static final int ANGLE_STEP = 360/60;
    
    public static void main(String[] args) {
        int[] time = new int[3];
        String oneMoreTime;
        do{
            time = queryTime();
            // Get angles between watch hand and origin (0)
            int hourAngle = getHourAngle(time);
            int minuteAngle = getMinuteAngle(time);
            int secondAngle = getSecondAngle(time);

            // compute angle between each watch hand
            int hourToMinuteAngle = hourAngle - minuteAngle;
            int minuteToSecondAngle = minuteAngle - secondAngle;
            int secondToHourAngle = secondAngle - hourAngle;

            // display values
            System.out.println("Hour to Minute: "+ hourToMinuteAngle);
            System.out.println("Minute to Second: "+ minuteToSecondAngle);
            System.out.println("Second to Hour: "+ secondToHourAngle);

            System.out.println("One more time ? (yes/no)");
            Scanner scan = new Scanner(System.in);
            oneMoreTime = scan.nextLine();
        }while(oneMoreTime.equalsIgnoreCase("yes"));
    }
    
    public static int[] queryTime(){
        int[] time = new int[3];
        Scanner scan = new Scanner(System.in);
        
        int hour = -1;
        do{
            System.out.println("Type your hour:");
            hour = scan.nextInt();
        }while(hour < 0 || hour >= 24); // check if it is a right hour value
        
        int min = -1;
        do{
            System.out.println("Type your minute:");
            min = scan.nextInt();
        }while(min < 0 || min >= 60); // check if it is a right minute value
        
        int sec = -1;
        do{
            System.out.println("Type your second:");
            sec = scan.nextInt();
        }while(sec < 0 || sec >= 60); // check if it is a right second value
        
        time[HOUR] = hour;
        time[MINUTE] = min;
        time[SECOND] = sec;
        return time;
    }
    
    public static int getHourAngle(int[] time){
        int hour = time[HOUR];
        int minute = time[MINUTE];
        // change hour to 12-hour format
        if(hour >= 12){
            hour -= 12;
        }
        // compute angle between hour watch hand and origin
        // add minute displacement 
        return hour * HOUR_ANGLE_STEP + (minute * HOUR_ANGLE_STEP)/60;
    }
    
    public static int getMinuteAngle(int[] time){
        return time[MINUTE] * ANGLE_STEP;
    }
    
    public static int getSecondAngle(int[] time){
        return time[SECOND] * ANGLE_STEP;
    }
}
