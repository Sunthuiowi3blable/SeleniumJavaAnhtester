package AnhTesterCMS.testcases;

import AnhTesterCMS.pages.CategoryPage;
import AnhTesterCMS.pages.DashboardPage;
import AnhTesterCMS.pages.LoginPage;
import common.BaseTest;
import dataproviders.DataProviderFactory;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CategoryTest extends BaseTest {

    //Khởi tạo đối tượng trang
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CategoryPage categoryPage;
    private ExcelHelper excelHelper;

    //Testcase đăng nhập thành công với đầy đủ thông tin
    @Test (dataProvider = "data_provider_category_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testAddNewCategoryFullInformation (Hashtable<String, String> data){

        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper để sử dụng file Excel
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang categoryPage
        categoryPage = dashboardPage.clickMenuCategoryWithMenuProducts();

        categoryPage.clickButtonAddNewCategory();
        categoryPage.enterDataAddNewCategory(data);
        categoryPage.checkCategoryInTableList(data);
        categoryPage.checkCategoryDetail(data);
    }

    //Testcase đăng nhập không thành công với thông tin bỏ trống
    @Test (dataProvider = "data_provider_category_excel_hashtable_null", dataProviderClass = DataProviderFactory.class)
    public void testAddNewCategoryWithInformationNull(Hashtable<String, String> data){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper để sử dụng file Excel
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang categoryPage
        categoryPage = dashboardPage.clickMenuCategoryWithMenuProducts();

        categoryPage.clickButtonAddNewCategory();
        categoryPage.enterDataAddNewCategory(data);
        categoryPage.verifyInfomationNull();
    }
}
