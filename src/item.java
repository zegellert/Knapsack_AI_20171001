/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gellert-Eva
 */

///WIDTH AND HEIGHT STARTS AT 1
public class item {
    int value=0;
    int width=0;
    int height=0;
    
    ///THIS IS A READONLY METHOD
    ///0 MEANS HORIZONTAL
    ///1 MEANS VERTICAL
    public int orientation(){
        if(width>height){return 0;}
        if(height<width){return 1;}
        return 0;
    }
    
    public item(){
        value=1;
        width=1;
        height=1;
    }
    
    public item(int w,int h, int data){
        width=w;
        height=h;
        value=data;
    }
    
    public void rotate(){
        int temp=width;
        width=height;
        height=temp;
    }
}
