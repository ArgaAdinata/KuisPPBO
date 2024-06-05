import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookListener implements ActionListener {
    private Window window;

    public AddBookListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] bookData = window.getBookFormData();

        for (String data : bookData) {
            if (data.isEmpty()) {
                JOptionPane.showMessageDialog(window, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        window.getTableModel().addRow(bookData);
        BookFileManager.saveBookToFile(bookData);
        JOptionPane.showMessageDialog(window, "Book added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        window.clearForm();
    }
}
