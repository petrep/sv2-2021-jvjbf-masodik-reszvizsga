package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
	private List<String> words = new ArrayList<>();

	public Words() {
	}

	public List<String> getWords() {
		return words;
	}

	public void addWord(String word) {
		for (char c: word.toCharArray()) {
			if (Character.isUpperCase(c)) throwException("Word should be lower case!");
			if (Character.isSpaceChar(c)) throwException("It should be one word!");
		}
		words.add(word);
	}

	private void throwException(String exception) {
		throw new IllegalArgumentException(exception);
	}

	public boolean isThereAWordTwice() {
		for (int i = 0; i < words.size(); i++) {
			if (countWordOccurrancy(words.get(i)) > 1 ) return true;
		}
		return false;
	}

	private int countWordOccurrancy(String wordToBeChecked) {
		int wordCount = 0;
		for (String word : words) {
			if (word.equals(wordToBeChecked)) wordCount++;
		}
		return wordCount;
	}
}
