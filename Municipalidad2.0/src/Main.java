import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Reader r = new Reader();
        Municipalidad m = new Municipalidad();

        r.leerPlanDePago(m);
        r.leerCuotas(m);

        opcionesMenu(m);
    }

    public static void opcionesMenu(Municipalidad m) {
        Map<Integer, Runnable> mapaMenu = new HashMap<>();
        mapaMenu.put(1, () -> System.out.println("Planes pagados en su totalidad: " + m.planesPagadosTotales() + "/30"));
        mapaMenu.put(2, () -> System.out.println("Sumatoria de deudas: " + String.format("%.2f", m.sumatoriaDeDeudas())));
        mapaMenu.put(3, () -> System.out.println("Promedio de intereses adicionales: " + String.format("%.2f", m.promedioInteresesAdicionales())));
        mapaMenu.put(4, () -> {
            System.out.println("Ingrese el nombre del contribuyente: Juan Perez");
            Scanner sc = new Scanner(System.in);
            String nombre = sc.nextLine();
            m.listadoPagosDeContribuyente(nombre).forEach(System.out::println);
        });

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("------ Menú ------");
            System.out.println("1. Planes pagados en su totalidad");
            System.out.println("2. Sumatoria de deudas");
            System.out.println("3. Promedio de intereses adicionales");
            System.out.println("4. Listado de pagos de un contribuyente");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            mapaMenu.getOrDefault(opcion, () -> System.out.println("Opción inválida. Intente nuevamente.")).run();

            System.out.println();
        } while (opcion != 0);
    }
}
