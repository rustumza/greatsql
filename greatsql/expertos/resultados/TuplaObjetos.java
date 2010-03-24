package greatsql.expertos.resultados;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.1D0D38DD-1F96-48E7-1BD3-101984EF6745]
// </editor-fold> 
public class TuplaObjetos {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B287A1B5-EA8D-B306-443B-C6E54DBB4F79]
    // </editor-fold> 
    private int numero;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.79D8F8FD-D731-F22F-A871-33751EE7AC23]
    // </editor-fold> 
    private ArrayList<ValorTuplaObjetos> valores;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BD0DAF9F-3F6F-AE47-694C-0EEAF347ED9A]
    // </editor-fold> 
    public TuplaObjetos () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.78FFE04C-0D17-8DAD-459C-EAEA8F7CE359]
    // </editor-fold> 
    public int getNumero () {
        return numero;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CCC2285F-0457-BC3A-19D3-AA492BF815F9]
    // </editor-fold> 
    public void setNumero (int val) {
        this.numero = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.84C6D744-66C4-6F6F-7301-E15582221A9B]
    // </editor-fold> 
    public ArrayList<ValorTuplaObjetos> getValores () {
        return valores;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F08DB512-EAD7-BECB-8FB5-E9BDE1FBFE1F]
    // </editor-fold> 
    public void setValores (ArrayList<ValorTuplaObjetos> val) {
        this.valores = val;
    }

}

