public class LinkedListCopy{
	public Node root;
	class Node{
		public int data;
		public Node next;
		public Node(int d){
			data = d;
			next = null;
		}
		public Node(int d, Node nxt){
			data = d;
			next = nxt;
		}
	}
	/* utility function to check the output */
	public void traverse(Node r){
		if(r == null)
			return;
		else{
			System.out.print(" " + r.data + " ->");
			traverse(r.next);
		}
	}
	/* helper function to create the linkedlist */
	public void insert(Node r, int key){
		if(this.root == null){
			Node n = new Node(key);
			this.root = n;
			return;
		}
		else if(r.next == null){
			r.next = new Node(key);
		}
		else{
			insert(r.next, key);
		}
	}
	public Node copyList(Node root1, Node root2){
		Node r1 = root1; Node r2 = root2;
		r2 = new Node(r1.data);
		root2 = r2;
		while(r1.next != null){
			r2.next = new Node(r1.next.data);
			r1 = r1.next;
			r2 = r2.next;
		}
		return root2;
	}
	/* IDEA : copy the current node and assign the next pointer 
	to the copy of the next pointer of origianl list */
	public Node recursiveCopy(Node root1){
		if(root1 == null){
			return null;
		}
		else{
			return new Node(root1.data, recursiveCopy(root1.next));
		}
	}
	public static void main(String [] args){
		int [] a = {17, 23, 6, 14, 32};
		LinkedListCopy llc = new LinkedListCopy();
		for(int i = 0; i < a.length; i++){
			llc.insert(llc.root, a[i]);
		}
		System.out.println("\n LinkedList generated...");
		llc.traverse(llc.root);
		Node root2 = null;
		System.out.println("\n Copy Iterative Manner...");
		root2 = llc.copyList(llc.root, root2);
		llc.traverse(root2);
		System.out.println("\n Copy Recursive Manner...");
		root2 = llc.recursiveCopy(llc.root);
		llc.traverse(root2);
	}
}