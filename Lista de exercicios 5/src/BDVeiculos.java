import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;

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

    public void save(Passeio passeio) throws VeicExisException {
        if (veiculosDePasseio.contains(passeio))
            throw new VeicExisException("Veiculo de passeio já foi cadastrado");
        veiculosDePasseio.add(passeio);
    }

    public void save(Carga carga) throws VeicExisException {
        if (veiculosDeCarga.contains(carga))
            throw new VeicExisException("Veiculo de carga já foi cadastrado");
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
            System.out.println("# Imprimindo todos os veiculos de passeio");
            veiculosDePasseio.stream().forEach(System.out::println);
        }else{
            System.out.println("# Não existe veiculo de passeio cadastrado");
        }
    }

    public void imprimeVeiculosDeCarga() {
        if (veiculosDeCarga.size() > 0) {
            System.out.println("# Imprimindo todos os veiculos de carga");
            veiculosDeCarga.stream().forEach(System.out::println);
        } else {
            System.out.println("# Não existe veiculo de carga cadastrado");
        }
    }

    public Passeio buscaVeiculoPasseioPelaPlaca(Passeio passeio) {
        if(veiculosDePasseio.size() > 0 && nonNull(passeio) && nonNull(passeio.getPlaca())){
            for (int i = 0 ; i < veiculosDePasseio.size(); i++){
                if(veiculosDePasseio.get(i).getPlaca().equalsIgnoreCase(passeio.getPlaca())){
                    passeio = veiculosDePasseio.get(i);
                    passeio.setId(i);
                    return passeio;
                }
            }
        }
        return null;
    }


    public Carga buscaVeiculoCargaPelaPlaca(Carga carga) {
        if(veiculosDeCarga.size() > 0 && nonNull(carga) && nonNull(carga.getPlaca())){
            for (int i = 0 ; i < veiculosDeCarga.size(); i++){
                if(veiculosDeCarga.get(i).getPlaca().equalsIgnoreCase(carga.getPlaca())){
                    carga = veiculosDeCarga.get(i);
                    carga.setId(i);
                    return carga;
                }
            }
        }
        return null;
    }
    public boolean existeVeiculoPasseioComA(String placa) throws VeicExistException {
        if(veiculosDePasseio.size() > 0 && nonNull(placa)){
            for (int i = 0 ; i < veiculosDePasseio.size(); i++){
                if(veiculosDePasseio.get(i).getPlaca().equalsIgnoreCase(placa)){
                    throw new VeicExistException("Veiculo com a Placa ("+placa+") já foi cadastrado");
                }
            }
        }
        return false;
    }

    public boolean existeVeiculoCargaComA(String placa) throws VeicExistException {
        if(veiculosDeCarga.size() > 0 && nonNull(placa)){
            for (int i = 0 ; i < veiculosDeCarga.size(); i++){
                if(veiculosDeCarga.get(i).getPlaca().equalsIgnoreCase(placa)){
                    throw new VeicExistException("Veiculo com a Placa ("+placa+") já foi cadastrado");
                }
            }
        }
        return false;
    }

    public void save(int indexVeiculoPasseio, Carga carga) {
        veiculosDeCarga.add(indexVeiculoPasseio, carga);
    }
    public void save(int indexVeiculoPasseio, Passeio passeio) {
        veiculosDePasseio.add(indexVeiculoPasseio, passeio);
    }
}
