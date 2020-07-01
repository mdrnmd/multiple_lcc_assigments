import java.util.Scanner;

// Esta classe providencia a leitura de uma lista a partir do stdin
// e chama o metodo reverse
class Prob132 {

    public static void reverse(Stack<Integer> s, int n) {
	//int[] invert = new int[n];
	
	LinkedList<Integer> invert = new LinkedList<Integer>();
	
	
	for (int i=0; i<n; i++) {
	    //invert[i]=s.pop();
	    invert.addLast(s.pop());
	    
	}
	for (int i=0; i<n; i++) {
	    //s.push(invert[i]);
	    s.push(invert.get(i));
	    
	}
    }
    
public static void main(String args[]) {
    Scanner stdin = new Scanner(System.in);
    Stack<Integer> s = new Stack<Integer>();    
	
    int size = stdin.nextInt();
    for (int i=0; i<size; i++) {
	int n = stdin.nextInt();
	s.push(n);
    }
    int n = stdin.nextInt();

    System.out.println("Pilha Inicial: " + s);
    reverse(s, n);
    System.out.println("Pilha Final:   " + s);
}
}

// Classe para representar uma pilha
class Stack<T> {
    LinkedList<T> elements;

    public Stack() {
	elements = new LinkedList<T>();
    }
    public boolean isEmpty() {
	return elements.empty();
    }
    public int size() {
	return elements.size();
    }
    public T pop() {
	T value = elements.get(0);
	elements.removeFirst();
	return value;
    }
    public void push(T value) {
	elements.addFirst(value);
    } 
    public T top() {
	return elements.get(0);
    }
    public String toString() {
	return elements.toString();
    }
}

// Classe para representar um no
class Node<T> {
    T    value;
    Node<T> next;

    Node(T v, Node<T> n) {
	value = v;
	next  = n;
    }

    Node(T v) {
	value = v;
	next  = null;
    }
}

// Classe para representar uma lista
class LinkedList<T> {  
    Node<T> first; 
    int     size;  
                         
    public LinkedList() {    
	first = null; 
	size  = 0; 
    }

    public int size() { 
	return size; 
    }

    public String toString() {
	if (size == 0) 
	    return new String("[]");
	else {
	    String  s = new String("[");
	    Node<T> p = first;
	    while (p.next != null) {
		s += p.value + ",";
		p = p.next;
	    }
	    s += p.value + "]";
	    return s;
	}
    }

    public void addFirst(T value) {
	first = new Node<T>(value, first);
	size++;
    }

    public void addLast(T value) {
	if(size == 0) 
	    first = new Node<T>(value, first);
	else {
	    Node<T> p = first;
	    for( int i = 0 ; i < size - 1 ; i++)
		p = p.next;
	    p.next = new Node<T>(value);
	}
	size++;
    }

    public T get(int index) {
	if (size == 0) 
	    throw new IndexOutOfBoundsException();
	if ( index < 0 || index > size - 1 )
	    throw new IndexOutOfBoundsException();
	Node<T> p = first;
	for ( int i = 0; i < index ; i++ ) 
	    p = p.next;
	return p.value;
    }

    public boolean empty() { 
	return (size == 0); 
    }

    public void removeFirst() {
	if (size == 0) 
	    throw new IndexOutOfBoundsException();
	first = first.next;
	size--;
    }

    
}
