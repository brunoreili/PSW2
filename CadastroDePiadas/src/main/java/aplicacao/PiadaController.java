package aplicacao;

import entidade.Piada;
import entidade.PiadaDAO;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiadaController {
    
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping(method = RequestMethod.POST, value="/piada")
    public Piada salvarPiada(@RequestBody Piada p){
        System.out.println("Autordapiada: " + p.getAutor().getNome());
        PiadaDAO dao = new PiadaDAO();
        Piada piadaSalva = dao.salvar(p);
        return piadaSalva;
    }
    
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping(method = RequestMethod.GET, value = "/piada")
    public List<Piada> ListarPiada(@RequestParam(value="palavra", defaultValue="")String filtro, 
                                   @RequestParam(value="safe", defaultValue="false")boolean safe){
        
        PiadaDAO dao = new PiadaDAO();
        return dao.consultar(filtro, safe);
        
    }
    
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping(method = RequestMethod.DELETE, value = "/piada/{id}")
    public void deletarPiada(@PathVariable("id")int id){
        
        new PiadaDAO().deletar(id);
    
    }
    
}
