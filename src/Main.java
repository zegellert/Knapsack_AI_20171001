
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
    static ArrayList<item> strays=new ArrayList<item>();
    static ArrayList<cumulative> cumulatives=new ArrayList<cumulative>();
    static int number=0;

   
    public static void main(String[] args) {
       
     
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       try{
       
       String size=reader.readLine();
       m=new model(Integer.parseInt(size.split("\t")[0]),Integer.parseInt(size.split("\t")[1]));
       for(int i=0;i<m.height;i++){
           cumulative c=new cumulative(m.height);
           cumulatives.add(c);
       }
       
       number=Integer.parseInt(reader.readLine());
       for (int i=0;i<number;i++){
          
           String item_s=reader.readLine();
           item temp=new item(Integer.parseInt(item_s.split("\t")[0]),Integer.parseInt(item_s.split("\t")[1]),i+1);
           items.add(temp);
       }
       }
       catch(Exception e){}
       
       for(int i=0;i<items.size();i++){
           try_to_fit(items.get(i),m,0,0);
       }
       
       if(strays.size()>0){}
       
       view.display_model(m);
       display_cumulatives(cumulatives);
       
       
       
      

       
    }
    
    public static void try_to_fit(item item,model sack,int X,int Y){
        if(X>sack.width){
            System.out.println("Item went to strays.");
            strays.add(item);
        }
        else{
            
            
        int column=X;
        int row=0;
        
        ///COLUMN CHOOSING LOOP:
        ///THIS OUGHT TO BE DONE IN A WHILE LOOP:
        for(int i=0;i<cumulatives.size();i++){
            cumulative c=cumulatives.get(i);
            System.out.println("Item is: "+item.value+" Height is: "+item.height+" Col is: "+i+" Space is: "+c.space);
            
            if(item.height<=c.space){
                column=i;
                row=c.next;
                System.out.println("Chosen column: "+column+", row: "+row);
                break;
            }
            
        }
       
        
        try{
        item_to_sack(item,m,column,row);}
        catch(Exception e){
            System.out.println("Item went to strays.");
            strays.add(item);
        }
        
        
        }//END OF ELSE
        
        
        
        
      
        
        
        
    }
    
    public static void refitting_strays(){}
    
    public static void item_to_sack(item item,model sack,int X,int Y){
        try{
            sack.insert(Y, X, item);
            for(int i=X;i<X+item.width;i++){
                cumulative c=cumulatives.get(i);
                c.space-=item.height;
                c.next=Y+item.height;
            }
        
        }
        catch(Exception e){
            
            System.out.println("Item "+item.value+" couldn't be inserted to: "+X+","+Y+". Error: "+e.getMessage());}
    }
    
    ///OUTSOURCE THIS TO VIEW!!!!!...OR DELETE IT, AS SEE FIT
    public static void display_cumulatives(ArrayList<cumulative> list){
        System.out.print("Cumulatives: ");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).space+":"+list.get(i).next+",");
        }
        System.out.print("\n");
    }
    
    
    
    
    public static class cumulative{
        int space=0;
        int next=0;
        
        public cumulative(int s){
            space=s;
        }
    }
    
    
    
}



