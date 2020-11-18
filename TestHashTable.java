// --== CS400 File Header Information ==--
// Name: Ananya Heroor
// Email: heroor@wisc.edu
// Team: LE
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
public class TestHashTable{

  /**
   * Check if HashTableMap class's put method is correct
   * @return true if the class successfully can put elements in a list,
   * false otherwise
   */
  public static boolean test1() {
    boolean passed = true;
    //create an empty hash table
    HashTableMap<String, String> hashtablemap = new HashTableMap <String, String>();

    //put 2 values (a credit card number and the credit card holder information) in the hash table
    hashtablemap.put("056011980649898", "Beverley Beaumont");
    hashtablemap.put("000019078111455", "Cordelia Cornelius");
    
    //Display the hash table
    //System.out.println(hashtablemap);
    
    
    //if new hash table shows 2 values that we inserted above, return true
    if (hashtablemap.containsKey("056011980649898") && hashtablemap.containsKey("000019078111455")) {
      return passed;
    }
    passed = false;
    System.out.println("The put method did not successfully insert the new key, value pair.");
    return passed;
  }
  
  /**
   * Check if HashTableMap class's get method is correct
   * @return true if the class successfully gets the element specified from the list,
   * false otherwise
   */
  public static boolean test2() {
    boolean passed = true;
  //create an empty hash table
    HashTableMap<String, String> hashtablemap2 = new HashTableMap <String, String>();
    
    //put 2 (a credit card number and the credit card holder information) in the hash table
    hashtablemap2.put("356011980649898", "Beverley Beaumont");
    hashtablemap2.put("349119078111455", "Cordelia Cornelius");
    
    
    //if the first element that it gets matches element 0 then passed = true
    if (hashtablemap2.get("356011980649898") != null) {
      return passed;
    } 
    System.out.println("The get method did not successfully get element 0");
    return passed=false;
  }
  
  /**
   * Check if HashTableMap class's size method is correct
   * @return true if the class successfully returns the size of a list,
   * false otherwise
   */
  public static boolean test3() {
    boolean passed = true;
  //create an empty hash table
    HashTableMap<String, String> hashtablemap3 = new HashTableMap <String, String>();
    
    //add 2 (a credit card number and the credit card holder information) to hash table
    hashtablemap3.put("356011980649898", "Beverley Beaumont");
    hashtablemap3.put("349119078111455", "Cordelia Cornelius");
    
    
    //if the size is called and matches the size of the list, passed = true
    if (hashtablemap3.size() == 2) {
      return passed;
    }
    passed = false;
    System.out.println("The size method should have returned the size of "
        + "the list, which is 2 but instead returned a different value");
    return passed;
  }
  
  /**
   * Check if HashTableMap class's containsKey method is correct
   * @return true if the class successfully returns true if the list contains elements,
   * false otherwise
   */
  public static boolean test4() {
    boolean passed = true;
    //create an empty hash table
      HashTableMap<String, String> hashtablemap4 = new HashTableMap <String, String>();
      
    //if containsKey is called and returns false (since the table is empty) then passed = true
    if (hashtablemap4.containsKey(null) == false) {
      return passed;
    }
    else {
      passed = false;
      System.out.println("The containsKey should have returned false for the empty hash map"
          + "but returned true instead.");
    }
    return false;
    
  }
  /**
   * Check if HashTableMap class's clear method is correct
   * @return true if the class successfully clears the list,
   * false otherwise
   */
  public static boolean test5() {
    boolean passed = true;
    //create an empty hash table
      HashTableMap<String, String> hashtablemap5 = new HashTableMap <String, String>();
      
      
      
    //put 1 thing (a credit card number and the credit card holder information) in the hash table
      hashtablemap5.put("356011980649898", "Beverley Beaumont");
      
      
    //clear the hash table map
      hashtablemap5.clear();
    
    
    //if size says 0, then passed = true since it should be empty
      if (hashtablemap5.size() == 0) {
        return passed;
      }
      else {
      passed = false;
      System.out.println("the clear method did not successfully clear the hash map");
      }
      
      return false;
  }
  
  public static void main(String[] args) {
    // put
    System.out.println("test1() tests the put method: " + test1());
    
    // get
    System.out.println("test2() tests the get method: " + test2());
    
    // size
    System.out.println("test3() tests the size method: " + test3());
    
    // containsKey
    System.out.println("test4() tests the containsKey method: " + test4());
    
    // clear
    System.out.println("test5() tests the clear method: " + test5());
    
  }

}
