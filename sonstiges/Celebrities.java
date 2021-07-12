/**
 * https://www.forbes.com/celebrities/
 * The forbes top earning celebrities 2020
 * 
 * The top earning celebrities were Kylie Jenner and Kanye West​, 
 * who brought in $590 million and $170 million, respectively. 
 * West collected most of his ​earnings from his Yeezy sneakers deal with Adidas, 
 * while Jenner’s payday came from selling a 51% stake ​in her cosmetics firm to Coty in January. 
 * While she had exaggerated over the years about the size of her business, 
 * the money she pulled in from the deal was real--enough 
 * to rank as one of the biggest celebrity cashouts of all time.
 * 
 * Three streaming giants doled out $300 million to stars on the list, 
 * including Ryan Reynolds (No. 18, $71.5 million), Billie Eilish (No. 43, $53 million) 
 * and Jerry Seinfeld (No. 46, $51 million), with Netflix paying out more than two thirds of that.
 * 
 * Live shows drove career-best income for some of music’s biggest names, 
 * with Ed Sheeran’s Divide Tour drawing 8.9 million fans 
 * and grossing $776 million over two-plus years 
 * to surpass U2’s all-time record for a single tour. 
 * Others will take a hit next year as tours for everyone 
 * from Taylor Swift (No. 25, $63.5 million) to Paul McCartney (No. 93, $37 million) 
 * have been cancelled because of the pandemic.
 * 
 * In sports, Roger Federer (No. 3, $106.3 million) is the first tennis player to earn the top spot 
 * among athletes on the list, while soccer’s Cristiano Ronaldo (No. 4, $105 million) 
 * became the first team player to earn $1 billion during his career. 
 * Naomi Osaka set her own record at No. 90, bringing in $37 million income, 
 * the most money any female athlete has ever made in a single year.
 * 
 * Podcasting makes its first appearance in the voice of Bill Simmons (No.13, $82.5 million), 
 * who sold his podcast company The Ringer to Spotify in February for $206 million. 
 * Another newcomer: Hamilton creator and star Lin-Manuel Miranda (No. 62, $45.5 million), 
 * who added to his haul from the Broadway hit in February when Walt Disney paid $75 million 
 * for the rights to air the filmed version of his Founding Father musical. 
 * Miranda joined a chorus of celebrities using their fame to speak out after the killing of Floyd: 
 * “It’s up to us, in words and deeds, to stand up for our fellow citizens.” He’s one of a growing group of stars working to enact systemic change. More than a dozen on the Celebrity 100 have invested or otherwise worked with Andreessen Horowitz’s Cultural Leadership Fund, which aims to expand investment opportunities and access to tech jobs among African Americans.
 */


package sonstiges;
import linear.ListWithViewer;
import linear.QueueWithViewer;
import linear.StackWithViewer;

public class Celebrities {
	
	
	private static String[] vornamen  = {"Kylie" , "Kanye", "Roger"  , "Cristiano"  ,"Lionel", "Dwayne" , "Ariana", ""          , "Billie" , "Heidi", "Lady" , "Sebastian" }; 
	private static String[] namen     = {"Jenner", "West" , "Federer", "Ronaldo"    ,"Messi" , "Johnson", "Grande", "Marshmello", "Eilish" , "Klum" , "Gaga" , "Vettel"};
	private static int[]    einkommen = {590     , 115    , 106      , 105          ,104     , 87       , 72      , 56          , 53       , 39     , 38     , 36};

	public static Celebrity[] celebritiesArray(){
		Celebrity[] ergebnis = new Celebrity[namen.length];
		for (int i = 0; i < ergebnis.length; i++) {
			Celebrity aktuell = new Celebrity(namen[i], vornamen[i], einkommen[i]);
			ergebnis[i] = aktuell;
		}
		return ergebnis;
	}
	
	
	public static ListWithViewer<Celebrity> celebritiesList() {
		Celebrity[] celebrities =  celebritiesArray();
		ListWithViewer<Celebrity> dieListe = new ListWithViewer<Celebrity>();
		for (int i = 0; i < celebrities.length; i++) {
			dieListe.append(celebrities[i]);
		}
		return dieListe;
	}


	public static QueueWithViewer<Celebrity> celebritiesQueue() {
		Celebrity[] celebrities =  celebritiesArray();
		QueueWithViewer<Celebrity> derQueue = new QueueWithViewer<Celebrity>();
		for (int i = 0; i < celebrities.length; i++) {
			derQueue.enqueue(celebrities[i]);
		}
		return derQueue;
	}

	public static StackWithViewer<Celebrity> celebritiesStack() {
		Celebrity[] celebrities =  celebritiesArray();
		StackWithViewer<Celebrity> derStack = new StackWithViewer<Celebrity>();
		for (int i = 0; i < celebrities.length; i++) {
			derStack.push(celebrities[i]);
		}
		return derStack;
	}
	
}