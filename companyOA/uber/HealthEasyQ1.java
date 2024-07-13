package uber;

public class HealthEasyQ1 {


    public int finalHealthStatus(int[] deltas, int initialHealth){
        int currentHealth = initialHealth;
        for (int delta:deltas) {
            currentHealth+=delta;
            if(currentHealth<0) currentHealth = 0;
            if(currentHealth>100) currentHealth = 100;
        }
        return currentHealth;
    }
}
