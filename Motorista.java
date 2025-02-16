import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;
public class Motorista implements Serializable{
    private String nome = new String(); 
    private int idade, cnh, porcenCom;
    private double salFixo, kmIni, kmFim, valorFrete, pesoCarga;
    private Date dataAdm = new Date();
    private Date dataDem = new Date();
    private String senhaMotorista = new String();
    private Caminhao[] caminhao;
    private String placa = new String();
    private String origem, destino, carregamento;

    private Abastecimento[] abastecimento;
    private Viagem viagem;

    // Construtor
    public Motorista(String nome, int idade, int cnh, Date dataAdm, Date dataDem, 
    int porcenCom, double salFixo, String senhaMotorista) {
        this.nome = nome;
        this.idade = idade;
        this.cnh = cnh;
        this.dataAdm = dataAdm;
        this.dataDem = dataDem;
        this.porcenCom = porcenCom;
        this.salFixo = salFixo;
        this.senhaMotorista = senhaMotorista;
        for(int i=0; i<caminhao.length;i++){
            if(caminhao[i].getEmUso() == false){
                this.placa = caminhao[i].getPlaca();
                caminhao[i].setEmUso(true);
                break;
            }
            System.out.println("Não é possível adicionar novo motorista, pois todos os caminhões estão em uso!");
        }
    }

    public Motorista(String nome, int idade, int cnh, Date dataAdm, 
    int porcenCom, double salFixo, String senhaMotorista){
        this(nome, idade, cnh, dataAdm, null, porcenCom, salFixo, senhaMotorista);
    }//inicializar aqui os vetores de manutenção, viagem e abastecimento

    public Motorista(){// naõ seria melhor botar a parada de null que nem no de cima, dataDem, prar todos os parâmetros nesse?
        for(int i=0; i<caminhao.length;i++){
            if(caminhao[i].getEmUso() == false){
                this.placa = caminhao[i].getPlaca();
                caminhao[i].setEmUso(true);
                break;
            }
            System.out.println("Não é possível adicionar novo motorista, pois todos os caminhões estão em uso!");
        }
    }

    public String getNome() {// Função para pegar o nome do motorista.
        return this.nome;
    }

    public int getIdade() {// Função para pegar a idade do motorista.
        return this.idade;
    }

    public int getCnh() {// Função para pegar a CNH do motorista.
        return this.cnh;
    }

    public Date getDataAdm() {// Função para pegar a data de admissão do motorista.
        return this.dataAdm;
    }

    public Date getDataDem() {// Função para pegar a data de demissao do motorista.
        return this.dataDem;
    }

    public String getPlacaMot() {// Função para pegar a placa do caminhao que o motorista trabalha
        return this.placa;
    }

    public int getPorcenCom() {// Função para pegar a porcentagem de comissão do motorista.
        return this.porcenCom;
    }

    public double getSalFixo() {// Função para pegar o salário fixo do motorista.
        return this.salFixo;
    }

    public String getSenhaMotorista() {// Função para pegar a senha do motorista.
        return this.senhaMotorista;
    }

    public void setDataDem(Date novaDem) {//Função que vai definir a data de demissão do motorista
        this.dataDem = novaDem;
    }

    public double calcularValorFrete(){  //calcula o valor do total do frete da viagem
        double valorTotalFrete;
        valorTotalFrete = viagem.getPesoCarga() * viagem.getValorTonelada(); 
        viagem.setValorFrete(valorTotalFrete);

        return valorFrete;
    }

    public void registrarViagem(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Origem: ");
        origem = teclado.nextLine();
        System.out.println("Destino: ");
        destino = teclado.nextLine();
        System.out.println("Carregamento: ");
        carregamento = teclado.nextLine();
        System.out.println("Km Inicial: ");
        kmIni = teclado.nextDouble();
        System.out.println("Km Final: ");
        kmFim = teclado.nextDouble();
        System.out.println("Valor do Frete por Tonelada: ");
        valorFrete = teclado.nextDouble();
        System.out.println("Peso da Carga: ");
        pesoCarga = teclado.nextDouble();
    }

    public double calcularComissaoViagem(){

        return comissaoViagem;
    }
    
    public void registrarDespesas(){
        Scanner teclado = new Scanner (System.in);
        String opcao;
        boolean saida=false;

        do{
            System.out.println ("..:: Menu Interativo Registrar Despesas:..");
            System.out.println ("(a) Para Registrar Abastecimento ");
            System.out.println ("(b) Para Registrar Manutenção " );
            System.out.println ("(c) Sair da Aplicação");
            System.out.println("Entre com uma opção do menu: ");
            opcao = teclado.nextLine( );

            switch(opcao){
                case "a":
                    registrarAbastecimento();
                    break;
                case "b":
                    registrarManutencao();
                    break;
                case "c":
                    System.out.println ("Saindo");
                    saida=true;
                    break;
                default :
                    System.out.println ("Opcao invalida. Tente novamente");
            }
        }while(saida==false);
        teclado.close();
    }

    public void registrarAbastecimento(){
        Scanner teclado= new Scanner(System.in);

        System.out.println("Posto: ");
        nome = teclado.nextLine();
        System.out.println("Litragem Abastecido: ");
        litragem = teclado.nextDouble();
        System.out.println("Valor Abastecido: ");
        valor = teclado.nextDouble();
        System.out.println("Data de Abastecimento: ");
        data = teclado.nextLine();

        abastecimento[] = new Abastecimento(nome, litragem, valor, data);
        
    }

    public void registrarManutencao(){
        Scanner teclado= new Scanner(System.in);
    }

    public void gerarHolerite(){
        
    }

    public double calcularSomaSalCom(){
        return somaSalCom;
    }

}