# ADS-Project
Project made for Architecture and Software Design. Consists of a simple Java application that uses Homomorphic Encryption to communicate.
The client receives an input (integers), encrypts, sends to the factory, the factory evaluates (operates on the ciphertext), returns it to the client, the client decrypts and finally it shows the result to the user.

# Instalation
Use docker to run the factory jar, and then you can start the client jar on your workstation. The jar on your workstation will use TCP/4445 to communicate with the factory.
steps to configure factory:
1. cd to/the/root/of/the/project/
2. docker build -t 'project' .
3. docker run -p 4445:4445

# Usage
Run the jar in the folder /out/artifacts/Client/ADS-Project.jar
You can write anything in the name of the variables, and input integers in the values. The bigger the quality, the longer it'll take to get the solution. You can check the command line for the System.out's with all the messages arriving/departing.

