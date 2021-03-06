package com.capgemini.hotelmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.bean.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminOperationsServiceTest {
	@Autowired
	private AdminOperationService adminOperationService;

//		@Test
//		// Valid test addHotel()
//		public void testAddHotel() {
//			HotelInformationBean hotelInformationBean = new HotelInformationBean();
//			hotelInformationBean.setAddress("Mumbai");
//			hotelInformationBean.setContactNumber("9087654321");
//			hotelInformationBean.setHotelName("Abcd Efgh");
//			hotelInformationBean.setImgUrl("qwerty.image.url");
//			hotelInformationBean.setLicenseNumber("H00000000");
//			hotelInformationBean.setHotelId(3);
//			
//			TestCase.assertNotNull(adminOperationService.addHotel(hotelInformationBean));
//			
//		}//End of testAddHotel()

	@Test
	// Invalid addHotel()
	public void testInvalidAddHotel() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		hotelInformationBean.setHotelAddress("Mumbai");
		hotelInformationBean.setHotelContactNumber("9087654321");
		hotelInformationBean.setHotelName("Abcd Efgh");
		hotelInformationBean.setHotelImageURL("qwerty.image.url");
		hotelInformationBean.setLicenceNumber("");

		TestCase.assertNull(adminOperationService.addHotel(hotelInformationBean));
	}

	@Test
	// Valid testgetHotelList()
	public void testGetHotelList() {
		TestCase.assertNotNull(adminOperationService.getHotelList());
	}

//	@Test
//	// Valid test deleteHotelInformation()
//	public void testDeleteHotelInformation() {
//		boolean actual = adminOperationService.deleteHotelInformation(3);
//		assertEquals(true, actual);
//	}// End of testDeleteRoomInformation()

	@Test
	// invalid test deleteHotelInformation()
	public void testInvalidDeleteHotelInformation() {
		boolean actual = adminOperationService.deleteHotelInformation(3);
		assertEquals(false, actual);
	}// End of testDeleteRoomInformation()

	@Test
	// Valid test licenseNumberPresent()
	public void testlicenseNumberPresent() {
		boolean actual = adminOperationService.licenseNumberPresent("H00000001");
		assertEquals(true, actual);
	}

	@Test
	// Valid test licenseNumberPresent()
	public void testInvalidLicenseNumberPresent() {
		boolean actual = adminOperationService.licenseNumberPresent("H00000000");
		assertEquals(false, actual);
	}

	/* Room operations test cases */

//	@Test // Valid addRoom()
//	public void testAddRoom() {
//		RoomInformationBean roomInformationBean = new RoomInformationBean();
//		roomInformationBean.setHotelLicense("H00000001");
//		roomInformationBean.setHotelName("Qwerty Hotel");
//		roomInformationBean.setHotelId(1);
//		roomInformationBean.setRoomAmount(123);
//		roomInformationBean.setRoomCount(25);
//		roomInformationBean.setRoomImageUrl("asdf");
//		roomInformationBean.setRoomStatus("Avaliable");
//		roomInformationBean.setRoomType("AC");
//		roomInformationBean.setRoomCapacity("Single Bed");
//
//		TestCase.assertNotNull(adminOperationService.addRoom(roomInformationBean));
//
//	}// End of testAddRoom()

	@Test(expected = HotelManagementSystemException.class)
	// invalid addRoom()
	public void testInvalidAddRoom() {
		RoomInformationBean roomInformationBean = new RoomInformationBean();
		roomInformationBean.setHotelId(1);
		roomInformationBean.setHotelName("Qwerty Hotel");
		// roomInformationBean.setHotelId(1);
		// roomInformationBean.setRoomAmount(123);
		roomInformationBean.setRoomCount(25);
		roomInformationBean.setRoomImageURL("asdf");
		roomInformationBean.setRoomType("AC");
		roomInformationBean.setRoomCapacity("Single Bed");

		TestCase.assertNull(adminOperationService.addRoom(roomInformationBean));
	}

	@Test
	public void testGetRoomList() {
		TestCase.assertNotNull(adminOperationService.getRoomList());
	}

