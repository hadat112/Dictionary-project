public class DictionaryCommandline {
    DictionaryManagement d = new DictionaryManagement();
    public void showAllWords(){
        for(int i = 0; i < d.dictionary.words.size(); i++){
            System.out.println(d.dictionary.words.get(i).getWord_target()
                    + " " + d.dictionary.words.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic(Word word){
        d.insertFromCommandline(word);
        showAllWords();
    }

    public static void main(String[] args) {
        Word word = new Word("hadat", "depzaivcl");
        Word word1 = new Word("hung", "occho");
        DictionaryCommandline d = new DictionaryCommandline();
        d.dictionaryBasic(word);
        d.dictionaryBasic(word1);
    }
}
