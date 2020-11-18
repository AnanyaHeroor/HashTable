// --== CS400 File Header Information ==--
// Name: Ananya Heroor
// Email: heroor@wisc.edu
// Team: Team LE
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTableMap <KeyType, ValueType> implements MapADT<KeyType, ValueType>{
  
  private class Node<Key, Value> {
    Key key;
    Value value;
    public Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }
  
  private LinkedList<Node<KeyType, ValueType>> [] arr;
  private int count = 0;
  private int capacity = 0;
  
  @SuppressWarnings("unchecked")
  public HashTableMap(int capacity) {
    arr = new LinkedList [capacity];
    this.capacity = capacity;
  }
  
  @SuppressWarnings("unchecked")
  public HashTableMap() {
    arr = new LinkedList [10];
    capacity = 10;
  }
  
  @SuppressWarnings("unchecked")
  private void grow() {
    LinkedList<Node<KeyType, ValueType>> [] newArr = new LinkedList[capacity*2];
    capacity = capacity *2;
    for(int i=0; i<count; i++)
    {
      LinkedList <Node<KeyType, ValueType>> e = arr[i];
      if(e != null) {
        newArr[getIndex(e.getFirst().key)] = e;
      }
    }
    this.arr = newArr;
    
    }
  
  private void checkSize() {
    float cf = ((float)this.count/(float)this.capacity); 
    if(cf >= 0.8) {
      this.grow();
    } 
  }

  private int getIndex(KeyType key) {
    int theHash = key.hashCode();
    if(theHash < 0) {
      theHash = -1*theHash;
    }
    return theHash%capacity;
  }

  @Override
  public boolean put(KeyType key, ValueType value) {
    if (this.arr[getIndex(key)] != null ) {
      LinkedList<Node<KeyType, ValueType>> l = arr[getIndex(key)];
      for(int i =0 ; i < l.size(); i++)
      {
        Node<KeyType, ValueType> e = l.get(i);
        if( e.key.equals(key) ) {
          return false;
        }
      }
      this.arr[getIndex(key)].add(new Node<KeyType, ValueType>(key, value));
      this.count++;
      checkSize();
      return true;
    } else {
      this.arr[getIndex(key)] = new LinkedList<Node<KeyType, ValueType>>();
      this.arr[getIndex(key)].add(new Node<KeyType, ValueType>(key, value));
      this.count++;
      checkSize();
      return true;
    }
  }

  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    if(key != null && arr[getIndex(key)] != null) {
      LinkedList<Node<KeyType, ValueType>> l = arr[getIndex(key)];
      for(int i=0; i<l.size(); i++) {
        if(l.get(i).key.equals(key)) {
          Node<KeyType, ValueType> e = l.get(i);
          return e.value;
        }
      }
    }
    throw new NoSuchElementException();
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public boolean containsKey(KeyType key) {
    if(key!=null && arr[getIndex(key)] != null) {
      LinkedList<Node<KeyType, ValueType>> l = arr[getIndex(key)];
      for(int i=0; i<l.size(); i++) {
        if(l.get(i).key.equals(key)) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public ValueType remove(KeyType key) {
    if(arr[getIndex(key)] != null) {
      LinkedList<Node<KeyType, ValueType>> l = arr[getIndex(key)];
      for(int i=0; i<l.size(); i++) {
        if(l.get(i).key.equals(key)) {
          Node<KeyType, ValueType> e = l.remove(i);
          count--;
          return e.value;
        }
      }
    }
    return null;
  }

  @Override
  public void clear() {
    for(int i=0; i< capacity; i++) {
      arr[i] = null;
    }
    count =0;
  }
  
}
