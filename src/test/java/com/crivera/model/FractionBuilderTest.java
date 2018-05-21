package com.crivera.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.crivera.model.FractionBuilder.Builder;

public class FractionBuilderTest {
	@Test
	public void simplificate() {
		FractionBuilder f1 = new Builder().numerator(1).denominator(2).build();
		FractionBuilder f2 = new Builder().numerator(2).denominator(4).build();
		assertThat(f1.toString(), is(f2.toString()));
	}

	@Test
	public void plusFraction() {
		FractionBuilder f1 = new Builder().numerator(1).denominator(2).build();
		FractionBuilder fresult = new Builder().numerator(1).build();
		assertThat(f1.plus(f1), is(fresult));
	}
	
	
	@Test
	public void lessFraction() {
		FractionBuilder f1 = new Builder().numerator(3).denominator(2).build();
		FractionBuilder f2 = new Builder().numerator(1).build();
		FractionBuilder fresult = new Builder().numerator(1).denominator(2).build();
		assertThat(f1.less(f2), is(fresult));
	}
	
	
	@Test
	public void multipliedByFraction() {
		FractionBuilder f1 = new Builder().numerator(3).denominator(2).build();
		FractionBuilder f2 = new Builder().numerator(7).denominator(4).build();
		FractionBuilder fresult = new Builder().numerator(21).denominator(8).build();
		assertThat(f1.multipliedBy(f2), is(fresult));
	}
	
	@Test
	public void divideFraction() {
		FractionBuilder f1 = new Builder().numerator(2).denominator(3).build();
		FractionBuilder f2 = new Builder().numerator(3).denominator(2).build();
		FractionBuilder fresult = new Builder().numerator(4).denominator(9).build();
		assertThat(f1.dividedBy(f2), is(fresult));
	}
	
	

}
