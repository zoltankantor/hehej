import java.time.LocalDateTime;
import java.util.Random;

public class Homero extends Szenzor implements IHomero{


    private int alsoHatar;
    private int felsoHatar;
    private boolean aktiv;

    public Homero(int x,int y, int alsoHatar, int felsoHatar) {
        super(new Pozicio(x,y));
        hatarokatBeallit(alsoHatar,felsoHatar);
        aktiv = true;
    }

    @Override
    public boolean isAktiv() {
        return aktiv;
    }

    @Override
    public void hatarokatBeallit(int alsoHatar, int felsoHatar) {
        setAlsoHatar(alsoHatar);
        setFelsoHatar(felsoHatar);
    }

    @Override
    public Double homersekletetMer() {
        if (!aktiv){throw new SzenzorInaktivException();}
        Random rnd = new Random();
        return rnd.nextDouble(alsoHatar,felsoHatar);
    }

    @Override
    public void adatkuldes() {
        String visszaad;

        LocalDateTime ido = LocalDateTime.now();
        int ev = ido.getYear();
        String evS = Integer.toString(ev);

        int honap = ido.getMonthValue();
        String honapS;
        if (honap<10){honapS="0"+Integer.toString(honap);}
        else {honapS = Integer.toString(honap);}

        int nap = ido.getDayOfMonth();
        String napS;
        if (nap<10){napS="0"+Integer.toString(nap);}
        else {napS = Integer.toString(nap);}

        int ora = ido.getHour();
        String oraS;
        if (ora<10){oraS="0"+Integer.toString(ora);}
        else {oraS = Integer.toString(ora);}

        int perc = ido.getMinute();
        String percS;
        if (perc<10){percS="0"+Integer.toString(perc);}
        else {percS = Integer.toString(perc);}

        Pozicio p = getPozicio();
        visszaad = "Hőmérséklet a(z) " + "(" + Integer.toString(p.getX()) +";"
                + Integer.toString(p.getY()) +
                ") pozíción"
                + evS + "." + honapS + "." + napS + " " +
                oraS + ":" + percS + " időpontban: "
                + Double.toString(homersekletetMer()) + "°C";
        System.out.println(visszaad);
    }

    protected Object clone() throws CloneNotSupportedException {
        return new Homero(pozicio.getX(), pozicio.getY(), alsoHatar,felsoHatar);
    }

    @Override
    public String toString() {
        return String.format("Hőmérő: %s, A:%d - F:%d",
                super.toString(), alsoHatar, felsoHatar);
    }

    void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public int getFelsoHatar() {
        return felsoHatar;
    }

    void setFelsoHatar(int felsoHatar) {
        this.felsoHatar = felsoHatar;
    }

    public int getAlsoHatar() {
        return alsoHatar;
    }

    void setAlsoHatar(int alsoHatar) {
        if (alsoHatar >=-60){
            this.alsoHatar = alsoHatar;
        }else{
            throw new AlacsonyAlsoHatarException();
        }
    }
}
