/*
 * Calum Bruton
 */
package multithreading.project;

/**
 * The main method will open a server and run multiple clients on separate threads
 * for the user to work with
 */
public class Main {
    
    public static void run_server(){
        msg_Server msg_server = new msg_Server();
        String[] argum = {};
        msg_server.main(argum);
        
    }
   
    public static void main(String args[]) {
        Thread thread1 = new Thread() {
            public void run() {
                run_server();
            }
        };
            
        Thread thread2 = new Thread() {
            public void run() {
                msg_Client msg_cli1 = new msg_Client();
                msg_cli1.run_client(msg_cli1);
            }
        };
        
        
        Thread thread3 = new Thread() {
            public void run() {
                msg_Client msg_cli2 = new msg_Client();
                msg_cli2.run_client(msg_cli2);
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
              
    }
}
