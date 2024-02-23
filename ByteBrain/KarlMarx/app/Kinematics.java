public class Kinematics extends Unit {

    Kinematics() {
      super("Kinematics");
    }
  
    public String[] generateQ(int type) { 
      String[] QA = new String[2];
      //[0] = time, [1] = acceleration, [2] = velocity one, [3] = velocity two, [4] = inital poisiton, [5] = final position
      double[] values = new double[6];
  
      // GENERATE VALUES
      values[0] = getRandFloat(1.0,25.0);
      values[1] = getRandFloat(-25.0,25.0);
      values[2] = getRandFloat(-200.0,200.0);
      values[3] = values[2] + values[1] * values[0];
      values[4] = getRandFloat(-100.0,100.0);
      values[5] = values[4] + values[2]*values[0]+0.5*values[1]*values[0]*values[0];
      
      if(type == 0){
        int index = getRandInt(0, 3);
        //solve for v2
        if(index == 0){
          QA[0] = "A "+getRandAnimal()+" is running away from "+getRandName()+" at a velocity of "+round(values[3])+"m/s. Their velocity changes at a rate of "+round(values[1])+"m/s^2. After "+round(values[0])+" seconds, what is their final velocity?";
          QA[1] = round(values[3]) + "";
        }
        //solve for v1
        else if(index == 1){
          QA[0] = getRandName()+" crossed the finish line with a velocity of "+round(values[3])+"m/s. The race lasted a total of "+round(values[0])+" seconds. A spectator noticed that their velocity changed at a rate of "+round(values[1])+" m/s^2, what was their starting velocity?";
          QA[1] = round(values[2]) + "";
        }
        //solve for acceleration
        else if(index == 2){
          QA[0] = getRandName()+"'s mother recorded their initial and final velocity at "+round(values[2])+ " m/s and "+round(values[3])+" m/s respectively. Her stopwatch read "+round(values[0])+" seconds. What rate did their velocity change by?";
          QA[1] = round(values[1]) + "";
        }
        //solve for time
        else if(index == 3){
          QA[0] = getRandName() + " fell asleep during a race between " + getRandName() +" and a "+getRandAnimal()+". He/She knows that their starting velocity was "+round(values[2])+"m/s and both crossed the finish line at the same time with a velocity of "+round(values[3])+"m/s. How long was the race?";
          QA[1] = round(values[0]) + "";
        }

        
      }else if (type == 1){
        int index = getRandInt(0, 4);
        //solve for time
        if(index == 0){
          QA[0] = getRandName()+" drove "+round(values[5]-values[4])+" meters to the grocery store. If they drove at a velocity of "+round(values[2])+"m/s and their vehicle accelerates at a rate of "+round(values[1])+"m/s^2, how long did their trip take?";
          QA[1] = round(values[0]) + "";
        }
        //solve for acceleration
        else if(index == 1){
          QA[0] = "In an outstanding "+round(values[0])+" seconds, "+getRandName()+" moved from "+round(values[4])+"m to "+round(values[5])+"m. If they started moving with a velocity of "+round(values[2])+"m/s, what was their acceleration?";
          QA[1] = round(values[1]) + "";
        }
        //solve for v1
        else if(index == 2){
          QA[0] = "A "+getRandAnimal()+" leaped through the air for "+round(values[0])+"s and landed "+round(values[5]-values[4])+"m from their initial spot. If they accelerated at a rate of "+round(values[1])+"m/s^2, what was their inital velocity?";
          QA[1] = round(values[2]) + "";
        }
        //solve for x1
        else if(index == 3){
          QA[0] = getRandName()+" is "+round(values[5])+"m North after "+round(values[0])+"s of their trip. If they started moving at"+round(values[2])+"m/s with an acceleration of "+round(values[1])+"m/s^2, where did they start their trip?";
          QA[1] = round(values[4]) + "";
        }
        //solve for x2
        else if(index == 4){
          QA[0] = "Starting at "+round(values[4])+"m, "+getRandName()+" ran at "+round(values[2])+"m/s for "+round(values[0])+"s. If they sped up by "+round(values[1])+"m/s^2, what was their final position.";
          QA[1] = round(values[5]) + "";
        }
      }
      return QA;
    }
  }