package com.self.entertainment.unclassified;

/**
 * @author AmazingZ
 * @date 2019/7/4 15:56
 */
public class RobotWrapper implements Robot {

    private Robot robot;

    public RobotWrapper() {
        System.out.println();
    }

    public RobotWrapper(Robot robot) {
        System.out.println();
        this.robot = robot;
    }

    @Override
    public void sayHello() {
        robot.sayHello();
    }
}
