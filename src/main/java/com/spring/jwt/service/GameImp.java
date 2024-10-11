package com.spring.jwt.service;

import com.spring.jwt.Interfaces.IGame;
import com.spring.jwt.dto.ResponceDto;
import com.spring.jwt.dto.ResponseSizeObjectDto;
import com.spring.jwt.entity.ChartTrend;
import com.spring.jwt.entity.GameColorNumber;
import com.spring.jwt.repository.ChartTrendRepo;
import com.spring.jwt.repository.GameColorNumberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameImp implements IGame {
    @Autowired
    private GameColorNumberRepo gameColorNumberRepo;

    @Autowired
    private ChartTrendRepo chartTrendRepo;
    @Override
    public String saveGameColorOrNumber(String referenceId, String colorOrNumber,Integer amount,String period) {
        if (colorOrNumber.isEmpty())throw new RuntimeException("Enter valid color or number");
        GameColorNumber gameColorNumber = GameColorNumber
                .builder()
                    .wonNumber(-1)
                        .dateAndTime(LocalDateTime.now())
                            .amount(amount)
                                .green(false)
                                     .orange(false)
                                         .violet(false)
                                              .zero(false)
                                                   .one(false)
                                                       .two(false)
                                                          .three(false)
                                                            .four(false)
                                                                 .five(false)
                                                                      .six(false)
                                                                        .seven(false)
                                                                            .eight(false)
                                                                                .nine(false)
                                                                                    .period(period)
                                                                                        .userReferenceId(referenceId)
                                                                                            .winStatus(false)
                        .build();


        if (colorOrNumber.equals("_ONE_")){
            gameColorNumber.setType("_NUMBER_");
            gameColorNumber.setOne(true);

        } else if (colorOrNumber.equals("_TWO_")){
            gameColorNumber.setType("_NUMBER_");
            gameColorNumber.setTwo(true);

        }else if (colorOrNumber.equals("_THREE_")){
            gameColorNumber.setType("_NUMBER_");
            gameColorNumber.setThree(true);

        }
        else if (colorOrNumber.equals("_FOUR_")){
            gameColorNumber.setType("_NUMBER_");
            gameColorNumber.setFour(true);

        }else if (colorOrNumber.equals("_FIVE_")){
            gameColorNumber.setType("_NUMBER_");
            gameColorNumber.setFive(true);

        }else if (colorOrNumber.equals("_SIX_")){
            gameColorNumber.setType("_NUMBER_");
            gameColorNumber.setSix(true);

        }else if (colorOrNumber.equals("_SEVEN_")){
            gameColorNumber.setType("_NUMBER_");
            gameColorNumber.setSeven(true);

        }else if (colorOrNumber.equals("_EIGHT_")){
            gameColorNumber.setType("_NUMBER_");
            gameColorNumber.setEight(true);

        }else if (colorOrNumber.equals("_NINE_")){
            gameColorNumber.setType("_NUMBER_");
            gameColorNumber.setNine(true);

        }else if (colorOrNumber.equals("_ZERO_")){
            gameColorNumber.setType("_NUMBER_");
            gameColorNumber.setOne(true);

        }else if (colorOrNumber.equals("_ORANGE_")){
            gameColorNumber.setType("_COLOR_");
            gameColorNumber.setOrange(true);

        }else if (colorOrNumber.equals("_GREEN_")){
            gameColorNumber.setType("_COLOR_");
            gameColorNumber.setGreen(true);

        }else if (colorOrNumber.equals("_VIOLET_")){
            gameColorNumber.setType("_COLOR_");
            gameColorNumber.setViolet(true);

        }else {
            throw new RuntimeException("type or color or number is not valid input");
        }
        gameColorNumberRepo.save(gameColorNumber);
        return "request saved";


    }

    @Override
    public String saveChartTrend() {

        List<ChartTrend> listOFChartTrend = chartTrendRepo.findAll();
        if(listOFChartTrend.size() == 0){
            Long i = 2000000000000L;
            ChartTrend chartTrend = ChartTrend.builder()
                    .runningStatus("_RUNNING_")
                    .period(i)
                    .wonNumber(-1)
                    .build();
            chartTrendRepo.save(chartTrend);
        }else {
            Long i = (2000000000000L+listOFChartTrend.size())+1;


            ChartTrend chartTrend = ChartTrend.builder()
                    .runningStatus("_RUNNING_")
                    .period(i)
                    .wonNumber(-1)
                    .build();
            chartTrendRepo.save(chartTrend);
        }
        return "saved chartTrend";
    }



    @Override
    public String updateChartTrend(Integer wonNumber) {

        ChartTrend chartTrend = chartTrendRepo.findByRunningStatus("_RUNNING_").orElseThrow(()->new RuntimeException("chart treand details not found by id"));
        chartTrend.setRunningStatus("_DONE_");
        chartTrend.setWonNumber(wonNumber);
        chartTrendRepo.save(chartTrend);

        return "updated Chart Trend";

    }

    @Override
    public Object getLivePeriodNo() {
        List<ChartTrend> listOFChartTrend = chartTrendRepo.findAll();
        Long size = (long) listOFChartTrend.size();
        return new ResponseSizeObjectDto(size,listOFChartTrend);

    }

    @Override
    public String makeWinNumber() {
        Integer green = gameColorNumberRepo.findByGreen(true);
        Integer orange =gameColorNumberRepo.findByOrange(true);
        Integer violet =gameColorNumberRepo.findByViolet(true);
        Integer zero =gameColorNumberRepo.findByZero(true);
        Integer one =gameColorNumberRepo.findByOne(true);
        Integer two =gameColorNumberRepo.findByTwo(true);
        Integer three =gameColorNumberRepo.findByThree(true);
        Integer four =gameColorNumberRepo.findByFour(true);
        Integer five =gameColorNumberRepo.findByFive(true);
        Integer six =gameColorNumberRepo.findBySix(true);
        Integer seven =gameColorNumberRepo.findBySeven(true);
        Integer eight =gameColorNumberRepo.findByEight(true);
        Integer nine =gameColorNumberRepo.findByNine(true);
        Integer finalWonValue = -1;

        System.out.println(nine);
        System.out.println(green +" "+ orange +" "+violet +" "+ zero +" "+one +" "+ two +" "+three +" "+ four +" "+five +" "+ six +" "+ seven+" "+ eight +" "+nine);

        List<Integer> listOfNumber = new ArrayList<>();
        Map<Integer,Integer> mapOfNumbers = new HashMap<>();
        List<Integer> listOfColor = new ArrayList<>();
        Map<Integer,String> mapOfColor = new HashMap<>();

        if (orange!=null) {
            listOfColor.add(orange);
            mapOfColor.put(orange,"_ORANGE_");
        };
        if (green!=null) {
            listOfColor.add(green);
            mapOfColor.put(green,"_GREEN_");

        };
        if (violet!=null) {
            listOfColor.add(violet);
            mapOfColor.put(violet,"_VIOLET_");

        };
        if (zero!=null) {
            listOfNumber.add(zero);
            mapOfNumbers.put(zero,0);
        };
        if (one!=null) {
            listOfNumber.add(one);
            mapOfNumbers.put(one,1);
        };
        if (two!=null) {
            listOfNumber.add(two);
            mapOfNumbers.put(two,2);
        };
        if (three!=null) {
            listOfNumber.add(three);
            mapOfNumbers.put(three,3);
        };
        if (four!=null) {
            listOfNumber.add(four);
            mapOfNumbers.put(four,4);
        };
        if (five!=null) {
            listOfNumber.add(five);
            mapOfNumbers.put(five,5);
        };
        if (six!=null) {
            listOfNumber.add(six);
            mapOfNumbers.put(six,6);
        };
        if (seven!=null) {
            listOfNumber.add(seven);
            mapOfNumbers.put(seven,7);
        };
        if (eight!=null) {
            listOfNumber.add(eight);
            mapOfNumbers.put(eight,8);
        };
        if (nine!=null) {
            listOfNumber.add(nine);
            mapOfNumbers.put(nine,9);
        };
        System.out.println(listOfNumber);
        System.out.println(listOfColor);

        Collections.sort(listOfNumber);
        Collections.sort(listOfColor);

        System.out.println(listOfNumber);
        System.out.println(listOfColor);


        System.out.println(listOfNumber.size());


        for (int i=1; i<listOfNumber.size();i++){
            getResultNumber(listOfNumber,mapOfNumbers);
        }





//        System.out.println(green +" "+ orange +" "+violet +" "+ zero +" "+one +" "+ two +" "+three +" "+ four +" "+five +" "+ six +" "+ seven+" "+ eight +" "+nine);
//        boolean flag = false;
//        if (orange==null)orange=MaxAmount;
//        else if (green==null)green=MaxAmount;
//        else if (violet==null)violet=MaxAmount;
//        else if (one==null)one=MaxAmount;
//        else if (two==null)two=MaxAmount;
//        else if (three==null)three=MaxAmount;
//        else if (four==null)four=MaxAmount;
//        else if (five==null)five=MaxAmount;
//        else if (six==null)six=MaxAmount;
//        else if (seven==null)seven=MaxAmount;
//        else if (eight==null)eight=MaxAmount;
//        else if (nine==null)nine=MaxAmount;
//        System.out.println(green +" "+ orange +" "+violet +" "+ zero +" "+one +" "+ two +" "+three +" "+ four +" "+five +" "+ six +" "+seven +" "+ eight +" "+nine);
//
//
//
//        if (green<=orange && green<=violet || flag){
//            if (one!=-1 && one <= three  && one <= five  && one <= seven  && one <= nine){
//                finalWonValue = 1;
//            }else if (three!=-1 && three <= one && three <= five && three <= seven && three <= nine){
//                finalWonValue = 3;
//            }else if (five!=-1 && five <= one &&  five <= three && five <= seven  && five <= nine){
//                finalWonValue = 5;
//            }else if (seven!=-1 && seven <= one && seven <= three && seven <= five  && seven <= nine){
//                finalWonValue = seven;
//            }else if (nine!=-1 && nine <= one && nine <= three && nine <= five && nine <= seven){
//                finalWonValue = 9;
//            }else {
//                flag = true;
//            }
//        }
//        if (orange<=green && orange<=violet || flag){
//            System.out.println("300");
//            if ( zero!=-1 && zero <= two  && zero <= four  && zero <= six  && zero <= eight){
//                finalWonValue = 0;
//            }else if (two!=-1 &&  two <= zero && two <= four && two <= six  && two <= eight ){
//                finalWonValue = 2;
//            }else if ( four!=-1 && four <= two  && four <= zero  && four <= six  && four <= eight){
//                finalWonValue = 4;
//            }else if (six!=-1 && six <= two  && six <= four && six <= zero  && six <= eight){
//                finalWonValue = 6;
//            }else if (eight!=-1 &&  eight <= two  && eight <= four  && eight <= six && eight <= zero ){
//                finalWonValue = 8;
//            }else {
//                flag = true;
//            }
//        }
//        if (violet<=green && violet<=orange || flag){
//            System.out.println("400");
//            if (zero!=-1 &&  zero <= two  && zero <= four  && zero <= six  && zero <= eight){
//                finalWonValue = 0;
//            }else if (five!=-1 && five <= one &&  five <= three && five <= seven  && five <= nine){
//                finalWonValue = 5;
//            }else {
//                flag = true;
//            }
//        }
//        System.out.println("okokokok"+finalWonValue);

        return String.valueOf(0);

    }

    private Integer getResultNumber(List<Integer> listOfNumber, Map<Integer, Integer> mapOfNumbers) {
        Integer sum = 0;
        for (int i=0; i<listOfNumber.size();i++){
            sum = sum+listOfNumber.get(i);
        }
        System.out.println(sum);
        Integer thirtyPercentage = (int) (0.3 * sum);
        Integer fortyPercentage =(int) (0.4 * sum) ;
        Integer fiftyPercentage =(int) (0.5 * sum);

        System.out.println("thirtyPercentage : "+thirtyPercentage+" fortyPercentage : "+fortyPercentage+" fiftyPercentage : "+fiftyPercentage);
        System.out.println("MMMAAAPPP"+mapOfNumbers);


        Integer finalWinValue = listOfNumber.get(0) ;

        return 0;

    }

}
