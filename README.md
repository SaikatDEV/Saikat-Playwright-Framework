# Here are some important info:

    `mvn test -DtestngXmlFile=./src/test/resources/testrunners/testng_regression.xml`

# Just download the latest Artifacts/dependencies:

    `mvn clean install -DskipTests=true`

#------------------------------------------------------------------------------

# To take a quick screenshot sample code:

    `page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get('test.png')));`

# Wait until the next page is being loaded/navigation complete:

    `page.waitForLoadState(LoadState.NETWORKIDLE);`

    OR

    `with page.waitForNavigation(() -> {
            page.click("css_selector");
    });`

#------------------------------------------------------------------------------

# Running codegen/Test generator. So we can create a script by recording:

https://playwright.dev/java/docs/codegen
`mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://something.com"`

#------------------------------------------------------------------------------

# Emulate devices

Record scripts and tests while emulating a mobile device using the --device option which sets the viewport size and user agent among others.
`mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args='codegen --device="iPhone 13" playwright.dev'`
