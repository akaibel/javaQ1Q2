package datenbank;

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018.
 * </p>
 * <p>
 * Klasse QueryResult
 * </p>
 * <p>
 * Ein Objekt der Klasse QueryResult stellt die Ergebnistabelle einer Datenbankanfrage mit Hilfe 
 * der Klasse DatabaseConnector dar. Objekte dieser Klasse werden nur von der Klasse DatabaseConnector erstellt. 
 * Die Klasse verfuegt ueber keinen oeffentlichen Konstruktor.
 * </p>
 * 
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule
 * @version 2015-01-31
 */
public class QueryResult{
  private String[][] data;
  private String[] columnNames;
  private String[] columnTypes;

  /**
   * Paketinterner Konstruktor.
   */
  QueryResult(String[][] pData, String[] pColumnNames, String[] pColumnTypes){
    data = pData;
    columnNames = pColumnNames;   
    columnTypes = pColumnTypes;
  }

  /**
   * Die Anfrage liefert die Eintraege der Ergebnistabelle als zweidimensionales Feld
   * vom Typ String. Der erste Index des Feldes stellt die Zeile und der zweite die 
   * Spalte dar (d.h. Object[zeile][spalte]).
   */
  public String[][] getData(){
    return data;
  }

  /**
   * Die Anfrage liefert die Bezeichner der Spalten der Ergebnistabelle als Feld vom 
   * Typ String zurueck.
   */
  public String[] getColumnNames(){
    return columnNames;
  }

  /**
   * Die Anfrage liefert die Typenbezeichnung der Spalten der Ergebnistabelle als Feld 
   * vom Typ String zurueck. Die Bezeichnungen entsprechen den Angaben in der MySQL-Datenbank.
   */
  public String[] getColumnTypes(){
    return columnTypes;
  }

  /**
   * Die Anfrage liefert die Anzahl der Zeilen der Ergebnistabelle als Integer.
   */
  public int getRowCount(){
    if (data != null )
      return data.length;
    else 
      return 0;
  }

  /**
   * Die Anfrage liefert die Anzahl der Spalten der Ergebnistabelle als Integer.
   */
  public int getColumnCount(){
    if (data != null && data.length > 0 && data[0] != null)
      return data[0].length;
    else
      return 0;
  }

}