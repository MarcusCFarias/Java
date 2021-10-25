import java.util.Scanner;

/**
 * Escreva uma descrição da classe TrabalhoT2 aqui.
 *
 * @author (seu nome)
 * @version (um número da versão ou uma data)
 */
public class TrabalhoT2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numPrendaCarn, numPrendaVeg, numPeaoCarn, numPeaoVeg, opChurras, quantSalsichao, quantCostela, quantPicanha,
        quantPaoAlho, quantQueijo, quantXixo, quantErvaMate;

    System.out.println("\f");
    System.out.println("Quantas prendas são carnívoras?");
    numPrendaCarn = verificarQuantidade(scanner.nextInt());
    System.out.println("Quantas prendas são vegetarianas?");
    numPrendaVeg = verificarQuantidade(scanner.nextInt());
    System.out.println("Quantos peões são carnívoras?");
    numPeaoCarn = verificarQuantidade(scanner.nextInt());
    System.out.println("Quantos peões são vegetarianos?");
    numPeaoVeg = verificarQuantidade(scanner.nextInt());

    System.out.println(
        "Entre os carnívoros qual das três opções de churrascada ai ser escolhida? \n (1-Tchê Salsichão) (2-Tchê Costela)    (3-Tchê Picanha)");
    opChurras = verificarOpChurras(scanner.nextInt());

    quantSalsichao = getQuantSalsichao(numPrendaCarn, numPeaoCarn, opChurras);
    quantCostela = getQuantCostela(numPrendaCarn, numPeaoCarn, opChurras);
    quantPicanha = getQuantPicanha(numPrendaCarn, numPeaoCarn, opChurras);
    quantPaoAlho = getQuantPaoAlho(numPrendaCarn, numPeaoCarn, numPrendaVeg, numPeaoVeg, opChurras);
    quantQueijo = getQuantQueijo(numPrendaCarn, numPeaoCarn, numPrendaVeg, numPeaoVeg, opChurras);
    quantXixo = getQuantXixo(numPrendaVeg, numPeaoVeg);
    quantErvaMate = getQuantErvaMate(numPrendaCarn + numPeaoCarn, numPrendaVeg + numPeaoVeg);

    System.out.println("Quantidades: ");
    System.out.println("Salsichão: " + quantSalsichao + "g");
    System.out.println("Costela: " + quantCostela + "g");
    System.out.println("Picanha: " + quantPicanha + "g");
    System.out.println("Pão de Alho: " + quantPaoAlho + "un");
    System.out.println("Queijo: " + quantQueijo + "un");
    System.out.println("Xixo: " + quantXixo + "un");
    System.out.println("Erva-mate: " + quantErvaMate + "g");
  }

  private static int getQuantSalsichao(int numPrendaCarn, int numPeaoCarn, int opChurras) {
    int gramasPrenda = opChurras == 1 ? 100 : opChurras == 2 ? 70 : 50;
    int gramasPeao = opChurras == 1 ? 150 : opChurras == 2 ? 100 : 70;
    return (numPrendaCarn * gramasPrenda) + (numPeaoCarn * gramasPeao);
  }

  private static int getQuantCostela(int numPrendaCarn, int numPeaoCarn, int opChurras) {
    int gramasPrenda = opChurras == 2 ? 300 : 200;
    int gramasPeao = opChurras == 2 ? 400 : 300;
    return (numPrendaCarn * gramasPrenda) + (numPeaoCarn * gramasPeao);
  }

  private static int getQuantPicanha(int numPrendaCarn, int numPeaoCarn, int opChurras) {
    int gramasPrenda = opChurras == 1 ? 50 : opChurras == 2 ? 70 : 200;
    int gramasPeao = opChurras == 1 ? 100 : opChurras == 2 ? 130 : 250;
    return (numPrendaCarn * gramasPrenda) + (numPeaoCarn * gramasPeao);
  }

  private static int getQuantPaoAlho(int numPrendaCarn, int numPeaoCarn, int numPrendaVeg, int numPeaoVeg,
      int opChurras) {
    int unidadePrendaCarn = opChurras == 3 ? 1 : 2;
    int unidadePeaoCarn = opChurras == 3 ? 2 : 3;
    return (numPrendaCarn * unidadePrendaCarn) + (numPeaoCarn * unidadePeaoCarn) + (numPrendaVeg * 2) + (numPeaoCarn * 3);
  }

  private static int getQuantQueijo(int numPrendaCarn, int numPeaoCarn, int numPrendaVeg, int numPeaoVeg,
      int opChurras) {
    int unidadePrenda = opChurras == 3 ? 1 : 0;
    int unidadePeao = opChurras == 3 ? 2 : 0;
    return (numPrendaCarn * unidadePrenda) + (numPeaoCarn * unidadePeao) + (numPrendaVeg * 2) + (numPeaoVeg * 3);
  }

  private static int getQuantXixo(int numPrendaVeg, int numPeaoVeg) {
    return (numPrendaVeg * 1) + (numPeaoVeg * 2);
  }

  private static int getQuantErvaMate(int quantTotalPrenda, int quantTotalPeao) {
    return (quantTotalPrenda * 50) + (quantTotalPeao * 70);
  }

  private static int verificarQuantidade(int num) {
    Scanner scanner = new Scanner(System.in);

    while (num < 0) {
      System.out.println("Valor inválido, insira um valor positivo");
      num = scanner.nextInt();
    }
    return num;
  }

  private static int verificarOpChurras(int num) {
    Scanner scanner = new Scanner(System.in);

    while (!(num == 1 || num == 2 || num == 3)) {
      System.out.println("Valor inválido, selecione uma das opções");
      num = scanner.nextInt();
    }
    return num;
  }

}
