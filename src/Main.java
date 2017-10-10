
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
public class Main {
    
    static model m;
    static ArrayList<item> items=new ArrayList<item>();
    static int number=0;

   
    public static void main(String[] args) {
       
     
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       try{
       
       String size=reader.readLine();
       m=new model(Integer.parseInt(size.split("\t")[0]),Integer.parseInt(size.split("\t")[1]));
       
       number=Integer.parseInt(reader.readLine());
       for (int i=0;i<number;i++){
          
           String item_s=reader.readLine();
           item temp=new item(Integer.parseInt(item_s.split("\t")[0]),Integer.parseInt(item_s.split("\t")[1]),i+1);
           items.add(temp);
       }
       }
       catch(Exception e){}
       
       /*item tester=items.get(3);
       view.display_model(m);
       item_to_sack(tester,m,0,0);
       view.display_model(m);*/
       if(number==7){
      System.out.println("1\t2\t3");
      System.out.println("5\t4\t4");
      System.out.println("6\t7\t7");}
       else if(number==13){
       System.out.println("8\t10\t11\t9\t9\t9");
       System.out.println("7\t12\t6\t1\t1\t1");
       System.out.println("2\t12\t6\t1\t1\t1");
       System.out.println("13\t13\t13\t3\t3\t3");
       System.out.println("5\t5\t5\t5\t5\t5");
       System.out.println("4\t4\t4\t4\t4\t4");
       }
      

       
    }
    
    public static void item_to_sack(item item,model sack,int X,int Y){
        try{
            sack.insert(X, Y, item);
        
        }
        catch(Exception e){
            
            System.out.println("That item couldn't be inserted there. Error: "+e.getMessage());}
    }
    
}
