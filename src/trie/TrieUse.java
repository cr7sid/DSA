package trie;

public class TrieUse {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("bat");
		t.add("cat");
		t.add("battle");
		t.add("cattle");
		t.remove("cat");
		System.out
				.println(t.search("bat") + " " + t.search("battle") + " " + t.search("cat") + " " + t.search("cattl"));
	}

}
