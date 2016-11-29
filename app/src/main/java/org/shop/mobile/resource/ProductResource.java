package org.shop.mobile.resource;

import org.shop.mobile.Constants;

public class ProductResource extends Resource {

    public static final String PRODUCT_API_URI = Constants.BASE_API_URI + "products";

    private Long productTypeId;

    private Category category;

    private Long producerId;

    private Integer cost;

    private String imageUri;

    private String info;

    /**
     * Default constructor with no parameters.
     */
    public ProductResource() {

    }

    /**
     * Constructor with id.
     * @param id identifier
     */
    public ProductResource(final Long id) {
        super(id);
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ProductResource that = (ProductResource) o;

        if (productTypeId != null ? !productTypeId.equals(that.productTypeId) : that.productTypeId != null)
            return false;
        if (category != that.category) return false;
        if (producerId != null ? !producerId.equals(that.producerId) : that.producerId != null)
            return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (imageUri != null ? !imageUri.equals(that.imageUri) : that.imageUri != null)
            return false;
        return info != null ? info.equals(that.info) : that.info == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (productTypeId != null ? productTypeId.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (producerId != null ? producerId.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (imageUri != null ? imageUri.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductResource{");
        sb.append("productTypeId=").append(productTypeId);
        sb.append(", category=").append(category);
        sb.append(", producerId=").append(producerId);
        sb.append(", cost=").append(cost);
        sb.append(", imageUri='").append(imageUri).append('\'');
        sb.append(", info='").append(info).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
