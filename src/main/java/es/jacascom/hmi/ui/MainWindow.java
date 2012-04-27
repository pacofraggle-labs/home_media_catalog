package es.jacascom.hmi.ui;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: elkstro
 * Date: 26/04/12
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow {
    public JPanel panel;

    private JMenuItem exitMenuItem;
    private JMenuItem readFolderMenuItem;
    private JMenuItem loadCSVMenuItem;

    public void addMenuBar(JFrame frame) {

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);
        exitMenuItem = new JMenuItem("Exit");
        readFolderMenuItem = new JMenuItem("Read Folder");
        loadCSVMenuItem = new JMenuItem("Write CSV");
        file.add(readFolderMenuItem);
        file.add(loadCSVMenuItem);
        file.add(new JSeparator());
        file.add(exitMenuItem);

        MenuBarListener listener = new MenuBarListener(this, frame);

        exitMenuItem.addActionListener(listener);
        readFolderMenuItem.addActionListener(listener);
        loadCSVMenuItem.addActionListener(listener);

        frame.setJMenuBar(menuBar);

    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public JMenuItem getReadFolderMenuItem() {
        return readFolderMenuItem;
    }

    public JMenuItem getLoadCSVMenuItem() {
        return loadCSVMenuItem;
    }
}
