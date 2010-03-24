package greatsql.expertos.planificaciones;

import greatsql.sentencias.select.SentenciaSelect;

public class Planificacion implements Comparable {


    private double puntaje;


    private SentenciaSelect sentenciaSelect;


    private MetodoAcceso metodoAcceso;


    public Planificacion () {
    }


    public MetodoAcceso getMetodoAcceso () {
        return metodoAcceso;
    }


    public void setMetodoAcceso (MetodoAcceso val) {
        this.metodoAcceso = val;
    }


    public double getPuntaje () {
        return puntaje;
    }


    public void setPuntaje (double val) {
        this.puntaje = val;
    }


    public SentenciaSelect getSentenciaSelect () {
        return sentenciaSelect;
    }


    public void setSentenciaSelect (SentenciaSelect val) {
        this.sentenciaSelect = val;
    }

    public int compareTo(Object o) {
        Planificacion p = (Planificacion) o;

        int resultado = Double.compare(puntaje, p.puntaje);

        if (resultado == 0) {
            if (metodoAcceso.getTipoAcceso() == TipoAcceso.INDICE && p.metodoAcceso.getTipoAcceso() == TipoAcceso.COMPLETO) {
                return -1;
            } else if (metodoAcceso.getTipoAcceso() == TipoAcceso.COMPLETO && p.metodoAcceso.getTipoAcceso() == TipoAcceso.INDICE) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return resultado;
        }
    }

}

