package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Trie 
{
	private Map<Character, TrieNode> map = null;
	public Trie() {
		map = new HashMap<>();
	}
	
	private void insertWord(String word) 
	{
		Map<Character, TrieNode> temp = this.map;
		TrieNode helperNode = null;
		int length = word.length();
		for(int i=0; i<length;i++)
		{
			char ch = word.charAt(i);
			helperNode = temp.get(ch);
			if(helperNode == null)
			{
				temp.put(ch, new TrieNode(ch, false));
			}
			if(i==length-1)
				temp.get(ch).setEndOfWord(true);
			temp = temp.get(ch).getMap();
		}
	}
	
	private boolean isWordPresent(String word)
	{
		Map<Character, TrieNode> temp = this.map;
		TrieNode helperNode = null;
		int length = word.length();
		for(int i=0; i<length;i++)
		{
			char ch = word.charAt(i);
			helperNode = temp.get(ch);
			if(helperNode == null)
			{
				return false;
			}
			if(i==length-1)
				return temp.get(ch).isEndOfWord();
			temp = helperNode.getMap();
		}
		return false;
	}
	
	private boolean deleteWord(String word)
	{
		int length = word.length();
		Map<Character, TrieNode> tempMap = this.map;
		TrieNode node = null;
		boolean isWordPresent = false;
		Stack<TrieNode> stack = new Stack<>();
		for(int i = 0; i<length; i++)
		{
			char ch = word.charAt(i);
			node =tempMap.get(ch);
			if(node == null)
				return false;
			stack.push(node);//Stack to hold root to leaf nodes for that word.
			if(i == length-1 && node.isEndOfWord())//If last character node has isEndOfWord true, then break;
			{
				isWordPresent = true;
				break;			
			}
			tempMap = node.getMap();
		}
		if(isWordPresent)
		{
			while(!stack.isEmpty())
			{
				node = stack.pop();
				tempMap = node.getMap();
				if(tempMap.isEmpty())	//If the map is empty, then it means it does not have any child. So we have to remove from it's upper character map.
				{
					if(!stack.isEmpty()) //This check is required as for Below Example, cow, we need to delete c and else block will execute.
					{
						stack.peek().getMap().remove(node.getCh());
					}
					else
					{
						this.map.remove(node.getCh());
					}
				}
				else //While deleting "her", as it has descendant("hers"), so we just need to mark this current endOfWord to false. 
				{
					node.setEndOfWord(false);
				}
			}
		}
		return isWordPresent;
	} 
	/**
	 * 				h--------c  
	 * 			   / \        \
	 * 			  i   e        o
	 * 			 /     \        \
	 * 			s(T)	r(T)     w(T)
	 *                   \
	 *                    s(T)
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Trie trie = new Trie();
		trie.insertWord("his");																	
		trie.insertWord("her");
		trie.insertWord("hers");
		trie.insertWord("cow");
		System.out.println("ok "+trie.isWordPresent("ok"));
		System.out.println("hi "+trie.isWordPresent("hi"));
		
		//Deleting a word that does not have any further children.
		System.out.println("his DELETE "+trie.deleteWord("his"));
		System.out.println("his "+trie.isWordPresent("his"));
		
		//Deleting a word that only present in tree.i.e. does not have any siblings or children. so from parent map it should delete C.
		System.out.println("cow before delete "+trie.isWordPresent("cow"));
		System.out.println("cow DELETE "+trie.deleteWord("cow"));
		System.out.println("cow after delete "+trie.isWordPresent("cow"));
		
		//Deleting a word that has further child. so only end of character should be false.
		System.out.println("her before delete "+trie.isWordPresent("her"));
		System.out.println("her DELETE "+trie.deleteWord("her"));
		System.out.println("her after delete "+trie.isWordPresent("her"));
		System.out.println("hers after delete "+trie.isWordPresent("hers"));
	}
}
class TrieNode
{
	private Character ch;
	private boolean isEndOfWord;
	private Map<Character, TrieNode> map = null;
	public TrieNode(Character ch, boolean isEndOfWord) {
		this.ch = ch;
		this.setEndOfWord(isEndOfWord);
		this.map = new HashMap<>();
	}
	public Map<Character, TrieNode> getMap() {
		return map;
	}
	public boolean isEndOfWord() {
		return isEndOfWord;
	}
	public void setEndOfWord(boolean isEndOfWord) {
		this.isEndOfWord = isEndOfWord;
	}
	public Character getCh() {
		return ch;
	}
}