import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    private final String SPLITTING_CHAR = "<html>";
    private final String E_V_FILE_PATH = "./file/E_V.txt";
    private final String E_V_FILE_PATH_VE = "./file/V_E.txt";
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

    public void createWordListVE() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(E_V_FILE_PATH_VE));
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
        return wordList.get(word).getDef();
    }

    public void changeWord(String word, String newDef) {
        wordList.put(word, new Word(word, newDef));
    }

    public void addWord(Word newWord) {
        wordList.put(newWord.getWord(), newWord);
    }

    public void deleteWord(String word) {
        wordList.remove(word);
    }
    public void clearWords(){
        wordList.clear();
    }
}
