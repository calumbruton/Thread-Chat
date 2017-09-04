/*
 * A Client Thread
 */

package multithreading.project;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientThread extends Thread {
    protected Socket clientSocket;
    
    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    public void run() {
        try{
            String msg = "";
            while(!msg.equals("exit")){ 
                //Create a scanner that waits for the connected client socket input
                Scanner scanner = new Scanner(clientSocket.getInputStream());
                msg = scanner.nextLine();

                //update the message area with the message from the client
                msg_Server.msg_area.setText(msg_Server.msg_area.getText()+ msg + "\n");

                //Send a message back to the client
                PrintStream p = new PrintStream(clientSocket.getOutputStream());
                p.println("Server: Hello Client");
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }  
    
    }
}
