import ru.otr.ip.IPValidator;
import org.junit.Before;
import org.junit.Test;

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
    public void validate(){
        assertTrue(validator.validate("15.123.0.24".split(Pattern.quote("."))));
        assertFalse(validator.validate("15.0.24".split(Pattern.quote("."))));
        assertFalse(validator.validate("1500.123.0.24".split(Pattern.quote("."))));
        assertFalse(validator.validate("15i.123.0.24".split(Pattern.quote("."))));
    }
}
