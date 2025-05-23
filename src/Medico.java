public class Medico {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String especialidad;

    public Medico(String nombre, String especialidad) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Método para mostrar información completa del médico
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
    }
}
