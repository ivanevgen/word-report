package core;

/**
 * Класс представляет собой сущность с именем и информацией по упавшему тесту.
 */
public class Feature {
    private String name;
    private String info;

    public Feature(String name) {
        this.name = name;
    }

    public Feature(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}