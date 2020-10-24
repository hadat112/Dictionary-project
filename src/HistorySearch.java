

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    public void saveHistory() {
        try {
            Formatter fileOut = new Formatter(HISTORY_FILE_PATH);
            for (int i = 0; i < wordSearchList.size(); i++){
                fileOut.format("%s \n", wordSearchList.get(i));
            }
            fileOut.close();
            System.out.println("Saved");
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    public void addToHistory(String word){
        if(wordSearchList.contains(word)){
            wordSearchList.remove(word);
        }else{
            num++;
            if(num >=30)
                wordSearchList.remove(0);
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
