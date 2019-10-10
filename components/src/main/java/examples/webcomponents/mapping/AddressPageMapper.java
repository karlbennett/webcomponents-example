package examples.webcomponents.mapping;

import examples.webcomponents.data.Address;
import examples.webcomponents.domain.AddressPage;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import static java.util.stream.Collectors.toList;

@Mapper
public interface AddressPageMapper {

    default AddressPage mapPage(Page<Address> page) {
        final AddressPage mappedPage = new AddressPage();
        mappedPage.setNumber(page.getNumber() + 1);
        mappedPage.setSize(page.getSize());
        mappedPage.setTotalPages(page.getTotalPages());
        mappedPage.setTotalElements(page.getTotalElements());
        mappedPage.setAddresses(page.get().map(this::mapAddress).collect(toList()));
        return mappedPage;
    }

    examples.webcomponents.domain.Address mapAddress(Address address);
}
