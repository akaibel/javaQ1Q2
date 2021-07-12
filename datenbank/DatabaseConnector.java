package datenbank;

import java.sql.*;

import linear.Queue;

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018
 * </p>
 * <p>
 * Klasse DatabaseConnector
 * </p>
 * <p>
 * Ein Objekt der Klasse DatabaseConnector ermoeglicht die Abfrage und Manipulation 
 * einer MySQL-Datenbank. 
 * Beim Erzeugen des Objekts wird eine Datenbankverbindung aufgebaut, so dass 
 * anschließend SQL-Anweisungen an diese Datenbank gerichtet werden koennen.
 * </p>
 * 
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule
 * @version 2016-01-24
 */
public class DatabaseConnector{
  private Connection connection;  
  private QueryResult currentQueryResult = null;
  private String message = null;

    /**
   * Ein Objekt vom Typ DatabaseConnector wird erstellt, und eine Verbindung zur Datenbank 
   * wird aufgebaut. Mit den Parametern pIP und pPort werden die IP-Adresse und die 
   * Port-Nummer uebergeben, unter denen die Datenbank mit Namen pDatabase zu erreichen ist. 
   * Mit den Parametern pUsername und pPassword werden Benutzername und Passwort fuer die 
   * Datenbank uebergeben.
   */
  public DatabaseConnector(String pIP, int pPort, String pDatabase, String pUsername, String pPassword){
    try {
      //Laden der Treiberklasse
      Class.forName("com.mysql.jdbc.Driver");

      //Verbindung herstellen
      connection = DriverManager.getConnection("jdbc:mysql://"+pIP+":"+pPort+"/"+pDatabase, pUsername, pPassword);

    } catch (Exception e) {
      message = e.getMessage();
    }
  }

  /**
   * Der Auftrag schickt den im Parameter pSQLStatement enthaltenen SQL-Befehl an die 
   * Datenbank ab. 
   * Handelt es sich bei pSQLStatement um einen SQL-Befehl, der eine Ergebnismenge 
   * liefert, so kann dieses Ergebnis anschließend mit der Methode getCurrentQueryResult 
   * abgerufen werden.
   */
  public void executeStatement(String pSQLStatement){  
    //Altes Ergebnis loeschen
    currentQueryResult = null;
    message = null;

    try {
      //Neues Statement erstellen
      Statement statement = connection.createStatement();

      //SQL Anweisung an die DB schicken.
      if (statement.execute(pSQLStatement)) { //Fall 1: Es gibt ein Ergebnis

        //Resultset auslesen
        ResultSet resultset = statement.getResultSet();

        //Spaltenanzahl ermitteln
        int columnCount = resultset.getMetaData().getColumnCount();
        
        //Spaltennamen und Spaltentypen in Felder uebertragen
        String[] resultColumnNames = new String[columnCount];
        String[] resultColumnTypes = new String[columnCount];
        for (int i = 0; i < columnCount; i++){
          resultColumnNames[i] = resultset.getMetaData().getColumnLabel(i+1);
          resultColumnTypes[i] = resultset.getMetaData().getColumnTypeName(i+1);
        }

        //Queue fuer die Zeilen der Ergebnistabelle erstellen
        Queue<String[]> rows = new Queue<String[]>();

        //Daten in Queue uebertragen und Zeilen zaehlen
        int rowCount = 0;
        while (resultset.next()){
          String[] resultrow =  new String[columnCount];
          for (int s = 0; s < columnCount; s++){
            resultrow[s] = resultset.getString(s+1);
          }
          rows.enqueue(resultrow);
          rowCount = rowCount + 1;
        }

        //Ergebnisfeld erstellen und Zeilen aus Queue uebertragen
        String[][] resultData = new String[rowCount][columnCount];
        int j = 0;
        while (!rows.isEmpty()){
          resultData[j] = rows.front();
          rows.dequeue();          
          j = j + 1;
        }
               
        //Statement schließen und Ergebnisobjekt erstellen
        statement.close();
        currentQueryResult =  new QueryResult(resultData, resultColumnNames, resultColumnTypes); 

      } else { //Fall 2: Es gibt kein Ergebnis.
        //Statement ohne Ergebnisobjekt schliessen
        statement.close();       
      }

    } catch (Exception e) {
      //Fehlermeldung speichern
      message = e.getMessage();
    }
  }

  /**
   * Die Anfrage liefert das Ergebnis des letzten mit der Methode executeStatement an 
   * die Datenbank geschickten SQL-Befehls als Ob-jekt vom Typ QueryResult zurueck.
   * Wurde bisher kein SQL-Befehl abgeschickt oder ergab der letzte Aufruf von 
   * executeStatement keine Ergebnismenge (z.B. bei einem INSERT-Befehl oder einem 
   * Syntaxfehler), so wird null geliefert.  
   */  
  public QueryResult getCurrentQueryResult(){
    return currentQueryResult;
  }

  /**
   * Die Anfrage liefert null oder eine Fehlermeldung, die sich jeweils auf die letzte zuvor ausgefuehrte 
   * Datenbankoperation bezieht.
   */
  public String getErrorMessage(){
    return message;
  }

  /**
   * Die Datenbankverbindung wird geschlossen.
   */
  public void close(){
    try{
      connection.close();
    } catch (Exception e) {
      message = e.getMessage();
    }
  }

}