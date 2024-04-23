package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class AssessmentStepsDefinition {

    public static WebDriver driver;

    @Given("I navigate to Star wars Home page")
    public void i_navigate_to_star_wars_home_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karthik9\\Desktop\\Karthik\\Extra\\details\\Digitcert\\Assessment\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/");
        driver.manage().window().maximize();
    }

    @When("I click on Title column")
    public void i_click_on_title_column() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//th[text()='Title']")).click();
    }

    @Then("I should see the last movie in the list is The Phantom Menace")
    public void i_should_see_the_last_movie_in_the_list_is_the_phantom_menace() throws InterruptedException {
        Thread.sleep(5000);
        String movie_name = driver.findElement(By.xpath("//a[text()='The Phantom Menace']")).getText();
        System.out.println(movie_name);
        Assert.assertEquals(movie_name, "The Phantom Menace");
        driver.close();
    }

        @When("I select the movie The Empire Strikes Back")
        public void i_select_the_movie_the_empire_strikes_back() throws InterruptedException {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//a[text()='The Empire Strikes Back']")).click();
        }


        @Then("I should see the Species list has Wookie")
        public void i_should_see_the_species_list_has_wookie() throws InterruptedException {
            Thread.sleep(5000);
            String species_list = driver.findElement(By.xpath("//li[text()='Wookie']")).getText();
            System.out.println(species_list);
            Assert.assertEquals(species_list, "Wookie");
            Assert.assertEquals(1, driver.findElements(By.xpath("//li[text()='Wookie']")).size());
            driver.close();
        }

    @When("I select the movie The Phantom Menace")
    public void i_select_the_movie_the_phantom_menace() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='The Phantom Menace']")).click();
    }

    @Then("I should not see the Planets - Camino in the list for movie The Phantom Menace")
    public void i_should_not_see_the_planets_camino_in_the_list_for_movie_the_phantom_menace() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(0, driver.findElements(By.xpath("//li[text()='Camino']")).size());
        driver.close();
    }

    }


