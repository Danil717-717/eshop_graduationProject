package ru.onlineStore.eshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.onlineStore.eshop.models.Cart;
import ru.onlineStore.eshop.repositories.CartRepository;

import java.util.List;

/**
 * Сервис корзин
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Service
@Transactional(readOnly = true)
public class CartService {

    /**
     * Поле cartRepository
     */
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    /**
     * Поиск корзин по id пользователя
     *
     * @param id id пользователя
     * @return список корзин
     */
    public List<Cart> findByPersonId(int id) {
        return cartRepository.findByPersonId(id);
    }

    /**
     * Удаление корзины по id товара
     *
     * @param id товара
     */
    @Transactional
    public void deleteCartByProductId(int id) {
        cartRepository.deleteCartByProductId(id);
    }

    /**
     * Создание корзины
     *
     * @param cart корзина
     * @return корзина
     */
    @Transactional
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }
}
