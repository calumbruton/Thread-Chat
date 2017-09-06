/*
 * A Client Thread
 */

package multithreading.project;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientThread extends Thread {
    protected Socket clientSocket;
    protected String cli_name;
    
    public ClientThread(String cli_name, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.cli_name = cli_name;
    }
    
    public void run() {
        try{
            String msg = "";
            while(!msg.equals("exit")){ 
                //Create a scanner that waits for the connected client socket input
                Scanner scanner = new Scanner(clientSocket.getInputStream());
                msg = scanner.nextLine();

                //update the message area with the message from the client
                msg_Server.msg_area.setText(msg_Server.msg_area.getText()+ cli_name + ": " + msg + "\n");
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }  
    
    }
}
