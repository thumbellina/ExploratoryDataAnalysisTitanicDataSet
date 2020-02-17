package fr.epita.titanic.launcher;

import fr.epita.titanic.dao.PassengerDao;
import fr.epita.titanic.dao.TitanicChartBuilder;
import fr.epita.titanic.model.PassengerDetails;

import java.util.ArrayList;

import java.util.List;


public class Main {
	
public static List<PassengerDetails> datalist= new ArrayList<>();

public static void main(String[] args) throws Exception {
	
	PassengerDao pc=new PassengerDao();
	try {
		//Reading from data Set
		datalist=pc.readAll();
		TitanicChartBuilder tc= new TitanicChartBuilder();

		//returns a chart representing survival count and demised count of passengers
		tc.getSurvival();
		//returns a chart representing fare distribution passengers
		tc.getPassengerFareDistribution();
		//returns a chart representing survival count and demised count base on gender
		tc.getgenderBasedSurvival();
		//returns a chart representing survival count and demised count base on passenger class
		tc.getclassBasedSurvival();
		//returns a chart representing age vs fare scatter plot with passenger class details
		tc.getAgevsFarePclassBased();
		//returns a chart representing age vs fare scatter plot with survival details
		tc.getAgevsFareSurvivalBased();
		//returns a chart representing survival count and demised count based on age range
		tc.getAgeCount();
		//returns a chart representing survival rate of different fare range
		tc.getFareBasedSurvivalRate();
		//returns a chart representing survival % and demised %  base on family aboard
		tc.getPassengerFamilyAboard();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new Exception("Exception in main "+e);
	}
	
	
}




}
