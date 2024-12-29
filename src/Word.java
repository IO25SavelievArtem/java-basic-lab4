/**
 * Word class, which of letters.
 */

public class Word {
    Letter[] letters;

    public Word(String text){
        char[] chars = text.toCharArray();
        this.letters = new Letter[chars.length];
        for(int i = 0; i < chars.length; i++){
            this.letters[i] = new Letter(chars[i]);
        }
    }

    // Returns number of letters in word
    public int getNumLetters(){
        return this.letters.length;
    }

    public void removeLetters(int startIndex, int endIndex) {
        //System.out.println(this);
        int newNumLetters = this.letters.length - endIndex + startIndex - 1;
        Letter[] temp = new Letter[newNumLetters];
        int newIndex = 0;
        for (int i = 0; i < this.letters.length; i++) {
            if (i < startIndex || i > endIndex) {
                temp[newIndex] = this.letters[i];
                newIndex++;
            }
        }
        this.letters = temp;
    }

    // Returns index of first found corresponding letter in word
    public int findLetter(char ch){
        int found = -1;
        for(int i=0; i<this.letters.length; i++) {
            if (this.letters[i].getChar() == ch) {
                found = i;
                break;
            }
        }
        return found;
    }

    // Returns index of last found corresponding letter in word
    public int findLastLetter(char ch) {
        int found = -1;
        for(int i=this.letters.length-1; i>-1; i--) {
            if (this.letters[i].getChar() == ch) {
                found = i;
                break;
            }
        }
        return found;
    }


    public String toString() {
        String word = "";
        for(int i = 0; i < this.letters.length; i++) {
            word += this.letters[i].toString();
        }
        return word;
    }
}
