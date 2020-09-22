public class DictionaryCommandline {
    public void showAllWords(DictionaryManagement d){
        for(int i = 0; i < d.dictionary.words.size(); i++){
            System.out.println(d.dictionary.words.get(i).getWord_target()
                    + " " + d.dictionary.words.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic(Object insertFromCommandline){
         insertFromCommandline
    }
}
