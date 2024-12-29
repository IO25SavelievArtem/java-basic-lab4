/**
 * Punctuation mark class.
 */

public class Punctuation {
    char punctuationMark;
    public Punctuation(char punctuation){
        this.punctuationMark = punctuation;
    }

    public String toString(){
        return Character.toString(this.punctuationMark);
    }
}
