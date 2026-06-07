interface NumberSystem {
    void convertNumber(int num);
}

class Octal implements NumberSystem {
    @Override
    public void convertNumber(int num) {
        System.out.println(Integer.toOctalString(num));
    }
}

class Binary implements NumberSystem {
    @Override
    public void convertNumber(int num) {
        System.out.println(Integer.toBinaryString(num));
    }
}

class Hexa implements NumberSystem {
    @Override
    public void convertNumber(int num) {
        System.out.println(Integer.toHexString(num));
    }
}

class Strategy {
    private NumberSystem strategy;

    public void setStrategy(NumberSystem strategy) {
        this.strategy = strategy;
    }

    public void execute(int num) {
        strategy.convertNumber(num);
    }
}

public class Main {
    public static void main(String[] args) {
        Strategy s = new Strategy();

        s.setStrategy(new Binary());
        s.execute(10);
    }
}