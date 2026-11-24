import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    private List<Voo> listaDeVoos = new ArrayList<Voo>();
    private List<Rota> listaDeRotas = new ArrayList<Rota>();


    public static void main(String[] args) throws Exception {
        
    }

    private void GerarRotas()
    {

    }

    private void MostrarMenu()
    {

    }

    private void LoopPrincipal()
    {

    }

    private void ProcurarVoos()
    {

    }

    private void CadastrarCliente()
    {

    }

    private void CriarBilhete()
    {

    }

    private void CadastrarVoo()
    {   
        int rotaIndex = Integer.parseInt(IO.readln("Digite a rota: "));
        Rota rota = SelecionarRota(rotaIndex);
        int dataIndex = Integer.parseInt(IO.readln("Digite a data: "));
        //LocalDate data = SelecionarData(voo);
        //Voo voo = new Voo(rota, data, 0);
        //listaDeVoos.add(voo);
        IO.println("Voo cadastrado com sucesso!");
    }

    private Bilhete ComprarBilhete(Cliente cliente)
    {
        return cliente.comprarBilhete(listaDeVoos);
    }

    private Rota SelecionarRota(int index)
    {
        return listaDeRotas.get(index);
    }
    private LocalDate SelecionarData(Voo voo)
    {
        return voo.getData();
    }
}
