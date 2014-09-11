/*
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Ing. DOuglas Barrios
* Miembros:
* - Max de Leon 13012
* - Javier Bucaro 13033
* - Kuk Ho Chung 13279
*/

public class BinaryTree<E>{

    protected E val; // value associated with node
	protected BinaryTree<E> parent; // parent of node
	protected BinaryTree<E> left, right; // children of node
	
	public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right, BinaryTree<E> parent)
	// post: returns a tree referencing value and two subtrees
	{
		val = value;
		this.right = right;
		this.left = left;
		this.parent = parent;
	}
	
	public BinaryTree<E> left()
	// post: returns reference to (possibly empty) left subtree
	// post: returns reference to (possibly empty) left subtree
	{
		return left;
	}
	public BinaryTree<E> right(){
		return right;
	}
	public BinaryTree<E> parent(){
		return parent;
	}
	// post: returns reference to parent node, or null
	
	public void setLeft(BinaryTree<E> newLeft)
	// post: sets left subtree to newLeft
	// re-parents newLeft if not null
	{
		left = newLeft;
	}
	public void setRight(BinaryTree<E> newRight){
		right = newRight;
	}
	protected void setParent(BinaryTree<E> newParent)
	// post: re-parents this node to parent reference, or null
	{
		if (!isEmpty()) {
		parent = newParent;
		}
	}
	public E value()
	// post: returns value associated with this node
	{
		return val;
	}
	
	public void setValue(E value)
	// post: sets the value associated with this node
	{
		val = value;
	}
	public boolean isEmpty(){
		if(val == null){
			return false;
		}else{
			return true;
		}
	}
}