
import java.util.ArrayList;
import java.util.List;

public class ControleBonus{
    private List<Educador> listFunc;

    public ControleBonus(List<Educador> listFunc) {
        this.listFunc = new ArrayList<>();
    }

    public void addFunc(Educador f){
        listFunc.add(f);
    }

    public void listarFunc(){
        for (int i = 0; i < listFunc.size(); i++){
            System.out.println(listFunc);
        }
    }
}
