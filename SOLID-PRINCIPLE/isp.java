interface Workable{
    void work();
}
interface Eatable{
    void eat();
}
interface Sleepable{
    void sleep();
}
class HumanWorker implements Workable, Eatable, Sleepable{
    public void work(){
        System.out.println("Human Working");
    }
    public void eat(){
        System.out.println("Human Eating");
    }
    public void sleep(){
        System.out.println("Human Sleeping");
    }
}
class RobotWorker implements Workable{
    public void work() {
        System.out.println("Robot Working");
    }
}
public class Main{
    public static void main(String[] args){
        Workable human = new HumanWorker();
        human.work();

        Workable robot = new RobotWorker();
        robot.work();
    }
}