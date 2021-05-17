build:
	javac Main.java
	javac WazeMap.java
	javac MapGraph.java
	javac Dijkstra.java
	javac PriorityIntersectionSelector.java
	javac Street.java
	javac Vehicle.java
	javac Bicycle.java
	javac Car.java
	javac Motorcycle.java
	javac Truck.java

run:
	java Main

clean:
	$(RM) $*.class