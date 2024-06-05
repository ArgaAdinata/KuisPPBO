import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class BookFileManager {
    private static final String FILE_NAME = "books.txt";

    public static void loadBooksFromFile(DefaultTableModel tableModel) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                tableModel.addRow(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading books from file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void saveBookToFile(String[] bookData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(String.join(";", bookData));
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving book to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void deleteBookFromFile(String bookId) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("books_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (!data[0].equals(bookId)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error deleting book from file.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    public static void updateBookInFile(String[] updatedBookData) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("books_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data[0].equals(updatedBookData[0])) {
                    writer.write(String.join(";", updatedBookData));
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error updating book in file.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
}
