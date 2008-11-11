/*
 * Copyright 2008 - Uva Software, LLC
 * 
 * For licensing see LICENSE
 */
package com.uvasoftware.core;

import org.apache.log4j.Logger;

import java.math.BigInteger;

import com.uvasoftware.core.primitives.YesOrNoType;

import java.util.ArrayList;
import java.util.List;

import com.uvasoftware.core.data.student.*;
import com.uvasoftware.core.data.infra.*;
import com.uvasoftware.core.util.*;


/**
 * Represents a <code> SIF_Response </code> message
 * <p>
 * Version 1.5r1 of the SIF Specification describes <code>SIF_Response</code> as follows:
 * <blockquote>
 * <code>SIF_Response</code> is used to respond to a <code>SIF_Request</code> message. A response 
 * consists of one or many data objects, which are either complete or partial. A partial data 
 * object is one that contains a subset of the elements for the data object. 
 * <a href="../../../../overview-summary.html#reference1"><sup>1</sup></a>
 * </blockquote>
 * 
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class SIFResponse extends SIFMessage {
	private static Logger log = Logger.getLogger(SIFResponse.class);
	
	/**
	 * Simple, no arguments ctor
	 */
	public SIFResponse() {
		init();
	}
	
	/**
	 * Creates a new SIFRequest message
	 * 
	 * @param requestMsgID id of the SIF_Request being processed
	 * @param packetNumber what number is this packet in the total response message
	 * @param hasMorePackets are there still outstanding packets for this message
	 */
	public SIFResponse(String requestMsgID, int packetNumber, boolean hasMorePackets) {
		
		init();
		
		com.uvasoftware.core.primitives.SIFResponse resp = this.message.getSIFResponse();
		
		log.debug(String.format("creating new sif reponse with requestMsgID:{%s} packetNumber:{%s} hasMorePacktes:{%s}",requestMsgID,packetNumber,hasMorePackets));

		resp.setSIFHeader((com.uvasoftware.core.primitives.SIFHeader) new SIFHeader().getPrimitive());
		resp.setSIFRequestMsgId(requestMsgID);
		
		// setting packet stuff
		if (packetNumber < 1 ){
			resp.setSIFPacketNumber(BigInteger.ONE);
		}else {
			resp.setSIFPacketNumber( BigInteger.valueOf(packetNumber));
		}
		
		// handling more packets
		if (hasMorePackets) {
			resp.setSIFMorePackets(YesOrNoType.YES);
		}else {
			resp.setSIFMorePackets(YesOrNoType.NO);
		}
 	

		
		// putting it all together
		
		
		
	}
	
	private void init() {
		com.uvasoftware.core.primitives.SIFResponse resp = new com.uvasoftware.core.primitives.SIFResponse();
		// gratis object data in case all we want is to send back an error message
		resp.setSIFObjectData(new com.uvasoftware.core.primitives.SIFObjectData());
		this.message.setSIFResponse(resp);
	}
	/**
	 * Sets the object data for this message - the payload basically
	 * @param data the payload
	 */
	public void addObjectData(ISIFObject value) {
		
		log.debug("adding an object of type:"+value.getClass());
		
		
		com.uvasoftware.core.primitives.SIFObjectData data = this.message.getSIFResponse().getSIFObjectData();

		Class klass = value.getClass();
		
		// the infra objects need a bit of love
		if (klass.getName().contains(SIFObjectName.SIFLogEntry.name())) { data.getSIFLogEntry().add( (com.uvasoftware.core.primitives.SIFLogEntry) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.SIFReportObject.name())) { data.getSIFReportObject().add( (com.uvasoftware.core.primitives.SIFReportObject) value.getPrimitive() ); } 

		if (klass.getName().contains(SIFObjectName.SIFZoneStatus.name())) { data.getSIFZoneStatus().add( (com.uvasoftware.core.primitives.SIFZoneStatus) value.getPrimitive() ); } 
		
		
		// this covers all the 1.5 spec objects
		
		if (klass.getName().contains(SIFObjectName.AccountingPeriod.name())) { data.getAccountingPeriod().add( (com.uvasoftware.core.primitives.AccountingPeriod) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.Activity.name())) { data.getActivity().add( (com.uvasoftware.core.primitives.Activity) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.ActivityProvider.name())) { data.getActivityProvider().add( (com.uvasoftware.core.primitives.ActivityProvider) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.AggregateCharacteristicInfo.name())) { data.getAggregateCharacteristicInfo().add( (com.uvasoftware.core.primitives.AggregateCharacteristicInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.AggregateStatisticFact.name())) { data.getAggregateStatisticFact().add( (com.uvasoftware.core.primitives.AggregateStatisticFact) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.AggregateStatisticInfo.name())) { data.getAggregateStatisticInfo().add( (com.uvasoftware.core.primitives.AggregateStatisticInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.Assessment.name())) { data.getAssessment().add( (com.uvasoftware.core.primitives.Assessment) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.AssessmentItem.name())) { data.getAssessmentItem().add( (com.uvasoftware.core.primitives.AssessmentItem) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.AssessmentSection.name())) { data.getAssessmentSection().add( (com.uvasoftware.core.primitives.AssessmentSection) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.AssessmentSubTest.name())) { data.getAssessmentSubTest().add( (com.uvasoftware.core.primitives.AssessmentSubTest) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.Assignment.name())) { data.getAssignment().add( (com.uvasoftware.core.primitives.Assignment) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.AttendanceCodeInfo.name())) { data.getAttendanceCodeInfo().add( (com.uvasoftware.core.primitives.AttendanceCodeInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.Authentication.name())) { data.getAuthentication().add( (com.uvasoftware.core.primitives.Authentication) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.Billing.name())) { data.getBilling().add( (com.uvasoftware.core.primitives.Billing) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.BusEquipment.name())) { data.getBusEquipment().add( (com.uvasoftware.core.primitives.BusEquipment) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.BusInfo.name())) { data.getBusInfo().add( (com.uvasoftware.core.primitives.BusInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.BusPositionInfo.name())) { data.getBusPositionInfo().add( (com.uvasoftware.core.primitives.BusPositionInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.BusRouteDetail.name())) { data.getBusRouteDetail().add( (com.uvasoftware.core.primitives.BusRouteDetail) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.BusRouteInfo.name())) { data.getBusRouteInfo().add( (com.uvasoftware.core.primitives.BusRouteInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.BusStopInfo.name())) { data.getBusStopInfo().add( (com.uvasoftware.core.primitives.BusStopInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.CurriculumStructure.name())) { data.getCurriculumStructure().add( (com.uvasoftware.core.primitives.CurriculumStructure) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.EmployeeAssignment.name())) { data.getEmployeeAssignment().add( (com.uvasoftware.core.primitives.EmployeeAssignment) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.EmployeeContract.name())) { data.getEmployeeContract().add( (com.uvasoftware.core.primitives.EmployeeContract) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.EmployeeCredential.name())) { data.getEmployeeCredential().add( (com.uvasoftware.core.primitives.EmployeeCredential) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.EmployeeCredit.name())) { data.getEmployeeCredit().add( (com.uvasoftware.core.primitives.EmployeeCredit) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.EmployeeHR.name())) { data.getEmployeeHR().add( (com.uvasoftware.core.primitives.EmployeeHR) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.EmployeePersonal.name())) { data.getEmployeePersonal().add( (com.uvasoftware.core.primitives.EmployeePersonal) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.EmployeePicture.name())) { data.getEmployeePicture().add( (com.uvasoftware.core.primitives.EmployeePicture) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.EmployeeRecertification.name())) { data.getEmployeeRecertification().add( (com.uvasoftware.core.primitives.EmployeeRecertification) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.EmployeeWage.name())) { data.getEmployeeWage().add( (com.uvasoftware.core.primitives.EmployeeWage) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FinancialAccount.name())) { data.getFinancialAccount().add( (com.uvasoftware.core.primitives.FinancialAccount) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FinancialAccountAccountingPeriodLocationInfo.name())) { data.getFinancialAccountAccountingPeriodLocationInfo().add( (com.uvasoftware.core.primitives.FinancialAccountAccountingPeriodLocationInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FinancialClass.name())) { data.getFinancialClass().add( (com.uvasoftware.core.primitives.FinancialClass) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FinancialIncomeStatement.name())) { data.getFinancialIncomeStatement().add( (com.uvasoftware.core.primitives.FinancialIncomeStatement) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FinancialTransaction.name())) { data.getFinancialTransaction().add( (com.uvasoftware.core.primitives.FinancialTransaction) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FinAnnual.name())) { data.getFinAnnual().add( (com.uvasoftware.core.primitives.FinAnnual) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FInBudget.name())) { data.getFinBudget().add( (com.uvasoftware.core.primitives.FinBudget) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FiscalYear.name())) { data.getFiscalYear().add( (com.uvasoftware.core.primitives.FiscalYear) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FoodserviceItem.name())) { data.getFoodserviceItem().add( (com.uvasoftware.core.primitives.FoodserviceItem) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FoodserviceItemPortion.name())) { data.getFoodserviceItemPortion().add( (com.uvasoftware.core.primitives.FoodserviceItemPortion) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FoodserviceItemSales.name())) { data.getFoodserviceItemSales().add( (com.uvasoftware.core.primitives.FoodserviceItemSales) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FoodserviceItemUnit.name())) { data.getFoodserviceItemUnit().add( (com.uvasoftware.core.primitives.FoodserviceItemUnit) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FoodserviceMealPrices.name())) { data.getFoodserviceMealPrices().add( (com.uvasoftware.core.primitives.FoodserviceMealPrices) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FoodserviceReimbursementRates.name())) { data.getFoodserviceReimbursementRates().add( (com.uvasoftware.core.primitives.FoodserviceReimbursementRates) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FoodserviceSales.name())) { data.getFoodserviceSales().add( (com.uvasoftware.core.primitives.FoodserviceSales) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FoodserviceTransaction.name())) { data.getFoodserviceTransaction().add( (com.uvasoftware.core.primitives.FoodserviceTransaction) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FoodserviceTransactionDetails.name())) { data.getFoodserviceTransactionDetails().add( (com.uvasoftware.core.primitives.FoodserviceTransactionDetails) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.FoodserviceTransactionPayMethod.name())) { data.getFoodserviceTransactionPayMethod().add( (com.uvasoftware.core.primitives.FoodserviceTransactionPayMethod) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.LEAInfo.name())) { data.getLEAInfo().add( (com.uvasoftware.core.primitives.LEAInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.LearningResource.name())) { data.getLearningResource().add( (com.uvasoftware.core.primitives.LearningResource) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.LearningStandardDocument.name())) { data.getLearningStandardDocument().add( (com.uvasoftware.core.primitives.LearningStandardDocument) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.LearningStandardItem.name())) { data.getLearningStandardItem().add( (com.uvasoftware.core.primitives.LearningStandardItem) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.Lesson.name())) { data.getLesson().add( (com.uvasoftware.core.primitives.Lesson) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.LibraryPatronStatus.name())) { data.getLibraryPatronStatus().add( (com.uvasoftware.core.primitives.LibraryPatronStatus) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.LocationInfo.name())) { data.getLocationInfo().add( (com.uvasoftware.core.primitives.LocationInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.Payment.name())) { data.getPayment().add( (com.uvasoftware.core.primitives.Payment) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.ProfDevActivities.name())) { data.getProfDevActivities().add( (com.uvasoftware.core.primitives.ProfDevActivities) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.Purchasing.name())) { data.getPurchasing().add( (com.uvasoftware.core.primitives.Purchasing) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.ReportAuthorityInfo.name())) { data.getReportAuthorityInfo().add( (com.uvasoftware.core.primitives.ReportAuthorityInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.ReportManifest.name())) { data.getReportManifest().add( (com.uvasoftware.core.primitives.ReportManifest) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.RoomInfo.name())) { data.getRoomInfo().add( (com.uvasoftware.core.primitives.RoomInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.RoomType.name())) { data.getRoomType().add( (com.uvasoftware.core.primitives.RoomType) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.SchoolCourseInfo.name())) { data.getSchoolCourseInfo().add( (com.uvasoftware.core.primitives.SchoolCourseInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.SchoolInfo.name())) { data.getSchoolInfo().add( (com.uvasoftware.core.primitives.SchoolInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.SectionInfo.name())) { data.getSectionInfo().add( (com.uvasoftware.core.primitives.SectionInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StaffAssignment.name())) { data.getStaffAssignment().add( (com.uvasoftware.core.primitives.StaffAssignment) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StaffMeal.name())) { data.getStaffMeal().add( (com.uvasoftware.core.primitives.StaffMeal) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StaffPersonal.name())) { data.getStaffPersonal().add( (com.uvasoftware.core.primitives.StaffPersonal) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentContact.name())) { data.getStudentContact().add( (com.uvasoftware.core.primitives.StudentContact) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentDailyAttendance.name())) { data.getStudentDailyAttendance().add( (com.uvasoftware.core.primitives.StudentDailyAttendance) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentLocator.name())) { data.getStudentLocator().add( (com.uvasoftware.core.primitives.StudentLocator) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentMeal.name())) { data.getStudentMeal().add( (com.uvasoftware.core.primitives.StudentMeal) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentParticipation.name())) { data.getStudentParticipation().add( (com.uvasoftware.core.primitives.StudentParticipation) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentPersonal.name())) { data.getStudentPersonal().add( (com.uvasoftware.core.primitives.StudentPersonal) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentPicture.name())) { data.getStudentPicture().add( (com.uvasoftware.core.primitives.StudentPicture) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentPlacement.name())) { data.getStudentPlacement().add( (com.uvasoftware.core.primitives.StudentPlacement) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentResultSet.name())) { data.getStudentResultSet().add( (com.uvasoftware.core.primitives.StudentResultSet) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentSchoolEnrollment.name())) { data.getStudentSchoolEnrollment().add( (com.uvasoftware.core.primitives.StudentSchoolEnrollment) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentSectionEnrollment.name())) { data.getStudentSectionEnrollment().add( (com.uvasoftware.core.primitives.StudentSectionEnrollment) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentSnapshot.name())) { data.getStudentSnapshot().add( (com.uvasoftware.core.primitives.StudentSnapshot) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.StudentTransportInfo.name())) { data.getStudentTransportInfo().add( (com.uvasoftware.core.primitives.StudentTransportInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.TermInfo.name())) { data.getTermInfo().add( (com.uvasoftware.core.primitives.TermInfo) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.TimeWorked.name())) { data.getTimeWorked().add( (com.uvasoftware.core.primitives.TimeWorked) value.getPrimitive() ); } 
		if (klass.getName().contains(SIFObjectName.VendorInfo.name())) { data.getVendorInfo().add( (com.uvasoftware.core.primitives.VendorInfo) value.getPrimitive() ); } 

	}
	
	/*
	public List<ISIFObject> getObjectData(SIFObjectName type) {
		ArrayList<ISIFObject> l = new ArrayList<ISIFObject>();
		
		try {
			ReflectionHelper.callMethod( this.message.getSIFResponse().getSIFObjectData(), "get" + type.name());
		}
		
		return(l);
	}
	*/
	
	/**
	 * Gets the payload for this message by object type
	 * @param desiredObject the desired object type to be pulled from this response object
	 * @return a list containing of the object of the desired type contained in this message
	 */
	public List<ISIFObject> getObjectData(SIFObjectName desiredObject) {
		ArrayList<ISIFObject> response = new ArrayList<ISIFObject>();
	
		try {
			if (message.getSIFResponse().getSIFObjectData() == null ) {
				return(response);
			}
			com.uvasoftware.core.primitives.SIFObjectData data = this.message.getSIFResponse().getSIFObjectData();
			
			List lt = (List) ReflectionHelper.callMethod(data, "get" + desiredObject.name());
			Class klass = Class.forName(Config.getInstance().getClassMap(desiredObject));
			int length =  0;
			while (length < lt.size()) {
				ISIFObject i = (ISIFObject) klass.newInstance();
				i.setPrimitive( lt.get(length));
				response.add(i);
				length++;
			}
			
			
		} catch (Exception ex) {
			log.error(ex);
		}
		
		
		return(response);
		
	}
	/**
	 * Gets the payload for this message - note this method is deprecated you should use getDataObject(SIFObjectName desiredObject) instead. 
	 * @deprecated 
	 * @return the message payload
	 */
	public List<ISIFObject> getObjectData() {
		
		ArrayList<ISIFObject> l = new ArrayList<ISIFObject>();
		

		try {
			if (message.getSIFResponse().getSIFObjectData() == null ) {
				return(l);
			}
			
			com.uvasoftware.core.primitives.SIFObjectData data = this.message.getSIFResponse().getSIFObjectData();
			for (com.uvasoftware.core.primitives.SIFZoneStatus a: data.getSIFZoneStatus() ) {
				SIFZoneStatus i = new SIFZoneStatus();
				i.setPrimitive(a);
				l.add( i );
			}	
			
			for (com.uvasoftware.core.primitives.Authentication a: data.getAuthentication() ) {
				Authentication i = new Authentication(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.SIFZoneStatus a: data.getSIFZoneStatus() ) {
				SIFZoneStatus i = new SIFZoneStatus();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.RoomInfo a: data.getRoomInfo() ) {
				RoomInfo i = new RoomInfo();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.RoomType a: data.getRoomType() ) {
				RoomType i = new RoomType();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.SchoolCourseInfo a: data.getSchoolCourseInfo() ) {
				SchoolCourseInfo i = new SchoolCourseInfo();
				i.setPrimitive(a);
				l.add( i );
			}
				
	/*		for (com.uvasoftware.core.primitives.SchoolInfo a: data.getSchoolInfo() ) {
				SchoolInfo i = new SchoolInfo();
				i.setPrimitive(a);
				l.add( i );
			}*/
				
			for (com.uvasoftware.core.primitives.SectionInfo a: data.getSectionInfo() ) {
				SectionInfo i = new SectionInfo();
				i.setPrimitive(a);
				l.add( i );
			}
				
	/*		for (com.uvasoftware.core.primitives.SIF_LogEntry a: data.getSIF_LogEntry() ) {
				SIF_LogEntry i = new SIF_LogEntry();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.SIF_ReportObject a: data.getSIF_ReportObject() ) {
				SIF_ReportObject i = new SIF_ReportObject();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.StaffAssignment a: data.getStaffAssignment() ) {
				StaffAssignment i = new StaffAssignment();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.StaffMeal a: data.getStaffMeal() ) {
				StaffMeal i = new StaffMeal();
				i.setPrimitive(a);
				l.add( i );
			}*/
				
			for (com.uvasoftware.core.primitives.StaffPersonal a: data.getStaffPersonal() ) {
				StaffPersonal i = new StaffPersonal();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.StudentContact a: data.getStudentContact() ) {
				StudentContact i = new StudentContact();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.StudentDailyAttendance a: data.getStudentDailyAttendance() ) {
				StudentDailyAttendance i = new StudentDailyAttendance();
				i.setPrimitive(a);
				l.add( i );
			}
				
	/*		for (com.uvasoftware.core.primitives.StudentLocator a: data.getStudentLocator() ) {
				StudentLocator i = new StudentLocator();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.StudentMeal a: data.getStudentMeal() ) {
				StudentMeal i = new StudentMeal();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.StudentParticipation a: data.getStudentParticipation() ) {
				StudentParticipation i = new StudentParticipation();
				i.setPrimitive(a);
				l.add( i );
			}*/
				
			for (com.uvasoftware.core.primitives.StudentPersonal a: data.getStudentPersonal() ) {
				StudentPersonal i = new StudentPersonal();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.StudentPicture a: data.getStudentPicture() ) {
				StudentPicture i = new StudentPicture();
				i.setPrimitive(a);
				l.add( i );
			}
				
	/*		for (com.uvasoftware.core.primitives.StudentPlacement a: data.getStudentPlacement() ) {
				StudentPlacement i = new StudentPlacement();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.StudentResultSet a: data.getStudentResultSet() ) {
				StudentResultSet i = new StudentResultSet();
				i.setPrimitive(a);
				l.add( i );
			}*/
				
			for (com.uvasoftware.core.primitives.StudentSchoolEnrollment a: data.getStudentSchoolEnrollment() ) {
				StudentSchoolEnrollment i = new StudentSchoolEnrollment();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.StudentSectionEnrollment a: data.getStudentSectionEnrollment() ) {
				StudentSectionEnrollment i = new StudentSectionEnrollment();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.StudentSnapshot a: data.getStudentSnapshot() ) {
				StudentSnapshot i = new StudentSnapshot();
				i.setPrimitive(a);
				l.add( i );
			}
			/*	
			for (com.uvasoftware.core.primitives.StudentTransportInfo a: data.getStudentTransportInfo() ) {
				StudentTransportInfo i = new StudentTransportInfo();
				i.setPrimitive(a);
				l.add( i );
			}
			*/
			for (com.uvasoftware.core.primitives.TermInfo a: data.getTermInfo() ) {
				TermInfo i = new TermInfo();
				i.setPrimitive(a);
				l.add( i );
			}
		/*		
			for (com.uvasoftware.core.primitives.TimeWorked a: data.getTimeWorked() ) {
				TimeWorked i = new TimeWorked();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.VendorInfo a: data.getVendorInfo() ) {
				VendorInfo i = new VendorInfo();
				i.setPrimitive(a);
				l.add( i );
			}
				
			for (com.uvasoftware.core.primitives.W4 a: data.getW4() ) {
				W4 i = new W4();
				i.setPrimitive(a);
				l.add( i );
			}
		*/
		}catch (Exception e) {
			log.error(e);
		}
		
		return(l);
	}
	/**
	 * Turns this response into a error notification
	 * 
	 * @param code The sif error code
	 * @param category The sif error category
	 * @param desc a short description of the problem
	 * @param extDesc an extended description of the problem
	 */
	public void setError(int code, int category, String desc, String extDesc) {
		com.uvasoftware.core.primitives.SIFError error = new com.uvasoftware.core.primitives.SIFError();
		error.setSIFCode(BigInteger.valueOf(code));
		error.setSIFCategory(BigInteger.valueOf(category));
		error.setSIFDesc(desc);
		error.setSIFExtendedDesc(extDesc);
		
		this.message.getSIFResponse().setSIFError(error);
		
	}
	
	/**
	 * Returns true is the response contains an error
	 * @return true if error, false otherwise
	 */
	public boolean hasError() {
		if (message.getSIFResponse().getSIFError() == null) {
			return(false);
		}
		return(true);
	}
	
	/**
	 * returns the error code contained in this message / -1  otherwise
	 * @return
	 */
	public int getErrorCode() {
		if (!this.hasError()) return(-1);
		
		return(message.getSIFResponse().getSIFError().getSIFCode().intValue());
	}
	
	/**
	 * returns the error category contained in this message / -1 otherwise
	 * @return
	 */
	public int getErrorCategory() {
		if (!this.hasError()) return(-1);
		return(message.getSIFResponse().getSIFError().getSIFCategory().intValue());
	}
	
	/**
	 * returns the error description contained in this message / null otherwise;
	 * @return
	 */
	public String getErrorDescription() {
		if (!this.hasError()) return(null);
		return(message.getSIFResponse().getSIFError().getSIFDesc());
	}
	
	/**
	 * returns the extended error description contained in this message / null otherwise
	 * @return
	 */
	public String getErrorExtendedDescription() {
		if (!this.hasError()) return(null);
		return(message.getSIFResponse().getSIFError().getSIFExtendedDesc());
	}
	
	/**
	 * Returns the message id of the request that originated this response
	 * @return the string repr of the ID
	 */
	public String getRequestMsgID(){
		return(message.getSIFResponse().getSIFRequestMsgId());
	}
	
	/**
	 * Returns the number that this packet represents in the entire message
	 * @return the packet number :)
	 */
	public int getPacketNumber() {
		return(message.getSIFResponse().getSIFPacketNumber().intValue());
	}
		
	/**
	 * Is this the last packet of this message or not? 
	 * @return true if this is not the last packet, false otherwise
	 */
	public boolean hasMorePackets() {
			if (message.getSIFResponse().getSIFMorePackets() == com.uvasoftware.core.primitives.YesOrNoType.YES) {
				return(true);
			}
			return(false);
	}
	
}
