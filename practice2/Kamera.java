import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Kamera extends Szenzor implements IKamera {
    private Kepformatum formatum;

    public Kamera(int x, int y, Kepformatum formatum) {
        super(new Pozicio(x,y));
        this.formatum = formatum;
    }
    public String kepetKeszit(){
        String visszaad = "";
        try{
            if (!isAktiv()){throw new SzenzorInaktivException();}
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
            visszaad = evS + "-" + honapS + "-" + napS + "_" +
                    oraS + "-" + percS + "_x" + Integer.toString(p.getX()) +
                    "_y" + Integer.toString(p.getY()) + ".PNG";
        }catch (Exception e){
        }
        return visszaad;
    }

    public void adatkuldes() {
        System.out.println("Kép mentve: " + kepetKeszit());
    }

    protected Object clone() throws CloneNotSupportedException {
        return new Kamera(pozicio.getX(), pozicio.getY(), formatum);
    }
    @Override
    public String toString() {
        return String.format("Kamera: %s, Formátum: %s",
                super.toString(), formatum);
    }

    public boolean isAktiv(){
        LocalTime ido = LocalTime.now();
        int ora = ido.getHour();
        int perc = ido.getMinute();
        if (ora>=7 && ora<=21){
            if (ora == 21 && perc > 0 ){return false;}
            return true;
        }
        return false;
    }
    public Kepformatum getFormatum(){
        return this.formatum;
    }
}
