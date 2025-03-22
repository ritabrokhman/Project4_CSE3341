class StmtSeq {
    Stmt stmt;
    StmtSeq ss;

    void parse() {
        // Check for invalid starting token
        // Extra error checking to make sure statement is valid
        if (Parser.scanner.currentToken() == Core.END) {
            System.out.println("ERROR: Procedure body missing. Showing: " + Parser.scanner.currentToken());
            System.exit(1);
        }

        if (Parser.scanner.currentToken() == Core.ID) {
            stmt = new Assign();  
        } else if (Parser.scanner.currentToken() == Core.PRINT) {
            stmt = new Print();   
        } else if (Parser.scanner.currentToken() == Core.IF) {
            stmt = new If();  
        } else if (Parser.scanner.currentToken() == Core.FOR) {
            stmt = new Loop();    
        } else if (Parser.scanner.currentToken() == Core.INTEGER || Parser.scanner.currentToken() == Core.OBJECT) {
            stmt = new Decl();  
        } else if (Parser.scanner.currentToken() == Core.BEGIN) {
            stmt = new Call(); 
        } else if (Parser.scanner.currentToken() == Core.READ) {
            stmt = new Read(); 
        } else {
            // Catch any unexpected token
            System.out.println("ERROR: Bad start to statement: " + Parser.scanner.currentToken());
            System.exit(1);
        }
        stmt.parse();
        // If the current token is neither END nor ELSE, create and parse a new statement sequence
        if (!(Parser.scanner.currentToken() == Core.END || Parser.scanner.currentToken() == Core.ELSE)) {
            ss = new StmtSeq();
            ss.parse();
        }
        
    }

    void print(int indent) {
        stmt.print(indent); 
        if (ss != null) ss.print(indent); 
    }

    void execute() {
        stmt.execute(); 
        if (ss != null) ss.execute(); 
    }
}
