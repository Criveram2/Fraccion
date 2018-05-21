package com.crivera.model;

import com.crivera.Utils.MathUtils;

public class Fraction {

	private final int numerator;
	private final int denominator;

	public Fraction(int numerator, int denominator) {
		// Preconditions.checkArgument(denominator >= 0, "negative value: %s",
		// denominator);
		if (denominator == 0) {
			throw new IllegalArgumentException("enominator =: " + denominator);
		}
		int MCD = MathUtils.mcd(numerator, denominator);
		this.numerator = numerator / MCD;
		this.denominator = denominator / MCD;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public Fraction plus(Fraction fraction) {
		int MCM = MathUtils.mcm(this.getDenominator(), fraction.getDenominator());
		int firstNumerador = MCM / this.denominator * this.numerator;
		int secondNumerador = MCM / fraction.getDenominator() * fraction.getNumerator();
		Fraction fractionPlus = new Fraction(firstNumerador + secondNumerador, MCM);
		return fractionPlus;
	}

	public Fraction less(Fraction fraction) {
		int MCM = MathUtils.mcm(this.denominator, fraction.getDenominator());
		int firstNumerador = MCM / this.denominator * this.numerator;
		int secondNumerador = MCM / fraction.getDenominator() * fraction.getNumerator();
		Fraction fractionLess = new Fraction(firstNumerador - secondNumerador, MCM);
		return fractionLess;
	}

	public Fraction multipliedBy(Fraction fraction) {
		int numerator = this.numerator * fraction.getNumerator();
		int denominator = this.denominator * fraction.getDenominator();
		Fraction fractionMultiply = new Fraction(numerator, denominator);
		return fractionMultiply;
	}

	public Fraction dividedBy(Fraction fraction) {
		int numerator = this.numerator * fraction.getDenominator();
		int denominator = this.denominator * fraction.getNumerator();
		Fraction fractionDivide = new Fraction(numerator, denominator);
		return fractionDivide;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominator;
		result = prime * result + numerator;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d/%d", numerator, denominator);
	}

}
