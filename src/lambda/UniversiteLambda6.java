package lambda;

public class UniversiteLambda6 {
    //ENCAPSULATION
    private String fakulte;
    private String bolum;
    private int notOrtalama;
    private int ogrenciNo;

    public UniversiteLambda6(String fakulte, String bolum, int norOrtalama, int ogrenciNo) {
        this.fakulte = fakulte;
        this.bolum = bolum;
        this.notOrtalama = norOrtalama;
        this.ogrenciNo = ogrenciNo;
    }

    public String getFakulte() {
        return fakulte;
    }

    public String getBolum() {
        return bolum;
    }

    public int getNotOrtalama() {
        return notOrtalama;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    @Override
    public String toString() {
        return "UniversiteLambda6 { " +
                "fakulte='" + fakulte + '\'' +
                ", bolum='" + bolum + '\'' +
                ", norOrtalama=" + notOrtalama +
                ", ogrenciNo=" + ogrenciNo +
                '}';
    }
}
