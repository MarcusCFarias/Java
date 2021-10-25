----------------------------------------------------------------------------
Este é o arquivo README do projeto. Você deve descrever aqui o seu projeto.
Informe ao usuário (alguém que não sabe nada sobre este projeto!) tudo que
ele/ela precisa saber. Os comentários devem incluir, pelo menos:
------------------------------------------------------------------------

TÍTULO DO PROJETO: Carta Enigmática
OBJETIVO DO PROJETO: Criptografar uma frase dada pelo usuário e ele mesmo descobrir o critério
VERSÃO ou DATA: 06/10/2021

AUTORES: Marcus Farias 21201342 Bernado Haab 21200707-4

APRENDIZADO:

- TRABALHO EM EQUIPE E SINTAXE NOVA E USO DE REGEX PARA MATCH

DIFICULDADES

- USAR O REGEX PARA O ALFABETO

DESCRIÇÃO CÓDIGO:

O código começa pedindo um nome válido para o usuário, a partir disso, ele calcula o número de vogais. Caso a soma de vogais seja par, o usuário escreve duas frases, caso seja ímpar, o usuário escreve três frases. Após esse processo, as frases são criptografadas e, abaixo, está sendo explicada a criptografia no método "criarEnigma()". Por último, o usuário tem 3 tentativas para acertar uma das opções de como é feita a criptografia.

- criarEnigma()
-- esse método transforma as frases do usuário em criptografias. Basicamente, ele percorre a string e vai substituindo com letras aleatorias de 3 em 3 espaços, contando os espaços, mas não preenchendo-os.

- validarNome()
-- só permite um conjunto de letras como nome

- contagemVogais()
-- conta o numero de vogais que tem no nome

- imprimirOpcoes()
-- expõe na tela o menu de opções para o usuário digitar. Foi transformado em método para reduzir a repetição de código.

- selecionouOpCorreta()
-- método para verificar se usuário selecionou a opção correta de como a criptografia foi feita. Recebe a opção selecionada, caso seja a opção correta congratula o usuário, e sai do método. Caso seja uma das opções possíveis, porém errada, informa o usuário e se este ainda tiver chance de responder (não tenha tentando três vezes), pergunta novamente a forma de criptografia. Caso a opção inserida não seja válida informa o usuário e repete a pergunta, descontando a tentativa com opção inválida.

REFERÊNCIAS UTILIZADAS:

- https://stackoverflow.com/questions/2626835/is-there-functionality-to-generate-a-random-character-in-java

- https://moodle.pucrs.br/mod/forum/discuss.php?d=602060

- https://pt.stackoverflow.com/questions/35281/verificar-se-a-string-%C3%A9-nula-ou-vazia

