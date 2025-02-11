package ciao;

import java.util.LinkedList;
import java.util.List;

public interface Scaffale extends Iterable<Supporto>{
    List<Supporto> getLista();
    void add(Supporto item);
    List<Supporto> mensola(int index);
    List<Supporto> cerca(String keyword);
    void ordina();

    default void remove(Supporto item){
        var it = this.iterator();
        while (it.hasNext()){
            if(it.next().equals(item)){
                it.remove();
                this.ordina();
            }
        }
    }
}
