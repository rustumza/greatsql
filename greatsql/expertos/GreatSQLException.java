package greatsql.expertos;
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B827E8DD-FE46-769E-CFCE-43271F91FFC5]
// </editor-fold> 
public class GreatSQLException extends Exception {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.553A8A3A-3E1B-EB0C-C6C8-3A24EA3E51DC]
    // </editor-fold> 
    private int codigoError;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.52A3F08B-9A25-634B-F973-9510B26E9AD7]
    // </editor-fold> 
    private String sentencia;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A1D381B8-C3DF-52B8-2393-0A86697C4131]
    // </editor-fold> 
    private int numeroLineaError;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E2D04B0A-9CD3-AF05-42D0-6E9CA236A19E]
    // </editor-fold> 
    private int numeroCaracterError;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C52B9EBE-2B07-E685-3929-D68D02A21386]
    // </editor-fold> 
    public GreatSQLException (String mensaje, int codigoError, String sentencia, int numeroLineaError, int numeroCaracterError) {
        super(mensaje);

        this.codigoError = codigoError;
        this.sentencia = sentencia;
        this.numeroLineaError = numeroLineaError;
        this.numeroCaracterError = numeroCaracterError;
    }

    public GreatSQLException (CodigosError codigoError, String sentencia, int numeroLineaError, int numeroCaracterError) {
        this(codigoError.getMensaje(), codigoError.getCodigo(), sentencia, numeroLineaError, numeroCaracterError);
    }

    public GreatSQLException (CodigosError codigoError) {
        this(codigoError, null, 0, 0);
    }

    public GreatSQLException (Exception exception) {
        super(CodigosError.ERROR_INESPERADO.getMensaje(), exception);

        this.codigoError = CodigosError.ERROR_INESPERADO.getCodigo();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.03E07007-C1C6-C8F2-EF02-17B515605CCE]
    // </editor-fold> 
    public int getCodigoError () {
        return codigoError;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3526398A-F60D-1FF3-95C0-517F8F4C65EE]
    // </editor-fold> 
    public void setCodigoError (int val) {
        this.codigoError = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D1B2CFAF-DB0B-48E1-F9D6-91F23D675110]
    // </editor-fold> 
    public int getNumeroCaracterError () {
        return numeroCaracterError;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A5B6B15F-9A12-5187-F5B5-86AED962402A]
    // </editor-fold> 
    public void setNumeroCaracterError (int val) {
        this.numeroCaracterError = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CEDBD851-ECB5-C3FC-555A-4FD10D92FFEF]
    // </editor-fold> 
    public int getNumeroLineaError () {
        return numeroLineaError;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8A791222-EF44-DF17-CE8B-78EA40D44464]
    // </editor-fold> 
    public void setNumeroLineaError (int val) {
        this.numeroLineaError = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.07D3D252-C64F-BAA2-1AED-3BFE5C3CC9CB]
    // </editor-fold> 
    public String getSentencia () {
        return sentencia;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7E248086-0757-F1E0-18F0-EA9743574BF7]
    // </editor-fold> 
    public void setSentencia (String val) {
        this.sentencia = val;
    }

    @Override
    public String toString() {
        return getMessage() + "\n" +
            "Error:     " + codigoError + "\n" +
            "Sentencia: " + sentencia + "\n" +
            "Línea:     " + numeroLineaError + "\n" +
            "Posición:  " + numeroCaracterError;
    }

}

