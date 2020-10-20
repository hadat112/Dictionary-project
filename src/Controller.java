import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class Controller extends Dictionary {
    private Boolean isEV = true;
    //rivate static Dictionary dictionary = new Dictionary();
    //private Map<String, Word> wordList;
    private Map<String, Word> searchList = new TreeMap<>();
    private String current;
    @FXML
    private ListView<String> wordView;
    private ListView<String> searchView;
    @FXML
    private WebView defView;
    @FXML
    private TextField textField;
    @FXML
    private Button findingBtn;
    private Button speakingBtn;
    private Button fixBtn;
    private Button chaBtn;
    private Button addBtn;
    private Labeled label;

    public void initButton(Scene scene) {
        wordView = (ListView<String>) scene.lookup("#wordView");
        searchView = (ListView<String>) scene.lookup("#searchView");
        defView = (WebView) scene.lookup("#defView");
        textField = (TextField) scene.lookup("#textField");
        findingBtn = (Button) scene.lookup("#find");
        speakingBtn = (Button) scene.lookup("#speak");
        chaBtn = (Button) scene.lookup("#changeLanguage");
        addBtn = (Button) scene.lookup("#add");
    }

    //********************************************
    public void initialData() throws IOException {
        if(isEV)
            createWordList();
        else
            createWordListVE();
        loadWords();
    }
/*
    private void createWordList1() throws IOException {
        if(isEV)
            createWordList();
        else
            createWordListVE();
        wordList = dictionary.getWordList();
    }
*/
    private void loadWords() {
        this.wordView.getItems().addAll(super.getWordList().keySet());
    }

    //*******************************************************************
    public void loadDef() {
        wordView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    turnOffSearchView();
                    String selectedWordDef = super.getWordList().get(newValue).getDef();
                    current = newValue;
                    this.defView.getEngine().loadContent(selectedWordDef, "text/html");
                }
        );
    }

    public String getTextFieldValue(Scene scene) {
        return textField.getText();
    }

    public void getDefWhenFind(Scene scene) {
        findingBtn.setOnAction(e -> {
            current = getTextFieldValue(scene);
            String def = findDef(current);
            loadNewWords(def, scene);
        });
    }

    private String findDef(String word) {
        return getDef(word);
    }

    private void loadNewWords(String def, Scene scene) {
        defView.getEngine().loadContent(def, "text/html");
    }


    public void spellCurrentWord(Scene scene) {
        speakingBtn.setOnAction(e -> {
            current = getTextFieldValue(scene);
            if (!current.equals("")) {
                Speaker.speak(current);
            }
        });
    }

    private void addListenerToTextField(Scene scene) {
        textField.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.equals("")) {
                        searchWord(newValue);
                        loadSearchWords();
                        loadSearchViewList(scene);
                    } else {
                        searchList.clear();
                        loadWords();
                    }
                }
        );
    }

    private void setMouseEventToSearchView() {
        this.textField.setOnMouseClicked(e -> {
            searchView.setVisible(true);
        });
    }

    private void exchangeLanguage(Scene scene) {
        this.chaBtn.setOnMouseClicked(e -> {
            clearWords();
            this.isEV = !isEV;
            System.out.println("run" + isEV + " ");
            wordView.getItems().clear();
            try {
                initialData();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public void textFieldCatchEvent(Scene scene) {
        searchView.setVisible(false);
        addListenerToTextField(scene);
        setMouseEventToSearchView();
        exchangeLanguage(scene);
        add();
    }


    private void searchWord(String word) {
        searchList.clear();
        for (String key : super.getWordList().keySet()) {
            if (key.startsWith(word)) {
                searchList.put(key, super.getWordList().get(key));
            }
        }
    }

    private void loadSearchViewList(Scene scene) {
        searchView.setOnMouseClicked(e -> {
            current = searchView.getSelectionModel().getSelectedItem();
            String def = findDef(current);
            textField.setText(current);
            defView.getEngine().loadContent(def, "text/html");
            searchView.setVisible(false);
        });
    }

    private void loadSearchWords() {
        searchView.getItems().clear();
        searchView.getItems().addAll(searchList.keySet());
    }

    public void turnOffSearchView() {
        searchView.setVisible(false);
    }

    private Word showInputTextDialog() {

        Dialog<Word> dialog = new Dialog<>();

        dialog.setTitle("add an word");
        dialog.setHeaderText("Enter your Word:");
        dialog.setResizable(true);

        Label label = new Label("new word:");
        Label label1 = new Label("defination:");
        TextField textField = new TextField();
        TextField textField1 = new TextField();

        dialog.setHeight(600);
        dialog.setWidth(800);
        GridPane grid = new GridPane();
        grid.add(label, 1, 1);
        grid.add(label1, 1, 3);
        grid.add(textField, 1, 2);
        grid.add(textField1, 1, 4);

        dialog.getDialogPane().setContent(grid);
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        dialog.setResultConverter(new Callback<ButtonType, Word>() {
            @Override
            public Word call(ButtonType b) {

                if (b == buttonTypeOk) {

                    return new Word(textField.getText(), textField1.getText());
                }

                return null;
            }
        });

        Optional<Word> result = dialog.showAndWait();

        Word newWord = null;
        if(result.isPresent()){
            newWord = result.get();
        }
        return newWord;
    }


    public void add(){
        this.addBtn.setOnMouseClicked(e -> {
            super.addWord(showInputTextDialog());
            wordView.getItems().clear();
            try {
                initialData();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}