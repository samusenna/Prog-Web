import java.util.ArrayList;
import java.util.List;

public class ControleBonus{
    private List<FuncionarioBonificado> listFunc;

    public ControleBonus(List<FuncionarioBonificado> listFunc) {
        this.listFunc = new ArrayList<>();
    }

    public void addFunc(FuncionarioBonificado f){
        listFunc.add(f);
    }

    public void listarFunc(){
        for (int i = 0; i < listFunc.size(); i++){
            System.out.println(listFunc);
        }
    }
}
