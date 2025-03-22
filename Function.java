import java.util.*;
class Function {
    String name;
    Parameter p;
    StmtSeq ss;

    void parse() {
        // Parse PROCEDURE
        Parser.expectedToken(Core.PROCEDURE);
        Parser.scanner.nextToken();
        // Parse ID
        Parser.expectedToken(Core.ID);
        name = Parser.scanner.getId();
        Parser.scanner.nextToken();
        // Parse LPAREN
        Parser.expectedToken(Core.LPAREN);
        Parser.scanner.nextToken();
        // Parse OBJECT
        Parser.expectedToken(Core.OBJECT);
        Parser.scanner.nextToken();
        p = new Parameter();
        p.parse(); 
        // Parse RPAREN
        Parser.expectedToken(Core.RPAREN);
        Parser.scanner.nextToken();
        // Parse IS
        Parser.expectedToken(Core.IS);
        Parser.scanner.nextToken();
        ss = new StmtSeq();
        ss.parse();
        // Parse END
        Parser.expectedToken(Core.END);
        Parser.scanner.nextToken();
    }

    void print(int indent) {
        System.out.print("procedure " + name + " (object ");
        p.print();
        System.out.println(") is ");
        ss.print(indent + 1);
        System.out.println("end");
        
    }

    void execute() {
        if (Memory.map.containsKey(name)) {
            System.out.println("ERROR: " + name + ": DUPLICATE FUNCTION");
            System.exit(1);
        }

        Memory.map.put(name, this);

        // Check for duplicate formal parameters
        List<String> list = p.execute();
        HashSet<String> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            System.out.println("ERROR: Function " + name + ": DUPLICATE PARAMETERS");
            System.exit(1);
        }
    }
}

