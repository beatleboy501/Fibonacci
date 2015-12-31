package test;

import org.junit.Assert;

import org.junit.Test;

import main.FibonacciIndex;

public class FibonacciIndexTest {
	
	FibonacciIndex fibIndex = new FibonacciIndex();
	
	@Test
	public void test1() throws Exception {
		int index = 1; 
		Integer[] indices = fibIndex.returnIndices(index);
		Assert.assertTrue(indices.length == index);
		Assert.assertTrue(indices[0] == 1);
	}
	
	@Test
	public void test2() throws Exception {
		int index = 2; 
		Integer[] indices = fibIndex.returnIndices(index);
		Assert.assertTrue(indices.length == index);
		Assert.assertTrue(indices[0] == 1);
		Assert.assertTrue(indices[1] == 1);
	}
	
	@Test
	public void test3() throws Exception {
		int index = 3; 
		Integer[] indices = fibIndex.returnIndices(index);
		Assert.assertTrue(indices.length == index);
		Assert.assertTrue(indices[0] == 1);
		Assert.assertTrue(indices[1] == 1);
		Assert.assertTrue(indices[2] == 2);
	}
}
