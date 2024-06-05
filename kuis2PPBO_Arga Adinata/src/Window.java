import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;

public class Window extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField idField, titleField, authorField, genreField, publisherField, pubDateField;
    private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Window() {
        setTitle("Book Manager");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        tableModel = new DefaultTableModel(new String[]{"ID", "Title", "Author", "Genre", "Publisher", "Pub Date", "Added Date"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);


        JPanel formPanel = new JPanel(new GridLayout(7, 2));
        idField = new JTextField();
        titleField = new JTextField();
        authorField = new JTextField();
        genreField = new JTextField();
        publisherField = new JTextField();
        pubDateField = new JTextField();
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Author:"));
        formPanel.add(authorField);
        formPanel.add(new JLabel("Genre:"));
        formPanel.add(genreField);
        formPanel.add(new JLabel("Publisher:"));
        formPanel.add(publisherField);
        formPanel.add(new JLabel("Pub Date:"));
        formPanel.add(pubDateField);


        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new AddBookListener(this));
        JButton deleteButton = new JButton("Delete Book");
        deleteButton.addActionListener(new DeleteBookListener(this));
        JButton updateButton = new JButton("Update Book");
        updateButton.addActionListener(new UpdateBookListener(this));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);


        add(tableScrollPane, BorderLayout.CENTER);
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public String[] getBookFormData() {
        String id = idField.getText();
        String title = titleField.getText();
        String author = authorField.getText();
        String genre = genreField.getText();
        String publisher = publisherField.getText();
        String pubDate = pubDateField.getText();
        String addedDate = dateTimeFormat.format(new java.util.Date());
        return new String[]{id, title, author, genre, publisher, pubDate, addedDate};
    }

    public void setBookFormData(String[] data) {
        idField.setText(data[0]);
        titleField.setText(data[1]);
        authorField.setText(data[2]);
        genreField.setText(data[3]);
        publisherField.setText(data[4]);
        pubDateField.setText(data[5]);
    }

    public void clearForm() {
        idField.setText("");
        titleField.setText("");
        authorField.setText("");
        genreField.setText("");
        publisherField.setText("");
        pubDateField.setText("");
    }

    public void refreshTable() {
        tableModel.setRowCount(0);
        BookFileManager.loadBooksFromFile(tableModel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window manager = new Window();
            manager.setVisible(true);
            manager.refreshTable();
        });
    }
}
