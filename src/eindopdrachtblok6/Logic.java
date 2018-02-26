/*
 * Methods om Virus classes aan te maken en arraylists
 * 
 * 
 */
package eindopdrachtblok6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 * @since 07/02/2018
 * @author Luuk
 */
public class Logic {

    static private String Host;
    static public ArrayList<Virus> Lijst = new ArrayList<>();
    static public ArrayList<String> HostLijst = new ArrayList<>();
    static public ArrayList<String> VirusLijst = new ArrayList<>();
    static public ArrayList<String> Virus2Lijst = new ArrayList<>();
    static public ArrayList<String> CompareList = new ArrayList<>();

//readfile method, returned arraylist met Virus objecten
    public static ArrayList<Virus> ReadFile() throws FileNotFoundException, IOException {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            //System.out.println(selectedFile.getAbsolutePath());
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()))) {
                String line;
                //creeer objecten, eerste in de arraylist is niet nuttig voor dit programma.
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
            }
        }
        return Lijst;
    }

    //HostLijst aanmaken
    public static ArrayList<String> Host() {
        for (int i = 1; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            //if (HostLijst.contains(a.getHostTaxID()+" ("+a.getHostName()+")")){
            if (HostLijst.contains(a.getHostName())) {
            } else {
                //Host=(a.getHostTaxID()+" ("+a.getHostName()+")");
                Host = (a.getHostName());
                HostLijst.add(Host);
                Host = "";
            }
        }
        return HostLijst;
    }

    //////////////////////////////////
    /*
    //VirusLijst
    public static ArrayList<String> Virus1(String HostName) {
        //System.out.println(HostName);
        VirusLijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(a.getHostName())) {
                VirusLijst.add(a.getID());
            }

        }

        //System.out.println(VirusLijst);
        return VirusLijst;
    }

    public static ArrayList<String> Virus1SSDNA(String HostName) {
        //System.out.println(HostName);
        VirusLijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(a.getHostName())) {
                if (a.getLineage().contains("ssDNA")) {
                    VirusLijst.add(a.getID());
                }

            }
        }
        //System.out.println(VirusLijst);
        return VirusLijst;
    }

    public static ArrayList<String> Virus1DSDNA(String HostName) {
        //System.out.println(HostName);
        VirusLijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(a.getHostName())) {
                if (a.getLineage().contains("dsDNA")) {
                    VirusLijst.add(a.getID());
                }

            }
        }
        //System.out.println(VirusLijst);
        return VirusLijst;
    }

    public static ArrayList<String> Virus1SSRNA(String HostName) {
        //System.out.println(HostName);
        VirusLijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(a.getHostName())) {
                if (a.getLineage().contains("ssRNA")) {
                    VirusLijst.add(a.getID());
                }

            }
        }
        //System.out.println(VirusLijst);
        return VirusLijst;
    }

    public static ArrayList<String> Virus1DSRNA(String HostName) {
        //System.out.println(HostName);
        VirusLijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(a.getHostName())) {
                if (a.getLineage().contains("dsRNA")) {
                    VirusLijst.add(a.getID());
                }

            }
        }
        //System.out.println(VirusLijst);
        return VirusLijst;
    }

    public static ArrayList<String> Virus1Retro(String HostName) {
        //System.out.println(HostName);
        VirusLijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(a.getHostName())) {
                if (a.getLineage().contains("Retro-transcribing viruses")) {
                    VirusLijst.add(a.getID());
                }

            }
        }
        //System.out.println(VirusLijst);
        return VirusLijst;
    }

    public static ArrayList<String> Virus1Satellite(String HostName) {
        //System.out.println(HostName);
        VirusLijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(a.getHostName())) {
                if (a.getLineage().contains("Satellites")) {
                    VirusLijst.add(a.getID());
                }

            }
        }
        //System.out.println(VirusLijst);
        return VirusLijst;
    }

    public static ArrayList<String> Virus1Viroids(String HostName) {
        //System.out.println(HostName);
        VirusLijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(a.getHostName())) {
                if (a.getLineage().contains("Viroids")) {
                    VirusLijst.add(a.getID());
                }

            }
        }
        //System.out.println(VirusLijst);
        return VirusLijst;
    }

    public static ArrayList<String> Virus1Unclassified(String HostName) {
        //System.out.println(HostName);
        VirusLijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus a = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(a.getHostName())) {
                if (a.getLineage().contains("unclassified")) {
                    VirusLijst.add(a.getID());
                }

            }
        }
        //System.out.println(VirusLijst);
        return VirusLijst;
    }

    ////////////////////////////////
    public static ArrayList<String> Virus2(String HostName) {
        //System.out.println(HostName);
        Virus2Lijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus b = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(b.getHostName())) {

                Virus2Lijst.add(b.getID());
            }

        }
        //System.out.println(VirusTempLijst);
        return Virus2Lijst;
    }

    public static ArrayList<String> Virus2SSDNA(String HostName) {
        //System.out.println(HostName);
        Virus2Lijst.clear();
        for (int i = 1; i < Lijst.size(); i++) {
            Virus b = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(b.getHostName())) {
                if (b.getLineage().contains("ssDNA")) {
                    Virus2Lijst.add(b.getID());
                }
            }
        }
        //System.out.println(VirusTempLijst);
        return Virus2Lijst;
    }

    public static ArrayList<String> Virus2DSDNA(String HostName) {
        //System.out.println(HostName);
        Virus2Lijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus b = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(b.getHostName())) {
                if (b.getLineage().contains("dsDNA")) {
                    Virus2Lijst.add(b.getID());
                }
            }
        }
        //System.out.println(VirusTempLijst);
        return Virus2Lijst;
    }

    public static ArrayList<String> Virus2SSRNA(String HostName) {
        //System.out.println(HostName);
        Virus2Lijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus b = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(b.getHostName())) {
                if (b.getLineage().contains("ssRNA")) {
                    Virus2Lijst.add(b.getID());
                }
            }
        }
        //System.out.println(VirusTempLijst);
        return Virus2Lijst;
    }

    public static ArrayList<String> Virus2DSRNA(String HostName) {
        //System.out.println(HostName);
        Virus2Lijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus b = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(b.getHostName())) {
                if (b.getLineage().contains("dsRNA")) {
                    Virus2Lijst.add(b.getID());
                }
            }
        }
        //System.out.println(VirusTempLijst);
        return Virus2Lijst;
    }

    public static ArrayList<String> Virus2Retro(String HostName) {
        //System.out.println(HostName);
        Virus2Lijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus b = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(b.getHostName())) {
                if (b.getLineage().contains("Retro-transcribing viruses")) {
                    Virus2Lijst.add(b.getID());
                }
            }
        }
        //System.out.println(VirusTempLijst);
        return Virus2Lijst;
    }

    public static ArrayList<String> Virus2Satellite(String HostName) {
        //System.out.println(HostName);
        Virus2Lijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus b = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(b.getHostName())) {
                if (b.getLineage().contains("Satellites")) {
                    Virus2Lijst.add(b.getID());
                }
            }
        }
        //System.out.println(VirusTempLijst);
        return Virus2Lijst;
    }

    public static ArrayList<String> Virus2Viroids(String HostName) {
        //System.out.println(HostName);
        Virus2Lijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus b = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(b.getHostName())) {
                if (b.getLineage().contains("Viroids")) {
                    Virus2Lijst.add(b.getID());
                }
            }
        }
        //System.out.println(VirusTempLijst);
        return Virus2Lijst;
    }

    public static ArrayList<String> Virus2Unclassified(String HostName) {
        //System.out.println(HostName);
        Virus2Lijst.clear();
        for (int i = 0; i < Lijst.size(); i++) {
            Virus b = Lijst.get(i);
            //System.out.println(a);
            if (HostName.equals(b.getHostName())) {
                if (b.getLineage().contains("unclassified")) {
                    Virus2Lijst.add(b.getID());
                }
            }
        }
        //System.out.println(VirusTempLijst);
        return Virus2Lijst;
    }
*/
    public static ArrayList<String> Test(int J, int K, int L, String HostName, String Class) {
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
            
        
        if (K==1){
            Collections.sort(VirusLijst);
        }
        
        return VirusLijst;
    }

   

    static ArrayList<String> Compare(ArrayList<String> VirusLijst1, ArrayList<String> VirusLijst2) {
        CompareList.clear();
        for (int i = 0; i < VirusLijst1.size(); i++) {
            for (int k = 0; k < VirusLijst2.size(); k++) {
                if (VirusLijst1.get(i).equals(VirusLijst2.get(k))) {
                    CompareList.add(VirusLijst1.get(i));
                }
            }
        }
        
        return CompareList;
    }
    
    
    
    
}
