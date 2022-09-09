import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFile {

    ArrayList<LinkedListOperations> columnArraylist = new ArrayList<>();
    ArrayList<String> wordList = new ArrayList<>();
    private int columnSize = 0;
    private int rowSize = 0;
    private int row = 0;

    public ReadFile() {

    }

    public void readerFromFile(String fileName) {

        try {
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {

                LinkedListOperations listOperations = new LinkedListOperations();

                String[] arraySplit = line.split(" ");

                for (String s : arraySplit) {
                    listOperations.add(s);
                    row++;
                }

                if (row >= rowSize) {//en büyük satır
                    rowSize = row;
                }
                row = 0;

                columnArraylist.add(listOperations);
                columnSize++;//toplam sutün
            }

        } catch (Exception e) {
            System.out.println(fileName + " dosyası okunurken hata çıktı...");
        }
    }

    public void readerWordFromFile(String fileName) {

        try {
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {

                wordList.add(line);
            }

        } catch (Exception e) {
            System.out.println(fileName + " dosyası okunurken hata çıktı...");
        }
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public int getRowSize() {
        return rowSize;
    }

    public void setRowSize(int rowSize) {
        this.rowSize = rowSize;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}