/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gellert Zelenak
 */
public class view {
    
    public static void display_model(model m){
        for(int i=0;i<m.height;i++){
            System.out.print("\n");
            for(int j=0;j<m.width;j++){
                if(j==0){System.out.print(m.array[i][j]);}
                else{System.out.print("\t"+m.array[i][j]);}
            }
        }
        System.out.println("\n");
    }
    
}
