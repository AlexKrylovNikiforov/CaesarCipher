package Service;

import java.util.*;

public class LangChecker {
    private final Pattern pattern;

    public LangChecker(Pattern patterns) {
        this.pattern = patterns;
    }

    public String getLanguageByPattern(String text) {
        String languageName = "";
        List<Pattern> patternList = List.of(
                Pattern.EN,
                Pattern.FR,
                Pattern.ES,
                Pattern.DE,
                Pattern.IT,
                Pattern.UK,
                Pattern.RU);
        for(Pattern patter: patternList) {
            if(isPatternWordInText(text, pattern)) {
                languageName =  pattern.getLabel();
            }
        }
        return languageName;
    }

    private boolean isPatternWordInText (String text, Pattern pattern) {
        String [] frequentWord = pattern.getDescription();
        List<String> wordFrequency = new ArrayList<>();
        for(String word: frequentWord) {
            int wordCount = getFrequentWordCount(text, word);
                if(wordCount != 0) {
                    wordFrequency.add(word);
                }
        }
        return wordFrequency.size() > 0 ? true : false;
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
