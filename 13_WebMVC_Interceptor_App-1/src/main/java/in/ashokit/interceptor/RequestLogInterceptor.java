package in.ashokit.interceptor;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class RequestLogInterceptor implements HandlerInterceptor {

	  @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		  System.out.println("prehandle() method called");
		  
		  long startTime = System.currentTimeMillis();
		  request.setAttribute("startTime", startTime);
		 
		  String clientId=request.getParameter("clientId");
		  if("ashokit".equals(clientId)) {
			  return true;
		  }
		  
		  response.getWriter().print("invalid request");
		  return false;
		//return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	  
	  @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
			 
		  System.out.println("post handle() method called");
		  
		  long endTime = System.currentTimeMillis();
		  
		  
		  long startTime =(long) request.getAttribute("startTime");
		  
		  long time=(endTime-startTime);
		  System.out.println("total time taken in (ms) " + time);
		  
		  HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
