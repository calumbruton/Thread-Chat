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
   
    public static void main(String args[]) throws InterruptedException {
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
        
        Thread thread4 = new Thread() {
            public void run() {
                msg_Client msg_cli3 = new msg_Client();
                msg_cli3.run_client(msg_cli3);
            }
        };

        thread1.start();
        Thread.sleep(3000); //Sleeping the main function ensures the correct thread starting order
        thread2.start();
        Thread.sleep(3000);
        thread3.start();
        Thread.sleep(3000);
        thread4.start();              
    }
}
