package examples.webcomponents.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static nl.jqno.equalsverifier.Warning.NONFINAL_FIELDS;
import static org.junit.Assert.assertThat;

public class AddressTest {

    @Test
    public void Address_is_a_valid_bean() {
        assertThat(Address.class, hasValidGettersAndSetters());
    }

    @Test
    public void Address_hash_equality() {
        EqualsVerifier.forClass(Address.class).suppress(NONFINAL_FIELDS).usingGetClass().verify();
    }
}