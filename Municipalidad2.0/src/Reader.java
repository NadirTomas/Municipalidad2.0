import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Reader {


    public PlanDePago generarPlan(String linea){
        Scanner sc = new Scanner(linea);
        sc.useDelimiter(";");
        int idPlanDePago = sc.nextInt();
        String nombre = sc.next();
        double totalDeuda = sc.nextDouble();
        int cuotasTotales = sc.nextInt();
        return new PlanDePago(idPlanDePago, nombre, totalDeuda, cuotasTotales);
    }

    public void leerPlanDePago(Municipalidad municipalidad) throws FileNotFoundException {
        new BufferedReader(new FileReader("C:\\Users\\nadir\\OneDrive\\Escritorio\\Proyectos\\trabajo-practico-modulo-2-NadirTomas\\Municipalidad2.0\\PlanesDePago.txt"))
                .lines()
                .map(this::generarPlan)
                .forEach(municipalidad::agregarPlan);
    }

    public Cuota generarCuota(String linea){
        Scanner sc = new Scanner(linea);
        sc.useDelimiter(";");
        int idPlanDePago = sc.nextInt();
        int diasDeMora = sc.nextInt();
        int numeroCuota = sc.nextInt();
        return new Cuota(idPlanDePago, diasDeMora, numeroCuota);
    }

    public void leerCuotas(Municipalidad municipalidad) throws FileNotFoundException {
        new BufferedReader(new FileReader("C:\\Users\\nadir\\OneDrive\\Escritorio\\Proyectos\\trabajo-practico-modulo-2-NadirTomas\\Municipalidad2.0\\Cuotas.txt"))
                .lines()
                .map(this::generarCuota)
                .forEach(municipalidad::agregarCuota);
    }



}
