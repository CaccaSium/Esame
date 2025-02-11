package ciao;

import java.util.Iterator;
import java.util.LinkedList;

public class Scaffale_LinkedList extends Scaffale_astratto{
    private final int ID;
    private LinkedList<Supporto> lista;
    private final int lunghezza_mensola;

    public Scaffale_LinkedList(LinkedList<Supporto> ohmygod,int ID){
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

    public LinkedList<Supporto> cerca(String keyword){
        var lista = new LinkedList<Supporto>();
        for(Supporto s: this){
            if(s.getTitolo().titolo().contains(keyword)){
                lista.add(s);
            }
        }
        return lista;
    }

    public Iterator<Supporto> iterator(){
        return  lista.iterator();
    }
}
