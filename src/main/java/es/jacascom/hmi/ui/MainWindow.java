package es.jacascom.hmi.ui;

import es.jacascom.hmi.data.MediaFile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: elkstro
 * Date: 26/04/12
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow {
    private List<MediaFile> data;

    public JPanel panel;
    private JTable filesTable;

    private JMenuItem exitMenuItem;
    private JMenuItem readFolderMenuItem;
    private JMenuItem loadCSVMenuItem;

    public MainWindow(String[] tableColumnNames) {
      clearTableData(tableColumnNames);
    }

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
        //future file.add(saveNewCsv);
        file.add(new JSeparator());
        file.add(exitMenuItem);

        MenuBarListener listener = new MenuBarListener(this, frame);

        exitMenuItem.addActionListener(listener);
        readFolderMenuItem.addActionListener(listener);
        loadCSVMenuItem.addActionListener(listener);

        frame.setJMenuBar(menuBar);

    }

    private DefaultTableModel getTableModel() {
        return (DefaultTableModel) filesTable.getModel();
    }

    public void clearTableData(String[] tableColumnNames){
      filesTable.setModel(new DefaultTableModel(tableColumnNames, 0));
    }

    public void addRow(String[] data) {
      //System.out.println("addRow: " + Arrays.toString(data));
      getTableModel().addRow(data);
      //getTableModel().fireTableDataChanged();
    }

    public void addRow (int row, String[] data) {
        getTableModel().insertRow(row, data);
        //getTableModel().fireTableDataChanged();
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

    public void setData(List<MediaFile> files) {
        this.data = files;

        clearTableData(MediaFile.obtainFieldNames());
        // Insert new files
        for (int i=0; i<files.size(); i++){
            MediaFile m = files.get(i);
            addRow(m.toStringArray());
        }
        getTableModel().addTableModelListener(new DataListener(this));
    }


    public void updateData(int firstRow, int column) {

        String cellValue = getTableModel().getValueAt(firstRow, column).toString() ;

        /*if (column == 4){
        String cellValue = getTableModel().getValueAt(firstRow, column).toString() ;
            Long cellValueSize = Long.parseLong(cellValue);
        } else {
                String cellValue = getTableModel().getValueAt(firstRow, column).toString() ;
        }

        this = cellValue;   */



        System.out.println(cellValue );






    }


}
