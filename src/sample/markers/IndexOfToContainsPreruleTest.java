package sample.markers;

import java.util.List;

import java.util.ArrayList;

public class IndexOfToContainsPreruleTest {

	public void testList() {
		List<String> l = new ArrayList<>();
		String s = "searchString";

		// not contains
		if (!l.contains(s)) {
			l.add(s);
		}

		if (l.indexOf(s) < 0) {
			l.add(s);
		}

		if (l.indexOf(s) <= -1) {
			l.add(s);
		}

		if (-1 == l.indexOf(s)) {
			l.add(s);
		}

		if (0 > l.indexOf(s)) {
			l.add(s);
		}

		if (-1 >= l.indexOf(s)) {
			l.add(s);
		}

		if (!l.contains(s)) {
			l.add(s);
		}

		// contains
		if (l.indexOf(s) != -1) {
			l.remove(s);
		}

		if (l.indexOf(s) > -1) {
			l.remove(s);
		}

		if (l.indexOf(s) >= 0) {
			l.remove(s);
		}

		if (-1 != l.indexOf(s)) {
			l.remove(s);
		}

		if (-1 < l.indexOf(s)) {
			l.remove(s);
		}

		if (0 <= l.indexOf(s)) {
			l.remove(s);
		}

		if (l.contains(s)) {
			l.remove(s);
		}

		// other cases without transformation
		if (l.indexOf(s) == 0) {
			l.remove(s);
		}

		if (l.indexOf(s) == 1) {
			l.remove(s);
		}

		if (l.indexOf(s) > 0) {
			l.remove(s);
		}

		if (0 == l.indexOf(s)) {
			l.remove(s);
		}

		if (1 == l.indexOf(s)) {
			l.remove(s);
		}

		if (0 < l.indexOf(s)) {
			l.remove(s);
		}

		int i = 0;
		while ((i = l.indexOf(s)) != -1) {
			System.out.println(s);
		}

		while ((i = l.indexOf(s)) >= 0) {
			System.out.println(s);
		}

		int index = l.indexOf(s);
		System.out.println("object found at index: " + index);

		/*
		 * Some cases with comments
		 */

		if (/* saving comments */ l.indexOf(s) == -1) {
			l.add(s);
		}

		if (l // index of
				.indexOf(s) == -1) {
			l.add(s);
		}

		if (l // I don't want to break anything
				.indexOf(s) < 0) {
			l.add(s);
		}
	}

	public void testString() {
		String s = "Hello World";

		// not contains
		if (s.indexOf("ello") == -1) {
			System.out.println(s);
		}

		if (s.indexOf("ello") < 0) {
			System.out.println(s);
		}

		if (s.indexOf("ello") <= -1) {
			System.out.println(s);
		}

		if (-1 == s.indexOf("ello")) {
			System.out.println(s);
		}

		if (0 > s.indexOf("ello")) {
			System.out.println(s);
		}

		if (-1 >= s.indexOf("ello")) {
			System.out.println(s);
		}

		if (!s.contains("ello")) {
			System.out.println(s);
		}

		// contains
		if (s.indexOf("ello") != -1) {
			System.out.println(s);
		}

		if (s.indexOf("ello") > -1) {
			System.out.println(s);
		}

		if (s.indexOf("ello") >= 0) {
			System.out.println(s);
		}

		if (-1 != s.indexOf("ello")) {
			System.out.println(s);
		}

		if (-1 < s.indexOf("ello")) {
			System.out.println(s);
		}

		if (0 <= s.indexOf("ello")) {
			System.out.println(s);
		}

		if (s.contains("ello")) {
			System.out.println(s);
		}

		if (/* save me */ s.indexOf("ello") != -1) {
			System.out.println(s);
		}

		// char as argument of indexOf
		if (s.indexOf('l') != -1) {
			System.out.println(s);
		}

		if (s.indexOf('l') >= 0) {
			System.out.println(s);
		}

		// other cases without transformation
		if (s.indexOf("ello") == 0) {
			System.out.println(s);
		}

		if (s.indexOf("ello") == 1) {
			System.out.println(s);
		}

		if (s.indexOf("ello") > 0) {
			System.out.println(s);
		}

		if (0 == s.indexOf("ello")) {
			System.out.println(s);
		}

		if (1 == s.indexOf("ello")) {
			System.out.println(s);
		}

		if (0 < s.indexOf("ello")) {
			System.out.println(s);
		}

		int i = 0;
		while ((i = s.indexOf("ello")) != -1) {
			System.out.println(s);
		}

		while ((i = s.indexOf("ello")) >= 0) {
			System.out.println(s);
		}

		int index = s.indexOf("ello");
		System.out.println("substring found at index: " + index);
	}
}
