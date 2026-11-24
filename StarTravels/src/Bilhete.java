import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bilhete {

    private final List<Voo> voos = new ArrayList<>();

    /** Acrescenta um voo se a sequência continuar elegível; senão, desfaz e retorna false. */
    public boolean adicionarVoo(Voo voo) {
        if (voo == null) {
            return false;
        }
        voos.add(voo);
        if (verificarElegibilidade()) {
            return true;
        }
        voos.remove(voos.size() - 1);
        return false;
    }

    /**
     * Cada voo deve sair da cidade em que o anterior chegou,
     * no mesmo dia ou no dia seguinte ao do voo anterior.
     */
    public boolean verificarElegibilidade() {
        if (voos.isEmpty()) {
            return false;
        }
        for (int i = 1; i < voos.size(); i++) {
            Voo anterior = voos.get(i - 1);
            Voo atual = voos.get(i);
            long dias = ChronoUnit.DAYS.between(anterior.getData(), atual.getData());
            boolean mesmaCidade = anterior.getRota().getDestino() == atual.getRota().getOrigem();
            if (!mesmaCidade || dias < 0 || dias > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Um voo: preço base.
     * Mais de um voo: 60% do mais caro + 40% do segundo mais caro + 10% de cada adicional.
     */
    public double calcularPrecoVenda() {
        if (voos.isEmpty()) {
            return 0;
        }
        List<Double> precos = new ArrayList<>();
        for (Voo v : voos) {
            precos.add(v.getPrecoBase());
        }
        precos.sort(Comparator.reverseOrder());
        if (precos.size() == 1) {
            return precos.get(0);
        }
        double total = 0.6 * precos.get(0) + 0.4 * precos.get(1);
        for (int i = 2; i < precos.size(); i++) {
            total += 0.1 * precos.get(i);
        }
        return total;
    }

    public ECidade getOrigem() {
        return voos.isEmpty() ? null : voos.get(0).getRota().getOrigem();
    }

    public ECidade getDestino() {
        return voos.isEmpty() ? null : voos.get(voos.size() - 1).getRota().getDestino();
    }

    public List<LocalDate> getDatas() {
        List<LocalDate> datas = new ArrayList<>();
        for (Voo v : voos) {
            datas.add(v.getData());
        }
        return datas;
    }
}
