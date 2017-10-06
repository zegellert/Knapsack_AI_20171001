/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gellert-Eva
 */
public class model {
    int[][] array;
    int width;
    int height;
    public model(){
        width=5;
        height=5;
        array=new int[width][height];
    }
    public model(int w,int h){
        width=w;
        height=h;
        array=new int[width][height];
    }
    
    public int getValue(int X,int Y){
        return array[X][Y];
    }
    
    public int getFreeSpace(){
        int space=0;
         for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                    if(array[i][j]==0){space++;}
            }
        }
         return space;
    }
    
    ///X AND Y BEGINS AT 0
    public void insert(int X,int Y,int data){
        array[X][Y]=data;
    }
}
