package com.course.api.ExportExcel;

import com.course.api.entity.Invoice;
import com.course.api.entity.InvoiceDetail;
import com.course.api.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportListClass {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void exportClass(List<Student> students, String fileName, String className) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Students sheet");

        int rownum = 0;
        Cell cell;
        Row row;
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);
        row.setHeight((short) 600);
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Danh sách lớp : " + className);

        sheet.addMergedRegion( new CellRangeAddress(0,0,2,6) );

        rownum++;
        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Id");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Họ tên");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("CMND");
        cell.setCellStyle(style);

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Ngày sinh");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Giới tính");
        cell.setCellStyle(style);

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Địa chỉ");
        cell.setCellStyle(style);

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Email");
        cell.setCellStyle(style);

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Số điện thoại");
        cell.setCellStyle(style);


        for (Student stu:
                students) {
            rownum++;
            row = sheet.createRow(rownum);
            if(stu != null) {
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(stu.getIdStudent());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(stu.getStudentName());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(stu.getCmnd());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(stu.getStudentDate());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(stu.getSex() == 1 ? "Nam" : "Nữ");

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(stu.getAddress());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(stu.getEmail());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(stu.getPhone());
            }
        }

        File file = new File("F:\\" + fileName + ".xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
    }

    public static void exportInvoice(List<Student> students, Invoice invoice, String fileName) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Inovice sheet");

        int rownum = 0;
        Cell cell;
        Row row;
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);
        row.setHeight((short) 600);
        cell = row.createCell(2, CellType.STRING);
        if(invoice != null)
            cell.setCellValue("Hóa đơn có id là : " + invoice.getIdInvoice());

        sheet.addMergedRegion( new CellRangeAddress(0,0,2,6) );

        rownum++;
        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Id");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Lớp/Khóa học");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Nhân viên");
        cell.setCellStyle(style);

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Họ tên");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Ngày lập");
        cell.setCellStyle(style);

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Nhóm");
        cell.setCellStyle(style);

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Phương thức thanh toán");
        cell.setCellStyle(style);

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Tổng tiền");
        cell.setCellStyle(style);

        rownum++;
        row = sheet.createRow(rownum);

        if(invoice != null) {
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(invoice.getIdInvoice());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(invoice.getClazz().getClassName() + "/" + invoice.getClazz().getCourse().getCourse() + "-" + invoice.getClazz().getCourse().getLevel().getLevel());

            cell = row.createCell(2, CellType.STRING);
            if(invoice.getEmployee() != null)
                cell.setCellValue(invoice.getEmployee().getEmployeeName());

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(invoice.getStudentName());

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(invoice.getDateInvoice());

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(invoice.getGroupNum() + " người");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(invoice.getPayment());

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue(invoice.getCost());
        }

        rownum++;
        row = sheet.createRow(rownum);

        row.setHeight((short) 600);
        cell = row.createCell(2, CellType.STRING);
        if(invoice != null)
            cell.setCellValue("Chi tiết : " );

        sheet.addMergedRegion( new CellRangeAddress(3,3,2,6) );

        rownum++;
        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Id");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Họ tên");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("CMND");
        cell.setCellStyle(style);

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Ngày sinh");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Giới tính");
        cell.setCellStyle(style);

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Địa chỉ");
        cell.setCellStyle(style);

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Email");
        cell.setCellStyle(style);

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Số điện thoại");
        cell.setCellStyle(style);

        for (Student stu:
                students) {
            rownum++;
            row = sheet.createRow(rownum);
            if(stu != null) {
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(stu.getIdStudent());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(stu.getStudentName());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(stu.getCmnd());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(stu.getStudentDate());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(stu.getSex() == 1 ? "Nam" : "Nữ");

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(stu.getAddress());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(stu.getEmail());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(stu.getPhone());
            }
        }

        File file = new File("F:\\" + fileName + ".xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
    }
}
