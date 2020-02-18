import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Alexandre Tiago Ximenes
 */

public class Teste {

    private static BDVeiculos bdVeiculos = new BDVeiculos();
    static String escolha;
    static Leitura leitura = new Leitura();
    static String resposta = null;

    public static void main(String[] args) {

        System.out.println("Sistema de gestão de veiculos - Menu inicial");

        do {

            menuSistema();
            escolha = leitura.entraDados();

            switch (escolha) {
                case "1":
                    cadastrarVeiculoDePasseio();
                    break;
                case "2":
                    cadastrarVeiculoDeCarga();
                    break;
                case "3":
                    imprimirTodosVeiculosDePasseio();
                    break;
                case "4":
                    imprimirTodosVeiculosDeCarga();
                    break;
                case "5":
                    imprimirVeiculosDePasseioPelaPlaca();
                    break;
                case "6":
                    imprimirVeiculosDeCargaPelaPlaca();
                    break;
                case "7":
                    System.out.println("Informe a placa: ");
                    String placa = leitura.entraDados();
                    Passeio passeio = new Passeio();
                    passeio.setPlaca(placa);
                    alterarDadosDoveiculoDePasseioPelaPlaca(passeio);
                    break;
                case "8":
                    alterarDadosDoveiculoDeCargaPelaPlaca();
                    break;
            }

        } while (!escolha.equals("9"));
        System.out.println("Finalizou o programa");
    }

    private static void menuSistema() {
        System.out.println();
        System.out.println("1)_ Cadastrar Veículo de Passeio");
        System.out.println("2)_ Cadastrar Veículo de Carga");
        System.out.println("3)_ Imprimir Todos os Veículos de Passeio");
        System.out.println("4)_ Imprimir Todos os Veículos de Carga");
        System.out.println("5)_ Imprimir Veículo de Passeio pela Placa");
        System.out.println("6)_ Imprimir Veículo de Carga pela Placa");
        System.out.println("7)_ Alterar dados do Veículo de Passeio pela Placa");
        System.out.println("8)_ Alterar dados do Veículo de Carga pela Placa");
        System.out.println("9)_ Sair do Sistema");
    }

    private static void alterarDadosDoveiculoDeCargaPelaPlaca() {
        System.out.println("# Voce escolheu alterar veiculo de carga pela placa");
    }

    private static void alterarDadosDoveiculoDePasseioPelaPlaca(Passeio passeio) {
        System.out.println("# Voce escolheu alterar veiculo de passeio pela placa");
        Passeio passeioRecuperado = bdVeiculos.buscaVeiculoPasseioPelaPlaca(passeio);



    }

    private static void imprimirVeiculosDeCargaPelaPlaca() {
        System.out.println("# Imprimindo veiculo de carga pela placa");
        System.out.println("Informe a placa: ");
        String placa = leitura.entraDados();
        Carga carga = new Carga();
        carga.setPlaca(placa);
        carga = bdVeiculos.buscaVeiculoCargaPelaPlaca(carga);
        if(nonNull(carga)){
            System.out.println(carga);
        }else{
            System.out.println("# Veiculo não encontrado");
        }

    }

    private static void imprimirVeiculosDePasseioPelaPlaca() {
        System.out.println("# Imprimindo veiculo de passeio pela placa");
        System.out.println("Informe a placa: ");
        String placa = leitura.entraDados();
        Passeio passeio = new Passeio();
        passeio.setPlaca(placa);
        passeio = bdVeiculos.buscaVeiculoPasseioPelaPlaca(passeio);
        if(nonNull(passeio)){
            System.out.println(passeio);
        }else{
            System.out.println("# Veiculo não encontrado");
        }
    }

    private static void imprimirTodosVeiculosDeCarga() {
        bdVeiculos.imprimeVeiculosDeCarga();
    }

    private static void imprimirTodosVeiculosDePasseio() {
        bdVeiculos.imprimeVeiculosDePasseio();
    }

