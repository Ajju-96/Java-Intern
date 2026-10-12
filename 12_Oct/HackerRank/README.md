# Java HackerRank Practice

This repository contains three Java practice solutions, each in its own `.java` file. Each source file begins with the corresponding question and requirements in comments.

## Files

1. `ShapeAreaCalculator.java` — abstract class, inheritance, and method overriding.
2. `VehicleSpeedManager.java` — constructors, object methods, and updating vehicle speed.
3. `MediaPlayerRuntime.java` — `switch` statement and returning a message based on media type.

## How to compile and run

Install a JDK, open a terminal in this folder, then compile each file separately:

```bash
javac ShapeAreaCalculator.java
java ShapeAreaCalculator
```

```bash
javac VehicleSpeedManager.java
java VehicleSpeedManager
```

```bash
javac MediaPlayerRuntime.java
java MediaPlayerRuntime
```

## Sample inputs

### 1. Shape Area Calculator

```text
2
4
5
```

Sample output:

```text
Orange 12.57
Light Blue 20.00
```

Input order: circle radius, rectangle length, rectangle width.

### 2. Vehicle Speed Manager

```text
Honda
40
15
10
```

Sample output:

```text
Honda has started.
Speed after acceleration: 55
Speed after braking: 45
```

Input order: model, initial speed, acceleration increment, braking decrement.

### 3. Media Player

```text
Song
Imagine
```

Sample output:

```text
Playing song: Imagine
```

## Note about HackerRank

HackerRank sometimes supplies its own `Solution` class and asks you to complete only a method. These files are standalone Java programs for GitHub practice, so each has its own public class and matching filename. If submitting to HackerRank, keep its required class and method signatures unchanged and paste only the required implementation when instructed.
