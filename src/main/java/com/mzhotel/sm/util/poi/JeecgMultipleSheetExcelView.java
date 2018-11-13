package com.mzhotel.sm.util.poi;

import com.mzhotel.sm.util.poi.entity.MultipleSheetExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.jeecgframework.poi.excel.export.ExcelExportServer;
import org.jeecgframework.poi.excel.view.MiniAbstractExcelView;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller(MultipleSheetExcelConstants.JEECG_MULTIPLE_SHEET_EXCEL_VIEW)
public class JeecgMultipleSheetExcelView extends MiniAbstractExcelView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String codedFileName = "临时文件";
        ExportParams exportParams = (ExportParams) model.get(MultipleSheetExcelConstants.PARAMS);
        Workbook workbook = exportExcel((List<Map<String, Object>>) model.get(MultipleSheetExcelConstants.MULTIPLLE_SHEET_LIST), exportParams.getType());
        if (model.containsKey(MultipleSheetExcelConstants.FILE_NAME)) {
            codedFileName = (String) model.get(MultipleSheetExcelConstants.FILE_NAME);
        }
        if (workbook instanceof HSSFWorkbook) {
            codedFileName += HSSF;
        } else {
            codedFileName += XSSF;
        }
        if (isIE(request)) {
            codedFileName = java.net.URLEncoder.encode(codedFileName, "UTF8");
        } else {
            codedFileName = new String(codedFileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("content-disposition", "attachment;filename=" + codedFileName);
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
    }

    public static Workbook exportExcel(List<Map<String, Object>> list, ExcelType type) {
        Workbook workbook;
        if (ExcelType.HSSF.equals(type)) {
            workbook = new HSSFWorkbook();
        } else {
            workbook = new XSSFWorkbook();
        }
        for (Map<String, Object> map : list) {
            ExcelExportServer server = new ExcelExportServer();
            server.createSheet(workbook, (ExportParams) map.get("title"), (Class<?>) map.get("entity"), (Collection<?>) map.get("data"));
        }
        return workbook;
    }

}
