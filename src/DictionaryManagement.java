import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();
    Word[] words = dictionary.getWords().toArray(new Word[0]);
    int numOfWords = 0;
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        numOfWords = sc.nextInt();
        sc.nextLine();
        //  Word[] words = new Word[numOfWords];

        for (int i = 0; i < numOfWords ; i++) {
            Word word = new Word();
            word.setWord_explain(sc.nextLine());
            word.setWord_target(sc.nextLine());
            words[i] = word;
        }
    }

    public void show() {
        for(int i = 0; i < numOfWords; i++) {
            System.out.println(words[i].getWord_target());
            System.out.println(words[i].getWord_explain());
        }
    }
}
