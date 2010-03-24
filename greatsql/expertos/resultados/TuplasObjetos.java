package greatsql.expertos.resultados;
import greatsql.expertos.planificaciones.Planificacion;
import greatsql.sentencias.ColumnaObjetos;
import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B40A900E-CC33-FCB0-0C51-CB116B6B7A05]
// </editor-fold> 
public class TuplasObjetos {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1C7FA82C-0B09-F781-D039-0F8DE8810250]
    // </editor-fold> 
    private int tiempoEjecucion;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0B50A71D-FF7B-A770-562F-AB4321ABCE71]
    // </editor-fold> 
    private Planificacion planificacion;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.73E95D0C-7C50-B7EA-D901-F9CB1C7FFCC2]
    // </editor-fold> 
    private ArrayList<ColumnaObjetos> columnas;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DE9B90FF-1FAB-F3A5-6C28-35BC2318629B]
    // </editor-fold> 
    private ArrayList<TuplaObjetos> tuplas;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5AA35E49-DE5F-DD4A-4AA6-F29673A13722]
    // </editor-fold> 
    public TuplasObjetos () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.508E65D2-4C0D-5320-9D42-9066F29A124D]
    // </editor-fold> 
    public ArrayList<ColumnaObjetos> getColumnas () {
        return columnas;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0DBB8F12-1BBF-F47E-E4DB-934EA74ACBB4]
    // </editor-fold> 
    public void setColumnas (ArrayList<ColumnaObjetos> val) {
        this.columnas = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1C99C9A9-4C23-06B3-EE44-4E2A8BCBB320]
    // </editor-fold> 
    public Planificacion getPlanificacion () {
        return planificacion;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.11973C0A-22B3-B5C7-D7AF-062E5950F5D6]
    // </editor-fold> 
    public void setPlanificacion (Planificacion val) {
        this.planificacion = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DCB0A888-9769-F27B-176A-5AB225C20CDC]
    // </editor-fold> 
    public int getTiempoEjecucion () {
        return tiempoEjecucion;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7EC19EAF-AB90-E038-DD4F-22C51F3B5746]
    // </editor-fold> 
    public void setTiempoEjecucion (int val) {
        this.tiempoEjecucion = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1EB58360-8808-814C-0B05-E6C8EDEF31A7]
    // </editor-fold> 
    public ArrayList<TuplaObjetos> getTuplas () {
        return tuplas;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.744B6BB1-2868-9270-3091-7182D944E55C]
    // </editor-fold> 
    public void setTuplas (ArrayList<TuplaObjetos> val) {
        this.tuplas = val;
    }

}

