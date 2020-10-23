import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Root {
    private static Dictionary dictionary = new Dictionary();
    private static HistorySearch historySearch = new HistorySearch();
    private static boolean changed = false;

    private static String current = "";

    public void setCurrent(String current) {
        this.current = current;
    }
    public String getCurrent(){
        return current;
    }

    public static Map<String, Word> getWordList() {
        return dictionary.getWordList();
    }

    public void createWordList() throws IOException {
        dictionary.createWordList();
    }

    public String findDef(String word) {
        return dictionary.getDef(word);
    }

    public void loadHistorySearch() throws IOException {
        historySearch.loadHistory();
    }

    public void addToHistorySearch(String word){
        historySearch.addToHistory(word);
    }

    public List<String> getHistory(){
        return historySearch.getHistory();
    }

    public void setChanged(){
        changed = true;
    }

    public boolean getChanged(){
        return changed;
    }
}
