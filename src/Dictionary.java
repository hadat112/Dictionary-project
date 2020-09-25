import java.util.ArrayList;

public class Dictionary {
    //Khởi tạo mảng động chứa các đối tượng word.
    private static ArrayList<Word> words = new ArrayList<>();

    //Check tu
    private boolean checkWord(Word word){
        for(Word aWord : words){
            if(aWord.getWord_target().equals(word.getWord_target())){
                return true;
            }
        }
        return false;
    }

    //Thêm từ vào mảng.
    public void addWord(Word word){
        if(checkWord(word)){
            System.out.println("Tu da ton tai!");
        }else
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

    /*public void setWords(ArrayList<Word> words) {
        this.words = words;
    }*/

    public ArrayList<Word> getWords() {
        return words;
    }
}
