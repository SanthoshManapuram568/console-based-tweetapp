package com.tweetapp.console_based_tweet_app;

import java.util.Map;
import java.util.Scanner;

import com.tweetapp.console_based_tweet_app.controller.RegisterController;

public class App 
{
	public static boolean loggedInStatus = false;
	public static int userId;
	static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args )
    {	
    	RegisterController userFuctions = new RegisterController();
    	
    	if(!loggedInStatus) {
	        System.out.println( "1.Register\n2.Login\n3.Forgot password");
	        System.out.println("Enter your choice : ");
	        int option = scanner.nextInt();
	        switch(option) {
	        case 1 : userFuctions.registerUser();
        			 main(args);
        			 break;
	        case 2 : Map<String,Integer> res = userFuctions.login();
	        		 if(res.get("status")==1) {
	        			loggedInStatus = true;
	        			userId = res.get("userId");
	        		 }else {
	        			 System.out.println("Invalid email or password");
	        		 }
	        		 main(args);
	        		 break;
	        		 
	        case 3 : userFuctions.forgotPassword();
	        		 main(args);
	        		 break;
	        default : System.out.println("Invalid Option. Please try again..");
	        		  main(args);
	        	
	        }
    	}else {
    		System.out.println( "*************************************************\n1.Post a tweet\n2.View my tweets\n3.View all tweets\n4.View All Users\n5.Reset Password\n6.Logout");
	        System.out.println("Enter your choice : ");
	        int option = scanner.nextInt();
	        switch(option) {
	        case 1 : userFuctions.createTweet(userId);
        			 main(args);
        			 break;
	        case 2 : userFuctions.getMyTweets(userId);
	        		 main(args);
	        		 break;
	        case 3 : userFuctions.getAllTweets();
	        		 main(args);
	        		 break;
	        case 4 : userFuctions.getAllUsers();
	        		 main(args);
	        		 break;
	        case 5 : userFuctions.updateUser(userId);
	        		 main(args);
	        		 break;
	        case 6 : if(userFuctions.logout(userId)) {
	        			loggedInStatus = false;
	        		 };
	        		 main(args);
	        		 break;
	        default : System.out.println("Invalid Option. Please try again..");
	        		  main(args);
	        	
	        }
    	}
    }
}
