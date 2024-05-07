# Application Execution Guide

To run the application with a Java file located at `filepath`, follow the instructions below:

```bash
java -jar out/artifacts/task_parser_jar/task_parser.jar filepath
```

You can also run a test version with `filepath` set to `Test.java`.

# State Class Overview

The `State` class describes the main entity - "state". A state represents the current configuration of our analyzer (parser), which determines what data we store, what actions we take, and which state we transition to next.

## States:
- **Empty**: Reads the current character.
- **IsMethod**: Checks if the current line is a method declaration.
- **ReadMethod**: Reads code inside a method.
- **AddMethod**: Adds method data to the associated instance of `CodeAnalyzer`.
- **End**: Final state, parsing ends after reaching this state.

## Transitions:
- **Empty** transitions to **IsMethod** or **End**.
- **IsMethod** transitions to **Empty** or **ReadMethod**.
- **ReadMethod** transitions to **AddMethod**.
- **AddMethod** transitions to **Empty**.

At the beginning of the program, an instance of the `CodeAnalyzer` class is created. This class defines method complexity metrics, camelCase validation, and global logic for state changes. It also stores method data (in our case, complexity and camelCase validation). We have the current `State`, perform actions corresponding to its type, determine which state to transition to next, and transition until reaching the final state.

