package Service;

import java.lang.reflect.Array;
import java.util.*;

public class LangChecker {
    private final Pattern pattern;

    public LangChecker(Pattern patterns) {
        this.pattern = patterns;
    }

    public String getLanguageByPattern(String text) {
        String languageName = "";
        List<Pattern> patternList = Arrays.asList(
                Pattern.EN, // English
                Pattern.FR, // French
                Pattern.ES, // Spanish
                Pattern.DE, // German
                Pattern.IT, // Italian
                Pattern.UK, // Ukrainian
                Pattern.RU);
        for(Pattern patter: patternList) {
            if(getFrequencyWordCount(text, pattern) != null) {
                languageName =  pattern.getLabel();
            }
        }
        return languageName;
    }

    private Map<String, Integer> getFrequencyWordCount (String text, Pattern pattern) {
        String [] frequentWord = pattern.getDescription();
        Map<String, Integer> wordFrequency = new HashMap<>();
        for(String word: frequentWord) {
            int wordCount = getFrequentWordCount(text, word);
                if(wordCount != 0) {
                    wordFrequency.put(word, wordCount);
                }
        }
        return !wordFrequency.isEmpty() ? wordFrequency : null;
    }

    private int getFrequentWordCount(String text, String frequentWord) {
        int count = 0;
        int index = text.indexOf(frequentWord);
        while (index != -1) {
            count++;
            index = text.indexOf(frequentWord, index + 1);
        }
        return count;
    }
}
