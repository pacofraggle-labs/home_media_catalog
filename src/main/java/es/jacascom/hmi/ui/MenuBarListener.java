package es.jacascom.hmi.ui;

import es.jacascom.hmi.data.MediaFile;
import es.jacascom.hmi.io.IMediaFinder;
import es.jacascom.hmi.io.MediaFinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: elkstro
 * Date: 27/04/12
 * Time: 13:24
 * To change this template use File | Settings | File Templates.
 */
public class MenuBarListener implements ActionListener {

    private MainWindow window;
    private Component frame;

    public MenuBarListener(MainWindow window, Component frame) {
        this.window = window;
        this.frame = frame;

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (source == window.getExitMenuItem()) {
            System.exit(0);
        } else if (source == window.getReadFolderMenuItem()){
            JFileChooser chooser = new JFileChooser()  ;

            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );

            int result = chooser.showDialog(frame,"Open");

            if (result == JFileChooser.APPROVE_OPTION ){
                System.out.print(chooser.getSelectedFile());
                IMediaFinder finder = new MediaFinder()  ;
                List<MediaFile> files = finder.findMedia(chooser.getSelectedFile().getAbsolutePath());
                for (int i=0; i<files.size(); i++){
                    MediaFile m = files.get(i);
                    window.addRow(i, m.toStringArray());
                    //System.out.println(files.get(i));
                }

            }
        }
    }



}
