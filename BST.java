import java.util.*;

public class BST<T>
{
	private BSTNode root = null;

	//calls find and returns a boolean value which determines if the value is within the tree
	public boolean find(Comparable value)
	{
		return find (root, value);
	}//public find

	//method overload of find
	private boolean find(BSTNode node, Comparable value)
	{
		if (node == null)
		{
			return false;
		}//if

		if (node.data.compareTo(value) == 0)
		{
			return true;
		}//if

		else if (node.data.compareTo(value) > 0)
		{
			return find(node.right, value);
		}//else if

		else
		{
			return find(node.left, value);
		}//else
	}//private find

	//calls insert which adds a new node to the tree
	public void insert(Comparable value)
	{
		root = insert(root, value);
	}//public insert

	//method overload of insert
	private BSTNode insert(BSTNode node, Comparable value)
	{
		if (node == null)
		{
			BSTNode n = new BSTNode(value);
			return n;
		}//if

		else if (node.data.compareTo(value) > 0)
		{
			node.right = insert(node.right, value);
		}//else if

		else
		{
			node.left = insert(node.left, value);
		}//else

		return node;
	}//private insert

	//calls print which prints the tree
	public void print()
	{
		print(root);
	}//public print

	//method overload of print
	private void print(BSTNode node)
	{
		if(node != null)
		{
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}//if
	}//private print

	//calls delete which will "delete" a node
	public BSTNode delete(Comparable value)
	{
		return delete(root, value);
	}//public delete

	//method overload of delete
	private BSTNode delete(BSTNode node, Comparable value)
	{
		if (node == null)
		{
			return null;
		}//if

		if (node.data.compareTo(value) == 0)
		{
			if (node.left == null)
			{
				return node.right;
			}//if

			else if (node.right == null)
			{
				return node.left;
			}//else if

			else
			{
				if (node.right.left == null)
				{
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				}//if

				else
				{
					node = (BSTNode) removeSmallest(node.right);
					return node;
				}//else
			}//else
		}//if

		else if (node.data.compareTo(value) < 0)
		{
			node.right = delete(node.right, value);
		}//else if

		else
		{
			node.left = delete(node.left, value);
		}//else

		return null;
	}//private delete

	//gets the next smallest number
	private Comparable removeSmallest(BSTNode node)
	{
		if (node.left.left == null)
		{
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}//if

		else
		{
			return removeSmallest(node.left);
		}//else
	}//removeSmallest

	//BSTNode class
	public class BSTNode
	{
		//data
		Comparable data;
		BSTNode right;
		BSTNode left;

		//constructor
		public BSTNode(Comparable value)
		{
			data = value;
			right = null;
			left = null;
		}//constructor

		//gets right node
		public BSTNode getRight()
		{
			return right;
		}//getRight

		//gets left node
		public BSTNode getLeft()
		{
			return left;
		}//getLeft

		//set a left node
		public void setLeft(BSTNode left)
		{
			this.left = left;
		}//setLeft

		//sets a right node
		public void setRight(BSTNode right)
		{
			this.right = right;
		}//setRight

		//sets data
		public void setData(Comparable value)
		{
			this.data = value;
		}//setData
	}//BSTNode class
	
}//BST class