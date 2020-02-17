package fr.epita.titanic.dao;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;

import org.knowm.xchart.internal.chartpart.Chart;
import org.knowm.xchart.style.Styler.LegendPosition;

import fr.epita.titanic.launcher.Constants;
import fr.epita.titanic.launcher.Main;
import fr.epita.titanic.launcher.SampleChart;



public class TitanicChartBuilder implements SampleChart<Chart<?,?>> {
	static Map<String, Long> survived =new HashMap<String, Long>();
	
	static Map<String, Long> ageTotal =new HashMap<String, Long>();
	static Map<String, Long> ageSur =new HashMap<String, Long>();
	static Map<String, Long> ageDem =new HashMap<String, Long>();
	static Map<String, Long> genderTotal =new HashMap<String, Long>();
	static Map<String, Long> genderSurvived =new HashMap<String, Long>();
	static Map<String, Long> genderDemised =new HashMap<String, Long>();
	static Map<Integer, Long> pClassTotal =new HashMap<Integer, Long>();
	static Map<Integer, Long> pClassSurvived =new HashMap<Integer, Long>();
	static Map<Integer, Long> pClassDemised =new HashMap<Integer, Long>();
	static List<Double> ageClassOne =new ArrayList<Double>();
	static List<Double> fareClassOne =new ArrayList<Double>();
	static List<Double> ageClassTwo =new ArrayList<Double>();
	static List<Double> fareClassTwo =new ArrayList<Double>();
	static List<Double> ageClassThree =new ArrayList<Double>();
	static List<Double> fareClassThree =new ArrayList<Double>();
	static List<Double> ageSurvived =new ArrayList<Double>();
	static List<Double> fareSurvived =new ArrayList<Double>();
	static List<Double> ageDemised =new ArrayList<Double>();
	static List<Double> fareDemised =new ArrayList<Double>();
	static Long zeroFare=(long)0;
	static Long belowFifty=(long)0;
	static Long belowHundred=(long)0;
	static Long belowOneFifty=(long)0;
	static Long belowTwoHundre=(long)0;
	static Long aboveTwoHundred=(long)0;
	static Long passengerAlone=(long)0;
	static Long passengerDAlone=(long)0;
	static Long passengerWFamily=(long)0;
	static Long passengerWDFamily=(long)0;
	
	static String caseValue="";

	static long zeroFareS=(long)0 ;

	static long belowFiftyS=(long)0;

	static long belowHundredS=(long)0;

	static long belowOneFiftyS=(long)0;

	static long belowTwoHundredS=(long)0;

