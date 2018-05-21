package com.crivera.model;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class FractionTest {
	@Test
	public void simplificate() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(2,4);
		assertThat(f1.toString(), is(f2.toString()));
	}
	
	@Test
	public void plusFraction() {
		Fraction f1 = new Fraction(1,2);
		Fraction fresult = new Fraction(1,1);
		assertThat(f1.plus(f1), is(fresult));
	}
	
	@Test
	public void OtherplusFraction() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(1,1);
		Fraction fresult = new Fraction(3,2);
		assertThat(f1.plus(f2), is(fresult));
	}
	
	@Test
	public void lessFraction() {
		Fraction f1 = new Fraction(3,2);
		Fraction f2 = new Fraction(1,1);
		Fraction fresult = new Fraction(1,2);
		assertThat(f1.less(f2), is(fresult));
	}
	
	@Test
	public void multipliedByFraction() {
		Fraction f1 = new Fraction(6,4);
		Fraction f2 = new Fraction(7,4);
		Fraction fresult = new Fraction(21,8);
		assertThat(f1.multipliedBy(f2), is(fresult));
	}
	
	@Test
	public void divideFraction() {
		Fraction f1 = new Fraction(2,3);
		Fraction f2 = new Fraction(7,5);
		Fraction fresult = new Fraction(10,21);
		assertThat(f1.dividedBy(f2), is(fresult));
	}
	
}
