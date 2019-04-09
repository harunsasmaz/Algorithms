package algos;

import java.util.Queue;

public class ReverseQueue {
	
	public static Queue<Integer> reverseQueue(Queue<Integer> q) 
	{ 
	    // Base case 
	    if (q.isEmpty()) 
	        return q; 
	  
	    // Dequeue current item (from front)   
	    int data = q.peek(); 
	    q.remove(); 
	  
	    // Reverse remaining queue   
	    q = reverseQueue(q); 
	  
	    // Enqueue current item (to rear)   
	    q.add(data); 
	          
	    return q; 
	} 
	
}
