package algos;

public class RabinKarp {

	static void search(String pat, String txt, int q) 
	{ 
		int M = pat.length(); 
		int N = txt.length();
		int alphabet = 256;
		int i, j; 
		int hashPat = 0; // hash value for pattern 
		int hashTxt = 0; // hash value for txt 
		int h = 1; 

		// The value of h would be "pow(d, M-1)%q" 
		for (i = 0; i < M-1; i++) 
			h = (h*alphabet)%q; 

		// Calculate the hash value of pattern and first 
		// window of text 
		for (i = 0; i < M; i++) 
		{ 
			hashPat = (alphabet*hashPat + pat.charAt(i)) % q; 
			hashTxt = (alphabet*hashTxt + txt.charAt(i)) % q; 
		} 

		// Slide the pattern over text one by one 
		for (i = 0; i <= N - M; i++) 
		{ 

			// Check the hash values of current window of text 
			// and pattern. If the hash values match then only 
			// check for characters on by one 
			if ( hashPat == hashTxt ) 
			{ 
				/* Check for characters one by one */
				for (j = 0; j < M; j++) 
				{ 
					if (txt.charAt(i + j) != pat.charAt(j)) 
						break; 
				} 

				// if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1] 
				if (j == M) 
					System.out.println("Pattern found at index " + i); 
			} 

			// Calculate hash value for next window of text: Remove 
			// leading digit, add trailing digit 
			if ( i < N-M ) 
			{ 
				hashTxt = (alphabet * (hashTxt - txt.charAt(i) * h) + txt.charAt(i + M)) % q; 

				// We might get negative value of t, converting it 
				// to positive 
				if (hashTxt < 0) 
					hashTxt = (hashTxt + q); 
			} 
		} 
	} 

}
