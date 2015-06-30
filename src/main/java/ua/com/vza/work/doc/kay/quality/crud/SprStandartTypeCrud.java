package ua.com.vza.work.doc.kay.quality.crud;

import ua.com.vza.work.doc.kay.quality.crud.abstracts.CrudAbstractFactory;
import ua.com.vza.work.doc.kay.quality.entity.SprStandartType;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by kycenko on 22.06.15.
 */
@Stateless
public class SprStandartTypeCrud extends CrudAbstractFactory<SprStandartType> {
    public static final String TABLEOBJECT = "SprStandartType";

    public SprStandartTypeCrud() {
        super(TABLEOBJECT);
    }

    public SprStandartTypeCrud(String tableObject) {
        super(tableObject);
    }

    @Override
    public SprStandartType create(SprStandartType obj) {
        return super.create(obj);
    }

    @Override
    public void update(SprStandartType person) {
        super.update(person);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public SprStandartType getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<SprStandartType> getAll(int pageNumber) {
        return super.getAll(pageNumber);
    }
}
