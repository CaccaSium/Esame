/*
package ciao;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

public class Scaffale_LC extends Scaffale_astratto{
    private My_list<Supporto> m;
    private int grandezza_mensola;


    public Scaffale_LC(List<Supporto> s, int ID){
        super(new My_list<Supporto>(s), ID);
        grandezza_mensola = 10;
    }

    @Override
    public Iterator<Supporto> iterator() {
        return m.iterator();
    }
}
class My_list<T extends Comparable<? super T>> extends AbstractList<T> implements Iterable<T>{
    private int size;
    private Nodo<T> testa;


    public My_list(List<T> l){
        for(T elem : l)
            this.aggiungiInCoda(elem);
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

    public void aggiungiInCoda(T supporto){
        if(supporto == null)
            throw new IllegalArgumentException("sei un coglione");
        if(testa == null){
            testa = new Nodo<>(supporto, null);
        }
        else{
            Nodo<T> n = testa;
            while (n.next != null)
                n = n.next;
            n.next = new Nodo<>(supporto, null);
        }
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Nodo<T> curr = testa;

            @Override
            public boolean hasNext() {
                return curr.next!= null;
            }

            @Override
            public T next() {
                if(this.hasNext()){
                    var info = curr.supporto;
                    curr = curr.next;
                    return info;
                }
                throw new RuntimeException();
            }
        };
    }

    private static class Nodo<T extends Comparable<? super T>>{ //qua il nodo sarebbe il supporto
        private T supporto;
        private Nodo<T> next;

        public Nodo(T s, Nodo<T> next) {
            supporto = s;
            this.next = next;
        }

        public T getSupporto() {
            return supporto;
        }

        public void setSupporto(T supporto) {
            this.supporto = supporto;
        }

        public Nodo<T> getNext() {
            return next;
        }

        public void setNext(Nodo<T> next) {
            this.next = next;
        }
    }
}
*/