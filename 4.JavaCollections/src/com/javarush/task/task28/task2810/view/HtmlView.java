package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {

    private Controller controller;
    private final String filePath="./src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";
    //private final String filePath="D:\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task28\\task2810\\view\\vacancies.html";

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies){
        Document document=null;
        try {
             document = getDocument();
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        Element element = document.getElementsByClass("template").first();
        Element copyElement=element.clone();
        copyElement.removeAttr("style");
        copyElement.removeClass("template");

        document.select("tr[class=vacancy]").remove().not("tr[class=vacancy template");
        for (Vacancy vacancy : vacancies) {
            Element localClone = copyElement.clone();
            localClone.getElementsByClass("city").first().text(vacancy.getCity());
            localClone.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
            localClone.getElementsByClass("salary").first().text(vacancy.getSalary());
            Element link =localClone.getElementsByTag("a").first();
            link.text(vacancy.getTitle());
            link.attr("href", vacancy.getUrl());

            element.before(localClone.outerHtml());
        }



        return document.html();
    }

    private void updateFile(String s){
        try {
            FileWriter fileWriter = new FileWriter(new File(filePath));
            fileWriter.write(s);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }

    @Override
    public void update(List<Vacancy> vacancies) {
        //System.out.println(vacancies.size());
        updateFile(getUpdatedFileContent(vacancies));

    }

    @Override
    public void setController(Controller controller) {
        this.controller=controller;

    }
}
