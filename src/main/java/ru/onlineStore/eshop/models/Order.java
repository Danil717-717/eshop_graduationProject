package ru.onlineStore.eshop.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.onlineStore.eshop.enums.Status;

import java.time.LocalDateTime;

/**
 * Класс сущности заказ со свойствами id, number, product, person,
 * count, price, dateTime, status
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    /**
     * Поле id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Поле number
     */
    private String number;

    /**
     * Поле product
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Product product;

    /**
     * Поле person
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Person person;

    /**
     * Поле count
     */
    private int count;

    /**
     * Поле price
     */
    private float price;

    /**
     * Поле dateTime
     */
    private LocalDateTime dateTime;

    /**
     * Поле status
     */
    private Status status;

    /**
     * Метод автоматического указания времени создания
     */
    @PrePersist
    private void init() {
        dateTime = LocalDateTime.now();
    }

    /**
     * Конструктор - создание нового объекта
     *
     * @param number  - номер
     * @param product - товар
     * @param person  - пользователь
     * @param count   - количество
     * @param price   - стоимость
     * @param status  - статус
     * @see Order#Order(String, Product, Person, int, float, Status)
     */
    public Order(String number, Product product, Person person, int count, float price, Status status) {
        this.number = number;
        this.product = product;
        this.person = person;
        this.count = count;
        this.price = price;
        this.status = status;
    }
}
