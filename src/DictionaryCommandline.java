import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    private DictionaryManagement dictionaryManagement = new DictionaryManagement();
    private Scanner scanner = new Scanner(System.in);

    public void showAllWords() {
        int n = dictionaryManagement.getDictionarySize();
        ArrayList<Word> wordList = dictionaryManagement.getWordsList();
        System.out.println("No  |English     |Vietnamese");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "   |" + wordList.get(i).getWord_target() + "          |" + wordList.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        System.out.println("Cac lenh: \"show\" de xem danh sach cac tu, \"add\" de them tu");
        String command = scanner.next();
        String s = scanner.nextLine();
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

}
