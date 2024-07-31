import java.util.ArrayList;

public class PlanDePago{
    private int idPlanDePago;
    private String nombre;
    private double totalDeuda;
    private int cuotasTotales;
    private ArrayList<Cuota> cuotasPagas = new ArrayList<>();

    public PlanDePago(int idPlanDePago, String nombre, double totalDeuda, int cuotasTotales) {
        this.idPlanDePago = idPlanDePago;
        this.nombre = nombre;
        this.totalDeuda = totalDeuda;
        this.cuotasTotales = cuotasTotales;

    }

    public PlanDePago() {
        cuotasPagas = new ArrayList<>();
    }

    public ArrayList<Cuota> getCuotasPagas() {
        return cuotasPagas;
    }

    public void setCuotasPagas(ArrayList<Cuota> cuotasPagas) {
        this.cuotasPagas = cuotasPagas;
    }

    public int getIdPlanDePago() {
        return idPlanDePago;
    }

    public void setIdPlanDePago(int idPlanDePago) {
        this.idPlanDePago = idPlanDePago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotalDeuda() {
        return totalDeuda;
    }

    public void setTotalDeuda(double totalDeuda) {
        this.totalDeuda = totalDeuda;
    }

    public int getCuotasTotales() {
        return cuotasTotales;
    }

    public void setCuotasTotales(int cuotasTotales) {
        this.cuotasTotales = cuotasTotales;
    }

    @Override
    public String toString() {
        return "PlanDePago{" +
                "idPlanDePago=" + idPlanDePago +
                ", nombre='" + nombre + '\'' +
                ", totalDeuda=" + totalDeuda +
                ", cuotasTotales=" + cuotasTotales +
                '}';
    }



    //---------------------------------------- Metodos ----------------------------------------

    public double calcularMontoCuota(){
        return totalDeuda / cuotasTotales;
    }
    public void agregarCuotaPaga(Cuota cuota){
        double importe = this.calcularMontoCuota() + ((this.calcularMontoCuota() * 0.005) * (cuota.getDiasDeMora()));
        cuota.setImporte(importe);
        cuotasPagas.add(cuota);
    }


    public double interesesAdicionales() {

        return cuotasPagas
                .stream()
                .mapToDouble(cuota -> cuota.getImporte() - this.calcularMontoCuota())
                .sum();
    }
}


