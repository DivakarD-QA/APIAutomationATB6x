package org.example.tests.misc.parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass2 {

    @BeforeMethod
    public void beforeMethodC2() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsC2TC01() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method One(1). Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsC2TC02() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Two(2). Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsC2TC03() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Three(3). Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsC2TC04() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Four(4). Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsC2TC05() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Five(5). Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsC2TC06() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Six(6). Thread id is: " + id + getClass().getSimpleName());
    }

    @AfterMethod
    public void afterMethodC2() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id + getClass().getSimpleName());
    }


}
