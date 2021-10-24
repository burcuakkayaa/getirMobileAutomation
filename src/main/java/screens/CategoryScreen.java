package screens;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.ElementUtil;

import java.util.List;

public class CategoryScreen {

    private final By products =  By.xpath("//android.support.v4.view.ViewPager/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout");


    private final ElementUtil element = new ElementUtil();

    public void getCategoryScreen(String categoryName) {
        try {
            String category = "//android.support.v7.app.ActionBar.Tab[@content-desc='" +  categoryName +  "']";
            element.clickElement(By.xpath(category));
        }catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Category name must be start to uppercase..");
        }
    }

    public void selectProduct(int index) {

        List<MobileElement> productList = element.getMobileElements(products);
        element.waitUntilClickable(products);
        productList.get((index-1)).click();

    }

    public void goToCategory(String categoryName) {

        String category = "//*[@text='" + categoryName +  "']";
        By categoryLocator = By.xpath(category);
        element.isElementPresent(categoryLocator);
        element.actionClick(categoryLocator);

    }

    public void checkCategoryPage() {
        element.isElementPresent(products);
    }
}
