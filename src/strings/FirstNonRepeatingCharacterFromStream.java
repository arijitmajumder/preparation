package strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingCharacterFromStream 
{
	public static Character getFirstNonRepeatingChar(String data)
	{
		Map<Character, Integer> map = new LinkedHashMap<>();
		int[] isCharPresent = new int[256];
		for(Character ch : data.toCharArray())
		{
			if(isCharPresent[ch] == 0)
			{
				map.put(ch, 1);
				isCharPresent[ch] = 1;
			}
			else
			{
				map.remove(ch);
			}
		}
		Set<Character> keySet = map.keySet();
		if(keySet.size()>0)
			return (Character) keySet.toArray()[0];
		throw new IllegalArgumentException("There is no non repeating elements found");
	}
	
	
	public static void main(String[] args) {
		String stream1 = "geeksforgeeksquiz";
		System.out.println(getFirstNonRepeatingChar(stream1));
	}
}
