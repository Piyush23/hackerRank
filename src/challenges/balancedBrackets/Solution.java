package challenges.balancedBrackets;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static boolean isBalanced(String expression) {

		boolean isBalanced = true;
		Stack<Character> bracketStack = new Stack<Character>();
		bracketStack.push('s');

		for (Character bracket : expression.toCharArray()) {
			if (bracket == '{' || bracket == '(' || bracket == '[') {
				bracketStack.push(bracket);
			} else {
				if (bracketStack.peek() == getMirror(bracket)) {
					bracketStack.pop();
				} else {
					isBalanced = false;
					break;
				}
			}
		}

		if (bracketStack.peek() != 's') {
			isBalanced = false;
		}

		return isBalanced;
	}

	public static char getMirror(char brack) {
		if(brack == ')')
			return '(';
		else if (brack == '}')
			return '{';
		else
			return '[';
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
	}
}
