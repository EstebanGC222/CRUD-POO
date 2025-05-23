import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Doctor {
    private static int contadorId = 1;  // Contador de ID para asignar automáticamente
    private int id;
    private List<Paciente> pacientes;
    private List<Cita> citas;

    public Doctor(List<Paciente> pacientes, List<Cita> citas) {
        this.id = contadorId++;
        this.pacientes = pacientes;
        this.citas = citas;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Doctor:");
            System.out.println("1. Ver agenda");
            System.out.println("2. Agregar informes sobre pacientes");
            System.out.println("3. Acceso a informes médicos de pacientes");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    verAgenda();
                    break;
                case 2:
                    agregarInformes();
                    break;
                case 3:
                    accederInformesMedicos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void verAgenda() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Agenda del Doctor:");

        for (Cita cita : citas) {
            System.out.println("Fecha y Hora: " + cita.getFechaHora());
            System.out.println("Paciente: " + cita.getPaciente().getNombre() + " " + cita.getPaciente().getApellido());
            System.out.println("----");
        }

        System.out.println("Fin de la agenda");

        // Opción para modificar cita
        System.out.println("¿Desea modificar alguna cita? (Sí/No)");
        String respuestaModificar = scanner.next();

        if (respuestaModificar.equalsIgnoreCase("Sí")) {
            System.out.println("Ingrese la fecha y hora de la cita que desea modificar (yyyy-MM-dd HH:mm):");
            String fechaHoraStr = scanner.next() + " " + scanner.next();
            modificarCita(LocalDateTime.parse(fechaHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        }
    }

    private void modificarCita(LocalDateTime fechaHora) {
        Cita citaModificar = buscarCitaPorFechaHora(fechaHora);

        if (citaModificar != null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nueva fecha y hora de la cita (yyyy-MM-dd HH:mm):");
            String nuevaFechaHoraStr = scanner.next() + " " + scanner.next();
            LocalDateTime nuevaFechaHora = LocalDateTime.parse(nuevaFechaHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            citaModificar.setFechaHora(nuevaFechaHora);

            System.out.println("Cita modificada con éxito.");
        } else {
            System.out.println("Cita no encontrada.");
        }
    }

    private void agregarInformes() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pacientes asignados:");

        for (Paciente paciente : pacientes) {
            System.out.println("ID: " + paciente.getId() + ", Nombre: " + paciente.getNombre() + " " + paciente.getApellido());
        }

        System.out.println("Seleccione el ID del paciente al que desea agregar un informe:");
        int idPacienteInforme = scanner.nextInt();
        Paciente pacienteInforme = buscarPacientePorID(idPacienteInforme);

        if (pacienteInforme != null) {
            scanner.nextLine(); // Consumir la nueva línea pendiente

            System.out.println("Ingrese la descripción del informe:");
            String descripcionInforme = scanner.nextLine();
            System.out.println("Ingrese la fecha del informe (yyyy-MM-dd):");
            String fechaInformeStr = scanner.next();
            LocalDate fechaInforme = LocalDate.parse(fechaInformeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            InformeMedico nuevoInforme = new InformeMedico(descripcionInforme, fechaInforme);
            pacienteInforme.agregarInforme(nuevoInforme);

            System.out.println("Informe médico agregado con éxito.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private void accederInformesMedicos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pacientes asignados:");

        for (Paciente paciente : pacientes) {
            System.out.println("ID: " + paciente.getId() + ", Nombre: " + paciente.getNombre() + " " + paciente.getApellido());
        }

        System.out.println("Seleccione el ID del paciente para acceder a sus informes médicos:");
        int idPacienteInforme = scanner.nextInt();
        Paciente pacienteInforme = buscarPacientePorID(idPacienteInforme);

        if (pacienteInforme != null) {
            System.out.println("Informes Médicos de " + pacienteInforme.getNombre() + " " + pacienteInforme.getApellido() + ":");

            for (InformeMedico informe : pacienteInforme.getInformes()) {
                System.out.println("Fecha: " + informe.getFecha() + ", Descripción: " + informe.getDescripcion());
            }
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private Cita buscarCitaPorFechaHora(LocalDateTime fechaHora) {
        for (Cita cita : citas) {
            if (cita.getFechaHora().equals(fechaHora)) {
                return cita;
            }
        }
        return null;
    }

    private Paciente buscarPacientePorID(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }
}
