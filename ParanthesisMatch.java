package algos;

import java.util.Stack;

public class ParanthesisMatch {


	private static boolean isMatchingPair(char character1, char character2) 
	{ 
		if (character1 == '(' && character2 == ')') 
			return true; 
		else if (character1 == '{' && character2 == '}') 
			return true; 
		else if (character1 == '[' && character2 == ']') 
			return true; 
		else
			return false; 
	} 


	public static boolean areParenthesisBalanced(char exp[]) 
	{ 
		/* Declare an empty character stack */
		Stack<Character> st = new Stack<>(); 

		/* Traverse the given expression to  
	          check matching parenthesis */
		for(int i = 0; i < exp.length; i++) 
		{ 

			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') 
				st.push(exp[i]); 


			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') 
			{ 

				if (st.isEmpty()) {
					
					return false; 
					
				} else if ( !isMatchingPair(st.pop(), exp[i]) ) { 

					return false; 
				} 
			} 
		} 
		if (st.isEmpty()) 
			return true; /*balanced*/
		else
		{   /*not balanced*/
			return false; 
		}  
	}  
}
