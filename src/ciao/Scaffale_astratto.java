package ciao;

import java.util.LinkedList;
import java.util.List;

public abstract class Scaffale_astratto implements Scaffale{
    private final int ID;
    private List<Supporto> lista;
    private final int lunghezza_mensola;

    public Scaffale_astratto(List<Supporto> lista, int ID){
        if(lista == null)
            throw new IllegalArgumentException();
        lunghezza_mensola = 10;
        this.ID = ID;
        for(Supporto s : lista)
            this.lista.add(s);
        this.ordina();
    }

    public void add(Supporto item){
        lista.add(item);
        this.ordina();
    }

    public void ordina() {
        List<Supporto> l_m = new LinkedList<>();
        while (!this.lista.isEmpty()){
            var it = this.iterator();
            while(it.hasNext()){
                Supporto s = it.next();
                if(s.getGenere().getSupporto().equals("CD")){
                    List<Supporto> l_k = this.riempi_Lista("CD");
                    for(Supporto u : l_k)
                        l_m.add(u);

                }
                if(s.getGenere().getSupporto().equals("LIBRO")){
                    List<Supporto> l_k = this.riempi_Lista("LIBRO");
                    for(Supporto u : l_k)
                        l_m.add(u);
                }
            }
        }
        this.lista.addAll(l_m);
    }

    private List<Supporto> riempi_Lista(String supporto){
        List<Supporto> fin = new LinkedList<>();
        var it1 = this.iterator();
        int c = 0;
        while (it1.hasNext() && c < this.lunghezza_mensola){
            Supporto s = it1.next();
            if(s.getGenere().getSupporto().equals(supporto)){
                fin.add(s);
                it1.remove();
                c++;
            }
        }
        while (c < this.lunghezza_mensola){
            fin.add(null);
            c++;
        }
        return fin;
    }

    public List<Supporto> mensola(int index){
        int n_mensole = lista.size() / lunghezza_mensola;
        if (index >= n_mensole || index < 0)
            throw new IllegalArgumentException();
        List<Supporto> lista_finale = new LinkedList<>();
        int inizio = index * 10;
        int fine = (index * 10) -1;
        int i = 0;
        for(Supporto s: this){
            if(i>=inizio && index <= fine)
                lista_finale.add(s);
            if (i > fine)
                break;
            i++;
        }
        return lista_finale;
    }

    public List<Supporto> cerca(String keyword){
        List<Supporto> lista = new LinkedList<>();
        for(Supporto s: this){
            if(s.getTitolo().titolo().contains(keyword)){
                lista.add(s);
            }
        }
        return lista;
    }
}
