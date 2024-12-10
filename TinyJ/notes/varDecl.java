/* 
 * EBNF for varDecl - it just handles parsing of variable declaration 
 * varDecl is NOT the starting non-terminal (<program> is)
 * (whether or not you declared it properly) 
 * 
 * <varDecl> ::= (singleVarDecl) {, singleVarDecl} |
 * Scanner IDENTIFIER ::= new Scanner '(' System . in ')' ;  
 * */

 private static void varDecl() throws SourceFileErrorException{

    // increases tree depth of parse tree each time
    TJ.output.printSymbol(NTvarDecl);
    TJ.output.incTreeDepth();

    // corresponding to the first part for var declarations - if after tokenization we get an int,
    // we call call nextToken and call singleVarDec to create a single variable declaration
    if (getCurrentToken() == int) {
        nextToken();
        singleVarDecl();
        // then afterwards, we need to check if there's more variable declarations, 
        // so we check for commas
        while (getCurrentToken() == comma)
        {   // same thing here, call nextToken and create another single variable
            nextToken();
            singleVarDecl();
        }
        // to finish the statement, we need a semi colon:
        accept(SEIMICOLON);

    }

    else if (getCurrentToken() == Scanner)
    {
        nextToken();
        // IDENT == IDENTIFIER
        if (getCurrentToken() == IDENT)
        {
            accept(IDENT);

        }
        else throw new SourceFileExceptionError("expected name of scanner");
        // just like we accepted a comma for eac 
        accept(BECOMES); // idk wtf this is
        accept(NEW); // new keyword
        accept(SCANNER); // scanner class
        accept(LPAREN); // left paranthesis
        accept(SYSTEM); // System class for std in
        accept(DOT); . // dot in System.in
        accept(IN); // input in system.in
        accept(RPAREN); // right paranthesis
        accept(SEIMICOLON); // to end statement like before

        
    }

    // otherwise, if getCurrentToken() doesn't get INT or Scanner, we throw a SourceFileErrorException
    else{
        throw new SourceFileErrorException("Need an int or scanner.")
    }

    // decreases tree depth here for some reason
    TJ.out.decTreeDepth();
    
 }

// Questions 
 /* 
 what's the difference between getCurrentToken() and nextToken()?
 when do we use either method and when?
 why do we increment tree depth in beginning?
 what is sourcefileexception error?
 what does accept(keyword/token) do?
 why do all the accepts for the scanner class not go in the if(getcurrentToken == SCANNER) block?
 */ 
  

