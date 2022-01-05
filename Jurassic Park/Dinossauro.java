
/**
 * Escreva uma descrição da classe Dinossauro aqui.
 *
 * @author (seu nome)
 * @version (um número da versão ou uma data)
 */
public class Dinossauro {
  private int idDinossauro; // corresponde ao ID do dinossauro. Cada dinossauro possui um ID único.
  private String nomeRaca; // corresponde ao nome da raça do dinossauro
  private int tipo; // corresponde ao tipo do dinossauro. 1 para carnívoros, 2 para herbívoros.
  private int categoria;// corresponde a categoria do dinossauro. 1 para Pequeno Porte, 2 para Médio
                        // Porte, 3 para grande porte.
  private double peso;// corresponde ao peso do dinossauro

  public Dinossauro(int idDinossauro, String nomeRaca, int tipo, int categoria, double peso) {
    this.idDinossauro = idDinossauro;
    this.nomeRaca = nomeRaca;
    this.tipo = tipo;
    this.categoria = categoria;
    this.peso = peso;
  }

  public int getIdDinossauro() {
    return idDinossauro;
  }

  public void setIdDinossauro(int idDinossauro) {
    this.idDinossauro = idDinossauro;
  }

  public String getNomeRaca() {
    return nomeRaca;
  }

  public void setNomeRaca(String nomeRaca) {
    this.nomeRaca = nomeRaca;
  }

  public int getCategoria() {
    return categoria;
  }

  public void setCategoria(int categoria) {
    this.categoria = categoria;
  }

  public double getPeso() {
    return peso;
  }

  public int getTipo() {
    return tipo;
  }

  public void setTipo(int tipo) {
    this.tipo = tipo;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  @Override
  public String toString() {
    return "Dinossauro: \n Id: " + idDinossauro + ", Raça: " + nomeRaca + ", Peso: " + peso + ", Tipo: " + tipo
        + ", Categoria: " + categoria;
  }
}
