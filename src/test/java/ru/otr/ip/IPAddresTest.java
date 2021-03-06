package ru.otr.ip;

import ru.otr.ip.IPAddress;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IPAddresTest {
    private IPAddress firstIPAddres;
    private IPAddress secondIPAddres;

    @Before
    public void init(){
        firstIPAddres = new IPAddress(Arrays.asList("192","168","5","195"));
        secondIPAddres = new IPAddress(Arrays.asList("192","168","5","196"));
    }

    @Test
    public void sameShouldBeEqual(){
        assertTrue(firstIPAddres.equals(firstIPAddres));
    }

    @Test
    public void differentShouldNotBeEqual(){
        assertFalse(firstIPAddres.equals(secondIPAddres));
    }

    @Test
    public void shouldBeGreater(){
        assertTrue(firstIPAddres.isGreater(firstIPAddres));
    }

    @Test
    public void shouldNotBeGreater(){
        assertFalse(firstIPAddres.isGreater(secondIPAddres));
    }

    @Test
    public void shouldBeIncremented(){
        firstIPAddres.increment();
        assertTrue(firstIPAddres.equals(secondIPAddres));
    }
}
