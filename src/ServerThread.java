import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.Date;

/**
 *
 * @author Alexander Basho
 */

public class ServerThread extends Thread {
    ServerSocket s;	
    Socket socket;
    /**
     *
     * @param socket
     */
    //Synchronize sockets 'Threads'
public ServerThread(Socket socket) throws IOException
{
        synchronized(this)
     {
         this.socket = socket;
     }
}

     public static String  Path = System.getProperty("user.dir");
	@SuppressWarnings("deprecation")
        
	public void run()  
	{	
		final String  Path = System.getProperty("user.dir");
          
		try 
		{
			//Mainresponse is the serverresponse
			String mainresponse = null;
			
			//Create datainputstream for read buffer. In other words to recieve and read client messages
			DataInputStream InputStream = new DataInputStream(socket.getInputStream());
			
			//Create file with the passwords of the users
			List<String> Passwords = Files.readAllLines(Paths.get(Path+"\\Passwords\\passwords.txt"));
			
			//Create variables for save username, password and saltedandhashed passwords
			String username = InputStream.readUTF();
			String password = InputStream.readUTF();
			String ClientNames[] = {"alexanderbasho","giorgosalexopoulos","dimitrisgiannopoulos"};
                        File file = null; 
                        
                         switch (username)
                        {
                            case "alexanderbasho":
                            {
                                file = new File(Path+"\\Logs\\"+ClientNames[0]+".txt");
                                break;
                            }
                            case "giorgosalexopoulos":
                            {
                                file = new File(Path+"\\Logs\\"+ClientNames[1]+".txt");
                                break;
                            }
                            case "dimitrisgiannopoulos":
                            {
                                file = new File(Path+"\\Logs\\"+ClientNames[2]+".txt");
                                break;    
                            }
                        }                      
                        file.setWritable(true);
                        file.setReadable(true);
                        file.getAbsolutePath();
                        FileWriter writer;
                        writer = new FileWriter(file,true);
                        BufferedWriter write = new BufferedWriter(writer);
                        Date date = new Date();
                        write.write("Date: "+date);
                        write.newLine();
                        
                        if(username.equals(ClientNames[0]) && password.equals(Passwords.get(0)))
                        {
                            //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                            DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                            mainresponse = "S: Hello "+ClientNames[0];
                            OutputStream1.writeUTF(mainresponse);
                            OutputStream1.flush();
                        }
                        if(username.equals(ClientNames[1]) && password.equals(Passwords.get(1)))
                        {
                            //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                            DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                            mainresponse = "S: Hello "+ClientNames[0];
                            OutputStream1.writeUTF(mainresponse);
                            OutputStream1.flush();
                        }
                        if(username.equals(ClientNames[2]) && password.equals(Passwords.get(2)))
                        {
                            //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                            DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                            mainresponse = "S: Hello "+ClientNames[0];
                            OutputStream1.writeUTF(mainresponse);
                            OutputStream1.flush();
                        }
				
			//Create variable to save inputs from client
			String message = null;
			
			while ((message = InputStream.readLine()) != null) 
			{
                            for(int i=0;i<ClientNames.length;i++)
                            {
                            if(message.equals("Discover Songs"))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "1) Eminem - Lose Yourself\n2) Pitbull - Hotel Room\n3) Akon ft. 50cent - Smack That\n4) Eminem - Not Afraid";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                break;
                            }
                            if(message.equals("1song"))
                            {
                                String sendFile = Path+"\\Server1\\Songs\\loseyourself.wav"; 
                                serverside(sendFile,57028992);
                                write.write("User "+username+" listened to the song: Eminem - Lose Yourself\n");
                                write.newLine();
                                write.close();
                            }
                            if(message.equals("4song"))
                            {
                                String sendFile = Path+"\\Server1\\Songs\\notafraid.wav"; 
                                serverside(sendFile,49733918);
                                write.write("User "+username+" listened to the song: Eminem - Not Afraid\n");
                                write.newLine();
                                write.close();
                            }
                            if(message.equals("download1"))
                            {
                                String sendFile = Path+"\\Server1\\Songs\\loseyourself.wav"; 
                                serverside(sendFile,57028992);
                                write.write("User "+username+" listened to the song: Eminem - Lose Yourself\n");
                                write.newLine();
                                write.close();
                                break;
                            }
                            if(message.equals("download4"))
                            {
                                String sendFile = Path+"\\Server1\\Songs\\notafraid.wav"; 
                                serverside(sendFile,49733918);
                                write.write("User "+username+" listened to the song: Eminem - Not Afraid\n");
                                write.newLine();
                                write.close();
                                break;
                            }
                            if(message.equals("afriends1"))
                            {
                                String sendFile = Path+"\\Logs\\"+ClientNames[1]+".txt";
                                serverside(sendFile,50000);
                                break;
                            }
                           if(message.equals("afriends2"))
                            {
                                String sendFile = Path+"\\Logs\\"+ClientNames[2]+".txt";
                                serverside(sendFile,50000);
                                break;
                            }
                           if(message.equals("gfriends1"))
                            {
                                String sendFile = Path+"\\Logs\\"+ClientNames[0]+".txt";
                                serverside(sendFile,50000);
                                break;
                            }
                           if(message.equals("gfriends2"))
                            {
                                String sendFile = Path+"\\Logs\\"+ClientNames[2]+".txt";
                                serverside(sendFile,50000);
                                break;
                            }
                           if(message.equals("dfriends1"))
                            {
                                String sendFile = Path+"\\Logs\\"+ClientNames[0]+".txt";
                                serverside(sendFile,50000);
                                break;
                            }
                           if(message.equals("dfriends2"))
                            {
                                String sendFile = Path+"\\Logs\\"+ClientNames[1]+".txt";
                                serverside(sendFile,50000);
                                break;
                            }                           
                            }	  
			}         
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
        
    public void serverside(String sendFile, int filesize) throws IOException
    { 
    FileInputStream wavinstream = null;
    BufferedInputStream bufinstream = null;
    OutputStream output = null;
    try {
      while (true) {
        System.out.println("Waiting...");
        try {
          System.out.println("Accepted connection : " + socket);
          // send file
          File wavFile = new File (sendFile);
          byte [] musicbytearray  = new byte [filesize];
          wavinstream = new FileInputStream(wavFile);
          bufinstream = new BufferedInputStream(wavinstream);
          bufinstream.read(musicbytearray,0,musicbytearray.length);
          output = socket.getOutputStream();
          System.out.println("Sending " + sendFile + "(" + musicbytearray.length + " bytes)");   
          output.write(musicbytearray,0,musicbytearray.length);
          output.flush();
          System.out.println("Done."); 
        }
        finally {
         
        }break;
      }
    }
    finally {
    }
  }
}