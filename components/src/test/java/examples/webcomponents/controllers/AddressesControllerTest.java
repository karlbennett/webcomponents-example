package examples.webcomponents.controllers;

import examples.webcomponents.data.Address;
import examples.webcomponents.data.AddressesRepository;
import examples.webcomponents.domain.AddressPage;
import examples.webcomponents.mapping.AddressPageMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomIntegers.someIntegerBetween;

public class AddressesControllerTest {

    private AddressesRepository repository;
    private AddressPageMapper mapper;
    private AddressesController controller;

    @Before
    public void setUp() {
        repository = mock(AddressesRepository.class);
        mapper = mock(AddressPageMapper.class);
        controller = new AddressesController(repository, mapper);
    }

    @Test
    public void Can_render_a_addresses_menu_item() {

        final Authentication authentication = mock(Authentication.class);

        // Given
        given(authentication.isAuthenticated()).willReturn(true);

        // When
        final ModelAndView actual = controller.menuItem(authentication);

        // Then
        assertThat(actual.getViewName(), equalTo("addresses-item"));
        assertThat(actual.getModel(), hasEntry("loggedIn", true));
    }

    @Test
    public void Cannot_render_a_addresses_menu_item() {

        // When
        final ModelAndView actual = controller.menuItem(null);

        // Then
        assertThat(actual.getViewName(), equalTo("addresses-item"));
        assertThat(actual.getModel(), equalTo(emptyMap()));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_render_some_addresses() {

        final Integer page = someIntegerBetween(10, 100);
        final Integer size = someIntegerBetween(10, 100);

        final org.springframework.data.domain.Page<Address> repoPage = mock(org.springframework.data.domain.Page.class);
        final AddressPage addressPage = mock(AddressPage.class);

        // Given
        given(repository.findAll(PageRequest.of(page - 1, size))).willReturn(repoPage);
        given(mapper.mapPage(repoPage)).willReturn(addressPage);

        // When
        final ModelAndView actual = controller.addressTable(page, size);

        // Then
        assertThat(actual.getViewName(), equalTo("address-table"));
        assertThat(actual.getModel(), hasEntry("addressPage", addressPage));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_render_some_addresses_with_page_zero() {

        final Integer size = someIntegerBetween(10, 100);

        final org.springframework.data.domain.Page<Address> repoPage = mock(org.springframework.data.domain.Page.class);
        final AddressPage addressPage = mock(AddressPage.class);

        // Given
        given(repository.findAll(PageRequest.of(0, size))).willReturn(repoPage);
        given(mapper.mapPage(repoPage)).willReturn(addressPage);

        // When
        final ModelAndView actual = controller.addressTable(0, size);

        // Then
        assertThat(actual.getViewName(), equalTo("address-table"));
        assertThat(actual.getModel(), hasEntry("addressPage", addressPage));
    }
}