package com.mzhotel.sm.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.jeecgframework.poi.excel.export.ExcelExportServer;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    public static Workbook exportExcel(List<Map<String, Object>> list, ExcelType type) {
        Workbook workbook;
        if (ExcelType.HSSF.equals(type)) {
            workbook = new HSSFWorkbook();
        } else {
            workbook = new XSSFWorkbook();
        }
        for (Map<String, Object> map : list) {
            ExcelExportServer server = new ExcelExportServer();
            ExportParams params = (ExportParams) map.get("params");
            Class<?> entry = (Class<?>) map.get("entity");
            Collection<?> data = (Collection<?>) map.get("data");
            server.createSheet(workbook, params, entry, data);
        }
        return workbook;
    }
}
