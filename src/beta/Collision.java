//public void NewCheckStar() {
//        Shape orb = (Shape) playerOrb.getOrbGroup().getChildren().get(0);
//        Shape starShape = orb; //dummy
////        System.out.println("Orb: "+orb.getStroke()+" "+orb.getFill());
//        Iterator<Node> elements = list.iterator();
//        while(elements.hasNext()){
//        // Obstacle stackpane
//        if (elements.getClass().getName().equals("javafx.scene.layout.StackPane")) {
//        StackPane tempPane = (StackPane) elements;
//        starShape = (Shape) tempPane.getChildren().get(1);
//        Shape intersect = Shape.intersect(orb, starShape);
//        if (intersect.getBoundsInLocal().getWidth() != -1) {
//        System.out.println("Star ");
//        tempPane.getChildren().remove(1);
//        }
//        }
//        //Collision with ColorSwitcher
//        else if(elements.getClass().getName().equals("javafx.scene.layout.Group")){
//        Group elementGroup = (Group)elements;
//        for (Node iterator : elementGroup.getChildren()) {
//        Shape shape = (Shape) iterator;
//        Shape intersect = Shape.intersect(orb, shape);
//        if (intersect.getBoundsInLocal().getWidth() != -1) {
//        System.out.println("cs");
//        list.remove(elements);
//        }
//        }
//
//        }
//        }
//        }