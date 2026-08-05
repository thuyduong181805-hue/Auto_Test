import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class CheckoutProductSuccessTest {
    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        // Tắt cảnh báo pass của chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_leak_detection", false
        ));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        // Mở web
        driver.get("https://www.saucedemo.com/");
        // Step1 : Login
        // Nhập user-name
        WebElement userName = driver.findElement(
                By.xpath("//input[@id='user-name']")
        );
        userName.sendKeys("standard_user");
        //Nhập passwork
        WebElement passWork = driver.findElement(
                By.xpath("//input[@id='password']")
        );
        passWork.sendKeys("secret_sauce");
        // login
        WebElement login = driver.findElement(
                By.xpath("//input[@id='login-button']")
        );
        login.click();

        //Step 2: Chọn tìm kiếm droplist Price (low to high)
        WebElement productSortContainer = driver.findElement(
                By.xpath("//select[@class='product_sort_container']")
        );
        Select select = new Select(productSortContainer);
        select.selectByVisibleText("Price (low to high)");
        // Step 3: Add to cart 2 sản phẩm bất kì
        // Thêm sản phẩm 1 vào giỏ
        WebElement addToCart1 = driver.findElement(
                By.xpath("//button[@name='add-to-cart-sauce-labs-onesie']")
        );
        addToCart1.click();
        //Thêm sản phẩm 2 vào giỏ
        WebElement addToCart2 = driver.findElement(
                By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")
        );
        addToCart2.click();
        // System.out.println: ở giỏ hàng hiển thị số 2
        WebElement shoppingCartBadge = driver.findElement(
                By.xpath("//span[@class='shopping_cart_badge']")
        );
        //lay gia tri shoppingCartBadge
        String text = shoppingCartBadge.getText();
        //In trang thai da chon
        System.out.println("Shopping Cart Badge: " + text);
        //Step 4: Click vào giỏ hàng
        WebElement shoppingCart = driver.findElement(
                By.xpath("//a[@class='shopping_cart_link']")
        );
        shoppingCart.click();
        // System.out.println 1: Thông tin Your Cart hiển thị đúng 2 sản phẩm với tên và giá tiền đúng
        List<WebElement> itemNameShoppingCart = driver.findElements(
                By.xpath("//div[@class='inventory_item_name']")
        );
        List<WebElement> itemPriceShoppingCart = driver.findElements(
                By.xpath("//div[@class='inventory_item_price']")
        );

        //check giỏ hàng hiển thi đúng 2 sản phẩm
        int productCount = itemNameShoppingCart.size();
        if (productCount == 2) {
            System.out.println("PASS: Giỏ hàng hiển thị đúng 2 sản phẩm");
        } else {
            System.out.println("FAIL: Giỏ hàng không hiển thị đúng 2 sản phẩm");
        }
        //in thong tin tn và giá 2 sản phẩm
        for (int i=1; i<=productCount; i++){
            System.out.println(
                    "Tên sản phẩm " + i + ": " + itemNameShoppingCart.get(i-1).getText()
                    + " | giá tiền: " + itemPriceShoppingCart.get(i-1).getText()
            );
        }
        //Màn hình có hiển thị 2 button Remove
        List<WebElement> remove = driver.findElements(
                By.xpath("//button[@class='btn btn_secondary btn_small cart_button']")
        );
        int removeCount = remove.size();
        System.out.println("Giỏ hàng hiển thị " + removeCount + " button Remove");
        // Step 5: Click continute và nhập các thông tin Firts name, Last name, Zip code
        // Click checkout
        WebElement checkout = driver.findElement(
                By.xpath("//button[@id='checkout']")
        );
        checkout.click();
        //Nhập Firts name
        WebElement firtsName = driver.findElement(
                By.xpath("//input[@id='first-name']")
        );
        firtsName.sendKeys("Thùy Dương");
        // Nhập Last name
        WebElement lastName = driver.findElement(
                By.xpath("//input[@id='last-name']")
        );
        lastName.sendKeys("Nguyễn Thị");
        // Nhập Zip code
        WebElement zipCode = driver.findElement(
                By.xpath("//input[@id='postal-code']")
        );
        zipCode.sendKeys("0058411");
        // Step 6: Click continute
        WebElement continute = driver.findElement(
                By.xpath("//input[@id='continue']")
        );
        continute.click();
        // System.out.println 1 : Thông tin Description hiển thị đúng 2 sản phẩm với số lượng, tên và giá tiền đúng
        List<WebElement> itemNameDescription = driver.findElements(
                By.xpath("//div[@class='inventory_item_name']")
        );
        List<WebElement> itemPriceDescription = driver.findElements(
                By.xpath("//div[@class='inventory_item_price']")
        );
        List<WebElement> cartQuantity = driver.findElements(
                By.xpath("//div[@class='cart_quantity']")
        );
        int descriptionCount = itemNameDescription.size();
        if (descriptionCount == 2) {
            System.out.println("PASS: Description hiển thị đúng 2 sản phẩm");
        } else {
            System.out.println("FAIL: Description không hiển thị đúng 2 sản phẩm");
        }
        //in thong tin 2 sản phẩm với số lượng, tên và giá tiền, tính tổng tiền 2 sản phẩm
        double totalProduct = 0;
        for (int j=1; j<=descriptionCount; j++){
            System.out.println(
                    "Tên sản phẩm " + j + ": " + itemNameDescription.get(j-1).getText() +
                    " | Số lượng :" + cartQuantity.get(j-1).getText() +
                    " | giá tiền: " + itemPriceDescription.get(j-1).getText()
            );
            double Price = Double.parseDouble(
                    itemPriceDescription.get(j-1).getText().replace("$", "")
            );
            totalProduct = totalProduct + Price;
            System.out.println("Tổng tiền 2 sản phẩm là: " + totalProduct);
        }
        // Shipping Information hiển thị đúng "Free Pony Express Delivery!"
        WebElement shippingInfo = driver.findElement(By.xpath("//div[contains(text(),'Free Pony Express Delivery!')]"));
        if (shippingInfo.getText().equals("Free Pony Express Delivery!")) {
            System.out.println("PASS: Shipping Information hiển thị: "+shippingInfo.getText());
        } else {
            System.out.println("FAIL: Shipping Information hiển thị sai");
        }
        // System.out.println 3: Price Total hiển thị đúng tổng tiền 2 sản phẩm
        WebElement itemTotalText = driver.findElement(
                By.xpath("//div[@class='summary_subtotal_label']")
        );

        double actuaPricelTotal = Double.parseDouble(
                itemTotalText.getText().replace("Item total: $", "")
        );
        if (totalProduct == actuaPricelTotal) {
            System.out.println(
                    "Price Total hiển thị đúng tổng tiền 2 sản phẩm là: "+ actuaPricelTotal
            );
        } else {
            System.out.println(
                    "Price Total hiển thị sai tổng tiền 2 sản phẩm"
            );
        }
        // System.out.println 4: Total hiển thị đúng tổng tiền của Item total + Tax
        WebElement taxText = driver.findElement(
                By.className("summary_tax_label")
        );
        double tax = Double.parseDouble(
                taxText.getText().replace("Tax: $", "")
        );

        // Tính Total mong đợi, thực tế
        double expectedTotal = totalProduct + tax;
        double actualTotal = actuaPricelTotal + tax;
        //so sánh
        if (expectedTotal == actualTotal) {
            System.out.println(
                    "Total hiển thị đúng tổng tiền của Item total + Tax là: " + expectedTotal
            );
        } else {
            System.out.println(
                    "Total hiển thị sai tổng tiền của Item total + Tax"
            );
        }
        // System.out.println 5: Button Finish hiển thị
        WebElement finishText = driver.findElement(
                By.xpath("//button[@id='finish']")
        );
        System.out.println("Hiển thị Button: "+finishText.getText());
        //Step 7: Click Finish
        finishText.click();
        //System.out.println 1 : hiển thị "Checkout: Complete!"
        WebElement checkoutComplete = driver.findElement(
                By.xpath("//span[@class='title']")
        );
        System.out.println("Hiển thị: "+checkoutComplete.getText());
        //System.out.println 2 : hiển thị "Thank you for your order!"
        WebElement completeHeader = driver.findElement(
                By.xpath("//h2[@class='complete-header']")
        );
        System.out.println("Hiển thị: "+completeHeader.getText());
        //System.out.println 3 : hiển thị "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
        WebElement completeText = driver.findElement(
                By.xpath("//div[@class='complete-text']")
        );
        System.out.println("Hiển thị: "+completeText.getText());
        //System.out.println 3 : hiển thị button Back Home
        WebElement backHome = driver.findElement(
                By.xpath("//button[@id='back-to-products']")
        );
        System.out.println("Hiển thị button: "+backHome.getText());

        Thread.sleep(5000);
        driver.quit();
    }
}
