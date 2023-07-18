package Service;

import java.util.*;

public class LanguageChecker {

    public String getLanguageByPattern(String text) {
        String languageName = "";
        for(Pattern pattern: Pattern.values()) {//проверить, привести к типу стринг
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
                if(wordCount > 2) {
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
