package org.example;

import java.io.Serializable;

public class Resources implements Serializable {
    public String name;

    public Resources(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