	static long abovetwoHundredS=(long)0;
	
	
 
	
	@Override
	public Chart<?, ?> getChart() {
		

		Chart <?, ?> chart=null;
	    switch (caseValue)
	    {
	         case Constants.CASE_GENDER:
	        	CategoryChart chartGender = new CategoryChartBuilder().width(800).height(600).title("Gender based Survival").xAxisTitle("Gender").yAxisTitle("Count").build();	     	    
	        	chartGender.getStyler().setLegendPosition(LegendPosition.InsideNE);
	     	    chartGender.getStyler().setHasAnnotations(true);
	     	    ArrayList<Object> x = new ArrayList<Object>();
	     	    ArrayList<Long> y = new ArrayList<Long>();
	        	x.add(Constants.GENDER[0]);
	     	    x.add(Constants.GENDER[1]);
	     	    y.add(genderTotal.get(Constants.GENDER[0]));
	     	    y.add(genderTotal.get(Constants.GENDER[1]));
	     	    chartGender.addSeries(Constants.SERIES_LABEL_TOTAL, x, y);
	     	    x = new ArrayList<Object>();
	     	    y = new ArrayList<Long>();
	     	    x.add(Constants.GENDER[0]);
	     	    x.add(Constants.GENDER[1]);
	     	    y.add(genderSurvived.get(Constants.GENDER[0]));
	     	    y.add(genderSurvived.get(Constants.GENDER[1]));
	     	    chartGender.addSeries(Constants.SERIES_LABEL_SURVIVED, x, y);
	     	    
	     	    x = new ArrayList<Object>();
	     	    y = new ArrayList<Long>();
	     	    x.add(Constants.GENDER[0]);
	     	    x.add(Constants.GENDER[1]);
	     	    y.add(genderDemised.get(Constants.GENDER[0]));
	     	    y.add(genderDemised.get(Constants.GENDER[1]));
	     	    chartGender.addSeries(Constants.SERIES_LABEL_DEMISED, x, y);
	     	    chart= chartGender; 
	         ;
	         break;
	         case Constants.CASE_PCLASS:
	        	CategoryChart chartpClass = new CategoryChartBuilder().width(800).height(600).title("Passenger Class based Survival").xAxisTitle("Passenger class").yAxisTitle("Count").build();
		     	chartpClass.getStyler().setLegendPosition(LegendPosition.InsideNE);
		     	chartpClass.getStyler().setHasAnnotations(true);
		     	x = new ArrayList<Object>();
		     	y = new ArrayList<Long>();
	        	x.add(Constants.P_CLASS[0]);
	     	    x.add(Constants.P_CLASS[1]);
	     	    x.add(Constants.P_CLASS[2]);
	     	    y.add(pClassTotal.get(1));
	     	    y.add(pClassTotal.get(2));
	     	    y.add(pClassTotal.get(3));
	     	    chartpClass.addSeries(Constants.SERIES_LABEL_TOTAL, x, y);
	     	    x = new ArrayList<Object>();
	     	    y = new ArrayList<Long>();
	     	    x.add(1);
	     	    x.add(2);
	     	    x.add(3);
	     	    y.add(pClassSurvived.get(Constants.P_CLASS[0]));
	     	    y.add(pClassSurvived.get(Constants.P_CLASS[1]));
	     	    y.add(pClassSurvived.get(Constants.P_CLASS[2]));
	     	    chartpClass.addSeries(Constants.SERIES_LABEL_SURVIVED, x, y);
	     	    
	     	    x = new ArrayList<Object>();
	     	    y = new ArrayList<Long>();
	     	    x.add(Constants.P_CLASS[0]);
	     	    x.add(Constants.P_CLASS[1]);
	     	    x.add(Constants.P_CLASS[2]);
	     	    y.add(pClassDemised.get(Constants.P_CLASS[0]));
	     	    y.add(pClassDemised.get(Constants.P_CLASS[1]));
	     	    y.add(pClassDemised.get(Constants.P_CLASS[2]));
	     	    chartpClass.addSeries(Constants.SERIES_LABEL_DEMISED, x, y);
	     	    chart=chartpClass;
	         ;
	         break;
	         case Constants.CASE_AGEFARE:
	        	 XYChart ageChart = new XYChartBuilder().width(800).height(600).title("Age vs Fare with pclass").xAxisTitle("Age").yAxisTitle("Fare").build(); 
	        	 ageChart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
	        	 ageChart.getStyler().setChartTitleVisible(false);
	        	 ageChart.getStyler().setLegendPosition(LegendPosition.InsideNE);
	        	 ageChart.getStyler().setMarkerSize(16);
	        	 ageChart.addSeries(Constants.SERIES_LABEL_CLASSONE, ageClassOne,fareClassOne);
	        	 ageChart.addSeries(Constants.SERIES_LABEL_CLASSTWO, ageClassTwo,fareClassTwo);
	        	 ageChart.addSeries(Constants.SERIES_LABEL_CLASSTHREE, ageClassThree,fareClassThree);
	        	 chart=ageChart;
	        	 break;
	         case Constants.CASE_AGEFARE_SURVIVAL:
	        	 XYChart ageSurvivalChart = new XYChartBuilder().width(800).height(600).title("Age vs Fare with survival").xAxisTitle("Age").yAxisTitle("Fare").build(); 
	        	 ageSurvivalChart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
	        	 ageSurvivalChart.getStyler().setChartTitleVisible(false);
	        	 ageSurvivalChart.getStyler().setLegendPosition(LegendPosition.InsideNE);
	        	 ageSurvivalChart.getStyler().setMarkerSize(16);
	        	 ageSurvivalChart.addSeries(Constants.SERIES_LABEL_SURVIVED, ageSurvived,fareSurvived);
	        	 ageSurvivalChart.addSeries(Constants.SERIES_LABEL_DEMISED, ageDemised,fareDemised);
	        	 chart=ageSurvivalChart;
	        	 break;
	         case Constants.CASE_AGE_COUNT:
		        	CategoryChart chartAgeCount = new CategoryChartBuilder().width(800).height(600).title("Survival based on age").xAxisTitle("Age").yAxisTitle("Count").build();
	        	 chartAgeCount.getStyler().setLegendPosition(LegendPosition.InsideNE);
	        	 chartAgeCount.getStyler().setHasAnnotations(true);
			       x = new ArrayList<Object>();
			       y = new ArrayList<Long>();
			       x.add(Constants.AGE_RANGE_ONE);
		     	   x.add(Constants.AGE_RANGE_TWO);
		     	   x.add(Constants.AGE_RANGE_THREE);
		     	   x.add(Constants.AGE_RANGE_FOUR);
		     	   y.add(ageSur.get(Constants.AGE_RANGE_ONE));
		     	   y.add(ageSur.get(Constants.AGE_RANGE_TWO));
		     	   y.add(ageSur.get(Constants.AGE_RANGE_THREE));
		     	   y.add(ageSur.get(Constants.AGE_RANGE_FOUR));
		     	   chartAgeCount.addSeries(Constants.SERIES_LABEL_SURVIVED, x, y);
		     	   x = new ArrayList<Object>();
		     	   y = new ArrayList<Long>();
		     	   x.add(Constants.AGE_RANGE_ONE);
		     	   x.add(Constants.AGE_RANGE_TWO);
		     	   x.add(Constants.AGE_RANGE_THREE);
		     	   x.add(Constants.AGE_RANGE_FOUR);
		     	   y.add(ageDem.get(Constants.AGE_RANGE_ONE));
		     	   y.add(ageDem.get(Constants.AGE_RANGE_TWO));
		     	   y.add(ageDem.get(Constants.AGE_RANGE_THREE));
		     	   y.add(ageDem.get(Constants.AGE_RANGE_FOUR));
		     	   chartAgeCount.addSeries(Constants.SERIES_LABEL_DEMISED, x, y);
		           chart=chartAgeCount;
		    		break;
	         case Constants.CASE_SURVIVAL:
	        	 CategoryChart chartsurvival = new CategoryChartBuilder().width(800).height(600).title("Survival Count").yAxisTitle("Count").build();
	        	 chartsurvival.getStyler().setLegendPosition(LegendPosition.InsideNW);
	        	 chartsurvival.getStyler().setHasAnnotations(true);
	        	 x = new ArrayList<Object>();
			     y = new ArrayList<Long>();
			     x.add("Survival");
			     y.add(survived.get(Constants.SERIES_LABEL_SURVIVED));
			     
		         chartsurvival.addSeries(Constants.SERIES_LABEL_SURVIVED, x, y);
		         x = new ArrayList<Object>();
			     y = new ArrayList<Long>();
			     x.add("Survival");
			     y.add(survived.get(Constants.SERIES_LABEL_DEMISED));
			     chartsurvival.addSeries(Constants.SERIES_LABEL_DEMISED, x, y);
			     chart=chartsurvival;
	        	 break;
	        	 
	         case Constants.CASE_FAMILY :
	        	 PieChart caseFamily = new PieChartBuilder().width(800).height(600).title("Passenger Family Details").build();


	     	     Color[] sliceColors = new Color[] { new Color(230, 105, 62),  new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182) };
	     	     caseFamily.getStyler().setSeriesColors(sliceColors);
	     	     caseFamily.addSeries("Passengers survived who were travelling alone", passengerAlone-passengerDAlone);
	     	     caseFamily.addSeries("Passengers demised who were travelling alone", passengerDAlone);

	     	     caseFamily.addSeries("Passengers  survived who had family member aboard", passengerWFamily-passengerWDFamily);
	     	     caseFamily.addSeries("Passengers demised  who had family member aboard", passengerWDFamily);
	     	     chart=caseFamily;
	     	     break;
	         case Constants.CASE_FARE_DISTRIBUTION:
	        	    PieChart chartFareDistr = new PieChartBuilder().width(800).height(600).title("Passenger Fare Distribution").build();


	        	    Color[] colorsFare = new Color[] { new Color(224, 68, 14),new Color(230, 105, 62),  new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182),new Color(240, 180, 182) };
	        	    chartFareDistr.getStyler().setSeriesColors(colorsFare);

	        		
	        	    chartFareDistr.addSeries("Passengers who paid 0 fare", zeroFare);
	        	    chartFareDistr.addSeries("Passengerswho paid 0-50 fare", belowFifty);

