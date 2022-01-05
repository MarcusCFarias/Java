// import org.jcp.xml.dsig.internal.dom.DOMSignatureMethod;

/**
 * Escreva uma descrição da classe Relatorios aqui.
 *
 * @author (seu nome)
 * @version (um número da versão ou uma data)
 */
public class Relatorios {
  private int numCarnivorosPequenoPorte = 0;
  private int numCarnivorosMedioPorte = 0;
  private int numCarnivorosGrandePorte = 0;
  private int numHerbivorosPequenoPorte = 0;
  private int numHerbivorosMedioPorte = 0;
  private int numHerbivorosGrandePorte = 0;
  Dinossauro[] dinossauros;

  public Relatorios(Dinossauro[] dinossauros) {
    this.dinossauros = dinossauros;

  }

  public boolean podeFugir(double distanciaDinossauro, double distanciaPessoa, double velocidadeDinossauro) {
    double velocidadePessoa = 20;

    double tempoPessoa = distanciaPessoa / velocidadePessoa;
    double tempoDinossauro = distanciaDinossauro / velocidadeDinossauro;

    if (tempoPessoa < tempoDinossauro) {
      return true;
    }

    return false;
  }

  public String zonaPerigosa(int[][] terrenoParque, CadastroDinossauro cadastroDinossauro) {

    int metadeParque = (int) Math.floor(terrenoParque.length / 2);
    int qtdSul = 0, qtdNorte = 0;
    String zonaPerigosa = "Sul";

    for (int i = 0; i <= metadeParque; i++) {
      for (int j = 0; j < terrenoParque[i].length; j++) {

        Dinossauro dinoCarnivoro = cadastroDinossauro.pesquisarDinossauro(terrenoParque[i][j]);

        if(dinoCarnivoro != null){
          if(dinoCarnivoro.getTipo() == 1){
            qtdNorte++;
          }
        }
      }
    }

    for (int i = metadeParque + 1; i < terrenoParque.length; i++) {
      for (int j = 0; j < terrenoParque[i].length; j++) {

        Dinossauro dinoCarnivoro = cadastroDinossauro.pesquisarDinossauro(terrenoParque[i][j]);

        if(dinoCarnivoro != null){
          if(dinoCarnivoro.getTipo() == 1){
            qtdSul++;
          }
        }
      }
    }

    if (qtdNorte > qtdSul) {
      zonaPerigosa = "Norte";
    }
    return zonaPerigosa;
  }

  public Dinossauro pesoPesado(int tipo, int categoria) {
    Dinossauro[] dinossaurosfiltrado = new Dinossauro[dinossauros.length];
    int posicao = 0;

    for (int i = 0; i < dinossauros.length; i++) {
      boolean eValido = dinossauros[i].getTipo() == tipo && dinossauros[i].getCategoria() == categoria;
      if (eValido) {
        dinossaurosfiltrado[posicao] = dinossauros[i];
        posicao++;
      }
    }

    if (posicao == 0) {
      return null;
    }

    Dinossauro dinossauroPesado = dinossaurosfiltrado[0];

    for (int i = 0; i < posicao; i++) {
      if (dinossauroPesado.getPeso() < dinossaurosfiltrado[i].getPeso()) {
        dinossauroPesado = dinossaurosfiltrado[i];
      }
    }

    return dinossauroPesado;
  }

  public String qtdAnimaisDeCadaTipoECategoria() {
    String relatorio = "";

    for (int i = 0; i < dinossauros.length; i++) {
      if (dinossauros[i].getTipo() == 1) {
        switch (dinossauros[i].getCategoria()) {
        case 1:
          this.numCarnivorosPequenoPorte++;
          break;
        case 2:
          this.numCarnivorosMedioPorte++;
          break;
        case 3:
          this.numCarnivorosGrandePorte++;
          break;
        }
      } else {
        switch (dinossauros[i].getCategoria()) {
        case 1:
          this.numHerbivorosPequenoPorte++;
          break;
        case 2:
          this.numHerbivorosMedioPorte++;
          break;
        case 3:
          this.numHerbivorosGrandePorte++;
          break;
        }
      }
    }

    relatorio = "Carnívoros: PP: " + this.numCarnivorosPequenoPorte + " MP: " + this.numCarnivorosMedioPorte + " GP: "
        + this.numCarnivorosGrandePorte;
    relatorio = relatorio + " Herbívoros: PP: " + this.numHerbivorosPequenoPorte + " MP: "
        + this.numHerbivorosMedioPorte + " GP: " + this.numHerbivorosGrandePorte;
    return relatorio;
  }

  public double qtdCarne() {
    double qtdCarne = 0;

    for (int i = 0; i < dinossauros.length; i++) {

      if (dinossauros[i].getTipo() == 1) {
        if (dinossauros[i].getCategoria() == 1) {
          qtdCarne += dinossauros[i].getPeso() * 10 / 100;

        } else if (dinossauros[i].getCategoria() == 2) {
          qtdCarne += dinossauros[i].getPeso() * 15 / 100;
        } else {
          qtdCarne += dinossauros[i].getPeso() * 20 / 100;
        }
      }
    }

    return qtdCarne * 30;
  }
}
