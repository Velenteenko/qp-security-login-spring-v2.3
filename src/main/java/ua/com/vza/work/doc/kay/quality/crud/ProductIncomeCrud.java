package ua.com.vza.work.doc.kay.quality.crud;

import ua.com.vza.work.doc.kay.quality.crud.abstracts.CrudAbstractFactory;
import ua.com.vza.work.doc.kay.quality.entity.ProductIncome;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Aleksandr on 26.06.15.
 */
@Stateless
public class ProductIncomeCrud extends CrudAbstractFactory<ProductIncome> {
    public static final String TABLEOBJECT = "ProductIncome";

    public ProductIncomeCrud() {
        super(TABLEOBJECT);
    }

    @Override
    public ProductIncome create(ProductIncome obj) {
        return super.create(obj);
    }

    @Override
    public void update(ProductIncome obj) {
        super.update(obj);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public ProductIncome getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<ProductIncome> getByLike(String name) {
        return super.getByLike(name);
    }

    @Override
    public List<ProductIncome> getAll(int pageNumber) {
        return super.getAll(pageNumber);
    }
}
