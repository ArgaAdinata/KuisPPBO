import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateBookListener implements ActionListener {
    private Window window;

    public UpdateBookListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = window.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(window, "Please select a book to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] updatedBookData = window.getBookFormData();
        for (String data : updatedBookData) {
            if (data.isEmpty()) {
                JOptionPane.showMessageDialog(window, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }


        for (int i = 0; i < updatedBookData.length; i++) {
            window.getTableModel().setValueAt(updatedBookData[i], selectedRow, i);
        }

        BookFileManager.updateBookInFile(updatedBookData);
        JOptionPane.showMessageDialog(window, "Book updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        window.clearForm();
    }
}
