package algos;

import java.util.Random;

public class ReservoirSampling {
	
	public static int[] pick(int input[], int n, int k) 
    { 
        int i;   // index for elements in stream[] 
        
        // reservoir[] is the output array. Initialize it with 
        // first k elements from stream[] 
        int reservoir[] = new int[k]; 
        
        for (i = 0; i < k; i++) 
            reservoir[i] = input[i]; 
          
        Random r = new Random(); 
          
        // Iterate from the (k+1)th element to nth element 
        for (; i < n; i++) 
        { 
            // Pick a random index from 0 to i. 
            int j = r.nextInt(i + 1); 
              
            // If the randomly  picked index is smaller than k, 
            // then replace the element present at the index 
            // with new element from stream 
            if(j < k) 
                reservoir[j] = input[i];             
        } 
       
        return reservoir;
    } 
	
}
