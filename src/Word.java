public class Word {
    private String word;
    private String def;
    private boolean isFavorite = false;

    public Word(String word, String def) {
        this.word = word;
        this.def = def;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public void setFavorite() {
        isFavorite = true;
    }

    public void unsetFavorite() {
        isFavorite = false;
    }
}
