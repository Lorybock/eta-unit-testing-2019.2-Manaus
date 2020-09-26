package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BodyMassIndexTest {
    @Test
    public void calculate_bmiUnder16_SeverelyUnderweight(){
        String expected = "Severely Underweight";
        String result = BodyMassIndex.calculate(15.9);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void calculate_bmi16_Underweight(){
        String expected = "Underweight";
        String result = BodyMassIndex.calculate(16);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void calculate_bmi18Dot5_HealthyWeight(){
        String result = BodyMassIndex.calculate(18.5);

        Assertions.assertEquals("Healthy Weight", result);
    }

    @Test
    public void calculate_bmi25_Overweight(){
        String result = BodyMassIndex.calculate(25);

        Assertions.assertEquals("Overweight", result);
    }

    @Test
    public void calculate_bmi30_Obese(){
        String result = BodyMassIndex.calculate(30);

        Assertions.assertEquals("Obese", result);
    }

}
