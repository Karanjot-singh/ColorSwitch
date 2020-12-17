package gamecode;

public class ObstacleFactory {
    //Design pattern: FACTORY
    public Obstacle createObstacle(int type, boolean scaleAnimate) {
        switch (type) {
            case 1:
                return createDiamond(scaleAnimate);

            case 2:
                return createSquare(scaleAnimate);

            case 3:
                return createCross();

            case 0:
            default:
                return createCircle(scaleAnimate);
        }
    }

    //Design pattern: FACADE
    public DiamondObstacle createDiamond(boolean scaleAnimate) {
        return new DiamondObstacle(1, 1, 1, 1, 1, scaleAnimate);
    }

    public SquareObstacle createSquare(boolean scaleAnimate) {
        return new SquareObstacle(1, 1, 1, 1, 1, scaleAnimate);
    }

    public CrossObstacle createCross() {
        return new CrossObstacle(1, 1, 1, 1, 1);
    }

    public CircleObstacle createCircle(boolean scaleAnimate) {
        return new CircleObstacle(1, 1, 1, 1, 1, scaleAnimate);
    }
}
