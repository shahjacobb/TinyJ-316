/* 
 * EBNF for varDecl - it just handles parsing of variable declaration 
 * varDecl is NOT the starting non-terminal (<program> is)
 * (whether or not you declared it properly) 
 * 
 * // this non-terminal (production) is already defined (we have to implement singlevarDecl tho)
 * <varDecl> ::== (int <singleVarDecl>) {',' <singleVarDecl>} ; | SCANNER IDENTIFIER = new SCANNER '(' System . in ')' ;
 * 
 * 
 * */

 public static void varDecl() throws SourceFileErrorException {

    // increment size of parse tree - indicates we're building the parse tree
    TJ.output.incTreeDepth();

    // check if token is an int (no apostrophes for reserved word)
    if (getCurrentToken() == int)
    {
        // go to next token since we know it's an int
        nextToken();
        // make a call to a non-terminal <singleVarDecl> which handles creation of a variable
        singleVarDecl();
    }

    // but we can have more variable declarations, so we need to check for a comma

    while (getCurrentToken() == COMMA){
        nextToken();
        singleVarDecl(); // do until no more integer variables to be declared
    }
    // finish with semicolon
    accept(SEMICOLON);


    // now we check for the non terminal after the | - the SCANNER object
    if (getCurrentToken() == SCANNER)
    {
        // same as int, move to next token
        nextToken();
        // we accept the IDENTIFIER 
        accept(IDENT);
        else{ 
            throw new SourceFileErrorException('Where is the scanner name bro?'); // need the new when throwing exceptions
        }
        // then we complete the rest of the creation of the scanner object using accept statements
        accept(BECOMES); // equivalent to = this is important. remember that!
        accept(NEW);
        accept(SCANNER);
        accept(LPAREN); // left paranthesis
        // for system. in 
        accept(SYSTEM); 
        accept(DOT);
        accept(IN);
        accept(RPAREN); // right paranthesis
        accept(SEMICOLON);
    }

    else{
        throw new SourceFileErrorException('not an int or scanner');
    }

    // decrement size of parse tree
    TJ.output.decTreeDepth();
 }

 // Done!