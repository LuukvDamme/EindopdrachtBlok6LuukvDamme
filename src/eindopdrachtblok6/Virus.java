/*
 * Virus class met setters en getters
 * 
 * 
 */
package eindopdrachtblok6;

/**
 * @since 07/02/2018
 * @author Luuk
 */
public class Virus implements Comparable{
    private String ID;
    private String Name;
    private String Lineage;
    private String RefseqID;
    private String Genome;
    private String KEGGDisease;
    private String Disease;
    private String HostTaxID;
    private String HostName;
    private String HostLineage;
    private String Pmid;
    private String Evidence;

      public String getKEGGDisease() {
        return KEGGDisease;
    }

    
    public void setKEGGDisease(String KEGGDisease) {
        this.KEGGDisease = KEGGDisease;
    }
   

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLineage(String Lineage) {
        this.Lineage = Lineage;
    }

    public void setRefseqID(String RefseqID) {
        this.RefseqID = RefseqID;
    }

    public void setGenome(String Genome) {
        this.Genome = Genome;
    }

    public void setDisease(String Disease) {
        this.Disease = Disease;
    }

    public void setHostTaxID(String HostTaxID) {
        this.HostTaxID = HostTaxID;
    }

    public void setHostName(String HostName) {
        this.HostName = HostName;
    }

    public void setHostLineage(String HostLineage) {
        this.HostLineage = HostLineage;
    }

    public void setPmid(String Pmid) {
        this.Pmid = Pmid;
    }

    public void setEvidence(String Evidence) {
        this.Evidence = Evidence;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getLineage() {
        return Lineage;
    }

    public String getRefseqID() {
        return RefseqID;
    }

    public String getGenome() {
        return Genome;
    }

    public String getDisease() {
        return Disease;
    }

    public String getHostTaxID() {
        return HostTaxID;
    }

    public String getHostName() {
        return HostName;
    }

    public String getHostLineage() {
        return HostLineage;
    }

    public String getPmid() {
        return Pmid;
    }

    public String getEvidence() {
        return Evidence;
    }

    @Override
    public int compareTo(Object t) {
        if (t instanceof Virus){
            String IDname1 = this.ID;
            String IDname2 = ((Virus) t).getID();
            return IDname1.compareTo(IDname2);
        }
        return 0;
    }
}
