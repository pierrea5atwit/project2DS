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
import edu.wit.scds.ds.lists.app.cards.Rank ;
import edu.wit.scds.ds.lists.app.piles.Field ;
import edu.wit.scds.ds.lists.app.piles.Hand ;

import java.util.ListIterator ;

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
     * @param target
     *     person recieving the card.
     * @return 
     */
    public Card giveTopCardToPlayer( Player target )
        {

        Card giveaway = this.hand.getRandomCard() ;
        target.dealtACard( giveaway ) ;
        this.hand.removeTopCard() ;
        
        return giveaway ; 
        }
    
    
    /**
     * 
     * 
     * @return
     */
    public int getHandSize() 
        {
        int count = 0 ; 
        for( @SuppressWarnings( "unused" ) Card cardInHand : this.hand ) 
            {
            count++ ; 
            }
        return count ; 
        }
    
    /**
     * 
     * 
     */
    public void shuffleHand() 
        {
        this.hand.shuffle();
        }


    /**
     * provide a string revealing the contents of the player's hand, 'put it back
     * down' after revealing
     *
     * @return a string containing the cards in the player's hand
     *
     * @since 1.0
     */
    public String revealHand()
        {

        this.hand.flipAllUp() ;
        String reveal = this.hand.toString() ;
        this.hand.flipAll() ;

        return reveal ;

        }   // end revealHand()


    /**
     * checks player's hand to see whether there's a card that matches
     * 
     * @param target
     *     card that the player is testing for pairs
     *
     * @return the given card's "Match" if found. else return null
     */
    public Card findMatch( Card target )
        {

        if ( target == null )
            return null ;

        // flag prevents counting one occurence as a pair
        boolean seen = false ;
        
        for ( Card card : this.hand )
            {
            if ( ( card.rank ).equals( target.rank ) && !seen )
                seen = true ;

            else if ( ( card.rank ).equals( target.rank ) && seen )
                {
                return card ;

                }

            }

        return null ;

        }
    
    /**
     * Checks if there are any matching pairs left
     * 
     * @return true or false 
     */
    public boolean hasPairs() 
        {
        
        for(Card card1 : this.hand) 
            {
            if(this.findMatch( card1 ) != null ) 
                {
                return true ;
                }
            }
        return false ;
        }
    
    
    /**
     * 
     * 
     * @return true or false
     */
    public boolean hasOldMaid() 
        {
        for(Card oldMaid : this.hand) 
            {
            if( oldMaid.rank == Rank.JOKER ) 
                {
                return true ;
                }
            }
        return false ;
        }

    
    /**
     * Player removes a card from their hand
     * 
     * @param first
     *     first card to remove
     * @param second
     *     second card to remove
     * 
     * @return boolean indicating if removed successfuly or not
     */
    public boolean removePair( Card first,
                               Card second )
        {

        if ( first.equals( second ) )
            {
            this.hand.removeCard( first ) ;
            this.hand.removeCard( second ) ;
            return true ;

            }

        return false ;

        }
    
    /**
     * 
     * 
     */
    public void flipAll() 
        {
        this.hand.flipAll();
        }


    /**
     * check 'pile' for the occurence of a card.
     * 
     * @param target
     *     card we're looking for
     * 
     * @return null object or a reference to that card.
     */
    public Card searchPile( Card target )
        {
        if ( target == null )
            return null ;

        for ( Card c : this.hand )
            {
            if ( target.equals( c ) )
                return c ;

            }

        return null ;

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