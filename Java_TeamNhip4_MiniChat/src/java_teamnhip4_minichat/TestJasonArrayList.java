/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_teamnhip4_minichat;


import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author TANCONG
 */
public class TestJasonArrayList {
    
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("Cong(ThanhNho)");
        a.add("Luyt(CuCai)");
        a.add("Loc(ThanhDo)");
        a.add("Tuan(ThanhXam)");
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonString =  mapper.writeValueAsString(a);
            System.out.println(""+jsonString);
            
            ArrayList<String> b = mapper.readValue(jsonString, ArrayList.class);
            for (int i =0; i<b.size(); i++){
                String s = b.get(i);
                System.out.println(s);
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        System.out.println("finished");
    }

}
