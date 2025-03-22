class Call implements Stmt {
	String name;
	Parameter cp;
	
	public void parse() {
		// Parse BEGIN
		Parser.expectedToken(Core.BEGIN);
		Parser.scanner.nextToken();
		// Parse ID
		Parser.expectedToken(Core.ID);
		name = Parser.scanner.getId();
		Parser.scanner.nextToken();
		// Parse LPAREN
		Parser.expectedToken(Core.LPAREN);
		Parser.scanner.nextToken();
		cp = new Parameter();
		cp.parse();
		// Parse RPAREN
		Parser.expectedToken(Core.RPAREN);
		Parser.scanner.nextToken();
		// Parse SEMICOLON
		Parser.expectedToken(Core.SEMICOLON);
		Parser.scanner.nextToken();
	}
	
	public void print(int indent) {
		System.out.print("begin " + name + "(");
		cp.print();
		System.out.print(");");
	}
	
	public void execute() {
		
		if (!Memory.map.containsKey(name)) {
			System.out.println("ERROR: " + name + ": UNDECLARED FUNCTION");
			System.exit(1);
		}
		Memory.pushFrame(name, cp);
		Memory.popFrame();
		
	}
}

