package controle;

import entidade.Pincel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class Controle {
   
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping(method = RequestMethod.POST, value = "/pincel")
    public Pincel criarPincel(@RequestBody Pincel p){
        
        //Jogar p no BD e receber do BD o id
        //Preencher o id de P
        p.setCor("Amarelo");
        p.setNum_serie(9876);
        
        return p;
    }
    
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping(method = RequestMethod.PUT, value = "/pincel/{id}")
    public Pincel atualizarPincel(@RequestBody Pincel p, @PathVariable("id") int id){
        
        //Jogar p no BD e receber do BD o id
        //Preencher o id de P
        
        p.setNum_serie(9876);
        
        return p;
    }
    
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping("/pincel/{id}")
    public Pincel buscarPincel(@PathVariable("id") int id){
        
        Pincel p = new Pincel();
        p.setCor("vermelho");
        p.setIdentificador(99);
        p.setNum_serie(id);
        
        return p;
        
    }   
    
    //GET Pincel
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping("/pincel")
    public List<Pincel> buscarPincel(){
        List resultado = new ArrayList<Pincel>();
        
        Pincel p1 = new Pincel();
        p1.setCor("Azul");
        p1.setIdentificador(1);
        p1.setNum_serie(999);
        
        resultado.add(p1);
        
        Pincel p2 = new Pincel();
        p2.setCor("Verde");
        p2.setIdentificador(2);
        p2.setNum_serie(777);
        
        resultado.add(p2);
        
        return resultado;
        
    }
    
}
