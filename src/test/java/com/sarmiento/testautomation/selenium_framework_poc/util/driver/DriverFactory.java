package com.sarmiento.testautomation.selenium_framework_poc.util.driver;

import com.sarmiento.testautomation.selenium_framework_poc.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URI;

@Component
public class DriverFactory {

    private  static final String pathFormat = System.getProperty("user.dir") + "src/test/resources/drivers/windows/%s";
    @Value("${grid.url}")
    private String remoteUrl;
    @Value("${remote.execution}")
    private boolean remoteExecution;

    public WebDriver get(Browser browser) throws MalformedURLException {

        if(remoteExecution){
            return getRemoteWebDriver(browser);
        }

        if (browser == Browser.chrome) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browser == Browser.firefox) {
            WebDriverManager.firefoxdriver();
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Browser not found" + browser);
        }
    }

    private RemoteWebDriver getRemoteWebDriver(Browser browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser.name());
        capabilities.setCapability("enableVideo", true);

        return new RemoteWebDriver(URI.create(remoteUrl).toURL(), capabilities);
    }
}
