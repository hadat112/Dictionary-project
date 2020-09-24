import java.util.Scanner;

public class DictionaryProjectTestDrive {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String a1 = scanner.next();
        String s2= scanner.next();*/
        Word word = new Word("Hello", "Xin chao");
        Word word1 = new Word("House", "Ngoi nha");
        //Word word2 = new Word("Huy", "handsome");
        //Word word3 = new Word(a1, s2);
        DictionaryCommandline d = new DictionaryCommandline();
        //d.dictionaryBasic(word3);
        d.dictionaryBasic();
    }
}
