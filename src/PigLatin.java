// Assignment
// X The application prompts the user for a phrase.
// X The application translates the text to Pig Latin and displays it on the console.
// X The application asks the user if he or she wants to translate another word
// X Words beginning with vowels are skipped.

// Extra Challenges
// Keep the case of the word, whether its uppercase (WORD), title case (Word), or
// 		lowercase (word).
// Allow punctuation in the input string.
// X Translate words with contractions. Ex: can’t become an’tcay
// X Don’t translate words that have numbers or symbols. Ex: 189 should be left as 189 
// 		and hello@grandcircus.co should be left as hello@grandcircus.co.
// X Check that the user has actually entered text before translating.
// X Make the application take a line instead of a single word, and then find the Pig Latin
// 		for each word in the line.


import java.util.Scanner;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

public class PigLatin
{
	public static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to the Pig Latin translator!\r\n");
		String userResponse = "";
		do
		{
			String input = getPLInput();
			translatePL(input);
			System.out.println("\n Would you like translate another line? (y/n)\r\n");
			userResponse = scnr.nextLine();
		}
		while (userResponse.equals("y"));
	System.out.println("Goodbye.");
	scnr.close();
	}
	
	private static String getPLInput()
	{
		System.out.println("Enter a line to be translated.\r\n");
		String input = scnr.nextLine();
		while (input.equals(""))
		{
			System.out.println("Your entry was invalid. Enter a line to be translated.\r\n");
			input = scnr.nextLine();
		}
		return input;
	}
	
	private static void translatePL(String input)
	{
		String[] words = input.split(" ");
		String firstLetter;
		Pattern vowels = Pattern.compile("[^aeiouAEIOU^]");
		Pattern noNumbersSymbols = Pattern.compile("[^a-zA-Z;.!?^]");
		boolean containsNumberSpecial = true;
		boolean isvowel = true;
		for (int i =0; i < words.length; i++)
		{
			firstLetter = words[i].substring(0,1);
			Matcher noSymbolsMatcher = noNumbersSymbols.matcher(words[i]);
			Matcher vowelsMatcher = vowels.matcher(firstLetter);
			containsNumberSpecial = noSymbolsMatcher.find();
			isvowel = vowelsMatcher.find();
			if (isvowel == false)
			{
				words[i] += " ";
			}
			else if (containsNumberSpecial == true)
			{
				words[i] += " ";
			}
			else
			{
			words[i] = words[i].substring(1) + firstLetter + "ay ";
			}
			
		}
		for ( String outputWords : words) {
		    System.out.print(outputWords);
		}
	}
}