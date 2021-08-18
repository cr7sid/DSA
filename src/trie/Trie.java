package trie;

class TrieNode {

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		children = new TrieNode[26];
		childCount = 0;
	}

}

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode('\0');
	}

	private void remove(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminating = false;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			return;
		}
		remove(child, word.substring(1));

		// Firstly, we simply marked the last word of the string in trie as
		// non-terminating, which would
		// work just fine, but it is not efficient. To save space, we check if the child
		// to be removed
		// is not terminating and doesn't have any children, in this case we delete that
		// child node

		// Here we iterate 26 times to check if there is any child of the node to be
		// deleted,
		// so to improve this, we used another field in the trie node, i.e., childCount.

//		if (!child.isTerminating) {
//			int childNum = 0;
//			for (int i = 0; i < 26; i++) {
//				if (child.children[i] != null) {
//					childNum++;
//				}
//			}
//			if (childNum == 0) {
//				root.children[childIndex] = null;
//				child = null;
//			}
//		}

		if (!child.isTerminating && child.childCount == 0) {
			root.children[childIndex] = null;
			child = null;
			root.childCount--;
		}
	}

	public void remove(String word) {
		remove(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if (word.length() == 0) {
			return root.isTerminating;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			return false;
		}
		return search(child, word.substring(1));
	}

	public boolean search(String word) {
		return search(root, word);
	}

	public void add(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word) {
		add(root, word);
	}

}
