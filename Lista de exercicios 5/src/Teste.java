/**
 * Alexandre Tiago Ximenes
 */

public class Teste {

    private static BDVeiculos bdVeiculos = new BDVeiculos();
    static String escolha;
    static Leitura leitura = new Leitura();
    static String resposta = null;
    static boolean atualizar = false;
    static boolean cadastrar = false;
    static boolean cadastrarDoMesmoTipo = false;


    public static void main(String[] args) {

        System.out.println("Sistema de gestão de veiculos - Menu inicial");

        do {
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
                    alterarDadosDoveiculoDePasseioPelaPlaca();
                    break;
                case "8":
                    alterarDadosDoveiculoDeCargaPelaPlaca();
                    break;
                default:
                    escolha = "";
            }

        } while (!escolha.equals("9"));
        System.out.println("Finalizou o programa");
    }

    private static void alterarDadosDoveiculoDeCargaPelaPlaca() {
        System.out.println("# Voce escolheu alterar veiculo de carga pela placa");
    }

    private static void alterarDadosDoveiculoDePasseioPelaPlaca() {
        System.out.println("# Voce escolheu alterar veiculo de passeio pela placa");
    }

    private static void imprimirVeiculosDeCargaPelaPlaca() {
        System.out.println("# Imprimindo veiculo de carga pela placa");

    }

    private static void imprimirVeiculosDePasseioPelaPlaca() {
        System.out.println("# Imprimindo veiculo de passeio pela placa");
    }

    private static void imprimirTodosVeiculosDeCarga() {
        System.out.println("# Imprimindo todos os veiculos de carga");
        bdVeiculos.imprimeVeiculosDeCarga();
    }

    private static void imprimirTodosVeiculosDePasseio() {
        System.out.println("# Imprimindo todos os veiculos de passeio");
        bdVeiculos.imprimeVeiculosDePasseio();
    }

    private static void cadastrarVeiculoDeCarga() {
        System.out.println("# Você escolheu cadastrar veiculo de carga");
    }

    private static void cadastrarVeiculoDePasseio() {

        Passeio passeio = new Passeio();

        System.out.println("# Você escolheu cadastrar veiculo de passeio");

        System.out.println("Informe a placa: ");
        String placa = leitura.entraDados();

        int indexVeiculoPasseio = bdVeiculos.buscaVeiculoPasseioPelaPlaca(resposta);

        if (indexVeiculoPasseio >= 0) {
            System.out.println("Veiculo com a placa " + resposta + " já foi cadastrado.");
            do {
                System.out.println("Você quer sobrescrever o veiculo? [s/n]");
                resposta = leitura.entraDados();
                if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {

                    atualizar = true;
                    cadastrar = false;

                } else if (resposta.equalsIgnoreCase("n") || resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("não")) {

                    System.out.println("Deseja cadastrar o veiculo do mesmo tipo? [s/n]");
                    resposta = leitura.entraDados();
                    passeio.setPlaca(placa);

                    if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {

                        atualizar = false;
                        cadastrar = true;

                        Passeio veiculoRecuperadoPeloIndice = bdVeiculos.buscaVeiculoPasseioPeloIndice(indexVeiculoPasseio);
                        passeio.setModelo(veiculoRecuperadoPeloIndice.getModelo());

                    }else{
                        atualizar = false;
                        cadastrar = true;
                        cadastrarDoMesmoTipo = false;
                    }
                }

            } while ((!resposta.equalsIgnoreCase("s") || !resposta.equalsIgnoreCase("n") || !resposta.equalsIgnoreCase("sim") || !resposta.equalsIgnoreCase("nao") || !resposta.equalsIgnoreCase("não")));
        }

        if (placa != null) {
            passeio.setPlaca(placa);
        }

        System.out.println("Informe a marca: ");
        resposta = leitura.entraDados();
        passeio.setMarca(resposta);

        if(passeio.getModelo() == null){
            System.out.println("Informe a modelo: ");
            resposta = leitura.entraDados();
            passeio.setModelo(resposta);
        }

        System.out.println("Informe a cor: ");
        resposta = leitura.entraDados();
        passeio.setCor(resposta);

        System.out.println("Informe a quantidade de rodas: ");
        resposta = leitura.entraDados();
        int qtdePneus = parseStringToInteger(resposta);
        passeio.setQtdeDeRodas(qtdePneus);

        System.out.println("Informe a velocidade maxima: ");
        resposta = leitura.entraDados();
        int velMax = parseStringToInteger(resposta);
        passeio.setVelocMax(velMax);

        if(cadastrar){
            try {
                bdVeiculos.addPasseio(passeio);
            } catch (VeicExisException e) {
                System.out.println("Veiculo placa: " + passeio.getPlaca() + " ja existe");
            }
        }else if(atualizar){
            bdVeiculos.addPasseio(indexVeiculoPasseio, passeio);
        }

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
