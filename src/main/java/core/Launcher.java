package core;

import org.apache.poi.xwpf.usermodel.*;
import org.openqa.selenium.WebDriver;
import selen.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Launcher {
    private static String succes; // количество успешных тестов
    private static String failed; // количество упавших тестов

    private static List<Feature> collectDataForReport(String url) {
        ArrayList<Feature> list = new ArrayList<Feature>();
        WebDriver driver = Util.createDriver(url);

        list.add(new Feature("CRM1-T1102", "Unable to get Element 10 sec"));
        list.add(new Feature("CRM1-T116", "Unable to get browser"));

        //succes = driver.findElement(By.xpath());
        //failed = driver.findElement(By.xpath());

        driver.quit();
        return list;
    }

    private static void createReport(List<Feature> features, String url) throws IOException {
        XWPFDocument document = new XWPFDocument();
        FileOutputStream out = new FileOutputStream(new File("C:/Users/79586/Desktop/createdocument.docx"));

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun xwpfRun = paragraph.createRun();

        // Шапка отчёта для информативности
        xwpfRun.setText("Окружение: Препрод");
        xwpfRun.addBreak();
        String link = url;
        xwpfRun.setText("Ссылка на прогон: " + link);
        xwpfRun.addBreak();
        xwpfRun.setText("Успешно: " + succes);
        xwpfRun.addBreak();
        xwpfRun.setText("Провалено: " + failed);
        xwpfRun.addBreak();
        xwpfRun.setText("Всего: " + "150");
        xwpfRun.addBreak();

        XWPFTable table = document.createTable();
        XWPFTableRow tableRow = table.getRow(0);

        // сделаем 3 столбца у таблицы
        tableRow.getCell(0).setText("Номер теста");
        tableRow.addNewTableCell().setText("Причина");
        tableRow.addNewTableCell().setText("Комментарии");

        // в цикле создаем ячейки под каждый параметр объекта Feature
        for(Feature feature : features) {
            XWPFTableRow row = table.createRow();
            row.getCell(0).setText(feature.getName());
            row.getCell(1).setText(feature.getInfo());
        }

        document.write(out);
        out.close();
    }

    public static void main(String[] args) throws IOException {
        // Пройти по аллюр отчёту, ссылку на отчёт передадим через командную строку
        List<Feature> featureList = collectDataForReport(args[0]);

        // Создать отчёт
        createReport(featureList, args[0]);
    }
}
