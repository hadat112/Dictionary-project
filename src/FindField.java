import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.*;

public class FindField extends Root{
    @FXML
    private final TextField findTextField;
    @FXML
    private final Button findingBtn;
    @FXML
    private final ListView<String> searchView;

    private Map<String, Word> searchList = new TreeMap<>();
    private List<String> history = new ArrayList<>();
    private List<String> reverse = new ArrayList<>();

    private final String findTexFieldTag = "#textField";
    private final String findingBtnTag = "#find";
    private final String searchViewTag = "#searchView";

    public FindField(Scene scene){
        findTextField = (TextField) scene.lookup(findTexFieldTag);
        findingBtn = (Button) scene.lookup(findingBtnTag);
        searchView = (ListView<String>) scene.lookup(searchViewTag);
        hideSearchView();
    }

    public String getFindFieldValue(){
        return findTextField.getText();
    }

    public void loadDefToDefView(DefView defView, WordViewList wordViewList){
        findingBtn.setOnAction(e -> {
            hideSearchView();
            String word = getFindFieldValue();
            setCurrent(word);
            addWordToHistory(word);
            wordViewList.jumpTo(word);
            String def = findDef(getCurrent());
            defView.representDef(def);
        });
    }

    public void addListenerToTextField(DefView defView, WordViewList wordViewList) {
        findTextField.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.equals("")) {
                        searchWord(newValue);
                        loadSearchWords();
                        loadSearchViewList(defView, wordViewList);
                    } else {
                        searchList.clear();
                        loadHistory();
                    }
                }
        );
    }

    private void searchWord(String word) {
        searchList.clear();
        for (String key : getWordList().keySet()) {
            if (key.startsWith(word)) {
                searchList.put(key, getWordList().get(key));
            }
        }
    }

    private void loadSearchWords() {
        searchView.getItems().clear();
        searchView.getItems().addAll(searchList.keySet());
    }

    private void loadHistory(){
        reverse = history;
        Collections.reverse(reverse);
        searchView.getItems().clear();
        searchView.getItems().addAll(reverse);
    }

    private void loadSearchViewList(DefView defView, WordViewList wordViewList) {
        searchView.setOnMouseClicked(e -> {
            String temp = searchView.getSelectionModel().getSelectedItem();
            addWordToHistory(temp);
            wordViewList.jumpTo(temp);
            setCurrent(temp);
            String def = findDef(getCurrent());
            findTextField.setText(getCurrent());
            defView.representDef(def);
            searchView.setVisible(false);
        });
    }

    public void setMouseEventToSearchView() {
        this.findTextField.setOnMouseClicked(e -> {
            searchView.setVisible(true);
        });
    }

    public void showSearchView(){
        searchView.setVisible(true);
    }

    public void hideSearchView(){
        searchView.setVisible(false);
    }

    private void addWordToHistory(String word){
        if(history.contains(word)){
            history.remove(word);
        }
        history.add(word);
    }

}
