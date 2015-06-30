package ua.com.vza.work.doc.kay.quality.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by kycenko on 30.06.15.
 */
@Entity
@Table(name = "product_income", schema = "", catalog = "qualityofproducts")
@NamedQuery(name = "ProductIncome.getAll", query = "SELECT d FROM ProductIncome d ORDER BY d.datePresenter")
public class ProductIncome implements Serializable {
    private int idproductIncome;
    private Integer productId;
    private Integer magazineId;
    private Integer countProduct;
    private Integer measureId;
    private String fioPresenter;
    private Integer datePresenter;
    private String fioLastModify;
    private Integer dateLastModify;
    private String fioControler;
    private Integer locationId;
    private String arrangements;
    private String note;
    private Collection<Document> documentsByIdproductIncome;
    private SprLocation sprLocationByLocationId;
    private SprMagazine sprMagazineByMagazineId;
    private SprMeasure sprMeasureByMeasureId;
    private Product productByProductId;

    public ProductIncome(){}

    @Id
    @Column(name = "idproduct_income", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getIdproductIncome() {
        return idproductIncome;
    }

    public void setIdproductIncome(int idproductIncome) {
        this.idproductIncome = idproductIncome;
    }

    @Basic
    @Column(name = "product_id", nullable = true, insertable = true, updatable = true)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "magazine_id", nullable = true, insertable = true, updatable = true)
    public Integer getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(Integer magazineId) {
        this.magazineId = magazineId;
    }

    @Basic
    @Column(name = "count_product", nullable = true, insertable = true, updatable = true)
    public Integer getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Integer countProduct) {
        this.countProduct = countProduct;
    }

    @Basic
    @Column(name = "measure_id", nullable = true, insertable = true, updatable = true)
    public Integer getMeasureId() {
        return measureId;
    }

    public void setMeasureId(Integer measureId) {
        this.measureId = measureId;
    }

    @Basic
    @Column(name = "fio_presenter", nullable = true, insertable = true, updatable = true, length = 45)
    public String getFioPresenter() {
        return fioPresenter;
    }

    public void setFioPresenter(String fioPresenter) {
        this.fioPresenter = fioPresenter;
    }

    @Basic
    @Column(name = "date_presenter", nullable = true, insertable = true, updatable = true)
    public Integer getDatePresenter() {
        return datePresenter;
    }

    public void setDatePresenter(Integer datePresenter) {
        this.datePresenter = datePresenter;
    }

    @Basic
    @Column(name = "fio_last_modify", nullable = true, insertable = true, updatable = true, length = 45)
    public String getFioLastModify() {
        return fioLastModify;
    }

    public void setFioLastModify(String fioLastModify) {
        this.fioLastModify = fioLastModify;
    }

    @Basic
    @Column(name = "date_last_modify", nullable = true, insertable = true, updatable = true)
    public Integer getDateLastModify() {
        return dateLastModify;
    }

    public void setDateLastModify(Integer dateLastModify) {
        this.dateLastModify = dateLastModify;
    }

    @Basic
    @Column(name = "fio_controler", nullable = true, insertable = true, updatable = true, length = 45)
    public String getFioControler() {
        return fioControler;
    }

    public void setFioControler(String fioControler) {
        this.fioControler = fioControler;
    }

    @Basic
    @Column(name = "location_id", nullable = true, insertable = true, updatable = true)
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "arrangements", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getArrangements() {
        return arrangements;
    }

    public void setArrangements(String arrangements) {
        this.arrangements = arrangements;
    }

    @Basic
    @Column(name = "note", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductIncome that = (ProductIncome) o;

        if (idproductIncome != that.idproductIncome) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (magazineId != null ? !magazineId.equals(that.magazineId) : that.magazineId != null) return false;
        if (countProduct != null ? !countProduct.equals(that.countProduct) : that.countProduct != null) return false;
        if (measureId != null ? !measureId.equals(that.measureId) : that.measureId != null) return false;
        if (fioPresenter != null ? !fioPresenter.equals(that.fioPresenter) : that.fioPresenter != null) return false;
        if (datePresenter != null ? !datePresenter.equals(that.datePresenter) : that.datePresenter != null)
            return false;
        if (fioLastModify != null ? !fioLastModify.equals(that.fioLastModify) : that.fioLastModify != null)
            return false;
        if (dateLastModify != null ? !dateLastModify.equals(that.dateLastModify) : that.dateLastModify != null)
            return false;
        if (fioControler != null ? !fioControler.equals(that.fioControler) : that.fioControler != null) return false;
        if (locationId != null ? !locationId.equals(that.locationId) : that.locationId != null) return false;
        if (arrangements != null ? !arrangements.equals(that.arrangements) : that.arrangements != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idproductIncome;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (magazineId != null ? magazineId.hashCode() : 0);
        result = 31 * result + (countProduct != null ? countProduct.hashCode() : 0);
        result = 31 * result + (measureId != null ? measureId.hashCode() : 0);
        result = 31 * result + (fioPresenter != null ? fioPresenter.hashCode() : 0);
        result = 31 * result + (datePresenter != null ? datePresenter.hashCode() : 0);
        result = 31 * result + (fioLastModify != null ? fioLastModify.hashCode() : 0);
        result = 31 * result + (dateLastModify != null ? dateLastModify.hashCode() : 0);
        result = 31 * result + (fioControler != null ? fioControler.hashCode() : 0);
        result = 31 * result + (locationId != null ? locationId.hashCode() : 0);
        result = 31 * result + (arrangements != null ? arrangements.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productIncomeByIncomeId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<Document> getDocumentsByIdproductIncome() {
        return documentsByIdproductIncome;
    }

    public void setDocumentsByIdproductIncome(Collection<Document> documentsByIdproductIncome) {
        this.documentsByIdproductIncome = documentsByIdproductIncome;
    }

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", nullable = false, insertable = false, updatable = false)
    public SprLocation getSprLocationByLocationId() {
        return sprLocationByLocationId;
    }

    public void setSprLocationByLocationId(SprLocation sprLocationByLocationId) {
        this.sprLocationByLocationId = sprLocationByLocationId;
    }

    @ManyToOne
    @JoinColumn(name = "magazine_id", referencedColumnName = "magazine_id", nullable = false, insertable = false, updatable = false)
    public SprMagazine getSprMagazineByMagazineId() {
        return sprMagazineByMagazineId;
    }

    public void setSprMagazineByMagazineId(SprMagazine sprMagazineByMagazineId) {
        this.sprMagazineByMagazineId = sprMagazineByMagazineId;
    }

    @ManyToOne
    @JoinColumn(name = "measure_id", referencedColumnName = "measure_id", nullable = false, insertable = false, updatable = false)
    public SprMeasure getSprMeasureByMeasureId() {
        return sprMeasureByMeasureId;
    }

    public void setSprMeasureByMeasureId(SprMeasure sprMeasureByMeasureId) {
        this.sprMeasureByMeasureId = sprMeasureByMeasureId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
