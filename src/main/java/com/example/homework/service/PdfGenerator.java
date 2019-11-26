package com.example.homework.service;

import com.example.homework.dtos.PdfObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.util.Matrix;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Slf4j
public class PdfGenerator {
    PdfObject pdfObject;

    public PdfGenerator(PdfObject pdfObject){
        this.pdfObject = pdfObject;
    }

//    public void generateDocument() throws IOException {
//        PDDocument document = new PDDocument();
//        PDPage page = new PDPage();
//        document.addPage(page);
//        PDFont fontNormal = PDType1Font.HELVETICA;
//        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
//        PDPageContentStream contentStream =new PDPageContentStream(document, page);
//        contentStream.beginText();
//        contentStream.newLineAtOffset(0, 700);
//        contentStream.setFont(fontBold, 15);
//        contentStream.showText("Name: ");
//        contentStream.setFont(fontNormal, 15);
//        contentStream.showText (pdfObject.getName());
//        contentStream.newLineAtOffset(200, 0);
//        contentStream.setFont(fontBold, 15);
//        contentStream.showText("Surname: ");
//        contentStream.setFont(fontNormal, 15);
//        contentStream.showText (pdfObject.getSurname());
//        contentStream.newLineAtOffset(-200, -50);
//        contentStream.setFont(fontBold, 15);
//        contentStream.showText("Salary: ");
//        contentStream.setFont(fontNormal, 15);
//        contentStream.showText (pdfObject.getSalary().toString() +" lei");
//        contentStream.newLineAtOffset(0, -50);
//        contentStream.setFont(fontBold, 15);
//        contentStream.showText("Extra salary: ");
//        contentStream.setFont(fontNormal, 15);
//        contentStream.showText (pdfObject.getExtraSalary().toString());
//        contentStream.newLineAtOffset(0, -50);
//        contentStream.setFont(fontBold, 15);
//        contentStream.showText("Tax: ");
//        contentStream.setFont(fontNormal, 15);
//        contentStream.showText (pdfObject.getTax().toString() + "%");
//        contentStream.newLineAtOffset(0, -50);
//        contentStream.setFont(fontBold, 15);
//        contentStream.showText("Net salary: ");
//        Integer x = pdfObject.getSalary() -  (pdfObject.getSalary() *pdfObject.getTax())/100;
//        contentStream.showText (x.toString()+" lei");
//        contentStream.newLineAtOffset(0, -50);
//        contentStream.setFont(fontBold, 15);
//        contentStream.showText("Yearly salary: ");
//        Integer y = (x * 12) + pdfObject.getExtraSalary()*x;
//        contentStream.showText (y.toString() + " lei");
//        contentStream.setFont(fontNormal, 15);
//
//        contentStream.endText();
//        contentStream.close();
//        document.save("homework.pdf");
//        log.info("pdf written");
//    }

    public static void generatePdfWithChart(String chart) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDFont fontNormal = PDType1Font.HELVETICA;
        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
        PDPageContentStream contentStream =new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.newLineAtOffset(0, 700);
        contentStream.setFont(fontBold, 15);
        contentStream.showText (chart);
        contentStream.endText();
        contentStream.close();
        document.save("homework_chart.pdf");
    }
}
