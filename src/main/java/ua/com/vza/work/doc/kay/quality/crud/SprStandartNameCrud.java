package ua.com.vza.work.doc.kay.quality.crud;

import ua.com.vza.work.doc.kay.quality.crud.abstracts.CrudAbstractFactory;
import ua.com.vza.work.doc.kay.quality.entity.SprStandartName;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by kycenko on 23.06.15.
 */@Stateless
public class SprStandartNameCrud extends CrudAbstractFactory<SprStandartName> {
    public static final String TABLEOBJECT = "SprStandartName";

    public SprStandartNameCrud() {
        super(TABLEOBJECT);
    }

    @Override
    public List<SprStandartName> getAll(int pageNumber) {
        return super.getAll(pageNumber);
    }

    @Override
    public SprStandartName create(SprStandartName obj) {
        return super.create(obj);
    }

    @Override
    public void update(SprStandartName person) {
        super.update(person);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public SprStandartName getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<SprStandartName> getByLike(String name) {
        return super.getByLike(name);
    }
}
