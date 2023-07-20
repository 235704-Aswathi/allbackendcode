import org.example.Arithmetics;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Arithmetictest {


    private Arithmetics arithmetics =null;
    private int a, b;

    @BeforeTest
    void createObject(){
        arithmetics= new Arithmetics();
         a=20;
         b=10;
    }

    @Test
    void testingAddition(){
        Assert.assertEquals(30,arithmetics.add(a,b));
    }
    @Test
    void testingSubtraction(){
        Assert.assertEquals(10,arithmetics.sub(a,b));
    }
    @Test
    void testingMultiplication(){
        Assert.assertEquals(200,arithmetics.mult(a,b));
    }
    @Test(expectedExceptions = ArithmeticException.class)
    void testingDivision(){
       // Assert.assertEquals(2,arithmetics.div(a,b));
        arithmetics.div(2,0);

    }
    @Test
    void printEven(){
        List<Integer> list= new ArrayList<Integer>();
        List<Integer> result= new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(8);
        result.add(2);
        result.add(4);
        result.add(8);
        Assert.assertEquals(result,arithmetics.printEven(list));
    }

    @Test
    void printOdd(){
        List<Integer> list= new ArrayList<Integer>();
        List<Integer> result= new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        result.add(1);
        result.add(3);
        Assert.assertEquals(result,arithmetics.printOdd(list));
    }



}
