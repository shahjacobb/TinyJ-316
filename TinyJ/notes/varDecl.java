/*
 * EBNF specification (prod) for varDecl's grammar:
 * <varDecl> ::== int <singleVarDecl> {, <singleVarDecl} ; | 
 * Scanner IDENTIFIER = new SCANNER '(' System . in ')' ;
 */

 private static void varDecl() throws SourceFileErrorException {

    // first print we're parsing this symbol for the tree idk
    TJ.output.printSymbol(NTvarDecl);

    // increment parse tree size
    TJ.output.incTreeDepth();


    // handle int variables declarations

    if (getCurrentToken() == INT)
    {
        // skip to next token which is identifier
        nextToken();
        singleVarDecl();
        while (getCurrentToken == COMMA)
        {
            nextToken();
            singleVarDecl();
        }
        accept(SEMICOLON);

        // deal with scanners objects now 

        if (getCurrentToken() == SCANNER)
        {
            nextToken() // advanced to next token and validate rest of string
            // now we to check if we get a proper identifier passed for the scanner object
            if (getCurrentToken == IDENT) {
                nextToken(); // we can just move on to the equality sign if the identifier for the scanner object is valid
            }
            else{
                throw new SourceFileErrorException("Not a valid Scanner identifier name.")
            }
            accept(BECOMES); // assignment / equals sign
            accept(NEW);
            accept(SCANNER);
            // open paranthesis
            accept(LPAREN);
            accept(SYSTEM);
            accept(DOT);
            accept(IN);
            accept(RPAREN);
            // close paranthesis
            // just need ending semi colon now;
            accept(SEMICOLON); 
            
        }
        else{
            throw new SourceFileErrorException("Not an int var or Scanner object");
        }

        TJ.output.decTreeDepth();



    }





}