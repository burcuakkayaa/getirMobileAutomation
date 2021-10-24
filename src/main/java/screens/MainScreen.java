package screens;


import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.ElementUtil;

public class MainScreen {

   private final By skip = By.id("com.allandroidprojects.getirsample:id/btn_skip");
   private final By onBoardingScreen = By.className("android.widget.FrameLayout");
   private final By mainScreen = By.id("com.allandroidprojects.getirsample:id/drawer_layout");
   private final By leftIcon = By.xpath("//*[@content-desc='Open navigation drawer']");


   private final ElementUtil element = new ElementUtil();

    public void passOnBoardingScreen() {
        element.waitUntilVisibleBy(onBoardingScreen);
        element.waitUntilClickable(skip);
        element.actionClick(skip);
    }

    public void checkMainScreenIsPresent() {
      if(!(element.isElementPresent(mainScreen)))
          Assert.fail("Main Screen has not been present..");
      else
          System.out.println("Main Screen opened successfully..");
    }

    public void clickLeftMenu() {
        element.waitUntilClickable(element.getMobileElement(leftIcon));
        element.actionClick(leftIcon);

            }

}
