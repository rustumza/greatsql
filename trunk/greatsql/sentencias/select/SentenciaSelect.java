package greatsql.sentencias.select;

import greatsql.sentencias.*;
import java.util.ArrayList; 


public class SentenciaSelect {


    private ArrayList<ColumnaSentencia> columnas;


    private TablaSentencia tabla;

    private Where where;


    public SentenciaSelect () {
    }


    public ArrayList<ColumnaSentencia> getColumnas () {
        return columnas;
    }


    public void setColumnas (ArrayList<ColumnaSentencia> val) {
        this.columnas = val;
    }


    public TablaSentencia getTabla () {
        return tabla;
    }


    public void setTabla (TablaSentencia val) {
        this.tabla = val;
    }

    /**
     * @return the where
     */
    public Where getWhere() {
        return where;
    }

    /**
     * @param where the where to set
     */
    public void setWhere(Where where) {
        this.where = where;
    }

}