	        	    chartFareDistr.addSeries("Passengers who paid 51-100 fare", belowHundred);
	        	    chartFareDistr.addSeries("Passengers who paid 101-150 fare", belowOneFifty);
	        	    chartFareDistr.addSeries("Passengers who paid 151-200 fare", belowTwoHundre);
	        	    chartFareDistr.addSeries("Passengers who paid greater than 200 fare", aboveTwoHundred);
	        	    chart=chartFareDistr;
	        	    break;
	        	    
	         case Constants.CASE_FARE_SURVIVAL_RATE:
	        	    PieChart chartSurvival = new PieChartBuilder().width(800).height(600).title("Survival rate of Passengers based on Fare").build();

	        		chartSurvival.getStyler().setLegendVisible(true);

	        		   chartSurvival.getStyler().setAnnotationDistance(.82);
	        		    chartSurvival.getStyler().setPlotContentSize(.9);
	        	    chartSurvival.getStyler().setDefaultSeriesRenderStyle(PieSeriesRenderStyle.Donut);


	        	    chartSurvival.addSeries("Survival rate of passengers in fare range 0 ", (double)zeroFareS/zeroFare);
	        	    chartSurvival.addSeries("Survival rate of passengers in fare range 0-50", (double)belowFiftyS/belowFifty);

