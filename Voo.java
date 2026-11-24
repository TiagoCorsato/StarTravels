package xavi;

import java.time.LocalDate;

public class Voo {

    public static final int CAPACIDADE_MAX = 150;

    private final Rota rota;
    private final LocalDate data;
    private final double precoBase;
    private int passageiros;

    public Voo(Rota rota, LocalDate data, double precoBase) {
        if (rota == null) {
            throw new IllegalArgumentException("Rota obrigatória");
        }
        LocalDate hoje = LocalDate.now();
        if (data == null || data.isBefore(hoje) || data.isAfter(hoje.plusMonths(12))) {
            throw new IllegalArgumentException("Data deve estar entre hoje e 12 meses à frente");
        }
        if (precoBase < 0) {
            throw new IllegalArgumentException("Preço base não pode ser negativo");
        }
        this.rota = rota;
        this.data = data;
        this.precoBase = precoBase;
        this.passageiros = 0;
    }

    /** "XAV" seguido do código da rota, ex.: XAV1350. */
    public String getCodigo() {
        return "XAV" + rota.getCodigo();
    }

    /** Reserva um assento; retorna false se o voo já estiver lotado. */
    public boolean reservarAssento() {
        if (passageiros >= CAPACIDADE_MAX) {
            return false;
        }
        passageiros++;
        return true;
    }

    public Rota getRota() {
        return rota;
    }

    public LocalDate getData() {
        return data;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public int getPassageiros() {
        return passageiros;
    }
}
