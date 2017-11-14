package com.javarush.task.task28.task2810.model;


import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {

    //private static final String URL_FORMAT = "https://javarush.ru/testdata/big28data.html";
    //private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+киев";
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    //private static final String URL_FORMAT = "http://hh.ru/search/vacancy";
    //private static final String userAgent = "Mozilla/5.0 (jsoup)";
    //private static final int timeout = 5 * 1000;


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        Document doc=null;
        int page=0;
        while (true){
            try {
                doc=getDocument(searchString, page);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //List<Element> elements=doc.getElementsByAttribute("vacancy-serp__vacancy");
            Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
            if (elements.size()==0) break;

            for (Element element : elements) {
                // title
                Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                String title = titleElement.text();

                // salary
                Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                String salary = "";
                if (salaryElement != null) {
                    salary = salaryElement.text();
                }

                // city
                String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();

                // company
                String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();

                // site
                String siteName = "http://hh.ua/";

                // url
                String url = titleElement.attr("href");


                // add vacancy to the list
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(title);
                vacancy.setSalary(salary);
                vacancy.setCity(city);
                vacancy.setCompanyName(companyName);
                vacancy.setSiteName(siteName);
                vacancy.setUrl(url);
                vacancies.add(vacancy);
            }
            page++;
        }


      return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException{

        String url=String.format(URL_FORMAT, searchString, page);

        return  Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                .referrer("no-referrer-when-downgrade").get();
    }

    //try {

    //Document doc = getDocument(searchString, 3);
    //Document doc =Jsoup.connect(String.format("%s?text=%s&page=%s",URL_FORMAT, searchString, 3))
    //        .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
    //        .timeout(5000)
    //        .referrer("http://google.ru")
    //        .get();
    //Document doc = Jsoup.connect(String.format(URL_FORMAT, "Kiev", 1)).userAgent(userAgent).referrer("none").get();
    //String referer = "http://hh.ua/search/vacancy?text=java+%D0%9A%D0%B8%D0%B5%D0%B2&area=0";
    //String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36";
    //Document doc = Jsoup.connect(String.format(URL_FORMAT, "Kiev", 1)).userAgent(userAgent).get();
    //Document document = Jsoup.connect(URL_FORMAT)
    //        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
    //        .referrer("no-referrer-when-downgrade").get();

    //}

    //catch (IOException e){
    //    e.printStackTrace();
    //}
}
