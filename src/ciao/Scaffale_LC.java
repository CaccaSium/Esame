package ciao;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Scaffale_LC<T> extends Scaffale_astratto{

    public Scaffale_LC(My_list m, int ID){
        super(m.elementi(), ID);
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

    public LinkedList<Nodo> elementi(){
        var fin = new LinkedList<Nodo>();
        Nodo<T> n = testa;
        while (n != null) {
            fin.add(n);
            n = n.next;
        }
        return fin;
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

    public void aggiungiInCoda(String info){
        if(info == null)
            throw new IllegalArgumentException("sei un coglione");
        if(testa == null){
            testa = new Nodo<>(info, null);
        }
        else{
            Nodo<T> n = testa;
            while (n.next != null)
                n = n.next;
            n.next = new Nodo<>(info, null);
        }
        size++;
    }

    //il metodo ordina te lo fai solo perchè mi caco il cazzo

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
            if(n.info.contains(keyword))
                lista_fin.add(n);
            n = n.next;
        }
        return lista_fin;
    }


    private static class Nodo<T>{ //qua il nodo sarebbe il supporto
        private String info; //info è il titolo
        private Nodo<T> next;

        public Nodo(String info, Nodo<T> next) {
            this.info = info;
            this.next = next;
        }

    }
}