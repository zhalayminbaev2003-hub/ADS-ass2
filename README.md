# My Data Structures Project

This is my assignment where I created my own versions of lists, stacks, and queues from scratch without using Java's built-in tools.

## What's inside?
- **MyArrayList**: A list based on an array that grows.
- **MyLinkedList**: A list made of "nodes" connected to each other.
- **MyStack**: A "Last-In-First-Out" structure.
- **MyQueue**: A "First-In-First-Out" structure.
- **MyMinHeap**: A structure that always keeps the smallest number on top.

## Why I chose these structures:

1. **Stack -> MyArrayList**:
   I used an array for the Stack because we only add and remove items from the very end. In an array, this is super fast.

2. **Queue -> MyLinkedList**:
   I used a linked list for the Queue because we need to take items from the front. A linked list is much faster at removing the first item than an array is.

3. **Heap -> MyArrayList**:
   I used an array for the Heap because it's easy to find "parents" and "children" using simple math formulas with array indexes.

## How to use
Just run the `Main.java` file. It will test everything and show you the results in the console.
