import com.applitools.eyes.FileLogger
import com.applitools.eyes.RectangleSize
import com.applitools.eyes.selenium.Eyes
import com.applitools.eyes.selenium.StitchMode
import geb.junit4.GebReportingTest
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class GebishOrgTest extends GebReportingTest {

    public Eyes eyes = new Eyes();

    @Test
    void canGetToTheCurrentBookOfGeb() {

        eyes.setApiKey('YourApiKey');
        eyes.setHideScrollbars(true);
        eyes.setForceFullPageScreenshot(true);
        eyes.setStitchMode(StitchMode.CSS);
        //eyes.setLogHandler(new FileLogger("/Users/justin/repos/applitools/file.log", true, true));

        to GebishOrgHomePage

        manualsMenu.open()

        driver = eyes.open(driver, "Geb", "Geb Test", new RectangleSize(1035, 635));

        eyes.checkWindow("Checkpoint1");

        //first link is for the current manual
        assert manualsMenu.links[0].text().startsWith("current")

        manualsMenu.links[0].click()

        at TheBookOfGebPage

        eyes.checkWindow("Checkpoint2");

        eyes.close(false);
    }

    @After
    public void tearDown() throws Exception {
        eyes.abortIfNotClosed();
    }
}