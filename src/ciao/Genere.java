package ciao;

public class Genere {
    private String genere;
    private String supporto;

    public Genere(String genere, String supporto) {
        // Validate supporto
        if (!supporto.equals("CD") && !supporto.equals("LIBRO")) {
            throw new IllegalArgumentException("Supporto non valido: " + supporto);
        }

        // Validate genere based on supporto
        boolean isValidGenere = false;
        if (supporto.equals("CD")) {
            for (Genere_CD g : Genere_CD.values()) {
                if (genere.equalsIgnoreCase(g.name())) {
                    isValidGenere = true;
                    break;
                }
            }
        } else if (supporto.equals("LIBRO")) {
            for (Genere_Libri l : Genere_Libri.values()) {
                if (genere.equalsIgnoreCase(l.name())) {
                    isValidGenere = true;
                    break;
                }
            }
        }

        if (!isValidGenere) {
            throw new IllegalArgumentException("Genere non valido per il supporto: " + genere);
        }

        // Assign values if validation passes
        this.genere = genere;
        this.supporto = supporto;
    }

    public String getGenere() {
        return this.genere;
    }

    public String getSupporto() {
        return supporto;
    }
}
