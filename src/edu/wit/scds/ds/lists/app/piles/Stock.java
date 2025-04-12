/* @formatter:off
 *
 * © David M Rosenberg
 * Spring, 2025
 *
 * Comp 2000 ~ Data Structures
 * Demonstration: List App
 * 
 * Usage restrictions:
 * 
 * You may use this code for exploration, experimentation, and furthering your
 * learning for this course. You may not use this code for any other
 * assignments, in my course or elsewhere, without explicit permission, in
 * advance, from myself (and the instructor of any other course).
 * 
 * Further, you may not post (including in a public repository such as on github)
 * nor otherwise share this code with anyone other than current students in my 
 * sections of this course
 * 
 * Violation of these usage restrictions will be considered a violation of
 * Wentworth Institute of Technology's Academic Honesty Policy.  Unauthorized posting
 * or use of this code may also be considered copyright infringement and may subject
 * the poster and/or the owners/operators of said websites to legal and/or financial
 * penalties.  Students are permitted to store this code in a private repository
 * or other cloud-based storage.
 *
 * Do not modify or remove this notice.
 *
 * @formatter:on
 */


package edu.wit.scds.ds.lists.app.piles ;

import edu.wit.scds.ds.lists.app.cards.Card ;
import static edu.wit.scds.ds.lists.app.cards.Card.* ;
import edu.wit.scds.ds.lists.app.utilities.NoCardsException ;

/**
 * Representation of a stock of cards
 * <p>
 * this is the source of all cards available to the game during gameplay
 *
 * @author Dave Rosenberg
 *
 * @version 0.1 2025-03-31 skeleton for assignment
 * 
 * @author Your Name    // TODO
 * 
 * @version 1.0 2025-03-31 Initial implementation per assignment
 */
public class Stock extends Pile
	{
	/*
	 *  utility constants
	 */
	// none
	
	
    /*
     *  data fields
     */
    // none
    
    
    /*
     * constructors
     */
    

    /**
     * Initialize a stock of {@code Cards} with the cards face-down
     */
	public Stock()
		{

        // initialize the pile
        super( FACE_DOWN ) ;

		
		}	// end no-arg constructor
	

    /*
     * public methods
     */

	// TODO implement this

	
	
	/*
	 * private utility methods
	 */
	// none

	
	/*
	 * for testing/debugging
	 */
	

	/**
     * (optional) test driver
     * 
     * @param args
     *     -unused-
     */
	public static void main( String[] args )
		{
		// TODO Auto-generated method stub

		}	// end main()

	}	// end class Deck