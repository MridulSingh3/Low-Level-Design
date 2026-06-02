import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String videoTitle);
}

interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " received notification: " + videoTitle);
    }
}

class YouTubeChannel implements Subject {
    private List<Observer> observers = new ArrayList<>();

    private String videoTitle;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(videoTitle);
        }
    }

    public void uploadVideo(String title) {
        this.videoTitle = title;
        notifyObservers();
    }
}

public class Main {
    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel();

        Observer user1 = new Subscriber("Mridul");

        Observer user2 = new Subscriber("Rahul");

        channel.addObserver(user1);
        channel.addObserver(user2);

        channel.uploadVideo("Observer Design Pattern");
    }
}