// --== CS400 File Header Information ==--
// Name: Ananya Heroor
// Email: heroor@wisc.edu
// Team: Team LE
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: My files are: CreditCard.java, CardCollection.java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * This class saves and reads the data file
 * @author ananyaheroor
 *
 */
public class CardCollection {

  HashTableMap<Long, CreditCard> hashtable;
  public void readCollection() throws FileNotFoundException {
    File file = new File("./Data_Wrangler_1_Data.csv");
    Scanner sc = new Scanner (file);
 
    long cardNum = 0;
    String expDate = "";
    String cardHolder = ""; 
    hashtable = new HashTableMap<Long, CreditCard>();
    
    while (sc.hasNextLine()) {
      String[] fields = sc.nextLine().split(",");
      cardNum = Long.parseLong(fields[0]);
      expDate = fields[1];
      cardHolder = fields[2];
      hashtable.put(cardNum, new CreditCard(cardNum, expDate, cardHolder));
      //sc.nextLine();
    }
    sc.close();
    System.out.println("Loaded: "+hashtable.size()+" cards");
    
  }
  public void writeCollection() throws IOException {
    //Can't implement, no method to read contents of hashtable
    
  }
  public HashTableMap<Long, CreditCard> getHash(){
    return this.hashtable;
  }
  public void setHash(HashTableMap<Long, CreditCard> newhashmap) {
   this.hashtable = newhashmap;
  }
  
  
}
