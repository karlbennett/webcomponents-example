package examples.webcomponents.mapping;

import examples.webcomponents.data.Address;
import examples.webcomponents.domain.AddressPage;
import org.junit.Test;
import org.springframework.data.domain.Page;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomIntegers.someInteger;
import static shiver.me.timbers.data.random.RandomLongs.someLong;

public class AddressPageMapperTest {

    @Test
    @SuppressWarnings("unchecked")
    public void Can_map_a_page_to_an_address_page() {

        final Page<Address> page = mock(Page.class);

        final Integer number = someInteger();
        final Integer size = someInteger();
        final Integer totalPages = someInteger();
        final Long totalElements = someLong();
        final Address address1 = mock(Address.class);
        final Address address2 = mock(Address.class);
        final Address address3 = mock(Address.class);
        final Function<Address, examples.webcomponents.domain.Address> mapper = mock(Function.class);
        final examples.webcomponents.domain.Address modelAddress1 = mock(examples.webcomponents.domain.Address.class);
        final examples.webcomponents.domain.Address modelAddress2 = mock(examples.webcomponents.domain.Address.class);
        final examples.webcomponents.domain.Address modelAddress3 = mock(examples.webcomponents.domain.Address.class);

        final AddressPage expected = new AddressPage();

        // Given
        given(page.getNumber()).willReturn(number);
        given(page.getSize()).willReturn(size);
        given(page.getTotalPages()).willReturn(totalPages);
        given(page.getTotalElements()).willReturn(totalElements);
        given(page.get()).willReturn(Stream.of(address1, address2, address3));
        given(mapper.apply(address1)).willReturn(modelAddress1);
        given(mapper.apply(address2)).willReturn(modelAddress2);
        given(mapper.apply(address3)).willReturn(modelAddress3);
        expected.setNumber(number + 1);
        expected.setSize(size);
        expected.setTotalPages(totalPages);
        expected.setTotalElements(totalElements);
        expected.setAddresses(asList(modelAddress1, modelAddress2, modelAddress3));

        // When
        final AddressPage actual = ((AddressPageMapper) mapper::apply).mapPage(page);

        // Then
        assertThat(actual, equalTo(expected));
    }
}