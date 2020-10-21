import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    private final String SPLITTING_CHAR = "<html>";
    private final String E_V_FILE_PATH = "./file/E_V.txt";
    private Map<String, Word> wordList = new TreeMap<>();
    private Word word;

    public void createWordList() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(E_V_FILE_PATH));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(SPLITTING_CHAR);
            String[] subpath = parts[1].split("</html>");
            parts[1] = "<html>" + parts[1];
            wordList.put(parts[0], new Word(parts[0], parts[1]));
        }
    }

    public Map<String, Word> getWordList() {
        return wordList;
    }

    public String getDef(String word) {
        if(wordList.containsKey(word)){
            return wordList.get(word).getDef();
        }
        return null;
    }

    public void changeWord(String word, String newDef) {
        wordList.put(word, new Word(word, newDef));
    }

    public void addWord(String word, String def) {
        wordList.put(word, new Word(word, def));
    }

    public void deleteWord(String word) {
        wordList.remove(word);
    }
}
