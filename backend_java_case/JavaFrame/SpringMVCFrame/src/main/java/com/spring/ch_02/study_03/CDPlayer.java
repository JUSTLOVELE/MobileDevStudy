package com.spring.ch_02.study_03;

import com.spring.ch_02.study_02.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class CDPlayer implements MediaPlayer{
	
	private CompactDisc cd;
	
	/**
	 * Ҳ�Զ�װ���ڷ���,�������û�еĻ����ǻ����쳣,������������required����Ϊfalse
	 * @param cd
	 */
	@Autowired
	public CDPlayer(CompactDisc cd){
		this.cd = cd;
	}

	public void play() {
		cd.play();
	}
}
