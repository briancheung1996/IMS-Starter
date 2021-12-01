package com.qa.ims.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Utils {
	
	private static final Logger LOGGER = LogManager.getLogger();

	private final Scanner scanner;

	public Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public Utils() {
		scanner = new Scanner(System.in);
	}

	public Long getLong() {
		String input = null;
		Long longInput = null;
		do {
			try {
				input = getString();
				longInput = Long.parseLong(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a number");
			}
		} while (longInput == null);
		return longInput;
	}

	public String getString() {
		return scanner.nextLine();
	}

	public Long[] getLongs() {
		String input = null;
		Long longInput = null;
		do {
			try {
				input = getString();
				String[] inputs = input.split(" ");
				if (inputs.length == 2) {
					Long [] out = new Long[2];
					out[0] = Long.parseLong(inputs[0]);
					out[1] = Long.parseLong(inputs[1]);
					return out;
				}
				if (inputs.length > 2) {
					LOGGER.info("More than two ids supplied.");
					return null;
				}
				longInput = Long.parseLong(input);
				return new Long[]{longInput};
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a number");
			}
		} while (longInput == null);
		return null;
	}

	public Double getDouble() {
		String input = null;
		Double doubleInput = null;
		do {
			try {
				input = getString();
				doubleInput = Double.parseDouble(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a number");
			}
		} while (doubleInput == null);
		return doubleInput;
	}

}
