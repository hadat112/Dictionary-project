

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistorySearch {
    private final String HISTORY_FILE_PATH = "./file/history.txt";
    private static List<String> wordSearchList = new ArrayList<>();
    private List<String> historySearch = new ArrayList<>();
    private short num = 0;

    public void loadHistory() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE_PATH));
        String line;
        while ((line = br.readLine()) != null) {
            wordSearchList.add(line);
            num++;
        }
        updateHistory();
    }

    public void addToHistory(String word){
        if(wordSearchList.contains(word)){
            wordSearchList.remove(word);
        }else{
            if(num >=20) wordSearchList.remove(0);
        }
        wordSearchList.add(word);
        updateHistory();
    }

    private void updateHistory(){
        historySearch.clear();
        historySearch.addAll(wordSearchList);
        Collections.reverse(historySearch);
    }

    public List<String> getHistory(){
        return historySearch;
    }

   /* public void saveChange(){
        try {
            Formatter fileOut = new Formatter(HISTORY_FILE_PATH);
            for (String word : wordSearchList) {
                fileOut.format("%s%s%s", entry.getKey()
                        , entry.getValue().getDef(), "\r\n");
            }
            fileOut.close();
            System.out.println("Saved");
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }*/
}
