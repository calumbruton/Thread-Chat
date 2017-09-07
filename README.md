# Thread-Chat

A multithreaded messenger application in Java

The program runs a server locally and creates clients that connect to the port
of the server socket. The server accepts the clients each on their own threads so that
it can communicate with them concurrently. 

By appending a unique username and socket pair to a HashMap each time a client is 
accepted by the server it has the ability to reply to any specific client thread 
by selecting their username on the right hand side of the GUI.

Run the main file to start the program
