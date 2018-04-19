import ru.otr.ip.IPValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IPValidatorTest {
    private IPValidator validator;

    @Before
    public void init(){
        validator = new IPValidator();
    }

    @Test
    public void shouldBeValid(){
        assertTrue(validator.validate(Arrays.asList("15.123.0.24".split(Pattern.quote(".")))));
    }

    @Test
    public void notFullIPShouldNotBeValid(){
        assertFalse(validator.validate(Arrays.asList("15.0.24".split(Pattern.quote(".")))));
    }

    @Test
    public void tooBigIpShouldNotBeValid(){
        assertFalse(validator.validate(Arrays.asList("1500.123.0.24".split(Pattern.quote(".")))));
    }

    @Test
    public void shouldNotBeValidWithLetter(){
        assertFalse(validator.validate(Arrays.asList("15i.123.0.24".split(Pattern.quote(".")))));
    }

    @Test
    public void negativeIpShouldNotBeValid(){
        assertFalse(validator.validate(Arrays.asList("-15.123.0.24".split(Pattern.quote(".")))));
    }

}
