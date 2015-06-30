package ua.com.vza.work.doc.kay.quality.crud;

import ua.com.vza.work.doc.kay.quality.crud.abstracts.CrudAbstractFactory;
import ua.com.vza.work.doc.kay.quality.entity.SprMagazine;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Aleksandr on 21.06.15.
 */
@Stateless
public class SprMagazineCrud extends CrudAbstractFactory<SprMagazine> {
    public static final String TABLEOBJECT = "SprMagazine";

    public SprMagazineCrud() {
        super(TABLEOBJECT);
    }

    public SprMagazineCrud(String tableObject) {
        super(tableObject);
    }

    @Override
    public SprMagazine create(SprMagazine obj) {
        return super.create(obj);
    }

    @Override
    public void update(SprMagazine person) {
        super.update(person);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public SprMagazine getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<SprMagazine> getAll(int pageNumber) {
        return super.getAll(pageNumber);
    }
}
