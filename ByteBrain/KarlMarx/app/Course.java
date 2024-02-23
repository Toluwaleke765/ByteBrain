public class Course {
    String course_name;
    Unit[] units = new Unit[3];
  
    Course(String course_name, Unit[] units) {
      this.course_name = course_name;
      this.units = units;
    }
  
  }