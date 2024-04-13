package ru.onlineStore.eshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.onlineStore.eshop.models.Product;
import ru.onlineStore.eshop.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис товаров
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Service
@Transactional(readOnly = true)
public class ProductService {

    /**
     * Поле productRepository
     */
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Метод возвращает все товары
     *
     * @return список товаров
     */
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    /**
     * Метод поиска товара по id
     *
     * @param id id товара
     * @return найденный товар
     */
    public Product getProductId(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    /**
     * Метод сохранения товара
     *
     * @param product товар
     * @return сохраненный товар
     */
    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Обновление товара
     *
     * @param id      id товара, который будет изменен
     * @param product товар с обновленными данными
     * @return обновленный товар
     */
    @Transactional
    public Product updateProduct(int id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    /**
     * Удаление продукта по id
     *
     * @param id id продукта
     */
    @Transactional
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    /**
     * Метод для валидации товара
     *
     * @param product продукт
     * @return продукт
     */
    public Product getProductFindByTitle(Product product) {
        Optional<Product> product_db = productRepository.findByTitle(product.getTitle());
        return product_db.orElse(null);
    }
}
