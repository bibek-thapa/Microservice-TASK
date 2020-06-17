package com.demo.CustomerMS;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JustTest {
	
	@BeforeClass
	public static void beforeClass() 
	{
		System.out.println("A");
	}

	@Before
	public static void before() 
	{
		System.out.println("B");
	}
	
	@After
	public static void after() 
	{
		System.out.println("C");
	}
	
	@Test
	public void test1() 
	{
		System.out.println("T1");
	}
	
	
	@Test
	public void test2() 
	{
		System.out.println("T2");
	}
	
	@AfterClass
	public static void afterClass() 
	{
		System.out.println("D");
	}

}
