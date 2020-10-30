import java.net.*; 
import java.io.*; 
  
public class Server 
{ 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in       =  null; 
  
    public Server(int port) 
    { 
        try
        { 
            server = new ServerSocket(port); 
            System.out.println("Servidor iniciado"); 
  
            System.out.println("Esperando por clientes ..."); 
  
            socket = server.accept(); 
            System.out.println("Cliente aceito"); 
  
            // takes input from the client socket 
            in = new DataInputStream( 
                new BufferedInputStream(socket.getInputStream())); 
  
            String line = ""; 
  
            while (!line.equals("sair")) 
            { 
                try
                { 
                    line = in.readUTF(); 
                    System.out.println(line); 
  
                } 
                catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            } 
            System.out.println("Fechando conexão"); 
            socket.close(); 
            in.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        Server server = new Server(5000); 
    } 
} 
