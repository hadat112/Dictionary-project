import java.util.ArrayList;

public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();

    //Add word from command line
    public void insertFromCommandline(Word word) {
        dictionary.addWord(word);
    }

    public int getDictionarySize() {
        return dictionary.getSize();
    }

    public ArrayList<Word> getWordsList() {
        return dictionary.getWordsList();
    }

    public void insertFromFile(){
        
    }
}
