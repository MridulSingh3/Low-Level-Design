interface Command{
    void execute();
}
class TV{
    public void turnOn(){
        System.out.println("TV ON");
    }
    public void turnOff(){
        System.out.println("TV OFF");
    }
}
class TurnOnCommand implements Command{
    private TV tv;
    
    public TurnOnCommand(TV tv){
        this.tv=tv;
    }
    
    @Override
    public void execute(){
        tv.turnOn();
    }
}
class TurnOffCommand implements Command{
    private TV tv;
    
    public TurnOffCommand(TV tv){
        this.tv=tv;
    }
    
    @Override
    public void execute(){
        tv.turnOff();
    }
}
class RemoteController{
    private Command command;
    
    public void setCommand(Command command){
        this.command=command;
    }
    public void pressButton(){
        command.execute();
    }
}

public class Main{
	public static void main(String[] args) {
		TV tv=new TV();
		
		Command onCommand=new TurnOnCommand(tv);
		
		Command offCommand=new TurnOffCommand(tv);
		
		RemoteController remote=new RemoteController();
		
		remote.setCommand(onCommand);
        remote.pressButton();

        remote.setCommand(offCommand);
        remote.pressButton();
	}
}