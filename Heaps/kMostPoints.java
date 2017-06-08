/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Aditya
 */
public class kMostPoints {
    public static void main(String[] args) {
        PriorityQueue<Point> heap = new PriorityQueue<>();
        ArrayList<Point> input = new ArrayList<>();
        
        input.add(new Point(1,2));
        input.add(new Point(0,4));
        input.add(new Point(10,4));
        

        
        for(Point p: input)
            heap.add(p);
        
        for(Point p: heap)
            System.out.println("Heap "+p.x+" "+p.y);
        
    }
}
class Point implements Comparable<Point>{
    
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
       
    public int compareTo(Point p){
        if(this.x <= p.x)
            return -1;
        else return 1;
    }
}
