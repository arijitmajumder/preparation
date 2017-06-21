package test;

import java.util.ArrayList;
import java.util.List;

public class Main {

	static void testShowingNoCaching() {
		List<String> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			// why I am doing this? There is no normal way to compare and non
			// gc.
			l.add(new String(""));
		}
		for (int i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				// these would never be same
				// there are no pooling
				// you got pooling totally wrong
				System.out.println(l.get(i) == l.get(j));
			}
		}
		// is JVM dumb? No, JDK is. Then, well...
	}

	static void testCache() {
		String x = "";
		String y = "";
		// this is the cache you were talking about
		// And yes, when we wrote CLR, we knew a bit about pooling to
		System.out.println(x == y);
		// here, you are right.
		// Linkers and Loaders by Levine.
		// That was the text that was supposed to teach you about this.
		// There is no Global pool, can not be. Move out of it.
	}

	static void testChange() {
		String a = "a";
		String A = "A";
		// this is pooling -->
		System.out.println("a" == a);
		System.out.println("A" == A);
		// This is the behaviour you can not explain, can you ?
		// if pool was the reason this would return true.
		// it does not, because it can not - because it is not
		// drop the pretext you know why String was made immutable - you have
		// really no idea
		// read the SDK. It will help you if you want to write your own language
		// extension.
		// this is not pooling -->
		System.out.println(A.toLowerCase() == a);
		System.out.println(a.toUpperCase() == A);
		// someone choose a moronic reason to make string immutable -
		// and it stuck. Not a very good reason.
		// Java Strings are *actually* mutable - there is no way to stop
		// string.value[x] access via reflection
		// in our DS languages (nJexl/ZoomBA) we do it day in and day out
		// https://arxiv.org/abs/1604.05903
		// https://mvnrepository.com/artifact/com.github.nmondal/njexl.lang
		// http://zoomba-lang.org/index.html
	}

	public static void main(String[] args) {
		testShowingNoCaching();
		testCache();
		testChange();
	}

}
