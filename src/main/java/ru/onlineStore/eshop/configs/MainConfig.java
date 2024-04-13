package ru.onlineStore.eshop.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Основной класс конфигурации
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Configuration
@ComponentScan("ru.onlineStore.eshop.utils")
public class MainConfig implements WebMvcConfigurer {

    /**
     * Путь загрузки изображений
     */
    @Value("${upload.path}")
    private String uploadPath;

    /**
     * Добавление пути сохранения изображений в ресурсы
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pics/**").addResourceLocations("file:///" + uploadPath + "/", "/images/");
    }
}
