package ua.com.vza.work.doc.kay.quality.crud.interfaces;

import java.util.List;

/**
 * Created by kycenko on 16.06.15.
 */
public interface CrudFactory<T> {
    //Создает новую запись
    public T create(T obj);

    //Обновляет запись выбраного объекта
    public void update(T obj);

    //Удаляет запись по id
    public void delete(long id);

    //Возвращает объект записи по id
    public T getById(long id);

    //Возвращает объект записи по совпадениям
    public List<T> getByLike(String name);

    //Возвращает список объектов
    public List<T> getAll(int pageNumber);


}
