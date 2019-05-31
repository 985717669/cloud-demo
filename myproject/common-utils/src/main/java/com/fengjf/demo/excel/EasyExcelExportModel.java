package com.fengjf.demo.excel;

import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.List;

/**
 * Author fengjf
 * Desc  easyExcel 导出模型
 */
@Data
public class EasyExcelExportModel {
    private List<? extends BaseRowModel> list;
    private String sheetName;
    private Class className;

    public EasyExcelExportModel(List<? extends BaseRowModel> list, String sheetName, Class className) {
        this.list = list;
        this.sheetName = sheetName;
        this.className = className;
    }
}
