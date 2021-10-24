package screens;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.ElementUtil;

import java.util.List;

public class ProductDetailsScreen {

    private final By detailsPage = By.id("com.allandroidprojects.getirsample:id/scrollbar");
    private final By detailsList  = By.className("android.widget.TextView");
    private final By addToCartButton = By.id("com.allandroidprojects.getirsample:id/text_action_bottom1");
    private final By buyNowButton = By.id("com.allandroidprojects.getirsample:id/text_action_bottom2");

    private final ElementUtil element = new ElementUtil();

    public void addToBasket() {
           element.waitUntilVisibleBy(addToCartButton);
           element.waitUntilClickable(addToCartButton);
           element.actionClick(addToCartButton);
    }

    public String getPrice() {
        String price = null;
        element.waitUntilVisibleBy(detailsPage);

       List<MobileElement> childElements = element.getChildMobileElements(detailsPage,detailsList);
       for(MobileElement priceElement : childElements) {
           if(priceElement.getAttribute("text").startsWith("$"))
              price  =  priceElement.getText();
       }

      return  price;

    }

    public void goToBasketScreen() {
        element.waitUntilClickable(buyNowButton);
        element.actionClick(buyNowButton);
    }


    public void goBackToCategoryPage() {
        element.back();
    }
}
