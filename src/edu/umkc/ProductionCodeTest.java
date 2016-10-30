package edu.umkc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProductionCodeTest {

  public static void main(String[] args) {

    ProductionCode testSubject = new ProductionCode();

    int inputValue1 = 3;
    int inputValue2 = 7;
    int expectedResult = 10;
    Object actualResult = null;
    ProductionCode prodCode = new ProductionCode();
    Class prodClass = prodCode.getClass();

    try {
      Method prodMethod = prodClass.getDeclaredMethod("add", int.class, int.class);
      prodMethod.setAccessible(true);
      actualResult = prodMethod.invoke(prodClass.newInstance(),inputValue1, inputValue2);

    } catch (NoSuchMethodException e) {
      System.err.println("Method ProductionCode.add(int, int) not found");
      e.printStackTrace();
    } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }


    if ((int)actualResult == expectedResult)
      System.out.println("ProductionCode test passed.");
    else
      System.out.println("ProductionCode test failed.");
  }
}