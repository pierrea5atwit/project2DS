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
import edu.wit.scds.ds.lists.app.cards.Suit ;
import edu.wit.scds.ds.lists.app.piles.Deck ;
import edu.wit.scds.ds.lists.app.piles.DiscardPile ;
import edu.wit.scds.ds.lists.app.piles.Stock ;

import java.util.ArrayList ;
import java.util.InputMismatchException ;
import java.util.Scanner ;

/**
 * NOTE You must rename this class to whatever you game is called. If the name of the
 * game begins with a number, spell out the number (can't start a class name with a
 * digit).
 * <p>
 * This is the main driver for the game of YOUR GAME. It supports from 3-? players.
 * Players take turns using a simple character cell console interface.
 *
 * @author David M Rosenberg
 * @author Andrew Pierre
 *
 * @version 1.0 2025-03-27 Initial implementation
 * @version 1.1 2025-04-02 Old Maid implementation
 *
 * @since 1.1
 */
public class OldMaid
    {
    /*
     * constants
     */
    // NOTE these are samples

    private final static int DEFAULT_PLAYER_COUNT = 4 ;
    private final static int MINIMUM_PLAYER_COUNT = 3 ;
    private final static int MAXIMUM_PLAYER_COUNT = 6 ;
    private final static int CARD_COUNT = 53 ;

    /*
     * data fields
     */

    // TODO add/remove/change data fields as you see fit
    // TODO this won't compile until the constructor sets the final data fields

    private final ArrayList<Player> players ;
    private int numberOfPlayers ;
    private Deck deck ;
    private Stock stock ;
    private DiscardPile discarded ; 

    private final Scanner scanner ;

    // flag to indicate to game, etc. whether execution should continue or get out
    private boolean running = true ;

    /*
     * constructors
     */

    /**
     * set up the game instance
     *
     * @param input
     *     used for player interactions
     *
     * @since 1.0
     */
    private OldMaid()
        {

        this.scanner = new Scanner( System.in ) ;
        this.players = new ArrayList<>() ;
        // TODO implement this

        }   // end constructor

    /*
     * game driver
     */


    /**
     * This is the top-level driver for the game of YOUR GAME.
     *
     * @param args
     *     -unused-
     *
     * @since 1.0
     */
    public static void main( final String[] args )
        {

        // TODO this is a sample to get you started - feel free to use, modify,
        // delete...

        final OldMaid exampleGame = new OldMaid() ;

        exampleGame.setup() ;

        while ( exampleGame.running )
            {
            exampleGame.run() ;

            if ( !exampleGame.running )
                {
                exampleGame.tearDown() ;

                return ;

                }

            exampleGame.summary() ;

            final String playAgain = exampleGame.promptForLine( "%nplay again?" ) ;

            if ( Character.toLowerCase( playAgain.charAt( 0 ) ) != 'y' )
                {
                exampleGame.running = false ;

                exampleGame.tearDown() ;

                return ;

                }

            exampleGame.reset() ;

            }

        exampleGame.tearDown() ;

        }   // end main()

    /*
     * operational methods
     */


    /**
     * prepare the game to run again
     *
     * @since 1.0
     */
    private void reset()
        {

        // TODO implement this
        setup() ;

        }   // end reset()


    /**
     * primary driver for the game
     *
     * @since 1.0
     */
    private void run()
        {

        // TODO implement this

        // introduce game
        System.out.printf( "%nThe game’s objective is to avoid being the player left with a Joker card.%n" +
                           "Each person’s hand is narrowed down by removing all numeric pairs and dealing one " +
                           "card to each other [There should be 51 total cards in use, as one joker is " +
                           "discarded by default].%nPlayer 1: %s, will be the dealer. %n%nAfter removing each pair you have, " +
                           "every player will put their hand face down, shuffle, and give away a random card to their right.%n" +
                           "This goes until only one player is left with a card and loses the game! Have fun.%n%n",
                           this.players.get( 0 ).name ) ;

        Player dealer = this.players.get( 0 ) ;
        this.setup() ;

        // deal initial hands



//        System.out.print( "Would the dealer like to begin? " ) ;
//        String response = "" ;
//
//        while ( !"y".equals( response ) && this.scanner.hasNextLine() )
//            {
//            response = this.scanner.nextLine() ;
//
//            }

        System.out.println( "\nMoving cards from deck to stock...\n" ) ;

        this.stock.transferFromPile( this.deck ) ;

        System.out.printf( "%n%s distributes cards from the stock. ", dealer.name ) ;

        //Passing cards around 
        for ( int i = 0 ; i < CARD_COUNT ; i++ )
            {

            int playerNum = i % this.numberOfPlayers ;
            dealer.dealtACard( this.stock.removeTopCard() ) ;

            if ( playerNum != 0 )
                dealer.giveCardToPlayer( this.players.get( playerNum ) ) ;

            }

        // Players remove their pairs
        System.out.println( "Now it's time to clear your pairs! " ) ;
        
        Player currentPlayer = dealer ; 
        for ( int i = 0 ; i < this.numberOfPlayers ; i++ )
            {
            
            System.out.printf( "Player %d reveals their hand. %n%s%nName a card to remove, Type '?' for help, or 'q' to quit.%n", (i+1), (currentPlayer.revealHand()) ) ;
            
            Card cardToPair = promptForCard( "Card:  " );
            // TODO: Write a method in either Player or Card class that determines if the card
            // that the user enters can be taken out from their hand. 
            Card paired = currentPlayer.hasPair(cardToPair) ;
            if (paired != null) 
                {
                currentPlayer.removePair( cardToPair, paired );
                this.discarded.addPair( cardToPair, paired );
                }
            
            for( Player p : this.players) 
                {
                
                //was thinking we could use a for-each loop for each players turn?
                //here the player is ask if their hand contains any pairs using hasPair( targetCard )
                }
            
                // If yes, send those cards to discard pile and 'loop' until user asks to quit
                // Otherwise, print a message or something that tells them to choose again.
            
            }

        // NOTE this prompt provides directions which the promptForCard() method uses

        // take turns playing

        // when end, set this.running false
        }   // end run()


    /**
     * prepare to play the game
     *
     * @since 1.0
     */
    private void setup()
        {

        // NOTE this is a piece of my setup() to give you some ideas about how to
        // implement the rest

        // find out how many players
        this.numberOfPlayers = DEFAULT_PLAYER_COUNT ;
        


        if ( MINIMUM_PLAYER_COUNT < MAXIMUM_PLAYER_COUNT )
            {

            do
                {
                this.numberOfPlayers = promptForInt( "\nHow many players (minimum %,d, maximum %,d, -1 to quit)?",
                                                     MINIMUM_PLAYER_COUNT,
                                                     MAXIMUM_PLAYER_COUNT ) ;

                if ( this.numberOfPlayers == -1 )
                    {
                    this.running = false ;

                    return ;

                    }

                }
            while ( ( this.numberOfPlayers < MINIMUM_PLAYER_COUNT ) ||
                    ( this.numberOfPlayers > MAXIMUM_PLAYER_COUNT ) ) ;

            }

        // create the players
        for ( int i = 1 ; i <= this.numberOfPlayers ; i++ )
            {
            String playerName ;

            do
                {
                playerName = promptForLine( String.format( "%nWhat is the name of player %,d?",
                                                           i ) ) ;

                }
            while ( "".equals( playerName ) ) ;

            this.players.add( new Player( playerName ) ) ;

            }
        this.deck = new Deck( 1 ) ;
        this.deck.shuffle() ;
        this.stock = new Stock() ;
        DiscardPile discarded = new DiscardPile(); 
        

        // TODO implement this

        }   // end setup()


    /**
     * displays the results of playing the game
     *
     * @since 1.0
     */
    @SuppressWarnings( "static-method" )
    private void summary()
        {
// TODO: Implement this

        return ;

        }   // end summary()


    /**
     * finished running the game
     *
     * @since 1.0
     */
    private void tearDown()
        {

        // NOTE this is my implementation - same as above - use or not - your choice

        // release most resources
        reset() ;

        this.players.clear() ;

        System.out.printf( "%n%nThank you for playing.%n" ) ;

        }   // end tearDown()

    /*
     * utility methods
     */

    // NOTE you might find these utility methods useful for console I/O


    /**
     * displays a formatted prompt
     *
     * @param prompt
     *     the prompt with optional formatting specifiers
     * @param arguments
     *     argument(s) used by the formatting specifiers
     *
     * @since 1.0
     */
    private static void displayPrompt( final String prompt,
                                       final Object... arguments )
        {

        System.out.printf( "%s ", String.format( prompt, arguments ) ) ;

        }   // end displayPrompt()


    /**
     * prompts the user for a card by specifying suit and rank
     *
     * @param prompt
     *     the prompt with optional formatting specifiers
     * @param arguments
     *     argument(s) used by the formatting specifiers
     *
     * @return a card as specified by the user
     *     <p>
     *     Note: this card should only be used for lookups/comparisons, not added to
     *     the current set of playing cards, though it's possible a game might allow
     *     a user to create cards
     *
     * @since 1.0
     */
    private Card promptForCard( final String prompt,
                                final Object... arguments )
        {

        Suit suit = null ;
        Rank rank = null ;

        String input ;

        displayPrompt( prompt, arguments ) ;

        input = null ;

        while ( ( ( input == null ) || ( rank == null ) || ( suit == null ) ) &&
                this.scanner.hasNext() )
            {
            input = this.scanner.next().replaceAll( "\\s+", "" ).toUpperCase() ;

            if ( input.length() == 0 )
                {
                continue ;

                }

            if ( input.length() > 0 )
                {

                if ( ".".equals( input ) )
                    {
                    this.running = false ;

                    return null ;

                    }

                if ( "?".equals( input ) )
                    {
                    Rank.displayHelp() ;
                    Suit.displayHelp() ;

                    continue ;

                    }

                if ( "R".equals( input ) )
                    {
                    rank = Rank.JOKER ;
                    suit = Suit.NA ;

                    break ;

                    }
                if ("q".equals( input.toLowerCase() ))
                    {
                    return null;
                    }
                }

            if ( input.length() > 2 )
                {
                System.out.printf( "%nplease try again: " ) ;

                input = null ;

                continue ;

                }

            // assertion: input has 2 characters

            final String rankElement = input.substring( 0, 1 ) ;
            final String suitElement = input.substring( 1, 2 ) ;

            if ( ".".equals( rankElement ) || ".".equals( suitElement ) )
                {
                this.running = false ;

                return null ;

                }

            // either or both might return null
            rank = Rank.interpretDescription( rankElement ) ;
            suit = Suit.interpretDescription( suitElement ) ;

            }

        return new Card( rank, suit ) ;

        }   // end promptForCard()


    /**
     * prompts the user for an integer value
     *
     * @param prompt
     *     the prompt with optional formatting specifiers
     * @param arguments
     *     argument(s) used by the formatting specifiers
     *
     * @return the integer value as specified by the user
     *
     * @throws InputMismatchException
     *     if the user enters any characters which can't be interpreted as valid
     *     decimal digits
     *
     * @since 1.0
     */
    private int promptForInt( final String prompt,
                              final Object... arguments )
        throws InputMismatchException
        {

        displayPrompt( prompt, arguments ) ;

        while ( this.scanner.hasNext() && !this.scanner.hasNextInt() )
            {
            this.scanner.next() ;    // skip the noise

            }

        return this.scanner.nextInt() ;

        }   // end promptForInt()


    /**
     * prompts the user for a line of text
     *
     * @param prompt
     *     the prompt with optional formatting specifiers
     * @param arguments
     *     argument(s) used by the formatting specifiers
     *
     * @return the line of text as specified by the user
     *
     * @since 1.0
     */
    private String promptForLine( final String prompt,
                                  final Object... arguments )
        {

        String response = "" ;

        displayPrompt( prompt, arguments ) ;

        while ( "".equals( response ) && this.scanner.hasNextLine() )
            {
            response = this.scanner.nextLine() ;

            }

        return response ;

        }   // end promptForLine()

    }   // end class OldMaid
