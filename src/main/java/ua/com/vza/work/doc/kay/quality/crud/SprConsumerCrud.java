package ua.com.vza.work.doc.kay.quality.crud;

import ua.com.vza.work.doc.kay.quality.crud.abstracts.CrudAbstractFactory;
import ua.com.vza.work.doc.kay.quality.entity.SprConsumer;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by kycenko on 24.06.15.
 */
@Stateless
public class SprConsumerCrud extends CrudAbstractFactory<SprConsumer> {
    public static final String TABLEOBJECT = "SprConsumer";

    public SprConsumerCrud() {
        super(TABLEOBJECT);
    }

    @Override
    public SprConsumer create(SprConsumer obj) {
        return super.create(obj);
    }

    @Override
    public void update(SprConsumer person) {
        super.update(person);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public SprConsumer getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<SprConsumer> getByLike(String name) {
        return super.getByLike(name);
    }

    @Override
    public List<SprConsumer> getAll(int pageNumber) {
        return super.getAll(pageNumber);
    }
}
