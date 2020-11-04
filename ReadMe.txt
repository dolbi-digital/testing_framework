Prerequisites:
IntelliJ Idea and Maven should be installed.

To run tests in all browsers:
1. Open project in IntelliJ Idea.
2. Run textng.xml file.

To run tests in all browsers with maven:
1. Open command line
2. Go to project folder
3. Execute maven command:
mvn clean test

To run tests for specific browser execute:
1. mvn clean test -Dbrowser=chrome -Dtest=ValtechTest

To run tests on docker:
1. Download images.
docker pull selenium/hub
docker pull selenium/node-firefox 
docker pull selenium/node-chrome 
docker pull mcr.microsoft.com/msedge/msedgedriver


2. Run Images.
docker run --name seleniumhub -d -p 4444:4444 selenium/hub
docker run -d -P --link seleniumhub:hub selenium/node-chrome
docker run -d -P --link seleniumhub:hub selenium/node-firefox
//docker run -d -P --link seleniumhub:hub selenium/node-firefox-debug (to see in VNC Viewer, password secret)
docker run -d -P --link seleniumhub:hub mcr.microsoft.com/msedge/msedgedriver

3. Add to ValtechTest class RemoveWebDriver instead of WebDriver.
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("browserName", browser);
driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);