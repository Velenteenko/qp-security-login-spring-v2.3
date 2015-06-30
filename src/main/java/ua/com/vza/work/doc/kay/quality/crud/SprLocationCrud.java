package ua.com.vza.work.doc.kay.quality.crud;

import ua.com.vza.work.doc.kay.quality.crud.abstracts.CrudAbstractFactory;
import ua.com.vza.work.doc.kay.quality.entity.SprLocation;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by kycenko on 30.06.15.
 */
@Stateless
public class SprLocationCrud extends CrudAbstractFactory<SprLocation> {
    public static final String TABLEOBJECT = "SprLocation";

    public SprLocationCrud() {
        super(TABLEOBJECT);
    }

    @Override
    public SprLocation create(SprLocation obj) {
        return super.create(obj);
    }

    @Override
    public void update(SprLocation obj) {
        super.update(obj);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public SprLocation getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<SprLocation> getByLike(String name) {
        return super.getByLike(name);
    }

    @Override
    public List<SprLocation> getAll(int pageNumber) {
        return super.getAll(pageNumber);
    }
}
