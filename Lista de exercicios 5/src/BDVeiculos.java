import java.util.LinkedList;
import java.util.List;

/**
 * Alexandre Tiago Ximenes
 */

public class BDVeiculos {

    private static List<Passeio> veiculosDePasseio = new LinkedList<>();
    private static List<Carga> veiculosDeCarga = new LinkedList<>();

    public static List<Passeio> getVeiculosDePasseio() {
        return veiculosDePasseio;
    }

    public static void setVeiculosDePasseio(List<Passeio> veiculosDePasseio) {
        BDVeiculos.veiculosDePasseio = veiculosDePasseio;
    }

    public void addPasseio(Passeio passeio) throws VeicExisException {
        if (veiculosDePasseio.contains(passeio))
            throw new VeicExisException("Veiculo já foi cadastrado");
        veiculosDePasseio.add(passeio);
    }

    public void addCarga(Carga carga) throws VeicExisException {
        if (veiculosDeCarga.contains(carga))
            throw new VeicExisException("Veiculo já foi cadastrado");
        veiculosDeCarga.add(carga);
    }

    public static List<Carga> getVeiculosDeCarga() {
        return veiculosDeCarga;
    }

    public static void setVeiculosDeCarga(List<Carga> veiculosDeCarga) {
        BDVeiculos.veiculosDeCarga = veiculosDeCarga;
    }


    public void imprimeVeiculosDePasseio() {
        if (veiculosDePasseio.size() > 0){
            veiculosDePasseio.stream().forEach(System.out::println);
        }else{
            System.out.println("# Não existe veiculo de passeio cadastrado");
        }
    }

    public void imprimeVeiculosDeCarga() {
        if (veiculosDeCarga.size() > 0) {
            veiculosDeCarga.stream().forEach(System.out::println);
        } else {
            System.out.println("# Não existe veiculo de carga cadastrado");
        }
    }

    public int buscaVeiculoPasseioPelaPlaca(String placa) {
        int index = 0;
        if(veiculosDePasseio.size() > 0){
            for (int i = 0 ; i < veiculosDePasseio.size(); i++){
                if(veiculosDePasseio.get(i).getPlaca().equalsIgnoreCase(placa)){
                    index = veiculosDePasseio.indexOf(i);
                }
            }
        }else {
            return -1;
        }
        return index;
    }

    public void addPasseio(int indexVeiculoPasseio, Passeio passeio) {
        veiculosDePasseio.add(indexVeiculoPasseio, passeio);
    }

    public Passeio buscaVeiculoPasseioPeloIndice(int indexVeiculoPasseio) {
        return veiculosDePasseio.get(indexVeiculoPasseio);
    }
}
