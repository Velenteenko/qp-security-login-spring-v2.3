package ua.com.vza.work.doc.kay.quality.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/** new
 * Created by kycenko on 30.06.15.
 */
@Entity
@Table(name = "product", schema = "", catalog = "qualityofproducts")
@NamedQuery(name = "Product.getAll", query = "SELECT d FROM Product d ORDER BY d.id")
public class Product implements Serializable {
    private int id;
    private Integer nameId;
    private Integer typeId;
    private Integer waranty;
    private Integer produceDate;
    private String lot;
    private Integer consumerId;
    private Integer stdNameId;
    private Integer stdTypeId;
    private String numberDoc;
    private SprConsumer sprConsumerByConsumerId;
    private SprProductName sprProductNameByNameId;
    private SprStandartName sprStandartNameByStdNameId;
    private SprProductType sprProductTypeByTypeId;
    private SprStandartName sprStandartNameByStdTypeId;
    private Collection<ProductIncome> productIncomesById;

    public Product(){}

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_id", nullable = true, insertable = true, updatable = true)
    public Integer getNameId() {
        return nameId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    @Basic
    @Column(name = "type_id", nullable = true, insertable = true, updatable = true)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "waranty", nullable = true, insertable = true, updatable = true)
    public Integer getWaranty() {
        return waranty;
    }

    public void setWaranty(Integer waranty) {
        this.waranty = waranty;
    }

    @Basic
    @Column(name = "produce_date", nullable = true, insertable = true, updatable = true)
    public Integer getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Integer produceDate) {
        this.produceDate = produceDate;
    }

    @Basic
    @Column(name = "lot", nullable = true, insertable = true, updatable = true, length = 45)
    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    @Basic
    @Column(name = "consumer_id", nullable = true, insertable = true, updatable = true)
    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    @Basic
    @Column(name = "stdName_id", nullable = true, insertable = true, updatable = true)
    public Integer getStdNameId() {
        return stdNameId;
    }

    public void setStdNameId(Integer stdNameId) {
        this.stdNameId = stdNameId;
    }

    @Basic
    @Column(name = "stdType_id", nullable = true, insertable = true, updatable = true)
    public Integer getStdTypeId() {
        return stdTypeId;
    }

    public void setStdTypeId(Integer stdTypeId) {
        this.stdTypeId = stdTypeId;
    }

    @Basic
    @Column(name = "number_doc", nullable = true, insertable = true, updatable = true, length = 45)
    public String getNumberDoc() {
        return numberDoc;
    }

    public void setNumberDoc(String numberDoc) {
        this.numberDoc = numberDoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (nameId != null ? !nameId.equals(product.nameId) : product.nameId != null) return false;
        if (typeId != null ? !typeId.equals(product.typeId) : product.typeId != null) return false;
        if (waranty != null ? !waranty.equals(product.waranty) : product.waranty != null) return false;
        if (produceDate != null ? !produceDate.equals(product.produceDate) : product.produceDate != null) return false;
        if (lot != null ? !lot.equals(product.lot) : product.lot != null) return false;
        if (consumerId != null ? !consumerId.equals(product.consumerId) : product.consumerId != null) return false;
        if (stdNameId != null ? !stdNameId.equals(product.stdNameId) : product.stdNameId != null) return false;
        if (stdTypeId != null ? !stdTypeId.equals(product.stdTypeId) : product.stdTypeId != null) return false;
        if (numberDoc != null ? !numberDoc.equals(product.numberDoc) : product.numberDoc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameId != null ? nameId.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (waranty != null ? waranty.hashCode() : 0);
        result = 31 * result + (produceDate != null ? produceDate.hashCode() : 0);
        result = 31 * result + (lot != null ? lot.hashCode() : 0);
        result = 31 * result + (consumerId != null ? consumerId.hashCode() : 0);
        result = 31 * result + (stdNameId != null ? stdNameId.hashCode() : 0);
        result = 31 * result + (stdTypeId != null ? stdTypeId.hashCode() : 0);
        result = 31 * result + (numberDoc != null ? numberDoc.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "consumer_id", referencedColumnName = "consumer_id", nullable = false, insertable = false, updatable = false)
    public SprConsumer getSprConsumerByConsumerId() {
        return sprConsumerByConsumerId;
    }

    public void setSprConsumerByConsumerId(SprConsumer sprConsumerByConsumerId) {
        this.sprConsumerByConsumerId = sprConsumerByConsumerId;
    }

    @ManyToOne
    @JoinColumn(name = "name_id", referencedColumnName = "spr_name_id", nullable = false, insertable = false, updatable = false)
    public SprProductName getSprProductNameByNameId() {
        return sprProductNameByNameId;
    }

    public void setSprProductNameByNameId(SprProductName sprProductNameByNameId) {
        this.sprProductNameByNameId = sprProductNameByNameId;
    }

    @ManyToOne
    @JoinColumn(name = "stdName_id", referencedColumnName = "spr_std_name_id", nullable = false, insertable = false, updatable = false)
    public SprStandartName getSprStandartNameByStdNameId() {
        return sprStandartNameByStdNameId;
    }

    public void setSprStandartNameByStdNameId(SprStandartName sprStandartNameByStdNameId) {
        this.sprStandartNameByStdNameId = sprStandartNameByStdNameId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "spr_type_id", nullable = false, insertable = false, updatable = false)
    public SprProductType getSprProductTypeByTypeId() {
        return sprProductTypeByTypeId;
    }

    public void setSprProductTypeByTypeId(SprProductType sprProductTypeByTypeId) {
        this.sprProductTypeByTypeId = sprProductTypeByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "stdType_id", referencedColumnName = "spr_std_name_id", nullable = false, insertable = false, updatable = false)
    public SprStandartName getSprStandartNameByStdTypeId() {
        return sprStandartNameByStdTypeId;
    }

    public void setSprStandartNameByStdTypeId(SprStandartName sprStandartNameByStdTypeId) {
        this.sprStandartNameByStdTypeId = sprStandartNameByStdTypeId;
    }

    @OneToMany(mappedBy = "productByProductId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<ProductIncome> getProductIncomesById() {
        return productIncomesById;
    }

    public void setProductIncomesById(Collection<ProductIncome> productIncomesById) {
        this.productIncomesById = productIncomesById;
    }
}