	        	    chartSurvival.addSeries("Survival rate of passengers in fare range 51-100 ", (double)belowHundredS/belowHundred);
	        	    chartSurvival.addSeries("Survival rate of passengers in fare range 101-150 ", (double)belowOneFiftyS/belowOneFifty);
	        	    chartSurvival.addSeries("Survival rate of passengers in fare range 151-200 ", (double)belowTwoHundredS/belowTwoHundre);
	        	    chartSurvival.addSeries("Survival rate of passengers in fare range above 200 ", (double)abovetwoHundredS/aboveTwoHundred);
	        	    chart=chartSurvival;
	        	    break;
	         default:
	         //Java code
	         ;
	    }
	
	    return chart;


	}
	
	public void getgenderBasedSurvival() {
		genderTotal= Main.datalist.stream().map(v->v.getGender()).collect(Collectors.groupingBy(
	            Function.identity(), Collectors.counting()));
	    genderSurvived=Main.datalist.stream().filter(o->o.getSurvived() == 1).map(v->v.getGender()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	    
	    genderDemised=Main.datalist.stream().filter(o->o.getSurvived() == 0).map(v->v.getGender()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	    SampleChart<Chart<?, ?>> exampleChart = new TitanicChartBuilder();
		caseValue=Constants.CASE_GENDER;
		CategoryChart chart = (CategoryChart) exampleChart.getChart();
	    new SwingWrapper<CategoryChart>(chart).displayChart();
		
	}

	public void getclassBasedSurvival() {
		
		pClassTotal= Main.datalist.stream().map(v->v.getpClass()).collect(Collectors.groupingBy(
	            Function.identity(), Collectors.counting()));
		pClassSurvived=Main.datalist.stream().filter(o->o.getSurvived() == 1).map(v->v.getpClass()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	    
		pClassDemised=Main.datalist.stream().filter(o->o.getSurvived() == 0).map(v->v.getpClass()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		SampleChart<Chart<?, ?>> exampleChart = new TitanicChartBuilder();
		caseValue=Constants.CASE_PCLASS;
		CategoryChart chart = (CategoryChart) exampleChart.getChart();
	    new SwingWrapper<CategoryChart>(chart).displayChart();
	}

	public void getAgevsFarePclassBased() {
		
		ageClassOne=Main.datalist.stream().filter(o->o.getpClass() == 1).map(v->v.getAge()).collect(Collectors.toList());
		fareClassOne=Main.datalist.stream().filter(o->o.getpClass() == 1).map(v->v.getFare()).collect(Collectors.toList());
		ageClassTwo=Main.datalist.stream().filter(o->o.getpClass() == 2).map(v->v.getAge()).collect(Collectors.toList());
		fareClassTwo=Main.datalist.stream().filter(o->o.getpClass() == 2).map(v->v.getFare()).collect(Collectors.toList());
		ageClassThree=Main.datalist.stream().filter(o->o.getpClass() == 3).map(v->v.getAge()).collect(Collectors.toList());
		fareClassThree=Main.datalist.stream().filter(o->o.getpClass() == 3).map(v->v.getFare()).collect(Collectors.toList());
		SampleChart<Chart<?, ?>> exampleChart =  new TitanicChartBuilder();
		caseValue=Constants.CASE_AGEFARE;
	    XYChart chart = (XYChart) exampleChart.getChart();
	    
	    new SwingWrapper<XYChart>(chart).displayChart();
		
	}

	public void getAgevsFareSurvivalBased() {
		ageSurvived=Main.datalist.stream().filter(o->o.getSurvived() == 1).map(v->v.getAge()).collect(Collectors.toList());
		fareSurvived=Main.datalist.stream().filter(o->o.getSurvived() == 1).map(v->v.getFare()).collect(Collectors.toList());
		ageDemised=Main.datalist.stream().filter(o->o.getSurvived() == 0).map(v->v.getAge()).collect(Collectors.toList());
		fareDemised=Main.datalist.stream().filter(o->o.getSurvived() == 0).map(v->v.getFare()).collect(Collectors.toList());
		SampleChart<Chart<?, ?>> exampleChart =  new TitanicChartBuilder();
		caseValue=Constants.CASE_AGEFARE_SURVIVAL;
	    XYChart chart = (XYChart) exampleChart.getChart();
	    
	    new SwingWrapper<XYChart>(chart).displayChart();
	}

	public void getAgeCount() {
		ageSur.put(Constants.AGE_RANGE_ONE,(long) 0);
		ageSur.put(Constants.AGE_RANGE_TWO,(long) 0);
		ageSur.put(Constants.AGE_RANGE_THREE,(long) 0);
		ageSur.put(Constants.AGE_RANGE_FOUR,(long) 0);
		ageDem.put(Constants.AGE_RANGE_ONE,(long) 0);
		ageDem.put(Constants.AGE_RANGE_TWO,(long) 0);
		ageDem.put(Constants.AGE_RANGE_THREE,(long) 0);
		ageDem.put(Constants.AGE_RANGE_FOUR,(long) 0);
		
		Main.datalist.stream().filter(o->o.getSurvived() == 1).map(v->v.getAge()).collect(Collectors.groupingBy(
	            Function.identity(), Collectors.counting())).forEach((key, value) -> {
	                if (key <= 20) {
	                	ageSur.put(Constants.AGE_RANGE_ONE, ageSur.get(Constants.AGE_RANGE_ONE)+value);
	                } else if(key <= 40) {
	                	ageSur.put(Constants.AGE_RANGE_TWO, ageSur.get(Constants.AGE_RANGE_TWO)+value);
	                }
	                else if(key <= 60) {
	                	ageSur.put(Constants.AGE_RANGE_THREE, ageSur.get(Constants.AGE_RANGE_THREE)+value);
	                }
	                else {
	                	ageSur.put(Constants.AGE_RANGE_FOUR, ageSur.get(Constants.AGE_RANGE_FOUR)+value);
	                }
	            });
		Main.datalist.stream().filter(o->o.getSurvived() == 0).map(v->v.getAge()).collect(Collectors.groupingBy(
	            Function.identity(), Collectors.counting())).forEach((key, value) -> {
	                if (key <= 20) {
	                	ageDem.put(Constants.AGE_RANGE_ONE, ageDem.get(Constants.AGE_RANGE_ONE)+value);
	                } else if(key <= 40) {
	                	ageDem.put(Constants.AGE_RANGE_TWO, ageDem.get(Constants.AGE_RANGE_TWO)+value);
	                }
	                else if(key <= 60) {
	                	ageDem.put(Constants.AGE_RANGE_THREE, ageDem.get(Constants.AGE_RANGE_THREE)+value);
	                }
	                else {
	                	ageDem.put(Constants.AGE_RANGE_FOUR, ageDem.get(Constants.AGE_RANGE_FOUR)+value);
	                }
	            });
		
		SampleChart<Chart<?, ?>> exampleChart = new TitanicChartBuilder();
		caseValue=Constants.CASE_AGE_COUNT;
	    CategoryChart chart = (CategoryChart) exampleChart.getChart();
	    new SwingWrapper<CategoryChart>(chart).displayChart();
		
	

		
	}

	public void getSurvival() {
		survived.put(Constants.SERIES_LABEL_SURVIVED,Main.datalist.stream().filter(o->o.getSurvived() == 1).count());
		survived.put(Constants.SERIES_LABEL_DEMISED,Main.datalist.stream().filter(o->o.getSurvived() == 0).count());
		SampleChart<Chart<?, ?>> exampleChart = new TitanicChartBuilder();
		caseValue=Constants.CASE_SURVIVAL;
	    CategoryChart chart = (CategoryChart) exampleChart.getChart();
	    new SwingWrapper<CategoryChart>(chart).displayChart();
		
		
	}

	public void getPassengerFamilyAboard() {
	
		 passengerAlone=Main.datalist.stream().filter(o->o.getNoOfParentChildren() == 0 && o.getNoOfSiblingSpouses() == 0).count();
		 passengerDAlone=Main.datalist.stream().filter(o->o.getNoOfParentChildren() == 0 && o.getNoOfSiblingSpouses() == 0 && o.getSurvived() == 0 ).count();

		 passengerWFamily=Main.datalist.stream().filter(o->o.getNoOfParentChildren() >0 || o.getNoOfSiblingSpouses() > 0 ).count();
         passengerWDFamily=Main.datalist.stream().filter(o->o.getNoOfParentChildren() + o.getNoOfSiblingSpouses() > 0 && o.getSurvived() == 0 ).count();
		
         SampleChart<Chart<?, ?>> exampleChart = new TitanicChartBuilder();
		caseValue=Constants.CASE_FAMILY;
		PieChart chart = (PieChart) exampleChart.getChart();
	    new SwingWrapper<PieChart>(chart).displayChart();
		
	 
		
		
	}

	public void getPassengerFareDistribution() {
	zeroFare=Main.datalist.stream().filter(o->o.getFare() == 0).count();

	belowFifty=Main.datalist.stream().filter(o->o.getFare() !=0 && o.getFare() <= 50 ).count();


    belowHundred=Main.datalist.stream().filter(o->o.getFare() > 50 && o.getFare() <= 100 ).count();
	
	belowOneFifty=Main.datalist.stream().filter(o->o.getFare() > 100 && o.getFare() <= 150 ).count();
	
	belowTwoHundre=Main.datalist.stream().filter(o->o.getFare() > 150 && o.getFare() <=  200 ).count();
	
	aboveTwoHundred=Main.datalist.stream().filter(o->o.getFare() > 200).count();
	
	SampleChart<Chart<?, ?>> exampleChart = new TitanicChartBuilder();
	caseValue=Constants.CASE_FARE_DISTRIBUTION;
	PieChart chart = (PieChart) exampleChart.getChart();
    new SwingWrapper<PieChart>(chart).displayChart();
	
	
    
	
	}

	public void getFareBasedSurvivalRate() {
	
		zeroFareS=Main.datalist.stream().filter(o->o.getFare() == 0  && o.getSurvived() == 1).count();
	    belowFiftyS=Main.datalist.stream().filter(o->o.getFare() !=0 && o.getFare() <=50  && o.getSurvived() == 1).count();
		belowHundredS=Main.datalist.stream().filter(o->o.getFare() > 50 && o.getFare() <= 100  && o.getSurvived() == 1).count();
		belowOneFiftyS=Main.datalist.stream().filter(o->o.getFare() > 100  && o.getFare() <= 150 && o.getSurvived() == 1).count();
		belowTwoHundredS=Main.datalist.stream().filter(o->o.getFare() > 150  && o.getFare() <= 200 && o.getSurvived() == 1).count();
		abovetwoHundredS=Main.datalist.stream().filter(o->o.getFare() > 200 && o.getSurvived() == 1).count();
		SampleChart<Chart<?, ?>> exampleChart = new TitanicChartBuilder();
		caseValue=Constants.CASE_FARE_SURVIVAL_RATE;
		PieChart chart = (PieChart) exampleChart.getChart();
	    new SwingWrapper<PieChart>(chart).displayChart();
	
	}




	



}

