package schoolsptech.projeto02;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/musicas")
public class MusicaController {

    private List<Musica> playlist;

    public MusicaController() {
        this.playlist = new ArrayList<>();
        playlist.add(new Musica("Carlina", "Luiz gonzaga", 2000));
        playlist.add(new Musica("Dias de luta, dias de gloria", "Chorão", 2001));
        playlist.add(new Musica("Boate azul", "Milionario e jose rico", 1980));
    }

    @GetMapping

    public List<Musica> list(){
        return playlist;
    }
    // http://localhost:8080/musica/recuperar
    // @GetMapping("/recuperar/{indice}")
   // http://localhost:8080/musica/8

    @GetMapping("/{indice}")
    public Musica recuperar (@PathVariable int indice){
        if(indice >= 0 && indice < playlist.size()){
            return playlist.get(indice);

        }
        return null;
    }

    // http://localhost:8080/musica/remove/8
    // @GetMapping("/remove/{indice}")
    // http://localhost:8080/8
    @DeleteMapping("/{indice}")
    public String remover (@PathVariable int indice){
        if(indice >= 0 && indice < playlist.size()){
            playlist.remove(indice);
            return "Musica removida com sucesso";

        }
        return "Musica não encontrada";
    }

    @PostMapping
    public Musica criar(@RequestBody Musica novaMusica){
    //    Musica novaMusica = new Musica(nome, artista, anoLancamento);
        playlist.add(novaMusica);
        return novaMusica;
    }

    @PutMapping("/{indice}")
        public String alterar(@PathVariable int indice, @RequestBody Musica musicaAlterada){
        if(indice >= 0 && indice < playlist.size()){
          //  Musica musicaAlterada = new Musica(nome, artista, anoLancamento);
            playlist.set(indice, musicaAlterada);
            return "alterado com sucesso";
        }
        return "Musica não alterada";
    }

}
