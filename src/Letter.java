/**
 * Letter class.
 */

public class Letter {
    char letter;
    public Letter(char letter){
        this.letter = letter;
    }

    public char getChar(){
        return this.letter;
    }

    public String toString(){
        return Character.toString(this.letter);
    }
}
