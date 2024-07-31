import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static java.time.chrono.JapaneseEra.values;


public class Municipalidad {
    private final HashMap<Integer, PlanDePago> planesDePago = new HashMap<>();

    public void agregarPlan(PlanDePago plan) {
        planesDePago.put(plan.getIdPlanDePago(), plan);
    }
    public void agregarCuota(Cuota cuota) {
        planesDePago.get(cuota.getIdPlanDePago()).agregarCuotaPaga(cuota);
    }
    public HashMap<Integer, PlanDePago> getPlanesDePago() {
        return planesDePago;
    }

    public long planesPagadosTotales() {
        return planesDePago
                .values()
                .stream()
                .filter(plan -> plan.getCuotasPagas().size() == plan.getCuotasTotales())
                .count();
    }

    public double sumatoriaDeDeudas() {
        return planesDePago
                .values()
                .stream()
                .mapToDouble(PlanDePago::getTotalDeuda)
                .sum();
    }

    public double promedioInteresesAdicionales() {
        OptionalDouble a = planesDePago
                .values()
                .stream()
                .mapToDouble(PlanDePago::interesesAdicionales)
                .average();
        return a.orElse(0);
    }

    public List<Cuota> listadoPagosDeContribuyente(String nombre) {
        return planesDePago
                .values()
                .stream()
                .filter(plan -> plan.getNombre().equalsIgnoreCase(nombre))
                .flatMap(plan -> plan.getCuotasPagas().stream())
                .collect(Collectors.toList());
    }

}
