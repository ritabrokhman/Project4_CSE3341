**Project 4 - Procedure Calls**

Rita Brokhman

Files Submitted:
1. Main.java: Provided by Tim Carpenter. Starts the program, sets up the scanner, runs parsing, and prints the results.
2. Scanner.java: Provided by Tim Carpenter. Breaks the input file into tokens for the parser.
3. Core.java: Provided by Tim Carpenter. Defines all the possible token types.
4. Parser.java: Provided by Tim Carpenter. Parses the tokens and checks for errors.
5. Procedure.java: Provided by Tim Carpenter. Parses a procedure to ensure it follows the correct structure.
6. DeclSeq.java: Provided by Tim Carpenter. Handles multiple variable declarations.
7. Decl.java: Provided by Tim Carpenter. Handles a single variable declaration.
8. DeclObj.java: Provided by Tim Carpenter. Handles object declarations.
9. DeclInteger.java: Provided by Tim Carpenter. Handles integer declarations.
10. StmtSeq.java: Provided by Tim Carpenter. Parses multiple statements.
11. Stmt.java: Provided by Tim Carpenter. Figures out what kind of statement it is and processes it.
12. Assign.java: Provided by Tim Carpenter. Handles assignments (e.g., x = 5;).
13. Print.java: Provided by Tim Carpenter. Handles print statements.
14. Read.java: Provided by Tim Carpenter. Handles read statements.
15. If.java: Provided by Tim Carpenter. Handles if and if-else statements.
16. Loop.java: Provided by Tim Carpenter. Handles for-loops.
17. Cond.java: Provided by Tim Carpenter. Handles conditions used in if and loop statements.
18. Cmpr.java: Provided by Tim Carpenter. Handles comparison expressions (e.g., x < y).
19. Expr.java: Provided by Tim Carpenter. Handles math expressions.
20. Term.java: Provided by Tim Carpenter. Handles multiplication and division.
21. Factor.java: Provided by Tim Carpenter. Handles individual values in expressions.
22. Memory.java: Provided by Tim Carpenter. Manages variable storage, scoping, object memory, and assignment operations.
23. Executor.java: Provided by Tim Carpenter. Executes parsed statements and expressions, reads input, and manages memory during execution.
24. Id.java: Provided by Tim Carpenter. Represents an identifier (variable name) and provides functionality to retrieve its value.
25. Function.java: Parses and executes user-defined procedures. Ensures semantic checks for duplicate procedure names. Supports recursion and manages parameter passing. Properly handles procedures with and without parameters.
26. Call.java: Handles procedure calls, passing arguments, and managing execution. Ensures that the correct procedure is called. Handles recursive function calls and scope management.
27. Parameter.java: Parses and stores formal parameters for procedures. Ensures valid parameter syntax and avoids duplicate parameter names.
28. tester.sh: Provided by Tim Carpenter. Runs multiple test cases automatically.
29. Correct Folder: Provided by Tim Carpenter. Contains valid Core programs and their expected outputs.
30. Error Folder: Provided by Tim Carpenter. Contains Core programs designed to test error handling.

Special Features:
1.  The interpreter implements a call stack that pushes and pops function frames during function calls. This is achieved using a Stack data structure, ensuring that the function's local variables are properly scoped.
2.  The interpreter includes checks for undeclared functions, duplicate function definitions, and duplicate parameters within functions, with appropriate error messages displayed.

Interpreter Design:
1. The Call Stack is implemented using a stack data structure, where each function call creates a new "frame" that holds local variables and parameters. Each time a function is called, a new frame is pushed onto the stack. When the function execution is completed, the frame is popped, ending the function's scope.
2. The function name, parameters, and the function body (StmtSeq) are parsed and stored in the Function class. When a function is called, the execute() method is responsible for checking if the function exists in the map and pushing the function’s execution context onto the stack.

Testing:
The interpreter was tested using tester.sh, which runs all test cases in Correct/ and Error/.

Known Bugs:
None