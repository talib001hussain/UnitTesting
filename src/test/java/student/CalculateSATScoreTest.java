package student;

import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class CalculateSATScoreTest {

    public static Object[] testValues(){
        return new Object[] {
                new Object[]{50, 50, 2500},
                new Object[]{500, 50, -1},
                new Object[]{50, 500, -1},
                new Object[]{500, 500, -1},
                new Object[]{-50, -50, -1},
                new Object[]{50, -50, -1},
                new Object[]{-50, 50, -1},
                new Object[]{0, 0, 0},
                new Object[]{100, 100, 10000}
        };
    }

    @Test
    @Parameters(method = "testValues")
    public void calculateSatScoreTestRegular(int mathsScore, int literacyScore, int expectedResult){
        Student student = new Student();
        student.calculateSATScore(mathsScore, literacyScore);
        Assert.assertEquals(expectedResult, student.getSatScore());
    }
}
