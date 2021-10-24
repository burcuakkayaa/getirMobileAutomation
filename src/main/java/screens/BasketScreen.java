package screens;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.ElementUtil;

import java.util.List;

public class BasketScreen {

    private final By totalPrice = By.id("com.allandroidprojects.getirsample:id/text_action_bottom1");
    private final ElementUtil element = new ElementUtil();
    private final By productListXpath = By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]");



    public String  getPrice() {
        element.waitUntilVisibleBy(totalPrice);
        return element.getText(totalPrice);
    }

    public void removeProducts() {

        while (element.isElementPresent(productListXpath)) {
            try {
                List<MobileElement> productList =  element.getMobileElements(productListXpath);
                productList.get(0).click();
            }catch (Exception e) {
                break;
            }


        }

    }
}
