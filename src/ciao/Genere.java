package ciao;

public class Genere {
    private String genere;
    private String supporto;

    public Genere(String genere, String supporto){
        if(supporto.equals("CD")){
            for (Genere_CD g : Genere_CD.values()){
                if (genere.equalsIgnoreCase(g.name())){
                    this.genere = genere;
                    this.supporto = supporto;
                }
            }
        }
        if(supporto.equals("LIBRO")){
            for(Genere_Libri l : Genere_Libri.values()){
                if (genere.equalsIgnoreCase(l.name())){
                    this.genere = genere;
                    this.supporto = supporto;
                }
            }
        }
        throw new IllegalArgumentException("genere o supporto non esistente");
    }

    public String getGenere(){
        return this.genere;
    }

    public String getSupporto() {
        return supporto;
    }
}
