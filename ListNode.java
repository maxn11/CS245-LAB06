//Maximus Nie
//3/24/2022
//CS245 Lab06: Linked List Functions

public class ListNode<T> {
	
	private T data;
	private ListNode<T> head;
	private ListNode<T> next;
	private int size;
	
	public ListNode() {
	    data = null;
	    next = null;
	    size = 0;
	}
	
	public ListNode(T value) {
	    data = value;
	    next = null;
	    size = 0;
	}
	
    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param item element to be appended to this list
     * @return {@code true}
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     * @throws IllegalArgumentException      if some property of this element
     *                                       prevents it from being added to this list
     */
    public boolean add(Object item) {
    	//check if list is empty, then add to first spot
    	if(item instanceof Object == false) {
    		throw new IllegalArgumentException("Invalid");
    	}
    	if(head == null) {
    		head = new ListNode(item);
    		if(head.data instanceof Object == false) {
        		throw new ClassCastException("Incompatible Types");
        	}
    		++size;
    		return true;
    	}
    	//else, append the element
    	ListNode<T> prev = head;
    	for(int i = 0; i < size - 1; i++) {
    		if(head == null || prev == null) {
    			throw new NullPointerException("Pointing to Null");
    		}
    		prev = prev.next;
    	}
    	ListNode<T> node = new ListNode(item);
    	if(node.data instanceof Object == false) {
    		throw new ClassCastException("Incompatible Types");
    	}
    	prev.next = node;
    	++size;

        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param position   index at which the specified element is to be inserted
     * @param item element to be inserted
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and
     *                                       this list does not permit null elements
     * @throws IllegalArgumentException      if some property of the specified
     *                                       element prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()})
     */
    public void add(int position, Object item) {
    	if(position > size || position < 0) {
    		throw new IllegalArgumentException("Invalid");
    	}
    	if(position == 0) {
    		ListNode<T> node = new ListNode(item);
    		if(head == null || node == null) {
    			throw new NullPointerException("Pointing to Null");
    		}
    		if(node.data instanceof Object == false) {
        		throw new ClassCastException("Incompatible Types");
        	}
    		node.next = head;
    		head = node;
    		++size;
    	} else {
    		ListNode<T> prev = head;
    		for(int i = 0; i < position - 1; i++) {
    			prev = prev.next;
    		}
    		if(position > size) {
				throw new IndexOutOfBoundsException("Out of Bounds");
			}
    		ListNode<T> node = new ListNode(item);
    		if(node.data instanceof Object == false) {
        		throw new ClassCastException("Incompatible Types");
        	}
    		node.next = prev.next;
    		prev.next = node;
    		++size;
    	}
    	
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param item element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     */
    public boolean contains(Object item) {
    	ListNode<T> curr = head;
        for(int i = 0; i < size; i++) {
        	if(curr == null) {
        		throw new NullPointerException("Pointing to Null");
        	}
        	if(curr.data instanceof Object == false) {
        		throw new ClassCastException("Incompatible Types");
        	}
        	if(curr.data == item) {
        		return true;
        	}
        	curr = curr.next;
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param position index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    public Object get(int position) {
    	ListNode<T> curr = head;
        for(int i = 0; i < position; i++) {
        	if(i < 0 || i >= size) {
        		throw new IndexOutOfBoundsException("Out of Bounds");
        	}
        	if(i == position - 1) {
        		return curr.data;
        	}
        	curr = curr.next;
        }
        return false;
    }

    /**
     * Removes the last element in this list. Returns the element that was removed from the
     * list.
     *
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */
    public Object removeLast() {
    	ListNode<T> curr = head;
    	ListNode<T> prev = head;
        for(int i = 0; i < size; i++) {
        	if(i < 0 || i >= size) {
        		throw new IndexOutOfBoundsException("Out of Bounds");
        	}
        	if(i == size - 1) {
        		prev.next = null;
        		--size;
        		return curr.data;
        	}
        	prev = curr;
        	curr = curr.next;
        }
        return curr.data;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param item element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     * @throws ClassCastException            if the type of the specified element
     *                                       is incompatible with this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     */
    public boolean remove(Object item) {
    	ListNode<T> curr = head;
    	ListNode<T> prev = head;
    	//check if its the first element
    	if(head.data == item) {
    		head = head.next;
    		--size;
    		return true;
    	}
    	//else, find item in list
        for(int i = 0; i < size - 1; i++) {
        	if(i < 0 || i >= size) {
        		throw new IndexOutOfBoundsException("Out of Bounds");
        	}
        	if(curr.data instanceof Object == false) {
        		throw new ClassCastException("Incompatible Types");
        	}
        	if(curr.data == item) {
        		prev.next = curr.next;
        		--size;
        		return true;
        	}
        	prev = curr;
        	curr = curr.next;
        }
        return false;
    }

    /**
     * Removes the element at the specified position from the end of the list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the head of the list.
     *
     * @param position the index of the item the end of the list to be removed
     * @return the head of the list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */
    public Object removeFromEnd(int position){
    	ListNode<T> curr = head;
    	ListNode<T> prev = head;
    	//check if its the first element
    	if(position == 0) {
    		return null;
    	}
    	//else, remove at n position
        for(int i = size - 1; i >= position; i--) {
        	if(i < 0 || i >= size) {
        		throw new IndexOutOfBoundsException("Out of Bounds");
        	}
        	if(i == position) {
        		prev.next = curr.next;
        		--size;
        		return head;
        	}
        	prev = curr;
        	curr = curr.next;
        }
        return head;
    }

    /**
     * Shows ListNode as a String, with each object in parentheses separated by “arrows” (->).
     * A ListNode of {1, 2, 3} should return the String "(1) -> (2) -> (3)".
     * @return String representation of the ListNode
     */
    @Override
    public String toString() {
    	String result = "";
        ListNode<T> curr = head;
        while(curr != null){
        	result += "(";
            result += curr.data;
            result += ")";
            if(curr.next != null){
                 result += " -> ";
            }
            curr = curr.next;
        }
        return "LinkedList: " + result;
    }

    //test code
    public static void main(String[] args){
    	
    	ListNode<Integer> list = new ListNode<>();
    	
    	//add
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	System.out.println(list.toString());
    	
    	//contains
    	System.out.println(list.contains(8));
    	
    	//get
    	System.out.println(list.get(2));
    	
    	//remove
    	list.remove(3);
    	System.out.println(list.toString());
    	
    	//add to position
    	list.add(2, 3);
    	System.out.println(list.toString());
    	
    	//remove last
    	list.removeLast();
    	System.out.println(list.toString());
    	list.add(4);

    	//remove from end
    	list.removeFromEnd(1);
    	System.out.println(list.toString());
    	
    }

}