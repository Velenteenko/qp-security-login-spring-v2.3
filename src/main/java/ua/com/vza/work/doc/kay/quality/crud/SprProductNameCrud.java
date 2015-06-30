package ua.com.vza.work.doc.kay.quality.crud;

import ua.com.vza.work.doc.kay.quality.crud.abstracts.CrudAbstractFactory;
import ua.com.vza.work.doc.kay.quality.entity.SprProductName;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by kycenko on 16.06.15.
 */
@Stateless
public class SprProductNameCrud extends CrudAbstractFactory<SprProductName> {
    public static final String TABLEOBJECT = "SprProductName";

    public SprProductNameCrud() {
        super(TABLEOBJECT);
    }

    @Override
    public SprProductName create(SprProductName obj) {
        return super.create(obj);
    }

    @Override
    public void update(SprProductName person) {
        super.update(person);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public SprProductName getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<SprProductName> getByLike(String name) {
        return super.getByLike(name);
    }

    @Override
    public List<SprProductName> getAll(int pageNumber) {
        return super.getAll(pageNumber);
    }
}
