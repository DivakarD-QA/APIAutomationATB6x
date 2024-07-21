package org.example.tests.misc.parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass {
    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsTC01() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method One(1). Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsTC02() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Two(2). Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsTC03() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Three(3). Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsTC04() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Four(4). Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsTC05() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Five(5). Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodsTC06() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Six(6). Thread id is: " + id + getClass().getSimpleName());
    }

    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id + getClass().getSimpleName());
    }

}
