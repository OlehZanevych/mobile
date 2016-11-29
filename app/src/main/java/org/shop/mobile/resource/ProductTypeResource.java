package org.shop.mobile.resource;

import org.shop.mobile.Constants;

public class ProductTypeResource extends Resource {

    public static final String PRODUCT_TYPE_API_URI = Constants.BASE_API_URI + "producttypes";

    private String name;

    private String info;

    /**
     * Default constructor with no parameters.
     */
    public ProductTypeResource() {

    }

    /**
     * Constructor with id.
     * @param id identifier
     */
    public ProductTypeResource(final Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        ProductTypeResource that = (ProductTypeResource) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return info != null ? info.equals(that.info) : that.info == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductTypeResource{");
        sb.append("name='").append(name).append('\'');
        sb.append(", info='").append(info).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
