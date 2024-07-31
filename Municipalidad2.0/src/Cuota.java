public class Cuota {
    private int idPlanDePago;
    private int diasDeMora;
    private int numeroCuota;
    private double importe;

    public Cuota(int idPlanDePago, int diasDeMora, int numeroCuota) {
        this.idPlanDePago = idPlanDePago;
        this.diasDeMora = diasDeMora;
        this.numeroCuota = numeroCuota;
    }

    public Cuota() {
    }

    public int getIdPlanDePago() {
        return idPlanDePago;
    }

    public void setIdPlanDePago(int idPlanDePago) {
        this.idPlanDePago = idPlanDePago;
    }

    public int getDiasDeMora() {
        return diasDeMora;
    }

    public void setDiasDeMora(int diasDeMora) {
        this.diasDeMora = diasDeMora;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Cuota{" +
                "idPlanDePago=" + idPlanDePago +
                ", diasDeMora=" + diasDeMora +
                ", numeroCuota=" + numeroCuota +
                ", importe=" + importe +
                '}';
    }

    //--------------------------------------- Metodos ---------------------------------------


}
