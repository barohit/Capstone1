import java.util.Scanner; 
public class PigLatinGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char cont = 'y'; 
		String answer = ""; 
		while (cont == 'y') {
			System.out.println("Welcome to the Pig Latin Translator! Enter a word to be translated: "); 
			String userInput = scan.nextLine();  
			boolean multipleWords = false; 
			
			while (userInput.trim().isEmpty() == true) { // this while loop addresses the extended challenge that ensures the user has actually entered text input and not pure whitespace
					System.out.println("Sorry, this is nothing but whitespace, please enter again: ");
					userInput = scan.nextLine();
				
			}
			
			for (int i = 0 ; i < userInput.length() - 1; i++) { // sends the input to a separate method for the final extended challenge if necessary
				if (Character.isWhitespace(userInput.charAt(i)) == true && (Character.isWhitespace(userInput.charAt(i + 1)) == false)) {
					multipleWords = true; 
				}
			}
			if (multipleWords == false) {
				
				System.out.println(pigLatinBase(userInput)); 
				System.out.println("Extended Challenge: " + pigLatinExtendedChallenge(userInput)); 
				
			} else {
				System.out.println(pigLatinFinalExtendedChallenge(userInput)); 
			}
			
			System.out.println("Would you like to translate another word? (Y/N)");
			answer = scan.next();
			while (answer.length() > 1 || !(Character.toLowerCase(answer.charAt(0)) == 'y' || Character.toLowerCase(answer.charAt(0)) == 'n')) {
				System.out.println("Error, invalid entry. Please enter the letter Y, or the letter N: "); 
				answer = scan.next(); 
			}
			cont = Character.toLowerCase(answer.charAt(0)); 
			if (cont == 'n') {
				System.out.println("Thank you for playing!"); 
			}
			scan.nextLine(); //garbage line
		}
		scan.close(); 
		
	}
	
	public static String pigLatinBase(String input) {
		input = input.toLowerCase(); 
		int firstVowelIndex = 0; 
		String endString = "";
		
		outerloop: for (int i = 0; i < input.length(); i++) {
			switch (input.charAt(i)) {
			case 'a':
				firstVowelIndex = i; 
				break outerloop;  // something I learned when making a small project a while ago. 
			case 'e':
				firstVowelIndex = i; 
				break outerloop;
			case 'i':
				firstVowelIndex = i; 
				break outerloop; 
			case 'o':
				firstVowelIndex = i; 
				break outerloop; 
			case 'u':
				firstVowelIndex = i; 
				break outerloop; 
			default: 
				break; 
			}
		}
		endString = input.substring(0, firstVowelIndex);  
		
		switch (Character.toLowerCase(input.charAt(0))) {
		
		case 'a': 
			endString = "way"; 
			input = input.substring(0);
			break; 
			
		case 'e': 
			endString = "way"; 
			input = input.substring(0);
			break; 
			
		case 'i': 
			endString = "way"; 
			input = input.substring(0);
			break; 
			
		case 'o': 
			endString = "way"; 
			input = input.substring(0);
			break; 
			
		case 'u': 
			endString = "way"; 
			input = input.substring(0);
			break; 
			
		default: 
			endString = endString + "ay"; 
			input = input.substring(firstVowelIndex);
			break; 
		}
		
		input = input + endString; 
		return input; 
	}
	
	public static String pigLatinExtendedChallenge(String input) {
		int firstVowelIndex = 0; 
		String endString = "";
		boolean letterCheck = true;  // next 9  lines deal with the extended challenge about not translating words that have numbers or symbols
			for (int i = 0; i < input.length(); i++) {
				if (Character.isAlphabetic(input.charAt(i)) == false && !(input.charAt(input.length() - 1) == '!' || input.charAt(input.length() - 1) == '?' || input.charAt(input.length() - 1) == '.' || input.charAt(i) == ','  || input.charAt(i) == '\'')) {
					letterCheck = false; 
				}
			}
		if (letterCheck == false) {
			return input;  
		}
	
		outerloop: for (int i = 0; i < input.length(); i++) {
			switch (Character.toLowerCase(input.charAt(i))) {
			case 'a':
				firstVowelIndex = i; 
				break outerloop;  // something I learned when making a small project a while ago. 
			case 'e':
				firstVowelIndex = i; 
				break outerloop;
			case 'i':
				firstVowelIndex = i; 
				break outerloop; 
			case 'o':
				firstVowelIndex = i; 
				break outerloop; 
			case 'u':
				firstVowelIndex = i; 
				break outerloop; 
			default: 
				break; 
			}
		}
		endString = input.substring(0, firstVowelIndex).toLowerCase(); //a title or uppercase situation will be handled later. Since the uppercase and titlecase
		// checks use the original input, changing endString to a lowercase will not influence the uppercase check in the next three lines. 
		
		boolean upperCase = true;  // next three lines and associated switch statements deal with the extended challenge of keeping the case of the word. 
		for (int i = 0; i < input.length(); i++) { 
			if (Character.isLowerCase(input.charAt(i)) == true) {
				upperCase = false; 
			}
		}
		
		boolean titleCase = false;
		if (Character.isUpperCase(input.charAt(0)) == true)  {
			titleCase = true; 
		}
	
		// each word is not being moved to lower case due to the extended challenge of keeping the case of the word. 
		if (upperCase == false) {
			
			input = input.toLowerCase(); // If the word is titlecase, this will be handled at the very end of the method. 
					
			switch (Character.toLowerCase(input.charAt(0))) {
			
			case 'a': 
				endString = "way"; 
				input = input.substring(0);
				break; 
				
			case 'e': 
				endString = "way"; 
				input = input.substring(0);
				break; 
				
			case 'i': 
				endString = "way"; 
				input = input.substring(0);
				break; 
				
			case 'o': 
				endString = "way"; 
				input = input.substring(0);
				break; 
				
			case 'u': 
				endString = "way"; 
				input = input.substring(0);
				break; 
				
			default: 
				endString = endString + "ay"; 
				input = input.substring(firstVowelIndex);
				break; 
			}
			
			input = input + endString; 
			
		}
		
		if (upperCase == true) {
			

			switch (input.charAt(0)) {
			
			case 'A': 
				endString = "WAY"; 
				input = input.substring(0);
				break; 
				
			case 'E': 
				endString = "WAY"; 
				input = input.substring(0);
				break; 
				
			case 'I': 
				endString = "WAY"; 
				input = input.substring(0);
				break; 
				
			case 'O': 
				endString = "WAY"; 
				input = input.substring(0);
				break; 
				
			case 'U': 
				endString = "WAY"; 
				input = input.substring(0);
				break; 
				
			default: 
				endString = endString.toUpperCase() + "AY"; 
				input = input.substring(firstVowelIndex);
				break; 
			}
			
			input = input + endString; 
			
		}
	
		if (titleCase) { //handles titlecase
			input = Character.toUpperCase(input.charAt(0)) + input.substring(1); 
		}
		
		for (int i = 0; i < input.length(); i++) { // moves certain punctuation to the end
			if (input.charAt(i) == '!' || input.charAt(i) == '?' || input.charAt(i) == '.' || input.charAt(i) == ',') {
				char temp = input.charAt(i); 
				String tempStrFront = input.substring(0, i); 
				String tempStrBack = input.substring(i, input.length()); 
				tempStrBack = tempStrBack.substring(1, tempStrBack.length()); 
				input = tempStrFront + tempStrBack + temp; 
			}
		}
		return input; 
	}
	
public static String pigLatinFinalExtendedChallenge (String input) { // handles the extended challenge of multiple words
	String result = ""; 
	String[] inputArray = input.split(" ");  
	for (int i = 0; i < inputArray.length; i++) {
		inputArray[i] = pigLatinExtendedChallenge(inputArray[i]); 
	}
	for (int i = 0; i < inputArray.length; i++) {
		result += inputArray[i] + " "; 
	}
	return result; 
}


}
