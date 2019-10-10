package examples.webcomponents.controllers;

import examples.webcomponents.data.Address;
import examples.webcomponents.data.AddressesRepository;
import examples.webcomponents.mapping.AddressPageMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Collections.singletonMap;

@Controller
public class AddressesController {

    private static final String ADDRESSES_LINK_VIEW = "addresses-link";
    private static final String ADDRESSES_VIEW = "address-table";

    private final AddressesRepository repository;
    private final AddressPageMapper mapper;

    public AddressesController(AddressesRepository repository, AddressPageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @RequestMapping(path = "/components/public/addresses-link.js")
    public ModelAndView link(Authentication authentication) {
        if (authentication == null) {
            return new ModelAndView(ADDRESSES_LINK_VIEW);
        }
        return new ModelAndView(ADDRESSES_LINK_VIEW, singletonMap("loggedIn", authentication.isAuthenticated()));
    }

    @RequestMapping(path = "/components/address-table.js")
    public ModelAndView addressTable(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        final Page<Address> addresses = repository.findAll(PageRequest.of(normalise(page), size));
        return new ModelAndView(ADDRESSES_VIEW, singletonMap("addressPage", mapper.mapPage(addresses)));
    }

    private int normalise(int page) {
        return page == 0 ? 0 : page - 1;
    }
}
