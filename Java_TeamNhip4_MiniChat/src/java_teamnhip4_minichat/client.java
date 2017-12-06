/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_teamnhip4_minichat;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.codehaus.jackson.map.ObjectMapper;
/**
 *
 * @author T.Công
 */
public class client {
    public String address;
    public int port;
    
    public client(){
        this.address = "localhost";
        this.port = 1234;
    }
    
    public client(String add, int p){
        this.address = add;
        this.port = p;
    }
    
    public MyMessage send(MyMessage m) throws Exception{
        try{
            Socket clientSocket = new Socket(this.address, this.port);
            ObjectMapper mapper = new ObjectMapper();
            
            String s = mapper.writeValueAsString(m);
                    
            OutputStream os = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(s);
            oos.flush();
            
            InputStream is = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String s1 = (String)ois.readObject();
            MyMessage m1 = mapper.readValue(s1, MyMessage.class);
            return m1;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("This is client.");
        String address = "localhost";
        int port = 1234;
        try{
            Socket clientSocket = new Socket(address, port);
            
            OutputStream os = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            String s = "ghjhkltujgfj";
            oos.writeObject(s);
            oos.flush();
            
            InputStream is = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String s1 = (String)ois.readObject();
            System.out.println("Receive from server: " + s1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
