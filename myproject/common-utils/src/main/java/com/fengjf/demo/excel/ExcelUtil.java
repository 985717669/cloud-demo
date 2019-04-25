package com.fengjf.demo.excel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.fengjf.demo.excep.NormalException;
import com.fengjf.demo.resp.BaseResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author fengjf
 * @Desc excel工具类
 **/

public class ExcelUtil {

    /**
     * 导出 Excel ：一个 sheet，带表头
     *
     * @param response HttpServletResponse
     * @param list     数据 list，每个元素为一个 BaseRowModel
     * @param fileName 文件名，会自动加上.xlsx
     * @param clazz    list<class> list里泛型对象
     */
    public static void writeExcel(HttpServletResponse response, List<? extends BaseRowModel> list, String fileName,
                                  Class clazz) throws IOException {
        if (fileName == null) {
            fileName = UUID.randomUUID().toString().replaceAll("-", "");
        }
        //创建本地文件
        String filePath = fileName + ".xlsx";
        File dbfFile = new File(filePath);
        if (!dbfFile.exists() || dbfFile.isDirectory()) {
            dbfFile.createNewFile();
        }
        fileName = new String(filePath.getBytes(), "ISO-8859-1");
        response.addHeader("Content-Disposition", "filename=" + fileName);
        OutputStream out = response.getOutputStream();
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet = new Sheet(1, 0, clazz);
            sheet.setSheetName("sheet");
            writer.write(list, sheet);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                dbfFile.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取excel内容的工具类， 支持xls, xlsx 两种格式
     *
     * @param clazz       接收对象class对象， 建议所有字段都设置为String, 否则可能会出现转换异常
     * @param sheetNo     sheet下标， 第一列为1
     * @param headLineNum 读取行数， 表头第一行为 0
     * @return 返回对象的集合
     */
    public static List<Object> readExcelWithModel(MultipartFile excel, Class<? extends BaseRowModel> clazz,
                                                  int sheetNo, int headLineNum) throws IOException {
        ExcelTypeEnum typeEnum = null;
        String filename = excel.getOriginalFilename();
        if (filename == null || (!filename.toLowerCase().endsWith(".xls") && !filename.toLowerCase().endsWith(".xlsx"))) {
            throw new NormalException(BaseResult.ERROR, "文件格式错误！");
        }
        if (filename.toLowerCase().endsWith(".xls")) {
            typeEnum = ExcelTypeEnum.XLS;
        } else {
            typeEnum = ExcelTypeEnum.XLSX;
        }
        // 解析每行结果在listener中处理
        ModelExcelListener listener = new ModelExcelListener();
        ExcelReader excelReader = new ExcelReader(excel.getInputStream(), typeEnum, null, listener);
        // 默认只有一列表头
        excelReader.read(new Sheet(sheetNo, headLineNum, clazz));
        return listener.getDatas();
    }

    /**
     * 模型 解析监听器
     */
    private static class ModelExcelListener extends AnalysisEventListener {
        private List<Object> datas = new ArrayList<>();

        @Override
        public void invoke(Object object, AnalysisContext context) {
            datas.add(object);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
        }

        public List<Object> getDatas() {
            return datas;
        }

        public void setDatas(List<Object> datas) {
            this.datas = datas;
        }
    }

}
