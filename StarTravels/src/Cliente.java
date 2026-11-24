import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {

    private final String nome;
    private final String sobrenome;
    private final String numeroRegistro;
    private final List<Bilhete> bilhetes = new ArrayList<>();

    public Cliente(String nome, String sobrenome, String numeroRegistro) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroRegistro = numeroRegistro;
    }

    /** Monta um bilhete com a sequência de voos e o atribui ao cliente. */
    public Bilhete comprarBilhete(List<Voo> voos) {
        Bilhete bilhete = new Bilhete();
        for (Voo v : voos) {
            if (!bilhete.adicionarVoo(v)) {
                throw new IllegalArgumentException("Sequência de voos inválida para o bilhete");
            }
        }
        if (!bilhete.verificarElegibilidade()) {
            throw new IllegalArgumentException("Bilhete sem voos");
        }
        bilhetes.add(bilhete);
        return bilhete;
    }

    public double calcularTotalGasto() {
        double total = 0;
        for (Bilhete b : bilhetes) {
            total += b.calcularPrecoVenda();
        }
        return total;
    }

    public List<Bilhete> getHistoricoBilhetes() {
        return Collections.unmodifiableList(bilhetes);
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }
}
