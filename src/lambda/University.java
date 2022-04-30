package lambda;

public class University {

    /*
        TASK :
        fields --> Universite (String)
                   bolum (String)
                   ogrcSayisi (int)
                   notOrt (int)
                   olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.
     */

    private String universite;
    private String bolum;
    private int ogrSayisi;
    private int notOrtalamasi;

    public University() {
    }

    public University(String universite, String bolum, int ogrSayisi, int notOrtalamasi) {
        this.universite = universite;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrtalamasi = notOrtalamasi;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public int getNotOrtalamasi() {
        return notOrtalamasi;
    }

    public void setNotOrtalamasi(int notOrtalamasi) {
        this.notOrtalamasi = notOrtalamasi;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "universite='" + universite + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrtalamasi=" + notOrtalamasi +
                "}\n";
    }
}
