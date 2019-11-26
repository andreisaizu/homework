package com.example.homework.service;


import com.example.homework.dtos.PdfObject;
import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import org.jfree.chart.JFreeChart;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class GeneratePdfService {

    public void generatePdf(PdfObject pdfObject) throws IOException {
        PdfGenerator pdfGenerator = new PdfGenerator(pdfObject);
       // pdfGenerator.generateDocument();
    }


    public static void writeChartToPDF(JFreeChart chart, int width, int height, String fileName) {
        PdfWriter writer = null;

//        Document document = new Document();
//
//        try {
//            writer = PdfWriter.getInstance(document, new FileOutputStream(
//                    fileName));
//            document.open();
//            PdfContentByte contentByte = writer.getDirectContent();
//            PdfTemplate template = contentByte.createTemplate(width, height);
//            Graphics2D graphics2d = template.createGraphics(width, height,
//                    new DefaultFontMapper());
//            Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width,
//                    height);
//
//            chart.draw(graphics2d, rectangle2d);
//
//            graphics2d.dispose();
//            contentByte.addTemplate(template, 0, 0);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
      //  document.close();
    }


}
