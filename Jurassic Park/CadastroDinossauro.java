
/**
 * Escreva uma descrição da classe CadastroDinossauro aqui.
 *
 * @author (seu nome)
 * @version (um número da versão ou uma data)
 */
public class CadastroDinossauro {

  Dinossauro[] cadastroDinossauros;
  private int proximaPosicao;

  public CadastroDinossauro(int numDinossauros) {

    cadastroDinossauros = new Dinossauro[numDinossauros];
    proximaPosicao = 0;
  }

  public boolean adicionarDinossauro(Dinossauro dino) {

    if (proximaPosicao < cadastroDinossauros.length) {
      cadastroDinossauros[proximaPosicao] = dino;
      proximaPosicao++;
      return true;
    } else
      return false;
  }

  public Dinossauro pesquisarDinossauro(int id) {

    for (int i = 0; i < proximaPosicao; i++) {
      if (cadastroDinossauros[i].getIdDinossauro() == id) {
        return cadastroDinossauros[i];
      }
    }
    return null;
  }

  public boolean removerDinossauro(int id) {

    for (int i = 0; i < proximaPosicao; i++) {
      if (cadastroDinossauros[i].getIdDinossauro() == id) {

        cadastroDinossauros[i] = null;
        for (int j = i; j < proximaPosicao; j++) {

          cadastroDinossauros[j] = cadastroDinossauros[j + 1];
        }

        cadastroDinossauros[proximaPosicao] = null;
        proximaPosicao--;
        return true;
      }
    }
    return false;
  }
}
