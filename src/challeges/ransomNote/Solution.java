package challeges.ransomNote;

import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public Solution(String magazine, String note) {
    	
    	magazineMap = new HashMap<>();
    	noteMap = new HashMap<>();
        
    	String[] magazineSplited = magazine.split("\\s+");
    	for(String word : magazineSplited) {
    		if(this.magazineMap.containsKey(word)) {
    			this.magazineMap.put(word, this.magazineMap.get(word) + 1);
    		}else {
    			this.magazineMap.put(word, 1);
    		}
    	}
    	
    	String[] noteSplited = note.split("\\s+");
    	for(String word : noteSplited) {
    		if(this.noteMap.containsKey(word)) {
    			this.noteMap.put(word, this.noteMap.get(word) + 1);
    		}else {
    			this.noteMap.put(word, 1);
    		}
    	}
    }
    
    public boolean solve() {
        boolean answer = true;
        for(String word : noteMap.keySet()) {
        	if(magazineMap.containsKey(word)) {
        		if(magazineMap.get(word) < noteMap.get(word)) {
        			answer = false;
        		}
        	}else {
        		answer = false;
        	}
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
