
package LSQ;

/**
 *
 * @author Aditya
 */
//below is the ADT implementation of a circular queue
//we use the getQueueSize method to check if the queue is empty or full
class MyQueue{
    private int a[];
    private int front;
    private int rear;
    private int capacity;

    public MyQueue(int capacity) {
        this.capacity=capacity;
        front=-1;
        rear=-1;
        a=new int[capacity];      
    }
    
    public void enQueue(int data){
        if(isFull())
            System.out.println("Queue is already full");
        else{
           rear=(rear+1)%capacity;
           a[rear]=data;
           //what if this is the first element
           if(front==-1) front++; //this is for the first element insertion
        } 
            
    }
    
    public int deQueue(){
        /*
        If you have only one element left in the Queue and you hit a deQueue operation,
        the entire queue is reset. 
        How do you know if there is only one element? A: When f and r both are equal
        */
        if(isEmpty())
            System.out.println("The queue is already empty");
        else {
            if(front==rear){
            int data=a[front];
            front=-1;rear=-1; //resetting the whole queue
            return data; //return the value that was deQueued
            }
            else{
            int data=a[front];
            front=(front+1)%capacity;
            return data;
            }
        }
        return -1;
    }
    
    public int getQueueSize(){      
       if(front==-1){
       return 0; //case when there are no elements in the queue
       }
       else{
        if(front>rear)
        return (capacity-front+rear+1); 
        else return(rear-front+1);
       }
    }
    
    public boolean isFull(){
        return (getQueueSize()==capacity);
    }
    
    public boolean isEmpty(){
        return getQueueSize()==0;   
    }
    
    public void printQueue(){
        
        if(isEmpty()) System.out.println("Cannot print an empty queue");
        else{
        if(front>rear){
        for(int i=front;i<capacity;i++)
            System.out.println(i+" "+a[i]);
        
        for(int j=0;j<=rear;j++)
            System.out.println(j+" "+a[j]);
        }
        else for(int i=front;i<=rear;i++)
                System.out.print(a[i]+" ");
        }
    }
    
}


public class QueueImpl {
    public static void main(String[] args) {
        /*
        We run some basic tests
        */
        MyQueue q=new MyQueue(4);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.printQueue();
        
        q.deQueue();q.deQueue();q.deQueue();
        q.printQueue();

    }
    
}
