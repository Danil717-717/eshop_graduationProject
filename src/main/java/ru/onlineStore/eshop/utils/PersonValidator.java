package ru.onlineStore.eshop.utils;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.onlineStore.eshop.models.Person;
import ru.onlineStore.eshop.services.PersonService;

/**
 * Клас вспомогательный, для проверки отсутствующих/повторяющихся сущностей Person
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Component
public class PersonValidator implements Validator {

    /**
     * Поле personService
     */
    private final PersonService personService;

    /**
     * Конструктор - создание нового объекта
     *
     * @param personService - сервис пользователя
     * @see PersonValidator#PersonValidator(PersonService)
     */
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Метод отсеивает классы на обрабатываемые и не обрабатываемые
     *
     * @param clazz класс
     * @return boolean значение
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    /**
     * Метод валидности объекта
     *
     * @param target объект
     * @param errors детали об ошибках
     */
    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personService.findByLogin(person) != null) {
            errors.rejectValue("login", "", "Логин занят!!!");
        }
    }
}
