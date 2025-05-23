import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private static int contadorId = 1;  // Contador de ID para asignar automáticamente

    private String nombre;
    private String apellido;
    private int id;
    private List<InformeMedico> informes;

    public Paciente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = contadorId++;
        this.informes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String obtenerInformacion() {
        return "ID: " + id + ", Nombre: " + nombre + " " + apellido;
    }

    public List<InformeMedico> getInformes() {
        return informes;
    }

    public void agregarInforme(InformeMedico informe) {
        informes.add(informe);
    }

    // Método para mostrar información completa del paciente
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);

        System.out.println("Informes Médicos:");
        for (InformeMedico informe : informes) {
            System.out.println("Fecha: " + informe.getFecha() + ", Descripción: " + informe.getDescripcion());
        }
    }
}
