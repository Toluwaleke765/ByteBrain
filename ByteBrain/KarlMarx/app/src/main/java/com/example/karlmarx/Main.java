package com.example.karlmarx;

    import java.util.Scanner;
    import java.util.Random;

    public class Main {
        static User student = new User();
        static Unit[] physUnits = { new Kinematics(), new Dynamics(), new CircularMotion() };
        static Unit[] mathUnits = { new Derivatives(), new Integrals(), new Limits() };
        static Unit[] chemUnits = { new ElectroChemistry(), new Stoichiometry(), new Trends() };

        static Course physics = new Course("Physics", physUnits);
        static Course math = new Course("Math", mathUnits);
        static Course chemistry = new Course("Chemistry", chemUnits);

        static Course[] courses = { physics, math, chemistry };
        public static void main(String[] args) {

            // (courses,index of the course, unit of the course, get chapter in the unit,
            // user)
            questionRush( 0, 1, 0);

        }

        public static String[] questionRush( int index, int unit, int chapter) {

                String[] QA = new String[2];
                try {
                    QA = courses[index].units[unit].generateQ(chapter);
                } catch (Exception e) {
                    System.out.println("Not a valid course, unit or chapter");
                }
                System.out.println(QA[0]);
                System.out.println(QA[1]);
                Random r = new Random();
                int temp = r.nextInt(2);

                System.out.println("Another? (y/n)");
                return QA;


        }

        static boolean checkAns(String givenAns, String realAns,User user) {
            try {
                float i = Float.parseFloat(givenAns);
                float j = Float.parseFloat(realAns);
                if ((Math.abs((i - j) / j) * 100) <= 5.0) {
                    user.increasePoints();
                    user.increaseStreak();

                    return true;
                }
                return false;
            } catch (Exception e) {
                System.out.print("Not supported");
                return false;
            }

        }


}
