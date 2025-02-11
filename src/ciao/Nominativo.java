package ciao;

public record Nominativo(String autore) {
    public Nominativo(String autore){
        if(autore == null || !autore.matches("[a-zA-Z\\s,.!?]+"))
            throw new RuntimeException("Autore non valido");
        this.autore = autore;
    }
}
