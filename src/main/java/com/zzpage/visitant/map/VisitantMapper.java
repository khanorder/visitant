package com.zzpage.visitant.map;

import com.zzpage.visitant.model.Visitant;
import com.zzpage.visitant.model.VisitantLogAction;
import com.zzpage.visitant.model.VisitantLogView;
import com.zzpage.visitant.model.VisitantLogVisit;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.DependsOn;

import java.util.Date;

@DependsOn("visitantMapper")
public interface VisitantMapper {

	public Integer insert(Visitant visitant) throws Exception;
	public Visitant getByHash(Visitant visitant) throws Exception;
	public Integer insertLogAction(VisitantLogAction visitantLogAction) throws Exception;
	public Integer checkUqLogAction(VisitantLogAction visitantLogAction) throws Exception;
	public VisitantLogAction getLogAction(VisitantLogAction visitantLogAction) throws Exception;
	public Integer insertLogVisit(VisitantLogVisit visitantLogVisit) throws Exception;
	public VisitantLogVisit getLogVisitOneday(VisitantLogVisit visitantLogVisit) throws Exception;
	public Integer insertLogView(VisitantLogView visitantLogView) throws Exception;
	public Integer getIsTrackedLogView(@Param("visit_id") Integer visit_id, @Param("url_action_id") Integer url_action_id, @Param("server_time") Date server_time) throws Exception;

}
