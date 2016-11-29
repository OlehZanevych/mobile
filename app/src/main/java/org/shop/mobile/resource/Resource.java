package org.shop.mobile.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.MessageFormat;

public abstract class Resource {

    protected Long id;

    protected String uri;

    /**
     * Default constructor with no parameters.
     */
    protected Resource() {

    }

    /**
     * Constructor with id.
     * @param id identifier
     */
    protected Resource(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (id != null ? !id.equals(resource.id) : resource.id != null) return false;
        return uri != null ? uri.equals(resource.uri) : resource.uri == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Resource{");
        sb.append("id=").append(id);
        sb.append(", uri='").append(uri).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
