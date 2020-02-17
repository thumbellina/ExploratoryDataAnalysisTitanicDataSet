package fr.epita.titanic.dao;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import fr.epita.titanic.launcher.Constants;
import fr.epita.titanic.model.PassengerDetails;

public class PassengerDao {

	public List<PassengerDetails> readAll() throws Exception {
		List<PassengerDetails> readList=new ArrayList<PassengerDetails>();
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(new File("data/input.csv")));
			String newLine;
			newLine = br.readLine();
			//System.out.println(newLine);
			while ((newLine = br.readLine()) != null) {
				String[] data=newLine.split(",");
				//System.out.println(newLine);
				PassengerDetails currObj= new PassengerDetails();
				currObj.setSurvived(Integer.valueOf(data[0].trim()));
				currObj.setpClass(Integer.valueOf(data[1].trim()));
				currObj.setName(data[2].trim());
				String gender=data[3].trim();
				currObj.setGender(gender);
				if (gender.equals(Constants.GENDER[0])){
					
					currObj.setGenderIdx(0);
					
				}
				else {
					currObj.setGenderIdx(1);
					
				}
				currObj.setAge(Double.valueOf(data[4].trim()));
				currObj.setNoOfSiblingSpouses(Integer.valueOf(data[5].trim()));
				currObj.setNoOfParentChildren(Integer.valueOf(data[6].trim()));
				currObj.setFare(Double.valueOf(data[7].trim()));
				
				readList.add(currObj);
		       
		    }
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		throw new Exception("Exception while reading file" +e);
		}
		// TODO Auto-generated method stub
		return readList;
	}

}
