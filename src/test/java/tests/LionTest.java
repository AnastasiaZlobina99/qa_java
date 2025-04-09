package tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;


    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        List<String> listOfFoodExp = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(listOfFoodExp);
        Assert.assertEquals(listOfFoodExp,lion.getFood());
    }

    @Test
    public void doesHaveManeTrueTest() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeFalseTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, "Самка");
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionGenderExceptionTest() throws Exception {
        Lion lion = new Lion(feline, "Не определено");
    }


}
