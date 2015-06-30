package ua.com.vza.work.doc.kay.quality.crud;

import ua.com.vza.work.doc.kay.quality.crud.abstracts.CrudAbstractFactory;
import ua.com.vza.work.doc.kay.quality.entity.SprMeasure;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by kycenko on 24.06.15.
 */
@Stateless
public class SprMeasureCrud extends CrudAbstractFactory<SprMeasure> {
    public static final String TABLEOBJECT = "SprMeasure";

    public SprMeasureCrud() {
        super(TABLEOBJECT);
    }

    @Override
    public SprMeasure create(SprMeasure obj) {
        return super.create(obj);
    }

    @Override
    public void update(SprMeasure person) {
        super.update(person);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public SprMeasure getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<SprMeasure> getByLike(String name) {
        return super.getByLike(name);
    }

    @Override
    public List<SprMeasure> getAll(int pageNumber) {
        return super.getAll(pageNumber);
    }
}
