import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestCalculator {

        private WebDriver driver;


        @BeforeClass
        public void beforeClass() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dusanic\\Desktop\\selenium\\chromedriver.exe");
            this.driver = new ChromeDriver();
           // this.driver.get("https://testsheepnz.github.io/BasicCalculator.html");
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            this.driver.manage().window().maximize();
        }
    @BeforeMethod
    public void beforeMethod(){
        this.driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();

    }


        @Test
      public void addTest() {
            JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
            scroll.executeScript("window.scrollBy(0,800)", "");

            WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
            firstNumberField.clear();
            firstNumberField.sendKeys("1");

            WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
            secondNumberField.clear();
            secondNumberField.sendKeys("1");

            WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
            Select select= new Select(chooseOperation);
            select.selectByVisibleText("Add");


            WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
            selectInteger.click();

            WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
            CalculateBtn.click();
            String expectedResult = "2";
            WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

            String actualResult =answerField.getAttribute("value");
            Assert.assertEquals(actualResult,expectedResult);
        }

    @Test
    public void testAddNegative() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("-2");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("-1");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByVisibleText("Add");


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));
        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "-3";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void testAddPositiveAndNegative() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("-10");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("5");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByVisibleText("Add");


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "-5";
        Assert.assertEquals(actualResult,expectedResult);
    }
   @Test
    public void testInt() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("1000000000");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("1000000000000");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByVisibleText("Add");


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "1001000000000";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void substractNegative() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("-1");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("-2");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByVisibleText("Subtract");

        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "1";
        Assert.assertEquals(actualResult,expectedResult);
    }

        @Test
        public void substractZeroTest() {
            JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
            scroll.executeScript("window.scrollBy(0,800)", "");

            WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
            firstNumberField.clear();
            firstNumberField.sendKeys("0");

            WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
            secondNumberField.clear();
            secondNumberField.sendKeys("1");

            WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
            Select select= new Select(chooseOperation);
            select.selectByVisibleText("Subtract");


            WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
            selectInteger.click();

            WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
            CalculateBtn.click();

            WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

            String actualResult =answerField.getAttribute("value");
            System.out.println(actualResult);
            String expectedResult = "-1";
            Assert.assertEquals(actualResult,expectedResult);
        }

    @Test
    public void testMultiplyPositive() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("10");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("1");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByIndex(2);


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "10";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void testMultiplyPositiveAndNegative() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("2");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("-2");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByIndex(2);


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "-4";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void testMultiplyNegativeAndNegative() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("-2");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("-10");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByIndex(2);


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "20";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void testMultiplyWithZero() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("-1");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("0");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByIndex(2);


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "0";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void testMultiplyInteger() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("100000000000");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("100");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByIndex(2);


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "10000000000000";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void dividePositiveTest() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("10");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("5");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByIndex(3);


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "2";
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Test
    public void dividePositiveAndNegativeTest() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("-10");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("5");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByIndex(3);


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "-2";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void divideTwoNegativeNumbersTest() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("-10");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("-2");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByIndex(3);


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "5";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void divideWithZeroTest() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("0");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("2");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByIndex(3);


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "0";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void divideTIntTest() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("10");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("3");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByIndex(3);


        WebElement selectInteger = this.driver.findElement(By.id("integerSelect"));
        selectInteger.click();

        WebElement CalculateBtn = this.driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "3.33";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void concatenateTestPositive() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("10");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("3");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByVisibleText("Concatenate");


        WebElement CalculateBtn = driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "103";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void concatenateTestPositiveandNegative() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("1");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("-2");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByVisibleText("Concatenate");


        WebElement CalculateBtn = driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "1-2";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void concatenateTwoNegativeNumbersTest() {
        JavascriptExecutor scroll = (JavascriptExecutor)this.driver;
        scroll.executeScript("window.scrollBy(0,800)", "");

        WebElement firstNumberField = this.driver.findElement(By.id("number1Field"));
        firstNumberField.clear();
        firstNumberField.sendKeys("-1");

        WebElement secondNumberField = this.driver.findElement(By.id("number2Field"));
        secondNumberField.clear();
        secondNumberField.sendKeys("-2");

        WebElement chooseOperation = this.driver.findElement(By.id("selectOperationDropdown"));
        Select select= new Select(chooseOperation);
        select.selectByVisibleText("Concatenate");


        WebElement CalculateBtn = driver.findElement(By.id("calculateButton"));
        CalculateBtn.click();

        WebElement answerField = this.driver.findElement(By.id("numberAnswerField"));

        String actualResult =answerField.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "-1-2";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @AfterMethod
    public void aftermethod() throws InterruptedException {
            Thread.sleep(500);
    }

        @AfterClass
        public void afterClass() {
            this.driver.quit();
        }

    }

