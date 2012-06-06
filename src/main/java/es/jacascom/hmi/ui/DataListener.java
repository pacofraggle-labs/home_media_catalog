package es.jacascom.hmi.ui;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * Created by IntelliJ IDEA.
 * User: elkstro
 * Date: 1/06/12
 * Time: 10:35
 * To change this template use File | Settings | File Templates.
 */
public class DataListener implements TableModelListener{
    private MainWindow window;

    public DataListener(MainWindow mainWindow) {
        this.window = mainWindow;
    }

    public void tableChanged(TableModelEvent tableModelEvent) {
        //System.out.println(tableModelEvent.getColumn());
        //System.out.println(tableModelEvent.getFirstRow()+" - "+tableModelEvent.getLastRow());

        window.updateData(tableModelEvent.getFirstRow(), tableModelEvent.getColumn());
    }
}
