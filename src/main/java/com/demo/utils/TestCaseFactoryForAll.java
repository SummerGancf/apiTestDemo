package com.demo.utils;

import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.*;

/**
 *
 *
 * @Description 自动生成测试代码的工具类,生成所有模块的测试类
 *
 */
public class TestCaseFactoryForAll {
    public static void main(String[] args) {

        final String caseFolder = "src/com/jkzl/test/autotestcase";
        File sourceFile = null;
        String sheetName = null;
        int sheetNum = 0;
        for (int i = 0; i < getFunctionNum(); i++) { // 第一层循环 取得模块的个数
            try {

                String functionName = getFunctionName(i);// 获得每轮循环的 模块名

                functionName = functionName.replaceFirst(
                        functionName.substring(0, 1),
                        functionName.substring(0, 1).toLowerCase());
                // 如果包名不存在，就新建
                File functionPackage = new File(caseFolder);
                if (functionPackage.exists()) {
                    System.out.println(caseFolder + "包已经存在，自动跳过！");
                    System.out.println("正在生成用例到" + caseFolder + "包下，请稍等...");
                } else {
                    functionPackage.mkdir();
                    System.out.println("包已创建！");
                    System.out.println("正在生成用例到" + caseFolder + "包下，请稍等...");
                }

                for (int j = 0; j < getSheetNum(getExcelRelativePath(i)); j++) { // 第二层循环，根据传入的模块文件路径获得
                                                                                    // 模块中sheet数量
                                                                                    // 也就是用例个数
                    if (j == getSheetNum(getExcelRelativePath(i)) - 1) {

                        break;
                    }
                    try {
                        sheetName = getSheetName(j , getExcelRelativePath(i)); // 取得sheetName
                                                                                    // 只进行一次全局异常捕获
                        sheetNum = getSheetNum(getExcelRelativePath(i));
                    } catch (BiffException e1) {
                        e1.printStackTrace();
                    }
                    sourceFile = new File(caseFolder
//								+ functionName.replaceFirst(functionName.substring(
//										0, 1), functionName.substring(0, 1)
//										.toLowerCase())
                            + File.separator
                            + functionName.replaceFirst(functionName.substring(
                                    0, 1), functionName.substring(0, 1)
                                    .toUpperCase()) + "_" + sheetName
                            + "_Test.java");// 创建测试用例源码，指定存放路径
                    FileWriter writer = new FileWriter(sourceFile);

                    // 生成测试用例代码的头文件
                    writer.write("package com.demo.test.autotestcase; \n"
                            + "import com.demo.utils.HttpAction; \n"
                            + "import com.demo.test.base.BaseParpare; \n "
                            +"import java.io.IOException;\n"
                            +"import java.util.Map;\n"
//								+"import org.codehaus.jettison.json.JSONArray;\n"
                            +"import org.codehaus.jettison.json.JSONException;\n"
                            +"import org.codehaus.jettison.json.JSONObject;\n"
                            +"import org.testng.Assert;\n"
//								+"import org.testng.Reporter;\n"
                            +"import org.testng.annotations.Test;\n"
//								+"import org.testng.log4testng.Logger;\n"
//								+"import com.demo.base.Common;\n"
//								+"import com.demo.base.HttpRespones;\n"
                            +"import com.jkzl.test.base.BaseParpare;\n"
                            + "public class "
                            + functionName.replaceFirst(functionName.substring(
                                    0, 1), functionName.substring(0, 1)
                                    .toUpperCase())  +"_" + sheetName
                            + "_Test extends BaseParpare{ \n");
                    // @Test的主体部分，也就是测试用例的方法
                    String firstLetter = sheetName.substring(
                            sheetName.indexOf("_") + 1).substring(0, 1);
                    String others = sheetName.substring(
                            sheetName.indexOf("_") + 1).substring(1);
                    String function = firstLetter.toLowerCase() + others;
                    writer.write("@Test(dataProvider = \"testData\")\n"
                            + "public void"
                            + " "
//								+ function
                            +functionName.replaceFirst(functionName.substring(
                                    0, 1), functionName.substring(0, 1)
                                    .toUpperCase())
                            + "(Map<String, String> data) { \n"
                            +"    try{\n"
                            +"        String Api = data.get(\"Api\"); \n"
                            +"        JSONObject  Param = new JSONObject(data.get(\"Param\"));\n"
                            +"        String expect=data.get(\"expect\");\n"
                            +"        HttpAction.httpForExcel(Api, Param, expect);\n"
                            +"       }catch(JSONException e) {\n"
                            +"            Assert.fail(\""
                            +functionName
                            + ":JSONException\");\n"
                            +"            e.printStackTrace();\n"
                            + "        }\n"
                            + "    }\n");

                    // 代码结尾大括号
                    writer.write("}");
                    writer.close();
                }
            } catch (IOException e) {
                Assert.fail("IO异常", e);
            }
            System.out.println("模块[" + getFunctionName(i) + "] 的用例已经生成完毕，共计："
                    + (sheetNum - 1) + "条，请到" + caseFolder
                     + "路径下查阅！");
        }

    }

    /**
     * 获得当前路径下模块个数
     *
     * @return 得到模块的个数
     */
    public static int getFunctionNum() {
        String path = "data";
        File file = new File(path);
        File[] array = file.listFiles();
        return array.length;
    }

    /**
     * 获得模块名字 也就是excel 表名
     *
     * @param 循环模块名称的角标
     * @return 得到对应index的模块名字
     */
    public static String getFunctionName(int index) {
        String excelCasePath = "data";
        String functionName = "";
        // get file list where the path has
        File file = new File(excelCasePath);

        // get the folder list
        File[] array = file.listFiles();
        if (array[index].isFile()) {
            functionName = array[index].getName().substring(0,
                    array[index].getName().lastIndexOf("."));
        }

        return functionName;
    }

    /**
     * 获得excel的相对路径
     *
     * @param 循环模块名称的角标
     * @return 得到对应index的模块名字
     */
    public static String getExcelRelativePath(int index) {
        String path = "data";
        String functionName = "";
        // get file list where the path has
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();
        functionName = array[index].getPath();
        return functionName;
    }

    /**
     * 获得当前excel的sheet数量 - 每个模块的用例数
     *
     * @param filePath
     *            文件路径
     * @return 获得excel的sheet数量
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static int getSheetNum(String filePath)
            throws FileNotFoundException, IOException {
        int casesNum = 0;
        if(isExcel2003(filePath)){
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(
                    filePath)));
            casesNum = workbook.getNumberOfSheets();
        }else{
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(
                    filePath)));
            casesNum = workbook.getNumberOfSheets();
        }


        return casesNum;
    }

    /**
     *
     * @param sheetIndex
     *            sheet的位置
     * @param filePath
     *            excel文件路径相对的
     * @return 返回sheet的名字
     * @throws BiffException
     * @throws IOException
     */
    public static String getSheetName(int sheetIndex, String filePath)
            throws BiffException, IOException {
        String casesName = "";
        if(isExcel2003(filePath)){
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath));
            casesName = workbook.getSheetName(sheetIndex);

        }else{

            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
            casesName = workbook.getSheetName(sheetIndex);
        }
        return casesName;

    }

     public static boolean isExcel2003(String filePath)
        {

            return filePath.matches("^.+\\.(?i)(xls)$");

        }

     public static boolean isExcel2007(String filePath)
        {

            return filePath.matches("^.+\\.(?i)(xlsx)$");

        }

}

