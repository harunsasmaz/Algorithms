package algos;

import java.util.Stack;

public class TowerOfHanoi {

	void moveDisksBetweenTwoPoles(Stack<Integer> src, Stack<Integer> dest,  char s, char d)  
	{ 
		int pole1TopDisk = src.isEmpty() ? Integer.MIN_VALUE : src.pop(); 
		int pole2TopDisk = dest.isEmpty() ? Integer.MIN_VALUE : dest.pop(); 

		// When pole 1 is empty 
		if (pole1TopDisk == Integer.MIN_VALUE)  
		{ 
			src.push(pole2TopDisk);
			moveDisk(d, s, pole2TopDisk); 
		} 
		// When pole2 pole is empty 
		else if (pole2TopDisk == Integer.MIN_VALUE)  
		{ 
			dest.push(pole1TopDisk);
			moveDisk(s, d, pole1TopDisk); 
		} 
		// When top disk of pole1 > top disk of pole2 
		else if (pole1TopDisk > pole2TopDisk)  
		{ 
			src.push(pole1TopDisk);
			src.push(pole2TopDisk);
			moveDisk(d, s, pole2TopDisk); 
		} 
		// When top disk of pole1 < top disk of pole2 
		else 
		{ 
			dest.push(pole2TopDisk);
			dest.push(pole1TopDisk);
			moveDisk(s, d, pole1TopDisk); 
		} 
	} 

	// Function to show the movement of disks 
	void moveDisk(char fromPeg, char toPeg, int disk) 
	{ 
		System.out.println("Move the disk "+disk +  
				" from "+fromPeg+" to "+toPeg); 
	} 

	// Function to implement TOH puzzle 
	void tohIterative(int num_of_disks, Stack<Integer> src, Stack<Integer> aux, Stack<Integer> dest) 
	{ 
		int i, total_num_of_moves; 
		char s = 'S', d = 'D', a = 'A'; 

		// If number of disks is even, then interchange 
		// destination pole and auxiliary pole 
		if (num_of_disks % 2 == 0) 
		{ 
			char temp = d; 
			d = a; 
			a  = temp; 
		}
		
		total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1); 

		// Larger disks will be pushed first 
		for (i = num_of_disks; i >= 1; i--) 
			src.push(i);

		for (i = 1; i <= total_num_of_moves; i++) 
		{ 
			if (i % 3 == 1) 
				moveDisksBetweenTwoPoles(src, dest, s, d); 

			else if (i % 3 == 2) 
				moveDisksBetweenTwoPoles(src, aux, s, a); 

			else if (i % 3 == 0) 
				moveDisksBetweenTwoPoles(aux, dest, a, d); 
		} 
	} 


}
