package com.example.project.cli;

import java.util.Map.Entry;

import de.charite.compbio.jannovar.data.JannovarData;
import de.charite.compbio.jannovar.data.JannovarDataSerializer;
import de.charite.compbio.jannovar.data.SerializationException;

public class Cli {

	public static int foo() {
		return 42;
	}

	public static void main(String[] args) throws SerializationException {
		System.err.println("Hello World!");

		// test arguments and get path to Jannovar .ser file
		if (args.length != 1) {
			System.err.println("Usage: example-project-0.1-SNAPSHOT.jar DB.ser");
			System.exit(1);
		}

		String dbPath = args[0];
		System.err.println("database file\t" + dbPath);

		// print contig/length pairs
		JannovarData data = new JannovarDataSerializer(dbPath).load();
		System.err.println("\nContig Length Information\n");
		System.err.println("name\tlength\n");
		for (Entry<Integer, Integer> x : data.getRefDict().getContigIDToLength().entrySet())
			System.err.println(data.getRefDict().getContigIDToName().get(x.getKey()) + "\t" + x.getValue());
	}
}
