import java.util.ArrayList;

public class DictionaryManagement<dictionary> {
    Dictionary dictionary = new Dictionary();

    public void insertFromCommandline(Word word) {
        dictionary.words.add(word);
    }
}
