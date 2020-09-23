import java.util.ArrayList;

public class Dictionary {
    ArrayList<Word> words;

    {
        words = new ArrayList<Word>();
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public ArrayList<Word> getWords() {
        return words;
    }
}
