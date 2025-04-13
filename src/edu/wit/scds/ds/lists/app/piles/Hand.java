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

import java.util.List ;
import java.util.ListIterator ;

/**
 * Representation of a hand of cards
 * 
 * @author Dave Rosenberg
 *
 * @version 0.1 2025-03-31 skeleton for assignment
 * 
 * @author Andrew Pierre
 * 
 * @version 1.0 2025-03-31 Initial implementation per assignment
 */
public class Hand extends Pile
    {

    // no additional data fields

    /*
     * constructors
     */

    /**
     * initialize hand
     */
    public Hand()
        {

        super() ;

        this.defaultFaceDown = FACE_UP ;

        }	// end no-arg constructor

    /*
     * public methods
     */

    // TODO implement this

    /**
     * @param dealt represents 'card dealt to hand'
     * 
     */
    public void addToTop( Card dealt )
        {
        
        this.cards.add( 0, dealt ) ;
        
        }



    /**
     * @return 
     * 
     * 
     */
    public Card getRandomCard()
        {
        int ranPosition = (int) ( Math.random() * this.cards.size() ) ;
        return this.cards.get( ranPosition ) ;

        }


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



    }	// end class Hand
