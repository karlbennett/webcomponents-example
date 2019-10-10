package examples.webcomponents.data;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressesRepository extends PagingAndSortingRepository<Address, Long> {
}
