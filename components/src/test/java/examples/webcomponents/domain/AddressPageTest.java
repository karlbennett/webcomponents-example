package examples.webcomponents.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static nl.jqno.equalsverifier.Warning.NONFINAL_FIELDS;
import static org.junit.Assert.assertThat;

public class AddressPageTest {

    @Test
    public void AddressPage_is_a_valid_bean() {
        assertThat(AddressPage.class, hasValidGettersAndSetters());
    }

    @Test
    public void AddressPage_hash_equality() {
        EqualsVerifier.forClass(AddressPage.class).suppress(NONFINAL_FIELDS).usingGetClass().verify();
    }
}