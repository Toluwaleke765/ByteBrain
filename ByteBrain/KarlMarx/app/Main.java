import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {

    User Tommy = new User();
    Unit[] physUnits = { new Kinematics(), new Dynamics(), new CircularMotion() };
    Unit[] mathUnits = { new Derivatives(), new Integrals(), new Limits() };
    Unit[] chemUnits = { new ElectroChemistry(), new Stoichiometry(), new Trends() };

    Course physics = new Course("Physics", physUnits);
    Course math = new Course("Math", mathUnits);
    Course chemistry = new Course("Chemistry", chemUnits);

    Course[] courses = { physics, math, chemistry };

    // (courses,index of the course, unit of the course, get chapter in the unit,
    // user)
    questionRush(courses, 0, 1, 0, Tommy);

  }

  public static void questionRush(Course[] courses, int index, int unit, int chapter, User user) {

    Scanner s = new Scanner(System.in);
    boolean run = true;
    while (run) {
      String[] QA = new String[2];
      try {
        QA = courses[index].units[unit].generateQ(chapter);
      } catch (Exception e) {
        System.out.println("Not a valid course, unit or chapter");
      }
      System.out.println(QA[0]);
      System.out.println(QA[1]);
      String givenAns = s.nextLine();

      Random r = new Random();
      int temp = r.nextInt(2);

      System.out.println(checkAns(givenAns, QA[temp]));
      if (checkAns(givenAns, QA[temp])) {
        user.increasePoints();
        user.increaseStreak();
      } else {
        user.resetStreak();
      }
      System.out.println("Points: " + user.points + " Streak: " + user.streak);

      System.out.println("Another? (y/n)");
      String input = s.nextLine();
      if (input.equals("n")) {
        run = false;
      }
    }
    s.close();
  }

  static boolean checkAns(String givenAns, String realAns) {
    try {
      float i = Float.parseFloat(givenAns);
      float j = Float.parseFloat(realAns);
      if ((Math.abs((i - j) / j) * 100) <= 5.0) {
        return true;
      }
      return false;
    } catch (Exception e) {
      System.out.print("Not supported");
      return false;
    }

  }
}