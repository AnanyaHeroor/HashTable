// --== CS400 File Header Information ==--
// Name: Tsz Hin Tsang
// Email: ttsang5@wisc.edu
// Team: LE TEAM
// TA: Divyanshu 
// Lecturer: Gary Dahl
// Notes to Grader: there are five java file in total: HashTableMap.java, Linked.java, MapADT.java, Pair.java, TestHashTable.java

import java.util.NoSuchElementException;

public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
	private int capacity;
	private Linked array[];
	private int size;

	/**
	 * Default constructor with 10 capacity
	 */
	public HashTableMap() { // with default capacity = 10
		this(10);
	}

	/**
	 * Constructor with given capacity will create the hash array with that capacity
	 * 
	 * @param capacity the capacity of the array
	 */
	public HashTableMap(int capacity) {
		this.capacity = capacity;
		this.array = new Linked[capacity];
		this.size = 0;
	}

	/**
	 * Add the pair object with both password and detail into the hash table with
	 * hashing 
	 * case 1: nothing in that hash position, directly add that linked list in 
	 * case 2: linked list exist in that hash position 
	 * 2a: the first linked object in the hashed position match the going to 
	 * be added key, so do nothing
	 * 2b: a linked object in the hashed position match the going to be added key,
	 * so do nothing 
	 * 2c: no match in that linked list found, add the key to the tail
	 * of the linked list
	 * 
	 * The table will resize if it reached 80% of the capacity after adding
	 * 
	 * @param key   the password part of the detail
	 * @param value the stored detail part of the pair
	 * @return true if a pair is added, false if not
	 */
	@Override
	public boolean put(KeyType key, ValueType value) {
		// hashing the given key
		int hashcode = key.hashCode() % this.capacity;
		// pairing
		Pair data = new Pair(key, value);
		Linked list = new Linked(data);
		// case 1, nothing in that hash position, directly add that linked list in
		if (array[hashcode] == null) {
			array[hashcode] = list;
			size++;
			// resize if needed
			if (this.size >= this.capacity * 8 / 10) {
				resize();
			}
			return true;
		}
		// case 2 a linked list exist in that hash position
		else {
			// case 2a the first linked object match the going to be added key
			if (array[hashcode].equals(list)) {
				return false;
			}
			// case 2b there are more than one linked object in that linked list
			Linked current = array[hashcode];
			while (current.getNext() != null) {
				current = current.getNext();
				// one of the linked object match the going to be added key
				if (current.equals(list)) {
					return false;
				}
			}
			// case 2c no match found, add the key to the tail of the linked list
			current.setNext(list);
			size++;
			// resize if needed
			if (this.size >= this.capacity * 8 / 10) {
				resize();
			}
			return true;
		}
	}

	/**
	 * Get the stored detail from inputing the password key 
	 * case 1: nothing in that hash location of the key, throw a no such element exception 
	 * case 2: a linked list exist in that hash position loop through the linked list 
	 * a: the key is found, return the stored detail 
	 * b: no key found, throw a no such element exception
	 * 
	 * @param key the password part of the detail
	 * @throws NoSuchElementException if a pair with that key does not exist
	 * @return the stored detail of the pair if that key pair is found
	 */
	@Override
	public ValueType get(KeyType key) throws NoSuchElementException {
		// hashing the given key
		int hashcode = key.hashCode() % this.capacity;
		// case 1 nothing in that hash location
		if (array[hashcode] == null) {
			throw new NoSuchElementException();
		}
		// case 2 a linked list exist in that hash position
		else {
			Linked current = array[hashcode];
			// check for matched key
			do {
				if (current.getPair().getKey().equals(key)) {
					// case 2a key found
					return (ValueType) current.getPair().getValue();
				}
				current = current.getNext();
			} while (current != null);
			// case 2b key not found
			throw new NoSuchElementException();
		}
	}

	/**
	 * Return the number of pair in the hash table
	 *
	 * @return the size of the hash table
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Check if that key pair exist Use the get() method to check, if it does not
	 * throw an exception, that pair exist
	 *
	 * @param key the password part of the detail
	 * @return true if there exist a pair with that key, false if otherwise
	 */
	@Override
	public boolean containsKey(KeyType key) {
		// use the try method to get the key, if success, then it exist
		try {
			this.get(key);
			return true;
		}
		// if not able to get the key, it does not exist
		catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Remove the pair with the given key  
	 * case 1: nothing in that hash location of the key, return null 
	 * case 2: a linked list exist in that hash position 
	 * a: there is only one linked object in the linked list and it matches the going
	 * to be removed key, so it removes the pair and return the stored detail loop
	 * through the linked list if there is more than one linked object in the list
	 * b: key is found, remove it and return the stored detail c: that key is not
	 * found, return null
	 *
	 * @param key the password part of the detail
	 * @return null if no pair is with that key, the stored detail of the removed
	 *         pair if that key pair is found
	 */
	@Override
	public ValueType remove(KeyType key) {
		// hashing the given key
		int hashcode = key.hashCode() % this.capacity;
		// case 1 nothing in that hash location
		if (array[hashcode] == null) {
			return null;
		}
		// case 2 a linked list exist in that hash position
		else {
			Linked current = array[hashcode];
			// case 2a there is only one linked object in the linked list and it matches the
			// going to be removed key
			if (current.getPair().getKey().equals(key) && current.getNext() != null) {
				array[hashcode] = current.getNext();
				size--;
				return (ValueType) current.getPair().getValue();
			}
			// case 2bi there is more than one linked object in the linked list and the
			// first element matches the going to be removed key
			if (current.getPair().getKey().equals(key)) {
				array[hashcode] = null;
				size--;
				return (ValueType) current.getPair().getValue();
			}
			// case 2bii there is more than one linked object in the linked list but the
			// first element does not match the going to be removed key
			while (current.getNext() != null) {
				// the matched key found
				if (current.getNext().getPair().getKey().equals(key)) {
					ValueType returning = (ValueType) current.getNext().getPair().getValue();
					current.setNext(current.getNext().getNext());
					size--;
					return returning;
				}
				current = current.getNext();
			}
			// case 2c no match found
		}
		return null;
	}

	/**
	 * Remove everything in the hash table by setting the hash array to a fresh
	 * array
	 */
	@Override
	public void clear() {
		// set the array to a new fresh array
		this.array = new Linked[capacity];
		this.size = 0;
	}

	/**
	 * Resize and rehash the old linked list of the old array into a doubled
	 * capacity array
	 */
	private void resize() {
		this.capacity = capacity * 2;
		// create a new doubled capacity array that is going to replace the old one
		Linked newArray[] = new Linked[capacity];
		for (int i = 0; i < capacity / 2; i++) {
			Linked temp = array[i];
			// a linked list in the i index of the old array
			if (temp != null) {
				// Rehash
				int newhash = temp.getPair().getKey().hashCode() % capacity;
				// Set the new array at the rehashed position to that linked list
				newArray[newhash] = array[i];
			}
		}
		// set the old array to the newArray
		this.array = newArray;
	}

}
