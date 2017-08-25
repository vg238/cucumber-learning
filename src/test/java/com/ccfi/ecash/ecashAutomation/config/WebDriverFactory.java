package com.ccfi.ecash.ecashAutomation.config;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

final class WebDriverFactory {

	private static final String WEB_DRIVER_FOLDER = "webdrivers";

	private WebDriverFactory() {

	}

	static WebDriver create() {
		String webDriverProperty = System.getProperty("webdriver");
		if (StringUtils.isEmpty(webDriverProperty))
			webDriverProperty = "chrome";
		if (webDriverProperty == null || webDriverProperty.isEmpty()) {
			throw new IllegalStateException("The webdriver system property must be set");
		}

		// setup system property for driver
		String driverFileName = "chromedriver.exe";
		System.setProperty("webdriver." + webDriverProperty + ".driver",
				driversFolder(new File("").getAbsolutePath()) + driverFileName);
		try {
			return Drivers.valueOf(webDriverProperty.toUpperCase()).newDriver();
		} catch (IllegalArgumentException e) {
			String msg = format(
					"The webdriver system property '%s' did not match any "
							+ "existing browser or the browser was not supported on your operating system. "
							+ "Valid values are %s",
					webDriverProperty,
					stream(Drivers.values()).map(Enum::name).map(String::toLowerCase).collect(toList()));

			throw new IllegalStateException(msg, e);
		}
	}

	private enum Drivers {
		FIREFOX {
			@Override
			public WebDriver newDriver() {
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				return new FirefoxDriver(capabilities);
			}
		},
		CHROME {
			@Override
			public WebDriver newDriver() {
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				return new ChromeDriver(capabilities);
			}
		},
		OPERA {
			@Override
			public WebDriver newDriver() {
				DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
				return new OperaDriver(capabilities);
			}
		},
		PHANTOMJS {
			@Override
			public WebDriver newDriver() {
				DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
				return new PhantomJSDriver(capabilities);
			}
		},
		IE {
			@Override
			public WebDriver newDriver() {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				return new InternetExplorerDriver(capabilities);
			}
		},
		EDGE {
			@Override
			public WebDriver newDriver() {
				DesiredCapabilities capabilities = DesiredCapabilities.edge();
				return new EdgeDriver(capabilities);
			}
		};

		public abstract org.openqa.selenium.WebDriver newDriver();

	}

	private static String driversFolder(String path) {
		File file = new File(path);
		for (String item : file.list()) {
			if (WEB_DRIVER_FOLDER.equals(item)) {
				return file.getAbsolutePath() + "/" + WEB_DRIVER_FOLDER + "/";
			}
		}
		return driversFolder(file.getParent());
	}
}