import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Escreva uma descrição da classe T4 aqui.
 *
 * @autores Bernardo Luzi Haab e Marcus Farias;
 * @data 06/11/2021
 */
public class T4 {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    int quantDrag, opMenu = 0;
    Dragao[] listaDragoes = new Dragao[6];

    System.out.println("Quantos dragões você deseja criar?");
    quantDrag = verificaQuantDrag(teclado.nextInt());

    for (int i = 0; i < quantDrag; i++) {
      String nome;
      Date dataNasc = null;
      double peso;

      System.out.println("Cadastro do " + (i + 1) + "° dragão. ");

      System.out.println("Nome do dragão: ");
      teclado.nextLine();
      nome = teclado.nextLine();

      System.out.println("Peso do dragão no nascimento (em Kg):");
      peso = verificarPeso(teclado.nextDouble());

      // verificar se o ano é bisexto
      boolean dataValida = false;
      while (dataValida == false) {

        System.out.println("Defina a data de nascimento do dragão:");
        System.out.println("Digite o ano:");
        int anoNasc = teclado.nextInt();
        System.out.println("Digite o mês:");
        int mesNasc = teclado.nextInt();
        System.out.println("Digite o dia:");
        int diaNasc = teclado.nextInt();

        Calendar cal = Calendar.getInstance();
        cal.set(anoNasc, mesNasc - 1, diaNasc);
        dataNasc = cal.getTime();

        dataValida = verificarDataNascimentoDragao(anoNasc, mesNasc, diaNasc);
      }

      Dragao dragao = new Dragao(peso, nome, dataNasc);
      listaDragoes[i] = dragao;
    }

    for (int i = quantDrag; i < listaDragoes.length; i++) {
      Dragao novoDragao = getDragaoAleatorio(i);
      listaDragoes[i] = novoDragao;
    }

