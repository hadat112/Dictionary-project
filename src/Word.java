public class Word {
    private String word_target;
    private String word_explain;

    //Khoi tao
    Word(String word_target, String word_explain){
        setWord_explain(word_explain);
        setWord_target(word_target);
    }

    //Set tu tieng anh
    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
    //Set nghia
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }
    //Get tu tieng anh
    public String getWord_explain() {
        return word_explain;
    }
    //Get nghia
    public String getWord_target() {
        return word_target;
    }

}
