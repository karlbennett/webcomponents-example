package examples.webcomponents.domain;

import org.springframework.data.domain.Pageable;

import java.util.Objects;

public class PageRequest {

    private int page;
    private int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Pageable toPagable() {
        return org.springframework.data.domain.PageRequest.of(page, size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageRequest that = (PageRequest) o;
        return page == that.page &&
            size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size);
    }
}
