package _config;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Properties {

	/**
	 * Saves or updates a property in the config.txt file.
	 * If the property exists, its value will be updated; otherwise, it will be added.
	 *
	 * @param property the property name (e.g., "speed").
	 * @param value the value to be associated with the property.
	 * @param fileName name of the file where it is stored
	 */
	public static void saveProperty(String property, String value, String fileName) {
		List<String> lines = new ArrayList<>();
		boolean propertyFound = false;

		if (!Files.exists(Paths.get(fileName))) {
			System.err.println("Error in Properties.java:\nFile "+fileName+" does not exist");
			return ; 
		}

		// Read existing lines
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(property + "=")) {
					lines.add(property + "=" + value); // Update the property
					propertyFound = true;
				} else {
					lines.add(line); // Keep other lines unchanged
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		// If the property was not found, append it
		if (!propertyFound) {
			lines.add(property + "=" + value);
		}

		// Write back all lines
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (String line : lines) {
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads the value of a property from config.txt.
	 * If the property does not exist, returns null.
	 *
	 * @param property the name of the property to read (e.g., "speed").
	 * @param fileName the name of the file where the property is stored
	 * @return the value associated with the property, or null if not found.
	 */
	public static String readProperty(String property, String fileName) {
		if (!Files.exists(Paths.get(fileName))) {
			System.err.println("Error in Properties.java:\nFile "+fileName+" does not exist");
			return null;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(property + "=")) {
					return line.substring((property + "=").length());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null; // Property not found
	}

	/**
	 * speichert alle properties
	 * @param properties
	 * @param fileName
	 */
	public static void saveProperties(Map<String,String> properties, String fileName) {
		// in the end lines will be written back to the file.
		List<String> lines = new ArrayList<>();
		if (!Files.exists(Paths.get(fileName))) {
			System.err.println("Error in Properties.java:\nFile "+fileName+" does not exist");
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] splits = line.replaceAll(" ","").split("=");
				String key = splits[0];
				String value = splits[1];
				String newValue = properties.get(key);
				if(newValue != null) {
					value = newValue;
				}
				lines.add(key+"="+value);
				// remove the handled property
				properties.remove(key);
			}

			// now add properties that do not exist in the file
			Iterator<Map.Entry<String, String>> iterator = properties.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, String> entry = iterator.next();
				lines.add(entry.getKey()+"="+entry.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// Write back all lines
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (String line : lines) {
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static Map<String,String> readAllProperties(String fileName) {
		Map<String, String> result = new HashMap<>();
		if (!Files.exists(Paths.get(fileName))) {
			System.err.println("Error in Properties.java:\nFile "+fileName+" does not exist");
			return null; // File does not exist
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] splits = line.replaceAll(" ", "").split("=");
				if(splits.length != 2) {
					System.err.println("Incorrect Syntax in: "+fileName+"\nin line: "+line+":\n Number of = incorrect");
					continue;
				}
				String key = splits[0];
				String value = splits[1];
				result.put(key,value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		String fileName = "_config/configuration.txt";
		Map<String,String> newProperties = new HashMap<>();
		newProperties.put("GRAPH_ANZEIGE_HOEHE", ""+400);
		newProperties.put("test", ""+42);
		newProperties.put("WARTEZEIT_GRAPH", ""+30);
		Properties.saveProperties(newProperties, fileName);
		
		Map<String,String> allproperties = Properties.readAllProperties(fileName);
		// now add properties that do not exist in the file
		Iterator<Map.Entry<String, String>> iterator = allproperties.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			//System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
		
	}

}

