package eindopdrachtblok6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 * Methods om Virus object aan te maken en arraylists stoppen
 * @since 07/02/2018
 * @version 2
 * @author Luuk
 */
public class Logic {

    static private String Host;
    static private ArrayList<Virus> Lijst = new ArrayList<>();
    static private ArrayList<String> HostLijst = new ArrayList<>();
    static private ArrayList<String> VirusLijst = new ArrayList<>();
    static private ArrayList<String> CompareList = new ArrayList<>();

    /**
     * methode om het bestand in te lezen
     *
     * @return Arraylist met virus objecten
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<Virus> ReadFile() throws FileNotFoundException, IOException {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            //System.out.println(selectedFile.getAbsolutePath());
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String[] colom = line.split("\t", -1);
                    Virus temp = new Virus();
                    temp.setID(colom[0]);
                    temp.setName(colom[1]);
                    temp.setLineage(colom[2]);
                    temp.setRefseqID(colom[3]);
                    temp.setGenome(colom[4]);
                    temp.setKEGGDisease(colom[5]);
                    temp.setDisease(colom[6]);
                    temp.setHostTaxID(colom[7]);
                    temp.setHostName(colom[8]);
                    temp.setHostLineage(colom[9]);
                    temp.setPmid(colom[10]);
                    temp.setEvidence(colom[11]);
                    Lijst.add(temp);
                    //System.out.println(temp.getLineage());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "fout bij het bestand lezen");
            }
        }
        return Lijst;
    }

    /**
     * methode om uniek host namen uit virus objecten arraylist in een arraylist
     * te stoppen
     *
     * @return Arraylist met Host namen
     */
    public static ArrayList<String> Host() {

        for (int i = 1; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            if (HostLijst.contains(a.getHostName())) {
            } else {
                Host = (a.getHostName());
                //Host = (a.getHostTaxID()+"("+a.getHostName()+")");
                HostLijst.add(Host);
                Host = "";
            }
        }
        return HostLijst;
    }

    /**
     * methode om arraylist van virus ID's te maken van geselecteerde Host naam
     * als radiobutton ID's is geselecteerd is kan deze methode de lijst
     * sorteren als radiobutton classificatie is geselecteerd kan deze methode
     * de arraylist filtreren op de classificatie
     *
     * @param J
     * @param K
     * @param L
     * @param HostName
     * @param Class
     * @return Arraylist met virus ID's
     */
    public static ArrayList<String> Test(int J, int K, int L, String HostName, String Class) {

        try {

            VirusLijst.clear();

            for (int i = 0; i < Lijst.size(); i++) {
                Virus a = Lijst.get(i);

                if (J == 1) {

                    if (HostName.equals(a.getHostName())) {
                        if (a.getLineage().contains(Class)) {
                            VirusLijst.add(a.getID());
                        }
                    }
                } else {
                    if (HostName.equals(a.getHostName())) {
                        VirusLijst.add(a.getID());
                    }
                }
            }

            if (K == 1) {
                Collections.sort(VirusLijst);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Virus ID's verkrijgen");
        }
        return new ArrayList<String>(VirusLijst);
    }

    /**
     * methode om het twee Virus ID arraylists met elkaar te vergelijken of er
     * twee dezelfde virus ID's inzitten
     *
     * @return Arraylist met virus ID's
     */
    static ArrayList<String> Compare(ArrayList<String> VirusLijst1, ArrayList<String> VirusLijst2) {

        try {
            CompareList.clear();
            for (int i = 0; i < VirusLijst1.size(); i++) {
                for (int k = 0; k < VirusLijst2.size(); k++) {
                    if (VirusLijst1.get(i).equals(VirusLijst2.get(k))) {
                        CompareList.add(VirusLijst1.get(i));
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "fout bij de overeenkomsten bepalen");
        }
        return CompareList;
    }

}
