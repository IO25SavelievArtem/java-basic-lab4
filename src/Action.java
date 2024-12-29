/**
 * Class, which contains method to delete the biggest substrings in sentences, that start from letter 1, and end on letter 2.
 */

public class Action {
    public static void execute(Text text, char char1, char char2){
        Sentence[] sentences = text.getSentences();
        for (Sentence sentence : sentences) {
            deleteSubstring(sentence, char1, char2);
        }
    }

    public static void deleteSubstring(Sentence sentence, char char1, char char2){
        int[] startIndex = {-1,-1}; // {word index, letter index in word}
        int[] endIndex = {-1,-1}; // {word index, letter index in word}
        Word[] words = sentence.getWords();
        //finding position of starting char1
        for (int i = 0; i < words.length; i++) {
            int lIndex = words[i].findLetter(char1);
            if (lIndex != -1){
                startIndex[0] = i;
                startIndex[1] = lIndex;
                break;
            }
        }
        //finding position of ending char2
        for (int i = words.length-1; i > -1; i--) {
            int lIndex = words[i].findLastLetter(char2);
            if (lIndex != -1){
                endIndex[0] = i;
                endIndex[1] = lIndex;
                break;
            }
        }
        // Stop if one of letters is not found, or if start letter goes after end one
        if (startIndex[0] > endIndex[0] || startIndex[0] == -1) {
            return;
        }
        if (startIndex[0] == endIndex[0] && startIndex[1] > endIndex[1]) {
            return;
        }
        //Removing text
        int[] order = sentence.getOrder();
        int metWords = 0;
        for (int i = order.length-1; i > -1; i--) {
            if (order[i] == 0){
                metWords++;
            }
            //whole word deletion, as it was between words with char1, char2
            if (words.length - metWords > startIndex[0] && words.length - metWords < endIndex[0]) {
                sentence.removeByOrder(i);
            //delete beginning part of word with char2, or delete it whole if it ends with char2
            } else if (words.length - metWords == endIndex[0]) {
                Word word = sentence.getWord(endIndex[0]);
                if (endIndex[1] == word.getNumLetters()-1 || order[i] != 0) {
                    sentence.removeByOrder(i);
                } else {
                    word.removeLetters(0, endIndex[1]);
                }
            //delete ending part of word with char1, or delete it whole if it starts with char1
            } else if (words.length - metWords == startIndex[0]) {
                if (startIndex[1] == 0 || order[i] != 0) {
                    sentence.removeByOrder(i);
                } else {
                    Word word = sentence.getWord(startIndex[0]);
                    word.removeLetters(startIndex[1], word.getNumLetters()-1);
                }
            }
        }
    }
}
