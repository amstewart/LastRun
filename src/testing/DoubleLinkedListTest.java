/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LastRun.src.testing;

import LastRun.src.utility.DoubleLinkedList;

/**
 *
 * @author Carlos
 */
public class DoubleLinkedListTest {
    
   
    public static void main(String[] args){
        
        DoubleLinkedList<String> list = new DoubleLinkedList();
        
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("Z");
        //list.add("D");
        
        list.print();
        
        System.out.println("Current Node: " + list.getData() );
        list.next();
        System.out.println("Current Node: " + list.getData() );
        list.next();
        System.out.println("Current Node: " + list.getData() );
        list.next();
        System.out.println("Current Node: " + list.getData() );
         list.next();
        System.out.println("Current Node: " + list.getData() );
        
        System.out.println("************************************");
        System.out.println("Current Node: " + list.getData() );
        list.previous();
        System.out.println("Current Node: " + list.getData() );
        list.previous();
        System.out.println("Current Node: " + list.getData() );
        list.previous();
        System.out.println("Current Node: " + list.getData() );
        list.previous();
        System.out.println("Current Node: " + list.getData() );
    }
}
