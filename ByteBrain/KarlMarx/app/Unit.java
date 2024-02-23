import java.util.Random;
import java.lang.Math;

public abstract class Unit {

    String name;
  
    Unit(String name) {
      this.name = name;
    }
  
    abstract String[] generateQ(int type);
  
    public double getRandFloat(double min, double max) {
      
      Random r = new Random();
      return r.nextDouble((max - min)) + min;
    }
  

    public int getRandInt(int min, int max) {
  
      Random r = new Random();
      return r.nextInt((max - min) ) + min;
    }
  

    public String getRandAnimal() {
  
      String[] nouns = {"dog","cat","elephant","hippo","zebra","giraffe","raccoon","squirrel","tortoise","hair"};
      return nouns[getRandInt(0,9)];
    }


    public String getRandName() {
  
      String[] nouns = {"Tommy","Joshua","Noah","Tolu","Carl Marks","Sally","Sam","Alex","Elizabeth","Emilia"};
      return nouns[getRandInt(0,9)];
    }

    public double round(double num){
      return Math.round(num*100.0)/100.0;
    }
  }