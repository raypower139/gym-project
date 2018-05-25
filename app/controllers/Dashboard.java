package controllers;

import models.Member;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Assessment> assessmentlist = member.assessmentlist;
    render("dashboard.html", member, assessmentlist);
  }

  public static void addAssessment(float weight, float chest, float thigh, float upperarm, float waist, float hips )
  {
    Member member = Accounts.getLoggedInMember();
    Assessment assessment = new Assessment(weight, chest, thigh, upperarm, waist, hips);
    member.assessmentlist.add(assessment);
    member.save();
    Logger.info("Adding Assessment");
    redirect("/dashboard");
  }

  public static void deleteAssessment(Long id, Long assessmentid)
  {
    Member member = Member.findById(id);
    Assessment assessment = Assessment.findById(assessmentid);
    member.assessmentlist.remove(assessment);
    member.save();
    assessment.delete();
    Logger.info("Deleting ");
    redirect("/dashboard");
  }
}
