public class User {
    int points;
    int streak;

    User(){
        this.points = 0;
        this.streak = 0;
    }
    public void increasePoints(){
        this.points ++;
    }
    public void increaseStreak(){
        this.streak ++;
    }
    public void resetStreak(){
        this.streak = 0;
    }
}
