package ru.onlineStore.eshop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Класс сущности корзины со свойствами id, personId, productId
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_cart")
public class Cart {

    /**
     * Поле id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Поле personId
     */
    @Column(name = "person_id")
    private int personId;

    /**
     * Поле productId
     */
    @Column(name = "product_id")
    private int productId;

    /**
     * Конструктор - создание нового объекта
     *
     * @param personId  - id пользователя
     * @param productId - id товара
     * @see Cart#Cart(int, int)
     */
    public Cart(int personId, int productId) {
        this.personId = personId;
        this.productId = productId;
    }
}
