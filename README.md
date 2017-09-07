# Thread-Chat

A multithreaded messenger application in Java

The program runs a server locally and creates clients that connect to the port
of the server socket. The server accepts each incoming client and handles it with a new thread so that
it can communicate with them concurrently. 

By appending a unique username and socket pair to a HashMap each time a client is 
accepted by the server it has the ability to reply to any client
by selecting their username on the right hand side of the GUI.


Run the main file to start the program

![thread-chat-image](https://user-images.githubusercontent.com/12948431/30145949-1f34a0fe-9363-11e7-8a99-20357e1a93b5.jpg)
