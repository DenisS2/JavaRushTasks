package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    //private Provider[] providers;
    private Model model;

    public Controller(Model model) throws IllegalArgumentException {
        if (model==null) throw new IllegalArgumentException();
        this.model = model;
    }

    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }

    /*public Controller(Provider ... providers) {
        this.providers = providers;
        if (providers.length==0)  throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        List<Vacancy> list = new ArrayList<>();

        for (Provider p:providers) {
            list.addAll(p.getJavaVacancies("java"));
        }
        System.out.println(list.size());
    }*/

}
