package AnhTesterCMS.pages;

import keywords.WebUI;
import org.openqa.selenium.By;

//CommonPage là để lưu những Element không thuộc về bất kỳ trang nào cả
public class CommonPage {

    //Khởi tạo đối tượng trang
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CategoryPage categoryPage;

    //Khai báo hàm xây dựng
    public CommonPage() {
    }

    //Khai báo các element trên trang dạng đối tượng By (đối tượng By là đối tượng mới chỉ thiết lập cấu trúc chứ chưa tìm kiếm)
    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By menuAllProducts = By.xpath("//span[normalize-space()='All products']");
    private By menuInHouseProducts = By.xpath("//span[normalize-space()='In House Products']");
    private By menuBrand = By.xpath("//span[normalize-space()='Brand']");

    //**Các hàm xử lý**
    //LIÊN KẾT TRANG: sau khi hàm clickMenuDashboard xử lý xong nó sẽ chuyển đến trang DashboardPage
    public DashboardPage clickMenuDashboard(){
        WebUI.clickElement(menuDashboard);

        //Khởi tạo mới cho trang DashboardPage
        return new DashboardPage();
    }

    public void clickMenuProducts(){
        WebUI.clickElement(menuProducts);
    }

    //LIÊN KẾT TRANG: sau khi hàm clickMenuCategoryWithMenuProducts xử lý xong nó sẽ chuyển đến trang CategoryPage
    public CategoryPage clickMenuCategoryWithMenuProducts(){
        clickMenuProducts();
        WebUI.waitForElementVisible(menuCategory);
        WebUI.clickElement(menuCategory);

        //Khởi tạo mới cho trang CategoryPage
        return new CategoryPage();
    }

}
