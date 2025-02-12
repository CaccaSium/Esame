package ciao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

public class Scaffale_LinkedList extends Scaffale_astratto{
    private final int ID;
    private LinkedList<Optional<Supporto>> lista;
    private final int lunghezza_mensola;

    public Scaffale_LinkedList(LinkedList<Optional<Supporto>> ohmygod,int ID){
        super(ohmygod,ID);
        this.ID = ID;
        lunghezza_mensola = 10;
        lista = ohmygod;
        this.ordina();
    }

    public LinkedList<Supporto> mensola(int index){
        int n_mensole = lista.size() / lunghezza_mensola;
        if (index >= n_mensole || index < 0)
            throw new IllegalArgumentException();

        var lista_finale = new LinkedList<Supporto>();
        int inizio = index * 10;
        int fine = (index + 1) * lunghezza_mensola -1;
        int i = 0;
        for(Optional<Supporto> s: lista){
            if(i >= inizio && i <= fine)
                lista_finale.add(s.orElse(null));
            if (i > fine)
                break;
            i++;
        }
        return lista_finale;
    }

    public LinkedList<Supporto> cerca(String keyword){
        var lista = new LinkedList<Supporto>();
        for(Optional<Supporto> s: this.lista){
            Supporto m = s.orElse(null);
            if(m != null && m.getTitolo().titolo().contains(keyword)){
                lista.add(m);
            }
        }
        return lista;
    }

    public Iterator<Supporto> iterator() {
        return new Iterator<Supporto>() {
            private final Iterator<Optional<Supporto>> it = lista.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Supporto next() {
                return it.next().orElse(null);
            }
        };
    }
}
