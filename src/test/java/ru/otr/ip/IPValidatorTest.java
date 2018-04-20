package ru.otr.ip;

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
        assertTrue(validator.isValid(Arrays.asList("15","123","0","24")));
    }

    @Test
    public void notFullIPShouldNotBeValid(){
        assertFalse(validator.isValid(Arrays.asList("15","0","24")));
    }

    @Test
    public void tooBigIpShouldNotBeValid(){
        assertFalse(validator.isValid(Arrays.asList("1500","123","0","24")));
    }

    @Test
    public void shouldNotBeValidWithLetter(){
        assertFalse(validator.isValid(Arrays.asList("15i","123","0","24")));
    }

    @Test
    public void negativeIpShouldNotBeValid(){
        assertFalse(validator.isValid(Arrays.asList("-15","123","0","24")));
    }

    @Test
    public void fourDigitsIpShouldNotBeValid(){
        assertFalse(validator.isValid(Arrays.asList("-15","123","0000","24")));
    }

}
