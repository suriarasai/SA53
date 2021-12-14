package sg.edu.nus.cats.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.cats.exception.CourseNotFound;
import sg.edu.nus.cats.helper.CourseEventEnum;
import sg.edu.nus.cats.model.Course;
import sg.edu.nus.cats.model.CourseEvent;
import sg.edu.nus.cats.services.CourseEventService;
import sg.edu.nus.cats.services.CourseService;
import sg.edu.nus.cats.validators.CourseValidator;

@Controller
@RequestMapping(value = "/staff")
public class StaffController {
	@Autowired
	private CourseService cService;

	@Autowired
	private CourseValidator cValidator;

	@Autowired
	private CourseEventService ceService;

	@InitBinder("course")
	private void initCourseBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.addValidators(cValidator);

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";

	}

	/**
	 * COURSE CRUD OPERATIONS
	 * 
	 * @return
	 */

	@RequestMapping(value = "/history")
	public String employeeCourseHistory(HttpSession session, Model model) {
		UserSession usession = (UserSession) session.getAttribute("usession");
		//ModelAndView mav = new ModelAndView("login");
		if (usession.getUser() != null) {
			//mav = new ModelAndView("staff-course-history");
			System.out.println(usession.getEmployee());
			if (cService.findCoursesByEID(usession.getEmployee().getEmployeeId()).size() > 0) {
				model.addAttribute("chistory", cService.findCoursesByEID(usession.getEmployee().getEmployeeId()));
			}
			return "staff-course-history";
		}
		return "forward:/home/login";

	}

	@RequestMapping(value = "/course/create", method = RequestMethod.GET)
	public ModelAndView newCoursePage() {
		ModelAndView mav = new ModelAndView("staff-course-new");
		mav.addObject("course", new Course());
		return mav;
	}

	@RequestMapping(value = "/course/create", method = RequestMethod.POST)
	public ModelAndView createNewCourse(@ModelAttribute @Valid Course course, BindingResult result,
			HttpSession session) {
		UserSession usession = (UserSession) session.getAttribute("usession");
		if (result.hasErrors())
			return new ModelAndView("staff-course-new");
		ModelAndView mav = new ModelAndView();
		String message = "New course " + course.getCourseId() + " was successfully created.";
		System.out.println(message);
		course.setEmployeeId(usession.getEmployee().getEmployeeId());
		course.setStatus(CourseEventEnum.SUBMITTED);
		mav.setViewName("forward:/staff/history");
		CourseEvent ce = new CourseEvent();
		ce.setCourse(course);
		ce.setEventBy(usession.getEmployee().getEmployeeId());
		ce.setEventType(CourseEventEnum.SUBMITTED);
		ce.setTimeStamp(Calendar.getInstance().getTime());
		cService.createCourse(course);
		return mav;
	}
	@Transactional
	@RequestMapping(value = "/course/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCoursePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("staff-course-edit");
		Course course = cService.findCourse(id);
		mav.addObject("course", course);
		return mav;
	}

	@RequestMapping(value = "/course/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editCourse(@ModelAttribute @Valid Course course, BindingResult result, @PathVariable Integer id,
			HttpSession session) throws CourseNotFound {
		UserSession usession = (UserSession) session.getAttribute("usession");
		if (result.hasErrors())
			return new ModelAndView("staff-course-edit");
		ModelAndView mav = new ModelAndView();
		System.out.println("DATES****" + course.getFromDate() + course.getToDate());
		String message = "New course " + course.getCourseId() + " was successfully created.";
		System.out.println(message);
		course.setEmployeeId(usession.getEmployee().getEmployeeId());
		course.setStatus(CourseEventEnum.UPDATED);
		mav.setViewName("forward:/staff/history");
		CourseEvent ce = new CourseEvent();
		ce.setCourse(course);
		ce.setEventBy(usession.getEmployee().getEmployeeId());
		ce.setEventType(CourseEventEnum.UPDATED);
		ce.setTimeStamp(Calendar.getInstance().getTime());
		course.addCourseEvent(ce);
		cService.changeCourse(course);
		return mav;
	}

	@RequestMapping(value = "/course/withdraw/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCourse(@PathVariable Integer id, HttpSession session) throws CourseNotFound {
		UserSession usession = (UserSession) session.getAttribute("usession");
		ModelAndView mav = new ModelAndView("forward:/staff/history");
		Course course = cService.findCourse(id);
		String message = "Course " + course.getCourseId() + " was successfully withdrawn.";
		System.out.println(message);
		course.setStatus(CourseEventEnum.WITHDRAWN);
		CourseEvent ce = new CourseEvent();
		ce.setCourse(course);
		ce.setEventBy(usession.getEmployee().getEmployeeId());
		ce.setEventType(CourseEventEnum.WITHDRAWN);
		ce.setTimeStamp(Calendar.getInstance().getTime());
		cService.changeCourse(course);
		ceService.createCourseEvent(ce);
		return mav;
	}

}
