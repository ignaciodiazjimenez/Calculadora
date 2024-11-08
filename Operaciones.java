public class Operaciones
{
    private int idOperacion;
    private String operacion;

    public Operaciones(int idOperacion, String operacion){
        this.idOperacion = idOperacion;
        this.operacion = operacion;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public String toString() {
        return "Operaciones{" +
                "idOperacion=" + idOperacion +
                ", operacion='" + operacion + '\'' +
                '}';
    }
}
