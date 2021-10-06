import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class OptionStore {
    private Hashtable<Integer, List<HashEntry<Integer,Integer>>> store;

    public OptionStore() {
        Hashtable<Integer, List<HashEntry<Integer,Integer>>> temp = new Hashtable<>();

        //AP Landscape
        Integer optionOne = 15;
        List<HashEntry<Integer,Integer>> optionOneValue = new ArrayList<>();
        optionOneValue.add(new HashEntry<Integer,Integer>(57, 0));
        optionOneValue.add(new HashEntry<Integer,Integer>(58, 41));
        optionOneValue.add(new HashEntry<Integer,Integer>(59, 67));
        optionOneValue.add(new HashEntry<Integer,Integer>(60, 175));
        optionOneValue.add(new HashEntry<Integer,Integer>(61, 262));

        temp.put(optionOne, optionOneValue);

        //AP Square
        Integer optionTwo = 16;
        List<HashEntry<Integer,Integer>> optionTwoValue = new ArrayList<>();
        optionTwoValue.add(new HashEntry<Integer, Integer>(62, 0));
        optionTwoValue.add(new HashEntry<Integer, Integer>(63, 56));
        optionTwoValue.add(new HashEntry<Integer, Integer>(64, 101));
        optionTwoValue.add(new HashEntry<Integer, Integer>(65, 249));
        optionTwoValue.add(new HashEntry<Integer, Integer>(66, 424));

        temp.put(optionTwo, optionTwoValue);

        //AP Portrait
        Integer optionThree = 17;
        List<HashEntry<Integer,Integer>> optionThreeValue = new ArrayList<>();
        optionThreeValue.add(new HashEntry<Integer, Integer>(67, 0));
        optionThreeValue.add(new HashEntry<Integer, Integer>(68, 41));
        optionThreeValue.add(new HashEntry<Integer, Integer>(69, 67));
        optionThreeValue.add(new HashEntry<Integer, Integer>(70, 175));
        optionThreeValue.add(new HashEntry<Integer, Integer>(71, 262));

        temp.put(optionThree, optionThreeValue);

        //Art Clock Landscape
        Integer optionFour = 37;
        List<HashEntry<Integer,Integer>> optionFourValue = new ArrayList<>();
        optionFourValue.add(new HashEntry<Integer, Integer>(194, 0));
        optionFourValue.add(new HashEntry<Integer, Integer>(183, 100));
        optionFourValue.add(new HashEntry<Integer, Integer>(184, 100));
        optionFourValue.add(new HashEntry<Integer, Integer>(185, 150));
        optionFourValue.add(new HashEntry<Integer, Integer>(186, 150));
        optionFourValue.add(new HashEntry<Integer, Integer>(187, 150)); 

        temp.put(optionFour, optionFourValue);

        //Art Clock Portrait
        Integer optionFive = 38;
        List<HashEntry<Integer,Integer>> optionFiveValue = new ArrayList<>();
        optionFiveValue.add(new HashEntry<Integer, Integer>(188, 0));
        optionFiveValue.add(new HashEntry<Integer, Integer>(189, 100));
        optionFiveValue.add(new HashEntry<Integer, Integer>(190, 100));
        optionFiveValue.add(new HashEntry<Integer, Integer>(191, 150));
        optionFiveValue.add(new HashEntry<Integer, Integer>(192, 150));
        optionFiveValue.add(new HashEntry<Integer, Integer>(193, 150));

        temp.put(optionFive, optionFiveValue);

        //Floating Frame Landscape
        Integer optionSix = 34;
        List<HashEntry<Integer,Integer>> optionSixValue = new ArrayList<>();
        optionSixValue.add(new HashEntry<Integer, Integer>(135, 0));
        optionSixValue.add(new HashEntry<Integer, Integer>(136, 60));
        optionSixValue.add(new HashEntry<Integer, Integer>(137, 60));
        optionSixValue.add(new HashEntry<Integer, Integer>(139, 100));
        optionSixValue.add(new HashEntry<Integer, Integer>(140, 100));
        optionSixValue.add(new HashEntry<Integer, Integer>(142, 150));
        optionSixValue.add(new HashEntry<Integer, Integer>(143, 150));
        optionSixValue.add(new HashEntry<Integer, Integer>(145, 240));
        optionSixValue.add(new HashEntry<Integer, Integer>(146, 240));
        optionSixValue.add(new HashEntry<Integer, Integer>(148, 315));
        optionSixValue.add(new HashEntry<Integer, Integer>(149, 315));

        temp.put(optionSix, optionSixValue);

        //Floating Frame Portrait
        Integer optionSeven = 35;
        List<HashEntry<Integer,Integer>> optionSevenValue = new ArrayList<>();
        optionSevenValue.add(new HashEntry<Integer, Integer>(151, 0));
        optionSevenValue.add(new HashEntry<Integer, Integer>(152, 60));
        optionSevenValue.add(new HashEntry<Integer, Integer>(153, 60));
        optionSevenValue.add(new HashEntry<Integer, Integer>(155, 100));
        optionSevenValue.add(new HashEntry<Integer, Integer>(156, 100));
        optionSevenValue.add(new HashEntry<Integer, Integer>(158, 150));
        optionSevenValue.add(new HashEntry<Integer, Integer>(159, 150));
        optionSevenValue.add(new HashEntry<Integer, Integer>(161, 240));
        optionSevenValue.add(new HashEntry<Integer, Integer>(162, 240));
        optionSevenValue.add(new HashEntry<Integer, Integer>(164, 315));
        optionSevenValue.add(new HashEntry<Integer, Integer>(165, 315));

        temp.put(optionSeven, optionSevenValue);

        //Floating Frame Square
        Integer optionEight = 36;
        List<HashEntry<Integer,Integer>> optionEightValue = new ArrayList<>();
        optionEightValue.add(new HashEntry<Integer, Integer>(167, 0));
        optionEightValue.add(new HashEntry<Integer, Integer>(168, 90));
        optionEightValue.add(new HashEntry<Integer, Integer>(169, 90));
        optionEightValue.add(new HashEntry<Integer, Integer>(171, 160));
        optionEightValue.add(new HashEntry<Integer, Integer>(172, 160));
        optionEightValue.add(new HashEntry<Integer, Integer>(174, 250));
        optionEightValue.add(new HashEntry<Integer, Integer>(175, 250));
        optionEightValue.add(new HashEntry<Integer, Integer>(177, 360));
        optionEightValue.add(new HashEntry<Integer, Integer>(178, 360));
        optionEightValue.add(new HashEntry<Integer, Integer>(180, 490));
        optionEightValue.add(new HashEntry<Integer, Integer>(181, 490));

        temp.put(optionEight, optionEightValue);
        
        store = temp;
    }

    public List<HashEntry<Integer,Integer>> getOpts(int index) {
        return store.get(index);
    }
}
