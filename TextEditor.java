import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextEditor extends JFrame {

    JTextArea textArea;

    TextEditor() {

        // Frame
        setTitle("Simple Text Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text Area
        textArea = new JTextArea();

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(clearItem);
        fileMenu.add(exitItem);

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");

        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        // New
        newItem.addActionListener(e -> {
            textArea.setText("");
        });

        // Clear
        clearItem.addActionListener(e -> {
            textArea.setText("");
        });

        // Exit
        exitItem.addActionListener(e -> {
            System.exit(0);
        });

        // Cut
        cutItem.addActionListener(e -> {
            textArea.cut();
        });

        // Copy
        copyItem.addActionListener(e -> {
            textArea.copy();
        });

        // Paste
        pasteItem.addActionListener(e -> {
            textArea.paste();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}