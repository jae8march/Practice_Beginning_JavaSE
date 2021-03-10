package com.epam.rd.java.basic.practice6.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class WordContainer for Task 1.
 */
public class WordContainer extends ArrayList<Word> {
	public static void main(String[] args) {
		System.out.println(getWord());
	}

	public static String getWord() {
		ArrayList<Word> list = new WordContainer();
		Scanner in = new Scanner(System.in);

		String line = in.next();

		while (!"stop".equalsIgnoreCase(line)) {
			list.add(new Word(line));
			line = in.next();
		}
		Collections.sort(list);
		return list.toString();
	}

	@Override
	public boolean add(Word wi) {
		WordContainer wc = new WordContainer();
		if (wc.toString().equals(" he")) {
			return false;
		}
		for (Word word : this) {
			if (word.equals(wi)) {
				word.increment();
				return true;
			}
		}
		super.add(wi);
		return true;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Object object : this) {
			str.append(object).append(System.lineSeparator());
		}
		return str.toString().trim();
	}
}

