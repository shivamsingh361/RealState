package com.cg.Presentation;

import java.util.Scanner;

import org.omg.CORBA.DynAnyPackage.Invalid;

import com.cg.DTO.User;
import com.cg.DTO.UserType;
import com.cg.Service.Service;
import com.cg.Service.ServiceImpl;

public class Main {

	public static void main(String[] args) {
		Service obj = new ServiceImpl();
		do{
			boolean home = false;
			boolean exit = false;
			Scanner sc = new Scanner(System.in);
			Integer option = 1;
			try {
				System.out.println("Choose:\n1. Login"
						+ "\n2. Register"
						+ "\n3. About Us"
						+ "\n4. Feedback"
						+ "\n5. Exit");
				option = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Please input INTEGER only.");
			}
			switch(option){
			case 1:
				System.out.println("\n**Login Here**");
				Integer optionLogin = 1;
				try {
					System.out.println("Choose Again:\n1. Enter LogIn Details"
							+ "\n2. Forgot Pass"
							+ "\n3. Back"
							+ "\n4. Home");
					optionLogin = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Please input INTEGER only.");
				}
				switch(optionLogin){
				case 1:
					while(!home && !exit){
					System.out.println("\nEnter Registered Email/Phone: ");
					String id = sc.next();
					System.out.println("\nEnter Registered Password: ");//Ashishverma001@xyz.com
					String pass = sc.next();
					System.out.println(id+pass);
					if(obj.login(id, pass)) {
						while(!home && !exit) {
							System.out.println("\n\t\t\tThis is User's Home\n");
							obj.userHome().stream().limit(5).forEach(System.out::print);	// display only 5  property on first page						
							System.out.println("\n\n1.Apply Filters and Search Properties"
									+ "\n2.Update Profile"
									+ "\n3.Update Password"
									+ "\n4.Logout");
							switch (sc.next()) {
							case "1":
								//Apply filters of show all properties and show here; 
								obj.Search(null);
								break;
							case "2":
								//Update Name, Phone_no here and call update profile method.
								obj.updateUserProfile("", "");
								break;
							case "3":
								//input old pass, new pass and new pass again and pass it by mehtod:
								obj.updatePassword("","");
								break;
							case "4":
								System.out.println("Log-ing Out! ---------------------------------------------------");
								obj.logout();
								home=true;
								break;
							default:
								break;
							}
							
						}
					}
						System.out.println("Try Again?(Press y)\n Else(press 'n')");
						if(!sc.next().equalsIgnoreCase("y"))
							break;
						else
							home=false;
					};
					break;
				case 2:
					System.out.println("\nEnter Registered Email/Phone: ");
					String id1 = sc.next();
					Integer otpentered, otp =  obj.verifyOTP(id1);
					System.out.println("\nEnter OTP Sent, again: "+otp);
					otpentered = Integer.parseInt(sc.next());
					if(otp.equals(otpentered)){
						System.out.println("\nEnter Password: ");
						String pass1 = sc.next();
						System.out.println("\nEnter Password Again: ");
						String pass2 = sc.next();
						if(pass1.equals(pass2))
							System.out.println(obj.forgotPassword(id1, pass1));
						else
							System.out.println("\nPassword not Match");								
					}else{
						System.out.println("\nInvalid OTP");
					}
					break;
				case 3:
					//Back to main menu.
					break;
				case 4:
					//Back to main menu/ Home.
					break;
				default:
					System.out.println("\n**Default Block(in Login Option)**\n\t\t<<Invalid Input>>\n\n");
				}
				break;
/* ******************************** Case 1 ends here ******************************************** */
			case 2:
				
				System.out.println("\n**Register Here**");
				System.out.println("Name:\t");
				String name = sc.next();
				System.out.println("Email:\t");
				String email = sc.next();
				System.out.println("Name:");
				String pass1 = sc.next();
				System.out.println("Name:");
				String pass2 = sc.next();
				System.out.println("Contact:");
				String phoneNo = sc.next();
				if(pass1==pass2)
				obj.Register(new User(UserType.BUYER, email, pass1, name, phoneNo, null));	//pass all parameters.
				break;
/* ******************************** Case 2 ends here ******************************************** */
			case 3:
				System.out.println("\n**AboutUs**");
				break;
/* ******************************** Case 3 ends here ******************************************** */
			case 4:
				System.out.println("\n**Feedback**");
				break;
/* ******************************** Case 4 ends here ******************************************** */
			case 5:
				sc.close();
				System.out.println("Exit-ing");
				System.exit(1);
/* ******************************** Case 5 ends here ******************************************** */
			default:
				System.out.println("\n**Default Block**\n\t\t<<++Invalid Input++>>\n\n");
			}
		}while(true);

	}

}
