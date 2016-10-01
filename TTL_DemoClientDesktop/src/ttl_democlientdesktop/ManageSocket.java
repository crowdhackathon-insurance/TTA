package ttl_democlientdesktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageSocket {
    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    String address = "localhost";
    
    public String sendMessage(String mess)
    {
        out.println(mess);
        try {
            String clientCommand = in.readLine();
            System.out.println("Server answers: " + clientCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "" ;
    }
    
    public boolean closeSocketWithServer()
    {
        try {
            out.close();
            in.close();
            echoSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ManageSocket.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true ;
    }
    public boolean openSocketWithServer()
    {
        try {
            echoSocket = new Socket(address, 1234);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + "host");
            return false ;
        }
        
        return true ;
    }
    
    class ListenThread extends Thread {
        BufferedReader in;
        boolean running = true;
        
        ListenThread(BufferedReader br) {
            in = br ;
        }
        
        public void run() {
            try {
                while (running) {
                    String clientCommand = in.readLine();
                    System.out.println("" + clientCommand);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

