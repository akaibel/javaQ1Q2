package _test.datenbanken.tippgemeinschaft;

import datenbank.DatabaseConnector;

public class Main {
	private static final String dbUrl = "localhost";
	private static final String dbUser = "root";
	private static final String dbPassword = "geheim";
	private static final String dbDatabase = "tippgemeinschaft";
	
	
	private static Nutzer nutzer;
	private static DatabaseConnector databaseConnector;
	private static MainFrame mainFrame;
	
	
	
	public static Nutzer getNutzer() {
		return nutzer;
	}

	public static DatabaseConnector getDbConnection() {
		return databaseConnector;
	}

	public static MainFrame getMainFrame() {
		return mainFrame;
	}

	public static void main(String[] args) {
		nutzer = new Nutzer();
		databaseConnector = new DatabaseConnector(dbUrl, 3306, dbDatabase, dbUser, dbPassword);
		mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}
}
