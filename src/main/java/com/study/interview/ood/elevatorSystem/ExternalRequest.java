package com.study.interview.ood.elevatorSystem;

public class ExternalRequest extends Request {

    private Direction direction;

    public ExternalRequest(int l, Direction d) {
        super(l);
        // TODO Auto-generated constructor stub
        this.direction = d;
    }

    public Direction getDirection() {
        return direction;
    }
}
