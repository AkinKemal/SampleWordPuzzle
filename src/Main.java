public class Main {
    //color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        Operations operations = new Operations();

        operations.printMatrix();

        readFile.readerWordFromFile("inputWord.txt");

        for (String s : readFile.wordList) {

            String result = operations.checkWords(s);

            if (result != "") {
                System.out.println(ANSI_BLUE + s + ANSI_RESET + ": " + result);
            } else {
                System.out.println(ANSI_BLUE + s + ANSI_RESET + ":" + ANSI_RED + " Not Found" + ANSI_RESET);
            }
        }
    }
}
