package ciao;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Genere g = new Genere("Avventura", "LIBRO");
        Genere g1 = new Genere("Horror", "LIBRO");
        Genere g2 = new Genere("Trap", "CD");

        // Creazione di oggetti Supporto (ipotizzo classi concrete Supporto_CD e Supporto_LIBRO)
        Supporto libro1 = new Supporto_LIBRO(new Titolo("Il Signore degli Anelli"), new Anno(1954), new Anno(2001), new Nominativo("J.R.R. Tolkien"), g);
        Supporto libro2 = new Supporto_LIBRO(new Titolo("Cacca"), new Anno(1949), new Anno(2010), new Nominativo("George Orwell"), g1);
        Supporto cd1 = new Supporto_CD(new Titolo("The Dark Side of the Moon"), new Anno(1973), new Anno(2015), new Nominativo("Pink Floyd"), g2);

        // Richiamo metodi su Supporto
        System.out.println("Dettagli libro 1: " + libro1.getTitolo().titolo() + ", Autore: " + libro1.getAutore().autore());
        System.out.println("Anno edizione: " + libro1.annoEdizione().anno());

        System.out.println("Dettagli CD 1: " + cd1.getTitolo().titolo() + ", Artista: " + cd1.getAutore().autore());

        // Creazione di un oggetto Scaffale concreto (ipotizzo l'implementazione Scaffale_LC)
        var lista = new LinkedList<Supporto>();
        lista.add(libro1);
        lista.add(libro2);
        lista.add(cd1);
        Scaffale scaffale = new Scaffale_LinkedList(lista,12);

        // Richiamo dei metodi di Scaffale
        System.out.println("Contenuto dello scaffale iniziale:");
        for (Supporto item : scaffale.getLista()) {
            System.out.println("- " + item.getTitolo().titolo());
        }
    }
}


