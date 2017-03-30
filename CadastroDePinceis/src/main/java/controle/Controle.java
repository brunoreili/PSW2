package controle;

import entidade.Pincel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controle {
    
    //GET Pincel
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