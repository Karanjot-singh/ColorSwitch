package gamecode;

import java.util.Random;

public class ObstacleFactory {
    //Design pattern: FACTORY
    public Obstacle createObstacle(int type, boolean scaleAnimate) {
        switch (type) {
            case 1:
                return new DiamondObstacle(1, 1, 1, 1,1, scaleAnimate);

			case 2:
                return new SquareObstacle(1, 1, 1, 1,1, scaleAnimate);

			case 3:
                return new CrossObstacle(1,1,1,1,1);

			case 0:
			default:
				return new CircleObstacle(1, 1, 1, 1,1, scaleAnimate );
		}
    }
}
