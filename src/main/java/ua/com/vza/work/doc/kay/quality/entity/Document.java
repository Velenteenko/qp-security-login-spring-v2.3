package ua.com.vza.work.doc.kay.quality.entity;

import javax.persistence.*;
import java.io.Serializable;

/**  new
 * Created by kycenko on 30.06.15.
 */
@Entity
@Table(name = "document", schema = "", catalog = "qualityofproducts")
@NamedQuery(name = "Document.getAll", query = "SELECT d FROM Document d ORDER BY d.name")
public class Document implements Serializable {
    private int documentId;
    private int incomeId;
    private String name;
    private String link;
    private ProductIncome productIncomeByIncomeId;

    public Document() {}

    @Id
    @Column(name = "document_id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    @Basic
    @Column(name = "income_id", nullable = false, insertable = true, updatable = true)
    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "link", nullable = false, insertable = true, updatable = true, length = 45)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (documentId != document.documentId) return false;
        if (incomeId != document.incomeId) return false;
        if (name != null ? !name.equals(document.name) : document.name != null) return false;
        if (link != null ? !link.equals(document.link) : document.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = documentId;
        result = 31 * result + incomeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "income_id", referencedColumnName = "idproduct_income", nullable = false, insertable = false, updatable = false)
    public ProductIncome getProductIncomeByIncomeId() {
        return productIncomeByIncomeId;
    }

    public void setProductIncomeByIncomeId(ProductIncome productIncomeByIncomeId) {
        this.productIncomeByIncomeId = productIncomeByIncomeId;
    }
}
