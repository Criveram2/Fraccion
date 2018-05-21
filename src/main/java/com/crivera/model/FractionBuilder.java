package com.crivera.model;

import com.crivera.Utils.MathUtils;
import com.google.common.base.Preconditions;

public class FractionBuilder {

	private final int numerator;
	private final int denominator;

	private FractionBuilder(Builder builder) {
		int MCD = MathUtils.mcd(builder.denominator, builder.denominator);
		this.numerator = builder.denominator / MCD;
		this.denominator = builder.denominator / MCD;
	}

	public int getDenominator() {
		return denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public FractionBuilder plus(FractionBuilder fraction) {
		int MCM = MathUtils.mcm(this.getDenominator(), fraction.getDenominator());
		int firstNumerador = MCM / this.denominator * this.numerator;
		int secondNumerador = MCM / fraction.getDenominator() * fraction.getNumerator();
		Builder fractionPlus = new Builder();
		return fractionPlus.numerator(firstNumerador + secondNumerador).denominator(MCM).build();
	}

	public FractionBuilder less(FractionBuilder fraction) {
		int MCM = MathUtils.mcm(this.denominator, fraction.getDenominator());
		int firstNumerador = MCM / this.denominator * this.numerator;
		int secondNumerador = MCM / fraction.getDenominator() * fraction.getNumerator();
		Builder fractionLess = new Builder();

		return fractionLess.numerator(firstNumerador - secondNumerador).denominator(MCM).build();
	}

	public FractionBuilder multipliedBy(FractionBuilder fraction) {
		int numerator = this.numerator * fraction.getNumerator();
		int denominator = this.denominator * fraction.getDenominator();
		Builder fractionMultiply = new Builder();
		return fractionMultiply.numerator(numerator).denominator(denominator).build();
	}

	public FractionBuilder dividedBy(FractionBuilder fraction) {
		int numerator = this.numerator * fraction.getDenominator();
		int denominator = this.denominator * fraction.getNumerator();
		Builder fractionDivide = new Builder();
		return fractionDivide.numerator(numerator).denominator(denominator).build();
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
		FractionBuilder other = (FractionBuilder) obj;
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

	public static class Builder {
		private int numerator;
		private int denominator = 1;

		public Builder numerator(final int numerator) {
			this.numerator = numerator;
			return this;
		}

		public Builder denominator(final int denominator) {
			Preconditions.checkArgument(denominator != 0, "Denominator must be different to zero");
			this.denominator = denominator;
			return this;
		}

		public FractionBuilder build() {
			return new FractionBuilder(this);
		}
	}
}
