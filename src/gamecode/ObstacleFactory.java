package gamecode;

public class ObstacleFactory {
    //Design pattern: FACTORY
    public Obstacle createObstacle(int type) {
        switch (type) {
            case 1:
                return new DiamondObstacle(1, 1, 1, 1);
            case 2:
                return new SquareObstacle(1, 1, 1, 1);
            case 0:
                return new CircleObstacle(1, 1, 1, 1);
			case 3:
				return new CrossObstacle(1,1,1,1);
			default:
				return new CircleObstacle(1, 1, 1, 1);
		}
    }
}
