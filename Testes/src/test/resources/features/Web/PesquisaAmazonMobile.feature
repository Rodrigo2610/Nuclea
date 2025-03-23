@PesquisaAmazon @PesquisaAmazonMobile
Feature: Pesquisa Amazon Mobile
  Validar pesquisa no site amazon

  Background:
  Given que eu acesse a pagina da amazon "https://www.amazon.com.br/" via mobile

  Scenario Outline: Pesquisar Produto
    Given Que eu informar o nome do produto "<produto>" na barra de pesquisa
    When eu clicar no botão pesquisar

    Examples: 
      | produto           |
      | iphone 15 pro max |

  Scenario Outline: Pesquisar Produto, Validar iniciais
    When Eu informar as iniciais de um produto "<produto>" na barra de pesquisa
    Then Sera exibida uma lista abaixo da barra de pesquisa com as sugestoes de pesquisa do produto "<produto>"

    Examples: 
      | produto |
      | sab     |
