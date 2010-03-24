package greatsql.sentencias;

public class ColumnaObjetos {

    
    private String nombre;

    
    private TipoDato tipoDato;

    private boolean indice;

    
    public ColumnaObjetos () {
    }

     
    public String getNombre () {
        return nombre;
    }

   
    public void setNombre (String val) {
        this.nombre = val;
    }

   
    public TipoDato getTipoDato () {
        return tipoDato;
    }

   
    public void setTipoDato (TipoDato val) {
        this.tipoDato = val;
    }

    /**
     * @return the indice
     */
    public boolean getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(boolean indice) {
        this.indice = indice;
    }

}

