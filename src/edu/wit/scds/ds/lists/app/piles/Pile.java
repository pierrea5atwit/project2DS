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
import edu.wit.scds.ds.lists.app.cards.Rank ;
import edu.wit.scds.ds.lists.app.cards.Suit ;

import static edu.wit.scds.ds.lists.app.cards.Card.* ;
import edu.wit.scds.ds.lists.app.utilities.NoCardsException ;

import java.util.Collections ;
import java.util.Iterator ;
import java.util.LinkedList ;
import java.util.List ;
import java.util.ListIterator ;

/**
 * Representation of a pile of card
 * <p>
 * the top card is at position 0
 *
 * @author Dave Rosenberg
 *
 * @version 0.1 2025-03-31 skeleton for assignment
 * 
 * @author Mina // TODO
 * 
 * @version 1.0 2025-03-31 Initial implementation per assignment
 */
public abstract class Pile implements Iterable<Card>
    {

    /*
     * data fields
     */

    /**
     * the list of cards where the top is in position 0 and the bottom is the highest
     * position
     */
    protected List<Card> cards ;

    /**
     * flag indicating whether cards in this pile should be face up or face down by
     * default
     */
    protected boolean defaultFaceDown ;

    // NOTE I recommend keeping these data fields - add more if you need them

    /*
     * constructors
     */

    /**
     * Initialize the pile with cards placed face down by default
     *
     * @since 0.1
     */
    protected Pile()
        {

        this( FACE_DOWN ) ;

        }	// end no-arg constructor


    /**
     * Initialize the pile with cards placed face up/down as specified by default
     * 
     * @param initialDefaultFaceDown
     *     specify whether cards will be face up or down by default
     *
     * @since 0.1
     */
    protected Pile( final boolean initialDefaultFaceDown )
        {

        this.cards = new LinkedList<>() ;

        this.defaultFaceDown = initialDefaultFaceDown ;

        }	// end 1-arg constructor

    /*
     * public methods
     */

    // TODO implement this

    // NOTE I left a couple of methods for you...
    

    /**
     * Retrieve the current number of cards in the pile
     *
     * @return the current number of cards in the pile
     * 
     * @since 0.1
     */
    public int cardCount()
        {

        return this.cards.size() ;

        }  // end cardCount()


    /**
     * remove all cards from the pile
     * 
     * @since 0.1
     */
    public void clear()
        {

        this.cards.clear() ;

        }   // end clear()


    /**
     * flip all cards in the pile - if a card was face down, turn it face up, and
     * vice versa
     * 
     * @since 0.1
     */
    public void flipAll()
        {

        for ( Card aCard : this.cards )
            {
            aCard.flip() ;

            }

        }   // end flipAll()


    /**
     * Retrieve the top card from the pile
     * <p>
     * Caution: the returned card should only be in one pile at any time
     * <p>
     * Note: there is no corresponding convenience method to retrieve the bottom card
     * since that's usually cheating and we can't condone that 8~)
     *
     * @return the top card
     * 
     * @throws NoCardsException
     *     if the pile is empty
     * 
     * @since 0.1
     */
    public Card getTopCard() throws NoCardsException
        {

        if ( isEmpty() )
            {
            throw new NoCardsException() ;

            }

        // assertion: there is at least one card in the pile

        return this.cards.getFirst() ;

        }  // end getTopCard()


    /**
     * removes the 'top card' from a deck or other pile
     * 
     * @return the top card in stack
     * 
     * @throws NoCardsException
     */
    public Card removeTopCard() throws NoCardsException
        {
        Card top = getTopCard() ;
        this.cards.remove( 0 ) ;
        return top ;

        }


    /**
     * Method to take ALL cards from one pile to another
     * 
     * @param stack the 'other' pile we're pulling cards from
     */
    public void transferFromPile( Pile stack )
        {
        while ( !stack.isEmpty() )
            {
            this.cards.add( stack.removeTopCard() ) ;

            }

        }


    /**
     * Report if the pile is empty (contains no cards)
     * 
     * @return true if there are no cards in the pile; false otherwise
     * 
     * @since 1.0
     */
    public boolean isEmpty()
        {

        return this.cards.isEmpty() ;

        }   // end isEmpty()

    // NOTE Pile is Iterable - I gave you the full implementation


    @Override
    public Iterator<Card> iterator()
        {

        return new CardIterator() ;

        }   // end iterator()


    /**
     * creates a list iterator for this pile
     * 
     * @return a new {@code ListIterator}
     *
     * @since 3.0
     */
    public ListIterator<Card> listIterator()
        {

        return new CardIterator() ;

        }   // end listIterator()


    /**
     * turn all cards in the pile face up
     * 
     * @since 1.0
     */
    public void revealAll()
        {

        for ( Card aCard : this.cards )
            {
            aCard.reveal() ;

            }

        }   // end revealAll()


    /**
     * Randomize (shuffle) the cards in the deck
     * 
     * @since 1.0
     */
    public void shuffle()
        {

        Collections.shuffle( this.cards ) ;

        }   // end shuffle()


    /**
     * Reorder (sort) the cards in the deck
     * 
     * @since 1.0
     */
    public void sort()
        {

        Collections.sort( this.cards ) ;

        }   // end sort()


    @Override
    public String toString()
        {

        return this.cards.toString() ;

        }	// end toString()

    /*
     * utility methods
     */

    /*
     * utility classes
     */

    /**
     * enable iteration over all cards in the pile
     * 
     * @author David M Rosenberg
     *
     * @version 1.0 2025-03-29 Initial implementation
     * 
     * @since 1.0
     */
    private class CardIterator implements ListIterator<Card>
        {

        private final ListIterator<Card> cardIterator ;

        /**
         * @since 1.0
         */
        private CardIterator()
            {

            this.cardIterator = Pile.this.cards.listIterator() ;

            }   // end constructor


        @Override
        public boolean hasNext()
            {

            return this.cardIterator.hasNext() ;

            }   // end hasNext()


        @Override
        public Card next()
            {

            return this.cardIterator.next() ;

            }   // end next()


        @Override
        public boolean hasPrevious()
            {
            return this.cardIterator.hasPrevious() ;

            }   // end hasPrevious()


        @Override
        public Card previous()
            {
            return this.cardIterator.previous() ;

            }   // end previous()


        @Override
        public int nextIndex()
            {

            return this.cardIterator.nextIndex() ;

            }   // end nextIndex()


        @Override
        public int previousIndex()
            {

            return this.cardIterator.previousIndex() ;

            }   // end previousIndex()


        @Override
        public void remove()
            {

            this.cardIterator.remove() ;

            }   // end remove()


        @Override
        public void set( Card replacementCard )
            {

            this.cardIterator.set( replacementCard ) ;

            }   // end set()


        @Override
        public void add( Card newCard )
            {

            this.cardIterator.add( newCard ) ;

            }   // end add()

        }   // end inner class CardIterator

    /*
     * testing/debugging
     */

    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     * 
     * @since 1.0
     */
    public static void main( final String[] args )
        {
        // TODO Auto-generated method stub

        }   // end main()

    }	// end class Pile