    private static void cadastrarVeiculoDeCarga() {
        System.out.println("# Você escolheu cadastrar veiculo de carga");

        System.out.println("Informe a placa: ");
        String placa = leitura.entraDados();

        try {

            //Caso não existe veiculo cadastrado com essa placa
            if (!bdVeiculos.existeVeiculoCargaComA(placa)) {

                Carga carga = new Carga();
                carga = cadastrarOuAtualizarDados(carga, placa);
                save(carga);
            }

        } catch (VeicExistException e) {
            System.out.println(e.getMessage());

            System.out.println("Você quer sobrescrever o veiculo? [s/n]");
            resposta = leitura.entraDados();
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                Passeio passeio = new Passeio();
                passeio.setPlaca(placa);
                alterarDadosDoveiculoDePasseioPelaPlaca(passeio);
            } else {
                cadastrarVeiculoDoMesmoTipo(placa);
            }
        }
    }

    private static void cadastrarVeiculoDePasseio() {

        System.out.println("# Você escolheu cadastrar veiculo de passeio");

        System.out.println("Informe a placa: ");
        String placa = leitura.entraDados();

        try {

            //Caso não existe veiculo cadastrado com essa placa
            if (!bdVeiculos.existeVeiculoPasseioComA(placa)) {

                Passeio passeio = new Passeio();
                passeio = cadastrarOuAtualizarDados(passeio, placa);
                save(passeio);
            }

        } catch (VeicExistException e) {
            System.out.println(e.getMessage());

            System.out.println("Você quer sobrescrever o veiculo? [s/n]");
            resposta = leitura.entraDados();
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                Passeio passeio = new Passeio();
                passeio.setPlaca(placa);
                alterarDadosDoveiculoDePasseioPelaPlaca(passeio);
            } else {
                cadastrarVeiculoDoMesmoTipo(placa);
            }
        }
    }

    private static void cadastrarVeiculoDoMesmoTipo(String placa) {
        String resposta = "n";
        do {
            System.out.println("Deseja cadastrar o veiculo do mesmo tipo? [s/n]");
            resposta = leitura.entraDados();
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                Passeio passeio = new Passeio();
                passeio.setPlaca(placa);
                passeio = bdVeiculos.buscaVeiculoPasseioPelaPlaca(passeio);
                if (nonNull(passeio)) {
                    passeio = cadastrarOuAtualizarDados(passeio, placa);
                    save(passeio);
                }
            }
        } while (!resposta.equalsIgnoreCase("n") || resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("não"));
    }

    private static void save(Passeio passeio) {
        try {
            bdVeiculos.save(passeio);
        } catch (VeicExisException e) {
            System.out.println("Veiculo placa: " + passeio.getPlaca() + " ja existe");
        }
    }

    private static void save(Carga carga) {
        try {
            bdVeiculos.save(carga);
        } catch (VeicExisException e) {
            System.out.println("Veiculo placa: " + carga.getPlaca() + " ja existe");
        }
    }

    private static Passeio cadastrarOuAtualizarDados(Passeio passeio, String placa) {

        if (nonNull(placa))
            passeio.setPlaca(placa);

        System.out.println("Informe a marca: ");
        resposta = leitura.entraDados();
        passeio.setMarca(resposta);

        if (isNull(passeio.getModelo())) {
            System.out.println("Informe a modelo: ");
            resposta = leitura.entraDados();
            passeio.setModelo(resposta);
        }

        System.out.println("Informe a cor: ");
        resposta = leitura.entraDados();
        passeio.setCor(resposta);

        System.out.println("Informe a quantidade de passageiros: ");
        resposta = leitura.entraDados();
        int qtdPassageiros = parseStringToInteger(resposta);
        passeio.setQtdeDePassageiros(qtdPassageiros);

        System.out.println("Informe a quantidade de rodas: ");
        resposta = leitura.entraDados();
        int qtdePneus = parseStringToInteger(resposta);
        passeio.setQtdeDeRodas(qtdePneus);

        System.out.println("Informe a velocidade maxima em Km/h: ");
        resposta = leitura.entraDados();
        int velMax = parseStringToInteger(resposta);
        passeio.setVelocMax(velMax);

        System.out.println("Informe a quantidade de pistões do motor: ");
        resposta = leitura.entraDados();
        int qtdPistoes = parseStringToInteger(resposta);
        System.out.println("Informe a potência do motor: ");
        resposta = leitura.entraDados();
        int potencia = parseStringToInteger(resposta);
        passeio.setMotor(new Motor(qtdPistoes, potencia));

        return passeio;
    }

    private static Carga cadastrarOuAtualizarDados(Carga carga, String placa) {

        if (nonNull(placa))
            carga.setPlaca(placa);

        System.out.println("Informe a marca: ");
        resposta = leitura.entraDados();
        carga.setMarca(resposta);

        if (isNull(carga.getModelo())) {
            System.out.println("Informe a modelo: ");
            resposta = leitura.entraDados();
            carga.setModelo(resposta);
        }

        System.out.println("Informe a cor: ");
        resposta = leitura.entraDados();
        carga.setCor(resposta);

        System.out.println("Informe a quantidade de passageiros: ");
        resposta = leitura.entraDados();
        int qtdPassageiros = parseStringToInteger(resposta);
//        carga.setQtdeDePassageiros(qtdPassageiros);

        System.out.println("Informe a quantidade de rodas: ");
        resposta = leitura.entraDados();
        int qtdePneus = parseStringToInteger(resposta);
        carga.setQtdeDeRodas(qtdePneus);

        System.out.println("Informe a velocidade maxima em Km/h: ");
        resposta = leitura.entraDados();
        int velMax = parseStringToInteger(resposta);
//        carga.setVelocMax(velMax);

        System.out.println("Informe a quantidade de pistões do motor: ");
        resposta = leitura.entraDados();
        int qtdPistoes = parseStringToInteger(resposta);
        System.out.println("Informe a potência do motor: ");
        resposta = leitura.entraDados();
        int potencia = parseStringToInteger(resposta);
        carga.setMotor(new Motor(qtdPistoes, potencia));

        return carga;
    }


    private static int parseStringToInteger(String resposta) {
        int i = 0;
        try {
            i = Integer.parseInt(resposta);
        } catch (NumberFormatException e) {
            System.out.println("Não foi possivel converter (" + resposta + ") para um numero valido");
            System.out.println("Tente novamente: ");
        }
        return i;
    }
}
