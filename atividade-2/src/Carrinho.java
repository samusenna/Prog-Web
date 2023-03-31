import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Vendavel> listVendas;

    public Carrinho() {
        this.listVendas = new ArrayList<>();
    }

    public void adicionarVendavel(Vendavel v){
        listVendas.add(v);
    }

    public Double calcularTotalVenda(){
        double total = 0.0;

        for (int i = 0; i < listVendas.size(); i++){
            total += listVendas.get(i).getValorVenda();
        }
        return total;
    }

    public void exibeItensCarinnho(){

        for (int i = 0; i < listVendas.size(); i++){
            System.out.println(listVendas.get(i));
        }
    }

    public List<Vendavel> getListVendas() {
        return listVendas;
    }

    public void setListVendas(List<Vendavel> listVendas) {
        this.listVendas = listVendas;
    }
}
