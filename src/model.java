
import java.util.HashMap;

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
    
    HashMap<Point,item> items=new HashMap<Point, item>();
    
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
    public void insert(int X,int Y,int item) throws Exception{
        
        for(int i=X;i<X+item.height;i++){
            for(int j=Y;j<Y+item.width;j++){
                if(this.getValue(i,j)!=0){throw new Exception("Items overlapping.");}
            }
        }
        
        for(int i=X;i<X+item.height;i++){
            for(int j=Y;j<Y+item.width;j++){
                
               array[X][Y]=item.value;
            }
        }
        
        Point p=new Point(X,Y);
        items.put(p,item);
        
        
    }
    
    public class Point{
        public int X;
        public int Y;
        public Point(int x,int y){X=x;Y=y;}
    }
}
