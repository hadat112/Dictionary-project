import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> words = new ArrayList<>();
    public void addWord(Word word){
        words.add(word);
    }
    public void deleteWord(Word word){
        words.remove(word);
    }
    public int getSize(){
        return words.size();
    }
    public ArrayList<Word> getWordsList(){
        return words;
    }
}
