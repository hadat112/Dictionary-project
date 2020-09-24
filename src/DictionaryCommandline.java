import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    //Khởi tạo đối tượng dictionaryManagement
    private static final DictionaryManagement dictionaryManagement = new DictionaryManagement();
    //Khởi tạo scanner để đọc input
    private static final Scanner scanner = new Scanner(System.in);

    //Hiển thị tất cả các từ trong mảng
    public void showAllWords() {
        //Lấy kích cỡ mảng
        int n = dictionaryManagement.getDictionarySize();
        //Lấy mảng chứa các từ
        ArrayList<Word> wordList = dictionaryManagement.getWordsList();
        //In ra các từ
        System.out.println("No  |English     |Vietnamese");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "   |" + wordList.get(i).getWord_target() + "          |" + wordList.get(i).getWord_explain());
        }
    }

    //Phương thức dictionaryBasic
    public void dictionaryBasic() {
        dictionaryManagement.insertFromFile();
        System.out.println("Cac lenh: \"show\" de xem danh sach cac tu, \"add\" de them tu");
        String command = scanner.next();
        scanner.nextLine();
        while (!command.equals("exit")) {
            if (command.equals("show")) {
                showAllWords();
            } else if (command.equals("add")) {
                System.out.print("Nhap tu: ");
                String newWord = scanner.nextLine();
                System.out.print("Nhap nghia: ");
                String mean = scanner.nextLine();
                Word word = new Word(newWord,mean);
                dictionaryManagement.insertFromCommandline(word);
            }
            command = scanner.next();
        }
    }

    //Phương thức dictionaryAdvanced
    public void dictionaryAdvanced(){
        dictionaryManagement.insertFromFile();
        System.out.println("Vui lòng tắt Unikey trước khi nhập lệnh!");
        System.out.println("Các lệnh: \"show\" để xem danh sách các từ, \"lookup\" để tra từ, \"exit\" để thoát.");
        String command = scanner.next();
        scanner.nextLine();
        //Vòng lặp chạy lệnh command.
        while (!command.equals("exit")) {
            if (command.equals("show")) {
                showAllWords();
            }else if(command.equals("lookup")){
                System.out.print("Nhap tu: ");
                String word_target = scanner.next();
                scanner.nextLine();
                //Gọi phương thức tra từ
                dictionaryManagement.dictionaryLookup(word_target);
            }else{
                System.out.println("Lệnh không tồn tại! Xin hãy nhập lại!");
            }
            command = scanner.next();
        }
    }
}
