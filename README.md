# Intel AMT Wake-Up Program

This is a simple C++ program that demonstrates how to use the Intel Active Management Technology (AMT) Software Development Kit (SDK) to connect to a computer's Intel Management Engine (IME) using the provided IP address, username, and password, and wake it up remotely.

## Prerequisites

Before running this program, make sure you have the following prerequisites installed:

- Intel AMT SDK: Download and install the Intel AMT SDK from the official Intel website. Follow the installation instructions provided with the SDK.

## Building the Program

To build the program, follow these steps:

1. Open a terminal or command prompt.
2. Navigate to the project directory.
3. Compile the program using a C++ compiler:
   g++ main.cpp -o amt-wake-up -lamt-sdk
Make sure to link against the Intel AMT SDK libraries (-lamt-sdk) properly. Adjust the command based on your build environment.

Running the Program
To run the program, execute the generated binary:
./amt-wake-up
The program will prompt you to enter the IP address, username, and password for the target Intel AMT-enabled computer. Once you provide the required information, the program will attempt to connect to the computer and send a wake-on-LAN command to wake it up.

Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

License
This project is licensed under the MIT License.