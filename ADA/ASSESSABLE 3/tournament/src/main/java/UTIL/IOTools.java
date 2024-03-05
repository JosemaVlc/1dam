package UTIL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOTools {
	
	public static Scanner scKeyboard = new Scanner(System.in);

	/**
	 * ----------------------------------------- 
	 * DATATYPE METHODS
	 * -----------------------------------------
	 */
	/*
	 * ---------------------------------------------------------
	 * Displays a text and waits for other text on the keypad.
	 * ---------------------------------------------------------
	 */
	public static String AskString(String stQuestion) {
		System.out.print(stQuestion + ": ");
		// https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
		String string = scKeyboard.next();
		scKeyboard.nextLine();
		return string;
	}
	
	public static String AskStringWhitSpaces(String stQuestion) {
		System.out.print(stQuestion + ": ");
		// https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
		return scKeyboard.nextLine();
	}
	
	public static char AskChar(String stQuestion, String valids) {
		boolean verif=false;
		char cResult;
		do {
			System.out.print(stQuestion + ": ");
			// https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
			String string = scKeyboard.next().toUpperCase();
			scKeyboard.nextLine();
			cResult = string.charAt(0);
			Pattern pattern = Pattern.compile(valids);
			Matcher matcher = pattern.matcher(String.valueOf(cResult));
			if (matcher.matches()) {
				verif = true;
			} else {
				verif = false;
				System.out.println("The character does not match the pattern.");
			}
		}while(verif==false);
		return cResult;
	}
	
	public static float AskForScore(String stQuestion) {
		boolean bRepeat = true;
		float iResult = -1;
		do {
			String stValue = AskString(stQuestion); // read the above method question
			try {
				iResult = Float.parseFloat(stValue);
				if(iResult == 0 || iResult == 0.5 || iResult == 1) {
					bRepeat = false;
				}else {
					System.out.println("Invalid Score. Try again.");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + stValue + " is not a valid number");
			}
		} while (bRepeat);

		return iResult;
	}

	/*
	 * -----------------------------------------------------------------------------------------
	 * Displays a text and waits for an integer by keyboard.
	 * -----------------------------------------------------------------------------------------
	 */
	public static int AskInt(String stQuestion) {
		boolean bRepeat = true;
		int iResult = -1;
		do {
			String stValue = AskString(stQuestion); // read the above method question
			try {
				iResult = Integer.parseInt(stValue);
				bRepeat = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + stValue + " is not a valid number");
			}
		} while (bRepeat);

		return iResult;
	}
	
	/*
	 * -----------------------------------------------------------------------------------------
	 * Displays a text and waits for an integer by keyboard between a minimum and a maximum.
	 * -----------------------------------------------------------------------------------------
	 */
	public static int AskInt(String stQuestion, int iMin, int iMax) {
		boolean bRepeat = true;
		int iResult = -1;
		do {
			String stValue = AskString(stQuestion); // read the above method question
			try {
				iResult = Integer.parseInt(stValue);
				bRepeat = (iResult < iMin) || (iResult > iMax);
				if (bRepeat) {
					System.out.println("Error: " + iResult + " out of range");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + stValue + " is not a valid number");
			}
		} while (bRepeat);

		return iResult;
	}
	/*
	 * -----------------------------------------------------------------------------------------
	 * Displays a text and waits for an integer by keyboard with a minimum.
	 * -----------------------------------------------------------------------------------------
	 */
	public static int AskInt(String stQuestion, int iMin) {
		boolean bRepeat = true;
		int iResult = -1;
		do {
			String stValue = AskString(stQuestion); // read the above method question
			try {
				iResult = Integer.parseInt(stValue);
				bRepeat = (iResult < iMin);
				if (bRepeat) {
					System.out.println("Error: " + iResult + " out of range");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + stValue + " is not a valid number");
			}
		} while (bRepeat);

		return iResult;
	}

	/*
	 * -------------------------------------------------------------------------------------------
	 * Displays a text and waits for a long by keyboard.
	 * -------------------------------------------------------------------------------------------
	 */
	public static long AskLong(String stQuestion) {
		boolean bRepeat = true;
		long lResult = -1;
		do {
			String stValue = AskString(stQuestion);
			try {
				lResult = Long.parseLong(stValue);
				bRepeat = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + stValue + " is not a valid number");
			}
		} while (bRepeat);

		return lResult;
	}
	
	/*
	 * -------------------------------------------------------------------------------------------
	 * Displays a text and waits for a long by keyboard between a minimum and a maximum.
	 * -------------------------------------------------------------------------------------------
	 */
	public static long AskLong(String stQuestion, long lMin, long lMax) {
		boolean bRepeat = true;
		long lResult = -1;
		do {
			String stValue = AskString(stQuestion);
			try {
				lResult = Long.parseLong(stValue);
				bRepeat = (lResult < lMin) || (lResult > lMax);
				if (bRepeat) {
					System.out.println("Error: " + lResult + " out of range");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + stValue + " is not a valid number");
			}
		} while (bRepeat);

		return lResult;
	}
	
	/*
	 * -------------------------------------------------------------------------------------------
	 * Displays a text and waits for a double by keyboard.
	 * -------------------------------------------------------------------------------------------
	 */
	public static double AskDouble(String stQuestion) {
		
		boolean bRepeat = true;
		double dResult = -1;
		do {
			String stValue = AskString(stQuestion);
			try {
				dResult = Double.parseDouble(stValue);
				bRepeat = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + stValue + " is not a valid number");
			}
		} while (bRepeat);
		
		return dResult;
	}
	
	/*
	 * -------------------------------------------------------------------------------------------
	 * Displays a text and waits for a double by keyboard between a minimum and a maximum.
	 * -------------------------------------------------------------------------------------------
	 */
	public static double AskDouble(String stQuestion, double dMin, double dMax) {
		boolean bRepeat = true;
		double dResult = -1;
		do {
			String stValue = AskString(stQuestion);
			try {
				dResult = Double.parseDouble(stValue);
				bRepeat = (dResult < dMin) || (dResult > dMax);
				if (bRepeat) {
					System.out.println("Error: " + dResult + " out of range");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + stValue + " is not a valid number");
			}
		} while (bRepeat);

		return dResult;
	}

	/*
	 * -------------------------------------------------------------------------------------------
	 * Displays a text and waits for a float by keyboard.
	 * -------------------------------------------------------------------------------------------
	 */
	public static float AskFloat(String stQuestion) {
		boolean bRepeat = true;
		float fResult = -1;
		do {
			String stValue = AskString(stQuestion);
			try {
				fResult = Float.parseFloat(stValue);
				bRepeat = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + stValue + " is not a valid number");
			}
		} while (bRepeat);

		return fResult;
	}
	
	/*
	 * -------------------------------------------------------------------------------------------
	 * Displays a text and waits for a float by keyboard between a minimum and a maximum.
	 * -------------------------------------------------------------------------------------------
	 */
	public static float AskFloat(String stQuestion, float fMin, float fMax) {
		boolean bRepeat = true;
		float fResult = -1;
		do {
			String stValue = AskString(stQuestion);
			try {
				fResult = Float.parseFloat(stValue);
				bRepeat = (fResult < fMin) || (fResult > fMax);
				if (bRepeat) {
					System.out.println("Error: " + fResult + " out of range");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + stValue + " is not a valid number");
			}
		} while (bRepeat);

		return fResult;
	}

	/**
	 * ----------------------------------------- 
	 * MENU METHODS
	 * -----------------------------------------
	 */
	/*
	 * -------------------------------------------------------------------------------------------
	 *  Displays a text and waits for a number from a list of options.
	 * -------------------------------------------------------------------------------------------
	 */
	public static int AskInt(String stQuestion, int... iValids) {
		boolean bAsk = true;
		int iResult;
		do {
			iResult = AskInt(stQuestion, iValids[0], iValids[iValids.length - 1]);
			bAsk = Arrays.binarySearch(iValids, iResult) < 0;
		} while (bAsk);

		return iResult;
	}

	/*
	 * -------------------------------------------------------------------------------------------
	 *  Displays a menu and waits for the user to choose an option.
	 * -------------------------------------------------------------------------------------------
	 */
	public static int ShowMenu(String stTitle, String... stOptions) {
		System.out.println();
		System.out.println(stTitle);
		System.out.println("================================================");
		int iResult;
		
		if ((stOptions == null) || (stOptions.length == 0)) {
			iResult = -1;
		} else {
			int iNumOptions = 0;
			for (int ii = 0; ii < stOptions.length; ii++) {
				if ((stOptions[ii] == null) || ("".equals(stOptions[ii].trim()))) {
					System.out.println();
				} else {
					System.out.println("  " + iNumOptions + ". " + stOptions[ii]);
					iNumOptions++;
				}
			}
			System.out.println("================================================");
			iResult = AskInt("    Select an option", 0, iNumOptions);
			System.out.println();
		}
		return iResult;
	}
	
	public static void pressAnyKey() {
		System.out.println("");
		System.out.println("Press any Key to continue");
		scKeyboard.nextLine();
	}
	
	/*
	 * -------------------------------------------------------------------------------------------
	 *  Displays a text and waits for a date by keyboard. format dd/MM/yyyy
	 * -------------------------------------------------------------------------------------------
	 */
	public static LocalDate AskDate(String stQuestion) {
		boolean bRepeat = true;
		LocalDate dResult = null;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		do {
			String stValue = AskString(stQuestion);
			try {
				dResult = LocalDate.parse(stValue, dateFormatter);	
                bRepeat = false;
			} catch (DateTimeParseException e) {
				System.out.println("Error: " + stValue + " is not a valid date");
			}
		} while (bRepeat);

		return dResult;		
	}	
}
