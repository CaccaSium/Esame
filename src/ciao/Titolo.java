package ciao;

public record Titolo(String titolo){
    public Titolo(String titolo){
        if(!titolo.matches("[a-zA-Z ]+"))
            throw new IllegalArgumentException("immetti un nome valido");
        this.titolo = titolo;
    }
}
