import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;
import java.net.Socket;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 *
 * @author Alexander Basho
 */
public class Client 
{
    //Set the server IPs
    static String serverIP = "localhost";
    static String serverIP2 = "localhost";
         
    //Create input object for user input	
    static Scanner scan = new Scanner(System.in); 
 
    //Create global variables for using in this class
     private static final int PORT=7777;
     private static final int PORT2=8888;
     public static Socket socket = null;
     public static Socket socket2 = null;
     public static String  Path = System.getProperty("user.dir");
 
 private static synchronized void play(final InputStream in) throws Exception {
        AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream (in));
        try (Clip clip = AudioSystem.getClip()) 
        {
            System.out.println("To play the music press 1");
            int stop = scan.nextInt();   
            clip.open(ais);
            while(stop != 1 && stop != 2)
            {
                System.out.println("C: Not a correct number");
	 	stop = scan.nextInt();
            }
            while(stop == 1 || stop == 2)
            {             
            if(stop == 1)
            {
                clip.start(); 
                System.out.println("To pause the music press 2");
                stop = scan.nextInt();
                while(stop != 2)
            {
                System.out.println("C: Not a correct number");
	 	stop = scan.nextInt();
            }
                if(stop==2)
                {
                    clip.stop();
                    System.out.println("To resume the music press 1");  
                    stop = scan.nextInt();
                }         
            }  
            }
        }
    }
 
	static String username; //Create variable to save username string
	static String password; //Create variable to save password string
	static int third = 0 ; //Initialize variable for use after in a while loop 
	static String ClientNames[] = {"alexanderbasho","giorgosalexopoulos","dimitrisgiannopoulos"}; //Create array for ClientNames

   public static void main(String[] args) throws UnknownHostException, IOException,NoSuchAlgorithmException, InvalidKeySpecException, FileNotFoundException, Exception
 {
        System.out.println("Examples -> Server users:\n//First User: Username: alexanderbasho Password: alex1998\n//Second User: Username: giorgosalexopoulos Password: giorgos1998\n//Third User: Username: dimitrisgiannopoulos Password: dimitris1998\n You can write any username-password. If you write another password and username your program will close.");
	 //Client input his username and password
	 System.out.println("C: Enter username: ");
	 username = scan.nextLine(); 
	 System.out.println("C: Enter password: ");
	 password = scan.nextLine();
         
         //Create Client Socket
         socket = new Socket(serverIP,PORT);

	 //Create dataoutputstream to send messages and data to Server
	 DataOutputStream OutputStream = new DataOutputStream(socket.getOutputStream());
	 
         //Send username and password to Server
         OutputStream.writeUTF(username);
	 OutputStream.flush();
	 OutputStream.writeUTF(password);
	 OutputStream.flush();
	 //Create writer to send messages to Server, buffered reader to take input from user and datainputstream to read data from buffer (Server responses-messages)
       	 PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
	 DataInputStream dataIn = new DataInputStream(socket.getInputStream());

         System.out.println("\n"+dataIn.readUTF()+"\n");	// Read and Print Server messages 
         Scanner scan = new Scanner(System.in);
         System.out.println("C: 1) Enter to the menu");
 
 while(true)
 {
	//Select specified commands where are connected with specified numbers
	 int first = scan.nextInt();
	 //Check if the inserted number is correct. If true then continue or if false try again
	 while(first != 1 && first != 2)
	 {
	 	System.out.println("C: Not a correct number");
	 	first = scan.nextInt();
	 }
	 while(first == 1 || first == 2)
	 {
             System.out.println("\nC: 1) Discover the playlist\nC: 2) What are my friends listening to?");
             first = scan.nextInt();
		 if(first == 1)
		 {
			//Select specified commands where are connected with specified numbers
			 int second = 1;
                         
			//Check if the inserted number is correct. If true then continue or if false try again
		 while(second == 1)	
		 {	 
			//Select specified commands where are connected with specified numbers
		 if(second == 1)
			 {
                             switch(second)
                             {
                                 case 1:
                                 {
                                     switch(username)
                                     {
                                         case "alexanderbasho":
                                         {
                                            printWriter.println(("Discover Songs"));
                                            System.out.println("\nC: Select one of the songs");
                                            System.out.println(dataIn.readUTF());
                                            third = scan.nextInt();
                                            break;
                                         }
                                         case "giorgosalexopoulos":
                                         {
                                            printWriter.println(("Discover Songs"));
                                            System.out.println("\nC: Select one of the songs");
                                            System.out.println(dataIn.readUTF()); 
                                            third = scan.nextInt(); 
                                            break;
                                         }
                                         case "dimitrisgiannopoulos":
                                         {
                                            printWriter.println(("Discover Songs"));
                                            System.out.println("\nC: Select one of the songs");
                                            System.out.println(dataIn.readUTF());
                                            third = scan.nextInt();
                                            break;
                                         }                                        
                                     }
                                 }
                             }  
                          }
                                 System.out.println("Do you want to download the song or stream it? (Press 10 for download or 11 for streaming it from server.)");
                                 int check = scan.nextInt();
                                 
				//Check if the inserted number is correct. If true then continue or if false try again				
				 while(third != 1 && third!=2 && third!=3 && third!=4)
				 {
				 	System.out.println("C: Not a correct number");
				 	third = scan.nextInt();
				 }
				 while(third == 1 || third == 2 || third == 3 || third == 4)	
				 {
                                     
                                     if((check==10) && third == 1)
                                 {
                                     switch(username)
                                     {
                                         case "alexanderbasho":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[0]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\loseyourself.wav";
                                            music14("alexanderbasho",recieveFile,"download1",57028992);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Eminem - Lose Yourself");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\loseyourself.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                         case "giorgosalexopoulos":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[1]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\loseyourself.wav";
                                            music14("giorgosalexopoulos",recieveFile,"download1",57028992);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Eminem - Lose Yourself");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\loseyourself.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                         case "dimitrisgiannopoulos":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[2]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\loseyourself.wav";
                                            music14("dimitrisgiannopoulos",recieveFile,"download1",57028992);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Eminem - Lose Yourself");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\loseyourself.wav");
                                            playmusic(musicFile); 
                                            break;
                                         }
                                     }             
				 }
                                 if((check==11) && third == 1)
                                 {
                                        printWriter.println((third+"song"));                                                     
                                        InputStream is = socket.getInputStream();
                                        System.out.println("Playing Eminem - Loseyourself ... "); 
                                        play(is);        
                                        break;
                                 }
                                     
                                    if((check==10) && third == 2)
                                 { 
                                     switch(username)
                                     {
                                         case "alexanderbasho":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[0]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\hotelroom.wav";
                                            music23("alexanderbasho",recieveFile,"download2",34928906);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Pitbull - Hotel Room");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\hotelroom.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                         case "giorgosalexopoulos":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[1]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\hotelroom.wav";
                                            music23("giorgosalexopoulos",recieveFile,"download2",34928906);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Pitbull - Hotel Room");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\hotelroom.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                         case "dimitrisgiannopoulos":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[2]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\hotelroom.wav";
                                            music23("dimitrisgiannopoulos",recieveFile,"download2",34928906);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Pitbull - Hotel Room");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\hotelroom.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                     }    
                                 }
                                 if((check==11) && third == 2)
                                 {
                                       socket2 = new Socket(serverIP2,PORT2);
                                       DataOutputStream OutputStream2 = new DataOutputStream(socket2.getOutputStream());
                                       OutputStream2.writeUTF(username);
                                       OutputStream2.flush();
                                       OutputStream2.writeUTF(third+"song");
                                       OutputStream2.flush();
                                       DataInputStream dataIn2 = new DataInputStream(socket2.getInputStream());
                                       System.out.println(dataIn2.readUTF());    
                                       InputStream is = socket2.getInputStream();
                                       System.out.println("Playing Pitbull - Hotel Room ... "); 
                                       play(is);        
                                       break;
                                 }
				 
                                       if((check==10) && third == 3)  
                                 {    
                                     switch(username)
                                     {
                                         case "alexanderbasho":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[0]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\smackthat.wav";
                                            music23("alexanderbasho",recieveFile,"download3",37762966);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Akon feat. 50 Cent - Smack That");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\smackthat.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                         case "giorgosalexopoulos":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[1]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\smackthat.wav";
                                            music23("giorgosalexopoulos",recieveFile,"download3",37762966);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Akon feat. 50 Cent - Smack That");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\smackthat.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                         case "dimitrisgiannopoulos":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[2]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\smackthat.wav";
                                            music23("dimitrisgiannopoulos",recieveFile,"download3",37762966);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Akon feat. 50 Cent - Smack That");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\smackthat.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                     }     
                                 }
                                  if((check==11) && third == 3)
                                 {
                                       socket2 = new Socket(serverIP2,PORT2);
                                       DataOutputStream OutputStream2 = new DataOutputStream(socket2.getOutputStream());
                                       OutputStream2.writeUTF(username);
                                       OutputStream2.flush();
                                       OutputStream2.writeUTF(third+"song");
                                       OutputStream2.flush();
                                       DataInputStream dataIn2 = new DataInputStream(socket2.getInputStream());
                                       System.out.println(dataIn2.readUTF());
                                       
                                       InputStream is = socket2.getInputStream();
                                       System.out.println("Playing Akon feat. 50 Cent - Smack That ... "); 
                                       play(is);        
                                       break;
                                 }
          
                                 if((check==10) && third == 4)
                                 {
                                     switch(username)
                                     {
                                         case "alexanderbasho":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[0]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\notafraid.wav"; 
                                            music14("alexanderbasho",recieveFile,"download4",49733918);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Eminem - Not Afraid");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\notafraid.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                         case "giorgosalexopoulos":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[1]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\notafraid.wav"; 
                                            music14("giorgosalexopoulos",recieveFile,"download4",49733918);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Eminem - Not Afraid");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\notafraid.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                         case "dimitrisgiannopoulos":
                                         {
                                            String songs = Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\";
                                            String logs = Path+"\\Clients\\"+ClientNames[2]+"\\Logs\\";
                                            createdirectory(songs,logs);
                                            String recieveFile = Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\notafraid.wav"; 
                                            music14("dimitrisgiannopoulos",recieveFile,"download4",49733918);
                                            System.out.println("File successfully downloaded to path " + recieveFile+"\n Im playing the song that you just download: Eminem - Not Afraid");
                                            String musicFile = (Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\notafraid.wav");
                                            playmusic(musicFile);
                                            break;
                                         }
                                     }                                      
                                 }
                                  if((check==11) && third == 4)
                                 {
                                        printWriter.println((third+"song"));                                                     
                                        InputStream is = socket.getInputStream();
                                        System.out.println("Playing Eminem - Not Afraid ... "); 
                                        play(is);        
                                        break;
                                 }
                                    break;
                                 }
                                    break;
                                 }
                                    break;
                         }
                 
                    if(first==2)
                    { 
                        switch(username)
                        {
                            case "alexanderbasho":
                            {
                                 System.out.println("\n1) giorgosalexopoulos\n2) dimitrisgiannopoulos");
                             int friends = scan.nextInt();
                             if(friends==1)
                             {
                                 String songs = Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\";
                                        String logs = Path+"\\Clients\\"+ClientNames[0]+"\\Logs\\";
                                        createdirectory(songs,logs);                                                  
                                        String txtpath = Path+"\\Clients\\"+ClientNames[0]+"\\Logs\\friend"+ClientNames[1]+".txt";
                                        logs(txtpath,"afriends1",50000); 
                                        break;
                             }
                             else if(friends ==2)
                             {
                                 String songs = Path+"\\Clients\\"+ClientNames[0]+"\\Songs\\";
                                        String logs = Path+"\\Clients\\"+ClientNames[0]+"\\Logs\\";
                                        createdirectory(songs,logs);                                                  
                                        String txtpath = Path+"\\Clients\\"+ClientNames[0]+"\\Logs\\friend"+ClientNames[2]+".txt";
                                        logs(txtpath,"afriends2",50000);       
                                        break;
                             }
                            }
                            case "giorgosalexopoulos":
                            {
                                System.out.println("\n1) alexanderbasho\n2) dimitrisgiannopoulos");
                                int friends = scan.nextInt();
                             if(friends==1)
                             {
                                 String songs = Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\";
                                        String logs = Path+"\\Clients\\"+ClientNames[1]+"\\Logs\\";
                                        createdirectory(songs,logs);                                                  
                                        String txtpath = Path+"\\Clients\\"+ClientNames[1]+"\\Logs\\friend"+ClientNames[0]+".txt";
                                        logs(txtpath,"gfriends1",50000); 
                                        break;
                             }
                             else if(friends ==2)
                             {
                                 String songs = Path+"\\Clients\\"+ClientNames[1]+"\\Songs\\";
                                        String logs = Path+"\\Clients\\"+ClientNames[1]+"\\Logs\\";
                                        createdirectory(songs,logs);                                                  
                                        String txtpath = Path+"\\Clients\\"+ClientNames[1]+"\\Logs\\friend"+ClientNames[2]+".txt";
                                        logs(txtpath,"gfriends2",50000);  
                                        break;
                             }
                            }
                            case "dimitrisgiannopoulos":
                            {
                                System.out.println("\n1) alexanderbasho\n2) giorgosalexopoulos");
                                int friends = scan.nextInt();
                             if(friends==1)
                             {
                                 String songs = Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\";
                                        String logs = Path+"\\Clients\\"+ClientNames[2]+"\\Logs\\";
                                        createdirectory(songs,logs);                                                  
                                        String txtpath = Path+"\\Clients\\"+ClientNames[2]+"\\Logs\\friend"+ClientNames[0]+".txt";
                                        logs(txtpath,"dfriends1",50000); 
                                        break;
                             }
                             else if(friends ==2)
                             {
                                 String songs = Path+"\\Clients\\"+ClientNames[2]+"\\Songs\\";
                                        String logs = Path+"\\Clients\\"+ClientNames[2]+"\\Logs\\";
                                        createdirectory(songs,logs);                                                  
                                        String txtpath = Path+"\\Clients\\"+ClientNames[2]+"\\Logs\\friend"+ClientNames[1]+".txt";
                                        logs(txtpath,"dfriends2",50000); 
                                        break;
                             }
                            }
                        }
                    }                       
                    }
         }
}
 
   public static void playmusic(String musicFile) throws FileNotFoundException, IOException
{
    if(username.equals(ClientNames[0]) || username.equals(ClientNames[1]) || username.equals(ClientNames[2]))
{
    InputStream in = new FileInputStream(musicFile); 
    AudioStream audioStream = new AudioStream(in); 
    System.out.println("To play the music press 1");
            int stop = scan.nextInt();   
            while(stop != 1  && stop != 2)
            {
                System.out.println("C: Not a correct number");
	 	stop = scan.nextInt();
            }
            while(stop == 1 || stop == 2)
            {             
            if(stop == 1)
            {
                AudioPlayer.player.start(audioStream); 
                System.out.println("To pause the music press 2");
                stop = scan.nextInt();
                if(stop==2)
                {
                    AudioPlayer.player.stop(audioStream); 
                    System.out.println("To resume the music press 1");  
                    stop = scan.nextInt();
                }         
            }  
            }
}   
}     
   
   public static void createdirectory(String songs,String logs)
   {
       File theDir = new File(songs);
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        File theDir2 = new File(logs);
        if (!theDir2.exists()){
            theDir2.mkdirs();
        }
   }
 
   public static void music14(String client, String recieveFile, String printwriter, int fileSize) throws IOException
   {
       PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
       printWriter.println((printwriter));
       int readBytes;
       int currentBytes = 0;
       FileOutputStream wavoutstream = null;
       BufferedOutputStream bufoutstream = null;
       System.out.println("Connecting...");
       if(username.equals(ClientNames[0]) || username.equals(ClientNames[1]) || username.equals(ClientNames[2]))
    {
	try {                                                      
             byte [] musicbytearray  = new byte [fileSize];
            InputStream is = socket.getInputStream();
            wavoutstream = new FileOutputStream(recieveFile);
            bufoutstream = new BufferedOutputStream(wavoutstream);
            do {   
               readBytes = is.read(musicbytearray, currentBytes, (musicbytearray.length-currentBytes));
               if(readBytes >= 0) currentBytes += readBytes;     
               } while(currentBytes < fileSize);
            bufoutstream.write(musicbytearray, 0 , currentBytes);
            bufoutstream.flush();    
            }
             finally {
               if (wavoutstream != null) wavoutstream.close();
                if (bufoutstream != null) bufoutstream.close();
                 }
   }        
}
   
   public static void music23(String client, String recieveFile, String printwriter, int fileSize) throws IOException
   {
       socket2 = new Socket(serverIP2,PORT2);
       DataOutputStream OutputStream2 = new DataOutputStream(socket2.getOutputStream());
       OutputStream2.writeUTF(username);
       OutputStream2.flush();
       OutputStream2.writeUTF(printwriter);
       OutputStream2.flush();
       DataInputStream dataIn2 = new DataInputStream(socket2.getInputStream());
       System.out.println(dataIn2.readUTF());
       int readBytes;
       int currentBytes = 0;
       FileOutputStream wavoutstream = null;
       BufferedOutputStream bufoutstream = null;
       System.out.println("Connecting...");   
       if(username.equals(ClientNames[0]) || username.equals(ClientNames[1]) || username.equals(ClientNames[2]))
    {
	 try {                                                
              byte [] musicbytearray  = new byte [fileSize];
              InputStream is2 = socket2.getInputStream();
              wavoutstream = new FileOutputStream(recieveFile);
              bufoutstream = new BufferedOutputStream(wavoutstream);
              do {   
                   readBytes = is2.read(musicbytearray, currentBytes, (musicbytearray.length-currentBytes));
                   if(readBytes >= 0) currentBytes += readBytes;  
                 } while(currentBytes < fileSize);
              bufoutstream.write(musicbytearray, 0 , currentBytes);
              bufoutstream.flush();       
             }
              finally {
                       if (wavoutstream != null) wavoutstream.close();
                       if (bufoutstream != null) bufoutstream.close();
                      }
        }
   }
   
   public static void logs(String txtpath, String printwriter, int fileSize) throws IOException
   {                 
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        printWriter.println((printwriter));
        int readBytes;
        int currentBytes = 0;
        FileOutputStream wavoutstream = null;
        BufferedOutputStream bufoutstream = null;
        try
        {       
          byte [] musicbytearray  = new byte [fileSize];
          InputStream is = socket.getInputStream();
          wavoutstream = new FileOutputStream(txtpath);
          bufoutstream = new BufferedOutputStream(wavoutstream);
          do {   
               readBytes = is.read(musicbytearray, currentBytes, (musicbytearray.length-currentBytes));
               if(readBytes >= 0) currentBytes += readBytes; 
             } while(currentBytes < fileSize);
          bufoutstream.write(musicbytearray, 0 , currentBytes);
          bufoutstream.flush();
          try {               
                File myObj = new File(txtpath);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                }
                myReader.close();
               } catch (FileNotFoundException e) 
               {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
               }
        }
         finally 
         {
            if (wavoutstream != null) wavoutstream.close();
            if (bufoutstream != null) bufoutstream.close();
         }
    }                             
}