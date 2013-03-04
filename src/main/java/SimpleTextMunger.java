import java.util.ArrayList;
import java.util.List;


public class SimpleTextMunger {
	public String process(String sentence){
		SentenceHelper sh = new SentenceHelper();
		List<String> words = sh.split(sentence);
		Munger m = new Munger();
		int i = 0;
		for(String word : words){
			words.set(i,m.mungeAWord(words.get(i)));
			i++;
		}
		return sh.join(words);
	}
	

}

class Munger{
	public String mungeAWord(String theWord){
		if(theWord.length()<4){
			return theWord;
		}else{
			StringBuilder strBldrWord = new StringBuilder(theWord);
			strBldrWord = strBldrWord.reverse();
			return switchFirstAndLastChar(strBldrWord).toString();
		}
	}
	
	public StringBuilder switchFirstAndLastChar(StringBuilder reversedWord){
		char firstChar = reversedWord.charAt(0);
		char lastChar = reversedWord.charAt(reversedWord.length() - 1);
		reversedWord.setCharAt(0, lastChar);
		reversedWord.setCharAt(reversedWord.length() - 1, firstChar);
		return reversedWord;
	}
}

class SentenceHelper{
	private static final String SEPARATOR = " ";
	
	public List<String> split(String sentence){
		List<String> words = new ArrayList<String>();
		for(String word : sentence.split(SEPARATOR)){
			words.add(word);
		}
		return words;
	}
	
	public String join(List<String> words){
		StringBuilder mungeSentence = new StringBuilder();
		for(String word : words){
			mungeSentence.append(word).append(SEPARATOR);
		}
		return mungeSentence.toString().trim();
	}
}
