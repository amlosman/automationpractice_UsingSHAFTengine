package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExcelFileManage {

    private File spreadsheet;
    private Sheet currentSheet;
    private Map<String, Integer> columns;

    public ExcelFileManage(File file) {
	spreadsheet = file;
	columns = new HashMap<String, Integer>();
    }

    public void switchToSheet(String name) {
	try (Workbook workbooks = WorkbookFactory.create(spreadsheet)) {
	    currentSheet = workbooks.getSheet(name);
	    currentSheet.getRow(0).forEach(cell -> {
		columns.put(cell.getStringCellValue(), cell.getColumnIndex());
	    });
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public String getCellData(String column, int row) {
	Row dataRow = currentSheet.getRow(row - 1);
	return getCellDataAsString(dataRow.getCell(columns.get(column)));
    }

    private String getCellDataAsString(Cell cell) {
//	return switch (cell.getCellType()) {
//	case STRING -> cell.getStringCellValue();
//	case NUMERIC -> String.valueOf((int) cell.getNumericCellValue());
//	default -> "";
//	};
	switch (cell.getCellType()) {
	case STRING:
	    return cell.getStringCellValue();
	case NUMERIC:
	    return String.valueOf((int) cell.getNumericCellValue());
	default:
	    return null;
	}

    }
}