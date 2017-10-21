
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

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
    
    static int width=0;
    static int height=0;

   
    public static void main(String[] args) {
       
     
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       try{
       
       String size=reader.readLine();
       height=Integer.parseInt(size.split("\t")[0]);
       width=Integer.parseInt(size.split("\t")[1]);
       m=new model(height,width);
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
       
       area_comparator ac=new area_comparator();
       Collections.sort(items,Collections.reverseOrder(ac));
       
       for(int i=0;i<items.size();i++){
           try_to_fit(items.get(i),m,0,0);
       }
       
      /*if(strays.size()>0){
           cumulatives.clear();
           m=new model(height,width);
            for(int i=0;i<m.height;i++){
           cumulative c=new cumulative(m.height);
           cumulatives.add(c);
            }
           Collections.sort(strays,Collections.reverseOrder(ac));
           for(int i=0;i<strays.size();i++){
               item stray=strays.get(i);
               stray.rotate();
              strays.remove(stray);
            try_to_fit(stray,m,0,0);
       }
           for(int i=0;i<items.size();i++){
           try_to_fit(items.get(i),m,0,0);
       }
       }*/
      
      for(int i=0;i<strays.size();i++){
               item stray=strays.get(i);
               strays.remove(stray);
               stray.modified=0;
               try_to_fit(stray,m,0,0);
      }
      
      while(strays.size()>0){
        
      for(int c=0;c<3;c++){
          for(int i=0;i<strays.size();i++){
               item stray=strays.get(i);
               stray.modified=0;
               items.remove(stray);
          }
          Collections.sort(strays,Collections.reverseOrder(ac));
          redo();
      }}
     
       
       view.display_model(m);
       
       //display_cumulatives(cumulatives);
       
       //System.out.println("Strays: "+strays.size());
       
      

       
    }
    
    public static void try_to_fit(item item,model sack,int X,int Y){
        

            
            
        int column=X;
        int row=0;
        
        ///COLUMN CHOOSING LOOP:
        ///THIS OUGHT TO BE DONE IN A WHILE LOOP:
        for(int i=0;i<cumulatives.size();i++){
            cumulative c=cumulatives.get(i);
            
            if(item.height<=c.space){
                column=i;

                for(int j=0;j<m.height;j++){
                    int check=m.getValue(j, column);
                    if(check==0){
                        row=j;
                        break;
                    }
                }
  
                break;
            }
            
        }
       
        
        
        item_to_sack(item,m,column,row);
        
        
        
   
        
        
        
        
      
        
        
        
    }
   
    
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
            
           //System.out.println("Item "+item.value+" ("+item.width+","+item.height+") couldn't be inserted to: "+X+","+Y+". Error: "+e.getMessage());
            if(item.modified<4){
                item.modified++;
                item.rotate();
                try_to_fit(item,sack,0,0);
            }
            else{strays.add(item);}
            
            
        }
    }
    
    public static void redo(){
        cumulatives.clear();
        m=new model(height,width);
       for(int i=0;i<m.height;i++){
           cumulative c=new cumulative(m.height);
           cumulatives.add(c);
       }
       items.addAll(0,strays);
       strays.clear();
       for(int i=0;i<items.size();i++){
           try_to_fit(items.get(i),m,0,0);
       }
       
       
       
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



