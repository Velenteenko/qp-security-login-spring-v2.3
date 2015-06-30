package ua.com.vza.work.doc.kay.quality.crud;

import ua.com.vza.work.doc.kay.quality.crud.abstracts.CrudAbstractFactory;
import ua.com.vza.work.doc.kay.quality.entity.SprProductType;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by kycenko on 23.06.15.
 */
@Stateless
public class SprProductTypeCrud extends CrudAbstractFactory<SprProductType> {
    public static final String TABLEOBJECT = "SprProductType";

    public SprProductTypeCrud() {
        super(TABLEOBJECT);
    }

    @Override
    public SprProductType create(SprProductType obj) {
        return super.create(obj);
    }

    @Override
    public void update(SprProductType person) {
        super.update(person);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public SprProductType getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<SprProductType> getByLike(String name) {
        return super.getByLike(name);
    }

    @Override
    public List<SprProductType> getAll(int pageNumber) {
        return super.getAll(pageNumber);
    }
}
