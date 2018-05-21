package com.crivera.Utils;

public final class MathUtils {

	private MathUtils() {
		throw new AssertionError("Esta clase no se deberia instanciar");
	}

	public static int mcd(int a, int b) {
		return b == 0 ? a : mcd(b, a % b);

	}

	public static int mcm(int a, int b) {
		return a * b / mcd(a, b);
	}
}
