
package challeges.anagram;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 
 * @author Piyush Nikam
 *
 *         Think twice code once.
 */

public class Solution {
	public static int numberNeeded(String first, String second) {

		Hashtable<Character, Integer> hashtable1 = Solution.initHashtable(first);
		Hashtable<Character, Integer> hashtable2 = Solution.initHashtable(second);

		return getDeleteCount(hashtable1, hashtable2);
	}

	public static int getDeleteCount(Hashtable<Character, Integer> hashtable1,
			Hashtable<Character, Integer> hashtable2) {

		Set<Character> charSet1 = hashtable1.keySet();
		Set<Character> charSet2 = hashtable2.keySet();

		int deleteCount = 0;

		for (char character : charSet1) {
			if (charSet2.contains(character)) {
				deleteCount += getDeleteCharCount(hashtable1.get(character).intValue(),
						hashtable2.get(character).intValue());
			} else {
				deleteCount += hashtable1.get(character).intValue();
			}

			// charSet1.remove(character);
		}

		for (char character : charSet2) {
			if (!charSet1.contains(character)) {
				deleteCount += hashtable2.get(character).intValue();
			}
		}

		return deleteCount;
	}

	public static int getDeleteCharCount(int firstCount, int secondCount) {
		return Math.abs(firstCount - secondCount);
	}

	public static Hashtable<Character, Integer> initHashtable(String str) {

		Hashtable<Character, Integer> hashtable = new Hashtable<>();

		for (char character : str.toCharArray()) {
			if (hashtable.contains(character)) {
				hashtable.put(character, hashtable.get(character).intValue() + 1);
			} else {
				hashtable.put(character, 1);
			}
		}
		return hashtable;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
