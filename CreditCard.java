// --== CS400 File Header Information ==--
// Name: Ananya Heroor
// Email: heroor@wisc.edu
// Team: LE
// Role: Data Wrangler 1
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: My files are: CreditCard.java, CardCollection.java
/**
 * This class reads and saves the credit card data
 * @author ananyaheroor
 *
 */
public class CreditCard {
  private Long cardNumber;
  private String expDate;
  private String cardHolder;
  
  public CreditCard(Long cardNumber, String expDate, String cardHolder) {
    this.cardNumber = cardNumber;
    this.expDate = expDate;
    this.cardHolder = cardHolder;
  }
  
  /**
   * This method gets credit card numbers
   * @return cardNumber
   */
  public Long getCardNumber() {
    return cardNumber;
  }
  
  /**
   * This method sets credit card numbers
   * @param cardNumber
   * @return cardNumber
   */
  public void setCardNumber(Long cardNumber) {
    this.cardNumber = cardNumber;
  }

  /**
   * This method gets the credit card expiration dates
   * @return expDate
   */
  public String getExpDate() {
    return expDate;
  }

  /**
   * This method sets the credit card expiration dates
   * @param expDate
   * @return expDate
   */
  public void setExpDate(String expDate) {
    this.expDate = expDate;
  }

  /**
   * This method gets the name of the credit card holder
   * @return cardHolder
   */
  public String getCardHolder() {
    return cardHolder;
  }

  /**
   * This method sets the name of the credit card holder
   * @param cardHolder
   * @return cardHolder
   */
  public void setCardHolder(String cardHolder) {
    this.cardHolder = cardHolder;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cardHolder == null) ? 0 : cardHolder.hashCode());
    result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
    result = prime * result + ((expDate == null) ? 0 : expDate.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CreditCard other = (CreditCard) obj;
    if (cardHolder == null) {
      if (other.cardHolder != null)
        return false;
    } else if (!cardHolder.equals(other.cardHolder))
      return false;
    if (cardNumber == null) {
      if (other.cardNumber != null)
        return false;
    } else if (!cardNumber.equals(other.cardNumber))
      return false;
    if (expDate == null) {
      if (other.expDate != null)
        return false;
    } else if (!expDate.equals(other.expDate))
      return false;
    return true;
  }

   

}
