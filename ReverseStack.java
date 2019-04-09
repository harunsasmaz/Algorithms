package algos;

import java.util.Stack;

public class ReverseStack {
	
	public static void insert_at_bottom(Stack<Integer> stack, int x) 
    { 
  
        if(stack.isEmpty()) 
            stack.push(x); 
  
        else
        { 
            // All items are held in Function 
            // Call Stack until we reach end 
            // of the stack. When the stack becomes 
            // empty, the st.size() becomes 0, the 
            // above if part is executed and  
            // the item is inserted at the bottom 
        	int a = stack.peek(); 
            stack.pop(); 
            insert_at_bottom(stack,x); 
  
            // push allthe items held  
            // in Function Call Stack 
            // once the item is inserted  
            // at the bottom 
            stack.push(a); 
        } 
    } 
      
    // Below is the function that  
    // reverses the given stack using 
    // insert_at_bottom() 
    static void reverse(Stack<Integer> stack) 
    { 
        if(stack.size() > 0) 
        { 
              
            // Hold all items in Function 
            // Call Stack until we 
            // reach end of the stack  
            int x = stack.peek(); 
            stack.pop(); 
            reverse(stack); 
              
            // Insert all the items held  
            // in Function Call Stack 
            // one by one from the bottom 
            // to top. Every item is 
            // inserted at the bottom  
            insert_at_bottom(stack,x); 
        } 
    } 
	
}
