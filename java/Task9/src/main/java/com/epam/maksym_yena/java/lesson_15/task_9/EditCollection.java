package com.epam.maksym_yena.java.lesson_15.task_9;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EditCollection {

    public static void checkCollection(List<Ticket> arrayList) throws IOException {
        List<Ticket> tmp = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).category.contains("STANDART")) {
                tmp.add(arrayList.get(i));
            }
        }
        toJSON(tmp);
    }

    public static void toJSON(List<Ticket> tickets) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String fileName = "tickets.txt";
        mapper.writeValue(new File(fileName), tickets);
        System.out.println("json created!");
        fromJSON(fileName);
        toExcel(tickets);
    }

    public static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void fromJSON(String filename) throws IOException {
        System.out.println("from json to object");
        int counter = 0;

        String jsonObject = readUsingFiles(filename);

        ObjectMapper mapper = new ObjectMapper();
        List<Ticket> tickets = mapper.readValue(jsonObject, new TypeReference<List<Ticket>>() {});
        for(Ticket ticket :  tickets) {
            counter++;
            System.out.println("Object №" + counter  + "  = " + ticket);
        }
        System.out.println("converting succesfully!");
    }

    private static HSSFCellStyle createCell(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void toExcel(List<Ticket> arrayList) throws IOException {
        System.out.println("creating excel file");
        int rowCount = 0;
        Cell cell;
        Row row;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Tickets sheet");
        HSSFCellStyle style = createCell(workbook);
        row = sheet.createRow(rowCount);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("id");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("title");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("category");
        cell.setCellStyle(style);

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("place");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("data");
        cell.setCellStyle(style);

        int counter = 0;
        for (Ticket ticket : arrayList) {
            rowCount++;
            row = sheet.createRow(rowCount);

            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(ticket.getId());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(ticket.getTitle());

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(ticket.getCategory());

            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue(ticket.getPlace());

            cell = row.createCell(4, CellType.STRING);
            cell.setCellFormula(ticket.data);

            File file = new File("C:/task9/tickets.xls");

            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            counter++;
        }
        System.out.println("Size of tickets.xls = " + counter + " objects");
    }
}
