package org.shop.mobile.resource;

import org.shop.mobile.Constants;

public class ProducerResource extends Resource {

    public static final String PRODUCER_API_URI = Constants.BASE_API_URI + "producers";

    private String name;

    private String imageUri;

    private String info;

    /**
     * Default constructor with no parameters.
     */
    public ProducerResource() {

    }

    /**
     * Constructor with id.
     * @param id identifier
     */
    public ProducerResource(final Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(final String imageUri) {
        this.imageUri = imageUri;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(final String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ProducerResource that = (ProducerResource) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (imageUri != null ? !imageUri.equals(that.imageUri) : that.imageUri != null)
            return false;
        return info != null ? info.equals(that.info) : that.info == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (imageUri != null ? imageUri.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProducerResource{");
        sb.append("id='").append(id).append('\'');
        sb.append(", uri='").append(uri).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", imageUri='").append(imageUri).append('\'');
        sb.append(", info='").append(info).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
