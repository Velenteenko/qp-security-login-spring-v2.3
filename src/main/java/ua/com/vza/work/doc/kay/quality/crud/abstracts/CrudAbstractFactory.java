package ua.com.vza.work.doc.kay.quality.crud.abstracts;

import ua.com.vza.work.doc.kay.quality.crud.interfaces.CrudFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.BadRequestException;
import java.util.List;

/**
 * Created by kycenko on 16.06.15.
 */
@Stateless
public class CrudAbstractFactory<T> implements CrudFactory<T> {
    @PersistenceContext(unitName = "QP")
    private EntityManager em;

    private String tableObject;

    public CrudAbstractFactory(){}

    public CrudAbstractFactory(String tableObject) {
        this.tableObject = tableObject;
    }

    public T create(T obj) {
        if(obj == null)
            throw new BadRequestException();
        return em.merge(obj);
    }

    public void update(T obj) {
        create(obj);
    }

    public void delete(long id) {
        em.remove(getById(id));
    }

    public T getById(long id) {
        return (T)em.find(Object.class, id);
    }

    public List<T> getByLike(String name) {
        Query query = em.createQuery("SELECT p FROM " + tableObject + " p WHERE UPPER(p.name) LIKE :param ORDER BY p.name");
        query.setParameter("param", name.toUpperCase() + "%");
        query.setMaxResults(20);
        List<T> resListLikeName = query.getResultList();
        return resListLikeName;
    }

    public List<T> getAll(int pageNumber) {
        TypedQuery<T> query = (TypedQuery<T>) em.createNamedQuery(tableObject+".getAll", Object.class);
        int pageSize = 20;
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<T> resList = query.getResultList();
        return resList;
    }
}
