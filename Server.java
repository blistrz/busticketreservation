
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //chatbox2 c=new chatbox();
        
Socket socket ;
InputStreamReader inputStreamReader ;
OutputStreamWriter outputStreamWriter ;
BufferedReader bufferedReader ;
BufferedWriter bufferedWriter ;
ServerSocket serversocket ;
serversocket = new ServerSocket(1433);

while (true) {
try {
socket = serversocket.accept();
inputStreamReader = new
InputStreamReader(socket.getInputStream());
outputStreamWriter = new
OutputStreamWriter(socket.getOutputStream());
bufferedReader = new
BufferedReader(inputStreamReader);
bufferedWriter = new
BufferedWriter(outputStreamWriter);


    String msgFromClient =bufferedReader.readLine();
    System.out.println("Client:"+msgFromClient);
//  while(true)  
//  {
    if(msgFromClient.equalsIgnoreCase("HELLO") || msgFromClient.equalsIgnoreCase("HI") || msgFromClient.equalsIgnoreCase("Yes") )
    {
        System.out.println("Client:"+msgFromClient);
        bufferedWriter.write("What kind of Help you need?Registration?Login?Ticket Reservation?View Ticket?Account Details?");        
        System.out.println("What kind of Help you need?\nRegistration?\nLogin?\nTicket Reservation?\nGenerate Ticket?\nAccount Details?");
       bufferedWriter.newLine();
       bufferedWriter.flush();
      // break;
    }
    else if(msgFromClient.equalsIgnoreCase("REGISTRATION"))
    {
        System.out.println("Client:"+msgFromClient);
        bufferedWriter.write("In Registration, you need to fill all mentioned details,authentic email and make sure to have strong password. ");
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
    else if(msgFromClient.equalsIgnoreCase("LOGIN"))
    {
        System.out.println("Client:"+msgFromClient);
        bufferedWriter.write("In Login,did you register youself?    ");
        bufferedWriter.write("If Yes, please enter the username and password which you entered at the time of registration");
       // break;
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
    else if(msgFromClient.equalsIgnoreCase("Ticket Reservation") || msgFromClient.equalsIgnoreCase("Ticket") || msgFromClient.equalsIgnoreCase("Reservation") )
    {
        System.out.println("Client:"+msgFromClient);
        bufferedWriter.write("In Ticket Reservation, Again Make sure to enter all given information.    ");
        bufferedWriter.write("At the time of Ticket Review, if you do not want to do reservation or made a mistake then select the cancel button. ");
       // break;
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
    else if(msgFromClient.equalsIgnoreCase("Ticket Generation") || msgFromClient.equalsIgnoreCase("Ticket bill") || msgFromClient.equalsIgnoreCase("Print the ticket") )
    {
        System.out.println("Client:"+msgFromClient);
        bufferedWriter.write("In Ticket generation, you do have a option of print which will save a pdf version of ticket in your desktop.    ");
       // bufferedWriter.write("At the time of Ticket Review, if you do not want to do reservation or made a mistake then select the cancel button. ");
       // break;
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
    else if(msgFromClient.equalsIgnoreCase("Account details") || msgFromClient.equalsIgnoreCase("login details") || msgFromClient.equalsIgnoreCase("Reservation details") || msgFromClient.equalsIgnoreCase("Payment details"))
    {
        System.out.println("Client:"+msgFromClient);
        bufferedWriter.write("In Details, it will show yours reservation/payment/login details.");
       // bufferedWriter.write("At the time of Ticket Review, if you do not want to do reservation or made a mistake then select the cancel button. ");
       // break;
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
    else if(msgFromClient.equalsIgnoreCase("OK")|| msgFromClient.equalsIgnoreCase("OKAY")|| msgFromClient.equalsIgnoreCase("OK,Got it"))
    {
        System.out.println("Client:"+msgFromClient);
        bufferedWriter.write("AnyThing else?");
        //break;
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
    else if(msgFromClient.equalsIgnoreCase("NO"))
    {
        System.out.println("Client:"+msgFromClient);
        bufferedWriter.write("Okay, All the best.");
        //break;
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
    if (msgFromClient.equalsIgnoreCase("BYE"))
    { 
        bufferedWriter.write("bye");
        System.out.println("bye");
       bufferedWriter.newLine();
       bufferedWriter.flush();
        //break;
    }
    
  //}

socket.close();
inputStreamReader.close();
outputStreamWriter.close();
bufferedReader.close();
bufferedWriter.close();
}
catch(IOException e)
{
e.printStackTrace();
}


}
}

}


