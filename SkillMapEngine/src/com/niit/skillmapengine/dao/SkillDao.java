package com.niit.skillmapengine.dao;

import com.niit.skillmapengine.model.Skills;

public interface SkillDao
{
	boolean saveSkill(Skills skill);
	boolean deleteSkill(Skills skill);
	boolean updateSkill(Skills skill);

}
