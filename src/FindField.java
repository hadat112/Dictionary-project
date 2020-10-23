import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Map;
import java.util.TreeMap;

public class FindField extends Root {
    @FXML
    private final TextField findTextField;
    @FXML
    private final Button findingBtn;
    @FXML
    private final ListView<String> searchView;

    private Map<String, Word> searchList = new TreeMap<>();

    private final String findTexFieldTag = "#textField";
    private final String findingBtnTag = "#find";
    private final String searchViewTag = "#searchView";

    public FindField(Scene scene) {
        findTextField = (TextField) scene.lookup(findTexFieldTag);
        findingBtn = (Button) scene.lookup(findingBtnTag);
        searchView = (ListView<String>) scene.lookup(searchViewTag);
        hideSearchView();
    }

    public String getFindFieldValue() {
        return findTextField.getText();
    }

    public void loadDefToDefView(DefView defView, WordViewList wordViewList) {
        findingBtn.setOnAction(e -> {
            hideSearchView();
            String word = getFindFieldValue();
            setCurrent(word);
            addToHistorySearch(word);
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

    private void loadHistory() {
        searchView.getItems().clear();
        searchView.getItems().addAll(getHistory());
    }

    private void loadSearchViewList(DefView defView, WordViewList wordViewList) {
        searchView.setOnMouseClicked(e -> {
            String temp = searchView.getSelectionModel().getSelectedItem();
            addToHistorySearch(temp);
            wordViewList.jumpTo(temp);
            setCurrent(temp);
            String def = findDef(getCurrent());
            findTextField.setText(getCurrent());
            defView.representDef(def);
            searchView.setVisible(false);
        });
    }

    public void setMouseEventToSearchView() {
        findTextField.setOnMouseClicked(e -> {
            searchView.setVisible(true);
            if(getFindFieldValue().equals("")){
                loadHistory();
            }
        });
    }

    public void showSearchView() {
        searchView.setVisible(true);
    }

    public void hideSearchView() {
        searchView.setVisible(false);
    }


}
