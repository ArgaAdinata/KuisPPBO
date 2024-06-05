import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBookListener implements ActionListener {
    private Window window;

    public DeleteBookListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = window.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(window, "Please select a book to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String bookId = (String) window.getTableModel().getValueAt(selectedRow, 0);
        window.getTableModel().removeRow(selectedRow);
        BookFileManager.deleteBookFromFile(bookId);
        JOptionPane.showMessageDialog(window, "Book deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
