import java.util.ArrayList;

public class Dictionary {
    //Khởi tạo mảng động chứa các đối tượng word.
    private static ArrayList<Word> words = new ArrayList<>();

    //Thêm từ vào mảng.
    public void addWord(Word word){
        words.add(word);
    }

    //Xóa từ
    public void deleteWord(Word word){
        getWordsList().remove(word);
    }

    //Lấy kích thước mảng, số lượng từ
    public int getSize(){
        return words.size();
    }

    //Lấy danh sách từ.
    public ArrayList<Word> getWordsList(){
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public ArrayList<Word> getWords() {
        return words;
    }
}
