/**
 *
 * @author Aditya
 */
// BTEx i.e. BinaryTree Example
class BinaryTree{
    private BinaryTree leftNode, rightNode;
    private int data;
    
    public BinaryTree(int data){
    this.data=data;
    this.leftNode=null;
    this.rightNode=null;
    }
    
    public int getData(){
      return this.data;        
    }

    public void setData(int data){
        this.data=data;
    }
    
    public void setLeftNode(BinaryTree leftNode){
        this.leftNode=leftNode;
    }
    
    public BinaryTree getLeftNode(){
        return this.leftNode;
    }
    
    public void setRightNode(BinaryTree rightNode){
        this.rightNode=rightNode;
    }
    
    public BinaryTree getRightNode(){
        return this.rightNode;
    }
    
}


public class BTEx {
    public static void main(String[] args) {
        BinaryTree b1=new BinaryTree(3);

        b1.setLeftNode(new BinaryTree(4));
        b1.setRightNode(new BinaryTree(5));
        b1.getRightNode().setLeftNode(new BinaryTree(1));
        b1.getRightNode().setRightNode(new BinaryTree(7));
    
        //printBinaryTreeIterative(b1);
        int max=findMaxRecurse(b1);
        System.out.println("Max is "+max);
        
        
    }
    
    
    public static int findMaxRecurse(BinaryTree b){
        /*
        function to find the max value in a binary tree using recursion
        consider a single node at the bottom with one left and one right child leaf nodes
        this will help in better understanding the recursive code 
        */
        
        int root_val=0;
        int left_child_val=0;
        int right_child_val=0;
        int max=0;
            
            if(b!=null){
            root_val=b.getData();
            left_child_val=findMaxRecurse(b.getLeftNode());
            right_child_val=findMaxRecurse(b.getRightNode());
            }
            
            if(left_child_val>right_child_val) max=left_child_val;
            else max=right_child_val;
            
            if(root_val>max) max=root_val;
            
            
          return max;
    }
    
    public static void printBinaryTree(BinaryTree rootNode){
        if(rootNode!=null){
            //pre oder traversal
           System.out.println(rootNode.getData());
           printBinaryTree(rootNode.getLeftNode());
           printBinaryTree(rootNode.getRightNode());
        
        }
    }
    
   
    public static void printBinaryTreeIterative(BinaryTree rootNode){
       //InOrder Traversal
      MyStack stack=new MyStack();
       
      while(true){
          
        while(rootNode!=null){
            System.out.print(rootNode.getData()+" ");
            
            stack.push(rootNode);
            rootNode=rootNode.getLeftNode();            
        }
          
        if(stack.isEmpty()) break;
        
        rootNode=stack.pop();
        rootNode=rootNode.getRightNode();       
      }
     
    }
    
}
