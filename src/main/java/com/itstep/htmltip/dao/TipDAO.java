package com.itstep.htmltip.dao;

import java.util.List;

import com.itstep.htmltip.model.Tip;

public interface TipDAO {
	public int createTip(Tip tip);
	public List<Tip> getAll(); 
	public Tip getOneById(int id);
	public int delete(int id);
}
