/* This is not a valid Java file */

// GridWorld Stuff

// Part 2 Exercises

// Question 1

public void act() {
	if (steps < sideLength && canMove()) {
		move();
		steps++;
	} else {
		turn(); // changed from two turns to one turn
		steps = 0;
	}
}

// It now moves like an octagon due to 45 degree turns instead of 90 that made it a square

// Question 2

public void act() {
	if (steps < sideLength && canMove()) {
		move();
		steps++;
	} else {
		turn(); 
		turn();
		steps = 0;
		sideLength++; // just add this line here to adjust side length when it turns to make a spiral
	}
}

// Question 3 

public class ZBug extends Bug {
	private int steps;
	private int length;
	private int segment;

	public ZBug (int length) {
		// constructor
		setDirection(Location.EAST); // has to be east at start
		steps = 0;
		this.length = length;
		segment = 1;


	}

	public void act() {
		if (segment <= 3 && steps < length) {
			if (canMove()) {
				move();
				steps++;
			}
		} else if (segment == 1) {
			setDirection(Location.SOUTHWEST);
			steps = 0;
			segment++;
		} else if (segment == 2) {
			setDirection(Location.EAST);
			steps = 0;
			segment++;
		}
	}

}

// Problem 4

public class DancingBug extends Bug {
	private int[] turns;
	private int thisStep;

	public DancingBug(int[] turns) {
		this.turns = turns;
		thisStep = 0;

	}

	public void turn(int times) {
		for (int j = 1; j < times + 1; j++) {
			turn();
		}
	}

	public void act() {
		if (thisStep = turns.length) {
			thisStep = 0;
			turn(turns[thisStep]);
			thisStep++;
			super.act();
		}
	}
}

// Problem 5

// The BoxBugRunner must first instantiate a Box Bug object, then add it into the world.
// The location can be set or random. 

// Group Activity - GridWorld Part 3 

// Question 1

// Part A: We can make it turn.

// Part B: We can make it turn. 

// Part C: Turn.

// Part D: Remove the actor. 

// Part E: Remove the other jumper from the grid.

// Part F: Can a jumper jump over an actor? 

// Question 2

// Part A: Jumper extends Actor.

// Part B: The Bug class is similar to the Jumper class.

// Part C: There should be if we wish to override the Actor class's defaults. 

// Part D: act - The jumper's art behavior is different than that of Actor. 

// Part E: jump, which relies on canJump, and turn, which also relies on canJump. canJump returns a boolean.

// Part F: Test it against edges, jumping in normal environments, surrounded by rocks, flowers, other actors, and also surrounded by things two units away. 

// Question 3

// Implementation of Jumper

public class Jumper extends Actor {

	public Jumper (Color c) {
		setColor(JumperColor); 
		// Allows a different color to be used in place of the default Actor one.
	}

	public void act() {
		if (canJump()) {
			jump();
		} else {
			turn();
		}
	}

	// 45 degree turn to the right. 
	// Position remains the same.
	public void turn() {
		setDirection(getDirection() + Location.HALF_RIGHT);
	}


	public void jump() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return;
		}
		Location thisLoc = getLocation();
		Location nextLoc = thisLoc.getAdjacentLocation(getDirection());
		Location jumpTarget = nextLoc.getAdjacentLocation(getDirection());
		if (gr.isValid(jumpTarget)) {
			moveTo(jumpTarget);
		} else {
			removeSelfFromGrid();
		}
	}

	public boolean canJump() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return false;
		}

		Location thisLoc = getLocation();
		Location nextLoc = thisLoc.getAdjacentLocation(getDirection());
		if (!gr.isValid(nextLoc)) {
			return false;
		} 
		Actor neighbor = gr.get(next);
		if (!(neighbor == null) || (neighbor instanceof Rock) || (neighbor instanceof Flower)) { // neighbor check
			return false;
		}

		Location jumpDistance = nextLoc.getAdjacentLocation(getDirection());
		if (!gr.isValid(jumpTarget)) { // jump landing check
			return false;
		}

		Actor targetItem = gr.get(jumpTarget);
		boolean success = ((neighbor == null) || (neighbor instanceof Flower));
		return success; 
	}
}

// JumperRunner

public class JumperRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld(); 
		// just driver stuff
		world.add(new Jumper());
		world.add(new Flower()); // stuff to test: Flowers, Rocks, Bugs
		world.add(new Rock());
		world.add(new Bug());
		world.show();
	}
}

// Compared with the CollegeBoard solutions to ensure all needed checks were accounted for