package ciao;

public class Supporto_CD implements Supporto{
    Titolo titolo;
    Anno annoEdizione;
    Anno annoAcquisto;
    Nominativo Autore;
    Genere genere;

    public Supporto_CD(Titolo t, Anno aE, Anno aA, Nominativo n, Genere g ){
        if(aE.anno() > aA.anno() || !g.getSupporto().equals("CD"))
            throw new IllegalArgumentException();
        titolo = t;
        annoEdizione = aE;
        annoAcquisto = aA;
        Autore = n;
        genere = g;
    }

    @Override
    public Titolo getTitolo() {
        return titolo;
    }

    public Anno annoEdizione() {
        return annoEdizione;
    }

    public Anno annoAcquisto() {
        return annoAcquisto;
    }

    @Override
    public Nominativo getAutore() {
        return Autore;
    }

    @Override
    public Genere getGenere() {
        return genere;
    }
}
