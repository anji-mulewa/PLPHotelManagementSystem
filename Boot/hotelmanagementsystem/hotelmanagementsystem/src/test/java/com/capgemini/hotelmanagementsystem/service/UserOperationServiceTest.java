package com.capgemini.hotelmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.BookingInformationBean;
import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;

import junit.framework.TestCase;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserOperationServiceTest {
	@Autowired
	private UserOperationServiceImpl userOperationService;
	
	@Test
	// valid roomList()
	public void testRoomList() {
		HotelInformationBean hotelInformation = new HotelInformationBean();
		hotelInformation.setLicenceNumber("H00000001");
		TestCase.assertNotNull(userOperationService.roomList(hotelInformation));
	}

	
		@Test
		// Invalid test roomList()
		public void testInvalidRoomList() {
			HotelInformationBean hotelInformation = new HotelInformationBean();
			hotelInformation.setLicenceNumber("H00");
			List<RoomInformationBean> roomList = userOperationService.roomList(hotelInformation);
			assertEquals(true, roomList.isEmpty());	
		}
		
		@Test
		//Valid test getBookingHistroy()
		public void testGetBookingHistory() {
			List<BookingInformationBean> bookingHistroy = userOperationService.getBookingHistory("user@gmail.com");
			assertEquals(false, bookingHistroy.isEmpty());
		}

		@Test
		//invalid test getBookingHistroy()
		public void testInvalidGetBookingHistory() {
			List<BookingInformationBean> bookingHistroy = userOperationService.getBookingHistory("user12@gmail.com");
			assertEquals(true, bookingHistroy.isEmpty());
		}

}
