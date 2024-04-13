package ru.onlineStore.eshop.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onlineStore.eshop.models.Category;

/**
 * Репозиторий категорий
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * Метод поиска категории по названию
     *
     * @param name название категории
     * @return категория
     */
    Category findByName(String name);
}