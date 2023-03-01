import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alexander Basho
 */
public class Server2 
{
    /**
     * Define the port of the Server
     */
    public static final int PORT=8888; 
	
    /**
     *
     * @param args
     * @throws IOException
     */
    //Synchronize sockets 'Threads'
    public synchronized static void main(String[] args)throws IOException 
	{
		new Server2().runServer();
	}
	
    /**
     *
     * @throws IOException
     */
    public void runServer() throws IOException 
	{
		try 
		{
			//Create Socket for the Server
			ServerSocket serverSocket = new ServerSocket(PORT); 
			System.out.println("S: Server 2 is up and it is ready for connections");
			
			while(true)
			{
				//Client socket is accepted from the server
				Socket socket = serverSocket.accept(); 
				new ServerThread2(socket).start();
				System.out.println("S: Client with "+socket+" is Connected");
			}
		}
		catch (Exception e)
		{
            System.out.println("Error : " + e.getMessage());
        }
	}
}