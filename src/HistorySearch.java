

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistorySearch {
    private final String HISTORY_FILE_PATH = "./file/history.txt";
    private List<String> historyList = new ArrayList<>();
    private List<String> reverse = new ArrayList<>();

    public void loadHistory() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE_PATH));
        String line;
        while ((line = br.readLine()) != null) {
            historyList.add(line);
        }
    }

    public void addToHistory(String word){
        if(historyList.contains(word)){
            historyList.remove(word);
        }
        historyList.add(word);
    }

    public List<String> getHistory(){
        reverse = historyList;
        Collections.reverse(reverse);
        return reverse;
    }
}
