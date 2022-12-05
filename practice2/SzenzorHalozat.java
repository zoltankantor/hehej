import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SzenzorHalozat implements Iterable<Szenzor>{
    List<Szenzor> szenzorok;

    public SzenzorHalozat() {
        szenzorok =  new ArrayList<>();
    }

    public void telepit(Szenzor sz){
        szenzorok.add(sz);
    }
    public List<Szenzor> aktivSzenzorok() throws CloneNotSupportedException {
        List<Szenzor> asz = new ArrayList<>();
        for (Szenzor sz : szenzorok){
            if (sz.isAktiv()){
                asz.add((Szenzor) sz.clone());
            }
        }
        return asz;
    }

    @Override
    public Iterator<Szenzor> iterator() {
        try {
            List<Szenzor> asz = aktivSzenzorok();
            Collections.reverse(asz);
            return asz.iterator();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
