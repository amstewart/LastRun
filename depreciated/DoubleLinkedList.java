/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.utility;

/**
 *
 * @author Carlos
 */
/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */
public class DoubleLinkedList<T> {
    Node head;
    Node current;
    int quantity;
    
    public DoubleLinkedList(){
        
        head = null;
        current = head;
        quantity = 0;
    }
    
    private class Node{
        
        T data;
        Node prev;
        Node next;
    }
    
    
    public void add(T data){
        
        if ( head == null){
            
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            current = head;
        }
        else{
            
            Node currentNode = head;
            while ( currentNode.next != head){
                
                currentNode = currentNode.next;
            }
            
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            newNode.prev = currentNode;
            
            currentNode.next = newNode; 
            head.prev = newNode;
        }
        quantity += 1;
    }
    
    public void print(){
        
        int i = 0;
        Node currentNode = head;
        while ( i++ < quantity ){
            
            System.out.println("Node " + i + ": " + currentNode.data);
            currentNode = currentNode.next;
        }
    }
    
    public void next(){
        
        current = current.next;
    }
    
    public void previous(){
        
        current = current.prev;
    }
    
    public T getData(){
        
        return current.data;
    }
    
    public void removeAll(){
        
        head = null;
        current = null;
    }
}
