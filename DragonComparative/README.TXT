----------------------------------------------------------------------------
Este é o arquivo README do projeto. Você deve descrever aqui o seu projeto.
Informe ao usuário (alguém que não sabe nada sobre este projeto!) tudo que
ele/ela precisa saber. Os comentários devem incluir, pelo menos:
------------------------------------------------------------------------

AUTORES: Bernardo Luzi Haab e Marcus Farias;
DATA: 06/11/2021;

MATERIAIS CONSULTADOS:
  https://www.leveluplunch.com/java/examples/number-of-weeks-between-two-dates/
  https://dzone.com/articles/practical-guide-for-converting-between-date-and-te
  https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
  https://stackoverflow.com/questions/3680637/generate-a-random-double-in-a-range#3680648
  https://moodle.pucrs.br/mod/forum/discuss.php?d=597185 (Gulherme Graf)

EXPLICAÇÃO:

  O sistema pergunta ao usuário (Dany) quantos dragões deseja cadastrar, tendo limite mínimo de 1 e máximo de 3.
  Então o usuário cria o número de dragões desejados, e este é adicionado a uma lista de dragões.
  Após este cadastro, são adicionados dragões com informações aleatórias até que a lista atinga o tamanho de 6 dragões.
  Os dragões são cadastrados inicialmente com nome, peso de nascimento, e data de nascimento. Com estes dados
  é criado o peso atual do dragão, considerado a data de nascimento cadastrada e a data de consulta (177/11/992).
  A data de nascimento é primeiramente tratada como 3 informações separadas - ano, mês, e dia - que são unidas em um objeto.
  Na geração de dragões aleatórios é gerado um ano aleatório entre 872 e 992, após é criada uma data aleatória de onde se extrai
  o dia e o mês, estas informações são unidas e testadas, para garantir que seja uma data valida.
  Ao final é apresentado um meno com 5 buscas e a opção de sair. A partir deste são buscadas a informações desejados.
  O menu pode ser revisto quantas vezes o usuário desejar.
