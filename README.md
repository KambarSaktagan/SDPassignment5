# Navigation Route Planner (Strategy Pattern)

A Java (JDK 17) implementation of the Strategy design pattern for planning routes using interchangeable transport strategies (`CarStrategy`, `WalkStrategy`, `CycleStrategy`, `PublicTransitStrategy`).

## Project Structure

```text
src/navigation/
├── Main.java                 # Client (runtime strategy switching demo)
├── context/Navigator.java    # Context class
├── model/Route.java          # Route data model
└── strategy/                 # RouteStrategy interface & implementations
```

## How to Build and Run

### In IntelliJ IDEA
1. Open the project in IntelliJ IDEA (ensure Project SDK is set to **JDK 17**).
2. Run `src/navigation/Main.java`.

### Via Terminal
```bash
javac -d out src/navigation/model/*.java src/navigation/strategy/*.java src/navigation/context/*.java src/navigation/Main.java
java -cp out navigation.Main
```

