package ciao;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class Scaffale_astratto implements Scaffale{
    private final int ID;
    private List<Optional<Supporto>> lista;
    private final int lunghezza_mensola;

    public Scaffale_astratto(List<Optional<Supporto>> l,int ID){
        if (l == null)
            throw new IllegalArgumentException();
        lunghezza_mensola = 10;
        this.ID = ID;
        lista = l;
        this.ordina();
    }

    public LinkedList<Optional<Supporto>> getLista(){
        LinkedList<Optional<Supporto>> n = new LinkedList<>();
        for (Optional<Supporto> s : lista)
            n.add(s);
        return n;
    }

    public void add(Supporto item){
        lista.add(Optional.ofNullable(item));
        if(lista.size() > 2)
            this.ordina();
    }

    public void ordina() {
        // Crea due liste separate per CD e LIBRI
        List<Optional<Supporto>> cdList = new LinkedList<>();
        List<Optional<Supporto>> libroList = new LinkedList<>();

        // Itera sulla lista originale e separa i supporti
        for (Optional<Supporto> sOpt : lista) {  // Usa 'sOpt' per gli Optional
            if (sOpt != null && sOpt.isPresent()) {
                Supporto s = sOpt.get();
                if (s.getGenere().getSupporto().equals("CD")) {
                    cdList.add(Optional.of(s));
                } else if (s.getGenere().getSupporto().equals("LIBRO")) {
                    libroList.add(Optional.of(s));
                }
            }
        }
        // Svuota la lista originale
        this.lista.clear();

        if(cdList.size() < lunghezza_mensola){
            int c = lunghezza_mensola - cdList.size();
            while (c != 0){
                cdList.add(Optional.empty());
                c--;
            }
        }

        if(libroList.size() < lunghezza_mensola){
            int c = lunghezza_mensola - libroList.size();
            while (c != 0){
                libroList.add(Optional.empty());
                c--;
            }
        }

        // Aggiungi prima i CD, poi i LIBRI
        this.lista.addAll(cdList);
        this.lista.addAll(libroList);
    }


    public List<Supporto> mensola(int index){
        int n_mensole = lista.size() / lunghezza_mensola;
        if (index >= n_mensole || index < 0)
            throw new IllegalArgumentException();

        List<Supporto> lista_finale = new LinkedList<>();
        int inizio = index * lunghezza_mensola;
        int fine = (index + 1) * lunghezza_mensola - 1;
        int i = 0;
        for(Optional<Supporto> s: lista){
            if(i >= inizio && i < fine)
                lista_finale.add(s.orElse(null));
            if (i > fine)
                break;
            i++;
        }
        return lista_finale;
    }

    public List<Supporto> cerca(String keyword){
        List<Supporto> lista = new LinkedList<>();
        for(Optional<Supporto> s: this.lista){
            Supporto m = s.orElse(null);
            if(m != null && m.getTitolo().titolo().contains(keyword)){
                lista.add(m);
            }
        }
        return lista;
    }
}
