import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Animal {
	private String type;
	
	public Animal(String type) {
		this.type = type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void helloWorld() {
		System.out.println("I am an Animal");
	}
}

class Cat extends Animal {
	public Cat(String type) {
		super(type);
	}
	
	@Override
	public void helloWorld() {
		System.out.println("I am an Cat");
	}
}

public class Practice {
	public static int fibonacci(int n)  {
	    if(n == 0)
	        return 0;
	    else if(n == 1)
	      return 1;
	   else
	      return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static int findIndex(String longStr, String shortStr) {
		return longStr.toLowerCase().indexOf(shortStr.toLowerCase());
	}

	private static boolean isPalindrome(int number) {
		if(number == reverse(number)){
			return true;
		}
		return false;
	}


	private static int reverse(int number){
		int reverse = 0;

		while(number != 0){
			reverse = reverse*10 + number%10;
			number = number/10;
		}

		return reverse;
	}

	public static char findLeastRepeatChar(String str) {
		HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
		char leastRepeatedChar = 0;
		int leastTimesRepeated = 0;
		boolean firstTimeRunning = true;
		
		for (int i = 0; i < str.length(); i++) {
			Character ch = (Character) str.charAt(i);
			
			if (letters.containsKey(ch)) {
				int tempRepetitions = letters.get(ch) + 1;
				letters.put(ch, tempRepetitions);
			} else {
				letters.put(ch, 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
			Character ch = entry.getKey();
			Integer repetitions = entry.getValue();
			
			if (firstTimeRunning) {
				leastTimesRepeated = repetitions;
				leastRepeatedChar = ch;
				firstTimeRunning = false;
			} else if (leastTimesRepeated > repetitions) {
				leastTimesRepeated = repetitions;
				leastRepeatedChar = ch;
			}
		}
		
		return leastRepeatedChar;
	}

	public static void compressAlgorithm(String str) {
		String result = "";
		int charCounter = 1;
		
		System.out.println();
		
		if (str == null || str.length() == 0) {
			return;
		}
		
		if (str.length() == 1) {
			System.out.println(str + charCounter);
			return;
		}
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				charCounter++;
			} else {
				result += String.valueOf(str.charAt(i - 1)) + charCounter;
				charCounter = 1;
			}
			
			if (i == (str.length() - 1)) {
				result += String.valueOf(str.charAt(i)) + charCounter;
				System.out.println(result);
			}
		}
	}
	
	public static void printSeparateDuplicatesList(ArrayList<ArrayList<Integer>> separateList) {
		ArrayList<Integer> noDuplicates = separateList.get(0);
		ArrayList<Integer> duplicates = separateList.get(1);
		
		for (Integer value: noDuplicates) {
			System.out.print(value + ", ");
		}
		
		System.out.println();
		
		for (Integer value: duplicates) {
			System.out.print(value + ", ");
		}
	}
	
	public static ArrayList<ArrayList<Integer>> separateDuplicatesList(ArrayList<Integer> arrayList) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> noDuplicates = new ArrayList<Integer>();
		ArrayList<Integer> duplicates = new ArrayList<Integer>();
		
		for (Integer value : arrayList) {
			if (!noDuplicates.contains(value)) {
				noDuplicates.add(value);
			} else {
				if (!duplicates.contains(value)) {
					duplicates.add(value);
				}
			}
		}
		
		result.add(noDuplicates);
		result.add(duplicates);
				
		return result;
	}

	/*
		----------------------------------------------------------------------------------------------------------------
											Start: Cracking Coding Interview Book Exercises
		----------------------------------------------------------------------------------------------------------------
	 */

	public static boolean isPalindrome(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] lettersCounter = new int[128];

		// Nicer code
		for (char c : s.toCharArray()) {
			lettersCounter[c]++;
		}

		for (char c : t.toCharArray()) {
			// Or better, to easier to read, decrement index position, and then do if statement
			if(--lettersCounter[c] < 0) {
				return false;
			}
		}

//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			lettersCounter[c]++;
//		}
//
//		for (int i = 0; i < t.length(); i++) {
//			char c = t.charAt(i);
//			lettersCounter[c]--;
//			if (lettersCounter[c] < 0) {
//				return false;
//			}
//		}

		return true;
	}

	public static void replaceSpaces(char[] str, int trueLength) {
		System.out.println("Original: " + new String(str));

		int spaceCount = 0;
		int index = 0;

		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		index = trueLength + (spaceCount * 2);
		if (trueLength < str.length) str[index] = '\0';

		for (int i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index -= 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}

		System.out.println("Replaced: " + new String(str));
	}

	public static String compressString(String str) {
		StringBuilder compressed = new StringBuilder(str.length());
		int countConsecutive = 0;

		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i)).append(countConsecutive);
				countConsecutive = 0;
			}
		}

		return  compressed.length() < str.length() ? compressed.toString() : str;
	}

	public static boolean isRotation(String s1, String s2) {
		if (s1.length() == s2.length() && s1.length() > 0) {
			return isSubstring(s1 + s1, s2);
		}

		return false;
	}

	public static boolean isSubstring(String big, String small) {
		return big.contains(small);
		/*
			return big.indexOf(small) >= 0;

			OR

			if (big.indexOf(small) >= 0) {
				return true;
			} else {
				return false;
			}
		 */
	}

	public static int sumDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}

		return sum;
	}

	/*
		----------------------------------------------------------------------------------------------------------------
											End: Cracking Coding Interview Book Exercises
		----------------------------------------------------------------------------------------------------------------
	 */

	public static String revereStringAvoidHTML(String word) {
		if (word == null || word.isEmpty()) return null;

		StringBuilder result = new StringBuilder();

		for (int i = word.length() - 1; i >= 0; i--) {
			char c = word.charAt(i);
			if (i - 3 >= 0 && c == 'l') {
				if (word.charAt(i - 1) == 'm' &&
					word.charAt(i - 2) == 't' &&
					word.charAt(i - 3) == 'h') {
					i -= 3;
					continue;
				}
			}
			result.append(word.charAt(i));
		}

		return result.toString();
	}

	public static String reverseString(String word) {
		if (word == null || word.isEmpty()) return null;

		StringBuilder result = new StringBuilder();

		for (int i = word.length() - 1; i >= 0; i--) {
			result.append(word.charAt(i));
		}

		return result.toString();
	}

	public static String duplicateChars(String word) {
		if (word == null || word.isEmpty()) return null;

		Set<Character> chars = new HashSet<>();
		Set<Character> dupChars = new HashSet<>();
		for (char c : word.toCharArray()) {
			if (!chars.contains(c)) {
				chars.add(c);
			} else {
				dupChars.add(c);
			}
		}

		return dupChars.toString();
	}

	public static String[] reverseArray(String[] stringArray) {
		String[] result = new String[stringArray.length];

		for (int i = stringArray.length - 1; i >= 0; i--) {
			result[stringArray.length - 1 - i] = stringArray[i];
		}

		return result;
	}

	public static String serializeAndCompress(int[] sortedInts) {
		if (sortedInts == null || sortedInts.length == 0) return null;

		StringBuilder result = new StringBuilder();
		result.append(sortedInts[0]);
		int counter = 1;

		for (int i = 1; i < sortedInts.length; i++) {
			if (sortedInts[i] - sortedInts[i - 1] > 1) {
				if (counter > 1) {
					result.append("-").append(sortedInts[i - 1]);
				}
				result.append(",").append(sortedInts[i]);
				counter = 1;
			} else {
				counter++;
			}
		}

		return result.toString();
	}

	public static void printWordsUpToMax(String sentence, int maxLength) {
		String[] words = sentence.split(" +");
		for (String word : words) {
			if (word.length() <= maxLength) System.out.println(word);
		}
	}

	public static String sumOfTwoEqualsThirdInt(int[] intValues, int sum) {
		StringBuilder result = new StringBuilder();
		Map<Integer, Integer> values = new HashMap<>();
		for (int value : intValues) {
			values.put(value, value);
		}

		for (int value : intValues) {
			if (values.containsKey(sum - value)) {
				result.append(value).append(",").append(values.get(sum - value));
				return result.toString();
			}
		}
		return null;
	}

	public static void swap(int int1, int int2) {
		int temp = int2;

		int2 = int1;
		int1 = temp;
	}
	
	public static void main(String[] args) throws FileNotFoundException {

		// Start: Cracking Coding Interview Book Exercises

		System.out.println("Is palindrome? " + isPalindrome("hello", "hello"));
		System.out.println("Is palindrome? " + isPalindrome("helloo", "heallo"));
		System.out.println("Is palindrome? " + isPalindrome("helloo", "bye"));
		System.out.println("Is palindrome? " + isPalindrome("helloo", "heollo"));

		replaceSpaces(new char[]{'H','E','L','L','O',' ','W','O','R','L','D',' ',' ',' '}, 11);

		System.out.println("String compression for aaaaaaabbcdeeafeeeeeeee:  " + compressString("aaaaaaabbcdeeafeeeeeeee"));
		System.out.println("String compression for a:  " + compressString("a"));

		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};

		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			System.out.println("Is " + word1 + " Rotation of " + word2 + "?: " + isRotation(word1, word2));
		}

		System.out.println("Sum digits 456: " + sumDigits(456));

		// End: Cracking Coding Interview Book Exercises

		System.out.println("Reverse string 'HELLO': " + reverseString("HELLO"));

		System.out.println("Find duplicates in string 'HEEEELLLLLO': " + duplicateChars("HEEEELLLLLO"));

		String[] reverse = new String[]{"123", "456", "789"};
		String[] result = reverseArray(reverse);
		System.out.println("Reverse array of length: " + result.length);
		for (String word : result) {
			System.out.println("Word: "+ word);
		}

		System.out.println("Reverse string 'htmlhellohtmlhellohtmlhtml': " + revereStringAvoidHTML("htmlhellohtmlhellohtmlhtml"));

		System.out.println("Serialize and compressed: " + serializeAndCompress(new int[]{1, 4, 5, 6, 9, 10, 15}));

		printWordsUpToMax("Testing this  split     method superlongwordwillnotprint", 7);

		System.out.println("Sum of two ints equals sum: " + sumOfTwoEqualsThirdInt(new int[]{1, 2, 3, 4, 5}, 6));

