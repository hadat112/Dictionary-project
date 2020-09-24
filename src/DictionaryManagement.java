import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class DictionaryManagement {
    //Khai bao doi tuong dictionary.
    private static final Dictionary dictionary = new Dictionary();
    //Khai bao file de doc
    private static final File file = new File("./File/Dictionary.txt");


    //Thêm từ vào list từ từ command line
    public void insertFromCommandline(Word word) {
        dictionary.addWord(word);
    }

    //Lấy kích thước mảng chứa từ
    public int getDictionarySize() {
        return dictionary.getSize();
    }

    //Lấy mảng chứa các từ
    public ArrayList<Word> getWordsList() {
        return dictionary.getWordsList();
    }

    //Nhập từ từ file vào mảng chứa
    public void insertFromFile() {
        String string;
        //File
        try {
            //Khai báo fileIn để đọc dữ liệu từ file
            Scanner fileIn = new Scanner(file);
            while (fileIn.hasNextLine()) {
                //Đọc từng dòng của file
                string = fileIn.nextLine();
                //Tách dòng đó thành mảng 2 phần tử qua dấu tab
                String[] str = string.split("   ");
                insertFromCommandline(new Word(str[0], str[1]));
                //System.out.println(str[0]+" "+str[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void dictionaryExportToFile() {
        try {
            Formatter f = new Formatter("D:/java/Dictionary/File/Dictionary.txt");

            ArrayList<Word> words = dictionary.getWordsList();
            for(int i=0;i<dictionary.getSize();i++){
                f.format("%s   %s   %s", words.get(i).getWord_target()
                                    , words.get(i).getWord_explain(), "\r\n");
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    //Tìm nghĩa tiếng Việt của từ tiếng Anh
    public String dictionaryLookup(String word_target) {
        String word_explain = "";
        //Lấy mảng chứa các từ
        ArrayList<Word> words = dictionary.getWordsList();
        //Duyệt từng phần tử để tìm từ có từng tiếng Anh tương ứng
        for (Word word : words) {
            //Nếu tìm thấy gắn nó vào word_explain rồi thoát khỏi phương thức
            if (word.getWord_target().toLowerCase().equals(word_target) || word.getWord_target().equals(word_target)) {
                word_explain = word.getWord_explain();
                return word_explain;
            }
        }
        //Nếu không tìm thấy
        System.out.println("Không tìm thấy từ");
        return word_explain;
    }

}
