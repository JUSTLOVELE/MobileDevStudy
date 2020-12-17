package com.spring.ch_04.study_02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

	@Bean
	public CompactDisc sgtPeppers(){
		BlankDisc cd = new BlankDisc();
		cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band ");
		cd.setArtist("The Beatles");
		List<String> tracks = new ArrayList<String>();
		tracks.add(" Sgt. Pepper's Lonely Hearts Club Band ");
		tracks.add("The Beatles");
		tracks.add("双节棍");
		tracks.add("不可思议的秘密");
		cd.setTracks(tracks);
		return cd;
	}
	
	@Bean
	public TrackCounter trackCounter(){
		return new TrackCounter();
	}
}
