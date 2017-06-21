package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProbelmII {
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("mobile");
		dict.add("samsung");
		dict.add("sam");
		dict.add("sung");
		dict.add("man");
		dict.add("i");
		dict.add("like");
		WordBreakProbelmII ebp =new WordBreakProbelmII();
		System.out.println(ebp.wordBreak("likeisamman", dict));
	}
	
	
	public boolean wordBreak(String s, Set<String> wordDict) {
	    int[] pos = new int[s.length()+1];
	 
	    Arrays.fill(pos, -1);
	 
	    pos[0]=0;
	 
	    for(int i=0; i<s.length(); i++){
	        if(pos[i]!=-1){
	            for(int j=i+1; j<=s.length(); j++){
	                String sub = s.substring(i, j);
	                if(wordDict.contains(sub)){
	                    pos[j]=i;
	                }
	            } 
	        }
	    }
	 
	    for(int i=1;i<pos.length;i++)
	    {
	    	 if(pos[i]!=-1){
	    		 System.out.println(s.substring(pos[i],i));
	    	 }
	    }
	    return pos[s.length()]!=-1;
	}
}

