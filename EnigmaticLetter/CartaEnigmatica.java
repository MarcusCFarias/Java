
/* Marcus Farias 21201342 Bernado Haab 21200707-4*/

import java.util.Scanner;
import java.util.Random;
import java.lang.String;

public class CartaEnigmatica
{
    public static void main(String[] args) {

        System.out.println("\f");

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o seu nome: ");
        String nomeUsuario = teclado.nextLine();

        while(!validarNome(nomeUsuario))
        {
            System.out.println("Nome inválido, digitar novamente: ");
            nomeUsuario = teclado.nextLine();
        }

        int numeroVogais = contagemVogais(nomeUsuario);

        String fraseCompleta;

        if(numeroVogais % 2 == 0){
            System.out.println("Digite duas frases para compor seu enigma!");

            System.out.println("Primeira frase: ");
            fraseCompleta = teclado.nextLine();

            System.out.println("Segunda frase: ");
            fraseCompleta = fraseCompleta + " " + teclado.nextLine();
        }else{

            System.out.println("Digite três frases para compor seu enigma!");

            System.out.println("Primeira frase: ");
            fraseCompleta = teclado.nextLine();

            System.out.println("Segunda frase: ");
            fraseCompleta = fraseCompleta + " " + teclado.nextLine();

            System.out.println("Terceira frase: ");
            fraseCompleta = fraseCompleta + " " + teclado.nextLine();
        }

        System.out.println("Frase criptografada:");
        System.out.println(criarEnigma(fraseCompleta.trim().toLowerCase()));
        System.out.println("------");

        System.out.println("Qual a lógica por trás da criptografia de suas frases?");
        imprimirOpcoes();
        int opLogica = teclado.nextInt();
        selecionouOpCorreta(opLogica);

    }

    // Verifica se selecinou a opção correta e pergunta novamente
    public static void selecionouOpCorreta(int opLogica) {
        int repeticao = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            switch (opLogica) {
                case 1:
                    System.out.println("Opção incorreta, tente novamente. As opções são: ");
                    imprimirOpcoes();
                    opLogica = teclado.nextInt();
                    break;
                case 2:
                    System.out.println("Parabéns!!! Você acertou o método de criptografia.");
                    return;
                case 3:
                    System.out.println("Opção incorreta, tente novamente. As opções são: ");
                    imprimirOpcoes();
                    opLogica = teclado.nextInt();
                    break;
                default:
                    System.out.println("Opção não encontrada. Selecionde pelos números entre um destas opções: ");
                    imprimirOpcoes();
                    opLogica = teclado.nextInt();
                    repeticao--;
                    break;
            }

            repeticao++;
        } while (repeticao < 2);

        System.out.println("Infelizmente você não conesguiu acertar o método de criptografia");
    }

    //Imprime as opções das formas como as frases podem ter sido criptografadas
    public static void imprimirOpcoes() {
        System.out.println("1) As letras que são criptografadas nas frases são aleatórias e são substituidas");
        System.out.println("2) A cada 3 caracteres uma letra é criptografada (Não podendo criptografar os espaços)");
        System.out.println("3) A cada 3 caracteres uma letra é criptografada (Podendo criptografar os espaços)");
    }

    //Conta a quantidade de vogais no nome (Adaptado de código do Guilherme Gräf Schüler
    public static int contagemVogais(String nomeUsuario)
    {

        int contagemVogais = 0;
        String conjuntoDeVogais = "aáâãäeéêëiíïoóôöõuúüũ";

        for(int i = 0; i < nomeUsuario.length();i++){
            if (conjuntoDeVogais.contains(String.valueOf(nomeUsuario.toLowerCase().charAt(i)))){
                contagemVogais++;
            }
        }

        return contagemVogais;
    }

    // Testa se o nome inserido é válido
    public static boolean validarNome(String frase)
    {
        boolean success = true;
        frase = frase.trim();
        if(frase == null || frase.isEmpty() || !frase.matches("^[A-Za-zaáâãäeéêëiíïoóôöõuúüũçñAÁÂÃÄEÉÊËIÍÏOÓÔÖÕUÚÜŨ ]+")){
            success = false;
        }

        return success;
    }

    // Criptografa as frases
    public static String criarEnigma(String fraseCompleta){

        StringBuilder fraseCompletaModificada = new StringBuilder(fraseCompleta);
        Random r = new Random();

        for(int i = 0; i < fraseCompleta.length(); i = i + 3)
        {
            if(fraseCompleta.charAt(i) != ' '){
              char letraAleatoria = (char)(r.nextInt(26) + 'a');
              fraseCompletaModificada.setCharAt(i, Character.toUpperCase(letraAleatoria));
              }
        }

        fraseCompleta = fraseCompletaModificada.toString();

        return fraseCompleta;
    }
}

