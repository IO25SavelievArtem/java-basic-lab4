/**
 * Sentence class, which consists words and punctuation marks.
 */

import java.util.regex.Pattern;

public class Sentence {
    int[] order;    //order of words and punctuation marks. 0 - word, 1 - punctuation mark.
    Word[] words;
    Punctuation[] punctuations;

    public Sentence(String text) {
        int orderNum = 0;
        int wordNum = 0;
        int punctNum = 0;
        int startIndex = 0;
        int endIndex = 0;
        //Counting words and punctuation marks to initialize arrays
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) == ' ' || text.charAt(i) == '\t')) {
                if (startIndex < endIndex) {
                    orderNum++;
                    wordNum++;
                }
                startIndex = i + 1;
            } else if (Pattern.matches("\\p{IsPunctuation}", text.subSequence(i, i + 1))) {
                endIndex = i;
                if (startIndex < endIndex) {
                    orderNum++;
                    wordNum++;
                }
                orderNum++;
                punctNum++;
                startIndex = i + 1;
            } else {
                endIndex = i + 1;
            }
        }
        this.order = new int[orderNum];
        this.words = new Word[wordNum];
        this.punctuations = new Punctuation[punctNum];

        //Adding words and punctuation marks to arrays
        startIndex = 0;
        endIndex = 0;
        orderNum = 0;
        wordNum = 0;
        punctNum = 0;
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) == ' ' || text.charAt(i) == '\t')) {
                if (startIndex < endIndex) {
                    this.order[orderNum] = 0;
                    this.words[wordNum] = new Word(text.substring(startIndex, endIndex));
                    orderNum++;
                    wordNum++;
                }
                startIndex = i + 1;
            } else if (Pattern.matches("\\p{IsPunctuation}", text.subSequence(i, i + 1))) {
                endIndex = i;
                if (startIndex < endIndex) {
                    this.order[orderNum] = 0;
                    this.words[wordNum] = new Word(text.substring(startIndex, endIndex));
                    orderNum++;
                    wordNum++;
                }
                this.order[orderNum] = 1;
                this.punctuations[punctNum] = new Punctuation(text.charAt(i));
                orderNum++;
                punctNum++;
                startIndex = i + 1;
            } else {
                endIndex = i + 1;
            }
        }
    }

    public int[] getOrder() {
        return this.order;
    }

    public Word[] getWords() {
        return this.words;
    }

    public Punctuation[] getPunctuations() {
        return this.punctuations;
    }

    public Word getWord(int index) {
        return this.words[index];
    }

    public void removeByOrder(int orderNum) {
        int newOrder[] = new int[this.order.length-1];
        int newIndex = 0;
        int objectNum = -1;
        int metWords = -1;
        int metPuncts = -1;
        boolean isWord = false;
        for (int i = 0; i < this.order.length; i++) {
            if (i <= orderNum) {
                isWord = this.order[i] == 0;
                if (isWord) {
                    metWords++;
                } else {
                    metPuncts++;
                }
            }
            if (i == orderNum) {
                if (isWord) {
                    objectNum = metWords;
                } else {
                    objectNum = metPuncts;
                }
            } else {
                newOrder[newIndex] = this.order[i];
                newIndex++;
            }
        }
        // Stop if object not found
        if (objectNum == -1){
            return;
        }
        newIndex = 0;
        if (isWord) {
            Word[] newWords = new Word[this.words.length-1];
            for (int i = 0; i < this.words.length; i++) {
                if (objectNum != i) {
                    newWords[newIndex] = this.words[i];
                    newIndex++;
                }
            }
            this.words = newWords;
        } else {
            Punctuation[] newPunct = new Punctuation[this.punctuations.length-1];
            for (int i = 0; i < this.punctuations.length; i++) {
                if (objectNum != i) {
                    newPunct[newIndex] = this.punctuations[i];
                    newIndex++;
                }
            }
            this.punctuations = newPunct;
        }
        this.order = newOrder;
    }

    public String toString() {
        String sentence = "";
        int wordCount = 0;
        int punctCount = 0;
        // So there is no space at the start of sentence
        if (this.order[0] == 0) {
            sentence = sentence + this.words[wordCount].toString();
            wordCount++;
        } else {
            sentence = sentence + this.punctuations[punctCount].toString();
            punctCount++;
        }
        // Print other sentence;
        for (int i = 1; i < this.order.length; i++) {
            if (this.order[i] == 0) {
                sentence = sentence + " ";
                sentence = sentence + this.words[wordCount].toString();
                wordCount++;
            } else {
                sentence = sentence + this.punctuations[punctCount].toString();
                punctCount++;
            }
        }
        return sentence;
    }
}
