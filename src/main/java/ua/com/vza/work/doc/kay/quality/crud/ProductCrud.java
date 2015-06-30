package ua.com.vza.work.doc.kay.quality.crud;

import ua.com.vza.work.doc.kay.quality.crud.abstracts.CrudAbstractFactory;
import ua.com.vza.work.doc.kay.quality.entity.Product;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by kycenko on 16.06.15.
 */
@Stateless
public class ProductCrud extends CrudAbstractFactory<Product> {
    public static final String TABLEOBJECT = "Product";

    public ProductCrud() {
        super(TABLEOBJECT);
    }

    @Override
    public Product create(Product obj) {
       return super.create(obj);
    }

    @Override
    public void update(Product obj) {
        super.update(obj);
    }

    @Override
    public void delete(long id) {
        super.delete(id);
    }

    @Override
    public Product getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<Product> getByLike(String name) {
        return super.getByLike(name);
    }

    @Override
    public List<Product> getAll(int pageNumber) {
        return super.getAll(pageNumber);
    }
}
