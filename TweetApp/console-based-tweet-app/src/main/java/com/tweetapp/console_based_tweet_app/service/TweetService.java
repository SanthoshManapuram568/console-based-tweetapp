package com.tweetapp.console_based_tweet_app.service;

import java.sql.ResultSet;


import com.tweetapp.console_based_tweet_app.dao.TweetDao;
import com.tweetapp.console_based_tweet_app.entity.Tweet;


public class TweetService {
	
	TweetDao tweetDao = new TweetDao();
	
	public boolean createTweet(Tweet tweet) {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		tweet.setCreated(date);
		tweetDao.createTweet(tweet);
		return true;
	}
	
	public boolean getAllTweets(){
		
		ResultSet resultSet = tweetDao.getAllTweets();
		try {
			if(resultSet.next()) {
				System.out.println(resultSet.getDate("created")+" "+resultSet.getString("tweet"));
			}else {
				System.out.println("No tweets found..");
			}
			while(resultSet.next()) {
				System.out.println(resultSet.getDate("created")+" "+resultSet.getString("tweet"));
			}
		}catch(Exception e) {
			System.out.println("Something went wrong. \n Please try again ");
		}
		return true;
	}
	
	public boolean getTweetsByUserId(int userId){
		
		ResultSet resultSet = tweetDao.getTweetsByUserId(userId);
		try {
			if(resultSet.next()) {
				System.out.println(resultSet.getDate("created")+" "+resultSet.getString("tweet"));
			}else {
				System.out.println("No tweets found..");
			}
			while(resultSet.next()) {
				System.out.println(resultSet.getDate("created")+" "+resultSet.getString("tweet"));
			}
		}catch(Exception e) {
			System.out.println("Something went wrong. Please try again ");
		}
		return true;
	}
}
