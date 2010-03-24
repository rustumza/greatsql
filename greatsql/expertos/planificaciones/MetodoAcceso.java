package greatsql.expertos.planificaciones;
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.50DE33E5-6988-2F87-049B-46C877E008A2]

import greatsql.expertos.indices.TipoIndice;
import greatsql.*;

// </editor-fold> 
public class MetodoAcceso {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C19C0990-7524-AF8E-C33E-C07E48F41C93]
    // </editor-fold> 
    private String nombreIndice;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6FF75A57-A903-FBCE-B95F-C9AB89F7AADF]
    // </editor-fold> 
    private TipoAcceso tipoAcceso;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D86E48C8-A669-7719-C697-7131AA254ED2]
    // </editor-fold> 
    private TipoIndice tipoIndice;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.44FCD01A-3F1F-6EBE-6DE0-EF77E70F5585]
    // </editor-fold> 
    public MetodoAcceso () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.14D4EACE-4878-67EF-7FB8-228936FC8EAB]
    // </editor-fold> 
    public String getNombreIndice () {
        return nombreIndice;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9635D759-6B1C-1935-B5D1-9FCF21832974]
    // </editor-fold> 
    public void setNombreIndice (String val) {
        this.nombreIndice = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FC9477BA-52D5-BE0A-688B-022A17CF6A42]
    // </editor-fold> 
    public TipoAcceso getTipoAcceso () {
        return tipoAcceso;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8E6AC780-2796-F89A-FAEC-C1405F902DC1]
    // </editor-fold> 
    public void setTipoAcceso (TipoAcceso val) {
        this.tipoAcceso = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9AFA0FB9-2EA7-CB27-A33C-4AECD34EF38E]
    // </editor-fold> 
    public TipoIndice getTipoIndice () {
        return tipoIndice;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.613405E2-A48F-CB2F-60AC-977990824013]
    // </editor-fold> 
    public void setTipoIndice (TipoIndice val) {
        this.tipoIndice = val;
    }

}

