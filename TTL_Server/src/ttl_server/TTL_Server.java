package ttl_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TTL_Server {
    static frmView myViews ;
    static private void prepareViews()
    {
        TTL_Server.myViews = new frmView() ;
        TTL_Server.myViews.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        ServerSocket m_ServerSocket = new ServerSocket(1234);
        TTL_Server.prepareViews() ;
        int id = 0;
        while (true) {
            Socket clientSocket = m_ServerSocket.accept();
            ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++);
            cliThread.start();
        }
    }
}

class ClientServiceThread extends Thread {
    Socket clientSocket;
    int clientID = -1;
    boolean running = true;
    pSOSReport currentSosPan  ;
    public static ArrayList<PrintWriter> arAllClients = new ArrayList<>() ;
    
    ClientServiceThread(Socket s, int i) {
        clientSocket = s;
        clientID = i;
    }
    
    public void run() {
        System.out.println("Accepted Client : ID - " + clientID + " : Address - "
                + clientSocket.getInetAddress().getHostName());
        try {
            BufferedReader   in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter   out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            arAllClients.add(out) ;
            while (running) {
                String clientCommand = in.readLine();
                System.out.println("Client"+ clientID +"("+clientSocket.getInetAddress().getHostName()+") Says :" + clientCommand);
                
                if (clientCommand.equalsIgnoreCase("quit")) {
                    running = false;
                    System.out.print("Stopping client thread for client : " + clientID);
                } else if (clientCommand.startsWith("#")) {
                    currentSosPan = TTL_Server.myViews.addSOSPanel(clientCommand,clientID +"("+clientSocket.getInetAddress().getHostName()+")") ;
                    for (PrintWriter pw : arAllClients)
                    {
                        if (out!=pw)
                        {
                            pw.println("HELP");
                            pw.flush();
                        }
                    }
                    
                }
                else
                {
                    currentSosPan.updateView(clientCommand) ;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}