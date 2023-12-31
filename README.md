# Yoink University Lift-Off Coding Puzzle

_Algorithmic elevator puzzles_

In this workshop, you will implement algorithms for routing elevators. The puzzle is divided into several levels, each of which gets progressively more difficult. Each level will give you a description of the rules of the algorithm, an empty implementation, and one or more test cases to validate your solution.

Start with `Level1.java` and implement the Operator. Once you have an implementation, you can run the program to see if your implementation is correct. Continue improving it until all the tests pass. Once they do, you can move on to the next level.

The input consists of a list of `Call`s which the elevator's passengers can make. A `Call` consists of a floor on which the passenger presses the call button, and the direction they push (`UP` or `DOWN`). For the sake of convenience, it also includes the floor that the passenger presses when inside the elevator, even though in reality, this information is not known yet when the passenger makes the call. Finally, the call has the timestamp when the passenger calls the elevator. This field is optional, and only becomes relevant in later levels.

The input also consists of the floor where the elevator starts (usually the ground floor, which is 0) and the number of floors in the building.

Every level includes a solution implementation in the class `SecretSolutions`, but is formatted as a sequence of unicode escape sequences. This is valid Java code, but of course quite unreadable, so it won't give away the answer!

The model classes have some convenience methods that you are encouraged to use, so it pays off to take a look at them. However, you should not modify these classes.

## Levels

These levels are currently implemented:

- In level 1, the elevator is very unintelligent and services each call sequentially.
- In level 2, the elevator becomes a little smarter: it picks up new passengers en route to its destination.
- In level 3, a time component is introduced to the system. Not every call is made at the same time, and it takes time to move from one floor to another.

Ideas for new levels:

- Consider maximum number of passengers that can be in the elevator at the same time
- Attempt to minimize transit time for each passenger
- Add energy efficiency concerns to the algorithm
- Have multiple elevators in the system that operate independently
- Have multiple elevators that coordinate with each other
- Handle peak times
- Handle the case when an elevator goes out of service
