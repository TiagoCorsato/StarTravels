import java.util.ArrayList;
import java.util.List;

public class Cliente
{
    private String nome;
    private String sobrenome;
    private String numeroRegistro;
    private List<Bilhete> historicoBilhetes;
    
    // TODO
    public Cliente()
    {

    }

    public Bilhete comprarBilhete(List<Voo> voos)
    {
        Bilhete bilhete = new Bilhete();

        for (Voo voo : voos) 
        {
            if(!bilhete.verificarElegibilidade()) return null;
                bilhete.adicionarVoo(voo);
                historicoBilhetes.add(bilhete);
        }
        return bilhete;
    }

    // TODO
    public double calcularTotalGasto()
    {
        double valorTotal = 0;
        for (Bilhete bilhete : historicoBilhetes) 
        {
            Voo primeiroCaro;
            Voo segundoCaro;
            for (Voo voo : bilhete.getListaDeVoos()) 
            {
                if(voo.getPrecoBase() > bilhete.getListaDeVoos().get(+1).getPrecoBase())
                    primeiroCaro = voo;
                else
                    segundoCaro = voo;
                
            }
            valorTotal += bilhete.calcularPrecoDeVenda();
        }
        return valorTotal;
    }

    // TODO
    public List<Bilhete> getHistoricoBilhetes()
    {
        return historicoBilhetes;
    }
}