package com.steelthorn.android.av;

//Basic node stored in unbalanced binary search trees
//Note that this class is not accessible outside
//of this package.

class BinaryNode<T extends Comparable<T>>
{
	// Constructors
	BinaryNode(T theElement)
	{
		element = theElement;
		left = right = null;
	}

	// Friendly data; accessible by other package routines
	T element; // The data in the node
	BinaryNode<T> left; // Left child
	BinaryNode<T> right; // Right child
}
