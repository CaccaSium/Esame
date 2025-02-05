package ciao;

public interface Supporto extends Comparable<Supporto>{
    Titolo getTitolo();
    Anno annoEdizione();
    Anno annoAcquisto();
    Nominativo getAutore();
    Genere getGenere();

    @Override
    default int compareTo(Supporto s) {
        return Double.compare(this.annoEdizione().anno(), s.annoEdizione().anno());
    }
}
