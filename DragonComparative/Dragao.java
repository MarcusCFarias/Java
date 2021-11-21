import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Escreva uma descrição da classe T4 aqui.
 *
 * @autores Bernardo Luzi Haab e Marcus Farias;
 * @data 06/11/2021
 */

public class Dragao {
  private double pesoAtual;
  private double pesoInicial;
  private String nome;
  private Date dataNasc;
  private Date dataConsulta;
  private double lufada;

  public Dragao(double pesoInicial, String nome, Date dataNasc) {
    this.pesoInicial = pesoInicial;
    this.nome = nome;
    this.dataNasc = dataNasc;
    Calendar cal = Calendar.getInstance();
    cal.set(992, Calendar.NOVEMBER, 17);
    dataConsulta = cal.getTime();
    atualizaPesoAtual();
    this.lufada = lufada();
  }

  private void atualizaPesoAtual() {

    long semanas = ChronoUnit.WEEKS.between(dataNasc.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
        dataConsulta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

    pesoAtual = pesoInicial;

    for (int i = 1; i <= semanas; i++) {

      pesoAtual = pesoAtual * (1 + 0.05);
    }

    if (pesoAtual > 5000) {
      pesoAtual = 5000;
    }
  }

  public double lufada() {
    double tamanhoLufada = 0.0;

    if (this.pesoAtual >= 500) {
      tamanhoLufada = 20;

      double diferencaDePeso = pesoInicial < 500 ? pesoAtual - 500 : pesoAtual - pesoInicial;

      double quantasALufadaAumentou =  Math.floor((diferencaDePeso) / 100);

      for (int i = 1; i <= quantasALufadaAumentou; i++) {

        tamanhoLufada = tamanhoLufada * (1 + 0.05);
      }
    }
 
    return tamanhoLufada;
  }

  public double getLufada() {
    return this.lufada;
  }

  public Date getDataNasc() {
    return dataNasc;
  }

  public String getFormattedNasc() {
    SimpleDateFormat Formatter = new SimpleDateFormat("dd/MM/yyyy");
    return Formatter.format(dataNasc);
  }

  public String getNome() {
    return nome;
  }

  public double getPeso() {
    return pesoAtual;
  }

  public double getPesoInicial() {
    return pesoInicial;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPesoInicial(double pesoInicial) {
    this.pesoInicial = pesoInicial;
  }

  @Override
  public String toString() {
    return ("Dragão: " + nome + ", Peso atual:" + pesoAtual + ", Peso no Nascimento: " + pesoInicial
        + ", Data de Nascimento: " + getFormattedNasc() + ", Lufada: " + getLufada());
  }
}