//		LinkedListDemo<Integer> list = new LinkedListDemo<Integer>();
//
//		list.add(1);
//		list.add(2);
//		list.add(4);
//		list.add(5);
//		list.printLinkedList();
//		list.add(3, 2);
//		list.printLinkedList();
//
//		list.detectCycleList(list.getHead());
//
//		/*
//		 * Send batches of email addresses from one inbox to another one in another server
//		 * Each batch cannot have duplicate email addresses
//		 * This algorithm is O(N2) since there are two nested loops (note: another nested loop would make this O(N3), etc
//		 */
//		List<String> array = new ArrayList<String>();
//		HashSet<String> hashSet = new HashSet<String>();
//
//		array.add("alex.foglia@hp.com");
//		array.add("andres.foglia@hp.com");
//		array.add("alex.foglia@hp.com");
//		array.add("luis.foglia@hp.com");
//		array.add("olga.ghiglione@hp.com");
//		array.add("alex.foglia@hp.com");
//		array.add("andres.foglia@hp.com");
//		array.add("andres.foglia@hp.com");
//
//		Iterator<String> itArray = array.iterator();
//		int sendInBatches = 1;
//
//		while (itArray.hasNext()) {
//			String str = itArray.next();
//
//			hashSet.add(str);
//
//			if (sendInBatches == 3) {
//				sendInBatches = 1;
//				System.out.println();
//				System.out.println("====BATCH====");
//				// Send email batches to other server - in this case, we just print them on console
//				Iterator<String> it = hashSet.iterator();
//
//				while (it.hasNext()) {
//					String email = (String) it.next();
//					System.out.println(email);
//				}
//				System.out.println("====+++++====");
//				hashSet.clear();
//			} else {
//				sendInBatches++;
//			}
//		}
//
//		if (sendInBatches == 3) {
//			System.out.println();
//			System.out.println("====BATCH====");
//			Iterator<String> it = hashSet.iterator();
//
//			while (it.hasNext()) {
//				String email = (String) it.next();
//				System.out.println(email);
//			}
//			System.out.println("====+++++====");
//		}
//
//		BinaryTree intTreeOne = new BinaryTree(null, null, 7);
//		BinaryTree rootOne = intTreeOne;
//
//		intTreeOne.addNode(rootOne, 3);
//		intTreeOne.addNode(rootOne, 2);
//		intTreeOne.addNode(rootOne, 4);
//		intTreeOne.addNode(rootOne, 10);
//		intTreeOne.addNode(rootOne, 11);
//		intTreeOne.addNode(rootOne, 8);
//
//		intTreeOne.printNode(rootOne);
//		intTreeOne.printNode(rootOne.getLeft());
//		intTreeOne.printNode(rootOne.getRight());
//		intTreeOne.printNode(rootOne.getLeft().getLeft());
//		intTreeOne.printNode(rootOne.getRight().getRight());
//		intTreeOne.printNode(rootOne.getLeft().getRight());
//		intTreeOne.printNode(rootOne.getRight().getLeft());
//
//		BinaryTree intTreeTwo = new BinaryTree(null, null, 100);
//		BinaryTree rootTwo = intTreeTwo;
//
//		intTreeTwo.addNode(rootTwo, 90);
//		intTreeTwo.addNode(rootTwo, 80);
//		intTreeTwo.addNode(rootTwo, 70);
//		intTreeTwo.addNode(rootTwo, 85);
//		intTreeTwo.addNode(rootTwo, 95);
//		intTreeTwo.addNode(rootTwo, 93);
//		intTreeTwo.addNode(rootTwo, 97);
//		intTreeTwo.addNode(rootTwo, 120);
//		intTreeTwo.addNode(rootTwo, 110);
//		intTreeTwo.addNode(rootTwo, 105);
//		intTreeTwo.addNode(rootTwo, 115);
//		intTreeTwo.addNode(rootTwo, 130);
//		intTreeTwo.addNode(rootTwo, 125);
//		intTreeTwo.addNode(rootTwo, 135);
//
//		intTreeTwo.printNode(rootTwo);
//		intTreeTwo.printNode(rootTwo.getLeft());
//		intTreeTwo.printNode(rootTwo.getRight());
//		intTreeTwo.printNode(rootTwo.getLeft().getLeft());
//		intTreeTwo.printNode(rootTwo.getRight().getRight());
//		intTreeTwo.printNode(rootTwo.getLeft().getRight());
//		intTreeTwo.printNode(rootTwo.getRight().getLeft());
//
//		System.out.println("Trees are equal? " + BinaryTree.treeEquals(intTreeOne, intTreeTwo));
//
//		BinaryTree.printTreeDepthFirst(intTreeOne);
//
//		BinaryTree.printTreeBreadthFirst(intTreeOne);
//
//		BinaryTree.printTreeBreadthFirst(rootTwo);
//
//		BinaryTree.printTreeDepthFirst(rootTwo);
//
//		BinaryTree.printTreeBreadthFirstSnakeMode(rootTwo);
//
//		System.out.println(fibonacci(4));
//
//		System.out.println(findIndex("abcabcabc", "abcabcabcabcabcabc"));
//
//		System.out.println(findLeastRepeatChar("aabbbbf"));
//
//		compressAlgorithm("aaabbbcccaabcc");
//
//		isPalindrome(11011);
//
//		ArrayList<Integer> list = new ArrayList<Integer>();
//
//		list.add(1);
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(3);
//		list.add(3);
//		list.add(2);
//		list.add(1);
//		list.add(3);
//
//		printSeparateDuplicatesList(separateDuplicatesList(list));
//
//		BufferedReader br = new BufferedReader(new FileReader("/File.txt"));
//	    try {
//	        StringBuilder sb = new StringBuilder();
//	        String line = br.readLine();
//
//	        while (line != null) {
//	            sb.append(line);
//	            sb.append(System.lineSeparator());
//	            line = br.readLine();
//	        }
//	        String everything = sb.toString();
//	        System.out.print("text: " + everything);
//	        br.close();
//	    }
//	    catch(Exception e) {
//	    	System.out.print("fail");
//	    }
//
//		Animal obj = new Animal("Cat");
//
//		Cat obj2 = new Cat("Cat");
//
//		obj = obj2;
//
//		obj.helloWorld();
//
//		obj2.helloWorld();

		BinaryTree intTreeOne = new BinaryTree(null, null, 7);
		BinaryTree rootOne = intTreeOne;

		intTreeOne.addNode(rootOne, 3);
		intTreeOne.addNode(rootOne, 2);
		intTreeOne.addNode(rootOne, 4);
		intTreeOne.addNode(rootOne, 10);
		intTreeOne.addNode(rootOne, 11);
		intTreeOne.addNode(rootOne, 8);

		intTreeOne.printInOrder(rootOne);

		BinaryTree.printTreeDepthFirst(intTreeOne);

		BinaryTree.printTreeBreadthFirst(intTreeOne);

		int int1 = 3;
		int int2 = 5;
		swap(int1, int2);
		System.out.println("int1: " + int1);
		System.out.println("int2: " + int2);
	}
}
