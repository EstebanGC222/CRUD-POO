import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Administrador {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Cita> citas;

    public Administrador(List<Paciente> pacientes, List<Medico> medicos, List<Cita> citas) {
        this.pacientes = pacientes;
        this.medicos = medicos;
        this.citas = citas;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente agregado con éxito.");
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
        System.out.println("Médico agregado con éxito.");
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
        System.out.println("Cita agregada con éxito.");
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Administrador:");
            System.out.println("1. Pacientes (CRUD)");
            System.out.println("2. Médicos (CRUD)");
            System.out.println("3. Citas (CRUD)");
            System.out.println("4. Acceso a informes médicos de pacientes");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionarPacientes();
                    break;
                case 2:

                    gestionarMedicos();
                    break;
                case 3:
                    gestionarCitas();
                    break;
                case 4:
                    accederInformesMedicos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void gestionarPacientes() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Pacientes:");
            System.out.println("1. Crear Paciente");
            System.out.println("2. Leer Pacientes");
            System.out.println("3. Actualizar Paciente");
            System.out.println("4. Eliminar Paciente");
            System.out.println("0. Volver al Menú Principal");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear Paciente
                    System.out.println("Ingrese el nombre del paciente:");
                    String nombre = scanner.next();
                    System.out.println("Ingrese el apellido del paciente:");
                    String apellido = scanner.next();


                    Paciente nuevoPaciente = new Paciente(nombre, apellido);
                    agregarPaciente(nuevoPaciente);
                    break;
                case 2:
                    // Leer Pacientes
                    System.out.println("Lista de Pacientes:");
                    for (Paciente paciente : pacientes) {
                        System.out.println("ID: " + paciente.getId() + ", Nombre: " + paciente.getNombre() + " " + paciente.getApellido());
                    }
                    break;
                case 3:
                    System.out.println("Lista de Pacientes:");
                    for (Paciente paciente : pacientes) {
                        System.out.println(paciente.obtenerInformacion());
                    }

                    System.out.println("Ingrese el ID del paciente que desea actualizar:");
                    int idActualizar = scanner.nextInt();
                    Paciente pacienteActualizar = buscarPacientePorID(idActualizar);

                    if (pacienteActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del paciente:");
                        pacienteActualizar.setNombre(scanner.next());
                        System.out.println("Ingrese el nuevo apellido del paciente:");
                        pacienteActualizar.setApellido(scanner.next());
                        System.out.println("Paciente actualizado con éxito.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 4:
                    // Eliminar Paciente
                    System.out.println("Lista de Pacientes:");
                    for (Paciente paciente : pacientes) {
                        System.out.println(paciente.obtenerInformacion());
                    }

                    System.out.println("Ingrese el ID del paciente que desea eliminar:");
                    int idEliminar = scanner.nextInt();
                    Paciente pacienteEliminar = buscarPacientePorID(idEliminar);

                    if (pacienteEliminar != null) {
                        pacientes.remove(pacienteEliminar);
                        System.out.println("Paciente eliminado con éxito.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 0:
                    // Volver al Menú Principal
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void gestionarMedicos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Médicos:");
            System.out.println("1. Crear Médico");
            System.out.println("2. Leer Médicos");
            System.out.println("3. Actualizar Médico");
            System.out.println("4. Eliminar Médico");
            System.out.println("0. Volver al Menú Principal");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear Médico
                    System.out.println("Ingrese el nombre del médico:");
                    String nombreMedico = scanner.next();
                    System.out.println("Ingrese la especialidad del médico:");
                    String especialidadMedico = scanner.next();

                    Medico nuevoMedico = new Medico(nombreMedico, especialidadMedico);
                    agregarMedico(nuevoMedico);
                    break;
                case 2:
                    // Leer Médicos
                    System.out.println("Lista de Médicos:");
                    for (Medico medico : medicos) {
                        System.out.println("Nombre: " + medico.getNombre() + ", Especialidad: " + medico.getEspecialidad());
                    }
                    break;
                case 3:
                    // Actualizar Médico
                    System.out.println("Lista de Médicos:");
                    for (Medico medico : medicos) {
                        System.out.println("ID: " + medico.getId() + ", Nombre: " + medico.getNombre() + ", Especialidad: " + medico.getEspecialidad());
                    }
                    System.out.println("Ingrese el ID del médico que desea actualizar:");
                    int idActualizar = scanner.nextInt();
                    Medico medicoActualizar = buscarMedicoPorId(idActualizar);

                    if (medicoActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del médico:");
                        medicoActualizar.setNombre(scanner.next());
                        System.out.println("Ingrese la nueva especialidad del médico:");
                        medicoActualizar.setEspecialidad(scanner.next());
                        System.out.println("Médico actualizado con éxito.");
                    } else {
                        System.out.println("Médico no encontrado.");
                    }
                    break;
                case 4:
                    // Eliminar Médico
                    System.out.println("Lista de Médicos:");
                    for (Medico medico : medicos) {
                        System.out.println("ID: " + medico.getId() + ", Nombre: " + medico.getNombre() + ", Especialidad: " + medico.getEspecialidad());
                    }

                    System.out.println("Ingrese el ID del médico que desea eliminar:");
                    int idEliminar = scanner.nextInt();
                    Medico medicoEliminar = buscarMedicoPorID(idEliminar);

                    if (medicoEliminar != null) {
                        medicos.remove(medicoEliminar);
                        System.out.println("Médico eliminado con éxito.");
                    } else {
                        System.out.println("Médico no encontrado.");
                    }
                    break;
                case 0:
                    // Volver al Menú Principal
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    private Medico buscarMedicoPorId(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }
    private Medico buscarMedicoPorID(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }
    private void mostrarListaPacientes() {
        System.out.println("Lista de Pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println("ID: " + paciente.getId() + ", Nombre: " + paciente.getNombre() + " " + paciente.getApellido());
        }
    }

    private void mostrarListaMedicos() {
        System.out.println("Lista de Médicos:");
        for (Medico medico : medicos) {
            System.out.println("ID: " + medico.getId() + ", Nombre: " + medico.getNombre() + ", Especialidad: " + medico.getEspecialidad());
        }
    }

    private Paciente seleccionarPacientePorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    private Medico seleccionarMedicoPorId(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }

    private void gestionarCitas() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Citas:");
            System.out.println("1. Crear Cita");
            System.out.println("2. Leer Citas");
            System.out.println("3. Actualizar Cita");
            System.out.println("4. Eliminar Cita");
            System.out.println("0. Volver al Menú Principal");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear Cita
                    mostrarListaPacientes();
                    System.out.println("Ingrese el ID del paciente:");
                    int idPacienteCita = scanner.nextInt();
                    Paciente pacienteCita = seleccionarPacientePorId(idPacienteCita);

                    if (pacienteCita != null) {
                        mostrarListaMedicos();
                        System.out.println("Ingrese el ID del médico:");
                        int idMedicoCita = scanner.nextInt();
                        Medico medicoCita = seleccionarMedicoPorId(idMedicoCita);

                        if (medicoCita != null) {
                            System.out.println("Ingrese la fecha y hora de la cita (yyyy-MM-dd HH:mm):");
                            String fechaHoraStr = scanner.next() + " " + scanner.next();

                            LocalDateTime fechaHoraCita = LocalDateTime.parse(fechaHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                            Cita nuevaCita = new Cita(fechaHoraCita, pacienteCita, medicoCita);
                            agregarCita(nuevaCita);
                        } else {
                            System.out.println("Médico no encontrado.");
                        }
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 2:
                    // Leer Citas
                    System.out.println("Lista de Citas:");
                    for (Cita cita : citas) {
                        System.out.println("ID: " + citas.indexOf(cita) + ", Fecha y Hora: " + cita.getFechaHora() +
                                ", Paciente: " + cita.getPaciente().getNombre() + " " + cita.getPaciente().getApellido() +
                                ", Médico: " + cita.getMedico().getNombre());
                    }
                    break;
                case 3:
                    System.out.println("Lista de Citas:");
                    for (Cita cita : citas) {
                        System.out.println("ID: " + citas.indexOf(cita) + ", Fecha y Hora: " + cita.getFechaHora() +
                                ", Paciente: " + cita.getPaciente().getNombre() + " " + cita.getPaciente().getApellido() +
                                ", Médico: " + cita.getMedico().getNombre());
                    }

                    System.out.println("Ingrese el ID de la cita que desea actualizar:");
                    int idCitaActualizar = scanner.nextInt();

                    if (idCitaActualizar >= 0 && idCitaActualizar < citas.size()) {
                        Cita citaActualizar = citas.get(idCitaActualizar);

                        System.out.println("Ingrese la nueva fecha y hora de la cita (yyyy-MM-dd HH:mm):");
                        String nuevaFechaHoraStr = scanner.next() + " " + scanner.next();
                        LocalDateTime nuevaFechaHora = LocalDateTime.parse(nuevaFechaHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                        citaActualizar.setFechaHora(nuevaFechaHora);

                        System.out.println("Cita actualizada con éxito.");
                    } else {
                        System.out.println("ID de cita no válido.");
                    }
                    break;
                case 4:
                    // Eliminar Cita
                    System.out.println("Lista de Citas:");
                    for (Cita cita : citas) {
                        System.out.println("ID: " + citas.indexOf(cita) + ", Fecha y Hora: " + cita.getFechaHora() +
                                ", Paciente: " + cita.getPaciente().getNombre() + " " + cita.getPaciente().getApellido() +
                                ", Médico: " + cita.getMedico().getNombre());
                    }

                    System.out.println("Ingrese el ID de la cita que desea eliminar:");
                    int idCitaEliminar = scanner.nextInt();

                    if (idCitaEliminar >= 0 && idCitaEliminar < citas.size()) {
                        citas.remove(idCitaEliminar);
                        System.out.println("Cita eliminada con éxito.");
                    } else {
                        System.out.println("ID de cita no válido.");
                    }
                    break;

                case 0:
                    // Volver al Menú Principal
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void accederInformesMedicos() {
        Scanner scanner = new Scanner(System.in);

        mostrarListaPacientes();
        System.out.println("Ingrese el ID del paciente para acceder a sus informes médicos:");
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


    private Paciente buscarPacientePorID(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    private Medico buscarMedicoPorNombre(String nombre) {
        for (Medico medico : medicos) {
            if (medico.getNombre().equalsIgnoreCase(nombre)) {
                return medico;
            }
        }
        return null;
    }

    private Cita buscarCitaPorFechaHora(LocalDateTime fechaHora) {
        for (Cita cita : citas) {
            if (cita.getFechaHora().equals(fechaHora)) {
                return cita;
            }
        }
        return null;
    }
}