//	@Test // valid updateRoom()
//	public void testUpdateRoom() {
//		RoomInformationBean roomInformationBean = new RoomInformationBean();
//		roomInformationBean.setHotelLicense("H00000001");
//		roomInformationBean.setHotelName("Qwerty Hotel");
//		roomInformationBean.setHotelId(1);
//		roomInformationBean.setRoomAmount(225);
//		roomInformationBean.setRoomCount(25);
//		roomInformationBean.setRoomImageUrl("asdf");
//		roomInformationBean.setRoomStatus("Avaliable");
//		roomInformationBean.setRoomType("AC");
//		roomInformationBean.setRoomCapacity("Single Bed");
//
//		TestCase.assertNotNull(adminOperationService.addRoom(roomInformationBean));
//
//	}// End of testAddRoom()

	@Test
	// Invalid updateHotelRoom()
	public void testInvalidUpdateHotelRoom() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		hotelInformationBean.setHotelId(3);
		hotelInformationBean.setHotelAddress("Mumbai");
		hotelInformationBean.setHotelContactNumber("8907654321");
		hotelInformationBean.setHotelName("Qwerty Hotel");
		hotelInformationBean.setHotelImageURL("qwy.image.url");
		hotelInformationBean.setLicenceNumber("H000");

		boolean actual = adminOperationService.updateHotelInformation(hotelInformationBean);
		assertEquals(false, actual);

	}// End of testUpdateHotelRoom()

	/* Employee operations */

//	@Test
//	public void testAddEmployee() {
//		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
//		employeeInformationBean.setAddress("Delhi");
//		employeeInformationBean.setContactNumber("9087654321");
//		employeeInformationBean.setEmail("abcd@gmail.com");
//		employeeInformationBean.setHotelId(1);
//		employeeInformationBean.setHotelLicense("H00000001");
//		employeeInformationBean.setHotelName("Qwerty Hotel");
//		employeeInformationBean.setName("Abcd Efgh");
//		employeeInformationBean.setNationality("Indian");
//		employeeInformationBean.setPassword("Qwerty123");
//		employeeInformationBean.setEmployeeId(3);
//
//		TestCase.assertNotNull(adminOperationService.addEmployee(employeeInformationBean));
//	}// End of testAddEmployee()

	// Invalid test addEmployee()
//	@Test
//	public void testInvalidAddEmployee() {
//		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
//		employeeInformationBean.setAddress("Delhi");
//		employeeInformationBean.setContactNumber("9987648115");
//		employeeInformationBean.setEmail("employee1@gmail.com");
//		employeeInformationBean.setHotelId(1);
//		employeeInformationBean.setHotelLicense("H00000001");
//		employeeInformationBean.setHotelName("Qwerty Hotel");
//		employeeInformationBean.setName("Abcd Efgh");
//		employeeInformationBean.setNationality("Indian");
//		employeeInformationBean.setPassword("Qwerty123");
//		employeeInformationBean.setEmployeeId(3);
//
//		TestCase.assertNull(adminOperationService.addEmployee(employeeInformationBean));
//
//	}

//	@Test
//	public void testDeleteEmployee() {
//		boolean actual = adminOperationService.deleteEmployeeInformation(3);
//		assertEquals(true, actual);
//
//	}// End of testDeleteEmployee()
//
//	// Invalid test deleteEmployee()
//	@Test
//	public void testInvalidDeleteEmployee() {
//		boolean actual = adminOperationService.deleteEmployeeInformation(3);
//		assertEquals(false, actual);
//
//	}

//	@Test //valid test updateEmployeeInformation()
//	public void testUpdateEmployeeInformation() {
//		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
//		employeeInformationBean.setAddress("Mumbai");
//		employeeInformationBean.setContactNumber("9987648115");
//		employeeInformationBean.setEmail("abcd@gmail.com");
//		employeeInformationBean.setHotelId(1);
//		employeeInformationBean.setHotelLicense("H00000001");
//		employeeInformationBean.setHotelName("Qwerty Hotel");
//		employeeInformationBean.setName("Abcd Efgh");
//		employeeInformationBean.setNationality("Indian");
//		employeeInformationBean.setPassword("Qwerty123");
//		employeeInformationBean.setEmployeeId(3);
//
//		boolean actual = adminOperationService.updateEmployeeInformation(employeeInformationBean);
//		assertEquals(true, actual);
//
//	}// End of testUpdateEmployeeInformation()

	// Invalid test updateEmployeeInformation
//	@Test
//	public void testInvalidUpdateEmployeeInformation() {
//
//		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
//		//employeeInformationBean.setEmployeeId(3);
//		employeeInformationBean.setAddress("Mumbai1");
//		employeeInformationBean.setContactNumber("9087654321");
//		employeeInformationBean.setHotelId(2);
//		employeeInformationBean.setHotelLicense("123");
//		//employeeInformationBean.setHotelName("Indus");
//		employeeInformationBean.setNationality("Indian");
//		employeeInformationBean.setPassword("Qwerty123");
//		
//		boolean actual = adminOperationService.updateEmployeeInformation(employeeInformationBean);
//		assertEquals(false, actual);
//
//	}

	// Valid test getEmployeeList()
	@Test
	public void testGetEmployeeList() {
		TestCase.assertNotNull(adminOperationService.getEmployeeList());
	}

}
