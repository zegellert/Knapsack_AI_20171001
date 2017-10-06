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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("JUPITER");
       model m=new model(5,7);
       System.out.println("New sack created, free space: "+m.getFreeSpace());
       view.display_model(m);
       item i=new item(4,2,1);
       item_to_sack(i,m,1,3);
       view.display_model(m);
       item j=new item(2,2,3);
       item_to_sack(j,m,0,4);
       view.display_model(m);
       item_to_sack(j,m,1,1);
       view.display_model(m);
       System.out.println("Remaining free space: "+m.getFreeSpace());
       System.out.println("END");
       
    }
    
    public static void item_to_sack(item item,model sack,int X,int Y){
        try{
            sack.insert(X, Y, item);
        
        }
        catch(Exception e){System.out.println("That item couldn't be inserted there. Error: "+e.getMessage());}
    }
    
}
