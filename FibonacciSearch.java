package algos;

public class FibonacciSearch {

	public static int fibonaccianSearch(int arr[],  
			int x, int n) 
	{ 
		
		int fib2 = 0; // (m-2)'th Fibonacci No. 
		int fib1 = 1; // (m-1)'th Fibonacci No. 
		int fib = fib2 + fib1; // m'th Fibonacci 

		
		while (fib < n) 
		{ 
			fib2 = fib1; 
			fib1 = fib; 
			fib = fib2 + fib1; 
		} 

		int offset = -1; 

		while (fib > 1) 
		{ 
			int i = Math.min(offset+fib2, n-1); 
			if (arr[i] < x) 
			{ 
				fib = fib1; 
				fib1 = fib2; 
				fib2 = fib - fib1; 
				offset = i; 
			} 

			else if (arr[i] > x) 
			{ 
				fib = fib2; 
				fib1 = fib1 - fib2; 
				fib2 = fib - fib1; 
			} 

			else return i; 
		} 


		if(fib1 == 1 && arr[offset+1] == x) 
			return offset + 1; 

		return -1; 
	} 

}
