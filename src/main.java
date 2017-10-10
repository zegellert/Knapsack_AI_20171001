
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gellert Zelenak
 */
public class main {
    
    static model m;
    static ArrayList<item> items=new ArrayList<item>();

   
    public static void main(String[] args) {
       System.out.println("JUPITER");
     
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       try{
       System.out.println("Enter the width/height of the sack:");
       String size=reader.readLine();
       m=new model(Integer.parseInt(size.split("\t")[0]),Integer.parseInt(size.split("\t")[1]));
       System.out.println("Enter the number of items:");
       int number=Integer.parseInt(reader.readLine());
       for (int i=0;i<number;i++){
           System.out.println("Enter item#"+(i+1)+" width/height:");
           String item_s=reader.readLine();
           item temp=new item(Integer.parseInt(item_s.split("\t")[0]),Integer.parseInt(item_s.split("\t")[1]),i+1);
           items.add(temp);
       }
       }
       catch(Exception e){System.out.println("There was an error. Message: "+e.getMessage());}
       
       item tester=items.get(3);
       view.display_model(m);
       item_to_sack(tester,m,0,0);
       view.display_model(m);
      
      
       System.out.println("END");
       
    }
    
    public static void item_to_sack(item item,model sack,int X,int Y){
        try{
            sack.insert(X, Y, item);
        
        }
        catch(Exception e){
            
            System.out.println("That item couldn't be inserted there. Error: "+e.getMessage());}
    }
    
}
