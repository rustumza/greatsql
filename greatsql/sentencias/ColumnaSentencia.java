package greatsql.sentencias;

import greatsql.*;


public class ColumnaSentencia {


    private String identificador;


    private String alias;


    private ColumnaObjetos columnaObjetos;

   


    public ColumnaSentencia () {
    }


    public String getAlias () {
        return alias;
    }


    public void setAlias (String val) {
        this.alias = val;
    }


    public String getIdentificador () {
        return identificador;
    }


    public void setIdentificador (String val) {
        this.identificador = val;
    }

    /**
     * @return the columnaObjetos
     */
    public ColumnaObjetos getColumnaObjetos() {
        return columnaObjetos;
    }

    /**
     * @param columnaObjetos the columnaObjetos to set
     */
    public void setColumnaObjetos(ColumnaObjetos columnaObjetos) {
        this.columnaObjetos = columnaObjetos;
    }

   
}

