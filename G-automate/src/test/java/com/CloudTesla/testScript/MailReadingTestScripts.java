package com.CloudTesla.testScript;

import java.io.IOException;

import java.security.GeneralSecurityException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CloudTesla.Generic.GmailReading;
@Listeners(com.CloudTesla.Generic.IsuitListenerIplementation.class)
public class MailReadingTestScripts{

static	String sub="Device Timed out";
	@Test(priority=1)
public  void rafeek() throws GeneralSecurityException, IOException{
	GmailReading g=new GmailReading();
	long result = g.getMail("rafeek",sub);
	Date mailDate=new Date(result);
	int mailcurrentDate = mailDate.getDate();
	LocalDate sysDate= LocalDate.now();	
	Time time=new Time(result);
	@SuppressWarnings("deprecation")
	int mailHour = time.getHours();
	@SuppressWarnings("deprecation")
	int mailMin=time.getMinutes();
	 LocalTime currentTime = LocalTime.now();
	 System.out.println();
	int SystemHour=currentTime.getHour();
	System.out.println(SystemHour);
    SoftAssert s=new SoftAssert();
    int sysCurentDate = sysDate.getDayOfMonth();
    if(mailcurrentDate==sysCurentDate) {
    s.assertTrue(mailHour==SystemHour&&((mailMin<5&&mailMin>0)||(mailMin>30&&mailMin<35)),"mail not received in current hour");
    s.assertAll();
    //Assert.fail();
    }
    else {
    	Reporter.log("mail not received today", true);
    	Assert.fail();
    }
}
	
//	@Test(priority=2)
//	public  void manjurocky() throws GeneralSecurityException, IOException{	
//		GmailReading g=new GmailReading();
//		long result = g.getMail("manju",sub); 
//		Date mailDate=new Date(result);
//		int mailcurrentDate = mailDate.getDate();
//		LocalDate sysDate= LocalDate.now();	
//		Time time=new Time(result);
//		@SuppressWarnings("deprecation")
//		int mailHour = time.getHours();
//		@SuppressWarnings("deprecation")
//		int mailMin=time.getMinutes();
//		 LocalTime currentTime = LocalTime.now();
//		 System.out.println();
//		int SystemHour=currentTime.getHour();
//		System.out.println(SystemHour);
//	    SoftAssert s=new SoftAssert();
//	    int sysCurentDate = sysDate.getDayOfMonth();
//	    if(mailcurrentDate==sysCurentDate) {
//	    s.assertTrue(mailHour==SystemHour&&((mailMin<5&&mailMin>0)||(mailMin>30&&mailMin<35)),"mail not received in current hour");
//	    s.assertAll();
//	    
//	    }
//	    else {
//	    	Reporter.log("mail not received today", true);
//	    	Assert.fail();
//	    }
//	}
//	@Test(priority=3)
//	public  void ningum40() throws GeneralSecurityException, IOException{	
//		GmailReading g=new GmailReading();
//		long result = g.getMail("ningu",sub); 
//		Date mailDate=new Date(result);
//		int mailcurrentDate = mailDate.getDate();
//		LocalDate sysDate= LocalDate.now();	
//		Time time=new Time(result);
//		@SuppressWarnings("deprecation")
//		int mailHour = time.getHours();
//		@SuppressWarnings("deprecation")
//		int mailMin=time.getMinutes();
//		 LocalTime currentTime = LocalTime.now();
//		 System.out.println();
//		int SystemHour=currentTime.getHour();
//		System.out.println(SystemHour);
//	    SoftAssert s=new SoftAssert();
//	    int sysCurentDate = sysDate.getDayOfMonth();
//	    if(mailcurrentDate==sysCurentDate) {
//	    s.assertTrue(mailHour==SystemHour&&((mailMin<5&&mailMin>0)||(mailMin>30&&mailMin<35)),"mail not received in current hour");
//	    s.assertAll();
//	    //Assert.fail();
//	    }
//	    else {
//	    	Reporter.log("mail not received today", true);
//	    	Assert.fail();
//	    }
//	}
//	@Test(priority=4)
//	public  void pundunayak576() throws GeneralSecurityException, IOException{
//		GmailReading g=new GmailReading();
//	
//		long result = g.getMail("pundu",sub); 
//		Date mailDate=new Date(result);
//		int mailcurrentDate = mailDate.getDate();
//		LocalDate sysDate= LocalDate.now();	
//		Time time=new Time(result);
//		@SuppressWarnings("deprecation")
//		int mailHour = time.getHours();
//		@SuppressWarnings("deprecation")
//		int mailMin=time.getMinutes();
//		 LocalTime currentTime = LocalTime.now();
//		 System.out.println();
//		int SystemHour=currentTime.getHour();
//		System.out.println(SystemHour);
//	    SoftAssert s=new SoftAssert();
//	    int sysCurentDate = sysDate.getDayOfMonth();
//	    if(mailcurrentDate==sysCurentDate) {
//	    s.assertTrue(mailHour==SystemHour&&((mailMin<5&&mailMin>0)||(mailMin>30&&mailMin<35)),"mail not received in current hour");
//	    s.assertAll();
//	    //Assert.fail();
//	    }
//	    else {
//	    	Reporter.log("mail not received today", true);
//	    	Assert.fail();
//	    }
//	}
//	@Test(priority=5)
//	public  void wimate99() throws GeneralSecurityException, IOException{	
//		GmailReading g=new GmailReading();
//		long result = g.getMail("wimate",sub); 
//		Date mailDate=new Date(result);
//		int mailcurrentDate = mailDate.getDate();
//		LocalDate sysDate= LocalDate.now();	
//		Time time=new Time(result);
//		@SuppressWarnings("deprecation")
//		int mailHour = time.getHours();
//		@SuppressWarnings("deprecation")
//		int mailMin=time.getMinutes();
//		 LocalTime currentTime = LocalTime.now();
//		 System.out.println();
//		int SystemHour=currentTime.getHour();
//		System.out.println(SystemHour);
//	    SoftAssert s=new SoftAssert();
//	    int sysCurentDate = sysDate.getDayOfMonth();
//	    if(mailcurrentDate==sysCurentDate) {
//	    s.assertTrue(mailHour==SystemHour&&((mailMin<5&&mailMin>0)||(mailMin>30&&mailMin<35)),"mail not received in current hour");
//	    s.assertAll();
//	    
//	    }
//	    else {
//	    	Reporter.log("mail not received today", true);
//	    	Assert.fail();
//	    }
//	}
//	@Test(priority=6)
//	public  void Wimatetest01() throws GeneralSecurityException, IOException{
//		GmailReading g=new GmailReading();
//			
//		long result = g.getMail("wimate1",sub); 
//		Date mailDate=new Date(result);
//		int mailcurrentDate = mailDate.getDate();
//		LocalDate sysDate= LocalDate.now();	
//		Time time=new Time(result);
//		@SuppressWarnings("deprecation")
//		int mailHour = time.getHours();
//		@SuppressWarnings("deprecation")
//		int mailMin=time.getMinutes();
//		 LocalTime currentTime = LocalTime.now();
//		 System.out.println();
//		int SystemHour=currentTime.getHour();
//		System.out.println(SystemHour);
//	    SoftAssert s=new SoftAssert();
//	    int sysCurentDate = sysDate.getDayOfMonth();
//	    if(mailcurrentDate==sysCurentDate) {
//	    s.assertTrue(mailHour==SystemHour&&((mailMin<5&&mailMin>0)||(mailMin>30&&mailMin<35)),"mail not received in current hour");
//	    s.assertAll();
//	    //Assert.fail();
//	    }
//	    else {
//	    	Reporter.log("mail not received today", true);
//	    	Assert.fail();
//	    }
//	}
//	@Test(priority=7)
//	public  void Wimatetest02() throws GeneralSecurityException, IOException{
//		GmailReading g=new GmailReading();
//		long result = g.getMail("wimate2",sub);
//		Date mailDate=new Date(result);
//		int mailcurrentDate = mailDate.getDate();
//		LocalDate sysDate= LocalDate.now();	
//		Time time=new Time(result);
//		@SuppressWarnings("deprecation")
//		int mailHour = time.getHours();
//		@SuppressWarnings("deprecation")
//		int mailMin=time.getMinutes();
//		 LocalTime currentTime = LocalTime.now();
//		 System.out.println();
//		int SystemHour=currentTime.getHour();
//		System.out.println(SystemHour);
//	    SoftAssert s=new SoftAssert();
//	    int sysCurentDate = sysDate.getDayOfMonth();
//	    if(mailcurrentDate==sysCurentDate) {
//	    s.assertTrue(mailHour==SystemHour&&((mailMin<5&&mailMin>0)||(mailMin>30&&mailMin<35)),"mail not received in current hour");
//	    s.assertAll();
//	    }
//	    else {
//	    	Reporter.log("mail not received today", true);
//	    	Assert.fail();
//	    }
//	}
//	@Test(priority=8)
//	public  void Wimatetest03() throws GeneralSecurityException, IOException{
//		GmailReading g=new GmailReading();
//		
//		long result = g.getMail("wimate3",sub); 
//		Date mailDate=new Date(result);
//		int mailcurrentDate = mailDate.getDate();
//		LocalDate sysDate= LocalDate.now();	
//		Time time=new Time(result);
//		@SuppressWarnings("deprecation")
//		int mailHour = time.getHours();
//		@SuppressWarnings("deprecation")
//		int mailMin=time.getMinutes();
//		 LocalTime currentTime = LocalTime.now();
//		 System.out.println();
//		int SystemHour=currentTime.getHour();
//		System.out.println(SystemHour);
//	    SoftAssert s=new SoftAssert();
//	    int sysCurentDate = sysDate.getDayOfMonth();
//	    if(mailcurrentDate==sysCurentDate) {
//	    s.assertTrue(mailHour==SystemHour&&((mailMin<5&&mailMin>0)||(mailMin>30&&mailMin<35)),"mail not received in current hour");
//	    s.assertAll();
//	    //Assert.fail();
//	    }
//	    else {
//	    	Reporter.log("mail not received today", true);
//	    	Assert.fail();
//	    }
//	}
}
