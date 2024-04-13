package ru.onlineStore.eshop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Класс сущности категории со свойствами id, name, product
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Getter
@Setter
@Entity
public class Category {

    /**
     * Поле id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Поле name
     */
    private String name;

    /**
     * Поле product
     */
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> product;
}
