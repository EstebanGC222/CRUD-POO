import java.time.LocalDate;

public class InformeMedico {
    private String descripcion;
    private LocalDate fecha;

    public InformeMedico(String descripcion, LocalDate fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Método para mostrar información completa del informe médico
    public void mostrarInformacion() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Descripción: " + descripcion);
    }
}
