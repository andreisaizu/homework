package com.example.homework.service;

import com.example.homework.bean.XmlBean;
import com.example.homework.dtos.PdfObject;
import com.example.homework.repository.XmlRepository;
import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import static com.example.homework.service.PdfGenerator.generatePdfWithChart;
import static com.example.homework.service.PlotGenerator.*;

@Service
public class ChartService {
    private GeneratePdfService generatePdfService;
    XmlRepository xmlRepository;
    public ChartService(GeneratePdfService generatePdfService, XmlRepository xmlRepository){
        this.generatePdfService = generatePdfService;
        this.xmlRepository =xmlRepository;
    }

    public void generateChartInPdf(PdfObject pdfObject) throws IOException {

        XmlBean xmlBean = XmlBean.builder()
                .id(UUID.randomUUID().toString())
                .period(pdfObject.getPeriod())
                .firstName(pdfObject.getName())
                .lastName(pdfObject.getSurname())
                .fee(pdfObject.getFee())
                .amount(pdfObject.getAmount())
                .build();
        xmlRepository.save(xmlBean);


        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        List<XmlBean> amountLentBetween1500And2000 = xmlRepository.findByAmountGreaterThanAndAmountLessThan(0, 100000);
        DefaultCategoryDataset dataSetBetween1500And2000 = generateBarChartHomework(dataSet, amountLentBetween1500And2000, 0, 100000);
        List<XmlBean> amountLentBetween2000And4000 = xmlRepository.findByAmountGreaterThanAndAmountLessThan(100000, 500000);
        DefaultCategoryDataset dataSetBetween2000And4000 = generateBarChartHomework(dataSetBetween1500And2000, amountLentBetween2000And4000, 100000, 500000);
        List<XmlBean> amountLentBetween4000And6000 = xmlRepository.findByAmountGreaterThanAndAmountLessThan(500000, 1000000);
        DefaultCategoryDataset dataSetBetween4000And6000 = generateBarChartHomework(dataSetBetween2000And4000, amountLentBetween4000And6000, 500000, 1000000);

        JFreeChart homeworkChart = ChartFactory.createBarChart(
                "Lent amount categories.", "Category", "Amount",
                dataSetBetween4000And6000, PlotOrientation.VERTICAL, false, true, false);

        String homeworkName = "homework.png";
        OutputStream outputHomework = new FileOutputStream(homeworkName);

        BufferedImage homeworkImage = homeworkChart.createBufferedImage( 550, 400, null);
        ImageIO.write( homeworkImage, "png", outputHomework );
    }


}
