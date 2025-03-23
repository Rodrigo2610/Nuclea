# Instalação e Execução de Testes Selenium com Maven

Este README descreve os passos necessários para instalar e executar testes Selenium usando o Maven como gerenciador de dependências e construção de projeto.

## Pré-requisitos

Antes de prosseguir com a instalação e execução dos testes Selenium, verifique se o seu sistema possui os seguintes pré-requisitos:

- Java Development Kit (JDK) instalado. Versão recomendada: JDK 8 ou superior.
- Maven instalado. Versão recomendada: Maven 3.6.0 ou superior.
- WebDriver compatível com o navegador de sua escolha (por exemplo, ChromeDriver, GeckoDriver, etc.). Certifique-se de ter o WebDriver apropriado instalado e configurado corretamente.

## Configuração do Projeto

1. Clone o repositório do projeto para o seu ambiente local:

```
git clone https://github.com/seu-usuario/seu-projeto.git
```

2. Navegue até o diretório raiz do projeto:

```
cd seu-projeto
```

3. Configure as dependências necessárias no arquivo `pom.xml`:

```xml
<dependencies>
    <!-- Dependências do Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
    <!-- Outras dependências do projeto -->
</dependencies>
```

Certifique-se de atualizar a versão do Selenium WebDriver de acordo com a versão desejada.

## Execução dos Testes

Para executar os testes Selenium, siga as etapas abaixo:

1. Abra um terminal ou prompt de comando.
2. Navegue até o diretório raiz do projeto.
3. Execute o comando Maven para executar os testes:

```
mvn test
```

O Maven baixará as dependências necessárias, compilará o código do projeto e executará os testes.

## Configuração do WebDriver

Certifique-se de ter configurado corretamente o WebDriver para o navegador específico que você deseja usar. Isso geralmente envolve definir o caminho do executável do WebDriver no código de teste. Aqui está um exemplo de código para o ChromeDriver:

```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        // Define o caminho do executável do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "caminho/para/o/chromedriver");

        // Inicializa o WebDriver
        WebDriver driver = new ChromeDriver();

        // Execute os testes...
    }
}
```

Certifique-se de substituir `"caminho/para/o/chromedriver"` pelo caminho real para o arquivo executável do ChromeDriver em seu sistema.

## Conclusão

Este README fornece uma visão geral básica dos passos necessários para instalar e executar testes Selenium com Maven. Certifique-se de personalizar as configurações e dependências conforme necessário para o seu projeto específico.