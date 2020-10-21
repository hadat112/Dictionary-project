import java.io.IOException;
import java.util.Map;

public class Root {
    private static Dictionary dictionary = new Dictionary();
    private static Map<String, Word> wordList;
    private static String current = "Invalid input";

    public void setCurrent(String current) {
        this.current = current;
    }
    public String getCurrent(){
        return current;
    }

    public static Map<String, Word> getWordList() {
        return wordList;
    }

    public void updateWordList(){
        wordList = dictionary.getWordList();
    }

    public void createWordList() throws IOException {
        dictionary.createWordList();
        updateWordList();
    }

    public String findDef(String word) {
        return dictionary.getDef(word);
    }

    public void printCurrent(){
        System.out.println(current);
    }

    public void removeWord(){
        dictionary.deleteWord(current);
        setCurrent("");
    }
}