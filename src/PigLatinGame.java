import java.util.Scanner; 
public class PigLatinGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char cont = 'y'; 
		String answer = ""; 
		while (cont == 'y') {
			System.out.println("Welcome to the Pig Latin Translator! Enter a word to be translator: "); 
			String userInput = scan.next(); 
			boolean textCheck = false; 
			
			while (textCheck == false) {
				textCheck = true; 
				for (int i = 0; i <  userInput.length(); i++)  {
					if (Character.isAlphabetic(userInput.charAt(i)) == false) {
						textCheck = false; 
					}
				}
				if (textCheck == false) {
					System.out.println("Sorry, this is not a text input, please enter again: ");
					userInput = scan.next();
				}
			}
			System.out.println(pigLatinBase(userInput)); 
			System.out.println(pigLatinExtendedChallenge(userInput)); 
			System.out.println("Would you like to translate another word? (Y/N)");
			answer = scan.next();
			while (!(Character.toLowerCase(answer.charAt(0)) == 'y' || Character.toLowerCase(answer.charAt(0)) == 'n')) {
				System.out.println("Error, invalid entry. Please try again: "); 
				answer = scan.next(); 
			}
			cont = Character.toLowerCase(answer.charAt(0)); 
			if (cont == 'n') {
				System.out.println("Thank you for playing!"); 
			}
			
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
		boolean letterCheck = true;  // next 9  lines deal with the extended challenge about not translating words that have numbers or symbols, though not really needed due to the extended challenge of making sure that the user has actually entered text. 
			for (int i = 0; i < input.length(); i++) {
				if (Character.isAlphabetic(input.charAt(i)) == false) {
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
		endString = input.substring(0, firstVowelIndex);  
		
		boolean upperCase = true; 
		for (int i = 0; i < input.length(); i++) { 
			if (Character.isLowerCase(input.charAt(i)) == true) {
				upperCase = false; 
			}
		}
	
		// each word is not being moved to lower case due to the extended challenge of keeping the case of the word. 
		if (upperCase == false) {
			

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
	
		return input; 
	}


}
