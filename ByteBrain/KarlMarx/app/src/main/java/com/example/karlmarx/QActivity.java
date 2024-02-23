package com.example.karlmarx;

import java.util.concurrent.TimeUnit;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class QActivity extends SelectActivity {
    static User student = new User();
    static Unit[] physUnits = {new Kinematics(), new Dynamics(), new CircularMotion()};
    static Unit[] mathUnits = {new Derivatives(), new Integrals(), new Limits()};
    static Unit[] chemUnits = {new ElectroChemistry(), new Stoichiometry(), new Trends()};

    static Course physics = new Course("Physics", physUnits);
    static Course math = new Course("Math", mathUnits);
    static Course chemistry = new Course("Chemistry", chemUnits);

    static Course[] courses = {physics, math, chemistry};

    public static void main(String[] args) {

        // (courses,index of the course, unit of the course, get chapter in the unit,
        // user)
        questionRush(0, 1, 0);

    }

    public static String[] questionRush(int index, int unit, int chapter) {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q);

        String[] QA = questionRush(course, unit, chapter);
        String tolu="Physics";
        if (course==2){
            tolu="Math";
        }
        else if(course==3)
        {
            tolu="Chemistry";
        }

        TextView textView1 = (TextView) findViewById(R.id.question_1);
        textView1.setText(tolu);

        TextView textView2 = (TextView) findViewById(R.id.question_area);
        textView2.setText(QA[0]);

        TextView textView3 = (TextView) findViewById(R.id.question_3);


        TextView textView4 = (TextView) findViewById(R.id.question_4);


        Button submitBtn = (Button) findViewById(R.id.submit_btn);
        EditText inputText = (EditText) findViewById(R.id.input_Text);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userInput = inputText.getText().toString();
                boolean ans = checkAns(userInput, QA[1],student);
                //student.points
                textView3.setText("Points: "+student.points);
                //student.streak
                textView4.setText("Streak: "+student.streak);
                System.out.println(QA[1]);
                System.out.println(userInput);
                if (ans) {
                    student.increaseStreak();
                    student.increasePoints();
                    try {
                        TimeUnit.SECONDS.sleep(1);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    String[] QA = questionRush(course, unit, chapter);
                    textView2.setText(QA[0]);
                }
                else{
                    student.resetStreak();
                }
            }
        });


    }
}

