package no.hvl.dat102.exception;
//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen n?r samlingen er tom
//********************************************************************
public class EmptyCollectionException extends RuntimeException{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/******************************************************************
     Setter opp et unntak med passende melding.
   ******************************************************************/
   public EmptyCollectionException (String samling) {
      super ("" + samling + " er tom.");
   }
}
