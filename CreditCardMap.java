import java.util.NoSuchElementException;

public class CreditCardMap {
	private HashTableMap<Long, CreditCard> hashtable;
	private String admPassword;

	public CreditCardMap() {
		this.hashtable = new HashTableMap<Long, CreditCard>();
		this.admPassword = "LE";
	}

	/**
	 * Input a new credit card into the map, if that card number already exist, the
	 * new card will not be inputed
	 * 
	 * @param cardNum the card number the user entered
	 * @param credit  The credit card object
	 * @return true if the card is successfully inputed
	 */
	public boolean put(Long cardNum, CreditCard credit) {
		boolean result = hashtable.put(cardNum, credit);
		return result;
	}

	/**
	 * Get the credit card if the user enter valid card number and correct password
	 * 
	 * @param cardNum             the card number the user entered
	 * @param expDateAKAPassaword the password the user entered
	 * @return The credit card object with that card number if user input password
	 *         correctly
	 * @throws NoSuchElementException there is no credit card with that credit card
	 *                                number
	 * @throws WrongPasswordException when the user enter the old password
	 */
	public CreditCard get(Long cardNum, String expDateAKAPassaword)
			throws NoSuchElementException, WrongPasswordException {
		CreditCard resultCard = null;
		try {
			resultCard = hashtable.get(cardNum);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("The card with the input card number does not exist");
		}
		if (resultCard.equals(null)) {
			return null;
		} else if (resultCard.getExpDate().equals(expDateAKAPassaword)) {
			throw new WrongPasswordException();
		} else {
			return resultCard;
		}
	}

	/**
	 * Show how many cards are in the map
	 * 
	 * @return the number of card in the map
	 */
	public int size() {
		return this.hashtable.size();
	}

	/**
	 * Check if the map has a credit card with that card number
	 * 
	 * @param cardNum the card number the user entered
	 * @return true if a credit card with that card number exist
	 */
	public boolean containsKey(Long cardNum) {
		boolean result = this.hashtable.containsKey(cardNum);
		return result;
	}

	/**
	 * Remove a credit card object from the map if the user enter valid card number
	 * and correct password
	 * 
	 * @param cardNum             the card number the user entered
	 * @param expDateAKAPassaword the password the user entered
	 * @return The credit card object if successfully remove, null if that input
	 *         card number does not exist
	 * @throws WrongPasswordException when the user enter the old password
	 */
	public CreditCard remove(Long cardNum, String expDateAKAPassaword) throws WrongPasswordException {
		CreditCard resultCard = this.hashtable.get(cardNum);
		if (resultCard.equals(null)) {
			return null;
		} else if (!resultCard.getExpDate().equals(expDateAKAPassaword)) {
			throw new WrongPasswordException();
		} else {
			this.hashtable.remove(cardNum);
			return resultCard;
		}
	}

	/**
	 * Remove every credit card that has stored in the map
	 * 
	 * @param admPassword the user enter password that will be compared to the
	 *                    administer password
	 * @throws WrongPasswordException when the user enter the old password
	 */
	public void clear(String admPassword) throws WrongPasswordException {
		if (this.admPassword.equals(admPassword)) {
			this.hashtable.clear();
		} else {
			throw new WrongPasswordException();
		}
	}
	
	/**
	 * Check if the user enter the correct adimin password
	 * 
	 * @param userPass the password that the user enter in the admin option
	 * @return true if the password is correct
	 */
	public boolean checkPassword(String userPass) {
		if(userPass.equals(admPassword)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Change the administer password if the user enter old password correctly
	 * 
	 * @param oldPass The old password
	 * @param newPass The new password
	 * @return the new password if change successfully
	 * @throws WrongPasswordException when the user enter the old password
	 */
	public String changeAdminPassword(String oldPass, String newPass) throws WrongPasswordException {
		if (this.admPassword.equals(oldPass)) {
			this.admPassword = newPass;
			return newPass;
		} else {
			throw new WrongPasswordException();
		}
	}
}
