package strings;

public class RearrangeCharacters {

	private static String rearrangeLetters(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		StringBuilder res = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c))
				map.put(c, 0);
			map.put(c, map.get(c) + 1);
		}
		
		PriorityQueue<Letter> PQ = new PriorityQueue<>(new Comparator<Letter>()
				{

					@Override
					public int compare(Letter arg0, Letter arg1) {
						if (arg0.occ > arg1.occ)
							return -1;
						else if (arg0.occ < arg1.occ)
							return 1;
						else
							return 0;
					}
			
				});
		
		for (Character key : map.keySet()) {
			if (map.get(key) > s.length() / 2)
				return "INVALID OUTPUT";
			PQ.add(new Letter(map.get(key), key));
		}
		
		while(!PQ.isEmpty()) {
			Letter front = PQ.poll(), secondFromFront = null;
			if (!PQ.isEmpty())
				secondFromFront = PQ.poll();
			res.append(front.c);
			
			if (secondFromFront != null) {
				res.append(secondFromFront.c);
				secondFromFront.occ--;
				if (secondFromFront.occ > 0)
					PQ.add(secondFromFront);
			}
			front.occ--;
			if (front.occ > 0)
				PQ.add(front);
			
			}
		
		
		return res.toString();
	}

}

}
