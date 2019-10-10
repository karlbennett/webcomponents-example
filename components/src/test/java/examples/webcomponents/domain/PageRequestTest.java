package examples.webcomponents.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import org.springframework.data.domain.Pageable;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static nl.jqno.equalsverifier.Warning.NONFINAL_FIELDS;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomIntegers.someIntegerBetween;

public class PageRequestTest {

    @Test
    public void Can_convert_to_a_pagable() {

        final PageRequest request = new PageRequest();
        final Integer page = someIntegerBetween(10, 100);
        final Integer size = someIntegerBetween(10, 100);

        // Given
        request.setPage(page);
        request.setSize(size);

        // When
        final Pageable actual = request.toPagable();

        // Then
        assertThat(actual, equalTo(org.springframework.data.domain.PageRequest.of(page, size)));
    }

    @Test
    public void PageRequest_is_a_valid_bean() {
        assertThat(PageRequest.class, hasValidGettersAndSetters());
    }

    @Test
    public void PageRequest_hash_equality() {
        EqualsVerifier.forClass(PageRequest.class).suppress(NONFINAL_FIELDS).usingGetClass().verify();
    }
}