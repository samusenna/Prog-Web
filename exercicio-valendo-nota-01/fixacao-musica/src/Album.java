import java.util.ArrayList;
import java.util.List;

public class Album{
    private String nomeAlbum;
    private Integer qtdMusica;
    private String dtLancamento;

    private List<Musica> faixas;

    public Album(String nomeAlbum, Integer qtdMusica, String dtLancamento) {
        this.nomeAlbum = nomeAlbum;
        this.qtdMusica = qtdMusica;
        this.dtLancamento = dtLancamento;
        this.faixas = new ArrayList<>();
    }

    public void adicionarMusica(Musica m){
        for (int i = 0; i < qtdMusica; i++){
            faixas.add(m);
            System.out.println("Musica adicionada! \n");
        }
    }

    public String buscarPornome(String nome){

        System.out.println("Buscando por nome! \n");
        for (int i = 0; i < faixas.size(); i++){
            if (nome == faixas.get(i).getNome()){
                System.out.println(faixas.get(i).getNome());
                return "Musica encontrada com sucesso! \n" +
                        "Musica: " + faixas;
            }
        }
        return "Musica não encontrada ou não existe!!";
    }

    public String buscarCompositor(String compositor){

        System.out.println("Buscando por compositor! \n");
        for (int i = 0; i < faixas.size(); i++){
            if (compositor == faixas.get(i).getCompositor()){
                System.out.println(faixas.get(i));
                return "Musica encontrada com sucesso! \n" +
                        "Musica: " + faixas;
            }
        }
        return "Musica não encontrada ou Compositor não existe!!";
    }

    public List listarMusicasAlbum(){
        System.out.println("Listando album! \n" + faixas);
        return faixas;
    }

    public List<Musica> getFaixas() {
        return faixas;
    }
}
