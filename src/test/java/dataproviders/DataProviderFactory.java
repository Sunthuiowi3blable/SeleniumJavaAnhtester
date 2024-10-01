package dataproviders;

import helpers.ExcelHelper;
import helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "data_provider_category_excel_hashtable", parallel = true)
    public Object[][] dataProviderCategoryFromExcelWithHashtable(){
        //Khởi tạo đối tượng
        ExcelHelper excelHelper = new ExcelHelper();

        //Lấy ra dữ liệu chỉ định trong file Excel chỉ đinh
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataTest.xlsx", "Category", 1, 2);
        System.out.println("Add New Product from Excel (Hashtable): " + data);

        //Trả về data Object[][] (object 2 chiều)
        return data;
    }

    @DataProvider(name = "data_provider_category_excel_hashtable_null", parallel = true)
    public Object[][] dataProviderCategoryFromExcelWithHashtableNull(){
        //Khởi tạo đối tượng
        ExcelHelper excelHelper = new ExcelHelper();

        //Lấy ra dữ liệu chỉ định trong file Excel chỉ đinh
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataTest.xlsx", "Category", 3, 4);
        System.out.println("Add New Product from Excel (Hashtable): " + data);

        //Trả về data Object[][] (object 2 chiều)
        return data;
    }
}
