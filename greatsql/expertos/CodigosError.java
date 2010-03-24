/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.expertos;

/**
 *
 * @author aranzuglia
 */
public enum CodigosError {

    SENTENCIA_INEXISTENTE (1, "Sentencia inexistente"),
    SENTENCIA_NO_INDICADA (2, "Sentencia no indicada"),
    SENTENCIA_DESCONOCIDA (3, "Tipo de sentencia desconocida"),
    SINTAXIS_INVALIDA (4, "Sintaxis inválida"),
    ERROR_INESPERADO (1000, "Error inesperado");

    private int codigo;
    private String mensaje;

    private CodigosError(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

}
