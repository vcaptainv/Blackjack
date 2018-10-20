/**
 * File: Shuffle.java
 * Author: Yusheng Hu
 * Date: 09/13/2016
 */
 
 import java.util.ArrayList;
 import java.util.Random;

public class Shuffle{ 
    public static void main (String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
    
        for (int i = 0;i<10;i++){
            int num = i + 1;
            
            list.add(num);
            System.out.println(list.get(i));    
        }
        /*for (int j = 0;j<10; j++){
            int num = random.nextInt(10-j);
            int r = list.remove(num);
            System.out.print(r);
            System.out.println(list);
        }
        */
        ArrayList<Integer> shufflelist = new ArrayList<Integer>();
        for (int i = 0; i<10; i++){
            
            int R = random.nextInt(10-i);
            shufflelist.add(list.get(R));
            list.remove(R);
            
        }
        System.out.println(shufflelist);
    }
}
    