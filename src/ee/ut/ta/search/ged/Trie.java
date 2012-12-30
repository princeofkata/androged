package ee.ut.ta.search.ged;

import java.util.Map;
import java.util.TreeMap;

public class Trie {
	static class TrieNode {
	    Map<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
	    boolean leaf;
	  }

	  TrieNode root = new TrieNode();

	  public void insertString(String s) {
	    TrieNode v = root;
	    for (char ch : s.toCharArray()) {
	      if (!v.children.containsKey(ch)) {
	        v.children.put(ch, new TrieNode());
	      }
	      v = v.children.get(ch);
	    }
	    v.leaf = true;
	  }

	  public void printSorted(TrieNode node, String s) {
		    for (Character ch : node.children.keySet()) {
		      printSorted(node.children.get(ch), s + ch);
		    }
		    if (node.leaf)
		      System.out.println(s);
		  }

}
