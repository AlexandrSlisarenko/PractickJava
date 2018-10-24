package SantoS.RelayRace;

public interface Competitor {
    void run(int dist);
    void swim(int dist);
    void jump(int dist);
    boolean isOnDistanc();
    void info();
}
