package ru.isu.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Вложение в Child{@link Child}
 * @author Сергей
 */
public class Element {
    @XmlElement
    private String key;
    @XmlElement
    private int value;

    public Element(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
