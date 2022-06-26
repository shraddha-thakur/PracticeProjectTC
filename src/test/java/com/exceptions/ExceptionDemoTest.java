package com.exceptions;

public class ExceptionDemoTest {

	public static void main(String[] args) {
		checkPin();
		withdrawMoney();
	}

	private static void withdrawMoney() {

		if (checkSufficientMoneyInAtm() && checkDenominationAvailable() && checkBalanceAvailableInAccount()) {
			System.out.println("Cash dispensed");
		} else {
			throw new RuntimeException("Denoimination of 100 is not available");
		}

//		try {
//			checkBalanceAvailableInAccount();
//			checkDenominationAvailable();
//			checkSufficientMoneyInAtm();
//		} catch (insufficientbalance e) {
//
//		} catch (denominationnotavailable e) {
//
//		} catch (anyotherexception e) {
//
//		}
	}

	private static boolean checkSufficientMoneyInAtm() {
		return true;
	}

	private static boolean checkDenominationAvailable() {
		return false;
	}

	private static boolean checkBalanceAvailableInAccount() {
		return true;

	}

	private static void checkPin() {
		throw new RuntimeException("Incorrect Pin Entered");
	}

}
