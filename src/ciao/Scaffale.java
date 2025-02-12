package ciao;

import java.util.List;
import java.util.Optional;

public interface Scaffale extends Iterable<Supporto>{
    List<Optional<Supporto>> getLista();
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
