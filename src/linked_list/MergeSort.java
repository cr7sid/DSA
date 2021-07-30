package linked_list;

public class MergeSort {

	public static Node<Integer> mergeSort(Node<Integer> head) {
		if (head == null || head.next == null)
			return head;
		Node<Integer> slow = head;
		Node<Integer> fast = head.next;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node<Integer> rightHead = slow.next;
		slow.next = null;
		Node<Integer> leftAns = mergeSort(head);
		Node<Integer> rightAns = mergeSort(rightHead);
		Node<Integer> ans = merge(leftAns, rightAns);
		return ans;
	}

	public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
		if(head1 == null && head2 == null) {
            return null;
        } else if(head1 == null) {
            return head2;
        } else if(head2 == null) {
            return head1;
        }
		Node<Integer> head3 = null, tail3 = null;
		while(head1 != null && head2 != null) {
			if(head3 == null) {
				if(head1.data <= head2.data) {
					head3 = head1;
					tail3 = head1;
					head1 = head1.next;
				} else {
					head3 = head2;
					tail3 = head2;
					head2 = head2.next;
				}
			} else {
				if(head1.data <= head2.data) {
					tail3.next = head1;
					head1 = head1.next;
					tail3 = tail3.next;
				} else {
					tail3.next = head2;
					head2 = head2.next;
					tail3 = tail3.next;
				}
			}
		}
		while(head1 != null) {
			tail3.next = head1;
			head1 = head1.next;
			tail3 = tail3.next;
		}
		while(head2 != null) {
			tail3.next = head2;
			head2 = head2.next;
			tail3 = tail3.next;
		}
		return head3;
	}

	public static void main(String[] args) {
		Node<Integer> head = LinkedListUse.takeInput();
		Node<Integer> ans = mergeSort(head);
		LinkedListUse.print(ans);
	}

}
