package ru.isu.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Корневой тэг
 * @author Сергей
 */
@XmlRootElement(name = "answers")
public class Root {
    @XmlElement(name = "top5Sellers")
    private Child childOne;

    @XmlElement(name = "top5SaleDates")
    private Child childTwo;

    public Root() {
        childOne = new Child();
        childTwo = new Child();
    }

    public Child getChildOne() {
        return childOne;
    }

    public Child getChildTwo() {
        return childTwo;
    }

    /**
     * Добавление продавца с количеством проданных товаров
     * @param firstName имя и фамилия продавца
     * @param value количество проданных товаров
     */
    public void addSeller(String firstName, String secondName, int value) {
        childOne.addElement(new Element(firstName + " " + secondName, value));
    }

    /**
     * Добавление даты с количеством проданных товаров
     * @param date дата продажи
     * @param value количество проданных товаров
     */
    public void addDate(LocalDate date, int value) {
        childTwo.addElement(new Element(date.toString(), value));
    }
}
