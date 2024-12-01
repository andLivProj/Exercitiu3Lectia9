package org.example;

import java.io.Serializable;
import java.util.List;

public class Country implements Serializable {
    public String name;
    public List<Resources> resources;

    public Country(String name, List<Resources> resources) {
        this.name = name;
        this.resources = resources;
    }

    public void resourcesList(String countryName, List<Resources> countryResourcesList) {
        countryResourcesList.forEach(resource -> System.out.println(countryName + " are:  " + resource.name));
    }

    @Override
    public String toString() {
        return name + " are urmatoarele resurse: " + resources;
    }
}
