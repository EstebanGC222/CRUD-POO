import java.time.LocalDateTime;

public class Cita {
    private LocalDateTime fechaHora;
    private Paciente paciente;
    private Medico medico;

    public Cita(LocalDateTime fechaHora, Paciente paciente, Medico medico) {
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    // Método para mostrar información completa de la cita
    public void mostrarInformacion() {
        System.out.println("Fecha y Hora: " + fechaHora);
        System.out.println("Paciente: " + paciente.getNombre() + " " + paciente.getApellido());
        System.out.println("Médico: " + medico.getNombre());
    }
}
