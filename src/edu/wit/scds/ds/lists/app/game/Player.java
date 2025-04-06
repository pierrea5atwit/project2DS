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

package edu.wit.scds.ds.lists.app.game ;

import edu.wit.scds.ds.lists.app.cards.Card ;
import edu.wit.scds.ds.lists.app.piles.Field ;
import edu.wit.scds.ds.lists.app.piles.Hand ;

/**
 * Representation of a player
 *
 * @author Dave Rosenberg
 *
 * @version 0.1 2025-03-31 skeleton for assignment
 *
 * @author ANDREW PIERRE
 *
 * @version 1.0 2025-03-31 Initial implementation per assignment
 */
public class Player
    {

    /*
     * data fields
     */

    // TODO you don't need to keep these data fields and you aren't limited to them

    /** the cards that are in-play */
    private final Hand hand ;

    /** the cards collected during play */
    private final Field field ;

    /** player's name */
    public final String name ;

    /*
     * constructor(s)
     */

    /**
     * initialize a player
     *
     * @param playerName
     *     the player's name
     */
    public Player( final String playerName )
        {

        this.name = playerName ;

        this.hand = new Hand() ;

        this.field = new Field() ;

        }	// end constructor

    /*
     * public methods
     */

    // NOTE I provided a few methods to get you started - you can keep them, modify
    // them, or toss them
    // TODO implement this


    /**
     * Add a dealt card to our hand
     *
     * @param dealt
     *     the card we're dealt
     */
    public void dealtACard( final Card dealt )
        {

        this.hand.addToTop( dealt ) ;
        this.hand.sort() ;

        }  // end dealtACard()


    /**
     * Hand a card to another player, they add it to their hand via dealtACard
     *
     * @param 'target'
     *     player, person recieving the card.
     */
    public void giveCardToPlayer( Player target )
        {
        this.hand.flipAll() ;
        this.hand.shuffle() ;
        Card giveaway = this.hand.getRandomCard() ;
        target.dealtACard( giveaway ) ;

        }


    /**
     * provide a string revealing the contents of the player's hand, re-conceals
     * after revealing
     *
     * @return a string containing the cards in the player's hand
     *
     * @since 1.0
     */
    public String revealHand()
        {

        this.hand.flipAll() ;
        String x = this.hand.toString() ;
        this.hand.flipAll() ;

        return x ;

        }   // end revealHand()


    /**
     * @param target
     *
     * @return
     */
    public Card hasPair( Card target )
        {

        for ( Card card : this.hand )
            {
            if ( ( card.rank ).equals( target.rank ) && !card.equals( target ) )
                {
                return card ;

                }

            }

        return null ;

        }


    /**
     * @param target
     * @param matchingCard
     *
     * @return
     */
    public boolean removePair( Card target,
                               Card matchingCard )
        {

        if ( hasPair( target ) != null )
            {
            this.hand.removeCard( target ) ;
            this.hand.removeCard( matchingCard ) ;

            return true ;

            }

        return false ;

        }

    /*
     * utility methods
     */


    @Override
    public String toString()
        {

        return String.format( "%nPlayer: %s%n\thand: %s%n\tcardsCollected: %s",
                              this.name,
                              this.hand,
                              this.field ) ;

        }   // end toString()

    /*
     * testing/debugging
     */


    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {

        // STUB for testing/debugging

        }	// end main()

    }	// end class Player