package ciao;

public record Anno(int anno){
    public Anno(int anno){
        if(anno < 0)
            throw new IllegalArgumentException("anno errato");
        this.anno = anno;
    }
}
