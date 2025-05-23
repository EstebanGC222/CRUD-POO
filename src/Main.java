import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear listas para almacenar datos
        List<Paciente> pacientes = new ArrayList<>();
        List<Medico> medicos = new ArrayList<>();
        List<Cita> citas = new ArrayList<>();

        // Crear instancias de las clases de usuarios
        Administrador administrador = new Administrador(pacientes, medicos, citas);
        Doctor doctor = new Doctor(pacientes, citas);

        // Simular el inicio de sesión
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema médico.");

        while (true) {
            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("1. Administrador");
            System.out.println("2. Doctor");
            System.out.println("0. Salir");

            int tipoUsuario = scanner.nextInt();

            switch (tipoUsuario) {
                case 1:
                    administrador.mostrarMenu();
                    break;
                case 2:
                    doctor.mostrarMenu();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema médico.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
            }
        }
    }



    private static void solicitarDatosPacientes(List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese el nombre del paciente (o 'fin' para terminar):");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.println("Ingrese el apellido del paciente:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese el ID del paciente:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea pendiente

            Paciente paciente = new Paciente(nombre, apellido);
            pacientes.add(paciente);
        }
    }

    private static void solicitarDatosMedicos(List<Medico> medicos) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese el nombre del médico (o 'fin' para terminar):");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.println("Ingrese la especialidad del médico:");
            String especialidad = scanner.nextLine();

            Medico medico = new Medico(nombre, especialidad);
            medicos.add(medico);
        }
    }
}
