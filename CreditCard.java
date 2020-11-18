// --== CS400 File Header Information ==--
// Name: Chenyu Niu
// Email: cniu8@wisc.edu
// Team: LE
// Role: Data Wrangler2
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader:none

public class CreditCard {
    private Long cardNumber;
    private String cardHolder;
    private String expDate;

    public CreditCard(Long cardNumber,String expDate, String cardHolder) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cardHolder = cardHolder;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 89 * hash + (int) (this.cardNumber ^ (this.cardNumber >>> 32));
//        return hash;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CreditCard other = (CreditCard) obj;
        if (this.cardNumber != other.cardNumber) {
            return false;
        }
        return true;
    }


}

