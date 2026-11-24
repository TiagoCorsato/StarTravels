public class Rota {

    private final String codigo;
    private final ECidade origem;
    private final ECidade destino;

    public Rota(String codigo, ECidade origem, ECidade destino) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        if (!validar()) {
            throw new IllegalArgumentException("Rota inválida: " + codigo);
        }
    }

    /** Código de 4 dígitos; origem e destino devem ser cidades diferentes. */
    public boolean validar() {
        return codigo != null
                && codigo.matches("\\d{4}")
                && origem != null
                && destino != null
                && origem != destino;
    }

    public String getCodigo() {
        return codigo;
    }

    public ECidade getOrigem() {
        return origem;
    }

    public ECidade getDestino() {
        return destino;
    }
}
