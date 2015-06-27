public class BinaryTree{
	public Node root;
	class Node{
		public int data;
		public Node lchild;
		public Node rchild;
		public Node(int d){
			data = d;
			lchild = rchild = null;
		}
	}
	/* helper function to find the node with the give key */
	public Node search(Node root,int key){
		if(root == null)
			return null;
		else if(root.data == key)
				return root;
			Node left = search(root.lchild, key);
			return left != null? left : search(root.rchild, key);
	}
	/* utility function to verify if the insertion happended correctly */
	public void traverse(Node root){
		if(root == null)
			return;
		System.out.print(" " + root.data);
		traverse(root.lchild);
		traverse(root.rchild);
	}
	/* function that carries insertion
	Theory : If tree is left filled then 
	childs of root will be :2i and 2i+1.
	IDEA : if root is null, treat new node as root. Else find the node 
	with the given key and do the insertion. */
	public void insert(Node root, int [] array, int indexValue){
		
		if(this.root == null){
			Node n = new Node(array[indexValue]);
			this.root = n;
			this.root.lchild = new Node(array[2 * indexValue]);
			this.root.rchild = new Node(array[2 * indexValue + 1]);
		}
		else{
			Node tempRoot = search(root, array[indexValue]);
			if(tempRoot != null){
				if(2 * indexValue < array.length)
				tempRoot.lchild = new Node(array[2 * indexValue]);
				if(2 * indexValue  + 1 < array.length)
				tempRoot.rchild = new Node(array[2 * indexValue + 1]);
			}
		}
	}
	public static void main(String [] args){
		BinaryTree bt = new BinaryTree();
		int [] a = {0, 1, 2, 4, 6, 7, 8};
		for(int i = 1; i <= a.length/2; i++){
			bt.insert(bt.root, a, i);
		}
		bt.traverse(bt.root);
	}
}