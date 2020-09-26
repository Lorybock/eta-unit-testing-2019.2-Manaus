package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BodyMassIndexTest {
    @Spy
    BodyMassIndex bmi;

//    @BeforeEach
//    public void setup(){
//        bmi = new BodyMassIndex();
//    }

    @Test
    public void classify_bmiUnder16_SeverelyUnderweight(){
        String expected = "Severely Underweight";
        String result = bmi.classify(15.9);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void classify_bmi16_Underweight(){
        String expected = "Underweight";
        String result = bmi.classify(16);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void classify_bmi18Dot5_HealthyWeight(){
        String result = bmi.classify(18.5);

        Assertions.assertEquals("Healthy Weight", result);
    }

    @Test
    public void classify_bmi25_Overweight(){
        String result = bmi.classify(25);

        Assertions.assertEquals("Overweight", result);
    }

    @Test
    public void classify_bmi30_Obese(){
        String result = bmi.classify(30);

        Assertions.assertEquals("Obese", result);
    }

    @Test
    public void classify() {
        BodyMassIndex bmi = new BodyMassIndex(){
            @Override
            public double calculate(double weight, double height) {
                return 10;
            }

            @Override
            public String classify(double bmi) {
                return "none";
            }
        };

        String result = bmi.classify(1.0,2.0);
        Assertions.assertEquals("none", result);
    }

    @Test
    public void classify_spyMethods() {
        final double[] params = new double[3];
        BodyMassIndex bmi = new BodyMassIndex(){
            @Override
            public double calculate(double weight, double height) {
                params[0] = weight;
                params[1] = height;
                return 10;
            }

            @Override
            public String classify(double bmi) {
                params[2] = bmi;
                return "none";
            }
        };

        bmi.classify(1, 2);
        Assertions.assertEquals(1, params[0]);
        Assertions.assertEquals(2, params[1]);
        Assertions.assertEquals(10, params[2]);
    }

    @Test
    public void classify_mokitoSpyMethods() {
        when(bmi.calculate(1,2)).thenReturn(22.0);
        bmi.classify(1, 2);
        verify(bmi,times(1)).calculate(1,2);
        verify(bmi,times(1)).classify(22.0);
    }
}
