#include <iostream>
#include <string>
#include "AMT.h" // Include the Intel AMT SDK header file

using namespace std;

void wakeUpSystem(const string& ipAddress, const string& username, const string& password) {
    try {
        // Initialize AMT SDK
        AMT::AMTSDKInitializer amtSDKInitializer;

        // Create connection details object
        AMT::AMTConnDetails connDetails(ipAddress, username, password);

        // Create AMT session
        AMT::AMTSession amtSession(connDetails);

        // Connect to AMT device
        amtSession.connect();

        // Send power-on command to AMT device
        AMT::AMTStatus status = amtSession.powerUp(AMT::AMTPowerUpType::PowerUp_WOL);

        // Disconnect from AMT device
        amtSession.disconnect();

        if (status == AMT::AMTStatus::OK) {
            cout << "Wake-on-LAN command sent to " << ipAddress << endl;
        }
        else {
            cout << "Failed to send wake-on-LAN command: " << AMT::AMTStatusToString(status) << endl;
        }
    }
    catch (exception& e) {
        cerr << "Error: " << e.what() << endl;
    }
}

int main() {
    string ipAddress;
    string username;
    string password;

    // Get user input
    cout << "Enter IP Address: ";
    getline(cin, ipAddress);
    cout << "Enter Username: ";
    getline(cin, username);
    cout << "Enter Password: ";
    getline(cin, password);

    // Call the wakeUpSystem function
    wakeUpSystem(ipAddress, username, password);

    return 0;
}