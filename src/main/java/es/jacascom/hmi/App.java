package es.jacascom.hmi;

import es.jacascom.hmi.ui.MainWindow;

import javax.swing.*;


/**
 * Hello world!
 *
 */
public class App
{
/*    public static void main( String[] args )
    {
        IMediaFinder finder = new MediaFinder();

        String[] ext = new String[1];

        ext[0] = "avi";

        List<MediaFile> files = finder.findMedia("H:/Bons/Pelicules","H:/Bons/Pelicules", ext);
//        for(int i=0; i<files.size(); i++) {
//            System.out.println(files.get(i));
//        }

        ICSVManager csv = new CSVManager()  ;

        try {
            csv.saveCSV(files, "H:/Bons/lista.csv");
            List<MediaFile> llista = csv.loadCSV("H:/Bons/lista.csv");
            for(int i=0; i<files.size(); i++) {
                System.out.println(llista.get(i));
            }


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }                       */


    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        MainWindow m = new MainWindow();
        m.addMenuBar(frame);

        frame.setContentPane(m.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400)  ;
        frame.pack();
        frame.setVisible(true);
    }










}

