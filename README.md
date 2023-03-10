# Teste de Automação AGI com Gradle
Este projeto é um exemplo de testes automatizados utilizando as bibliotecas JUnit, Selenium WebDriver e o Webdrivermanager, e tem como objetivo validar a funcionalidade de busca do website https://blogdoagi.com.br/.

# Funcionalidades
O código contém seis testes que automatizam a interação do navegador com o website, utilizando o navegador Chrome. Cada teste executa uma ação de busca no website com uma palavra-chave específica e verifica se a página de resultados foi exibida corretamente.

# Dependências
As dependências utilizadas no projeto estão definidas no arquivo build.gradle.

# Como utilizar
Para utilizar o projeto, basta clonar o repositório em sua máquina, construir o projeto e certificar-se de ter o JDK e o Gradle instalados em sua máquina. Os testes estão localizados em "test>java>testNavegacao".

# Outros navegadores
Este projeto suporta outros navegadores além do Chrome, como Firefox e Opera. Para utilizar um desses navegadores, siga os seguintes passos:<br>
1 - No arquivo PaginaPOO.java, descomente a linha 32 e 40 para utilizar o Firefox, ou a linha 33 e 41 para utilizar o Opera.<br>
2 - Lembre-se de comentar as linhas onde o Chrome é chamado, no caso 32 e 39.<br>
3 - Execute os testes normalmente.<br>

# Ajuda
Para obter ajuda sobre o projeto, você pode entrar em contato com o autor Bruno Lucas através do GitHub em https://github.com/BrunoLA013.

# Autor
Este projeto foi desenvolvido por Bruno Lucas (https://github.com/BrunoLA013).
