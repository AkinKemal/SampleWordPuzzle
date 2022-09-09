public class Operations {
    //color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    ReadFile readFile = new ReadFile();
    String[][] matrix;

    public Operations() {
        create();
    }

    private void create() {
        int column = 0;
        int row = 0;
        readFile.readerFromFile("inputPuzzle.txt");//dosyadan verileri alıp list yapısına ekledim

        matrix = new String[readFile.getColumnSize() + 1][readFile.getRowSize() + 1];

        for (LinkedListOperations node : readFile.columnArraylist) {

            LinkedListNode walk = node.getHead();
            while (walk != null) {

                matrix[column][row] = walk.getCharacter();

                row++;
                walk = walk.getNext();
            }
            row = 0;
            column++;
        }
    }

    public String checkWords(String word) {

        int matrixBoard = readFile.getColumnSize();

        int controlLetter = 0;
        int wordSize = word.length();
        String result = "";

        //sütun kontrol etme (yukarıdan aşağıya)
        for (int i = 0; i < matrixBoard; i++) {
            for (int j = 0; j < matrixBoard; j++) {
                if (matrix[i][j].equals(String.valueOf(word.charAt(controlLetter)))) {
                    result += "(" + i + ", " + j + ", " + ANSI_BLUE + word.charAt(controlLetter) + ANSI_RESET + ") ";
                    controlLetter++;
                } else {
                    controlLetter = 0;
                    result = "";
                }
                if (controlLetter == wordSize) {
                    return result;
                }
            }
        }
        controlLetter = 0;
        result = "";

        //sütun kontrol etme (aşağıdan yukarıya)
        for (int i = matrixBoard - 1; i >= 0; i--) {
            for (int j = matrixBoard - 1; j >= 0; j--) {
                if (matrix[i][j].equals(String.valueOf(word.charAt(controlLetter)))) {
                    result += "(" + i + ", " + j + ", " + ANSI_BLUE + word.charAt(controlLetter) + ANSI_RESET + ") ";
                    controlLetter++;
                } else {
                    controlLetter = 0;
                    result = "";
                }
                if (controlLetter == wordSize) {
                    return result;
                }
            }
        }
        controlLetter = 0;
        result = "";

        //satır kontrol etme (sağdan sola)
        for (int j = 0; j < matrixBoard; j++) {
            for (int i = 0; i < matrixBoard; i++) {
                if (matrix[(i)][j].equals(String.valueOf(word.charAt(controlLetter)))) {
                    result += "(" + i + ", " + j + ", " + ANSI_BLUE + word.charAt(controlLetter) + ANSI_RESET + ") ";
                    controlLetter++;
                } else {
                    controlLetter = 0;
                    result = "";
                }
                if (controlLetter == wordSize) {
                    return result;
                }
            }
        }
        controlLetter = 0;
        result = "";

        //satır kontrol etme (sağdan sola)
        for (int j = matrixBoard - 1; j >= 0; j--) {
            for (int i = matrixBoard - 1; i >= 0; i--) {
                if (matrix[(i)][j].equals(String.valueOf(word.charAt(controlLetter)))) {
                    result += "(" + i + ", " + j + ", " + ANSI_BLUE + word.charAt(controlLetter) + ANSI_RESET + ") ";
                    controlLetter++;
                } else {
                    controlLetter = 0;
                    result = "";
                }
                if (controlLetter == wordSize) {
                    return result;
                }
            }
        }
        controlLetter = 0;
        result = "";

        //çapraz kontrol etme (yukarıdan aşağıya)
        for (int i = 0; i < matrixBoard; i++) {
            for (int j = 0; j < matrixBoard; j++) {
                int counter = 0;
                do {
                    if (matrix[i + counter][j + counter].equals(String.valueOf(word.charAt(controlLetter)))) {
                        result += "(" + (i + counter) + ", " + (j + counter) + ", " + ANSI_BLUE + word.charAt(controlLetter) + ANSI_RESET + ") ";
                        controlLetter++;
                    } else {
                        controlLetter = 0;
                        result = "";
                    }
                    if (controlLetter == wordSize) {
                        return result;
                    }
                    counter++;
                } while (counter < (matrixBoard - j - i));
                counter = 0;
            }
        }
        controlLetter = 0;
        result = "";

        //çapraz kontrol etme (aşağıdan yukarıya)
        int digitControl = 0;
        for (int i = 0; i < matrixBoard; i++) {
            for (int j = 0; j < matrixBoard; j++) {
                int counter = matrixBoard - 1;
                do {
                    if (matrix[counter - i][counter - j].equals(String.valueOf(word.charAt(controlLetter)))) {
                        result += "(" + (counter - i) + ", " + (counter - j) + ", " + ANSI_BLUE + word.charAt(controlLetter) + ANSI_RESET + ") ";
                        controlLetter++;
                    } else {
                        controlLetter = 0;
                        result = "";
                    }
                    if (controlLetter == wordSize) {
                        return result;
                    }
                    counter--;
                } while (counter >= digitControl);
                digitControl++;
            }
        }
        controlLetter = 0;
        result = "";
        return result;
    }

    public void printMatrix() {
        for (int i = 0; i < readFile.getColumnSize(); i++) {
            for (int j = 0; j < readFile.getRowSize(); j++) {
                System.out.print(ANSI_BLUE + matrix[i][j] + ANSI_RESET + "  ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------");
    }
}