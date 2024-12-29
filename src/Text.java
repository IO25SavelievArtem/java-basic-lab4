/**
 * Text class, which consists of sentences array.
 */

public class Text {
    Sentence sentences[];

    public Text(String text) {
        int sentenceNum = 0;
        int nextDotIndex = text.indexOf(".", 0);
        while (nextDotIndex != -1){
            sentenceNum++;
            nextDotIndex = text.indexOf(".", ++nextDotIndex);
        }
        this.sentences = new Sentence[sentenceNum];

        int prevDotIndex = 0;
        nextDotIndex = text.indexOf(".", prevDotIndex);
        sentenceNum = 0;
        while (nextDotIndex != -1){
            this.sentences[sentenceNum] = new Sentence(text.substring(prevDotIndex, nextDotIndex+1));
            prevDotIndex = text.indexOf(".", prevDotIndex) + 1;
            nextDotIndex = text.indexOf(".", prevDotIndex);
            sentenceNum++;
        }
    }

    public Sentence[] getSentences() {
        return this.sentences;
    }

    @Override
    public String toString(){
        String text = this.sentences[0].toString();
        for(int i = 1; i < this.sentences.length-1; i++){
            text = text + " " + this.sentences[i].toString();
        }
        return text;
    }
}
