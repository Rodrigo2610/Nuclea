
package steps_definition;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Data.TestData;
import Devices.TestBase;
import Pages.ElementosPesquisa;
import Runner.Testrunner;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PesquisaAmazon extends Testrunner implements TestData {

	@Given("^que eu acesse a pagina da amazon \"([^\"]*)\" via chrome$")
	public void que_eu_acesse_a_pagina_da_amazon_via_chrome(String URL) throws Throwable {
		TestBase.Chrome(URL);
	}

	@Given("^que eu acesse a pagina da amazon \"([^\"]*)\" via mobile$")
	public void que_eu_acesse_a_pagina_da_amazon_via_mobile(String URL) throws Throwable {
		TestBase.Mobile(URL);
	}

	@Given("^que eu acesse a pagina da amazon \"([^\"]*)\" via firefox$")
	public void que_eu_acesse_a_pagina_da_amazon_via_firefox(String URL) throws Throwable {
		TestBase.Firefox(URL);
	}

	@Given("^Que eu informar o nome do produto \"([^\"]*)\" na barra de pesquisa$")
	public void que_eu_informar_o_nome_do_produto_na_barra_de_pesquisa(String Produto) throws Throwable {
		Thread.sleep(500);
		ElementosPesquisa.BarraPesquisa(TestBase.driver).click();
		ElementosPesquisa.BarraPesquisa(TestBase.driver).clear();
		ElementosPesquisa.BarraPesquisa(TestBase.driver).sendKeys(Produto);
	}

	@When("^eu clicar no botão pesquisar$")
	public void eu_clicar_no_botão_pesquisar() throws Throwable {
		ElementosPesquisa.LupaPesquisa(TestBase.driver).click();
	}

	@Then("^Sera exibida a tela do produto \"([^\"]*)\" pesquisado$")
	public void sera_exibida_a_tela_do_produto_pesquisado(String Produto) throws Throwable {
		Thread.sleep(500);
		assertEquals("\"" + Produto + "\"", ElementosPesquisa.LabelPesquisaProduto(TestBase.driver).getText());

	}

	@When("^Eu informar as iniciais de um produto \"([^\"]*)\" na barra de pesquisa$")
	public void eu_informar_as_iniciais_de_um_produto_na_barra_de_pesquisa(String Produto) throws Throwable {
		Thread.sleep(1000);
		ElementosPesquisa.BarraPesquisa(TestBase.driver).click();
		ElementosPesquisa.BarraPesquisa(TestBase.driver).sendKeys(Produto);
	}

	@Then("^Sera exibida uma lista abaixo da barra de pesquisa com as sugestoes de pesquisa do produto \"([^\"]*)\"$")
	public void sera_exibida_uma_lista_abaixo_da_barra_de_pesquisa_com_as_sugestoes_de_pesquisa_do_produto(
			String Produto) throws Throwable {

		Thread.sleep(1000);
		if (System.getProperty("env") == "mobile") {
			List<WebElement> elements = TestBase.driver
					.findElements(By.xpath("/html/body/div/header/div/div/form/div/div[/div/div/div/div/div/div/div"));
			for (WebElement element : elements) {
				Thread.sleep(1000);

				String produtoLista = TestBase.driver
						.findElement(
								By.xpath("/html/body/div/header/div/div/form/div/div[/div/div/div/div/div/div/div"))
						.getText();
				assert (produtoLista.contains(Produto));

				System.out.println(element.getText());
			}
		} else {

			List<WebElement> elements = TestBase.driver
					.findElements(By.xpath("/html/body/div/header/div/div/div/div/div/div/div/div/div"));

			for (WebElement element : elements) {
				Thread.sleep(1000);

				String produtoLista = TestBase.driver
						.findElement(By.xpath("/html/body/div/header/div/div/div/div/div/div/div/div/div")).getText();
				assert (produtoLista.contains(Produto));

				System.out.println(element.getText());
			}
		}

//		List<WebElement> elements = TestBase.driver 
//				.findElements(By.xpath("/html/body/div/header/div/div/div/div/div/div/div/div/div"));
//		                               
//		for (WebElement element : elements) {
//			Thread.sleep(1000);
//
//			String produtoLista = TestBase.driver
//					.findElement(By.xpath("/html/body/div/header/div/div/div/div/div/div/div/div/div")).getText();
//			assert (produtoLista.contains(Produto));
//
//			System.out.println(element.getText());
//		}

	}
}
