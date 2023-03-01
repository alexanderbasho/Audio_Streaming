import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.net.Socket;
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

public class ServerThread2 extends Thread {
    ServerSocket s;	
    Socket socket;
    /**
     *
     * @param socket
     */
    //Synchronize sockets 'Threads'
public ServerThread2(Socket socket) throws IOException{
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
                        //Save username in String variable
			String username = InputStream.readUTF();
                        
			String input = InputStream.readUTF();
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
                        write.write("Date: "+date); // Write to the txt file
                        write.newLine();
                        
                    while(true)
                    {
			try 
			{
                            if(input.equals("download2") && username.equals(ClientNames[0]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush(); 
                                String sendFile = Path+"\\Server2\\Songs\\hotelroom.wav"; 
                                serverside(sendFile,34928906);
                                write.write("User "+username+" listened to the song: Pitbull - Hotel Room\n");
                                write.newLine();
                                write.close();
                            }
                            if(input.equals("download2") && username.equals(ClientNames[1]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\hotelroom.wav"; 
                                serverside(sendFile,34928906); 
                                write.write("User "+username+" listened to the song: Pitbull - Hotel Room\n");
                                write.newLine();
                                write.close();
                            }
                            if(input.equals("download2") && username.equals(ClientNames[2]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\hotelroom.wav"; 
                                serverside(sendFile,34928906);
                                write.write("User "+username+" listened to the song: Pitbull - Hotel Room\n");
                                write.newLine();
                                write.close();  
                            }
                            
                            if(input.equals("download3") && username.equals(ClientNames[0]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\smackthat.wav"; 
                                serverside(sendFile,37762966);
                                write.write("User "+username+" listened to the song: Akon feat. 50cent - Smack That\n");
                                write.newLine();
                                write.close();
                            }
                            if(input.equals("download3") && username.equals(ClientNames[1]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\smackthat.wav";  
                                serverside(sendFile,37762966);
                                write.write("User "+username+" listened to the song: Akon feat. 50cent - Smack That\n");
                                write.newLine();
                                write.close();
                            }
                            if(input.equals("download3") && username.equals(ClientNames[2]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\smackthat.wav"; 
                                serverside(sendFile,37762966);
                                write.write("User "+username+" listened to the song: Akon feat. 50cent - Smack That\n");
                                write.newLine();
                                write.close();  
                            }
                            
                            if(input.equals("2song") && username.equals(ClientNames[0]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\hotelroom.wav"; 
                                serverside(sendFile,34928906);
                                write.write("User "+username+" listened to the song: Pitbull - Hotel Room\n");
                                write.newLine();
                                write.close();
                            }
                            if(input.equals("2song") && username.equals(ClientNames[1]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\hotelroom.wav"; 
                                serverside(sendFile,34928906);
                                write.write("User "+username+" listened to the song: Pitbull - Hotel Room\n");
                                write.newLine();
                                write.close();
                            }
                            if(input.equals("2song") && username.equals(ClientNames[2]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\hotelroom.wav"; 
                                serverside(sendFile,34928906);
                                write.write("User "+username+" listened to the song: Pitbull - Hotel Room\n");
                                write.newLine();
                                write.close();  
                            }
                            
                            if(input.equals("3song") && username.equals(ClientNames[0]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\smackthat.wav"; 
                                serverside(sendFile,37762966);
                                write.write("User "+username+" listened to the song: Akon feat. 50cent - Smack That\n");
                                write.newLine();
                                write.close();
                            }
                            if(input.equals("3song") && username.equals(ClientNames[1]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\smackthat.wav"; 
                                serverside(sendFile,37762966);
                                write.write("User "+username+" listened to the song: Akon feat. 50cent - Smack That\n");
                                write.newLine();
                                write.close();
                            }
                            if(input.equals("3song") && username.equals(ClientNames[2]))
                            {
                                //Create dataoutputstream for write to buffer. In other words to send messages and to response to client
                                DataOutputStream OutputStream1 = new DataOutputStream(socket.getOutputStream());
                                mainresponse = "I dont have this song in my storage. I will connect you with Server 2";
                                OutputStream1.writeUTF(mainresponse);
                                OutputStream1.flush();
                                String sendFile = Path+"\\Server2\\Songs\\smackthat.wav"; 
                                serverside(sendFile,37762966);
                                write.write("User "+username+" listened to the song: Akon feat. 50cent - Smack That\n");
                                write.newLine();
                                write.close(); 
                            }
                            
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
                    }
                }catch (IOException e) 
			{
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