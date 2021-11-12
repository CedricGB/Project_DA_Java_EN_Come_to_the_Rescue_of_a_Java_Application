package com.hemebiotech.analytics;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private SortedMap<String, Integer> result;
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;

	}

	/**
	 * Read the symptoms from a file
	 * @return a SortedMap with the information read from a file
	 */

	@Override
	public SortedMap<String, Integer> getSymptoms() {

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					// If symptom already exist, we increment the number. If not, we add it.
					if(result.containsKey(line)){
						result.put(line, result.get(line) + 1);

					} else {
						result.put(line, 1);
					}
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return this.result;
	}

}
