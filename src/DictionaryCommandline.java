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
        /*Word word = new Word("hadat", "depzaivcl");
       Word word1 = new Word("hung", "occho");
        d.dictionaryBasic(word);
        d.dictionaryBasic(word1);

         */
        DictionaryCommandline d = new DictionaryCommandline();
        d.dictionaryBasic();
    }
}
