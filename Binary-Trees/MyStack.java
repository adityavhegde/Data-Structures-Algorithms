

/*
ROUGH STACK IMPLEMENTATION FOR TREE TRAVERSAL
This stack does not auto resize or has provision for exceptions.
*/

public class MyStack {
    private BinaryTree[] stack;
    private int top;
    
    {
    stack=new BinaryTree[100];
    top=-1;
    }
    
    public void push(BinaryTree node){
        stack[++top]=node;
        
    }
    
    public BinaryTree pop(){
      
       return stack[top--];
    
    }
    
    public BinaryTree peek(){
    return stack[top];
    }
    
    public boolean isEmpty(){
    
        if(top==-1) return true;
        else return false;
    
    }
    
}
