public class DictionaryCommandline {
    DictionaryManagement d = new DictionaryManagement();
    public void showAllWords(){
        d.show();
    }

    public void dictionaryBasic(){
        d.insertFromCommandline();
        showAllWords();
    }

    public static void main(String[] args) {
        DictionaryCommandline d = new DictionaryCommandline();
        d.dictionaryBasic();
    }
}