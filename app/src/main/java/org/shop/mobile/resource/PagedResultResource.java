package org.shop.mobile.resource;

import java.util.List;

/**
 * PagedResultResource, that is sent to response,
 * when we need to have pagination response.
 * @author OlehZanevych
 *
 * @param <R> Generic object class of resource
 */
public class PagedResultResource<R extends Resource> {

    private Integer offset;
    private Integer limit;
    private Long count;
    private List<R> resources;

    /**
     * Default constructor with no parameters.
     */
    protected PagedResultResource() {

    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<R> getResources() {
        return resources;
    }

    public void setResources(List<R> resources) {
        this.resources = resources;
    }
}
