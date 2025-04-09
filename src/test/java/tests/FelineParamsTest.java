package tests;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamsTest {
    private final int checkingKitten;
    private final int expectedKitten;

    public FelineParamsTest(int checkingKitten,int expectedKitten){
        this.checkingKitten = checkingKitten;
        this.expectedKitten = expectedKitten;
    }

    @Parameterized.Parameters
    public static Object[][] dataTest(){
        return new Object[][]{
                {-10, -10},
                {0, 0},
                {1, 1},
        };
    }

    @Test
    public void getKittensWithArgumentsTest() {
        Feline feline = new Feline();
        assertEquals(expectedKitten, feline.getKittens(checkingKitten));
    }

}
