package ru.tusur.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPages;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


import ru.tusur.service.EmployeesService;
import ru.tusur.util.DateUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import padeg.lib.*;

@Service
public class ReportService {

    private static final String APPLICATION_CTX = "classpath:spring/applicationContext.xml";

    private static final String REPORTS_FONT = "classpath:font/tahoma.ttf";

    @Autowired
    private EmployeesService employeesService;

    private Font font;

    public byte[] prikazAddPostEmployees(String family, String name, String middleName, String post) throws DocumentException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Document pdfDocument = initReport("Приказ о принятии сотрудника на работу", baos);

        font.setSize(14);
        font.setStyle(Font.BOLD);

        Paragraph title1 = new Paragraph("ПРИКАЗ",font);
        title1.setAlignment(Element.ALIGN_CENTER);

        pdfDocument.add(title1);

        font.setStyle(Font.NORMAL);
        Paragraph someText = new Paragraph(" ");
        //someText.setAlignment(TextElementArray.ALIGN_CENTER);
        pdfDocument.add(someText);

        someText = new Paragraph("         Приказываю принять на работу в должности "
                + post +",",font);
        pdfDocument.add(someText);

        someText = new Paragraph("" + Padeg.getFIOPadegAS(family, name, middleName, 2) + ".", font);
        pdfDocument.add(someText);

        someText = new Paragraph("На постоянной основе, без испытательного срока",font);
        pdfDocument.add(someText);


        someText = new Paragraph(" ");
        pdfDocument.add(someText);
        someText = new Paragraph(" ");
        pdfDocument.add(someText);

        someText = new Paragraph("" + DateUtils.stringFromLocalDate(LocalDate.now()) +"                                   "
                +"____________Кунгуров А.Н", font);
        pdfDocument.add(someText);


          pdfDocument.close();
        return baos.toByteArray();
    }

    public byte[] prikazEditPostEmployees(String family, String name, String middleName, String post) throws DocumentException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Document pdfDocument = initReport("Приказ об изменении должности сотруника", baos);

        font.setSize(14);
        font.setStyle(Font.BOLD);

        Paragraph title1 = new Paragraph("ПРИКАЗ",font);
        title1.setAlignment(Element.ALIGN_CENTER);

        pdfDocument.add(title1);

        font.setStyle(Font.NORMAL);
        Paragraph someText = new Paragraph(" ");
        //someText.setAlignment(TextElementArray.ALIGN_CENTER);
        pdfDocument.add(someText);

        someText = new Paragraph("         Приказываю утвердить на новую должность "
                + post +",",font);
        pdfDocument.add(someText);

        someText = new Paragraph("" + Padeg.getFIOPadegAS(family, name, middleName, 2) + ".", font);
        pdfDocument.add(someText);

        someText = new Paragraph("Без измененния оклада.",font);
        pdfDocument.add(someText);


        someText = new Paragraph(" ");
        pdfDocument.add(someText);
        someText = new Paragraph(" ");
        pdfDocument.add(someText);

        someText = new Paragraph("" + DateUtils.stringFromLocalDate(LocalDate.now()) +"                                   "
                +"____________Кунгуров А.Н", font);
        pdfDocument.add(someText);


        pdfDocument.close();
        return baos.toByteArray();
    }

    /*public byte[] requestsInPeriod(LocalDate from, LocalDate to) throws IOException, DocumentException {
        List<Request> reportRequests = requestService.requestsInRange(from, to);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document pdfDocument = initReport("Заявки за период", baos);
        font.setSize(12);
        PdfPTable table = new PdfPTable(5);
        table.addCell(paragraph("ID"));
        table.addCell(paragraph("Заголовок"));
        table.addCell(paragraph("Желаемая дата"));
        table.addCell(paragraph("Крайний срок"));
        table.addCell(paragraph("Назначена на"));
        for (Request request : reportRequests) {
            table.addCell(paragraph(Integer.toString(request.getId())));
            table.addCell(paragraph(request.getTitle()));
            table.addCell(paragraph(DateUtils.stringFromLocalDate(request.getTargetDate())));
            table.addCell(paragraph(DateUtils.stringFromLocalDate(request.getDueDate())));
            table.addCell(paragraph(request.getAssignee().getEmail()));
        }
        pdfDocument.add(table);
        pdfDocument.close();
        return baos.toByteArray();
    } */

    private Document initReport(String header, ByteArrayOutputStream baos) throws DocumentException, IOException {
        Document pdfDocument = new Document();
        PdfWriter.getInstance(pdfDocument, baos);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(APPLICATION_CTX);
        Resource resource = applicationContext.getResource(REPORTS_FONT);
        BaseFont baseFont = BaseFont.createFont(resource.getFile().getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        font = new Font(baseFont);
        pdfDocument.open();
        Paragraph paragraph = new Paragraph(header, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        font.setSize(24);
        paragraph.setFont(font);
        return pdfDocument;
    }

    private Paragraph paragraph(String text) {
        return new Paragraph(text, font);
    }

}