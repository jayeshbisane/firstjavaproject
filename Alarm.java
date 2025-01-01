import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SimpleAlarmClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input time for the alarm
        System.out.println("Set alarm time in format HH:mm (24-hour format): ");
        String alarmTime = scanner.nextLine();

        // Input optional alarm message
        System.out.println("Enter an optional alarm message (or leave blank): ");
        String message = scanner.nextLine();
        if (message.isEmpty()) {
            message = "Wake up!";
        }

        // Schedule the alarm
        scheduleAlarm(alarmTime, message);
        scanner.close();
    }

    // Method to schedule alarm using Timer
    public static void scheduleAlarm(String alarmTime, String message) {
        Timer timer = new Timer();

        // TimerTask to trigger alarm at set time
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println(message);
                timer.cancel(); // Stop the timer after the alarm
            }
        };

        try {
            // Parse the user input time
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date alarmDate = dateFormat.parse(alarmTime);
            
            System.out.println("Alarm set for " + alarmTime);

            // Schedule task at the specified alarm time
            timer.schedule(task, alarmDate);
        } catch (Exception e) {
            System.out.println("Invalid time format. Please use HH:mm.");
        }
    }
}
