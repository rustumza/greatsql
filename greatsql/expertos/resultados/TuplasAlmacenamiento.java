package greatsql.expertos.resultados;
import greatsql.expertos.planificaciones.Planificacion;
import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.630F607A-B647-E481-769F-95E292235DBA]
// </editor-fold> 
public class TuplasAlmacenamiento {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5E7FEE97-C20A-A8ED-5C1A-0EE138D15473]
    // </editor-fold> 
    private int tiempoEjecucion;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C672DFF3-36DF-FA0E-CF78-002D3209DE1A]
    // </editor-fold> 
    private Planificacion planificacion;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9FDE795F-E727-A72F-5758-AAE58E459BDF]
    // </editor-fold> 
    private ArrayList<TuplaAlmacenamiento> tuplas;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A610AB1B-BB4F-53E7-95CE-4CDB804A2D99]
    // </editor-fold> 
    public TuplasAlmacenamiento () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5B48EF96-1EB6-D844-4ACC-990FAF8D6208]
    // </editor-fold> 
    public Planificacion getPlanificacion () {
        return planificacion;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2ECA9383-3628-5EEE-4729-68B5DFDE393D]
    // </editor-fold> 
    public void setPlanificacion (Planificacion val) {
        this.planificacion = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3667B548-DB87-84CA-C3D8-3DDB0F6178F4]
    // </editor-fold> 
    public int getTiempoEjecucion () {
        return tiempoEjecucion;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6B7F5319-A24C-BCBD-468D-6F63B76F4610]
    // </editor-fold> 
    public void setTiempoEjecucion (int val) {
        this.tiempoEjecucion = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D79A19EC-6401-05B2-7E27-8A7B2C40AD00]
    // </editor-fold> 
    public ArrayList<TuplaAlmacenamiento> getTuplas () {
        return tuplas;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3EE6682A-210C-F99A-695B-9B830E2D250C]
    // </editor-fold> 
    public void setTuplas (ArrayList<TuplaAlmacenamiento> val) {
        this.tuplas = val;
    }

}