    do {
      System.out.println("\n");
      System.out.println("Escolha uma das opções da lista e informe o número referente!");
      System.out.println("(1) Imprimir informações dos dragões cadastrados");
      System.out.println("(2) Escrever  o  nome  do  dragão  mais  perigoso  (cospe  mais  fogo  e destrói mais)");
      System.out.println("(3) Media do peso dos dragões");
      System.out.println("(4) Dragão mais leve ao nascer");
      System.out.println("(5) Primeiro dragão a nascer dos 6 cadastrados");
      System.out.println("(0) Sair");

      opMenu = teclado.nextInt();
      System.out.println("\n");

      switch (opMenu) {
      case 1:
        imprimeDragoes(listaDragoes);
        break;
      case 2:
        dragaoPerigoso(listaDragoes);
        break;
      case 3:
        mediaPesoDragoes(listaDragoes);
        break;
      case 4:
        dragaoLeveNasc(listaDragoes);
        break;
      case 5:
        dragaoVelho(listaDragoes);
        break;

      case 0:
        System.out.println("Programa encerrado.");
        break;

      default:
        System.out.println("Código não encontrado, por favor insira um número referente uma das opção!");
        break;
      }

    } while (opMenu != 0);

  }

  private static int verificaQuantDrag(int quantDrag) {
    Scanner teclado = new Scanner(System.in);
    int quantDragFinal = quantDrag;

    while (quantDragFinal < 1 || quantDragFinal > 3) {
      System.out.println("Você deve cadastrar no mínimo 1 dragão e no máximo 3!!");
      System.out.println("Informe novamente o númerod e drgões que quer cadastrar:");
      quantDragFinal = teclado.nextInt();
    }

    return quantDragFinal;
  }

  private static void imprimeDragoes(Dragao[] listaDragoes) {
    System.out.println("Informação de todos os dragões:");
    for (int i = 0; i < listaDragoes.length; i++) {
      System.out.println(listaDragoes[i]);
    }
  }

  private static void dragaoPerigoso(Dragao[] listaDragoes) {
    
    Dragao dragaoMaisPerigoso = listaDragoes[0];

    for (int i = 1; i < listaDragoes.length; i++) {

      Dragao dragaoAtual = listaDragoes[i];

      if(dragaoMaisPerigoso.getLufada() < dragaoAtual.getLufada()){
        dragaoMaisPerigoso = dragaoAtual;
      }
    }

    System.out.println("Dragão mais perigoso:");
    System.out.println(dragaoMaisPerigoso.getNome());
  }

  private static void mediaPesoDragoes(Dragao[] listaDragoes) {
    double somaPesoDragoes = 0.0;
    for (int i = 0; i < listaDragoes.length; i++) {
      somaPesoDragoes = somaPesoDragoes + listaDragoes[i].getPeso();
    }

    System.out.println("Média do peso dos Dragões:");
    System.out.println(somaPesoDragoes / listaDragoes.length);
  }

  private static void dragaoLeveNasc(Dragao[] listaDragoes) {
    Dragao dragaoMaisLeve = listaDragoes[0];

    for (int i = 1; i < listaDragoes.length; i++) {

      Dragao dragaoAtual = listaDragoes[i];

      if(dragaoMaisLeve.getPesoInicial() > dragaoAtual.getPesoInicial()){
        dragaoMaisLeve = dragaoAtual;
      }
    }

    System.out.println("Dragão mais leve ao nascer:");
    System.out.println(dragaoMaisLeve.getNome());
  }

  private static void dragaoVelho(Dragao[] listaDragoes) {
    Dragao dragaoMaisVelho = listaDragoes[0];

    for (int i = 1; i < listaDragoes.length; i++) {

      Dragao dragaoAtual = listaDragoes[i];

      if(dragaoMaisVelho.getDataNasc().getTime() > dragaoAtual.getDataNasc().getTime()){
        dragaoMaisVelho = dragaoAtual;
      }
    }

    System.out.println("Primeiro dragão a nascer:");
    System.out.println(dragaoMaisVelho.getNome());
  }

  private static Dragao getDragaoAleatorio(int id) {
    String nomeDragao = "Dragão aleatório" + id;
    double pesoDragao = (Math.random() * (5000 - 20)) + 20;
    Date dataNasc = null;
    int anoNasc = ThreadLocalRandom.current().nextInt(872, 992);
    int mesNasc = ThreadLocalRandom.current().nextInt(1, 12);
    int diaNasc = 0;

    boolean dataValida = false;
    while (dataValida == false) {

      diaNasc = ThreadLocalRandom.current().nextInt(1, 31);
      dataValida = verificarDataNascimentoDragao(anoNasc, mesNasc, diaNasc);
    }

    Calendar cal = Calendar.getInstance();
    cal.set(anoNasc, mesNasc - 1, diaNasc);
    dataNasc = cal.getTime();

    Dragao dragao = new Dragao(pesoDragao, nomeDragao, dataNasc);

    return dragao;

  }

  private static boolean verificarDataNascimentoDragao(int ano, int mes, int dia) {

    boolean success = true;

    int anoMinimo = 872;
    int anoMaximo = 992;
    int mesLimite = 11;
    int diaLimite = 17;

    if (ano >= anoMinimo && ano <= anoMaximo) {

      if ((ano == anoMinimo && mes < mesLimite) || (ano == anoMinimo && mes == mesLimite && dia < diaLimite)
          || (ano == anoMaximo && mes > mesLimite) || (ano == anoMaximo && mes == mesLimite && dia > diaLimite)) {

        System.out.println("A data de nascimento deve ser entre 872/11/17 e 992/11/17");
        success = false;

      } else {
        if ((mes > 0 && mes <= 12)) {
          if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            if (dia < 1 || dia > 31) {
              System.out.println("Dia inválido! (Dia menor do que 1 ou maior do que 31)");
              success = false;
            }
          } else {
            if (mes == 2) {
              if (anoBissexto(ano)) {
                if (dia < 1 || dia > 29) {
                  System.out.println("Dia inválido! (Dia menor do que 1 ou maior do que 29 no mês de fevereiro)");
                  success = false;
                }
              } else {
                if (dia < 1 || dia > 28) {
                  System.out.println("Dia inválido! (Dia menor do que 1 ou maior do que 28 no mês de fevereiro)");
                  success = false;
                }
              }
            } else {
              if (dia < 1 || dia > 30) {
                System.out.println("Dia inválido! (Dia menor do que 1 ou maior do que 30)");
                success = false;
              }
            }
          }
        } else {
          System.out.println("Mês Inválido!");
          success = false;
        }
      }

    } else {
      System.out.println("Ano Inválido. 872 a 972");
      success = false;
    }

    return success;
  }

  public static boolean anoBissexto(int ano) {
    if (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0)) {
      return true;
    } else {
      return false;
    }
  }

  private static double verificarPeso(double peso) {
    Scanner teclado = new Scanner(System.in);
    double pesoVerificado = peso;

    while (pesoVerificado < 20 || pesoVerificado > 5000) {
      System.out.println("O peso mínimo do dragão é 20kg e o máximo é 5000kg, informe novamente:");
      pesoVerificado = teclado.nextDouble();
    }

    return pesoVerificado;
  }
}
