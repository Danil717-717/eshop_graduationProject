package ru.onlineStore.eshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс сущности картинки со свойствами id, fileName, product
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {

    /**
     * Поле id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Поле fileName
     */
    private String fileName;

    /**
     * Поле product
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Product product;
}
