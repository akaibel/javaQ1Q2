package file;

import java.io.*;
import java.util.*;

public class FileReaderWriter {
	
	/**
	 * Es sollen keine Objekte vom Typ Serializer erzeugt werden.
	 */
	private FileReaderWriter(){		
	}
	
	/**
	 * speichert ein Objekt - und alle davon abhaengigen Objekte! - 
	 * in serialisierter Form.
	 * Voraussetzung: Das Objekt - und alle davon abhaengigen Objekte - 
	 * implementieren Serializable
	 * @param object
	 * @param filename
	 */
	public static void saveSerialized( Object object, String filename )
	{
		try
		{
			FileOutputStream file = new FileOutputStream( filename );
			ObjectOutputStream o = new ObjectOutputStream( file );
			o.writeObject  ( object );
			o.writeObject  ( new Date() );
			o.close();
		}
		catch ( IOException e ) { System.err.println("FileReaderWriter.saveSerialized(): "+ e ); }
	}

	/**
	 * liest ein serialisiertes Objekt 
	 * @param filename
	 * @return
	 */
	public static Object readSerialized( String filename )
	  {
		Object result = null; 
	    try
	    {
	      FileInputStream file = new FileInputStream( filename );
	      ObjectInputStream o = new ObjectInputStream( file );
	      result =  o.readObject();
	      o.close();
	    }
	    catch ( IOException e ) { 
	    	System.err.println("FileReaderWriter.readSerialized(): "+ e ); 
	    }
	    catch ( ClassNotFoundException e ) { 
	    	System.err.println("FileReaderWriter.readSerialized(): "+ e ); 
	    }
	    return result;
	  }
	
}

