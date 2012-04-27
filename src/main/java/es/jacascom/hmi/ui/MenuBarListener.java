package es.jacascom.hmi.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            }



        }
    }
}
