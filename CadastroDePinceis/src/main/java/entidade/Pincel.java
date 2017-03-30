package entidade;

public class Pincel {

    private int identificador;
    private String cor;
    private Fabricante fabricante;  
    private int num_serie;

    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public int getNum_serie() {
        return num_serie;
    }
    public void setNum_serie(int num_serie) {
        this.num_serie = num_serie;
    }
   
}