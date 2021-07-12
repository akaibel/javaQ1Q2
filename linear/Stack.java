package linear; 

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2017
 * </p>
 * <p>
 * Generische Klasse Stack<ContentType>
 * </p>
 * <p>
 * Objekte der generischen Klasse Stack (Keller, Stapel) verwalten beliebige
 * Objekte vom Typ ContentType nach dem Last-In-First-Out-Prinzip, d.h., das
 * zuletzt abgelegte Objekt wird als erstes wieder entnommen. Alle Methoden
 * haben eine konstante Laufzeit, unabhaengig von der Anzahl der verwalteten
 * Objekte.
 * </p>
 * 
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version Generisch_02 2014-02-21
 */
public class Stack<ContentType> {

  /* --------- Anfang der privaten inneren Klasse -------------- */

  class StackNode { // Sichtbarkeit geaendert wg. SViewer (GF)

    private ContentType content = null;
    private StackNode nextNode = null;

    /**
     * Ein neues Objekt vom Typ StackNode<ContentType> wird erschaffen. <br />
     * Der Inhalt wird per Parameter gesetzt. Der Verweis ist leer.
     * 
     * @param pContent der Inhalt des Knotens
     */
    public StackNode(ContentType pContent) {
      content = pContent;
      nextNode = null;
    }

    /**
     * Der Verweis wird auf das Objekt, das als Parameter uebergeben wird,
     * gesetzt.
     * 
     * @param pNext der Nachfolger des Knotens
     */
    public void setNext(StackNode pNext) {
      nextNode = pNext;
    }

    /**
     * 
     * @return das Objekt, auf das der aktuelle Verweis zeigt
     */
    public StackNode getNext() {
      return nextNode;
    }

    /**
     * @return das Inhaltsobjekt vom Typ ContentType
     */
    public ContentType getContent() {
      return content;
    }
  }

  /* ----------- Ende der privaten inneren Klasse -------------- */

  private StackNode head;

  /**
   * Ein leerer Stapel wird erzeugt. Objekte, die in diesem Stapel verwaltet
   * werden, muessen vom Typ ContentType sein.
   */
  public Stack() {
    head = null;
  }

  /**
   * Die Anfrage liefert den Wert true, wenn der Stapel keine Objekte
   * enthaelt, sonst liefert sie den Wert false.
   * 
   * @return true, falls der Stapel leer ist, sonst false
   */
  public boolean isEmpty() {
    return (head == null);
  }

  /**
   * Das Objekt pContentType wird oben auf den Stapel gelegt. Falls
   * pContentType gleich null ist, bleibt der Stapel unveraendert.
   * 
   * @param pContent 
   *        das einzufuegende Objekt vom Typ ContentType
   */
  public void push(ContentType pContent) {
    if (pContent != null) {
      StackNode node = new StackNode(pContent);
      node.setNext(head);
      head = node;
    }
  }

  /**
   * Das zuletzt eingefuegte Objekt wird von dem Stapel entfernt. Falls der
   * Stapel leer ist, bleibt er unveraendert.
   */
  public void pop() {
    if (!isEmpty()) {
      head = head.getNext();
    }
  }

  /**
   * Die Anfrage liefert das oberste Stapelobjekt. Der Stapel bleibt
   * unveraendert. Falls der Stapel leer ist, wird null zurueckgegeben.
   * 
   * @return das oberste Stackelement vom Typ ContentType oder null, falls
   *         der Stack leer ist
   */
  public ContentType top() {
    if (!this.isEmpty()) {
      return head.getContent();
    } else {
      return null;
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------------------------------
  
  /**
   *  Folgende Hilfsmethoden dienen nur der Darstellung als StackWithViewer, sie sind nicht Teil der Abitur-Schnittstelle (KB/BM/HO/GF)
  */
  public StackNode getTopNode(){
	  return this.head;
  }
  
}
