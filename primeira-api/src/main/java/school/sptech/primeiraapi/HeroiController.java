package school.sptech.primeiraapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    List<Heroi> herois = new ArrayList<>();
    @GetMapping("/favorito")
public Heroi favorito() {

        Heroi heroi = new Heroi("Batman", 17, "rico", 8500.0,true);
        return heroi;
    }

    @GetMapping
    public List<Heroi> listar(){
         herois.add(new Heroi("Batman", 17, "rico", 8500.0,true));
        return herois;
    }
}
