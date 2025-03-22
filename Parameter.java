import java.util.*;

class Parameter {
    String name;
    Parameter p;

    // Parses a parameter list, assigning names and handling commas if multiple parameters exist
    void parse() {
       
        Parser.expectedToken(Core.ID);
        name = Parser.scanner.getId();
        Parser.scanner.nextToken();

        if (Parser.scanner.currentToken() == Core.COMMA) {
            Parser.scanner.nextToken();
            p = new Parameter(); 
            p.parse();
        }
    }

    // Prints the parameter list, adding commas between multiple parameters
    void print() {
        System.out.print(name);
        if (p != null) {
            System.out.print(", ");
            p.print();
        }
    }

    // Executes the parameter list by creating an ArrayList of parameter names
    ArrayList<String> execute() {
        ArrayList<String> list;
        if (p != null) {
            list = p.execute();
        } else {
            list = new ArrayList<>();
        }
        list.add(name);
        return list;
    }
    
}

