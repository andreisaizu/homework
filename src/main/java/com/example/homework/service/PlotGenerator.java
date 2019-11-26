package com.example.homework.service;

import com.example.homework.bean.XmlBean;
import com.example.homework.dtos.PdfObject;
import com.googlecode.charts4j.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class PlotGenerator {

    public static JFreeChart generatePieChart() {
        DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue("China", 19.64);
        dataSet.setValue("India", 17.3);
        dataSet.setValue("United States", 4.54);
        dataSet.setValue("Indonesia", 3.4);
        dataSet.setValue("Brazil", 2.83);
        dataSet.setValue("Pakistan", 2.48);
        dataSet.setValue("Bangladesh", 2.38);

        JFreeChart chart = ChartFactory.createPieChart(
                "World Population by countries", dataSet, true, true, false);
        return chart;
    }

    public static JFreeChart generateBarChart() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(791, "Population", "1750 AD");
        dataSet.setValue(978, "Population", "1800 AD");
        dataSet.setValue(1262, "Population", "1850 AD");
        dataSet.setValue(1650, "Population", "1900 AD");
        dataSet.setValue(2519, "Population", "1950 AD");
        dataSet.setValue(6070, "Population", "2000 AD");

        JFreeChart chart = ChartFactory.createBarChart(
                "Salaries intervals", "Year", "Population in millions",
                dataSet, PlotOrientation.VERTICAL, false, true, false);

        return chart;
    }

    public static DefaultCategoryDataset generatePieChartHomework(DefaultCategoryDataset dataSet, List<XmlBean> objectList, Integer min, Integer max) {
        Iterator<XmlBean> iterator = objectList.iterator();
        Integer x =0;
        while (iterator.hasNext()) {
            XmlBean dbItem = iterator.next();
            x++;
        }
       // dataSet.setValue((min.toString()+"-"+max.toString()), x);
        return dataSet;
    }

    public static DefaultCategoryDataset generateBarChartHomework(DefaultCategoryDataset dataSet, List<XmlBean> objectList, Integer min, Integer max) {
        Iterator<XmlBean> iterator = objectList.iterator();
        Integer x =0;
        while (iterator.hasNext()) {
            XmlBean dbItem = iterator.next();
            x++;
        }
        dataSet.setValue(x, "Population", (min.toString()+"-"+max.toString()));
        return dataSet;
    }

}
