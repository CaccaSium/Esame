package ciao;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Scaffale_LC<T> extends Scaffale_astratto{

    public Scaffale_LC(List<Supporto> s, int ID){
        super(new My_list<>(s), ID);
    }

    @Override
    public Iterator<Supporto> iterator() {
        return null;
    }
}
class My_list<T> extends AbstractList<T> implements Iterable<T>{
    private int size;
    private Nodo<T> testa;
    private int grandezza_mensola;

    public My_list(){
        size = 0;
        testa = null;
        grandezza_mensola = 10;
    }

    public My_list(List<Supporto> l){
        for(Supporto elem : l)
            this.aggiungiInCoda(elem.getTitolo(),elem.annoAcquisto(),elem.annoEdizione(),elem.getAutore(),elem.getGenere());
    }

    @Override
    public int size() {
        return size;
    }

    public Nodo<T> getTesta() {
        return testa;
    }

    @Override
    public T get(int index) {
        return null;
    }

    public void aggiungiInCoda(Titolo info,Anno anno_a, Anno anno_e, Nominativo autore, Genere genere){
        if(info == null)
            throw new IllegalArgumentException("sei un coglione");
        if(testa == null){
            testa = new Nodo<>(info,null,anno_a,anno_a,autore,genere);
        }
        else{
            Nodo<T> n = testa;
            while (n.next != null)
                n = n.next;
            n.next = new Nodo<>(info,null,anno_a,anno_a,autore,genere);
        }
        size++;
    }

    public List<Nodo<T>> mensola(int index){
        int inizio = index * grandezza_mensola;
        int fine = (index * grandezza_mensola)+grandezza_mensola-1;
        if(inizio >= size || fine >= size)
            throw new IllegalArgumentException("Sei di nuovo un coglione");
        List<Nodo<T>> lista_fin = new LinkedList<>();
        int i = 0;
        Nodo<T> n = testa;
        while (i < inizio){
            n = n.next;
            i++;
        }
        while (i < fine){
            lista_fin.add(n);
            n = n.next;
            i++;
        }
        return lista_fin;
    }

    public List<Nodo<T>> cerca(String keyword){
        List<Nodo<T>> lista_fin = new LinkedList<>();
        Nodo<T> n = testa;
        while (n.next != null){
            if(n.titolo.titolo().contains(keyword))
                lista_fin.add(n);
            n = n.next;
        }
        return lista_fin;
    }

    private static class Nodo<T>{ //qua il nodo sarebbe il supporto
        private Titolo titolo;
        private Anno anno_e;
        private Anno anno_a;
        private Nominativo autore;
        private Genere genere;
        private Nodo<T> next;

        public Nodo(Titolo titolo, Nodo<T> next, Anno anno_a, Anno anno_e, Nominativo autore, Genere genere) {
            this.titolo = titolo;
            this.anno_a = anno_a;
            this.anno_e = anno_e;
            this.autore = autore;
            this.genere = genere;
            this.next = next;
        }

    }
}