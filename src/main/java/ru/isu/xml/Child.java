package ru.isu.xml;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Вложение в Root{@link Root}
 * @author Сергей
 */
public  class Child {
    @XmlElement(name = "element")
    private List<Element> elements;

    public Child() {
        this.elements = new ArrayList<>();
    }


    /**
     * Получение элементов
     * @return элементы
     */
    public List<Element> getElements() {
        return elements;
    }

    /**
     * Добавление элемента в список
     * @param element добавляемый элемент
     */
    public void addElement(Element element) {
        elements.add(element);
    }
}
