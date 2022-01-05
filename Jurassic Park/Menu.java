import java.util.Scanner;

/**
Autores: Marcus Farias 212013429
Bernado Haab 212007074
 */
public class Menu {
  public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);

    System.out.println("Bem Vindo ao Jurassic Zoo!");
    System.out.println("Gostaria de Cadastrar algum dinossauro? Digite 'S' para 'Sim' e 'N' para 'Não' ");

    String respostaUsuario = teclado.nextLine();
    int numDinossaurosCadastrados = 3, tamanhoLateralParque = 0;
    int[][] posicoesParque;

    while (!respostaUsuario.equals("S") && !respostaUsuario.equals("N")) {
      System.out.println("Opção Incorreta! Digite novamente: ");
      respostaUsuario = teclado.nextLine();
    }

    if (respostaUsuario.equals("S")) {
      System.out.println("Quantos dinossauros deseja cadastrar?");
      numDinossaurosCadastrados = numDinossaurosCadastrados + teclado.nextInt();
      teclado.nextLine();
    }

    System.out.println("Informe o tamanho da lateral do parque:");
    tamanhoLateralParque = teclado.nextInt();
    while (numDinossaurosCadastrados > tamanhoLateralParque * tamanhoLateralParque) {
      System.out.println("Área muito pequena! Insira novamente o tamanho da lateral do parque:");
      tamanhoLateralParque = teclado.nextInt();
    }
    posicoesParque = new int[tamanhoLateralParque][tamanhoLateralParque];

    CadastroDinossauro cadastroDinossauro = new CadastroDinossauro(numDinossaurosCadastrados);

    Dinossauro dinossauro1 = new Dinossauro(1, "T-Rex", 1, 3, 5000);
    cadastroDinossauro.adicionarDinossauro(dinossauro1);
    posicoesParque[1][1] = dinossauro1.getIdDinossauro();
    Dinossauro dinossauro2 = new Dinossauro(2, "Velociraptor", 1, 2, 90);
    cadastroDinossauro.adicionarDinossauro(dinossauro2);
    posicoesParque[2][2] = dinossauro2.getIdDinossauro();
    Dinossauro dinossauro3 = new Dinossauro(3, "Braquiossauro", 2, 3, 50000);
    cadastroDinossauro.adicionarDinossauro(dinossauro3);
    posicoesParque[3][3] = dinossauro3.getIdDinossauro();

    for (int i = 4; i < cadastroDinossauro.cadastroDinossauros.length + 1; i++) {
      System.out.println("Digite o nome: ");
      teclado.nextLine();
      String nomeNovoDinossauro = teclado.nextLine();
      System.out.println("Digite o tipo (1 para carnívoros, 2 para herbívoros): ");
      int tipoDinossauro = validarTipoDinossauro(teclado.nextInt());
      teclado.nextLine();
      System.out.println("Digite a categoria (1 para Pequeno Porte, 2 para Médio Porte, 3 para grande porte): ");
      int categoriaDinossauro = validarCategoriaDinossauro(teclado.nextInt());
      teclado.nextLine();
      System.out.println("Digite o peso (kg): ");
      double pesoDinossauro = validarPesoDinossauro(teclado.nextDouble());
      teclado.nextLine();

      System.out.println("Qual a coluna que o dinossauro está?");
      int coluna = teclado.nextInt();
      System.out.println("Qual a linha que o dinossauro está?");
      int linha = teclado.nextInt();

      while (posicoesParque[linha][coluna] != 0) {
        System.out.println("Posição já ocupada!");
        System.out.println("Escolha novamente uma coluna:");
        coluna = teclado.nextInt();
        System.out.println("Escolha novamente uma linha:");
        linha = teclado.nextInt();
      }

      posicoesParque[linha][coluna] = i;

      Dinossauro novoDinossauro = new Dinossauro(i, nomeNovoDinossauro, tipoDinossauro, categoriaDinossauro,
          pesoDinossauro);

      cadastroDinossauro.adicionarDinossauro(novoDinossauro);
    }

    Relatorios relatorios = new Relatorios(cadastroDinossauro.cadastroDinossauros);

    int opMenu = 0;

    do {
      for (int i = 0; i < posicoesParque.length; i++) {
        for (int j = 0; j < posicoesParque[i].length; j++) {
          System.out.printf(posicoesParque[i][j] + " - ");
        }
        System.out.println("\n");
      }

      imprimirMenu();

      opMenu = teclado.nextInt();
      System.out.println("\n");

      switch (opMenu) {
      case 1:
        String qtdAnimais = relatorios.qtdAnimaisDeCadaTipoECategoria();
        System.out.println(qtdAnimais);
        break;
      case 2:
        System.out.println("Qual o tipo do dinossauro? (1 para carnívoros, 2 para herbívoros)");
        int tipo = teclado.nextInt();
        System.out
            .println("Qual a categoria do dinossauro? (1 para Pequeno Porte, 2 para Médio Porte, 3 para grande porte)");
        int categoria = teclado.nextInt();

        Dinossauro dinossauroPesado = relatorios.pesoPesado(tipo, categoria);
        if (dinossauroPesado == null) {
          System.out.println("Nenhum dinossauro encontrado com este tipo e categoria");
        } else {
          System.out.println(dinossauroPesado.toString());
        }
        break;
      case 3:
        double qtdCarne = relatorios.qtdCarne();
        System.out.println("Devem ser comprados " + qtdCarne + "Kg por mês");
        break;
      case 4:
        System.out.println("Qual a distância do dinossauro para o bunker? (em km)");
        double distanciaDinossauro = teclado.nextDouble();
        System.out.println("Qual a distância entre a pessoa e o bunker (em km)");
        double distanciaPessoa = teclado.nextDouble();
        System.out.println("Qual a velocidade média do dinossauro (em km/h)");
        double velocidadeDinossauro = teclado.nextDouble();

        boolean consegueFugir = relatorios.podeFugir(distanciaDinossauro, distanciaPessoa, velocidadeDinossauro);
        String consegueFugirString = (consegueFugir) ? "consegue" : "não consegue";

        System.out.println("Nestas condições a pessoa " + consegueFugirString + " fugir");
        break;
      case 5:
        String zonaPerigosa = relatorios.zonaPerigosa(posicoesParque, cadastroDinossauro);
        System.out.println("A zona mais perigosa é a " + zonaPerigosa);
        break;

      case 0:
        System.out.println("Programa encerrado.");
        break;

      default:
        System.out.println("Código não encontrado, por favor insira um número referente uma das opção!");
        break;
      }

    } while (opMenu != 0);

    System.out.println(relatorios.qtdCarne());

  }

  private static void imprimirMenu() {
    System.out.println("\n");
    System.out.println("Escolha uma das opções da lista e informe o número referente!");
    System.out.println("(1) Quantidade de animais de cada tipo e categoria");
    System.out.println("(2) Peso Pesado (O dinossauro mais pesado da categiria e tipo indicado)");
    System.out.println("(3) Quantidade de carne para carnívoros");
    System.out.println("(4) Dá tempo de fugir?");
    System.out.println("(5) Zonas perigosas do parque");
    System.out.println("(0) Sair");
  }

  private static int validarTipoDinossauro(int numTipo) {

    Scanner teclado = new Scanner(System.in);

    while (numTipo > 2 || numTipo < 1) {
      System.out.println("Tipo inválido, 1 = Carnívoro, 2 = Herbívoro");
      numTipo = teclado.nextInt();
    }

    return numTipo;
  }

  private static int validarCategoriaDinossauro(int numCategoria) {

    Scanner teclado = new Scanner(System.in);

    while (numCategoria > 3 || numCategoria < 1) {
      System.out.println("Categoria inválida, 1 = pequeno, 2 = médio, 3 = grande");
      numCategoria = teclado.nextInt();
    }

    return numCategoria;
  }

  private static double validarPesoDinossauro(double numPeso) {

    Scanner teclado = new Scanner(System.in);

    while (numPeso < 0) {
      System.out.println("Peso Inválido!");
      numPeso = teclado.nextDouble();
    }

    return numPeso;
  }
}
