import java.net.InetAddress;
import java.util.Properties;
import javax.net.ssl.SSLException;
import com.intel.amt.sdk.*;
import com.intel.amt.api.*;
import java.util.Scanner;

/**
 * This class will send a wake-on-LAN command to an Intel AMT device.
 * 
 * @author Michael Fink @imafink
 * @version 1.0
 */

public class WakeUpSystemIntel {
    public static void wakeSystem(String ipAddress, String username, String password) {
        // Initialize AMT SDK properties
        Properties properties = new Properties();
        properties.setProperty("applicationName", "WakeUpSystem");
        properties.setProperty("useTls", "true");

        // Create connection details object
        ConnectionDetails connectionDetails = new ConnectionDetails(
                ipAddress, 16992, username, password, KvmUtil.getAmtPasswordCharset());

        // Create AMT session object
        AmtSession amtSession = new AmtSession(connectionDetails, properties);

        // Send power-on command to AMT device
        try {
            // Establish AMT session
            amtSession.connect();

            // Create power-on request object
            PowerUpRequest powerUpRequest = new PowerUpRequest(
                    PowerUpType.WOL, NetworkSettings.DEFAULT_WAKE_ON_LAN_PACKET);

            // Send power-on request to AMT device
            amtSession.getServiceProcessorClient().powerUp(powerUpRequest);

            // Disconnect AMT session
            amtSession.disconnect();

            System.out.println("Wake-on-LAN command sent to " + ipAddress);
        } catch (Exception e) {
            System.err.println("Error sending wake-on-LAN command: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String ipAddress = "";
        String username = "";
        String password = "";
        boolean repeat = true;

        // General print block
        System.out.println("Welcome to the Intel Wake-Up Program. Please follow the instructions below.")
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Username: ");
        username = scan.nextLine();
        System.out.println("Enter Password: ");
        password = scan.nextLine();
        System.out.println("Type exit to exit the program.");

        // Loop for multiple machines
        while (repeat) {
            System.out.println("Enter IP Address: ");
            ipAddress = scan.nextLine();
            if (ipAddress.equals("exit") || ipAddress.equals("Exit") || ipAddress.equals("EXIT")) {
                repeat = false;
            } else {
                wakeSystem(ipAddress, username, password);
            }
        }
        System.out.println("Thank you for using the Intel Wake-Up Program.");
        scan.close();
    }
}
