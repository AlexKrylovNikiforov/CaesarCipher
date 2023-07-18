package Service;

import java.util.*;

public class LanguageChecker {

    public String getLanguageByPattern(String text) {
        String languageName = "";
        List<Pattern> patternList = List.of(
                Pattern.EN,
                Pattern.FR,
                Pattern.ES,
                Pattern.DE,
                Pattern.RU);
        for(Pattern pattern: patternList) {
            if(isPatternWordInText(text, pattern)) {
                languageName =  pattern.getLabel();
            }
        }
        return languageName;
    }

    private boolean isPatternWordInText (String text, Pattern pattern) {
        String [] frequentWord = pattern.getDescription();
        int count = 0;
        for(String word: frequentWord) {
            int wordCount = getFrequentWordCount(text, word);
                if(wordCount > 0) {
                    count++;
                }
        }
        return count > 1;
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