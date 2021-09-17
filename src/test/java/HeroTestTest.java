import models.Hero;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;


public class HeroTestTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
//        Post.clearAllHeroes();
    }

    @Test
    public void Hero_returnsAllInstanceOfHero_true() {
        Hero firstHero = new Hero("Bolter",33, "superspeed", "aliens" );
        Hero secondHero = new Hero("Maximus",12, "ultragenius", "milk" );
        assertTrue(Hero.getAllInstances().contains(firstHero));
        assertTrue(Hero.getAllInstances().contains(secondHero));
    }

    @Test
    public void name() {
    }
}